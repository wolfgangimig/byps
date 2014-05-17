package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

import byps.BException;


public class BOutputJson extends BOutput {
	
	public BOutputJson(BTransport transport) {
		super(transport, 
		    transport.getApiDesc().getRegistry(BProtocolJson.BINARY_MODEL), 
		    BMessageHeader.MAGIC_JSON, 
		    BMessageHeader.BYPS_VERSION_CURRENT, 
		    0, 
		    ByteOrder.BIG_ENDIAN);
		this.objMap = new BObjMap();
		ByteBuffer buf = ByteBuffer.allocate(10 * 1000);
		this.bbuf = new BBufferJson(buf);
	}
	
	public BOutputJson(BTransport transport, BMessageHeader requestHeader) {
		super(transport, transport.getApiDesc().getRegistry(BProtocolJson.BINARY_MODEL), requestHeader);
		this.objMap = new BObjMap();
		ByteBuffer buf = ByteBuffer.allocate(10 * 1000);
		this.bbuf = new BBufferJson(buf);
	}
	
	@Override
	public ByteBuffer toByteBuffer() {
		if (bbuf.position() != 0) {
			bbuf.flip();
		}
		return bbuf.getBuffer();
	}
	
	@Override
	protected void internalStore(Object root) throws BException {
		final BBufferJson bbuf = (BBufferJson)this.bbuf;
		bbuf.clear();
		if (objMap != null) objMap.clear();
		nextObjId = 0;
		
		// {"header":[....],"objectTable":[null, {rootobj}, {...}]}
		bbuf.beginObject();
		
		bbuf.beginElement("header");
		header.writeJson(bbuf);
		bbuf.endElement();
		
		objMap.put(root, ++nextObjId);
		
		bbuf.beginElement("objectTable");
		bbuf.beginArray();
		bbuf.putNull();
		
		objStack.add(root);
		serStack.add(null);
		
		while (objStack.size() != 0) {
			Object obj = objStack.remove(0);
			BSerializer ser = serStack.remove(0);
			if (obj != null) {
				if (ser == null) {
					ser = registry.getSerializer(obj, true);
				}
				ser.write(obj, this, header.version);
			}
			else {
				bbuf.putString(null);
			}
		}
		
		bbuf.endElement();
		bbuf.endArray();
		bbuf.endObject();
	}
	
	public void writeObj(String name, Object obj, boolean isUnique, BSerializer ser) throws BException {
		
		final BBufferJson bbuf = (BBufferJson)this.bbuf;
		
		if (ser != null && ser.inlineInstance) {

			if (name != null) {
				bbuf.beginElement(name);
			}
			
			if (obj == null) {
				obj = ser.read(null, null, 0);
			}
			
			ser.write(obj, this, header.version);
			
			if (name != null) {
				bbuf.endElement();
			}
			
			return;
		}

		if (obj != null) {

			if (name != null) {
				
				bbuf.beginElement(name);
				
			}
			else {
				
				// Es ist ein Array Element
			}
			
			Integer id_o = objMap.get(obj); 
			if (id_o != null) {
				bbuf.putRef(id_o); // write { "*i":-123 }
			}
			else {
				id_o = ++nextObjId;
				bbuf.putRef(id_o); // write { "*i":-123 }

				objMap.put(obj, id_o);
				
				objStack.add(obj);
				serStack.add(ser);
			}
			
			if (name != null) {
				bbuf.endElement();
			}
		}
		else {
			// null values have to be written 
			// for array elements.
			if (name == null) {
				bbuf.putNull();
			}
		}
		
	}
	
	public void beginObject() {
		bbuf.beginObject();
	}
	public void endObject() {
		bbuf.endObject();
	}
	public void putBoolean(String name, boolean value) {
		bbuf.putBoolean(name, value);
	}
	public void putShort(String name, short value) {
		bbuf.putShort(name, value);
	}
	public void putInt(String name, int value) {
		bbuf.putInt(name, value);
	}
	public void putLong(String name, long value){
		bbuf.putLong(name, value);
	}
	public void putFloat(String name, float value) {
		bbuf.putFloat(name, value);
	}
	public void putDouble(String name, double value) {
		bbuf.putDouble(name, value);
	}
	public void putString(String name, String value) {
		bbuf.putString(name, value);
	}

	protected int nextObjId;
	protected final ArrayList<Object> objStack = new ArrayList<Object>();
	protected final ArrayList<BSerializer> serStack = new ArrayList<BSerializer>();
	public final BBufferJson bbuf;
}
