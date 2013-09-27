package com.wilutions.byps.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BAsyncResult;
import com.wilutions.byps.BBufferJson;
import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.BMessage;
import com.wilutions.byps.BMessageHeader;
import com.wilutions.byps.BNegotiate;
import com.wilutions.byps.BStreamRequest;
import com.wilutions.byps.BTestAdapter;
import com.wilutions.byps.BWire;

public class HWireClient extends BWire {
	
	protected final static long MESSAGEID_CANCEL_ALL_REQUESTS = -1;
	protected final static long MESSAGEID_DISCONNECT = -2;

	protected final String surl;
	protected final static int CHUNK_SIZE = 10 * 1000;
	protected final static int MAX_STREAM_PART_SIZE = 1000 * CHUNK_SIZE; // should be a multiple of CHUNK_SIZE
	protected final Log log = LogFactory.getLog(HWireClient.class);
//	protected final ConcurrentHashMap<RequestToCancel, Boolean> openRequestsToCancel = new ConcurrentHashMap<RequestToCancel, Boolean>();
	protected final Map<RequestToCancel, Boolean> openRequestsToCancel = Collections.synchronizedMap(new HashMap<RequestToCancel, Boolean>());
	protected final Executor threadPool;
	protected final boolean isMyThreadPool;
	protected final HTestAdapter testAdapter;
	protected volatile boolean cancelAllRequests;
	protected volatile boolean isDone;
	
	protected Statistics stats = null;
	
	protected long timeoutMillisClient;

	/**
	 * Initializes a new client-side HTTP communication.
	 * @param url URL to server.
	 * @param flags A combination of BWire.FLAG_* values.
	 * @param timeoutSeconds Read timeout in seconds. A timeout of zero is interpreted as an infinite timeout. 
	 * @param cookieManager Optional: A CookieManager. If null, a CookieManager is internally created.
	 * @param threadPool Optional: A thread pool. If null, a thread pool is internally created.
	 * @see BWire#FLAG_GZIP
	 */
	public HWireClient(String url, int flags, int timeoutSeconds, CookieManager cookieManager, Executor threadPool) {
		super(flags);
		
		if (url == null || url.length() == 0) throw new IllegalStateException("Missing URL");
		
		this.surl = url;
		this.timeoutMillisClient = (long)timeoutSeconds * 1000L; 
		
		this.isMyThreadPool = threadPool == null;
		if (threadPool == null) {
			threadPool = Executors.newCachedThreadPool();
		}
		this.threadPool = threadPool;
	
		this.testAdapter = new HTestAdapter(this);
		
		// Wenn die Anwendung als Java Webstart gestartet wird, dann bekommt Sie 
		// einen CookieHandler zugeordnet, der alle Set-Cookie Header aus der
		// HttpURLConnection herausnimmt. Die JSESSIONID kann dann hier nicht mehr ausgelesen werden.
		// Der CookieHander steckt in CookieHandler.getDefault(). Dort kann die JSESSIONID
		// abgeholt werden - sofern ich sie brauche.
		
		if (cookieManager == null) {
		  cookieManager = new CookieManager();
		  cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		}
		setSessionContext(cookieManager);
	}
	
	protected class AsyncResultAfterAllRequests implements BAsyncResult<BMessage> {
		final BAsyncResult<BMessage> innerResult;
		final AtomicInteger nbOfOutstandingResults;
		final long messageId;
		volatile BMessage result;
		final AtomicReference<Throwable> ex = new AtomicReference<Throwable>();
		
		public AsyncResultAfterAllRequests(long messageId, BAsyncResult<BMessage> asyncResult, final int nbOfRequests) {
			this.innerResult = asyncResult;
			this.nbOfOutstandingResults = new AtomicInteger(nbOfRequests);
			this.messageId = messageId;
		}

		@Override
		public void setAsyncResult(BMessage msg, Throwable e) {
			if (log.isDebugEnabled()) log.debug("setAsyncResult(msg=" + msg+ ", ex=" + e);
			boolean cancelMessage = false;
			
			if (e != null) {
				cancelMessage = ex.compareAndSet(null, e);
			}
			if (msg != null && msg.buf != null) {
				if (log.isDebugEnabled()) log.debug("set result");
				this.result = msg;
			}
			
			if (nbOfOutstandingResults.decrementAndGet() == 0) {
				if (log.isDebugEnabled()) log.debug("innerResult.setAsyncResult(result=" + result + ", ex=" + ex);
				innerResult.setAsyncResult(result, ex.get());
			}
			
			if (log.isDebugEnabled()) log.debug("cancelMessage=" + cancelMessage);
			if (cancelMessage) {
				sendCancelMessage(messageId);
			}
			
			if (log.isDebugEnabled()) log.debug(")setAsyncResult");
		}

	}
	
	@Override
	public synchronized void send(final BMessage msg, final BAsyncResult<BMessage> asyncResult) {
		internalSendMessageAndStreams(msg, asyncResult, this.timeoutMillisClient);
	}
	
	@Override
	public void sendR(BMessage msg, BAsyncResult<BMessage> asyncResult) {
		internalSendMessageAndStreams(msg, asyncResult, 0);
	}

	protected void executeRequest(RequestToCancel r) throws BException {
		if (log.isDebugEnabled()) log.debug("executeRequest(" + r);
		
		if (isDone) {
			BException e = new BException(BExceptionC.CANCELLED, "HTTP Client already disconnected.");
			throw e;
		}
		
		for (int retry = 0; retry < 10 && !isDone; retry++) {
			try {
				threadPool.execute(r);
				if (log.isDebugEnabled()) log.debug(")executeRequest");
				return;
			}
			catch (RejectedExecutionException e) {
				if (log.isDebugEnabled()) log.debug("rejected execution, thread pool exausted? retry=" + retry);
				int retryAfterMillis = rand.nextInt(100);
				try {
					Thread.sleep((long)retryAfterMillis);
				} catch (InterruptedException e1) {
					break;
				}
			}
		}

		BException e = new BException(BExceptionC.TOO_MANY_REQUESTS, "Failed to send method or stream because to many requests are currently active.");
		throw e;
	}
	
	@Override
	public void putStreams(List<BStreamRequest> streamRequests, BAsyncResult<BMessage> asyncResult) {
		try {
			for (BStreamRequest stream : streamRequests) {
				RequestToCancel req = createRequestForPutStream(stream.messageId, stream, asyncResult);
				executeRequest(req);
			}
		}
		catch (BException e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	protected synchronized void internalSendMessageAndStreams(final BMessage msg, final BAsyncResult<BMessage> asyncResult, long timeout) {
		if (log.isDebugEnabled()) log.debug("send(" + msg + ", asyncResult=" + asyncResult);

		try {
			
			// If the BMessage contains streams, the given asyncResult is wrapped into a
			// BAsyncRequest object that sets the asynchronous result after the message and all streams
			// have been sent.
			BAsyncResult<BMessage> outerResult = asyncResult;
			if (msg.streams != null && msg.streams.size() != 0) {
				if (log.isDebugEnabled()) log.debug("wrap asyncResult");
				outerResult = new AsyncResultAfterAllRequests(msg.header.messageId, asyncResult, msg.streams.size() + 1);
			}
		
			// Create RequestToCancel for message
			RequestToCancel req = createRequestForMessage(msg.header.messageId, timeout, msg.buf, outerResult);
			executeRequest(req);
			
			// Create RequestToCancel objects for each stream.
			if (msg.streams != null && msg.streams.size() != 0) {
				putStreams(msg.streams, outerResult);
			}
			
		}
		catch (BException e) {
			asyncResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")send");
	}
	
	@SuppressWarnings("unused")
	private synchronized void internalSendStreamsThenMessage(final BMessage msg, final BAsyncResult<BMessage> asyncResult, final long timeout) {
		if (log.isDebugEnabled()) log.debug("internalSendStreamsThenMessage(" + msg + ", asyncResult=" + asyncResult);

		// Convert the BMessage into RequestToCancel objects.
		// One RequestToCancel is created for msg.buf.
		// For each stream in msg.streams further RequestToCancel objects are created.
		
		int nbOfStreams = msg.streams != null ? msg.streams.size() : 0;
		final ArrayList<RequestToCancel> requests = new ArrayList<RequestToCancel>(nbOfStreams != 0 ? nbOfStreams : 1);
		
		// Does the message contains streams?
		if (nbOfStreams != 0) {

			// Send the streams first and then send the message.
			// If the message is sent before the streams, 
			// a timeout happens for the message if it takes 
			// more than timeoutMillisRequest to send the streams.
			
			// Create an BAsyncResult that sends the message on setAsyncResult
			BAsyncResult<BMessage> asyncSendMessage = new BAsyncResult<BMessage>() {
				@Override
				public void setAsyncResult(BMessage result, Throwable exception) {
					if (exception != null) {
						asyncResult.setAsyncResult(null, exception);
					}
					else {
						// Send the message 
						try {
							RequestToCancel messageRequest = createRequestForMessage(msg.header.messageId, timeout, msg.buf, asyncResult);
							requests.add(messageRequest);
							executeRequest(messageRequest);
						} catch (BException e) {
							asyncResult.setAsyncResult(null, e);
						}
					}
				}
			};

			// Create requests for each stream
			BAsyncResult<BMessage> outerResult = new AsyncResultAfterAllRequests(msg.header.messageId, asyncSendMessage, nbOfStreams);
			for (BStreamRequest stream : msg.streams) {
				RequestToCancel streamRequest = createRequestForPutStream(msg.header.messageId, stream, outerResult);
				requests.add(streamRequest);
			}
			
		}
		else {
			// Create RequestToCancel for msg.buf
			RequestToCancel req = createRequestForMessage(msg.header.messageId, timeout, msg.buf, asyncResult);
			requests.add(req);
		}
		
		// Execute the RequestToCancel objects in the thread pool
		if (log.isDebugEnabled()) log.debug("put requests into thread pool");
		try {
			for (RequestToCancel r : requests) {
				executeRequest(r);
			}
		}
		catch (BException e) {
			asyncResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")internalSendStreamsThenMessage");
	}

	protected RequestToCancel createRequestForMessage(long messageId, long timeout, ByteBuffer buf, BAsyncResult<BMessage> asyncResult) {
		RequestToCancel r =  new RequestToCancel(messageId, buf, null, 0L, 0L, timeout, asyncResult);
		addRequest(r);
		return r;
	}
	
	protected RequestToCancel createRequestForPutStream(long messageId, BStreamRequest streamRequest, BAsyncResult<BMessage> asyncResult) {
		RequestToCancel r = new RequestToCancel(messageId, null, streamRequest, streamRequest.streamId, 0L, this.timeoutMillisClient, asyncResult);
		addRequest(r);
		return r;
	}
	
	protected RequestToCancel createRequestForGetStream(long messageId, long streamId, BAsyncResult<BMessage> asyncResult) {
		RequestToCancel r = new RequestToCancel(messageId, null, null, streamId, 0L, this.timeoutMillisClient, asyncResult);
		addRequest(r);
		return r;
	}
	
	protected RequestToCancel createRequestForCancelMessage(long messageId) {
		RequestToCancel r = new RequestToCancel(0L, null, null, 0L, messageId, this.timeoutMillisClient, new BAsyncResult<BMessage>() {
			public void setAsyncResult(BMessage msg, Throwable e) {}
		});
		addRequest(r);
		return r;
	}

	protected class RequestToCancel implements Runnable, BAsyncResult<ByteBuffer>, Comparable<RequestToCancel> {
		
		final long messageId;
		final long streamId;
		final ByteBuffer buf;
		final BStreamRequest streamRequest;
		final long cancelMessageId;
		final BAsyncResult<BMessage> asyncResult;
		final AtomicBoolean isOpen = new AtomicBoolean(true);
		final long timeoutMillisRequest;

		volatile boolean _canceled;
		AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
		
		protected RequestToCancel(long messageId, ByteBuffer buf, BStreamRequest streamRequest,
				long streamId, long cancelMessageId, long timeout, BAsyncResult<BMessage> asyncResult) {
			this.messageId = messageId;
			this.streamId = streamId;
			this.buf = buf;
			this.streamRequest = streamRequest;
			this.cancelMessageId = cancelMessageId;
			this.timeoutMillisRequest = timeout;
			this.asyncResult = asyncResult;
		}

		public void setConnection(HttpURLConnection conn) throws BException {
			if (log.isDebugEnabled()) log.debug("setConnection" + this + "(conn=" + System.identityHashCode(conn));
			throwIfCancelled();
			this.conn.set(conn);
			if (log.isDebugEnabled()) log.debug(")setConnection");
		}
		
		public void throwIfCancelled() throws BException {
			if (_canceled) throw new BException(BExceptionC.CANCELLED, "Request cancelled");
		}
		
		@Override
		public void run() {
			if (buf != null) {
				internalSend(this);
			}
			else if (streamRequest != null) {
				internalPutStream(this);
			}
			else if (cancelMessageId != 0L) {
				internalSendCancelMessage(this);
			}
		}
		
		public void setAsyncResult(ByteBuffer buf, Throwable e) {
			if (log.isDebugEnabled()) log.debug("setAsyncResult" + this + "(");
			if (isOpen.getAndSet(false)) {
				if (e == null && buf != null) {
					BMessageHeader header = new BMessageHeader();
					try {
						if (BNegotiate.isNegotiateMessage(buf)) {
							header.messageId = messageId;
						}
						else {
							header.read(buf);
						}
						BMessage msg = new BMessage(header, buf, null);
						asyncResult.setAsyncResult(msg, null);
					} catch (BException ex) {
						asyncResult.setAsyncResult(null, ex);
					}
				}
				else {
					asyncResult.setAsyncResult(null, e);
				}
			}
			if (log.isDebugEnabled()) log.debug(")setAsyncResult");
		}
		
		public void cancel() {
			if (log.isDebugEnabled()) log.debug("cancel" + this + "(");
			_canceled = true;
			done();
			if (log.isDebugEnabled()) log.debug(")cancel");
		}
		
		public boolean isCanceled() {
			return _canceled;
		}
		
		public void done() {
			if (log.isDebugEnabled()) log.debug("done(" + this);
			HttpURLConnection c = conn.getAndSet(null);
			if (c != null) {
			  if(log.isDebugEnabled()) log.debug("disconnect");
				c.disconnect();
				c = null;
			}
			if (log.isDebugEnabled()) log.debug(")done");
		}
		
		

		@Override
		public int compareTo(RequestToCancel o) {
			if (messageId < o.messageId) return -1;
			if (messageId > o.messageId) return 1;
			if (streamId < o.streamId) return -1;
			if (streamId > o.streamId) return 1;
			if (cancelMessageId < o.cancelMessageId) return -1;
			if (cancelMessageId > o.cancelMessageId) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			StringBuilder sbuf = new StringBuilder();
			sbuf.append("[").append(messageId);
			if (buf != null) sbuf.append(",buf=").append(buf);
			if (streamRequest != null) sbuf.append(",streamId=").append(streamRequest.streamId);
			if (cancelMessageId != 0) sbuf.append(",cancelMessageId=").append(cancelMessageId);
			sbuf.append(",conn=").append(System.identityHashCode(conn));
			sbuf.append("]");
			return sbuf.toString();
		}

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + (int) (cancelMessageId ^ (cancelMessageId >>> 32));
      result = prime * result + (int) (messageId ^ (messageId >>> 32));
      result = prime * result + (int) (streamId ^ (streamId >>> 32));
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      RequestToCancel other = (RequestToCancel) obj;
      if (!getOuterType().equals(other.getOuterType())) return false;
      if (cancelMessageId != other.cancelMessageId) return false;
      if (messageId != other.messageId) return false;
      if (streamId != other.streamId) return false;
      return true;
    }

    private HWireClient getOuterType() {
      return HWireClient.this;
    }
	}

	public void internalSend(RequestToCancel request) {
		if (log.isDebugEnabled()) log.debug("internalSend(" + request);
		
		HttpURLConnection conn = null;
		ByteBuffer buf = request.buf;
		
		ByteBuffer returnBuffer = null;
		Throwable returnException = null;

		if (log.isDebugEnabled()) {
			buf.mark();
			BBufferJson bbuf = new BBufferJson(buf);
			log.debug(bbuf.toDetailString());
			buf.reset();
		}

		final long beginSendMillis = System.currentTimeMillis();
		final boolean isNegotiate = BNegotiate.isNegotiateMessage(buf);
		final boolean isJson = isNegotiate || BMessageHeader.detectProtocol(buf) == BMessageHeader.MAGIC_JSON;
		if (log.isDebugEnabled()) log.debug("isJson=" + isJson);

		try {
		  String destUrl = surl;
		  
		  if (isNegotiate) {
		    int p = destUrl.lastIndexOf("/");
		    if (p >= 0) {
		      destUrl = destUrl.substring(0, p);
		      destUrl += getServletPathForNegotiationAndAuthentication();
		    }
		  }
		  
			final URL url = new URL(destUrl);
			if (log.isDebugEnabled()) log.debug("open connection, url=" + url);
			
			conn = (HttpURLConnection)url.openConnection();
			request.setConnection(conn);
			
			conn.setConnectTimeout((int)timeoutMillisClient);
			conn.setReadTimeout((int)request.timeoutMillisRequest); // is 0 for a long-poll request

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("Accept", "application/json, application/byps, text/plain, text/html");
			if ((flags & BWire.FLAG_GZIP) != 0) conn.setRequestProperty("Accept-Encoding", "gzip"); 
			conn.setRequestProperty("Content-Type", isJson ? "application/json" : "application/byps");
			
			applySession(conn);

			if (log.isDebugEnabled()) log.debug("write to output stream");
			OutputStreamByteCount osbc = new OutputStreamByteCount(conn.getOutputStream());
			bufferToStream(buf, osbc);
			if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.sum + ", wait for response");

			if (stats != null) {
				final long endSendMillis = System.currentTimeMillis();
				synchronized(this) {
					stats.addSendData(osbc.sum, endSendMillis-beginSendMillis);
				}
			}
			
			final long beginRecvMillis = System.currentTimeMillis();
			
			request.throwIfCancelled();
			
			InputStream is = null; 
			int statusCode = HttpURLConnection.HTTP_BAD_REQUEST;
			
			try {		
				statusCode = conn.getResponseCode();
				
				if (statusCode != HttpURLConnection.HTTP_OK ){
					throw new IOException("HTTP status " + statusCode);
				}
				
				InputStreamByteCount isbc = null;
				is = isbc = new InputStreamByteCount(conn.getInputStream());

				saveSession(conn);

				String enc = conn.getHeaderField("Content-Encoding");
				boolean gzip = enc != null && enc.equals("gzip");

				if (log.isDebugEnabled()) log.debug("read stream");
				ByteBuffer obuf = bufferFromStream(is, gzip);
				if (log.isDebugEnabled()) {
					log.debug("received #bytes=" + obuf.remaining());
					obuf.mark();
					BBufferJson bbuf = new BBufferJson(obuf);
					log.debug(bbuf.toDetailString());
					obuf.reset();
				}
				
				if (stats != null) {
					final long endRecvMillis = System.currentTimeMillis();
					synchronized(this) {
						stats.addRecvData(isbc.sum, endRecvMillis-beginRecvMillis);
					}
				}
							
				returnBuffer = obuf;
			}
			catch (IOException e) {
				if (log.isDebugEnabled()) log.debug("received exception: " + e);

				is = conn.getErrorStream();
				if (is != null) {
					bufferFromStream(is, false);
				}
				
				throw new HException(statusCode, e);
			}
			finally {
				if (is != null) {
					try { is.close(); } catch (IOException ignored) {}
				}
			}
		
		}
		catch (BException e) {
			// thrown in RequestToCancel.setConnection
			if (log.isDebugEnabled()) log.debug("received BException: " + e);
			returnException = e;
		}
		catch (SocketException e) {
			if (log.isDebugEnabled()) log.debug("received exception=" + e);
      returnException = e;
		}
		catch (Throwable e) {
			if (log.isDebugEnabled()) log.debug("received Throwable: " + e);
			if (cancelAllRequests || request.isCanceled()) {
				BException bex = new BException(BExceptionC.CANCELLED, "");
				returnException = bex;
			}
			else {
				BException bex = new BException(BExceptionC.IOERROR, e.getMessage(), e);
				returnException = bex;
			}
		}
			
		removeRequest(request, returnBuffer, returnException);
		
		if (log.isDebugEnabled()) log.debug(")internalSend");
	}

	protected void internalPutStream(RequestToCancel request) {
		
		final long messageId = request.streamRequest.messageId;
		final long streamId = request.streamRequest.streamId; 
		InputStream stream = request.streamRequest.strm;
		
		if (log.isDebugEnabled()) log.debug("internalPutStream(messageId=" + messageId + ", streamId=" + streamId + ", stream=" + stream);
		ByteBuffer obuf = null;
		
		String contentType = null;
		long totalLength = -1L;
		if (stream instanceof BContentStream) {
			BContentStream cstream = (BContentStream)stream;
			contentType = cstream.getContentType();
			totalLength = cstream.getContentLength();
		}
		else if (stream instanceof ByteArrayInputStream) {
			contentType = BContentStream.DEFAULT_CONTENT_TYPE;
			totalLength = ((ByteArrayInputStream)stream).available();
		}

		if (contentType == null || contentType.length() == 0) {
			contentType = BContentStream.DEFAULT_CONTENT_TYPE;
		}
		if (log.isDebugEnabled()) log.debug("Content-Type=" + contentType);
		
		Throwable returnException = null;
		
		final long beginSendMillis = System.currentTimeMillis();
		
		try {
				// Cannot use neither setFixedLengthStreamingMode nor setChunkedStreamMode
				// due to a concurrency bug in JVM, Bug ID 9005601
				// Concurrent requests with setFixedLengthStreamingMode or setChunkedStreamMode
				// cause Socket read timeout exceptions in Tomcat.
			
//				if (contentLength >= 0) {
//					conn.setFixedLengthStreamingMode((int)contentLength);
//					try {
//						conn.setFixedLengthStreamingMode(contentLength);
//						if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//					}
//					catch (NoSuchMethodError ignored) { // Java 6
//						if (contentLength <= Integer.MAX_VALUE) {
//							conn.setFixedLengthStreamingMode((int)contentLength);
//							if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//						}
//						else {
//							conn.setChunkedStreamingMode(CHUNK_SIZE); 
//							if (log.isDebugEnabled()) log.debug("Content-Length > 2GB, Java 6 -> Chunked-Encoding");
//						}
//					}
//				}
//				else {
//					if (log.isDebugEnabled()) log.debug("Content-Length < 0 -> Chunked-Encoding");
//					conn.setChunkedStreamingMode(CHUNK_SIZE); // Chunked-Encoding + AsyncServlet erst ab Tomcat 7.0.28: https://issues.apache.org/bugzilla/show_bug.cgi?id=52055
//				}
				
			
			// Compute number of stream parts
			long nbOfParts = 1; 
			if (totalLength > 0) {
				nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
				if ((totalLength % MAX_STREAM_PART_SIZE) != 0) {
					nbOfParts++;
				}
				if (log.isDebugEnabled()) log.debug("send stream in #parts=" + nbOfParts);
			}
			else if (totalLength < 0) {
				nbOfParts = Long.MAX_VALUE;
			}
			
			boolean lastPart = false;
			
			for (long partId = 0; partId < nbOfParts && !lastPart; partId++) {
				
				if (request.isCanceled()) {
					if (log.isDebugEnabled()) log.debug("request is cancelled.");
					break;
				}
				
				// Read the first chunk to find out, 
				// wether it is the last part to be sent.
				byte[] buf = new byte[CHUNK_SIZE];
				int len = stream.read(buf, 0, buf.length);
				
				if (totalLength >= 0) {
					lastPart = partId == nbOfParts-1;
				}
				else {
					lastPart = len < CHUNK_SIZE;
				}
				
				StringBuilder burl = new StringBuilder();
				burl.append(surl)
					.append("?messageid=").append(messageId)
					.append("&streamid=").append(streamId)
					.append("&partid=").append(partId)
					.append("&last=").append(lastPart ? 1 : 0)
					.append("&total=").append(totalLength);
					
				final URL url = new URL(burl.toString());
				if (log.isDebugEnabled()) log.debug("open connection, url=" + url);
				
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				OutputStream os = null;
				OutputStreamByteCount osbc = null;
				
				request.setConnection(conn);
		
				conn.setConnectTimeout((int)timeoutMillisClient);
	
				conn.setDoInput(true);
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Content-Type", contentType);
				
				applySession(conn);
				
				if (log.isDebugEnabled()) log.debug("write to output stream");
				
				os = osbc = new OutputStreamByteCount(conn.getOutputStream());			
				
				long sum = 0;
				while (len != -1) {
					os.write(buf, 0, len);
					sum += len;
					if (sum >= MAX_STREAM_PART_SIZE) break;
					len = stream.read(buf, 0, buf.length);
				}
				
				os.flush();
				os.close();
				os = null;
				if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.sum + ", wait for response");
				
				if (stats != null) {
					long endSendMillis = System.currentTimeMillis();
					synchronized(this) {
						stats.addSendData(osbc.sum, endSendMillis-beginSendMillis);
					}
				}
				
				long beginRecvMillis = System.currentTimeMillis();
	
				request.throwIfCancelled();
	
				InputStreamByteCount isbc = null;
				int statusCode = HttpURLConnection.HTTP_BAD_REQUEST;
				try {
					statusCode = conn.getResponseCode();
					if (statusCode != HttpURLConnection.HTTP_OK) {
						throw new IOException("HTTP " + statusCode); 
					}
					
					InputStream isResp = isbc = new InputStreamByteCount(conn.getInputStream());
					obuf = bufferFromStream(isResp, false); // closes isResp
					if (log.isDebugEnabled()) log.debug("received #bytes=" + obuf.remaining());
				}
				catch (IOException e) {
					if (log.isDebugEnabled()) log.debug("Failed to read response", e);
					InputStream errStrm = conn.getErrorStream();
					bufferFromStream(errStrm, false);
					
					throw new BException(BExceptionC.IOERROR, "HTTP " + statusCode, e);
				}
	
				if (stats != null) {
					long endRecvMillis = System.currentTimeMillis();
					synchronized(this) {
						stats.addRecvData(isbc.sum, endRecvMillis-beginRecvMillis);
					}
				}
				
			}
		}
		catch (BException e) {
			// thrown in RequestToCancel.setConnection
			if (log.isDebugEnabled()) log.debug("received BException: " + e);
			returnException = e;
		}
		catch (Throwable e) {
			if (log.isDebugEnabled()) log.debug("received Throwable: " + e);
			if (cancelAllRequests || request.isCanceled()) {
				BException bex = new BException(BExceptionC.CANCELLED, "");
				returnException = bex;
			}
			else {
				BException bex = new BException(BExceptionC.IOERROR, e.getMessage(), e);
				returnException = bex;
			}
		}
		finally {
			
			if (stream != null) {
				if (log.isDebugEnabled()) log.debug("close stream, messageId=" + messageId + ", streamId=" + streamId + ", stream=" + stream);
				try { stream.close(); } catch (IOException ignored) {}
			}
		}
		
		removeRequest(request, null, returnException);

		if (log.isDebugEnabled()) log.debug(")internalPutStream");
	}
		
	protected class MyInputStream extends InputStreamWrapper implements BAsyncResult<BMessage> {

		// Implementierung ist so kompliziert, damit die HTTP-Verbindung abgebrochen werden kann. 
		// Die Exception durch RequestToCancel.cancle() wird nur in openStream ausgewertet. Aber da 
		// müsste das cancel schon während des openStream kommen.
		
		volatile RequestToCancel request;
		volatile HttpURLConnection conn;
		volatile Throwable ex;
		volatile String contentType;
		volatile long contentLength;
		protected final Log log = LogFactory.getLog(MyInputStream.class);
		
		public MyInputStream(long messageId, long streamId) {
			super(messageId, streamId);
		}
		
		@Override
		public void setAsyncResult(BMessage msg, Throwable e) {
			this.ex = e;
		}
		
		void throwExceptionIf() throws IOException {
			Throwable e = ex;
			if (e == null) return;
			if (e instanceof IOException) {
				throw (IOException)e;
			}
			else {
				throw new BException(BExceptionC.CANCELLED, "", e);
			}
		}
		
		@Override
		protected InputStream ensureStream() throws IOException {
			throwExceptionIf();
			return super.ensureStream();
		}

		@Override
		protected InputStream openStream() throws IOException {
			if (log.isDebugEnabled()) log.debug("openStream(");
			InputStream is = null;
			
			try {
				final URL url = new URL(surl + "?messageid=" + messageId + "&streamid=" + streamId);
				
				if (log.isDebugEnabled()) log.debug("open connection, url=" + url);

				conn = (HttpURLConnection)url.openConnection();
				request = createRequestForGetStream(messageId, streamId, this);
				request.setConnection(conn);
		
				conn.setConnectTimeout((int)timeoutMillisClient);
				conn.setReadTimeout((int)timeoutMillisClient);

				conn.setDoInput(true);
				conn.setDoOutput(false);
				conn.setRequestMethod("GET");
	
				applySession(conn);

				if (log.isDebugEnabled()) log.debug("wait for response");

				try {
					is = conn.getInputStream();
					contentType = conn.getContentType();
					
					contentLength = -1L;
					try {
						String s = conn.getHeaderField("Content-Length");
						if (s != null && s.length() != 0) {
							contentLength = Long.parseLong(s);
						}
					}
					catch (NumberFormatException ex) {}
				}
				catch (IOException e) {
					if (log.isWarnEnabled()) log.warn("Failed to open stream.", e);
					is = conn.getErrorStream();
					bufferFromStream(is, false);
					
					int statusCode = conn.getResponseCode();
					if (log.isDebugEnabled()) log.debug("received http status=" + statusCode); 
					BException bex = new BException(BExceptionC.IOERROR, "HTTP " + statusCode);
					setAsyncResult(null, bex);
					removeRequest(request, null, bex);
				}
			}
			finally {
			}
			
			throwExceptionIf();

			if (log.isDebugEnabled()) log.debug(")openStream=" + is);
			return is;
		}
		
		@Override
		public void close() throws IOException {
			super.close();
			removeRequest(request, null, null);
		}
		
		@Override
		public long getContentLength() {
			try {
				ensureStream();
				return contentLength;
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
		
		@Override
		public String getContentType() {
			try {
				ensureStream();
				return contentType;
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	@Override
	public BContentStream getStream(long messageId, long strmId) throws IOException {
		if (log.isDebugEnabled()) log.debug("getStream(messageId=" + messageId + ", streamId=" + strmId);
		BContentStream is = new MyInputStream(messageId, strmId);
		if (log.isDebugEnabled()) log.debug(")getStream="+ is);
		return is;
	}
	
	protected void internalCancelAllRequests(long cancelMessageId) {
		if (log.isDebugEnabled()) log.debug("internalCancelAllRequests(");
		cancelAllRequests = true;
		
		ArrayList<RequestToCancel> arr = new ArrayList<RequestToCancel>(openRequestsToCancel.keySet());
		
		if (log.isDebugEnabled()) log.debug("cancel requests on client, #requests=" + arr.size());
		for (RequestToCancel robj : arr) {
			robj.cancel();
		}
		
		// Notify the server about the canceled messages
		if (cancelMessageId != 0) {
			sendCancelMessage(cancelMessageId);
		}
		
		if (log.isDebugEnabled()) log.debug(")internalCancelAllRequests");
	}
	
	@Override
	public void cancelAllRequests() {
		internalCancelAllRequests(MESSAGEID_CANCEL_ALL_REQUESTS);
	}
	
	@Override
	public void done() {
		
		internalCancelAllRequests(MESSAGEID_DISCONNECT);
		
		isDone = true;
		
		if (isMyThreadPool) {
			if (threadPool instanceof ExecutorService) {
				ExecutorService tp = (ExecutorService)threadPool;
				tp.shutdown();
			}
		}
	}
	
	protected void addRequest(RequestToCancel robj) {
		if (log.isDebugEnabled()) log.debug("addRequest(robj=" + robj);
		openRequestsToCancel.put(robj, Boolean.TRUE);
		if (log.isDebugEnabled()) log.debug(")addRequest=" + robj);
	}
	
	protected void removeRequest(RequestToCancel robj, ByteBuffer buf, Throwable ex) {
		if (log.isDebugEnabled()) log.debug("removeRequest(" + robj);
		if (robj == null) return;
		openRequestsToCancel.remove(robj);

		robj.done();
		robj.setAsyncResult(buf, ex);
		if (log.isDebugEnabled()) log.debug(")removeRequest");
	}
	
	/**
	 * Cancel a message on the server side.
	 * @param messageId Either a message ID or -1, if all messages of the session should be canceled
	 */
	protected void sendCancelMessage(final long messageId) {
		if (log.isDebugEnabled()) log.debug("sendCancelMessage(messageId=" + messageId);
		try {
			RequestToCancel r = createRequestForCancelMessage(messageId);
			executeRequest(r);
		}
		catch (BException e) {
			log.warn("Exception", e);
		}
		if (log.isDebugEnabled()) log.debug(")sendCancelMessage");
	}
	
	/**
	 * Cancel a message on the server side.
	 * @param messageId
	 */
	protected void internalSendCancelMessage(RequestToCancel request) {
		if (log.isDebugEnabled()) log.debug("internalSendCancelMessage(" + request);
		HttpURLConnection conn = null;
		InputStream is = null;
		int retry = 3;
		while (--retry >= 0) {
			try {
				try {
					final URL url = new URL(surl + "?messageid=" + request.cancelMessageId + "&cancel=1");
					if (log.isDebugEnabled()) log.debug("open connection, url=" + url);
	
					conn = (HttpURLConnection)url.openConnection();
					request.setConnection(conn);
					
					conn.setConnectTimeout((int)timeoutMillisClient);
					conn.setReadTimeout((int)timeoutMillisClient);

					conn.setDoInput(true);
					conn.setDoOutput(false);
					conn.setRequestMethod("GET");
		
					applySession(conn);
		
					if (log.isDebugEnabled()) log.debug("wait for response");
					is = conn.getInputStream();
					if (log.isDebugEnabled()) log.debug("received response");
					
					if (log.isDebugEnabled()) log.debug("read response stream=" + is);
					try { bufferFromStream(is, false); } catch (IOException ignored) {}
					
					break;
				}
				catch (SocketException e) {
					if (log.isDebugEnabled()) log.debug("received exception=" + e + ", retry=" + retry);
					if (retry == 0) {
						break;
					}
				}
				catch (IOException e) {
					if (log.isDebugEnabled()) log.debug("received exception: " + e);
					is = conn.getErrorStream();
					if (log.isDebugEnabled()) log.debug("read response stream=" + is);
					try { bufferFromStream(is, false); } catch (IOException ignored) {}
					break;
				}
				
			}
			finally {
				if (conn != null) {
					if (log.isDebugEnabled()) log.debug("disconnect");
					conn.disconnect();
				}
			}
		}
		if (log.isDebugEnabled()) log.debug(")internalSendCancelMessage");
	}

	String testAdapter(String fnct, String[] args) {
		if (log.isDebugEnabled()) log.debug("testAdapter(fnct=" + fnct + ", " + Arrays.toString(args));
		
		if (fnct.equals(HTestAdapter.KILL_CONNECTIONS)) {
			internalCancelAllRequests(0);
			return "";
		}
		
		HttpURLConnection conn = null;
		InputStream is = null;
		String ret = "";
		
		try {
			try {
				StringBuilder uparams = new StringBuilder();
				if (args != null) {
					for (String arg : args) {
						uparams.append("&").append(arg);
					}
				}
				
				final URL url = new URL(surl + "?testAdapter=" + fnct + uparams);
				if (log.isDebugEnabled()) log.debug("open connection, url=" + url);

				conn = (HttpURLConnection)url.openConnection();
				conn.setConnectTimeout((int)timeoutMillisClient);
				conn.setReadTimeout((int)timeoutMillisClient);
				conn.setDoInput(true);
				conn.setDoOutput(false);
				conn.setRequestMethod("GET");
	
				applySession(conn);
	
				if (log.isDebugEnabled()) log.debug("wait for response");
				is = conn.getInputStream();
				if (log.isDebugEnabled()) log.debug("received response");
			}
			catch (IOException e) {
				if (log.isDebugEnabled()) log.debug("received exception: " + e);
				is = conn.getErrorStream();
			}
			
			if (log.isDebugEnabled()) log.debug("read response stream=" + is);
			try {
				ByteBuffer buf = bufferFromStream(is, false);
				if (buf != null) {
					ret = new String(buf.array(), buf.position(), buf.remaining(), "UTF-8");
				}
			} catch (IOException ignored) {}
		}
		finally {
			if (conn != null) {
				if (log.isDebugEnabled()) log.debug("disconnect");
				conn.disconnect();
			}
		}
		if (log.isDebugEnabled()) log.debug(")testAdapter=" + ret);
		return ret;
	}


	void applySession(HttpURLConnection conn) {
		CookieManager cookieManager = (CookieManager)getSessionContext();
		CookieStore cookies = cookieManager.getCookieStore();
		for (HttpCookie cookie : cookies.getCookies()) {
			if (log.isDebugEnabled()) log.debug("add cookie: " + cookie);
			conn.setRequestProperty("Cookie", cookie.toString());
		}
	}

	void saveSession(HttpURLConnection conn) throws IOException, URISyntaxException {
		URI uri = new URI(surl);
		CookieManager cookieManager = (CookieManager)getSessionContext();
		cookieManager.put(uri, conn.getHeaderFields());
		if (log.isDebugEnabled()) log.debug("save cookies=" + cookieManager.getCookieStore());
	}
	
	@Override
	public synchronized Statistics getStatistics() {
		return new Statistics(stats);
	}
	
	@Override
	public synchronized void clearStatistics() {
		stats = new Statistics();
	}

	@Override
	public BTestAdapter getTestAdapter() {
		return testAdapter;
	}

	/**
	 * Gets the servlet path for negotiation and authentication.
	 * A request for HTTP authentication should be sent to a different sub directory of the web application.
	 * E.g. while http://server/app/byps is the URL for BYPS communication, authentication requests are sent to 
	 * http://server/app/bypsauth/auth. The reason for this is that some browsers initiate the authentication
	 * handshake in each request if the first one has had to be authenticated.
	 * This function returns [servlet-name]auth/auth by default, whereby [servlet-name] is the part of the
	 * URL between the last slash and the first question mark (if available). E.g. for URL http://server/app/byps
	 * the [servlet-name] is byps and the function returns /bypsauth/byps.
	 * @return servlet path, e.g. /bypsauth/auth
	 */
	public String getServletPathForNegotiationAndAuthentication() {
	  String authUrl = surl;
	  int p = authUrl.lastIndexOf('/');
	  if (p >= 0) {
	    int e = authUrl.indexOf('?', p);
	    if (e < 0) e = authUrl.length();
	    authUrl = authUrl.substring(p, e);
	    authUrl += "auth/auth";
	  }
	  return authUrl;
	}

}
