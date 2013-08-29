package com.wilutions.byps;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BInputJson extends BInput {

	public BInputJson(BMessageHeader header, ByteBuffer buf, BTransport transport) {
		super(header, transport, transport.apiDesc.getRegistry(BProtocolJson.BINARY_MODEL));
		this.bbuf = new BBufferJson(buf);
	}

	@Override
	public Object load() throws BException {
		if (log.isDebugEnabled()) log.debug("load(");
		Object root = null;
		
		if (log.isDebugEnabled()) log.debug("header=" + header);
		if (header.messageId == 0) {
			header.read(bbuf.buf);
		}
		
		Object jsonMessageObj = header.messageObject;
		if (jsonMessageObj == null) throw new BException(BExceptionO.CORRUPT, "Missing message data.");
		if (!(jsonMessageObj instanceof BJsonObject)) throw new BException(BExceptionO.CORRUPT, "Message data must be a JSON object.");
		BJsonObject jsonMessage = (BJsonObject)jsonMessageObj;
		
		Object headerObj = jsonMessage.get("header");
		if (log.isDebugEnabled()) log.debug("headerObj=" + headerObj);
		if (headerObj == null) throw new BException(BExceptionO.CORRUPT, "Missing message header.");
		if (!(headerObj instanceof BJsonObject)) throw new BException(BExceptionO.CORRUPT, "Message header must be a JSON object.");
		
		Object objectTableObj = jsonMessage.get("objectTable");
		if (log.isDebugEnabled()) log.debug("objectTableObj=" + objectTableObj);
		if (objectTableObj != null) {
			if (!(objectTableObj instanceof BJsonObject)) throw new BException(BExceptionO.CORRUPT, "Object table must be a JSON object.");
			objectTable = (BJsonObject)objectTableObj;
			
			Object objNull = objectTable.get(0);
			if (objNull != null) throw new BException(BExceptionO.CORRUPT, "First object table element must be null.");
			
			root = deserializeObject(null, 1, null, 0);
			if (log.isDebugEnabled()) log.debug("root=" + root);
		
			if (header.error != 0) {
				Throwable ex = (Throwable)root;
				if (ex instanceof BException) throw (BException)ex;
				throw new BException(header.error, ex.toString(), ex);
			}
		}
				
		if (log.isDebugEnabled()) log.debug(")load");
		return root;
	}

	public Object readObj(String name, boolean isUnique, BSerializer ser) throws BException {
		Object obj = null;
		
		if (ser != null && ser.inlineInstance) {
			obj = deserializeObject(ser, null, name, 0);
		}
		else {
			Integer id = deserializeReference(name, 0);
			if (id != null) {
				obj = this.idMap.get(id);
				if (obj == null) {
					obj = deserializeObject(ser, id, null, 0);
				}
			}
		}
		return obj;

	}

	public Object readObj(int idx, boolean isUnique, BSerializer ser) throws BException {
		Object obj = null;
		
		if (ser != null && ser.inlineInstance) {
			obj = deserializeObject(ser, null, null, idx);
		}
		else {
			Integer id = deserializeReference(null, idx);
			if (id != null) {
				obj = this.idMap.get(id);
				if (obj == null) {
					obj = deserializeObject(ser, id, null, idx);
				}
			}
		}
		return obj;

	}

	protected Integer deserializeReference(String name, int idx) throws BException {
		Object jsonObj = null;
		if (name != null) {
			jsonObj = currentObject.get(name);
		}
		else if (idx >= 0) {
			jsonObj = currentObject.get(idx);
		}
		
		if (jsonObj == null) return null;
		
		if (!(jsonObj instanceof BJsonObject)) {
			String msg = "Expecting JSON Object at ";
			if (name != null) msg += "name=" + name;
			else if (idx > 0) msg += "idx=" + idx;
			msg += " but found \"" + jsonObj + "\". ";
			msg += " If custom serializers are used, make sure that BSerializer.write() functions call BOutput.beginObject/endObject.";
			
			throw new BException(BExceptionO.CORRUPT, msg);
		}
		
		int id = ((BJsonObject)jsonObj).getInt("*i");
		if (id >= 0) {
			String msg = "Excpecting reference with \"*i\" < 0 but found " + id;
			throw new BException(BExceptionO.CORRUPT, msg);
		}
		return -id;
	}
	
	protected Object deserializeCurrentObject(BSerializer ser, Integer id)
			throws BException {
		Object obj;
		// If the serializer is not supplied, lookup
		// the serializer from the registry
		if (ser == null) {
			
			// Only BSerializable-Objects - not Arrays - can be serialized without
			// specifying a BSerializer. 

			int typeId = currentObject.getInt("_typeId");
			if (typeId <= 0) throw new BException(BExceptionO.CORRUPT, "Invalid _typeId=" + typeId + " for objectTable[" + id + "]");
			
			ser = registry.getSerializer(typeId);
		}
		
		// Create and read Java object by information in this.currentObj
		currentId = id;
		obj = ser.read(null, this, header.version);
			// idMap.put(currentId, obj); has to be done in BSerializer.read() by calling onObjectCreated
		
		return obj;
	}
	
	protected Object deserializeObject(BSerializer ser, Integer id, String name, int idx) throws BException {
		Object jsonObj = null;
		if (id != null) {
			jsonObj = objectTable.get(id);
		}
		else if (name != null) {
			jsonObj = currentObject.get(name);
		}
		else if (idx >= 0) {
			jsonObj = currentObject.get(idx);
		}
		
		if (jsonObj == null) return null;
		
		if (!(jsonObj instanceof BJsonObject)) {
			String msg = "Expecting JSON Object at ";
			if (id != null) msg += "id=" + id;
			else if (name != null) msg += "name=" + name;
			else if (idx > 0) msg += "idx=" + idx;
			msg += " but found \"" + jsonObj + "\". ";
			msg += " If custom serializers are used, make sure that BSerializer.write() functions call BOutput.beginObject/endObject.";
			
			throw new BException(BExceptionO.CORRUPT, msg);
		}
		
		return deserializeObject(ser, (BJsonObject)jsonObj, id);
	}
	
	public Object deserializeObject(BSerializer ser, BJsonObject jsonObj, Integer id) throws BException {
		Object obj = null;
		BJsonObject prevObject = currentObject;
		currentObject = jsonObj;
		obj = deserializeCurrentObject(ser, id);
		currentObject = prevObject;
		return obj;
	}
	
	@Override
	public boolean getBoolean(String name) {
		return currentObject.getBoolean(name);
	}

	@Override
	public short getShort(String name) {
		return currentObject.getShort(name);
	}

	@Override
	public int getInt(String name) {
		return currentObject.getInt(name);
	}

	@Override
	public long getLong(String name) {
		return currentObject.getLong(name);
	}

	@Override
	public float getFloat(String name) {
		return currentObject.getFloat(name);
	}

	@Override
	public double getDouble(String name) {
		return currentObject.getDouble(name);
	}

	@Override
	public String getString(String name) {
		return currentObject.getString(name);
	}
	
	protected BJsonObject objectTable;
	public BJsonObject currentObject;
	public final BBufferJson bbuf;
	private final Log log = LogFactory.getLog(BInputJson.class);
}

