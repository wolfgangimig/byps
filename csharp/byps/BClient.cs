using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BClient
    {
	    public readonly BTransport transport;
	    protected readonly BServerR serverR;
	
	    public BClient(BTransport transport, BServerR serverR) {
		    this.transport = transport;
		    this.serverR = serverR;
	    }
	
	    public abstract BRemote getStub(int remoteId);
	
	    public void done() {
            if (serverR != null)
            {
                serverR.done();
            }
            transport.wire.done();
	    }
	
        private class MyNegoAsyncResult : BAsyncResult<bool> 
        {
            public MyNegoAsyncResult(BClient client, BAsyncResult<BClient> innerResult)
            {
                this.client = client;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(bool ignored, Exception ex)
            {
                try
                {
                    if (ex != null)
                    {
                        innerResult.setAsyncResult(null, ex);
                    }
                    else
                    {
                        if (client.serverR != null)
                        {
                            client.serverR.start();
                        }
                        innerResult.setAsyncResult(client, null);
                    }
                }
                catch (Exception e)
                {
                    innerResult.setAsyncResult(null, e);
                }
            }

            private readonly BAsyncResult<BClient> innerResult;
            private readonly BClient client;
        }

	    public void start(BAsyncResult<BClient> asyncResult) {

            BAsyncResult<Boolean> outerResult = new MyNegoAsyncResult(this, asyncResult);
		
		    transport.negotiateProtocolClient(outerResult);
	    }

    }
}
