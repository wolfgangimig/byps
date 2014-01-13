/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BServer
    {
	    public readonly BTransport transport;
	    public readonly BClient clientR;
	
	    protected readonly Dictionary<int, BRemote> remotes;
	
	    public BServer(BTransport transport, BClient clientR) {
		    this.transport = transport;
		    this.clientR = clientR;
		    this.remotes = new Dictionary<int, BRemote>();
	    }
	
	    public BServer(BServer rhs) {
		    this.transport = rhs.transport;
		    this.clientR = rhs.clientR;
		    this.remotes = rhs.remotes;
	    }
	
	    public virtual void addRemote(int remoteId, BSkeleton remoteImpl) {
		    if (remoteImpl != null) {
			    remotes[remoteId] = remoteImpl;
			    remoteImpl.BSkeleton_setTargetId(transport.getTargetId());
		    }
	    }

        public virtual BProtocol negotiate(BTargetId targetId, ByteBuffer bin, BAsyncResultIF<ByteBuffer> asyncResult)
        {
		    BProtocol protocol = transport.negotiateProtocolServer(targetId, bin, asyncResult);
		    return protocol;
	    }

        public virtual void recv(BTargetId clientTargetId, Object methodObj, BAsyncResultIF<Object> methodResult)
        {
		
		    try {
                BMethodRequest method = (BMethodRequest)methodObj;

                BRemote remote = null;
			    int remoteId = method.getRemoteId();
			    BTargetId serverTargetId = this.transport.getTargetId();
			
			    // Die Target-ID aus dem Header ist gleich der Target-ID des BServer-Objekts
			    // für einen normalen Client-Server-Request
			    if (clientTargetId.Equals(serverTargetId)) {
				    remotes.TryGetValue(remoteId, out remote);
			    }
			    else {
				
				    // Es wird eine andere Target-ID angesteuert.
				    // Ermittle hier die BRemote-Schnittstelle dieser Target-ID.
				    // Sie kommt möglicherweise von einem anderen Client.
				
				    remote = this.transport.getRemoteRegistry().getRemote(serverTargetId, clientTargetId, remoteId);
			    }
			
                if (remote != null)
                {
                    method.execute(remote, methodResult);
                }
                else
                {
                    BException ex = new BException(BExceptionC.SERVICE_NOT_IMPLEMENTED,
                        "Service not implemented: remoteId=" + remoteId);
                    methodResult.setAsyncResult(null, ex);
			    }
		    }
		    catch (Exception e) {
                methodResult.setAsyncResult(null, e);
		    }
		
	    }

    }
}
