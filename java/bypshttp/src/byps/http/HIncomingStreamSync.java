package byps.http;
import java.io.BufferedInputStream;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BTargetId;

public class HIncomingStreamSync extends BContentStream {
	
	private final Logger log = LoggerFactory.getLogger(HIncomingStreamSync.class);
	private final static int NO_BYTES = 0;
	private final static int FIRST_BYTES = 1;
	private final static int SECOND_BYTES = 2;
	private final static int FILE_BYTES = 3;
	
	private int bytesSource = NO_BYTES;
	private int readPos;
	private int markPos;
	private byte[] firstBytes;
	private byte[] secondBytes;
	private BufferedInputStream fis;
	private HTempFile file;
	private boolean closed;
	private byte[] readBuf1 = new byte[1];
	
	private int secondBytesWritePos;
	private final int secondBytesCapacity = HConstants.INCOMING_STREAM_BUFFER; 
	private FileOutputStream fos;
	protected IOException ex;
	
	private volatile boolean writeClosed;
	private volatile long lastPartId;

	private File tempDir;
	
	protected HIncomingStreamSync(BTargetId targetId, String contentType, long contentLength, String contentDisposition, long lifetimeMillis, File tempDir) {
		super(contentType, contentLength, lifetimeMillis);
		this.setTargetId(targetId);
		this.tempDir = tempDir;
		if (contentLength > secondBytesCapacity) {
			bytesSource = FILE_BYTES;
		}
    setContentDisposition(contentDisposition);
	}
	
	/**
	 * Copy constructor.
	 * Called when HIncomingSplittetStreamAsync or HIncomingStreamSync is cloned.
	 * @param rhs
	 * @param lifetimeMillis
	 * @param tempDir
	 */
	protected HIncomingStreamSync(BContentStream rhs, long lifetimeMillis, File tempDir) {
	  super(rhs, lifetimeMillis);
    this.tempDir = tempDir;
	}
	
	@Override
	public synchronized long getContentLength() {
		if (log.isDebugEnabled()) log.debug("getContentLength(");
	  long ret = super.getContentLength();
	  if (ret < 0) {
	  
	    if (log.isDebugEnabled()) log.debug("writeClosed={}", writeClosed);
  		while (!writeClosed) {
  			try {
  			  if (log.isDebugEnabled()) log.debug("wait 10s for writeClosed");
  				wait(10*1000);
  			} catch (InterruptedException e) {
  				throw new IllegalStateException("Interrupted", e);
  			}
  		}
  		
  		if (log.isDebugEnabled()) log.debug("bytesSource={}", bytesSourceToString());
  		switch (bytesSource) {
  			case FIRST_BYTES: 
  			  ret = (long)firstBytes.length; 
  			  break;
  			case SECOND_BYTES: 
  			  ret = (long)secondBytesWritePos; 
  			  break;
  			case FILE_BYTES: 
  			  ret = file.getFile().length(); 
  			  break;
  		}
  		
  		setContentLength(ret);
	  }
	  
		if (log.isDebugEnabled()) log.debug(")getContentLength={}", ret);
		return ret;
	}
	
	protected synchronized void assignBytes(byte[] buf, int len) {
	  if (log.isDebugEnabled()) log.debug("assignBytes({}", buf != null ? Integer.toString(buf.length) : "null");
		this.secondBytes = buf;
		this.secondBytesWritePos = len; // used in getContentLength() to determine the stream length
		this.bytesSource = SECOND_BYTES;
		this.readPos = 0;
		this.writeClosed = true;
		if (log.isDebugEnabled()) log.debug(")assignBytes");
	}
	
	protected synchronized void assignFile(HTempFile file) {
	  if (log.isDebugEnabled()) log.debug("assignFile({}", file);
		this.file = file;
		this.file.addref();
		this.bytesSource = FILE_BYTES;
		this.readPos = 0;
		this.writeClosed = true;
		this.setContentLength(file.getFile().length());
		if (log.isDebugEnabled()) log.debug(")assignFile");
	}
	
	protected void assignStream(InputStream is) throws IOException {
	  if (log.isDebugEnabled()) log.debug("assignStream(is={}", is);
		byte[] bytes = new byte[HConstants.DEFAULT_BYTE_BUFFER_SIZE];
		int len = 0;
		long sum = 0;
		
		if (log.isDebugEnabled()) log.debug("is.read...");
		
		while ((len = is.read(bytes)) != -1) {
		  if (log.isDebugEnabled()) log.debug("is.read(buf, 0, {})={}", bytes.length, len);
			write(bytes, 0, len);
			if (log.isDebugEnabled()) log.debug("this.write(buf, 0, {})", len);
			sum += len;
		}
		
		if (log.isDebugEnabled())log.debug("read #bytes={}", sum);

		writeClose();

    setContentLength(sum);
    
    if (log.isDebugEnabled()) log.debug(")assignStream");
	}
	
	private  String bytesSourceToString() {
	  StringBuilder sbuf = new StringBuilder();
	  sbuf.append("[");
	  sbuf.append("FIRST_BYTES=");
	  if (firstBytes != null) {
	    sbuf.append("#").append(firstBytes.length);
	  }
	  else {
	    sbuf.append("null");
	  }
	  sbuf.append(",SECOND_BYTES=");
    if (secondBytes != null) {
      sbuf.append("#").append(secondBytes.length);
    }
    else {
      sbuf.append("null");
    }
    sbuf.append(",FILE_BYTES=").append(fos);
    sbuf.append("]");
    return sbuf.toString();
	}
	
	@Override
	public synchronized void reset() throws IOException {
	  if (log.isDebugEnabled())log.debug("reset(");
	  if (log.isDebugEnabled())log.debug("bytesSource={}", bytesSourceToString());
	  if (bytesSource == FILE_BYTES) {
	    if (fis != null) {
	      if (log.isDebugEnabled())log.debug("fis.reset()");
	      fis.reset();
	    }
	  }
	  else {
	    if (log.isDebugEnabled())log.debug("set readPos={} = markPos={}", readPos, markPos);
	    readPos = markPos;
	  }
	  if (log.isDebugEnabled()) log.debug(")reset");
	}
	
	@Override
	public synchronized void mark(int readlimit) {
	  if (log.isDebugEnabled())log.debug("mark({}", readlimit);
	  if (log.isDebugEnabled())log.debug("bytesSource={}", bytesSourceToString());
    if (bytesSource == FILE_BYTES) {
      try {
        ensureFileInputStream();
      } catch (FileNotFoundException e) {
        throw new IllegalStateException(e);
      }
      if (log.isDebugEnabled())log.debug("fis.mark()");
      fis.mark(readlimit);
    }
    else {
      if (log.isDebugEnabled())log.debug("set markPos={} = readPos={}", markPos, readPos);
      markPos = readPos;
    }
    if (log.isDebugEnabled()) log.debug(")mark");
	}
	
	@Override
	public boolean markSupported() {
	  return true;
	}
	
	public void addStream(HRequestContext rctxt, long partId, boolean lastPart) throws BException {
		if (log.isDebugEnabled()) log.debug("addStream " + targetId + "(partId=" + partId + ", lastPart="  + lastPart);
		
		InputStream is = null;
		try {
			is = rctxt.getRequest().getInputStream();
			if (log.isDebugEnabled()) log.debug("is={}", is);

			if (log.isDebugEnabled()) log.debug("lastPartId={}", lastPartId);
			if (partId == 0 && lastPartId == 0) {
				// OK
			}
			else if (lastPartId + 1 == partId) {
				// OK
				lastPartId = partId;
			}
			else {
				throw new BException(BExceptionC.IOERROR, "Unexpected stream part.");
			}
			
			byte[] bytes = new byte[HConstants.DEFAULT_BYTE_BUFFER_SIZE];
			int len = 0;
			long sum = 0;
			
			if (log.isDebugEnabled()) log.debug("is.read...");
			while ((len = is.read(bytes)) != -1) {
			  if (log.isDebugEnabled()) log.debug("is.read(buf, 0, {})={}", bytes.length, len);
				write(bytes, 0, len);
				if (log.isDebugEnabled()) log.debug("this.write(buf, 0, {})", len);
			}
			
			if (log.isDebugEnabled())log.debug("read #bytes={}", sum);
			
		}
		catch (Throwable e) {
			if (log.isDebugEnabled()) log.debug("exception: ", e);
			BException bex = new BException(BExceptionC.IOERROR, "Failed to copy received bytes into buffer.", e);
			this.ex = bex;
			throw bex;
		}
		finally {
			if (is != null) {
				try { is.close(); }	catch (IOException ignored) {}
			}
			
			// Received all bytes?
			if (log.isDebugEnabled())log.debug("received all bytes? lastPart={}", lastPart);
			if (lastPart) {
				writeClose();
			}
		}
		if (log.isDebugEnabled()) log.debug(")addStream");
	}

	@Override
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[");
		sbuf.append(super.toString());
		if (file != null) sbuf.append(",file=").append(file);
		if (firstBytes != null) sbuf.append(",#bytes=" + firstBytes.length);
		if (secondBytes != null) sbuf.append(",#bytes=" + secondBytes.length);
		sbuf.append(",readPos=" + readPos);
		sbuf.append(",closed=" + closed);
		sbuf.append("]");
		return sbuf.toString();
	}
	
	@Override
	public BContentStream materialize() throws IOException {
	  if (log.isDebugEnabled()) log.debug("materialize(");
		BContentStream is = cloneStream();
	  
	  // Materialize closes "this"
		if (log.isDebugEnabled()) log.debug("this.close()");
	  this.close();
	  
	  if (log.isDebugEnabled()) log.debug(")materialize={}", is);
		return is;
	}
	
	public BContentStream cloneStream() throws IOException {
	  if (log.isDebugEnabled()) log.debug("cloneStream(");
	  
	  HIncomingStreamSync is = new HIncomingStreamSync(this, lifetimeMillis, tempDir);
	  
    switch (bytesSource) {
      case FIRST_BYTES: 
        is.assignBytes(firstBytes, firstBytes.length);
        break;
      case SECOND_BYTES: 
        is.assignBytes(secondBytes, secondBytesWritePos);
        break;
      case FILE_BYTES: 
        is.assignFile(file);
        break;
      case NO_BYTES:
      default:
        is.writeClose();
        break;
    }
	  
//    is.assignStream(this);
//    
//    // Reset this stream to the start position.
//    // BYPS-43
//    if (bytesSource == FILE_BYTES) {
//      if (fis != null) {
//        try {
//          fis.close();
//        }
//        catch (IOException e) {
//          // ignored
//        }
//        fis = null;
//      }
//    }
//    else {
//      markPos = 0;
//      readPos = 0;
//    }
    
    if (log.isDebugEnabled()) log.debug(")cloneStream={}", is);
    return is;
	}
	
	@Override
	protected void finalize() throws Throwable {
		close(); // make sure the internally used file is deleted.
	}
	
	@Override
	public int read() throws IOException {
		int c = read(readBuf1);
		if (c < 0) return c;
		c = ((int)readBuf1[0]) & 0xFF;
		return c;
	}
	
	@Override
	public int read(byte[] arg0) throws IOException {
		return read(arg0, 0, arg0.length);
	}
	
	@Override
	public synchronized int read(byte[] b, int offs, int len) throws IOException {
	  if (log.isDebugEnabled()) log.debug("read(b, offs={}, len={}", offs, len);
		long t1 = System.currentTimeMillis();
		int bytesRead = -1;


		while (true) {
			
		  if (log.isDebugEnabled()) log.debug("bytesSource={}, readPos={}, ex={}, closed={}", bytesSourceToString(), readPos, ex != null, closed);

		  if (ex != null) throw ex;
			if (closed) throw new IOException("Stream closed");

			if (bytesSource == NO_BYTES) {
				// noch keine bytes empfangen in write()
				if (log.isDebugEnabled()) log.debug("NO_BYTES");
			}
			else if (bytesSource == FIRST_BYTES) {
				bytesRead = Math.min(firstBytes.length - readPos, len);
				if (log.isDebugEnabled()) log.debug("FIRST_BYTES, #bytesRead=" + bytesRead);
				if (bytesRead > 0) {
					System.arraycopy(firstBytes, readPos, b, offs, bytesRead);
					readPos += bytesRead;
					break;
				}
			}
			else if (bytesSource == SECOND_BYTES) {
				bytesRead = Math.min(secondBytesWritePos - readPos, len);
				if (log.isDebugEnabled()) log.debug("SECOND_BYTES, #bytesRead=" + bytesRead);
				if (bytesRead > 0) {
					System.arraycopy(secondBytes, readPos, b, offs, bytesRead);
					readPos += bytesRead;
					break;
				}
			}
			else if (bytesSource == FILE_BYTES) {
			  if (file != null) {
			    ensureFileInputStream();
			    fis.skip(readPos);
  				bytesRead = fis.read(b, offs, len);
  				if (bytesRead >= 0) {
  					break;
  				}
			  }
			}
			else {
				throw new IllegalStateException("Illegal bytesSource=" + bytesSource);
			}
			
			if (log.isDebugEnabled()) log.debug("writeClosed={}", writeClosed);
			if (writeClosed) {
				bytesRead = -1;
				break;
			}
			
			try {
				long to = getLifetimeMillis();
				if (log.isDebugEnabled()) log.debug("wait for targetId=" + targetId + " for reading");
				this.wait(to);
				
				long t2 = System.currentTimeMillis();
				if (t2-t1 >= to) {
					if (log.isDebugEnabled()) log.debug("timeout while waiting for targetId=" + targetId);
					throw new IOException("Timeout");
				}

				if (log.isDebugEnabled()) log.debug("received singal, continue read");
				
			} catch (InterruptedException e) {
				if (log.isDebugEnabled()) log.debug("waiting for targetId=" + targetId + " interrupted");
				throw new InterruptedIOException();
			}
		}
		
		if (log.isDebugEnabled()) log.debug("exctendLifetime()");
		extendLifetime();
		
		if (log.isDebugEnabled()) log.debug(")read={}", bytesRead);
		return bytesRead;
	}
	
	private InputStream ensureFileInputStream() throws FileNotFoundException {
	  if (fis == null) {
	    fis = new BufferedInputStream(new FileInputStream(file.getFile()));
	    if (log.isDebugEnabled()) log.debug("ensureFileInputStream, file={}", file);
	  }
	  return fis;
	}
	
	@Override
	public synchronized int available() throws IOException {
	  if (log.isDebugEnabled()) log.debug("available(");
    if (log.isDebugEnabled()) log.debug("bytesSource={}, readPos={}, ex={}, closed={}", bytesSourceToString(), readPos, ex != null, closed);

		if (ex != null) throw ex;
		if (closed) throw new IOException("Stream closed");
		
		int n = 0;
		synchronized(HIncomingStreamSync.this) {
			switch (bytesSource) {
			case NO_BYTES:
			  n = 0;
			  break;
			case FIRST_BYTES:
				n = firstBytes != null ? (firstBytes.length - readPos) : 0;
				break;
			case SECOND_BYTES:
				n = secondBytes != null ? (secondBytes.length - readPos) : 0;
				break;
			case FILE_BYTES:
				n = fis != null ? fis.available() : 0;
				break;
			default:
				throw new IllegalStateException("Illegal bytesSource=" + bytesSource);
			}
			extendLifetime();
		}
		
		if (log.isDebugEnabled()) log.debug(")available={}", n);
		return n;
	}

	@Override
	public synchronized long skip(long bytesToskip) throws IOException {
	  if (log.isDebugEnabled()) log.debug("skip(bytesToSkip={}", bytesToskip);
	  if (log.isDebugEnabled()) log.debug("bytesSource={}, readPos={}, ex={}, closed={}", bytesSourceToString(), readPos, ex != null, closed);

		if (ex != null) throw ex;
		if (closed) throw new IOException("Stream closed");

		if (bytesToskip < 0) throw new IllegalArgumentException("n must be positive");
		if (bytesToskip == 0) return 0;
		
		long bytesSkipped = 0;
		
		switch(bytesSource) {
		case FIRST_BYTES:
		case SECOND_BYTES:
			{
				byte[] buf = bytesSource == FIRST_BYTES ? firstBytes : secondBytes;
				if (buf != null) {
					if (bytesToskip <= Integer.MAX_VALUE){
						int i = (int)bytesToskip;
						if (readPos + i > buf.length) {
							i = buf.length - readPos;
						}
						readPos += i;
						bytesSkipped = (long)i;
					}
					else {
						readPos = buf.length;
						bytesSkipped = (long)(buf.length - readPos);
					}
				}
			}
			break;
		case FILE_BYTES:
			bytesSkipped = fis != null ? fis.skip(bytesToskip) : 0;
			break;
		default:
			throw new IllegalStateException("Illegal bytesSource=" + bytesSource);
		}
		
    if (log.isDebugEnabled()) log.debug("bytesSource={}, readPos={}, ex={}, closed={}", bytesSourceToString(), readPos, ex != null, closed);

		extendLifetime();

		if (log.isDebugEnabled()) log.debug(")skip={}", bytesSkipped);
		return bytesSkipped;
	}
	
	private boolean internalWriteSecondBytes(byte[] bytes, int offs, int len) throws IOException {
	  if (log.isDebugEnabled()) log.debug("internalWriteSecondBytes(b={}, offs={}, len={}", bytes, offs, len);
		boolean succ = false;
		
		if (log.isDebugEnabled()) log.debug("secondBytesWritePos={}, secondBytesCapacity={}", secondBytesWritePos, secondBytesCapacity);
		
		if (secondBytesWritePos + len <= secondBytesCapacity) {
			if (secondBytes == null) {
				secondBytes = new byte[secondBytesCapacity];
			}
			System.arraycopy(bytes, offs, secondBytes, secondBytesWritePos, len);
			secondBytesWritePos += len;
			succ = true;
		}
		
    if (log.isDebugEnabled()) log.debug("secondBytesWritePos={}, secondBytesCapacity={}", secondBytesWritePos, secondBytesCapacity);

		if (log.isDebugEnabled()) log.debug(")internalWriteSecondBytes={}", succ);
		return succ;
	}
	
	private void internalWriteFileBytes(byte[] bytes, int offs, int len) throws IOException {
	  if (log.isDebugEnabled()) log.debug("internalWriteFileBytes(bytes, offs={}, len={}", bytes, offs, len);
		if (file == null) {
			file = HTempFile.createTemp(tempDir, targetId.getStreamId());
			fos = new FileOutputStream(file.getFile());
			if (log.isDebugEnabled()) log.debug("opened file={}, fos={}", file, fos);
		}
		fos.write(bytes, offs, len);
		if (log.isDebugEnabled()) log.debug(")internalWriteFileBytes");
	}
	
	public synchronized void write(byte[] bytes, int offs, int len) throws IOException {
	  if (log.isDebugEnabled()) log.debug("write(bytes, offs={}, len={}", offs, len);
	  
    if (log.isDebugEnabled()) log.debug("bytesSource={}, writeClosed={}", bytesSourceToString(), writeClosed);

		try {
			
			if (writeClosed) {
				if (log.isDebugEnabled()) log.debug("stream already closed.");
				throw new IOException("Stream closed");
			}
			
			if (bytesSource == NO_BYTES) {
				if (log.isDebugEnabled()) log.debug("write first bytes");
				firstBytes = new byte[len];
				System.arraycopy(bytes, offs, firstBytes, 0, len);
				bytesSource = FIRST_BYTES;
			}
			else if (bytesSource == FIRST_BYTES) {
			  if (log.isDebugEnabled()) log.debug("write second or file bytes");
				if (firstBytes.length + len <= secondBytesCapacity) {
					internalWriteSecondBytes(firstBytes, 0, firstBytes.length);
					internalWriteSecondBytes(bytes, offs, len);
					bytesSource = SECOND_BYTES;
				}
				else {
					internalWriteFileBytes(firstBytes, 0, firstBytes.length);
					internalWriteFileBytes(bytes, offs, len);
					bytesSource = FILE_BYTES;
					secondBytes = null;
				}
				firstBytes = null;
			}
			else if (bytesSource == SECOND_BYTES) {
			  if (log.isDebugEnabled()) log.debug("write second or file bytes");
				if (!internalWriteSecondBytes(bytes, offs, len)) {
					internalWriteFileBytes(secondBytes, 0, secondBytesWritePos);
					internalWriteFileBytes(bytes, offs, len);
					bytesSource = FILE_BYTES;
					secondBytes = null;
				}
			}
			else if (bytesSource == FILE_BYTES) {
				internalWriteFileBytes(bytes, offs, len);
			}
			
			if (log.isDebugEnabled()) log.debug("bytesSource={}, writeClosed={}", bytesSourceToString(), writeClosed);
		}
		catch (IOException e) {
			if (log.isDebugEnabled()) log.debug("exception: ", e);
			if (ex != null) ex = e;
			throw e;
		}
		finally {
		  if (log.isDebugEnabled()) log.debug("this.notifyAll()");
			this.notifyAll();
		}
		
		if (log.isDebugEnabled()) log.debug(")write");
	}
	
	public synchronized void writeClose() {
		if (log.isDebugEnabled()) log.debug("writeClose(");
		writeClosed = true;
		
		if (fos != null) {
		  if (log.isDebugEnabled()) log.debug("fos.close()");
			try { fos.close(); } catch (IOException ignored) {}
			fos = null;
		}
		
		if (log.isDebugEnabled()) log.debug("notify threads waiting for targetId=" + targetId);
		this.notifyAll();
		if (log.isDebugEnabled()) log.debug(")writeClose");
	}
	
	@Override
	public synchronized void close() throws IOException {
		if (log.isDebugEnabled()) log.debug("close(");
		writeClose();
		
		closed = true;
		
		if (fis != null) {
			fis.close();
			fis = null;
		}
		
		if (file != null) {
			file.release();
			file = null;
		}
		
		firstBytes = null;
		secondBytes = null;
		
    // Causes isExpired() to return true
		super.close();
		
		if (log.isDebugEnabled()) log.debug(")close");
	}
	
}
