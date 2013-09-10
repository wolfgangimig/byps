using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class HWireClient : BWire
    {
        public HWireClient(String url, BWireFlags flags, int timeoutSeconds)
            : base(flags)
        {
            this.url = url;
            this.timeoutMillisClient = timeoutSeconds * 1000;
            this._testAdapter = new HTestAdapter(this);
        }

	    private class AsyncResultAfterAllRequests : BAsyncResult<BMessage> 
        {
            readonly HWireClient wire;
            readonly long messageId;
		    BAsyncResult<BMessage> innerResult;
            int nbOfOutstandingResults;
            int nbOfResults;
            volatile BMessage result;
		    Exception ex;

            public AsyncResultAfterAllRequests(HWireClient wire, long messageId, BAsyncResult<BMessage> asyncResult, int nbOfRequests)
            {
                this.wire = wire;
                this.messageId = messageId;
			    this.innerResult = asyncResult;
                this.nbOfOutstandingResults = this.nbOfResults = nbOfRequests;
		    }

		    public void setAsyncResult(BMessage msg, Exception ex) {
                bool cancelMessage = false;
			    if (ex != null) {
                    cancelMessage = Interlocked.Exchange(ref this.ex, ex) == null;
			    }
                if (msg != null && msg.buf != null && msg.buf.remaining() != 0)
                {
                    this.result = msg;
                }
			
			    if (Interlocked.Decrement(ref nbOfOutstandingResults) == 0) {
                    innerResult.setAsyncResult(this.result, this.ex);
			    }

                if (cancelMessage)
                {
                    wire.sendCancelMessage(messageId);
                }
		    }

	    }

        public override void send(BMessage msg, BAsyncResult<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult, timeoutMillisClient);
        }

        public override void sendR(BMessage msg, BAsyncResult<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult, int.MaxValue);
        }

        protected void internalSend(BMessage msg, BAsyncResult<BMessage> asyncResult, int timeoutMillis)
        {
		    if (log.isDebugEnabled()) log.debug("send(" + msg + ", asyncResult=" + asyncResult);

		    // Convert the BMessage into single RequestToCancel objects.
		    // One RequestToCancel is created for msg.buf.
		    // For each stream in msg.streams further RequestToCancel objects are created.
		
		    int nbOfRequests = 1 + (msg.streams != null ? msg.streams.Count : 0);
		    List<RequestToCancel> requests = new List<RequestToCancel>(nbOfRequests);
		
		    // If the BMessage contains streams, the given asyncResult is wrapped into an
		    // outerResult in order to pass only the first exception to the caller. 
		    BAsyncResult<BMessage> outerResult = asyncResult;
		    if (nbOfRequests > 1) {
			    if (log.isDebugEnabled()) log.debug("wrap asyncResult");
			    outerResult = new AsyncResultAfterAllRequests(this, msg.messageId, asyncResult, nbOfRequests);
		    }
	
		    // Create RequestToCancel for msg.buf
		    RequestToCancel req = createRequestForMessage(msg.messageId, timeoutMillis, msg.buf, outerResult);
		    requests.Add(req);
		
		    // Create RequestToCancel objects for each stream.
		    if (msg.streams != null) {
			    foreach (BStreamRequest stream in msg.streams) {
				    req = createRequestForPutStream(msg.messageId, stream, outerResult);
				    requests.Add(req);
			    }
		    }

		    // Execute the RequestToCancel objects in the thread pool
		    if (log.isDebugEnabled()) log.debug("put requests into thread pool");
		    foreach (RequestToCancel r in requests) {
			    if (!executeRequest(r)) {
				    cancelMessage(msg.messageId);
				    break;
			    }
		    }
		
		    if (log.isDebugEnabled()) log.debug(")send");
	    }

	    public override void putStreams(List<BStreamRequest> streamRequests, BAsyncResult<BMessage> asyncResult1) {
		    throw new InvalidOperationException("putStreams is only for the server side");
	    }
	
	    protected RequestToCancel createRequestForMessage(long messageId, int timeoutMillis, ByteBuffer buf, BAsyncResult<BMessage> asyncResult) {
		    RequestToCancel r =  new RequestToCancel(this, messageId, buf, null, 0L, 0L,
                timeoutMillisClient, timeoutMillis, asyncResult);
		    addRequest(r);
		    return r;
	    }
	
	    protected RequestToCancel createRequestForPutStream(long messageId, BStreamRequest streamRequest, BAsyncResult<BMessage> asyncResult) {
            RequestToCancel r = new RequestToCancel(this, messageId, null, streamRequest, streamRequest.streamId, 0L, 
                timeoutMillisClient, timeoutMillisClient, asyncResult);
		    addRequest(r);
		    return r;
	    }

        protected RequestToCancel createRequestForGetStream(long messageId, long streamId, BAsyncResult<BMessage> asyncResult) {
            RequestToCancel r = new RequestToCancel(this, messageId, null, null, streamId, 0L, 
                timeoutMillisClient, timeoutMillisClient, asyncResult);
		    addRequest(r);
		    return r;
	    }

        protected class CancelResult : BAsyncResult<BMessage> {
			public void setAsyncResult(BMessage msg, Exception e) {}
        }
	
	    protected RequestToCancel createRequestForCancelMessage(long messageId) {
            RequestToCancel r = new RequestToCancel(this, 0L, null, null, 0L, messageId, 
                timeoutMillisClient, timeoutMillisClient, new CancelResult());
		    addRequest(r);
		    return r;
	    }

        protected bool executeRequest(RequestToCancel r)
        {
            if (log.isDebugEnabled()) log.debug("executeRequest(" + r);
            r.run();
            if (log.isDebugEnabled()) log.debug(")executeRequest=true");
            return true;
        }

        protected void internalSend(RequestToCancel request)
        {
            if (log.isDebugEnabled()) log.debug("internalSend(" + request);
            ByteBuffer buf = request.buf;

            bool isNegotiate = BNegotiate.isNegotiateMessage(buf);
            bool isJson = isNegotiate || BMessageHeader.detectProtocol(buf) == BMessageHeader.MAGIC_JSON;

            HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(url);
            request.setConnection(conn);
            conn.ContentType = isJson ? "application/json" : "application/octet-stream";
            conn.Method = "POST";
 
            conn.Accept = "application/json, application/byps, text/plain, text/html";
            if ((this.flags & BWireFlags.GZIP) != 0) conn.Headers.Add("Accept-Encoding", "gzip");

            applySession(conn);

            conn.BeginGetRequestStream(new AsyncCallback(this.getRequestStreamCallback), request);

            if (log.isDebugEnabled()) log.debug(")internalSend");
        }

        public override Stream getStream(long messageId, long streamId)
        {
 		    Stream strm = new MyInputStream(this, messageId, streamId);
            return strm;
        }

        protected void getRequestStreamCallback(IAsyncResult asynchronousResult)
        {
            RequestToCancel requestToCancel = (RequestToCancel)asynchronousResult.AsyncState;
            if (log.isDebugEnabled()) log.debug("getRequestStreamCallback(" + requestToCancel);
            try
            {
                HttpWebRequest conn = requestToCancel.conn;
                Stream postStream = conn.EndGetRequestStream(asynchronousResult);
                if (requestToCancel.buf != null)
                {
                    if (log.isDebugEnabled()) log.debug("bufferToStream");
                    bufferToStream(requestToCancel.buf, postStream);
                }
                else if (requestToCancel.streamRequest != null)
                {
                    if (log.isDebugEnabled()) log.debug("copy stream");
                    requestToCancel.streamRequest.strm.CopyTo(postStream);
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
                    bex = new BException(BExceptionC.CANCELED, "");
                }
                else
                {
                    bex = new BException(BExceptionC.IOERROR, e.Message, e);
                }
                removeRequest(requestToCancel, null, bex);
            }
            finally
            {
                if (requestToCancel.streamRequest != null)
                {
                    requestToCancel.streamRequest.strm.Close();
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

            try
            {
                HttpWebRequest conn = requestToCancel.conn;
                response = (HttpWebResponse)conn.EndGetResponse(asynchronousResult);
                if (log.isDebugEnabled()) log.debug("status=" + response.StatusCode);
                if (response.StatusCode != HttpStatusCode.OK)
                {
                    requestToCancel.setAsyncResult(null, new BException(BExceptionC.IOERROR, "HTTP Status " + response.StatusCode));
                }
                else
                {
                    saveSession(requestToCancel.conn);

                    if (log.isDebugEnabled()) log.debug("bufferFromStream");

                    bool gzip = response.ContentEncoding.Equals("gzip");

                    Stream responseStream = response.GetResponseStream();
                    returnBuffer = bufferFromStream(responseStream, gzip);
                }

            }
            catch (Exception e)
            {
                if (log.isDebugEnabled()) log.debug("Exception", e);
                BException bex = null;
                if (_cancelAllRequests)
                {
                    bex = new BException(BExceptionC.CANCELED, "");
                }
                else
                {
                    bex = new BException(BExceptionC.IOERROR, e.Message, e);
                }
                returnException = bex;
            }
            finally
            {
                if (response != null) response.Close();

                removeRequest(requestToCancel, returnBuffer, returnException);
            }

            if (log.isDebugEnabled()) log.debug(")getResponseCallback");
        }

        protected void internalPutStream(RequestToCancel request)
        {
            long messageId = request.messageId;
            long streamId = request.streamId;
            Stream stream = request.streamRequest.strm;

            if (log.isDebugEnabled()) log.debug("internalPutStream(messageId=" + messageId + ", streamId=" + streamId + ", stream=" + stream);

            String contentType = null;
		    long contentLength = -1L;
		    if (stream is BContentStream) {
			    BContentStream cstream = (BContentStream)stream;
                contentType = cstream.ContentType;
                contentLength = cstream.ContentLength;
		    }

            HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(url + "?messageid=" + messageId + "&streamid=" + streamId);
            request.setConnection(conn);

            conn.AllowWriteStreamBuffering = false;
            conn.ContentType = contentType != null ? contentType : HConstants.DEFAULT_CONTENT_TYPE;
            conn.Method = "PUT";
            conn.SendChunked = (contentLength == -1L);
            if (contentLength != -1L) conn.ContentLength = contentLength;

            applySession(conn);

            conn.BeginGetRequestStream(new AsyncCallback(this.getRequestStreamCallback), request);
            if (log.isDebugEnabled()) log.debug(")internalPutStream");
        }

        protected void internalSendCancelMessage(RequestToCancel request)
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

        protected class MyInputStream : InputStreamWrapper, BAsyncResult<BMessage>
        {
            Exception ex;
            RequestToCancel request;
            HttpWebResponse response;
            Stream responseStream;
            String contentType;
            long contentLength;
            readonly HWireClient wire;

            public MyInputStream(HWireClient wire, long messageId, long streamId)
                : base(messageId, streamId)
            {
                this.wire = wire;
            }

            protected override Stream openStream()
            {
                try 
                {
                    HttpWebRequest conn = (HttpWebRequest)HttpWebRequest.Create(wire.url + "?messageid=" + messageId + "&streamid=" + streamId);
                    request = wire.createRequestForGetStream(messageId, streamId, this);
                    request.setConnection(conn);

                    conn.Method = "GET";
                    wire.applySession(conn);

                    response = (HttpWebResponse)conn.GetResponse();
                    contentType = response.ContentType;
                    contentLength = response.ContentLength;
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
                base.Close();
                if (response != null)
                {
                    response.Close();
                    response = null;
                }
                wire.removeRequest(request, null, ex);
            }

		    public override long ContentLength 
            {
                get 
                {
			        try 
                    {
				        ensureStream();
				        return contentLength;
			        } catch (IOException e) 
                    {
				        throw new InvalidOperationException(e.ToString());
			        }
		        }
            }

            public override String ContentType
            {
                get
                {
                    try
                    {
                        ensureStream();
                        return contentType;
                    }
                    catch (IOException e)
                    {
                        throw new InvalidOperationException(e.ToString());
                    }
                }
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
				    throw new BException(BExceptionC.CANCELED, "", e);
			    }
		    }
        }

        protected class RequestToCancel : BAsyncResult<ByteBuffer>
        {
            private Log log = LogFactory.getLog(typeof(RequestToCancel));
            public readonly long messageId;
            public readonly long streamId;
            public readonly ByteBuffer buf;
            public readonly BStreamRequest streamRequest;
            public readonly long cancelMessageId;
            public readonly BAsyncResult<BMessage> asyncResult;
            public readonly HWireClient wire;
            public readonly int timeoutMillisClient;
            public readonly int timeoutMillisRequest;
		    protected volatile bool _canceled;
            protected int isOpen;

            public volatile HttpWebRequest conn;
            protected readonly long id;
            private static long requestCounter;

            public RequestToCancel(HWireClient wire, long messageId, ByteBuffer buf, BStreamRequest streamRequest,
                long streamId, long cancelMessageId, int timeoutMillisClient, int timeoutMillisRequest,
                BAsyncResult<BMessage> asyncResult) 
            {
                this.wire = wire;
                this.messageId = messageId;
                this.streamId = streamId;
                this.buf = buf;
                this.streamRequest = streamRequest;
                this.cancelMessageId = cancelMessageId;
                this.timeoutMillisClient = timeoutMillisClient;
                this.timeoutMillisRequest = timeoutMillisRequest;
                this.asyncResult = asyncResult;
                this.id = Interlocked.Increment(ref requestCounter);
		    }
		
		    public void setConnection(HttpWebRequest conn) {
			    if (log.isDebugEnabled()) log.debug("setConnection" + this + "(conn=" + conn);
                throwIfCancelled();
                this.conn = conn;
                conn.Timeout = timeoutMillisClient;
                conn.ReadWriteTimeout = timeoutMillisRequest;
			    if (log.isDebugEnabled()) log.debug(")setConnection");
		    }
		
		    public void throwIfCancelled() {
                if (_canceled) throw new BException(BExceptionC.CANCELED, "Request cancelled");
		    }

            public void run()
            {
                if (buf != null)
                {
                    wire.internalSend(this);
                }
                else if (streamRequest != null)
                {
                    wire.internalPutStream(this);
                }
                else if (cancelMessageId != 0L)
                {
                    wire.internalSendCancelMessage(this);
                }
            }

            public void setAsyncResult(ByteBuffer buf, Exception ex)
            {
                if (log.isDebugEnabled()) log.debug("setAsyncResult" + this + "(");
                if (Interlocked.Increment(ref isOpen) == 1)
                {
                    BMessage msg = buf != null ? new BMessage(messageId, buf, null) : null;
                    asyncResult.setAsyncResult(msg, ex);
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
			    if (streamRequest != null) sbuf.Append(",streamId=").Append(streamRequest.streamId);
			    if (cancelMessageId != 0) sbuf.Append(",cancelMessageId=").Append(cancelMessageId);
			    sbuf.Append(",conn=").Append(conn);
			    sbuf.Append("]");
			    return sbuf.ToString();
		    }

        }

        protected void addRequest(RequestToCancel robj) 
        {
            if (log.isDebugEnabled()) log.debug("addRequest(robj=" + robj);
            openRequestsToCancel[robj.getId()] = robj;
            if (log.isDebugEnabled()) log.debug(")addRequest=" + robj);
	    }

        protected void removeRequest(RequestToCancel robj, ByteBuffer buf, Exception ex) 
        {
            if (log.isDebugEnabled()) log.debug("removeRequest(" + robj);
            if (robj == null) return;
            openRequestsToCancel.TryRemove(robj.getId(), out robj);
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
			RequestToCancel r = createRequestForCancelMessage(messageId);
			executeRequest(r);
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
            return _testAdapter;
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

        protected readonly static long MESSAGEID_CANCEL_ALL_REQUESTS = -1;
        protected readonly static long MESSAGEID_DISCONNECT = -2;
        protected String url;
	    protected readonly static int CHUNK_SIZE = 10 * 1000;
	    protected bool compressStream = false;
	    protected volatile bool _cancelAllRequests;
        protected readonly ConcurrentDictionary<long, RequestToCancel> openRequestsToCancel = new ConcurrentDictionary<long, RequestToCancel>();
        protected CookieContainer cookieJar = new CookieContainer();
        protected readonly BTestAdapter _testAdapter;
        protected int timeoutMillisClient;
        private Log log = LogFactory.getLog(typeof(HWireClient));
    }
}
