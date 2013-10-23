package byps;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class wraps an arbitrary InputStream into a BContentStream.
 * Use this class to supply content type and content length information for an arbitrary InputStream.
 * E.g. use this class to wrap a FileInputStream and supply the file length as the content length.
 *
 */
public class BContentStreamWrapper extends BContentStream {
	
	/**
	 * Wrapped stream.
	 */
	protected volatile InputStream innerStream;
	
	/**
	 * Default constructor.
	 */
	public BContentStreamWrapper() {
	}
	
	/**
	 * 
	 * @param innerStream
	 */
	public BContentStreamWrapper(InputStream innerStream) {
		this(innerStream, BContentStream.DEFAULT_CONTENT_TYPE, -1L, 0L);
	}
	
	public BContentStreamWrapper(InputStream innerStream, String contentType, long contentLength) {
		this(innerStream, contentType, contentLength, 0L);
	}
	
	public BContentStreamWrapper(InputStream innerStream, String contentType, long contentLength, long lifetimeMillis) {
		super(
			makeValidContentType(innerStream, contentType),
			makeValidContentLength(innerStream, contentLength),
			lifetimeMillis
		);
		this.innerStream = innerStream;
	}
	
	private static String makeValidContentType(InputStream innerStream, String contentType) {
	  if (innerStream != null && innerStream instanceof BContentStream) return DEFAULT_CONTENT_TYPE;
		if (contentType != null && contentType.length() != 0) return contentType;
		return DEFAULT_CONTENT_TYPE;
	}
	
	private static long makeValidContentLength(InputStream innerStream, long contentLength) {
    if (innerStream != null && innerStream instanceof BContentStream) return -1L;
		if (contentLength > -1L) return contentLength;
		return -1L;
	}
	
  protected void setAsyncCallback(BContentStreamAsyncCallback cb) throws IOException {
    super.setAsyncCallback(cb);
    ensureStream();
  }
  	
	protected InputStream openStream() throws IOException {
		return this.innerStream;
	}
	
	public InputStream ensureStream() throws IOException {
		if (innerStream != null) return innerStream;
		
		synchronized(this) {
			if (innerStream == null) {
				innerStream = openStream();
			}
		}
		
		return innerStream;
	}
	
  @Override
  public String getContentType() throws IOException {
    ensureStream();   
    if (innerStream instanceof BContentStream) {
      return ((BContentStream)innerStream).getContentType();
    }
    else {
      return super.getContentType();
    }
  }
  
  @Override
  public long getContentLength() throws IOException {
    ensureStream();   
    if (innerStream instanceof BContentStream) {
      return ((BContentStream)innerStream).getContentLength();
    }
    else {
      return super.getContentLength();
    }
  }
  
	@Override
	public int read() throws IOException {
		return ensureStream().read();
	}
	@Override
	public int available() throws IOException {
		return ensureStream().available();
	}
	@Override
	public void close() throws IOException {
		InputStream is = innerStream;
		if (is != null) {
			is.close();
		}
	}
	@Override
	public void mark(int readlimit) {
		try {
			ensureStream().mark(readlimit);
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}
	@Override
	public int read(byte[] b) throws IOException {
		return ensureStream().read(b);
	}
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return ensureStream().read(b, off, len);
	}
	@Override
	public boolean markSupported() {
		try {
			return ensureStream().markSupported();
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}
	@Override
	public void reset() throws IOException {
		ensureStream().reset();
	}
	@Override
	public long skip(long n) throws IOException {
		return ensureStream().skip(n);
	}
	
}
