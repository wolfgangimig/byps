/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BProtocolS : BProtocol
    {
	    public BProtocolS(BApiDescriptor apiDesc, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder)
            : base(apiDesc, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder)
        {
	    }

	    public BProtocolS(BApiDescriptor apiDesc) 
            : base(apiDesc)
        {
	    }

	    public override BOutput getOutput(BTransport transport) 
        {
            if (negotiatedByteOrder == ByteOrder.UNDEFINED) throw new BException(BExceptionC.INTERNAL, "Protocol object can only be used for input.");
            return new BOutputS(transport, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder);
	    }

        public override BOutput getResponse(BTransport transport, BMessageHeader requestHeader)
        {
            if (negotiatedByteOrder == ByteOrder.UNDEFINED) throw new BException(BExceptionC.INTERNAL, "Protocol object can only be used for input.");
		    return new BOutputS(transport, requestHeader);
	    }

        public override BInput getInput(BTransport transport, BMessageHeader responseHeader, ByteBuffer buf)
        {
		    return new BInputS(transport, responseHeader, buf);
	    }

        public override BRegistry getRegistry()
        {
            return apiDesc.getRegistry(BBinaryModel.MEDIUM);
        }
    }
}
