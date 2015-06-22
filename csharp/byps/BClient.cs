/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BClient
    {
	    protected BTransport transportVal;
	    protected BServerR serverR;
	
	    public BClient(BTransport transport, BServerR serverR) {
            this.transportVal = transport;
		    this.serverR = serverR;
            this.setAuthentication(null);
	    }
	
	    public abstract BRemote getStub(int remoteId);

        public virtual BTransport getTransport()
        {
            return transportVal;
        }
	
	    public void done() {
            if (serverR != null)
            {
                serverR.done();
            }
            getTransport().getWire().done();
	    }
	
        private class MyAsyncResultStartServer : BAsyncResultIF<bool> 
        {
            public MyAsyncResultStartServer(BClient client, BAsyncResult<bool> innerResult)
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
                        innerResult(false, ex);
                    }
                    else
                    {
                        BServerR serverR = client.serverR;
                        if (serverR != null)
                        {
                            BTargetId targetId = client.getTransport().getTargetId();
                            String sessionId = client.getTransport().getSessionId();
                            serverR.transport.setTargetId(targetId);
                            serverR.transport.setSessionId(sessionId);

                            serverR.start();
                        }
                        innerResult(true, null);
                    }
                }
                catch (Exception e)
                {
                    innerResult(false, e);
                }
            }

            private readonly BAsyncResult<bool> innerResult;
            private readonly BClient client;
        }

        public void start(BAsyncResult<bool> asyncResult, bool startR)
        {
            BAsyncResultIF<bool> outerResult = BAsyncResultHelper.FromDelegate<bool>(asyncResult);
            if (startR)
            {
                outerResult = new MyAsyncResultStartServer(this, asyncResult);
            }
            getTransport().negotiateProtocolClient(outerResult);
        }

        public void start(BAsyncResult<bool> asyncResult)
        {
            start(asyncResult, true);
        }

        public void startR(BAsyncResult<bool> asyncResult)
        {
            BAsyncResultIF<bool> outerResult = new MyAsyncResultStartServer(this, asyncResult);
            outerResult.setAsyncResult(true, null);
        }


        private class ClientAuthentication : BAuthentication
        {
            private BClient client;
            internal BAuthentication innerAuth;

            public ClientAuthentication(BClient client, BAuthentication innerAuth)
            {
                this.client = client;
                this.innerAuth = innerAuth;
            }

            public void authenticate(BClient ignored, BAsyncResult<bool> asyncResult) 
            {
                if (log.isDebugEnabled()) log.debug("authenticate(");
      
                if (innerAuth != null) 
                {
                    if (log.isDebugEnabled()) log.debug("innerAuth.authenticate");
                    innerAuth.authenticate(client, asyncResult);
                }
                else 
                {
                    if (log.isDebugEnabled()) log.debug("return true");
                    asyncResult(true, null);
                }
                if (log.isDebugEnabled()) log.debug(")authenticate");
            }

            public bool isReloginException(BClient ignored, Exception ex, int typeId) 
            {
                if (log.isDebugEnabled()) log.debug("isReloginException(ex=" + ex + ", typeId=" + typeId);
                bool ret = false;
                if (innerAuth != null)
                {
                    if (log.isDebugEnabled()) log.debug("innerAuth.isReloginException");
                    ret = innerAuth.isReloginException(client, ex, typeId);
                }
                else
                {
                    if (log.isDebugEnabled()) log.debug("transport.isReloginException");
                    ret = client.getTransport().isReloginException(ex, typeId);
                }
                if (log.isDebugEnabled()) log.debug(")isReloginException=" + ret);
                return ret;
            }

            public void getSession(BClient ignored, int typeId, BAsyncResult<Object> asyncResult)
            {
                if (innerAuth != null)
                {
                    innerAuth.getSession(client, typeId, asyncResult);
                    if (log.isDebugEnabled()) log.debug("innerAuth.getSession()");
                }
                else
                {
                    asyncResult(null, null);
                }
            }

            private Log log = LogFactory.getLog(typeof(ClientAuthentication));
        }

        public void setAuthentication(BAuthentication auth)
        {
            if (log.isDebugEnabled()) log.debug("setAuthentication(" + auth + ")");
            getTransport().setAuthentication(new ClientAuthentication(this, auth));
        }

        public BAuthentication getAuthentication()
        {
            BAuthentication auth = getTransport().authentication;
            if (auth != null)
            {
                ClientAuthentication clientAuth = (ClientAuthentication)auth;
                auth = clientAuth.innerAuth;
            }
            return auth;
        }

        private Log log = LogFactory.getLog(typeof(BClient));
    }
}
