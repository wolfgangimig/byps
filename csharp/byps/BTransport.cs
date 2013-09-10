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

	    public BInput getInput(ByteBuffer buf) {
		    // Hier ermittle ich das Protokoll nochmal aus dem Input-Buffer.
		    // Dann brauche ich im Server das BTransport Objekt nicht zu der Verbindung zu speichern.
		    // Es genügt dann, das BTransport Objekt nur für die Anfrage zu verwenden.
		    // Der Server legt also für jede Anfrage ein neues BTransport Objekt an. 
		    // Hier ist this.protocol == null.
		
		    // Für den Client bringt das keinen Gewinn. Der muss ja mit BOutput 
		    // beginnen und dann antwortet der Server eh mit demselben Protokoll.
		    // Falls wir im Client sind, dann ist this.protocol != null.

            lock (this)
            {
                if (protocol == null)
                {
                    protocol = detectProtocolFromInputBuffer(buf);
                }

                return protocol.getInput(buf, this);
            }
	    }

        private class MyAsyncResultSend<T> : BAsyncResult<bool>
        {
            public MyAsyncResultSend(BTransport transport, BMethodRequest methodRequest, BAsyncResult<T> innerResult)
            {
                this.transport = transport;
                this.methodRequest = methodRequest;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(bool succ, Exception e2) {
                if (e2 != null) 
                {
                    innerResult.setAsyncResult(default(T), e2);
                }
                else 
                {
                    // Send again
                    transport.send(methodRequest, innerResult);
                }
            }

            private BTransport transport;
            private BMethodRequest methodRequest;
            private BAsyncResult<T> innerResult;
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
                bool relogin = false;

                try
                {
                    if (ex != null)
                    {
                        // BYPS relogin error? (HTTP 403)
                        relogin = internalIsReloginException(ex);
                        if (!relogin)
                        {
                            innerResult.setAsyncResult(default(T), ex);
                        }
                    }
                    else
                    {
                        BInput bin = transport.getInput(msg.buf);
                        T obj = (T)bin.load();
                        innerResult.setAsyncResult(obj, null);
                    }
                }
                catch (Exception e)
                {
                    try
                    {
                        relogin = internalIsReloginException(e);
                    }
                    catch (Exception) { }

                    if (!relogin)
                    {
                        innerResult.setAsyncResult(default(T), e);
                    }
                }

                if (relogin)
                {
                    try
                    {
                        MyAsyncResultSend<T> loginResult = new MyAsyncResultSend<T>(transport, methodRequest, innerResult);
                        transport.negotiateProtocolClient(loginResult);
                    }
                    catch (Exception e)
                    {
                        innerResult.setAsyncResult(default(T), e);
                    }
                }

            }

            private bool internalIsReloginException(Exception e)
            {
                int typeId = transport.apiDesc.getRegistry(BBinaryModel.MEDIUM).getSerializer(methodRequest, true).typeId;
                return transport.internalIsReloginException(e, typeId);
            }
        
            private BTransport transport;
            private BMethodRequest methodRequest;
            private BAsyncResult<T> innerResult;
        }

        public void send<T> (Object obj, BAsyncResult<T> asyncResult) {
		    try {
			    BOutput bout = getOutput();
			    
                BMethodRequest methodRequest = (BMethodRequest) obj;
                Object sess = authentication != null ? authentication.getSession() : null;
                methodRequest.setSession(sess);

			    bout.store(obj);

                BAsyncResult<BMessage> outerResult = new MyAsyncResultRelogin<T>(this, methodRequest, asyncResult);

                BMessage msg = bout.toMessage();
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
		
		    BInput bin = getInput(msg.buf);
		    Object methodObj = bin.load();
            MethodResult methodResult = new MethodResult(this, asyncResult, bin);
		
		    BTargetId clientTargetId = bin.header.targetId;
		    server.recv(clientTargetId, methodObj, methodResult);
		
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
                try
                {
                    if (ex != null)
                    {
                        innerResult.setAsyncResult(false, ex);
                    }
                    else
                    {
                        BNegotiate nego = new BNegotiate();
                        nego.read(msg.buf);
                        lock (transport)
                        {
                            transport.protocol = transport.createNegotiatedProtocol(nego);
                            transport.targetId = nego.targetId;
                        }
                        innerResult.setAsyncResult(true, ex);
                    }
                }
                catch (Exception e)
                {
                    innerResult.setAsyncResult(false, e);
                }
            }
        
            private BTransport transport;
            private BAsyncResult<bool> innerResult;
        }

        public void negotiateProtocolClient(BAsyncResult<Boolean> asyncResult) {
		
		    ByteBuffer buf = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
		    BNegotiate nego = new BNegotiate(apiDesc);
		    nego.write(buf);
		    buf.flip();

            BAsyncResult<BMessage> outerResult = new MyNegoAsyncResult(this, asyncResult);

            BMessage msg = new BMessage(0L, buf, null);
		    wire.send(msg, outerResult);
	    }

        public BProtocol negotiateProtocolServer(BTargetId targetId, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult)  {
		    BProtocol ret = null;
		    try {
			    BNegotiate nego = new BNegotiate();
			    nego.read(buf);
			
			    lock(this) {
				    this.protocol = ret = createNegotiatedProtocol(nego);
				    this.targetId = targetId;
			    }
			
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
            bool ret = false;

            if (authentication != null && ex != null)
            {
                ret = authentication.isReloginException(null, ex, typeId);
            }

            return ret;
        }

        public bool isReloginException(Exception ex, int typeId) 
        {
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
      
            return ret;
        }

    }
}
