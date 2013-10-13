using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BTransport
    {
        public readonly BWire wire;
	
	    public readonly BApiDescriptor apiDesc;
	
	    public readonly BRemoteRegistry remoteRegistry;

        private BTargetId targetId;

        private BProtocol protocol;

        internal BAuthentication authentication;
	
        public BTransport(BApiDescriptor apiDesc, BWire wire, BRemoteRegistry remoteRegistry)
        {
            this.apiDesc = apiDesc;
            this.wire = wire;
            this.targetId = new BTargetId();
            this.remoteRegistry = remoteRegistry;
        }

        public BTransport(BTransport rhs, BTargetId targetId)
        {
            this.apiDesc = rhs.apiDesc;
            this.wire = rhs.wire;
            this.targetId = targetId;
            this.protocol = rhs.getProtocol();
            this.authentication = rhs.authentication;
            this.remoteRegistry = rhs.remoteRegistry;
        }

        public void setProtocol(BProtocol protocol) {
            lock(this)
            {
		        this.protocol = protocol;
            }
	    }
	
	    public BProtocol getProtocol() {
            lock (this)
            {
                return protocol;
            }
	    }

        public void setTargetId(BTargetId TargetId)
        {
            lock (this)
            {
                this.targetId = TargetId;
            }
        }

        public BTargetId getTargetId()
        {
            lock (this)
            {
                return targetId;
            }
        }

        public BOutput getOutput()  {
            lock (this)
            {
                if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
                BOutput bout = protocol.getOutput(this);
                return bout;
            }
	    }

	    public BOutput getResponse(BMessageHeader requestHeader) {
            lock (this)
            {
                if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
                BMessageHeader responseHeader = requestHeader.createResponse();
                BOutput bout = protocol.getResponse(this, responseHeader);
                return bout;
            }
	    }

        public BInput getInput(BMessageHeader header, ByteBuffer buf)
        {
            // header is null in the test cases that check the serialization.
            if (header == null)
            {
                header = new BMessageHeader();
                header.read(buf);
            }

            return protocol.getInput(this, header, buf);
	    }

        private class MyAsyncResultSend<T> : BAsyncResult<bool>
        {
            public MyAsyncResultSend(BTransport transport, BMethodRequest methodRequest, BAsyncResult<T> innerResult)
            {
                this.transport = transport;
                this.methodRequest = methodRequest;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(bool ignored, Exception e2) {
                if (log.isDebugEnabled()) log.debug("setAsyncResult(" + e2);
                if (e2 != null) 
                {
                    if (log.isDebugEnabled()) log.debug("return ex");
                    innerResult.setAsyncResult(default(T), e2);
                }
                else 
                {
                    if (log.isDebugEnabled()) log.debug("transport.send, methodRequest=" + methodRequest);
                    // Send again
                    transport.send(methodRequest, innerResult);
                }
                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }

            private BTransport transport;
            private BMethodRequest methodRequest;
            private BAsyncResult<T> innerResult;
            private Log log = LogFactory.getLog(typeof(MyAsyncResultSend<T>));
        }

        private class MyAsyncResultRelogin<T> : BAsyncResult<BMessage>
        {
            public MyAsyncResultRelogin(BTransport transport, BMethodRequest methodRequest, BAsyncResult<T> innerResult)
            {
                this.transport = transport;
                this.methodRequest = methodRequest;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(BMessage msg, Exception ex)
            {
                if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg + ", ex=" + ex);
                bool relogin = false;

                try
                {
                    if (ex != null)
                    {
                        // BYPS relogin error? (HTTP 403)
                        relogin = internalIsReloginException(ex);
                        if (!relogin)
                        {
                            if (log.isDebugEnabled()) log.debug("return ex");
                            innerResult.setAsyncResult(default(T), ex);
                        }
                    }
                    else
                    {
                        if (log.isDebugEnabled()) log.debug("obj <- message");
                        BInput bin = transport.getInput(msg.header, msg.buf);
                        T obj = (T)bin.load();

                        if (log.isDebugEnabled()) log.debug("return obj=" + obj);
                        innerResult.setAsyncResult(obj, null);
                    }
                }
                catch (Exception e)
                {
                    if (log.isDebugEnabled()) log.debug("exception=" + e);
                    try
                    {
                        relogin = internalIsReloginException(e);
                    }
                    catch (Exception ignored) {
                        if (log.isDebugEnabled()) log.debug("ignored exception=", ignored);
                    }

                    if (!relogin)
                    {
                        if (log.isDebugEnabled()) log.debug("return ex");
                        innerResult.setAsyncResult(default(T), e);
                    }
                }

                if (log.isDebugEnabled()) log.debug("relogin=" + relogin);
                if (relogin)
                {
                    try
                    {
                        if (log.isDebugEnabled()) log.debug("negotiate");
                        MyAsyncResultSend<T> loginResult = new MyAsyncResultSend<T>(transport, methodRequest, innerResult);
                        transport.negotiateProtocolClient(loginResult);
                    }
                    catch (Exception e)
                    {
                        if (log.isDebugEnabled()) log.debug("transport.negotiate failed, return ex", e);
                        innerResult.setAsyncResult(default(T), e);
                    }
                }

                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }

            private bool internalIsReloginException(Exception e)
            {
                if (log.isDebugEnabled()) log.debug("internalIsReloginException(" + e);

                int typeId = transport.apiDesc.getRegistry(BBinaryModel.MEDIUM).getSerializer(methodRequest, true).typeId;
                if (log.isDebugEnabled()) log.debug("request typeId=" + typeId);

                bool ret = transport.internalIsReloginException(e, typeId);
                if (log.isDebugEnabled()) log.debug(")internalIsReloginException=" + ret);
                return ret;
            }
        
            private BTransport transport;
            private BMethodRequest methodRequest;
            private BAsyncResult<T> innerResult;
            private Log log = LogFactory.getLog(typeof(MyAsyncResultRelogin<T>));
        }

        public void send<T> (Object obj, BAsyncResult<T> asyncResult) {
            if (log.isDebugEnabled()) log.debug("send(" + obj);
		    try {
			    BOutput bout = getOutput();
			    
                BMethodRequest methodRequest = (BMethodRequest) obj;
                if (authentication != null)
                {
                    Object sess = authentication.getSession();
                    if (sess != null)
                    {
                        if (log.isDebugEnabled()) log.debug("methodRequest.sess=" + sess);
                        methodRequest.setSession(sess);
                    }
                }

                if (log.isDebugEnabled()) log.debug("obj -> message");
                bout.store(obj);
                BMessage msg = bout.toMessage();

                if (log.isDebugEnabled()) log.debug("wire.send");
                BAsyncResult<BMessage> outerResult = new MyAsyncResultRelogin<T>(this, methodRequest, asyncResult);
                wire.send(msg, outerResult);
		    }
		    catch (Exception e) {
                asyncResult.setAsyncResult(default(T), e);
		    }
	    }


		private class MethodResult : BAsyncResult<Object>
        {
            private BTransport transport;
            private BAsyncResult<BMessage> asyncResult;
            private BInput bin;

            public MethodResult(BTransport transport, BAsyncResult<BMessage> asyncResult, BInput bin)
            {
                this.transport = transport;
                this.asyncResult = asyncResult;
                this.bin = bin;
            }
			
			public void setAsyncResult(Object obj, Exception ex) {
				BOutput bout = transport.getResponse(bin.header);
				
				if (ex != null) {
					bout.setException(ex);
				}
				else {
					bout.store(obj);
				}
				
				asyncResult.setAsyncResult(bout.toMessage(), null);
			}

		}

        public void recv(BServer server, BMessage msg, BAsyncResult<BMessage> asyncResult) {
            if (log.isDebugEnabled()) log.debug("recv(");

            BInput bin = getInput(msg.header, msg.buf);
		    Object methodObj = bin.load();
            if (log.isDebugEnabled()) log.debug("methodObj=" + methodObj);

            MethodResult methodResult = new MethodResult(this, asyncResult, bin);
		
		    BTargetId clientTargetId = bin.header.targetId;
            if (log.isDebugEnabled()) log.debug("clientTargetId=" + clientTargetId);

            if (log.isDebugEnabled()) log.debug("server.recv");
            server.recv(clientTargetId, methodObj, methodResult);

            if (log.isDebugEnabled()) log.debug(")recv");
        }

 	    private BProtocol detectProtocolFromInputBuffer(ByteBuffer buf) {
		    BProtocol ret = null;
	
		    // Read the first 4 bytes to detect the protocol.
		    int magic = BMessageHeader.detectProtocol(buf);
		
		    if (magic == BMessageHeader.MAGIC_BINARY_STREAM) {
			    // Version, ByteOrder wird in BInput gelesen 
			    ret = new BProtocolS(apiDesc);
		    }
		
		    if (ret == null) {
                throw new BException(BExceptionC.CORRUPT, "Invalid protocol.");
		    }
		
		    return ret;
	    }

        private class MyNegoAsyncResult : BAsyncResult<BMessage>
        {
            public MyNegoAsyncResult(BTransport transport, BAsyncResult<bool> innerResult)
            {
                this.transport = transport;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(BMessage msg, Exception ex)
            {
                if (log.isDebugEnabled()) log.debug("setAsyncResult(msg=" + msg + ", ex=" + ex);
                try
                {
                    if (ex != null)
                    {
                        innerResult.setAsyncResult(false, ex);
                    }
                    else
                    {
                        if (log.isDebugEnabled()) log.debug("read message");
                        BNegotiate nego = new BNegotiate();
                        nego.read(msg.buf);
                        lock (transport)
                        {
                            transport.protocol = transport.createNegotiatedProtocol(nego);
                            transport.targetId = nego.targetId;
                        }
                        if (log.isDebugEnabled()) log.debug("protocol=" + transport.protocol + ", targetId=" + transport.targetId);

                        transport.internalAuthenticate(innerResult);
                    }
                }
                catch (Exception e)
                {
                    innerResult.setAsyncResult(false, e);
                }
                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }
        
            private BTransport transport;
            private BAsyncResult<bool> innerResult;
            private Log log = LogFactory.getLog(typeof(MyNegoAsyncResult));
        }

        public void negotiateProtocolClient(BAsyncResult<Boolean> asyncResult) {
            if (log.isDebugEnabled()) log.debug("negotiateProtocolClient(");

		    ByteBuffer buf = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
		    BNegotiate nego = new BNegotiate(apiDesc);
		    nego.write(buf);
		    buf.flip();

            BAsyncResult<BMessage> outerResult = new MyNegoAsyncResult(this, asyncResult);

            if (log.isDebugEnabled()) log.debug("wire.send");
            BMessageHeader header = new BMessageHeader();
            header.messageId = wire.makeMessageId();
            BMessage msg = new BMessage(header, buf, null);
		    wire.send(msg, outerResult);
            if (log.isDebugEnabled()) log.debug(")negotiateProtocolClient");
        }

        public BProtocol negotiateProtocolServer(BTargetId targetId, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult)  {
            if (log.isDebugEnabled()) log.debug("negotiateProtocolServer(targetId=" + targetId);
            BProtocol ret = null;
		    try {
                if (log.isDebugEnabled()) log.debug("read nego msg");
                BNegotiate nego = new BNegotiate();
			    nego.read(buf);
			
			    lock(this) {
				    this.protocol = ret = createNegotiatedProtocol(nego);
				    this.targetId = targetId;
			    }
                if (log.isDebugEnabled()) log.debug("protocol=" + this.protocol + ", targetId=" + this.targetId);
			
			    ByteBuffer bout = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
			    try {
				    nego.targetId = targetId;
				    nego.write(bout);
				    bout.flip();
				    asyncResult.setAsyncResult(bout, null);
			    } 
			    finally {
			    }
			
		    }
		    catch (Exception e) {
                asyncResult.setAsyncResult(null, e);
		    }
            if (log.isDebugEnabled()) log.debug(")negotiateProtocolServer=" + ret);
            return ret;
	    }


        private BProtocol createNegotiatedProtocol(BNegotiate nego)  {
		    BProtocol protocol = null;
		
		    if (nego.protocols.IndexOf(BNegotiate.BINARY_STREAM) == 0) {
			    long negotiatedVersion = Math.Min(apiDesc.version, nego.version);
			    nego.protocols = BNegotiate.BINARY_STREAM;
                if (nego.byteOrder == ByteOrder.UNDEFINED) nego.byteOrder = ByteOrder.LITTLE_ENDIAN;
                if (nego.byteOrder != ByteOrder.LITTLE_ENDIAN) throw new BException(BExceptionC.CORRUPT, "Protocol requires unsupported byte order BIG_ENDIAN");
			    nego.version = negotiatedVersion;
			    protocol = new BProtocolS(apiDesc, negotiatedVersion, nego.byteOrder);
		    }
		    else {
			    throw new BException(BExceptionC.CORRUPT, "Protocol negotiation failed.");
		    }

		    return protocol;
	    }
	
        public override String ToString()
        {
            return "[" + targetId + "]";
        }


        internal bool internalIsReloginException(Exception ex, int typeId)
        {
            if (log.isDebugEnabled()) log.debug("internalIsReloginException(ex=" + ex + ", typeId=" + typeId);
            bool ret = false;

            if (authentication != null && ex != null)
            {
                ret = authentication.isReloginException(null, ex, typeId);
            }

            if (log.isDebugEnabled()) log.debug(")isReloginException=" + ret);
            return ret;
        }

        public bool isReloginException(Exception ex, int typeId) 
        {
            if (log.isDebugEnabled()) log.debug("isReloginException(ex=" + ex + ", typeId=" + typeId);
            bool ret = false;
    
            // Check exception
            if (ex is BException) 
            {
                BException bex = (BException) ex;
                ret = (bex.Code == BExceptionC.AUTHENTICATION_REQUIRED);
                if (!ret)
                {
                    // The negotiated Tomcat session lives for 10 seconds.
                    // If we are slow in debugging and the session expires,
                    // we receive a BExceptionO.IOERRROR with the message "HTTP 403"
                    ret = (bex.Code == BExceptionC.IOERROR) && bex.ToString().IndexOf("403") >= 0;
                }
            }

            if (log.isDebugEnabled()) log.debug(")isReloginException=" + ret);
            return ret;
        }


        private class InternalAuthenticate_BAsyncResult : BAsyncResult<bool>
        {
            public InternalAuthenticate_BAsyncResult(BTransport transport)
            {
                this.transport = transport;
            }

            public void setAsyncResult(bool ignored, Exception ex) 
            {
                if (log.isDebugEnabled()) log.debug("setAsyncResult(ex=" + ex);

                List<BAsyncResult<bool>> copyResults = null;
                lock (transport.asyncResultsWaitingForAuthentication) {
                    copyResults = new List<BAsyncResult<bool>>(transport.asyncResultsWaitingForAuthentication);
                    transport.asyncResultsWaitingForAuthentication.Clear();
                    transport.lastAuthenticationTime = DateTime.Now.Ticks / 10000;
                    transport.lastAuthenticationException = ex;
                }

                if (log.isDebugEnabled()) log.debug("Call setAsyncResult for collected result objects, #=" + copyResults.Count);
                for (int i = 0; i < copyResults.Count; i++)
                {
                    copyResults[i].setAsyncResult(true, ex);
                }

                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }

            private BTransport transport;
            private Log log = LogFactory.getLog(typeof(InternalAuthenticate_BAsyncResult));
        }


        internal void internalAuthenticate(BAsyncResult<bool> innerResult)
        {
            if (log.isDebugEnabled()) log.debug("internalAuthenticate(");

            if (log.isDebugEnabled()) log.debug("authentication=" + authentication);
            if (authentication != null)
            {
                bool first = false;
                bool assumeAuthenticationIsValid = false;
                lock (asyncResultsWaitingForAuthentication)
                {
                    assumeAuthenticationIsValid = lastAuthenticationTime + RETRY_AUTHENTICATION_AFTER_MILLIS >= DateTime.Now.Ticks / 10000;
                    if (!assumeAuthenticationIsValid)
                    {
                        first = asyncResultsWaitingForAuthentication.Count == 0;
                        asyncResultsWaitingForAuthentication.Add(innerResult);
                    }
                }
                if (log.isDebugEnabled()) log.debug("first=" + first + ", assumeValid=" + assumeAuthenticationIsValid);

                if (first)
                {
                    InternalAuthenticate_BAsyncResult authResult = new InternalAuthenticate_BAsyncResult(this);
                    authentication.authenticate(null, authResult);
                }
                else if (assumeAuthenticationIsValid)
                {

                    // Assume that the session is still valid or that
                    // the exception from the last authentication would
                    // be received again at this time.
                    innerResult.setAsyncResult(false, lastAuthenticationException);
                }
                else
                {
                    // innerResult has been added to asyncResultsWaitingForAuthentication 
                    // and will be called in InternalAuthenticate_BAsyncResult
                }

            }
            else
            {
                innerResult.setAsyncResult(false, null);
            }

            if (log.isDebugEnabled()) log.debug(")internalAuthenticate");
        }

        internal void setAuthentication(BAuthentication auth, bool onlyIfNull) 
        {
            lock (asyncResultsWaitingForAuthentication)
            {
                if (onlyIfNull && authentication != null) return;
                authentication = auth;
                asyncResultsWaitingForAuthentication.Clear();
                lastAuthenticationException = null;
                lastAuthenticationTime = 0;
            }
        }

        /**
        * List of BAsyncResult objects from requests waiting for authentication.
        */
        internal List<BAsyncResult<bool>> asyncResultsWaitingForAuthentication = new List<BAsyncResult<bool>>();
  
        /**
        * Sytem millis when authentication was perfomed the last time.
        */
        internal long lastAuthenticationTime = 0;
  
        /**
        * Exception received from the last authentication.
        * Is null, if authentication was successful.
        */
        internal Exception lastAuthenticationException = null;
  
        /**
        * Last authentication result is assumed to be valid for this time.
        */
        internal long RETRY_AUTHENTICATION_AFTER_MILLIS = 1 * 1000;


        private Log log = LogFactory.getLog(typeof(BTransport));
    }
}
