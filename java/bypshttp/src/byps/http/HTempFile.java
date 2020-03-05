package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File with reference counter.
 * If the reference counter is decremented to zero, the file is deleted.
 */
public class HTempFile {
	private static Logger log = LoggerFactory.getLogger(HTempFile.class);
	private File file;
	private AtomicInteger refCount = new AtomicInteger(1);
	
	public static HTempFile createTemp(File tempDir, long streamId) throws IOException {
		HTempFile t = new HTempFile();
    if (streamId != 0) {
      String fileName = "bupload_" + streamId + ".tmp";
      if (tempDir == null) {
        tempDir = new File(System.getProperty("java.io.tmpdir"), "byps.http.HTempFile");
        tempDir.mkdirs();
      }
      t.file = new File(tempDir, fileName);
    }
    else {
      t.file = File.createTempFile("bupload_", ".tmp", tempDir);
    }
		return t;
	}
	
	public static HTempFile fromFile(File file) {
		HTempFile t = new HTempFile();
		t.file = file;
		return t;
	}
	
	public int addref() {
		if (refCount.get() == 0) throw new IllegalStateException("HTempFile already deleted.");
		int n = refCount.incrementAndGet();
		if (log.isDebugEnabled()) log.debug("file=" + file + ", addref=" + n);
		return n;
	}
	
	public int release() {
		int v = refCount.decrementAndGet();
		if (log.isDebugEnabled()) log.debug("file=" + file + ", release=" + v);
		if (v == 0) {
			if (log.isDebugEnabled()) log.debug("delete temp file=" + file);
			file.delete();
		}
		return v;
	}
	
	public File getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		return "[" + file + ", #refCount=" + refCount + "]";
	}
}
