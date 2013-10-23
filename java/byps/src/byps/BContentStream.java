package byps;

import java.io.IOException;
import java.io.InputStream;

import byps.BException;

/**
 * BContentStream is an InputStream with content type and content length.
 * Streams should always be transferred with a given content length. This 
 * makes HTTP communication more reliable. 
 */
public abstract class BContentStream extends InputStream {
	
	/**
	 * Default content type: application/octet-stream
	 */
	public final static String DEFAULT_CONTENT_TYPE = "application/octet-stream";

	/**
	 * Constructor with content type and length.
	 * @param contentType
	 * @param contentLength
	 */
	public BContentStream(String contentType, long contentLength) {
		this.lifetimeMillis = 0;
		this.contentType = contentType != null && contentType.length() != 0 ? contentType : DEFAULT_CONTENT_TYPE;
		this.contentLength = contentLength;
		extendLifetime();
	}
	
	/**
	 * Constructor used on provider side.
	 * @param contentType
	 * @param contentLength
	 * @param lifetimeMillis
	 */
	public BContentStream(String contentType, long contentLength, long lifetimeMillis) {
		this.lifetimeMillis = lifetimeMillis;
		this.contentType = contentType != null && contentType.length() != 0 ? contentType : DEFAULT_CONTENT_TYPE;
		this.contentLength = contentLength;
		extendLifetime();
	}
	
	/**
	 * Internally used copy constructor.
	 * @param rhs
	 */
	public BContentStream(BContentStream rhs) {
		this.lifetimeMillis = rhs.lifetimeMillis;
		this.contentType = rhs.contentType;
		this.contentLength = rhs.contentLength;
		extendLifetime();
	}
	
	/**
	 * Default constructor.
	 */
	public BContentStream() {
		this.lifetimeMillis = 0;
		this.contentType = DEFAULT_CONTENT_TYPE;
		this.contentLength = -1L;
	}
	
	/**
	 * Returns the content type.
	 * This value is used as HTTP Header Content-Type.
	 * @return Content type.
	 */
	public String getContentType() throws IOException {
		return contentType; // e.g. "text/plain; charset=utf-8"
	}
	
	/**
	 * Returns the content length.
	 * This value is used as HTTP Header Content-Length.
	 * This function returns -1L, if the content length is unknown.
	 * @return Content length.
	 */
	public long getContentLength() throws IOException {
		return contentLength; 
	}
	
	/**
	 * Clone stream.
	 * This function is only used on the provider side.
	 * @return
	 * @throws IOException
	 */
	public BContentStream cloneInputStream() throws IOException {
		throw new IOException("Stream cannot be cloned.");
	}
	
	/**
	 * Checks, whether the stream is expired.
	 * This function is only used on the provider side.
	 * @return
	 */
	public boolean isExpired() {
		boolean exp = lifetimeMillis > 0 && System.currentTimeMillis() > bestBefore;
		return exp;
	}
	
	/**
	 * Extends the lifetime.
	 * This function is only used on the provider side.
	 */
	protected void extendLifetime() {
		bestBefore = lifetimeMillis > 0 ? (System.currentTimeMillis() + lifetimeMillis) : 0;
	}
	
	/**
	 * Returns the lifetime in milliseconds.
	 * This function is only used on the provider side.
	 * @return
	 */
	protected long getLifetimeMillis() {
		return lifetimeMillis;
	}
	
	/**
	 * Get the callback interface for asynchronous processing.
	 * This function is for internal use only.
	 * @return Callback interface
	 */
	public BContentStreamAsyncCallback getAsyncCallback() {
	  return callback;
	}
	
	/**
	 * Assign a callback interface to the given stream.
	 * Only streams returned from API calls can be used as a parameter.
	 * @param is InputStream object returned from an API call. 
	 * @param cb Callback interface
	 * @throws IOException
	 */
	public static void assignAsyncCallback(InputStream is, BContentStreamAsyncCallback cb) throws IOException {
	  if (is instanceof BContentStream) {
  	  BContentStream me = ((BContentStream)is);
  	  me.setAsyncCallback(cb);
	  }
	  else {
	    throw new BException(BExceptionC.INTERNAL, "The given stream is not an instance of BContentStream.");
	  }
	}
	
	protected void setAsyncCallback(BContentStreamAsyncCallback cb) throws IOException {
	  this.callback = cb;
	}
	
	private volatile long bestBefore;
	protected final long lifetimeMillis;
	protected volatile String contentType;
	protected volatile long contentLength;

	protected volatile BContentStreamAsyncCallback callback;
}
