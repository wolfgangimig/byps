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

            setAuthentication(null);
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
            public MyNegoAsyncResult(BClient client, BAsyncResult<bool> innerResult)
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
                        innerResult.setAsyncResult(false, ex);
                    }
                    else
                    {
                        if (client.serverR != null)
                        {
                            client.serverR.start();
                        }
                        innerResult.setAsyncResult(true, null);
                    }
                }
                catch (Exception e)
                {
                    innerResult.setAsyncResult(false, e);
                }
            }

            private readonly BAsyncResult<bool> innerResult;
            private readonly BClient client;
        }

	    public void start(BAsyncResult<bool> asyncResult) {

            BAsyncResult<bool> outerResult = new MyNegoAsyncResult(this, asyncResult);
		
		    transport.negotiateProtocolClient(outerResult);
	    }


        private class ClientAuthentication : BAuthentication
        {
            public BAuthentication innerAuth;

            public ClientAuthentication(BAuthentication innerAuth)
            {
                this.innerAuth = innerAuth;
            }
            
            public void authenticate(BClient client, BAsyncResult<bool> asyncResult) 
            {
                BAsyncResult<bool> outerResult = new MyNegoAsyncResult(client, asyncResult);
      
                if (innerAuth != null) 
                {
                    innerAuth.authenticate(client, outerResult);
                }
                else 
                {
                    outerResult.setAsyncResult(true, null);
                }
            }

            public bool isReloginException(BClient client, Exception ex, int typeId) 
            {
              bool ret = false;
              if (innerAuth != null)
              {
                  ret = innerAuth.isReloginException(client, ex, typeId);
              }
              else
              {
                  ret = client.transport.isReloginException(ex, typeId);
              }
              return ret;
            }

            public Object getSession()
            {
                Object ret = null;
                if (innerAuth != null)
                {
                    ret = innerAuth.getSession();
                }
                return ret;
            }

        }

        public void setAuthentication(BAuthentication auth)
        {
            transport.authentication = new ClientAuthentication(auth);
        }

        public BAuthentication getAuthentication()
        {
            return transport.authentication;
        }

    }
}
