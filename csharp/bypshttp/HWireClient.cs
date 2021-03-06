﻿/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
// using System.Linq;
using System.Net;
using System.Text;
using System.Threading;
using byps.ureq;
// using System.Threading.Tasks;

namespace byps
{
    public class HWireClient : BWire
    {
        public HWireClient(String url, BWireFlags flags, int timeoutSeconds)
            : base(flags)
        {
            this.url = url;
            this.timeoutMillisClient = timeoutSeconds * 1000;
            this.testAdapterVal = new HTestAdapter(this);
        }

        private class AsyncResultAfterAllRequests : BAsyncResultIF<BMessage> 
        {
            readonly HWireClient wire;
            readonly long messageId;
            BAsyncResultIF<BMessage> innerResult;
            int nbOfOutstandingResults;
            int nbOfResults;
            BMessage result;
		    Exception ex;
            private Log log = LogFactory.getLog(typeof(AsyncResultAfterAllRequests));

            public AsyncResultAfterAllRequests(HWireClient wire, long messageId, BAsyncResultIF<BMessage> asyncResult, int nbOfRequests)
            {
                this.wire = wire;
                this.messageId = messageId;
			    this.innerResult = asyncResult;
                this.nbOfOutstandingResults = this.nbOfResults = nbOfRequests;
		    }

		    public void setAsyncResult(BMessage msg, Exception ex) {
                if (log.isDebugEnabled()) log.debug("setAsyncResult(msg=" + msg + ", ex=" + ex);
                
                bool cancelMessage = false;

                bool isLastResult = false;
                BMessage innerMsg = null;
                Exception innerEx = null;

                lock (this)
                {
                    isLastResult = --nbOfOutstandingResults == 0;
                    if (log.isDebugEnabled()) log.debug("isLastResult=" + isLastResult);

                    if (ex != null)
                    {
                        cancelMessage = this.ex == null;
                        if (cancelMessage) this.ex = ex;
                        if (log.isDebugEnabled()) log.debug("cancelMessage=" + cancelMessage);
                    }

                    if (msg != null && msg.buf != null && msg.buf.remaining() != 0)
                    {
                        if (log.isDebugEnabled()) log.debug("set result=" + msg);
                        this.result = msg;
                    }
                    else
                    {
                        // Stream result OK
                    }

                    if (isLastResult)
                    {
                        innerMsg = this.result;
                        innerEx = this.ex;
                    }
                }

                if (isLastResult)
                {
                    if (log.isDebugEnabled()) log.debug("innerResult.set(" + innerMsg + ", ex=" + innerEx + ")");
                    innerResult.setAsyncResult(innerMsg, innerEx);
			    }

                if (cancelMessage && !isLastResult)
                {
                    wire.sendCancelMessage(messageId);
                }

                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
		    }

	    }

        public override void send(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        public override void sendR(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        protected void internalSend(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
		    if (log.isDebugEnabled()) log.debug("send(" + msg + ", asyncResult=" + asyncResult);

		    // Convert the BMessage into single RequestToCancel objects.
		    // One RequestToCancel is created for msg.buf.
		    // For each stream in msg.streams further RequestToCancel objects are created.
		
		    int nbOfRequests = 1 + (msg.streams != null ? msg.streams.Count : 0);
		    List<RequestToCancel> requests = new List<RequestToCancel>(nbOfRequests);
		
		    // If the BMessage contains streams, the given asyncResult is wrapped into an
		    // outerResult in order to pass only the first exception to the caller. 
            BAsyncResultIF<BMessage> outerResult = asyncResult;
		    if (nbOfRequests > 1) {
			    if (log.isDebugEnabled()) log.debug("wrap asyncResult");
			    outerResult = new AsyncResultAfterAllRequests(this, msg.header.messageId, asyncResult, nbOfRequests);
		    }
	
		    // Create RequestToCancel for msg.buf
		    RequestToCancel req = createRequestForMessage(msg, outerResult);
		    requests.Add(req);
		
		    // Create RequestToCancel objects for each stream.
		    if (msg.streams != null) {
			    foreach (BContentStream stream in msg.streams) {
				    req = createRequestForPutStream(stream, outerResult);
				    requests.Add(req);
			    }
		    }

		    // Execute the RequestToCancel objects in the thread pool
		    if (log.isDebugEnabled()) log.debug("put requests into thread pool");
		    foreach (RequestToCancel r in requests) {
			    if (!executeRequest(r)) {
				    cancelMessage(msg.header.messageId);
				    break;
			    }
		    }
		
		    if (log.isDebugEnabled()) log.debug(")send");
	    }

        public override void putStreams(List<BContentStream> streamRequests, BAsyncResultIF<BMessage> asyncResult1)
        {
		    throw new InvalidOperationException("putStreams is only for the server side");
	    }

        public RequestToCancel createRequestForMessage(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
            ERequestDirection requestDirection = ERequestDirection.FORWARD;
            int timeout = this.timeoutMillisClient;

            // Reverse HTTP request (long-poll)?
            bool isReverse = (msg.header.flags & BMessageHeader.FLAG_RESPONSE) != 0;
            if (isReverse)
            {
                requestDirection = ERequestDirection.REVERSE;
                timeout = System.Threading.Timeout.Infinite; // timeout controlled by server, 10min by default.
            }

            RequestToCancel r = new RequestToCancel(this, 
                requestDirection, 
                msg.header.messageId,
                msg.buf, 
                null,
                0L, 
                0L,
                timeoutMillisClient, 
                timeout, 
                asyncResult);

		    addRequest(r);
		    return r;
	    }

        public RequestToCancel createRequestForPutStream(BContentStream stream, BAsyncResultIF<BMessage> asyncResult)
        {
            RequestToCancel r = new RequestToCancel(this, 
                ERequestDirection.FORWARD, 
                stream.TargetId.getMessageId(), 
                null,
                stream,
                stream.TargetId.getStreamId(), 
                0L, 
                timeoutMillisClient, 
                timeoutMillisClient, 
                asyncResult);
		    addRequest(r);
		    return r;
	    }

        public RequestToCancel createRequestForGetStream(BTargetId targetId, BAsyncResultIF<BMessage> asyncResult)
        {
            RequestToCancel r = new RequestToCancel(this, ERequestDirection.FORWARD, targetId.getMessageId(), null, null, targetId.getStreamId(), 0L, 
                timeoutMillisClient, timeoutMillisClient, asyncResult);
		    addRequest(r);
		    return r;
	    }

        protected class CancelResult : BAsyncResultIF<BMessage>
        {
			public void setAsyncResult(BMessage msg, Exception e) {}
        }

        public bool executeRequest(RequestToCancel r)
        {
            if (log.isDebugEnabled()) log.debug("executeRequest(" + r);
            r.run();
            if (log.isDebugEnabled()) log.debug(")executeRequest=true");
            return true;
        }

        public void internalSend(RequestToCancel request)
        {
            if (log.isDebugEnabled()) log.debug("internalSend(" + request);
            ByteBuffer requestDataBuffer = request.buf;

            bool isNegotiate = BNegotiate.isNegotiateMessage(requestDataBuffer);
            bool isJson = isNegotiate || BMessageHeader.detectProtocol(requestDataBuffer) == BMessageHeader.MAGIC_JSON;

            String destUrl = url;

            // Negotiate? 
            if (isNegotiate)
            {
                // Send a GET request and pass the negotate string as parameter 

                String negoStr = Encoding.UTF8.GetString(requestDataBuffer.array(), requestDataBuffer.position(), requestDataBuffer.remaining());
                negoStr = System.Uri.EscapeDataString(negoStr);

                destUrl = makeUrl(getServletPathForNegotiationAndAuthentication(),
                    new String[] { "negotiate", negoStr });
            }

            // Reverse request (long-poll) ?
            else if (request.requestDirection == ERequestDirection.REVERSE)
            {
                destUrl = makeUrl(getServletPathForReverseRequest(), null);
            }

            HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(destUrl);
            request.setConnection(conn);
            conn.Method = isNegotiate ? "GET" : "POST";
            conn.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;
            
            // Content-Type for POST request
            if (!isNegotiate)
            {
                conn.ContentType = isJson ? "application/json" : "application/byps";
            }
 
            conn.Accept = "application/json, application/byps, text/plain, text/html";

            // BYPS-36: Accept GZIP for both, json and byps
            conn.Headers.Add("Accept-Encoding", "gzip");

            applySession(conn);

            IAsyncResult asyncResult = null;
            if (isNegotiate)
            {
               asyncResult = conn.BeginGetResponse(new AsyncCallback(this.getResponseCallback), request);
            }
            else
            {
                asyncResult = conn.BeginGetRequestStream(new AsyncCallback(this.getRequestStreamCallback), request);
            }

            request.startTimeoutWatcher(conn, asyncResult, request.timeoutMillisRequest);

            if (log.isDebugEnabled()) log.debug(")internalSend");
        }

        public override BContentStream getStream(BTargetId targetId)
        {
            BContentStream strm = new MyInputStream(this, targetId);
            return strm;
        }

        protected void getRequestStreamCallback(IAsyncResult asynchronousResult)
        {
            RequestToCancel requestToCancel = (RequestToCancel)asynchronousResult.AsyncState;
            if (log.isDebugEnabled()) log.debug("getRequestStreamCallback(" + requestToCancel);
            try
            {
                HttpWebRequest conn = requestToCancel.getConnection();
                Stream postStream = conn.EndGetRequestStream(asynchronousResult);
                if (requestToCancel.buf != null)
                {
                    if (log.isDebugEnabled()) log.debug("bufferToStream");
                    bufferToStream(requestToCancel.buf, postStream);
                }
                else if (requestToCancel.stream != null)
                {
                    if (log.isDebugEnabled()) log.debug("copy stream");
                    requestToCancel.stream.CopyTo(postStream);
                    postStream.Close();
                }
                conn.BeginGetResponse(new AsyncCallback(this.getResponseCallback), requestToCancel);
            }
            catch (Exception e)
            {
                if (log.isDebugEnabled()) log.debug("Exception:", e);
                BException bex = null;
                if (_cancelAllRequests)
                {
                    bex = new BException(BExceptionC.CANCELLED, "");
                }
                else
                {
                    bex = new BException(BExceptionC.IOERROR, e.Message, e);
                }
                removeRequest(requestToCancel, null, bex);
            }
            finally
            {
                if (requestToCancel.stream != null)
                {
                    requestToCancel.stream.Close();
                }
            }
            if (log.isDebugEnabled()) log.debug(")getRequestStreamCallback");
        }

        protected void getResponseCallback(IAsyncResult asynchronousResult)
        {
            RequestToCancel requestToCancel = (RequestToCancel)asynchronousResult.AsyncState;
            if (log.isDebugEnabled()) log.debug("getResponseCallback(" + requestToCancel);
            HttpWebResponse response = null;
            ByteBuffer returnBuffer = null;
            Exception returnException = null;
            HttpWebRequest conn = requestToCancel.getConnection();

            try
            {
                response = (HttpWebResponse)conn.EndGetResponse(asynchronousResult);
                if (log.isDebugEnabled()) log.debug("status=" + response.StatusCode);
                if (response.StatusCode != HttpStatusCode.OK)
                {
                    requestToCancel.setAsyncResult(null, new BException(BExceptionC.IOERROR, "HTTP Status " + response.StatusCode));
                }
                else
                {
                    saveSession(conn);

                    if (log.isDebugEnabled()) log.debug("bufferFromStream");

                    Stream responseStream = response.GetResponseStream();
                    returnBuffer = bufferFromStream(responseStream, false);
                }

            }
            catch (WebException e)
            {

                BException bex = null;
                if (_cancelAllRequests)
                {
                    bex = new BException(BExceptionC.CANCELLED, "");
                }
                else
                {
                    if (e.Response != null)
                    {
                        int code = Convert.ToInt32(((HttpWebResponse)e.Response).StatusCode);
                        bex = new BException(code, "HTTP Status " + code);
                    }
                    else
                    {
                        int code = Convert.ToInt32(HttpStatusCode.BadRequest);
                        bex = new BException(code, e.ToString());
                    }
                }
                returnException = bex;
            }
            catch (Exception e)
            {
                if (log.isDebugEnabled()) log.debug("Exception", e);
                returnException = new BException(BExceptionC.IOERROR, e.Message, e);
            }
            finally
            {
                if (response != null) response.Close();

                removeRequest(requestToCancel, returnBuffer, returnException);
            }

            if (log.isDebugEnabled()) log.debug(")getResponseCallback");
        }

        void internalPutStream(RequestToCancel request)
        {
            long messageId = request.messageId;
            long streamId = request.streamId;
            Stream stream = request.stream;

            if (log.isDebugEnabled()) log.debug("internalPutStream(messageId=" + messageId + ", streamId=" + streamId + ", stream=" + stream);

            String contentType = null;
		    long contentLength = -1L;
            String contentDisposition = null;
		    if (stream is BContentStream) {
			    BContentStream cstream = (BContentStream)stream;
                contentType = cstream.ContentType;
                contentLength = cstream.ContentLength;
                contentDisposition = cstream.ContentDisposition;
		    }

            HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(url + "?messageid=" + messageId + "&streamid=" + streamId);
            request.setConnection(conn);

            conn.AllowWriteStreamBuffering = false;
            conn.Method = "PUT";
            conn.SendChunked = (contentLength == -1L);
            if (contentLength != -1L) conn.ContentLength = contentLength;
            conn.ContentType = contentType != null ? contentType : HConstants.DEFAULT_CONTENT_TYPE;
            if (contentDisposition != null) conn.Headers.Add("Content-Disposition", contentDisposition);
        
            applySession(conn);

            conn.BeginGetRequestStream(new AsyncCallback(this.getRequestStreamCallback), request);
            if (log.isDebugEnabled()) log.debug(")internalPutStream");
        }

        void internalSendCancelMessage(RequestToCancel request)
        {
            if (log.isDebugEnabled()) log.debug("internalSendCancelMessage(" + request);
            try
            {
                HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(request.wire.url + "?messageid=" + request.cancelMessageId + "&cancel=1");
                request.setConnection(conn);

                conn.Method = "GET";
                request.wire.applySession(conn);

                HttpWebResponse response = (HttpWebResponse)conn.GetResponse();
                response.Close();
            }
            catch (Exception e)
            {
                if (log.isDebugEnabled()) log.debug("received exception: " + e);
            }

            if (log.isDebugEnabled()) log.debug(")internalSendCancelMessage");
        }

        protected void applySession(HttpWebRequest conn)
        {
            conn.CookieContainer = cookieJar;
            conn.Credentials = CredentialCache.DefaultCredentials;
        }

        protected void saveSession(HttpWebRequest conn)
        {
            cookieJar = conn.CookieContainer;
        }

        protected class MyInputStream : InputStreamWrapper, BAsyncResultIF<BMessage>
        {
            Exception ex;
            RequestToCancel request;
            HttpWebResponse response;
            Stream responseStream;
            readonly HWireClient wire;

            public MyInputStream(HWireClient wire, BTargetId targetId)
                : base(targetId)
            {
                this.wire = wire;
            }

            protected override Stream openStream()
            {
                try 
                {
                    String url = wire.url + "?serverId=" + TargetId.getServerId() + "&messageid=" + TargetId.getMessageId() + "&streamid=" + TargetId.getStreamId();
                    HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(url);
                    request = wire.createRequestForGetStream(TargetId, this);
                    request.setConnection(conn);

                    conn.Method = "GET";
                    wire.applySession(conn);

                    response = (HttpWebResponse)conn.GetResponse();
                    ContentType = response.ContentType;
                    ContentLength = response.ContentLength;
                    ContentDisposition = response.Headers["Content-Disposition"];

                    responseStream = response.GetResponseStream();
                }
                catch (Exception ex)
                {
                    BException bex = new BException(BExceptionC.IOERROR, "", ex);
                    setAsyncResult(null, bex);
					wire.removeRequest(request, null, bex);
                }

                throwExceptionIf();

                return responseStream;
            }

            public override void Close()
            {
                if (response != null)
                {
                    response.Close();
                    response = null;
                }
                wire.removeRequest(request, null, ex);
            }

            public void setAsyncResult(BMessage msg, Exception ex)
            {
                if (ex != null)
                {
                    this.ex = ex;
                    this.request.cancel();
                    Close();
                }
            }

            void throwExceptionIf() 
            {
                Exception e = ex;
			    if (e == null) return;
			    if (e is IOException) {
				    throw (IOException)e;
			    }
			    else {
                    throw new BException(BExceptionC.CANCELLED, "", e);
			    }
		    }
        }

        public class RequestToCancel : BAsyncResultIF<ByteBuffer>
        {
            private Log log = LogFactory.getLog(typeof(RequestToCancel));
            public readonly long messageId;
            public readonly long streamId;
            public readonly ByteBuffer buf;
            public readonly BContentStream stream;
            public readonly long cancelMessageId;
            public readonly BAsyncResultIF<BMessage> asyncResult;
            public readonly HWireClient wire;
            public readonly int timeoutMillisClient;
            public readonly int timeoutMillisRequest;
		    private volatile bool _canceled;
            private int isOpen;

            private HttpWebRequest conn;
            private readonly long id;
            private static long requestCounter;

            public readonly ERequestDirection requestDirection;

            public RequestToCancel(HWireClient wire, 
                ERequestDirection requestDirection, 
                long messageId, 
                ByteBuffer buf, 
                BContentStream stream,
                long streamId, 
                long cancelMessageId, 
                int timeoutMillisClient, 
                int timeoutMillisRequest,
                BAsyncResultIF<BMessage> asyncResult) 
            {
                this.wire = wire;
                this.requestDirection = requestDirection;
                this.messageId = messageId;
                this.streamId = streamId;
                this.buf = buf;
                this.stream = stream;
                this.cancelMessageId = cancelMessageId;
                this.timeoutMillisClient = timeoutMillisClient;
                this.timeoutMillisRequest = timeoutMillisRequest;
                this.asyncResult = asyncResult;
                this.id = Interlocked.Increment(ref requestCounter);
		    }
		
		    public void setConnection(HttpWebRequest conn) {
			    if (log.isDebugEnabled()) log.debug("setConnection" + this + "(conn=" + conn);
                lock (this)
                {
                    throwIfCancelled();
                    this.conn = conn;
                    conn.Timeout = timeoutMillisClient;
                    conn.ReadWriteTimeout = timeoutMillisRequest;
                }
			    if (log.isDebugEnabled()) log.debug(")setConnection");
		    }

            public HttpWebRequest getConnection()
            {
                lock (this)
                {
                    return this.conn;
                }
            }
		
		    public void throwIfCancelled() {
                if (_canceled) throw new BException(BExceptionC.CANCELLED, "Request cancelled");
		    }

            public void run()
            {
                if (buf != null)
                {
                    wire.internalSend(this);
                }
                else if (stream != null)
                {
                    wire.internalPutStream(this);
                }
                else if (cancelMessageId != 0L)
                {
                    wire.internalSendCancelMessage(this);
                }
            }

            public void startTimeoutWatcher(HttpWebRequest conn, IAsyncResult result, int timeout)
            {
                ThreadPool.RegisterWaitForSingleObject(
                    result.AsyncWaitHandle,
                    new WaitOrTimerCallback(TimeoutCallback),
                    conn, 
                    timeout,
                    true);
            }

            private static void TimeoutCallback(object state, bool timedOut)
            {
                if (timedOut)
                {
                    HttpWebRequest conn = state as HttpWebRequest;
                    if (conn != null)
                    {
                        conn.Abort();
                    }
                }
            }

            public void setAsyncResult(ByteBuffer buf, Exception ex)
            {
                if (log.isDebugEnabled()) log.debug("setAsyncResult" + this + "(buf="  + buf + ", ex=" + ex);
                if (Interlocked.Increment(ref isOpen) == 1)
                {
                    try
                    {
                        if (ex == null && buf != null && buf.remaining() != 0)
                        {

                            BMessageHeader header = new BMessageHeader();

                            bool nego = BNegotiate.isNegotiateMessage(buf);
                            if (nego)
                            {
                                BNegotiate negoResponse = new BNegotiate();
                                negoResponse.read(buf);

                                header.messageId = messageId;

                                BTransport utransport = wire.getClientUtilityRequests().getTransport();
                                utransport.applyNegotiate(negoResponse);
                            }
                            else
                            {
                                header.read(buf);
                            }

                            BMessage msg = buf != null ? new BMessage(header, buf, null) : null;
                            if (log.isDebugEnabled()) log.debug("asyncResult.set");
                            asyncResult.setAsyncResult(msg, ex);
                        }
                        else
                        {
                            asyncResult.setAsyncResult(null, ex);
                        }
                    }
                    catch (Exception e)
                    {
                        asyncResult.setAsyncResult(null, e);
                    }
                }
                if (log.isDebugEnabled()) log.debug(")setAsyncResult");
            }

		    public void cancel() 
            {
                if (log.isDebugEnabled()) log.debug("cancel" + this + "(");
                _canceled = true;
                 done();
                if (log.isDebugEnabled()) log.debug(")cancel");
            }

            public bool isCanceled() 
            {
		        return _canceled;
            }
		
		    public void done() {
			    if (log.isDebugEnabled()) log.debug("done(" + this);
                HttpWebRequest c = this.conn;
                if (c != null)
                {
                    if (log.isDebugEnabled()) log.debug("WebRequest.Abort");
                    try { c.Abort(); }
                    catch (Exception) { }
                }
			    if (log.isDebugEnabled()) log.debug(")done");
		    }

            public long getId()
            {
                return id;
            }
		
		    public override String ToString() {
			    StringBuilder sbuf = new StringBuilder();
			    sbuf.Append("[").Append(messageId);
			    if (buf != null) sbuf.Append(",buf=").Append(buf);
                if (stream != null) sbuf.Append(",streamId=").Append(stream.TargetId.getStreamId());
			    if (cancelMessageId != 0) sbuf.Append(",cancelMessageId=").Append(cancelMessageId);
			    sbuf.Append(",conn=").Append(conn);
			    sbuf.Append("]");
			    return sbuf.ToString();
		    }

        }

        void addRequest(RequestToCancel robj) 
        {
            if (log.isDebugEnabled()) log.debug("addRequest(robj=" + robj);
            openRequestsToCancel[robj.getId()] = robj;
            if (log.isDebugEnabled()) log.debug(")addRequest=" + robj);
	    }

        void removeRequest(RequestToCancel robj, ByteBuffer buf, Exception ex) 
        {
            if (log.isDebugEnabled()) log.debug("removeRequest(" + robj);
            if (robj == null) return;
            RequestToCancel rtmp = null;
            openRequestsToCancel.TryRemove(robj.getId(), out rtmp);
            robj.done();
            robj.setAsyncResult(buf, ex);
            if (log.isDebugEnabled()) log.debug(")removeRequest");
	    }

        public override void cancelAllRequests()
        {
            internalCancelAllRequests(MESSAGEID_CANCEL_ALL_REQUESTS);
        }

        public override void done()
        {
            internalCancelAllRequests(MESSAGEID_DISCONNECT);
        }

        protected void internalCancelAllRequests(long cancelMessageId) 
        {
            if (log.isDebugEnabled()) log.debug("cancelAllRequests(");
	    	_cancelAllRequests = true;

            KeyValuePair<long, RequestToCancel>[] requests = openRequestsToCancel.ToArray();
            foreach (KeyValuePair<long, RequestToCancel> robj in requests)
            {
			    robj.Value.cancel();
		    }

            // Notify the server about the canceled messages
            if (cancelMessageId != 0)
            {
                sendCancelMessage(cancelMessageId);
            }

            if (log.isDebugEnabled()) log.debug(")cancelAllRequests");
	    }

	    protected void sendCancelMessage(long messageId) {
		    if (log.isDebugEnabled()) log.debug("sendCancelMessage(messageId=" + messageId);
            try
            {
                getClientUtilityRequests().BUtilityRequests.CancelMessage(messageId);
            }
            catch (Exception e)
            {
                log.warn("Exception", e);
            }
            if (log.isDebugEnabled()) log.debug(")sendCancelMessage");
	    }
	

        protected void cancelMessage(long messageId) {
		    if (log.isDebugEnabled()) log.debug("cancelMessage(" + messageId);
		
            KeyValuePair<long, RequestToCancel>[] requests = openRequestsToCancel.ToArray();
            foreach (KeyValuePair<long, RequestToCancel> robj in requests)
            {
                if (robj.Value.messageId == messageId) 
                {
			        robj.Value.cancel();
                }
		    }

		    if (log.isDebugEnabled()) log.debug(")cancelMessage");
	    }

        public override BTestAdapter getTestAdapter()
        {
            return testAdapterVal;
        }

       	internal String testAdapter(String fnct, String[] args) {
		    if (log.isDebugEnabled()) log.debug("testAdapter(fnct=" + fnct + ", " + args);
		
		    if (fnct.Equals(HTestAdapter.KILL_CONNECTIONS)) {
			    internalCancelAllRequests(0L);
			    return "";
		    }
		
            String ret = "";
            HttpWebResponse response = null;

            try 
            {
                StringBuilder uparams = new StringBuilder();
				if (args != null) {
					foreach (String arg in args) {
						uparams.Append("&").Append(arg);
					}
				}
				
				String surl = this.url + "?testAdapter=" + fnct + uparams;

                HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(surl);
                conn.Method = "GET";
                applySession(conn);

                response = (HttpWebResponse)conn.GetResponse();
                Stream responseStream = response.GetResponseStream();
				ByteBuffer buf = bufferFromStream(responseStream, false);
				if (buf != null) {
                    ret = Encoding.UTF8.GetString(buf.array(), buf.position(), buf.remaining());
				}

		    }
		    finally {
                if (response != null)
                {
                    response.Close();
                }
            }
		    if (log.isDebugEnabled()) log.debug(")testAdapter=" + ret);
		    return ret;
	    }

        public virtual String getServletPathForNegotiationAndAuthentication()
        {
            String authUrl = url;
            int p = authUrl.LastIndexOf('/');
            if (p >= 0)
            {
                authUrl = authUrl.Substring(p);
            }
            return authUrl;
        }

        public virtual String getServletPathForReverseRequest()
        {
            String authUrl = url;
            int p = authUrl.LastIndexOf('/');
            if (p >= 0)
            {
                authUrl = authUrl.Substring(p);
            }
            return authUrl;
        }

        private String makeUrl(String servletPath, String[] params1) 
        {
            StringBuilder sbuf = new StringBuilder();
            int p = url.LastIndexOf("/");
            if (p < 0) p = url.Length;
            sbuf.Append(url.Substring(0, p));
            sbuf.Append(servletPath);
            if (params1 != null) 
            {
                for (int i = 0; i < params1.Length; i += 2)
                {
                    sbuf.Append(i == 0 ? "?" : "&");
                    sbuf.Append(params1[i]);
                    sbuf.Append("=");
                    sbuf.Append(params1[i + 1]);
                }
            }
            return sbuf.ToString();
	    }

        public BClient_BUtilityRequests getClientUtilityRequests()
        {
            if (clientUtilityRequests == null)
            {
                BApiDescriptor apiDesc = BApiDescriptor_BUtilityRequests.instance;
                BTransportFactory transportFactory = new HTransportFactoryClient(apiDesc, this, 0);
                clientUtilityRequests = BClient_BUtilityRequests.createClient(transportFactory);
            }
            return clientUtilityRequests;
        }
  
    public String getHttpSession()
    {
      Cookie cookie = getHttpCookie(HConstants.HTTP_COOKIE_JSESSIONID);
      return cookie != null ? cookie.Value : "";
    }

    /// <summary>
    /// Get HTTP session cookie.
    /// </summary>
    /// <remarks>
    /// Gets the cookie with the given name.
    /// </remarks>
    /// <param name="name">Cookie name, e.g. HConstants.HTTP_COOKIE_JSESSIONID</param>
    /// <returns>Session cookie.</returns>
    public Cookie getHttpCookie(String name)
    {
      Cookie ret = null;
      CookieCollection cookies = cookieJar.GetCookies(new Uri(url));
      foreach (Cookie c in cookies)
      {
        if (c.Name.Equals(name))
        {
          ret = c;
          break;
        }
      }
      return ret;
    }

    /// <summary>
    /// Set HTTP cookie.
    /// </summary>
    /// <remarks>
    /// Adds or replaces a HTTP cookie. Ensure that at least Name, Value, Domain, Path are set in the given cookie.
    /// </remarks>
    /// <param name="cookie">Session cookie.</param>
    public void setHttpCookie(Cookie cookie)
    {
      if (cookie != null)
      {
        Cookie oldCookie = getHttpCookie(cookie.Name);
        if (oldCookie != null)
        {
          
          // Since there is no function to remove a cookie, 
          // create a new container and copy all cookies except the old one.

          Uri uri = new Uri(url);
          CookieContainer newCookieContainer = new CookieContainer();
          foreach (Cookie c in cookieJar.GetCookies(uri))
          {
            if (!c.Name.Equals(cookie.Name))
            {
              newCookieContainer.Add(c);
            }
          }

          cookieJar = newCookieContainer;
        }

        cookieJar.Add(cookie);
      }
    }

    protected readonly static long MESSAGEID_CANCEL_ALL_REQUESTS = -1;
        protected readonly static long MESSAGEID_DISCONNECT = -2;
        protected String url;
	    protected readonly static int CHUNK_SIZE = 10 * 1000;
	    protected bool compressStream = false;
	    private volatile bool _cancelAllRequests;
        readonly ConcurrentDictionary<long, RequestToCancel> openRequestsToCancel = new ConcurrentDictionary<long, RequestToCancel>();
        protected CookieContainer cookieJar = new CookieContainer();
        protected readonly BTestAdapter testAdapterVal;
        protected int timeoutMillisClient;
        private Log log = LogFactory.getLog(typeof(HWireClient));
        public enum ERequestDirection { FORWARD, REVERSE };
        private BClient_BUtilityRequests clientUtilityRequests;
    }
}
