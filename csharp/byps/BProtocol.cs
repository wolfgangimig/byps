using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BProtocol
    {
        public readonly BApiDescriptor apiDesc;

        public readonly long negotiatedVersion;

        public readonly ByteOrder negotiatedByteOrder;
	
	    public BProtocol(BApiDescriptor apiDesc, long negotiatedVersion, ByteOrder negotiatedByteOrder) {
		    this.apiDesc = apiDesc;
		    this.negotiatedVersion = negotiatedVersion;
		    this.negotiatedByteOrder = negotiatedByteOrder;
	    }
	
	    public BProtocol(BApiDescriptor apiDesc) {
		    this.apiDesc = apiDesc;
		    this.negotiatedVersion = 0;
            this.negotiatedByteOrder = ByteOrder.UNDEFINED;
	    }
	
	    public abstract BOutput getOutput(BTransport transport) ;

	    public abstract BOutput getResponse(BTransport transport, BMessageHeader requestHeader) ;

        public abstract BInput getInput(BTransport transport, BMessageHeader responseHeader, ByteBuffer buf);

        public abstract BRegistry getRegistry();
    }
}
