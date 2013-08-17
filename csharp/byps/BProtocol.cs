using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BProtocol
    {
 	    protected readonly BApiDescriptor apiDesc;
	
	    protected readonly int negotiatedVersion;
	
	    protected readonly ByteOrder negotiatedByteOrder;
	
	    public BProtocol(BApiDescriptor apiDesc, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
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

	    public abstract BInput getInput(ByteBuffer buf, BTransport transport) ;
    }
}
