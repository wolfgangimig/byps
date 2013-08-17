using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public class BProtocolS : BProtocol
    {
	    public BProtocolS(BApiDescriptor apiDesc, int negotiatedVersion, ByteOrder negotiatedByteOrder) 
		    : base(apiDesc, negotiatedVersion, negotiatedByteOrder)
        {
	    }

	    public BProtocolS(BApiDescriptor apiDesc) 
            : base(apiDesc)
        {
	    }

	    public override BOutput getOutput(BTransport transport) 
        {
            if (negotiatedByteOrder == ByteOrder.UNDEFINED) throw new BException(BException.INTERNAL, "Protocol object can only be used for input.");
		    return new BOutputS(transport, negotiatedVersion, negotiatedByteOrder);
	    }

        public override BOutput getResponse(BTransport transport, BMessageHeader requestHeader)
        {
            if (negotiatedByteOrder == ByteOrder.UNDEFINED) throw new BException(BException.INTERNAL, "Protocol object can only be used for input.");
		    return new BOutputS(transport, requestHeader);
	    }

        public override BInput getInput(ByteBuffer buf, BTransport transport)
        {
		    return new BInputS(buf, transport);
	    }

    }
}
