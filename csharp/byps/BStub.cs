/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BStub : BRemote {

	    public readonly BTransport transport;
	
	    public BStub(BTransport transport) {
		    this.transport = transport;
	    }
	
	    public BTargetId BRemote_getTargetId() {
		    return transport.getTargetId();
	    }

    }
}
