package byps.http;
import java.io.BufferedInputStream;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BTargetId;

public class HIncomingStreamAsync extends BContentStream  {

	private static Logger log = LoggerFactory.getLogger(HIncomingStreamAsync.class);
	protected InputStream is;
	protected HRequestContext rctxt;
	protected final File tempDir;
	
	private AtomicBoolean closed = new AtomicBoolean();

	HIncomingStreamAsync(BTargetId targetId, String contentType, long contentLength, String contentDisposition, long lifetimeMillis, File tempDir, HRequestContext rctxt) throws IOException {
		super(contentType, contentLength, lifetimeMillis);
		this.setTargetId(targetId);
		this.rctxt = rctxt;
		this.is = new BufferedInputStream(rctxt.getRequest().getInputStream());
		this.tempDir = tempDir;
		setContentDisposition(contentDisposition);
	}
	
	private final InputStream strm() throws IOException {
		if (closed.get()) {
			if (log.isDebugEnabled()) log.debug("Outgoing stream already closed, targetId=" + targetId);
			throw new IOException("Stream is closed");
		}
		return is;
	}

	@Override
	public int read() throws IOException {
		if (log.isDebugEnabled()) log.debug("read(");
		int b = strm().read();
		if (log.isDebugEnabled()) log.debug(")read=" + b);
		return b;
	}

	@Override
	public int available() throws IOException {
		return strm().available();
	}
	
	@Override
	public void close() throws IOException {
		if (log.isDebugEnabled()) log.debug("close(targetId=" + targetId);
		
		boolean alreadyClosed = closed.getAndSet(true);
		if (log.isDebugEnabled()) log.debug("alreadyClosed=" + alreadyClosed);
		if (!alreadyClosed) {
		
			if (log.isDebugEnabled()) log.debug("complete AsyncContext of targetId=" + targetId + " with status=" + HttpServletResponse.SC_OK);
			
			// The stream data must be completely read.
			// Otherwise the data remains in the socket and 
			// disturbs the next request.
			try {
  			long n = 0;
  			while (is.read() != -1) {
  				n++;
  			}
  			if (n != 0) {
  			  log.error("have read #bytes=" + n + ", before close");
  			}
			} 
			catch (Throwable ignored) { // Observed an NPE during testing
			}
			finally {
			  try { is.close(); } catch (Throwable ignored) {}
	      is = null;
			}
			
			try {
	      HttpServletResponse response = (HttpServletResponse)rctxt.getResponse();
			  response.getOutputStream().close();
	      response.setStatus(HttpServletResponse.SC_OK);
			} catch (Throwable ignored) {}
			
			rctxt.complete();
			rctxt = null;
			
			super.close();
		}
		if (log.isDebugEnabled()) log.debug(")close");
	}
	
	@Override
	public void mark(int readlimit) {
		is.mark(readlimit);
	}
	
	@Override
	public boolean markSupported() {
		return is.markSupported();
	}
	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		try {
			int n = strm().read(b, off, len);
	    //if (log.isDebugEnabled()) log.debug("read " + targetId + " (len=" + len + ")=" + n);
			return n;
		}
		catch (IOException e) {
			if (log.isDebugEnabled()) log.debug("exception: ", e);
			throw e;
		}
	}
	
	@Override
	public void reset() throws IOException {
		strm().reset();
	}
	
	@Override
	public long skip(long n) throws IOException {
		return strm().skip(n);
	}

	@Override
	public synchronized BContentStream materialize() throws BException {
		HIncomingStreamSync istrm = null;
		try {
		  istrm = new HIncomingStreamSync(this, lifetimeMillis, tempDir);
			istrm.assignStream(strm());
			
      // materialize closes "this"
      this.close();
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, "Failed to clone stream", e);
		}
		return istrm;
	}
	

}
