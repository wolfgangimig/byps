using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public class BInputS : BInputBin
    {
        public BInputS(BTransport transport, BMessageHeader responseHeader, ByteBuffer buf)
            : base(transport, responseHeader, buf, transport.apiDesc.getRegistry(BBinaryModel.MEDIUM))
        {
        }

	    protected override Object loadObj(BSerializer ser) {
		    long strmVersion = header.version;
		    if (strmVersion <= 0) throw new BException(BExceptionC.CORRUPT, "Invalid stream version " + strmVersion);
		    return readObj(false, ser);
	    }

	    public override Object readObj(bool isUnique, BSerializer ser) {
		    Object obj = null;
		
		    if (ser != null && ser.inlineInstance) {
                currentId = 0;
			    obj = ser.read(null, this, header.version);
			    return obj;
		    }

		    Dictionary<int, Object> idMap = isUnique ? null : this.idMap;
		
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
			
		    }
		    else if (id < 0) {
			    if (idMap == null) throw new BException(BExceptionC.INTERNAL, "Reference map must not be null.");
			    if (!idMap.TryGetValue(-id, out obj)) throw new BException(BExceptionC.INTERNAL, "Null values must not be mapped.");
		    }
		    else {
			    // NULL reference
		    }
		
		    return obj;

	    }

    }
}
