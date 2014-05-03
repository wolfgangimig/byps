package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;

public class HOutgoingStream extends BContentStreamWrapper {
	//private Log log = LogFactory.getLog(HOutgoingStream.class);
	
	private final File tempDir;

	HOutgoingStream(BContentStream innerStream, long lifetimeMillis, File tempDir)  {
		super(innerStream, lifetimeMillis);
		this.tempDir = tempDir;
	}
	
	public InputStream ensureStream() throws IOException {
		if (innerStream instanceof BContentStreamWrapper) {
		  ((BContentStreamWrapper)innerStream).ensureStream();
		}
		return innerStream;
	}

  @Override
  public synchronized BContentStream materialize() throws BException {
    HIncomingStreamSync istrm = null;
    try {
      BContentStream bstream = (BContentStream)ensureStream();
      istrm = new HIncomingStreamSync(bstream, lifetimeMillis, tempDir);
      istrm.assignStream(bstream);
      
      // materialize closes "this"
      this.close();
    } catch (IOException e) {
      throw new BException(BExceptionC.IOERROR, "Failed to clone stream", e);
    }
    return istrm;
  }
}
