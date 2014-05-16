package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	
  public BContentStreamWrapper(InputStream innerStream) {
    this(innerStream, "", -1L, 0L);
  }
  
	public BContentStreamWrapper(InputStream innerStream, String contentType, long contentLength) {
		this(innerStream, contentType, contentLength, 0L);
	}
	
	public BContentStreamWrapper(InputStream innerStream, String contentType, long contentLength, long lifetimeMillis) {
	  super(contentType, contentLength, lifetimeMillis);
		this.innerStream = innerStream;
	}
	
  public BContentStreamWrapper(BContentStream innerStream, long lifetimeMillis) {
    super(innerStream, lifetimeMillis);
    this.innerStream = innerStream;
  }
  
	public BContentStreamWrapper(File file) throws FileNotFoundException {
	  super(getFileContentType(file), file.length());
	  innerStream = new FileInputStream(file);
	  setContentDisposition(file.getName(), false);
	}
	
  public BContentStreamWrapper(ByteArrayInputStream is, String contentType) {
    this(is, contentType, is.available(), 0L);
  }
  
  public BContentStreamWrapper(ByteArrayInputStream is) {
    this(is, null, is.available(), 0L);
  }
    
	private static String getFileContentType(File file) {
    String contentType = DEFAULT_CONTENT_TYPE;
    Path fpath = Paths.get(file.getAbsolutePath());
    try {
      contentType = Files.probeContentType(fpath);
    } catch (IOException ignored) {
    }
    return contentType;
	}
	
  protected BContentStream setAsyncCallback(BContentStreamAsyncCallback cb) throws IOException {
    super.setAsyncCallback(cb);
    ensureStream();
    return this;
  }

  @Override
  public void ensureProperties() throws IOException {
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
				if (innerStream instanceof BContentStream) {
				  BContentStream bstream = (BContentStream)innerStream;
				  this.copyProperties(bstream); // copy contentType, contentLength etc.
				}
			}
		}
		
		return innerStream;
	}
	
  @Override
  public BContentStream cloneStream() throws IOException {
    InputStream is = ensureStream();
    if (is instanceof BContentStream) {
      return ((BContentStream)is).cloneStream();
    }
    else {
      return super.cloneStream();
    }
  }
  
  @Override
  public BContentStream materialize() throws IOException {
    InputStream is = ensureStream();
    if (is instanceof BContentStream) {
      BContentStream ret = ((BContentStream)is).materialize();
      this.close();
      return ret;
    }
    else {
      return super.materialize();
    }
  }
  
//	@Override
//  public String getContentType() {
//    String s = contentType;
//    if (s != null && s.length() != 0) return s;
//    InputStream is;
//    try {
//      
//      is = ensureStream();
//      s = contentType;
//      if (s != null && s.length() != 0) return s;
//      
//      if (is instanceof BContentStream) {
//        contentType = s = ((BContentStream)is).getContentType();
//      }    
//    }
//    catch (IOException e) {}
//    return s;
//  }
//
//  @Override
//  public long getContentLength() {
//    long s = contentLength;
//    if (s >= 0) return s;
//    InputStream is;
//    try {
//
//      is = ensureStream();
//      s = contentLength;
//      if (s >= 0) return s;
//
//      if (is instanceof BContentStream) {
//        contentLength = s = ((BContentStream)is).getContentLength();
//      }    
//    }
//    catch (IOException e) {}
//    return s;
//  }
//
//  @Override
//  public int getAttachmentCode() {
//    int s = attachmentCode;
//    if (s != 0) return s;
//    InputStream is;
//    try {
//
//      is = ensureStream();
//      s = attachmentCode;
//      if (s >= 0) return s;
//
//      if (is instanceof BContentStream) {
//        attachmentCode = s = ((BContentStream)is).getAttachmentCode();
//      }    
//    }
//    catch (IOException e) {}
//    return s;
//  }
//
//  @Override
//  public String getFileName() {
//    String s = fileName;
//    if (s != null && s.length() != 0) return s;
//    InputStream is;
//    try {
//      
//      is = ensureStream();
//      s = fileName;
//      if (s != null && s.length() != 0) return s;
//
//      if (is instanceof BContentStream) {
//        fileName = s = ((BContentStream)is).getFileName();
//      }    
//    }
//    catch (IOException e) {}
//    return s;
//  }

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
			throw new IllegalStateException(e);
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
