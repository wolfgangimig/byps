package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
   * URL parameter used when uploading files in HTML forms or by JavaScript.
   */
  public final static String URL_PARAM_UPLOAD_HANDLER = "uploadHandler";

  /**
   * Value for URL_PARAM_UPLOAD_HANDLER.
   * The upload response is wrapped into HTML and BODY tags. 
   */
  public final static String UPLOAD_HANDLER_HTML_FORM = "htmlform";
  
  /**
   * Value for URL_PARAM_UPLOAD_HANDLER.
   * The upload response is not wrapped. 
   */
  public final static String UPLOAD_HANDLER_HTML5 = "html5";
  
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
		this.properties_access_getProperties = new BContentStreamProperties(contentType, contentLength, "", ATTACHMENT);
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
    this.properties_access_getProperties = new BContentStreamProperties(contentType, contentLength, "", ATTACHMENT);
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
    this.setProperties(rhs.getProperties());
		this.targetId = rhs.getTargetId();
  }
  
  /**
	 * Default constructor.
	 */
	public BContentStream() {
		this.lifetimeMillis = 0;
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
	  return getProperties().getContentType();
		// e.g. "text/plain; charset=utf-8"
	}
	
	/**
	 * Set content type.
	 * @param v Content-Type header value
	 * @return this
	 */
	public void setContentType(String v) {
	  getProperties().setContentType(v);
	}
	
	/**
	 * Returns the content length.
	 * This value is used as HTTP Header Content-Length.
	 * This function returns -1L, if the content length is unknown.
	 * @return Content length.
   * @see #ensureProperies()
	 */
	public long getContentLength() {
		return getProperties().getContentLength(); 
	}
	
	/**
	 * Set content length
	 * @param v Content-Length header value
	 * @return this
   * @see #ensureProperies()
	 */
	public void setContentLength(long v) {
	  getProperties().setContentLength(v);
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
    this.getProperties().setFileName(fileName);
    this.getProperties().setAttachmentCode(attachment ? ATTACHMENT : INLINE);
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
	    
	    // Check for filename header following https://tools.ietf.org/html/rfc5987 
	    // 3.2.2 Examples: foo: bar; title*=UTF-8''%c2%a3%20and%20%e2%82%ac%20rates
	    int p = value.indexOf("filename*=");
	    if (p >= 0) {
	      int b = p + 10;
	      int e = value.indexOf('\'', b);
	      if (e != -1) {
	    	  String charSet = value.substring(b, e);
	    	  b = e;
	    	  e = value.indexOf('\'', b+1);
	    	  if (e != -1) {
	    		  //String lang = value.substring(b, e); ignored
	    		  b = e + 1;
	    		  e = value.indexOf(';', b);
	    		  if (e == -1) e = value.length();
	    		  fileName = value.substring(b, e);
	    		  fileName = fileName.trim();
	    		  if (fileName.startsWith("\"") && fileName.endsWith("\"")) fileName = fileName.substring(1, fileName.length()-1);
	    		  try {
	    			  fileName = URLDecoder.decode(fileName, charSet);
	    		  } catch (UnsupportedEncodingException e1) {
	    		  }
	    	  }
	      }
	    }
	    
	    if (fileName.isEmpty()) {
	      p = value.indexOf("filename=");
		  if (p >= 0) {
		    int b = p + 9;
		    int e = value.indexOf(';', b);
		    if (e == -1) e = value.length();
		    fileName = value.substring(b, e);
	        fileName = fileName.trim();
	        if (fileName.startsWith("\"") && fileName.endsWith("\"")) fileName = fileName.substring(1, fileName.length()-1);
            try {
	          fileName = URLDecoder.decode(fileName, "ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
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
    String fileName = getFileName();
    if (fileName != null && fileName.length() != 0) {
      sbuf.append(" filename=");
      try {
		String fileNameA = URLEncoder.encode(fileName, "ISO-8859-1").replaceAll("\\+", "%20");
		sbuf.append(fileNameA);
	  } catch (UnsupportedEncodingException e) {
	  }
      
      sbuf.append("; filename*=UTF-8''");
      try {
		String fileNameU = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		sbuf.append(fileNameU);
	  } catch (UnsupportedEncodingException e) {
	  }

    }
    return sbuf.toString();
 	}
 	
 	/**
 	 * Get content disposition attachment.
 	 * @return true, if the browser should open this stream as an attachment.
   * @see #ensureProperies()
 	 */
  public int getAttachmentCode() {
    return getProperties().getAttachmentCode();
  }
  
  /**
   * Set content disposition attachment.
   * @param attachment code, {@link BContentStream#ATTACHMENT} or {@link BContentStream#INLINE}.
   * @return this;
   */
  public void setAttachmentCode(int att) {
    getProperties().setAttachmentCode(att);
  }
  
  /**
   * Get file name.
   * @return file name.
   * @see #ensureProperies()
   */
  public String getFileName() {
    return getProperties().getFileName();
  }
  
  /**
   * Set file name.
   * @param fileName File name.
   * @return this
   */
  public BContentStream setFileName(String fileName) {
    this.getProperties().setFileName(fileName);
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
  
  public BContentStreamProperties getProperties() {
    return this.properties_access_getProperties;
  }
  
  private void setProperties(BContentStreamProperties properties) {
    properties_access_getProperties = properties;
  }

  private volatile long bestBefore;
	protected final long lifetimeMillis;
	protected volatile BTargetId targetId = BTargetId.ZERO;
	private BContentStreamProperties properties_access_getProperties = new BContentStreamProperties();

	protected volatile BContentStreamAsyncCallback callback;
	
	public String toString() {
	  StringBuilder sbuf = new StringBuilder();
	  sbuf.append("[").append(getProperties());
    if (targetId != null) sbuf.append(",targetId=").append(targetId);
	  sbuf.append("]");
	  return sbuf.toString();
	}
}
