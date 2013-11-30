/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BServerR
    {
 	    public readonly BTransport transport;
	    public readonly BServer server;

	    public BServerR(BTransport transport, BServer server) {
		    this.transport = transport;
		    this.server = new MyServer(this, server);
	    }

	    public virtual void start() {
	    }

	    public virtual void done() {
	    }
	
	    /**
	     * Die Hilfsklasse brauche ich, um BServer.putOutgoingStreams umzuleiten.
	     *
	     */
	    protected class MyServer : BServer {

            BServerR outerServer;
		    BServer innerServer;

            public MyServer(BServerR outerServer, BServer innerServer) 
			    : base (innerServer.transport, null) 
            {
                this.outerServer = outerServer;
			    this.innerServer = innerServer;
		    }

            public override BProtocol negotiate(BTargetId targetId, ByteBuffer bin, BAsyncResultIF<ByteBuffer> asyncResult)
            {
			    // negotiate muss bereits vom zugehörigen BClient ausgeführt worden sein.
			    // Die ausgehandelten Eigenschaften werden von BClient übernommen - sie sind in BTransport enthalten.
			    return transport.getProtocol();
		    }

            public override void recv(BTargetId clientTargetId, Object methodObj, BAsyncResultIF<Object> methodResult)
            {
			    innerServer.recv(clientTargetId, methodObj, methodResult);
		    }
		
            public override void addRemote(int remoteId, BSkeleton remoteImpl)
            {
                innerServer.addRemote(remoteId, remoteImpl);
            }
				
	    }
	
    }
}
