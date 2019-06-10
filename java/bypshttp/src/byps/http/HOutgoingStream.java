package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;

public class HOutgoingStream extends BContentStreamWrapper {
	//private Log log = LogFactory.getLog(HOutgoingStream.class);
	
	private final File tempDir;
	private boolean isOpen;

	HOutgoingStream(BContentStream innerStream, long lifetimeMillis, File tempDir)  {
		super(innerStream, lifetimeMillis);
		this.tempDir = tempDir;
	}
	
	public InputStream ensureStream() throws IOException {
	  
	  if (!isOpen) {
	  
      if (innerStream instanceof BContentStreamWrapper) {
        BContentStreamWrapper bstream = (BContentStreamWrapper)innerStream;
        bstream.ensureStream();
      }
      
      BContentStream bstream = (BContentStream)innerStream;
      bstream.ensureProperties();
      copyProperties(bstream);
      
      isOpen = true;
	  }
	  
	  extendLifetime();
    
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
