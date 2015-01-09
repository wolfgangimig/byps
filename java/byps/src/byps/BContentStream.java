package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.IOException;
import java.io.InputStream;

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
   * Explicitly add this URL parameter for range requests.
   * This parameter tells the server, that the stream should not be closed after the request.
   * If this parameter is not set, the HTTP range request header is ignored. 
   */
  public final static String URL_PARAM_ACCEPT_RANGES = "accept-ranges";
  
  /**
   * Controls HTTP header Content-Disposition.
   */
  public final static int ATTACHMENT = 1;

  /**
   * Controls HTTP header Content-Disposition.
   */
  public final static int INLINE = 2;

	/**
	 * Constructor with content type and length.
	 * @param contentType
	 * @param contentLength
	 */
	public BContentStream(String contentType, long contentLength) {
		this.lifetimeMillis = 0;
		this.contentType = contentType;
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
		this.contentType = contentType;
		this.contentLength = contentLength;
		extendLifetime();
	}
	
	/**
	 * Internally used copy constructor.
	 * Copies the stream properties (contentType, etc.).
	 * @param rhs
	 */
	public BContentStream(BContentStream rhs, long lifetimeMillis) {
		this.lifetimeMillis = lifetimeMillis;
		copyProperties(rhs);
		extendLifetime();
	}

	/**
	 * Copy properties from given stream if properties are not valid.
	 * Copies contentType, contentLength, attachment, fileName, targetId.
	 * @param rhs Other stream to get values from.
	 * @see #hasValidProperties()
	 */
  public void copyProperties(BContentStream rhs) {
    this.contentType = rhs.getContentType();
		this.contentLength = rhs.getContentLength();
		this.attachmentCode = rhs.getAttachmentCode();
		this.fileName = rhs.getFileName();
		this.targetId = rhs.getTargetId();
  }
  
	/**
	 * Default constructor.
	 */
	public BContentStream() {
		this.lifetimeMillis = 0;
		this.contentType = "";
		this.contentLength = -1L;
	}
	
	/**
	 * Ensure that stream properties are valid.
	 * This function ensures, that the properties contentType, contentLength, attachmentCode and fileName
	 * are valid. This function may start to read the stream.
	 * @throws IOException
	 */
  public void ensureProperties() throws IOException {
  }
	
	/**
	 * Returns the content type.
	 * This value is used as HTTP header Content-Type.
	 * @see #ensureProperies()
	 * @return Content type.
	 */
	public String getContentType() {
	  String s = contentType;
		return s != null ? s : ""; 
		// e.g. "text/plain; charset=utf-8"
	}
	
	/**
	 * Set content type.
	 * @param v Content-Type header value
	 * @return this
	 */
	public void setContentType(String v) {
	  contentType = v;
	}
	
	/**
	 * Returns the content length.
	 * This value is used as HTTP Header Content-Length.
	 * This function returns -1L, if the content length is unknown.
	 * @return Content length.
   * @see #ensureProperies()
	 */
	public long getContentLength() {
		return contentLength; 
	}
	
	/**
	 * Set content length
	 * @param v Content-Length header value
	 * @return this
   * @see #ensureProperies()
	 */
	public void setContentLength(long v) {
	  contentLength = v;
	}
	
  /**
   * Duplicate stream.
   * This function is only supported by sub-classes available on the server side.
   * It copies the stream contents into a new stream buffered by memory or a temporary file.
   * The stream referenced by "this" is reseted after it is copied. The properties are passed 
   * into the returned stream. Except the targetId is not copied, it is set to {@link BTargetId#ZERO}.
   * @return Materialized stream.
   * @throws CloneNotSupportedException 
   * @see {@link #materialize()}
   */
  public BContentStream cloneStream() throws IOException {
    throw new IOException("Stream cannot be cloned.");
  }
  
  /**
   * Write stream data into buffer or temporary file.
   * This function is only supported by sub-classes available on the server side.
   * Use this function for an incoming stream that has to be still available 
   * after the message was processed. The function copies the stream contents into a memory
   * buffer or into a temporary file.
   * The stream represented by "this" is closed by this function.
   * @return materialized stream.
   * @throws IOException
   */
  public BContentStream materialize() throws IOException {
    throw new IOException("Stream cannot be materialized.");
  }
  
  /**
   * Write stream data into buffer or temporary file.
   * @param is stream to be materialized.
   * @return materialized stream.
   * @throws IOException
   * @see {@link #materialize()}
   */
  public static BContentStream materialize(InputStream is) throws IOException {
    if (!(is instanceof BContentStream)) throw new IOException("InputStream cannot be materialized.");
    return ((BContentStream)is).materialize();
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
	
	protected BContentStream setAsyncCallback(BContentStreamAsyncCallback cb) throws IOException {
	  this.callback = cb;
	  return this;
	}
	
	/**
	 * Set HTTP header Content-Disposition.
	 * @param fileName File name
	 * @param attachment true, if the browser should open the file as an attachment.
	 * @return this
	 */
	public void setContentDisposition(String fileName, boolean attachment) {
    this.fileName = fileName;
    this.attachmentCode = attachment ? ATTACHMENT : INLINE;
	}
	
	/**
   * Set HTTP header Content-Disposition.
   * @param value Content-Dispostion header value
   * @return this
   */
 	public void setContentDisposition(String value) {
 	  String fileName = "";
 	  boolean att = false;
	  if (value != null && value.length() != 0) {
	    value = value.trim();
	    att = value.indexOf("attachment;") >= 0;
	    int p = value.indexOf("filename=");
	    if (p >= 0) {
	      fileName = value.substring(p + "filename=".length()).trim();
	      if (fileName.startsWith("\"")) {
	        fileName = fileName.substring(1);
	        if (fileName.endsWith("\"")) {
	          fileName = fileName.substring(0, fileName.length()-1);
	        }
	      }
	    }
	  }
	  setContentDisposition(fileName, att);
	}
 	
  /**
   * Get HTTP header Content-Disposition.
   * @return HTTP header Content-Disposition.
   * @see #ensureProperies()
   */
 	public String getContentDisposition() {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append( getAttachmentCode() == ATTACHMENT ? "attachment;" : "inline;" );
    final String fileName = getFileName();
    if (fileName != null && fileName.length() != 0) {
      sbuf.append(" filename=");
      boolean q = fileName.indexOf(' ') >= 0;
      if (q) sbuf.append("\"");
      sbuf.append(fileName);
      if (q) sbuf.append("\"");
    }
    return sbuf.toString();
 	}
 	
 	/**
 	 * Get content disposition attachment.
 	 * @return true, if the browser should open this stream as an attachment.
   * @see #ensureProperies()
 	 */
  public int getAttachmentCode() {
    return attachmentCode;
  }
  
  /**
   * Set content disposition attachment.
   * @param attachment code, {@link BContentStream#ATTACHMENT} or {@link BContentStream#INLINE}.
   * @return this;
   */
  public void setAttachmentCode(int att) {
    attachmentCode = att;
  }
  
  /**
   * Get file name.
   * @return file name.
   * @see #ensureProperies()
   */
  public String getFileName() {
    return fileName;
  }
  
  /**
   * Set file name.
   * @param fileName File name.
   * @return this
   */
  public BContentStream setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }
  
  public BTargetId getTargetId() {
    return targetId;
  }

  public void setTargetId(BTargetId targetId) {
    this.targetId = targetId;
  }
  
  /**
   * Returns true, if the stream supports random access.
   * If random access is supported, the function {@link #position(long)} can 
   * be used to read data at an arbitrary position in the stream. 
   * Function {@link #getContentLength()} must return the number of bytes in the stream, if
   * random access is supported.
   * @return true, if random access supported.
   */
  public boolean positionSupported() {
    return false;
  }
  
  /**
   * Set the stream position to the given value.
   * @param pos Stream offset from the beginning
   * @see #positionSupported()
   */
  public void position(long pos) throws IOException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public void close() throws IOException {
    super.close();
  }
  
  private volatile long bestBefore;
	protected final long lifetimeMillis;
	protected volatile String contentType;
	protected volatile long contentLength = -1L;
	protected volatile String fileName;
	protected volatile int attachmentCode;
	protected volatile BTargetId targetId = BTargetId.ZERO;

	protected volatile BContentStreamAsyncCallback callback;
	
	public String toString() {
	  StringBuilder sbuf = new StringBuilder();
	  sbuf.append("[").append(contentType).append(", #=").append(contentLength);
    if (targetId != null) sbuf.append(",targetId=").append(targetId);
	  sbuf.append("]");
	  return sbuf.toString();
	}
}
