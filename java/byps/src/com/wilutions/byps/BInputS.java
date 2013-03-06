package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.util.HashMap;


public class BInputS extends BInputBin {

	public BInputS(BMessageHeader header, ByteBuffer buf, BTransport transport) {
		super(header, buf, transport, transport.apiDesc.getRegistry());
	}

	@Override
	protected Object loadObj(BSerializer ser) throws BException {
		int strmVersion = header.version;
		if (strmVersion <= 0) throw new BException(BException.CORRUPT, "Invalid stream version " + strmVersion);
		return readObj(false, ser);
	}

	@Override
	public Object readObj(boolean isUnique, BSerializer ser) throws BException {
		Object obj = null;
		
		if (ser != null && ser.inlineInstance) {
			currentId = null;
			obj = ser.read(null, this, header.version);
			return obj;
		}

		HashMap<Integer, Object> idMap = isUnique ? null : this.idMap;
		
		int id = bbuf.getPointer();
		if (id > 0) {
			
			// Read type and size from stream
			int typeId = bbuf.getTypeId();
			if (typeId < 0) throw new BException(BException.CORRUPT, "Invalid type ID at stream position " + bbuf.position());
			
			// If the serializer is not supplied, lookup
			// the serializer from the registry
			if (ser == null) {
				ser = registry.getSerializer(typeId);
			}
			
			// Create and read
			currentId = id;
			obj = ser.read(null, this, header.version);
			// if (idMap != null) idMap.put(id, obj); has to be done in BSerializer.read()
			
		}
		else if (id < 0) {
			if (idMap == null) throw new BException(BException.INTERNAL, "Reference map must not be null.");
			obj = idMap.get(-id);
			if (obj == null) throw new BException(BException.INTERNAL, "Null values must not be mapped.");
		}
		else {
			// NULL reference
		}
		
		return obj;

	}
	
	
}
