﻿/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace byps
{
    public class BTransport
    {
        protected BWire wire;

        protected BApiDescriptor apiDesc;

        protected BRemoteRegistry remoteRegistry;

        private BTargetId targetId;

        private int connectedServerId;

        private String sessionId;

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
            this.sessionId = rhs.sessionId;
            this.protocol = rhs.getProtocol();

            // Still connected to the server given by rhs.
            this.connectedServerId = rhs.targetId.getServerId();
        }

        public void setProtocol(BProtocol protocol)
        {
            lock (this)
            {
                this.protocol = protocol;
            }
        }

        public void applyNegotiate(BNegotiate nego)
        {
            lock (this)
            {
                BNegotiate negoCopy = new BNegotiate(nego);
                protocol = createNegotiatedProtocol(negoCopy);
                setTargetId(nego.targetId);
                setSessionId(nego.sessionId);
            }
        }

        public BProtocol getProtocol()
        {
            lock (this)
            {
                return protocol;
            }
        }

        public void setTargetId(BTargetId targetId)
        {
            lock (this)
            {
                this.targetId = targetId;
                this.connectedServerId = targetId.getServerId();
            }
        }

        public BTargetId getTargetId()
        {
            lock (this)
            {
                return targetId;
            }
        }

        public void setSessionId(String sessionId)
        {
            lock (this)
            {
                this.sessionId = sessionId;
            }
        }

        public String getSessionId()
        {
            lock (this)
            {
                return this.sessionId;
            }
        }

        public int getConnectedServerId()
        {
            lock (this)
            {
                return connectedServerId;
            }
        }

        public virtual BWire getWire()
        {
            return wire;
        }

        public virtual BApiDescriptor getApiDesc()
        {
            return apiDesc;
        }

        public virtual BRemoteRegistry getRemoteRegistry()
        {
            return remoteRegistry;
        }

        public BOutput getOutput()
        {
            lock (this)
            {
                if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
                BOutput bout = protocol.getOutput(this);
                return bout;
            }
        }

        public BOutput getResponse(BMessageHeader requestHeader)
        {
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

        private class MyAsyncResultSend<T> : BAsyncResultIF<bool>
        {
            public MyAsyncResultSend(BTransport transport, BMethodRequest methodRequest, BAsyncResultIF<T> innerResult)
            {
                this.transport = transport;
                this.methodRequest = methodRequest;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(bool ignored, Exception e2)
            {
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
            private BAsyncResultIF<T> innerResult;
            private Log log = LogFactory.getLog(typeof(MyAsyncResultSend<T>));
        }

        private class MyAsyncResultRelogin<T> : BAsyncResultIF<BMessage>
        {
            public MyAsyncResultRelogin(BTransport transport, BMethodRequest methodRequest, BAsyncResultIF<T> innerResult)
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
                        // BYPS relogin error? (HTTP 401)
                        relogin = transport.internalIsReloginException(ex, transport.getObjectTypeId(methodRequest));
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
                        relogin = transport.internalIsReloginException(e, transport.getObjectTypeId(methodRequest));
                    }
                    catch (Exception ignored)
                    {
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
                    transport.reloginAndRetrySend(methodRequest, innerResult);
                }

                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }

            private BTransport transport;
            private BMethodRequest methodRequest;
            private BAsyncResultIF<T> innerResult;
            private Log log = LogFactory.getLog(typeof(MyAsyncResultRelogin<T>));
        }

        private int getObjectTypeId(Object obj)
        {
            return protocol.getRegistry().getSerializer(obj, true).typeId;
        }

        public IAsyncResult BeginSend<T>(BMethodRequest methodRequest, AsyncCallback callback, object state)
        {
            BAsyncProgModel<T> asyncResult = new BAsyncProgModel<T>(callback, state);
            BAsyncResultReceiveMethod<T> outerResult = new BAsyncResultReceiveMethod<T>(asyncResult);
            assignSessionThenSendMethod(methodRequest, outerResult);
            return asyncResult;
        }

        public T EndSend<T>(IAsyncResult asyncResult)
        {
            BAsyncProgModel<T> amp = (BAsyncProgModel<T>)asyncResult;
            T ret = amp.Result;
            return ret;
        }

        public void sendMethod<T>(BMethodRequest methodRequest, BAsyncResult<T> asyncResult)
        {
            BAsyncResultReceiveMethod<T> outerResult = new BAsyncResultReceiveMethod<T>(asyncResult);
            assignSessionThenSendMethod(methodRequest, outerResult);
        }

        private void assignSessionThenSendMethod<T>(BMethodRequest methodRequest, BAsyncResultIF<T> asyncResult)
        {
            if (authentication != null)
            {
                int typeId = getObjectTypeId(methodRequest);
                BAsyncResult<Object> sessionResult = (session, ex) =>
                {
                    if (ex != null)
                    {
                        bool relogin = isReloginException(ex, typeId);
                        if (relogin)
                        {
                            reloginAndRetrySend(methodRequest, asyncResult);
                        }
                        else
                        {
                            asyncResult.setAsyncResult(default(T), ex);
                        }
                    }
                    else
                    {
                        methodRequest.setSession(session);
                        send(methodRequest, asyncResult);
                    }
                };

                authentication.getSession(null, typeId, sessionResult);
            }
            else
            {
                send(methodRequest, asyncResult);
            }
        }

        private void reloginAndRetrySend<T>(BMethodRequest methodRequest, BAsyncResultIF<T> asyncResult)
        {
            try
            {
                BAsyncResult<bool> loginResult = (ignored, ex) =>
                {
                    if (ex != null)
                    {
                        asyncResult.setAsyncResult(default(T), ex);
                    }
                    else
                    {
                        assignSessionThenSendMethod(methodRequest, asyncResult);
                    }
                };

                negotiateProtocolClient(BAsyncResultHelper.FromDelegate(loginResult));

            }
            catch (Exception ex)
            {
                asyncResult.setAsyncResult(default(T), ex);
            }
        }

        public void send<T>(Object obj, BAsyncResultIF<T> asyncResult)
        {
            if (log.isDebugEnabled()) log.debug("send(" + obj);
            try
            {
                BOutput bout = getOutput();

                if (log.isDebugEnabled()) log.debug("obj -> message");
                bout.store(obj);
                BMessage msg = bout.toMessage();

                if (log.isDebugEnabled()) log.debug("wire.send");
                BAsyncResultIF<BMessage> outerResult = new MyAsyncResultRelogin<T>(this, (BMethodRequest)obj, asyncResult);
                wire.send(msg, outerResult);
            }
            catch (Exception e)
            {
                asyncResult.setAsyncResult(default(T), e);
            }
        }


        private class MethodResult : BAsyncResultIF<Object>
        {
            private BTransport transport;
            private BAsyncResultIF<BMessage> asyncResult;
            private BInput bin;

            public MethodResult(BTransport transport, BAsyncResultIF<BMessage> asyncResult, BInput bin)
            {
                this.transport = transport;
                this.asyncResult = asyncResult;
                this.bin = bin;
            }

            public void setAsyncResult(Object obj, Exception ex)
            {
                BOutput bout = transport.getResponse(bin.header);

                if (ex != null)
                {
                    bout.setException(ex);
                }
                else {
                    bout.store(obj);
                }

                asyncResult.setAsyncResult(bout.toMessage(), null);
            }

        }

        public void recv(BServer server, BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
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

        private BProtocol detectProtocolFromInputBuffer(ByteBuffer buf)
        {
            BProtocol ret = null;

            // Read the first 4 bytes to detect the protocol.
            int magic = BMessageHeader.detectProtocol(buf);

            if (magic == BMessageHeader.MAGIC_BINARY_STREAM)
            {
                // Version, ByteOrder wird in BInput gelesen 
                ret = new BProtocolS(apiDesc);
            }

            if (ret == null)
            {
                throw new BException(BExceptionC.CORRUPT, "Invalid protocol.");
            }

            return ret;
        }

        private class MyNegoAsyncResult : BAsyncResultIF<BMessage>
        {
            public MyNegoAsyncResult(BTransport transport, BAsyncResultIF<bool> innerResult)
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
                        transport.applyNegotiate(nego);
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
            private BAsyncResultIF<bool> innerResult;
            private Log log = LogFactory.getLog(typeof(MyNegoAsyncResult));
        }

        public void negotiateProtocolClient(BAsyncResultIF<Boolean> asyncResult)
        {
            if (log.isDebugEnabled()) log.debug("negotiateProtocolClient(");

            ByteBuffer buf = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
            BNegotiate nego = new BNegotiate(apiDesc);
            nego.write(buf);
            buf.flip();

            BAsyncResultIF<BMessage> outerResult = new MyNegoAsyncResult(this, asyncResult);

            if (log.isDebugEnabled()) log.debug("wire.send");
            BMessageHeader header = new BMessageHeader();
            header.messageId = wire.makeMessageId();
            BMessage msg = new BMessage(header, buf, null);
            wire.send(msg, outerResult);
            if (log.isDebugEnabled()) log.debug(")negotiateProtocolClient");
        }

        public BProtocol negotiateProtocolServer(BTargetId targetId, ByteBuffer buf, BAsyncResultIF<ByteBuffer> asyncResult)
        {
            if (log.isDebugEnabled()) log.debug("negotiateProtocolServer(targetId=" + targetId);
            BProtocol ret = null;
            try
            {
                if (log.isDebugEnabled()) log.debug("read nego msg");
                BNegotiate nego = new BNegotiate();
                nego.read(buf);

                lock (this)
                {
                    this.protocol = ret = createNegotiatedProtocol(nego);
                    this.setTargetId(targetId);
                    this.setSessionId(targetId.toSessionId());
                }
                if (log.isDebugEnabled()) log.debug("protocol=" + this.protocol + ", targetId=" + this.targetId);

                ByteBuffer bout = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
                try
                {
                    nego.targetId = targetId;
                    nego.sessionId = targetId.toSessionId();
                    nego.write(bout);
                    bout.flip();
                    asyncResult.setAsyncResult(bout, null);
                }
                finally
                {
                }

            }
            catch (Exception e)
            {
                asyncResult.setAsyncResult(null, e);
            }
            if (log.isDebugEnabled()) log.debug(")negotiateProtocolServer=" + ret);
            return ret;
        }


        private BProtocol createNegotiatedProtocol(BNegotiate nego)
        {
            BProtocol protocol = null;

            if (nego.protocols.IndexOf(BNegotiate.BINARY_STREAM) == 0)
            {
                int negotiatedBypsVersion = Math.Min(BMessageHeader.BYPS_VERSION_CURRENT, nego.bversion);
                long negotiatedVersion = Math.Min(apiDesc.version, nego.version);
                nego.protocols = BNegotiate.BINARY_STREAM;
                if (nego.byteOrder == ByteOrder.UNDEFINED) nego.byteOrder = ByteOrder.LITTLE_ENDIAN;
                if (nego.byteOrder != ByteOrder.LITTLE_ENDIAN) throw new BException(BExceptionC.CORRUPT, "Protocol requires unsupported byte order BIG_ENDIAN");
                nego.version = negotiatedVersion;
                protocol = new BProtocolS(apiDesc, negotiatedBypsVersion, negotiatedVersion, nego.byteOrder);
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

        private bool internalIsReloginException(Exception ex, int typeId)
        {
            if (log.isDebugEnabled()) log.debug("internalIsReloginException(" + ex);
            bool ret = false;

            if (authentication != null && ex != null)
            {
                ret = authentication.isReloginException(null, ex, typeId);
            }

            if (log.isDebugEnabled()) log.debug(")internalIsReloginException=" + ret);
            return ret;
        }

        public bool isReloginException(Exception ex, int typeId)
        {
            if (log.isDebugEnabled()) log.debug("isReloginException(ex=" + ex + ", typeId=" + typeId);
            bool ret = false;

            // Check exception
            if (ex is BException)
            {
                BException bex = (BException)ex;
                ret = (bex.Code == BExceptionC.UNAUTHORIZED);
            }

            if (log.isDebugEnabled()) log.debug(")isReloginException=" + ret);
            return ret;
        }


        internal void internalAuthenticate(BAsyncResultIF<bool> innerResult)
        {
            if (log.isDebugEnabled()) log.debug("internalAuthenticate(");

            if (log.isDebugEnabled()) log.debug("authentication=" + authentication);
            if (authentication != null)
            {
                authentication.authenticate(null, BAsyncResultHelper.ToDelegate(innerResult));
            }
            else
            {
                innerResult.setAsyncResult(false, null);
            }

            if (log.isDebugEnabled()) log.debug(")internalAuthenticate");
        }

        internal void setAuthentication(BAuthentication auth)
        {
            authentication = auth;
        }

        private Log log = LogFactory.getLog(typeof(BTransport));
    }
}
