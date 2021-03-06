package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.util.Map;

public class BInputS extends BInputBin {

	public BInputS(BTransport transport, BMessageHeader header, ByteBuffer buf) {
		super(header, buf, transport, transport.getApiDesc().getRegistry(BProtocolS.BINARY_MODEL));
	}

	@Override
	public Object readObj(boolean isUnique, BSerializer ser) throws BException {
		Object obj = null;
		
		if (ser != null && ser.inlineInstance) {
			currentId = null;
			obj = ser.read(null, this, header.version);
			return obj;
		}

		Map<Integer, Object> idMap = isUnique ? null : this.idMap;
		
		int id = bbuf.getPointer();
		if (id > 0) {
			
			// Read type and size from stream
			int typeId = bbuf.getTypeId();
			if (typeId < 0) throw new BException(BExceptionC.CORRUPT, "Invalid type ID at stream position " + bbuf.position());
			
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
			if (idMap == null) throw new BException(BExceptionC.INTERNAL, "Reference map must not be null.");
			obj = idMap.get(-id);
			if (obj == null) throw new BException(BExceptionC.INTERNAL, "Null values must not be mapped.");
		}
		else {
			// NULL reference
		}
		
		return obj;

	}
	
	
}
