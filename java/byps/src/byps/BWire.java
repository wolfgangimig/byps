package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.SecureRandom;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * An object of this class sends and receives bytes.
 * 
 */
public class BWire {
	
	public final static int FLAG_GZIP = 1;
	public final static int FLAG_DEFAULT = 0;
	
	public BWire(int flags) {
		internalInit(flags);
	}
	
	/**
	 * Send bytes in buf and receive result in asyncResult.
	 * Override this function to implement a useful transport of bytes.
	 * Die Funktion wird nur clientseitig benötigt
	 * @param msg
	 * @param asyncResult
	 * @return null oder ein CancelSend-Objekt, dass die Send-Operation abbrechen kann.
	 */
	public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
//		ByteBuffer obuf = ByteBuffer.allocate(msg.buf.remaining());
//		obuf.put(msg.buf);
//		obuf.flip();
//		
//		putStreams(msg.streams, asyncResult);
//		
//		BMessageHeader oheader = new BMessageHeader(msg.header);
//		oheader.flags |= BMessageHeader.FLAG_RESPONSE;
//		BMessage omsg = new BMessage(oheader, obuf, null);
//		asyncResult.setAsyncResult(omsg, null);
	  
	  asyncResult.setAsyncResult(null, new BException(BExceptionC.INTERNAL, "No wire attached to transport."));
	}
	
	/**
	 * Send message with infinite read timeout.
	 * @param msg
	 * @param asyncResult
	 */
	public void sendR(BMessage msg, BAsyncResult<BMessage> asyncResult) {
		send(msg, asyncResult);
	}
	
	/**
	 * Returns a unique message ID.
	 * @return message ID
	 */
	public long makeMessageId() {
		long mid = rand.nextLong();
		if (mid < 0) mid = -mid;
		return mid;
	}
	
	/**
	 * Stellt den Stream zum Versenden bereit.
	 * @param streamRequests Streams to send.
	 * @param asyncResult Result callback.
	 */
	public void putStreams(List<BContentStream> streams, BAsyncResult<BMessage> asyncResult) {
    asyncResult.setAsyncResult(null, new BException(BExceptionC.INTERNAL, "No wire attached to transport."));
	}
	
	/**
	 * Gib den Stream zur ID zurück.
	 * Der Stream wird erst beim ersten read() geöffnet. Bzw. der BLOB wird erst beim ersten read() angefordert.
	 * Funktion wird client- und serverseitig benötigt.
	 * @param targetId Stream target ID
	 * @return BContentStream object.
	 * @throws IOException
	 */
	public BContentStream getStream(BTargetId targetId) throws IOException {
    throw new BException(BExceptionC.INTERNAL, "No wire attached to transport.");
	}
	
	/**
	 * Kill all requests and free resources.
	 */
	public void done() {
	}
	
    public static class InputStreamWrapper extends BContentStreamWrapper {
    	
    	public InputStreamWrapper(BTargetId targetId) {
    	  setTargetId(targetId);
    	}

    }
    
    /**
     * Writes a ByteBuffer to an OutputStream.
     * Closes the OutputStream.
     * @param buf
     * @param os
     * @throws IOException
     */
    public static void bufferToStream(ByteBuffer buf, boolean gzip, OutputStream os) throws IOException {
    	if (gzip) {
    		os = new GZIPOutputStream(os);
    	}
    	
    	WritableByteChannel wch = null;
    	try {
	    	wch = Channels.newChannel(os);
	    	wch.write(buf);
    	}
    	finally {
    		if (wch != null) wch.close();
    	}
    }
    
	public static ByteBuffer bufferFromStream(InputStream is) throws IOException {
		return bufferFromStream(is, null);
	}
	
    /**
     * Reads a ByteBuffer from an InputStream
     * Closes the InputStream.
     * @param is
     * @return
     * @throws IOException
     */
	public static ByteBuffer bufferFromStream(InputStream is, Boolean gzip) throws IOException {
		if (is == null) return null;
		try {
			ByteBuffer ibuf = ByteBuffer.allocate(10 * 1000);
			
			if (gzip != null) {
				if (gzip) {
					is = new GZIPInputStream(is);
				}
			}
			else {
				if (!is.markSupported()) is = new BufferedInputStream(is, 2);
				is.mark(2);
				int magic = is.read() | (is.read() << 8);
				is.reset();
				if (magic == GZIPInputStream.GZIP_MAGIC) {
					is = new GZIPInputStream(is);
				}
			}
			
	        ReadableByteChannel rch = Channels.newChannel(is);
	        while (rch.read(ibuf) != -1) {
	        	if (ibuf.remaining() == 0) {
	        		ByteBuffer nbuf = ByteBuffer.allocate(ibuf.capacity() * 2);
	        		ibuf.flip();
	        		nbuf.put(ibuf);
	        		ibuf = nbuf;
	        	}
	        }
	        
	        ibuf.flip();
	        return ibuf;
		}
		finally {
			is.close();
		}
	}

	public Object getSessionContext() {
		return sess;
	}
	
	public void setSessionContext(Object sess) {
		this.sess = sess;
	}
	
	public static class Statistics
	{
		public long bytesSent;
		public long bytesReceived;
		public long millisSent;
		public long millisReceived;
		public long countSent;
		public long countReceived;
		
		public Statistics() {
		}
		
		public Statistics(Statistics rhs) {
			this.bytesSent = rhs.bytesSent;
			this.bytesReceived = rhs.bytesReceived;
			this.millisSent = rhs.millisSent;
			this.millisReceived = rhs.millisReceived;
			this.countSent = rhs.countSent;
			this.countReceived = rhs.countReceived;
		}
		
		public void addSendData(long bytes, long millis) {
			bytesSent += bytes; 
			millisSent += millis;
			countSent++;
		}
		
		public void addRecvData(long bytes, long millis) {
			bytesReceived += bytes; 
			millisReceived += millis;
			countReceived++;
		}
		
	}
	
	public Statistics getStatistics() {
		return null;
	}
	
	public void clearStatistics() {
	}

	public static class OutputStreamByteCount extends OutputStream {
		public long sum;
		protected final OutputStream os;
		
		public OutputStreamByteCount(OutputStream arg0) throws IOException {
			this.os = arg0;
		}
		
		@Override
		public void write(int arg0) throws IOException {
			os.write(arg0);
			sum++;
		}

		@Override
		public void write(byte[] buf, int off, int len) throws IOException {
			os.write(buf, off, len);
			sum += len;
		}
		
		@Override
		public void write(byte[] b) throws IOException {
			os.write(b);
			sum += b.length;
		}
		
		@Override
		public void close() throws IOException {
			os.close();
		}
		
		@Override
		public void flush() throws IOException {
			os.flush();
		}
	}
	
	public static class InputStreamByteCount extends InputStream {
		public long sum;
		protected InputStream is;

		public InputStreamByteCount(InputStream arg0) throws IOException {
			this.is = arg0;
		}
		
		@Override
		public int read(byte[] buf, int off, int len) throws IOException {
			int count = is.read(buf, off, len);
			if (count > 0) sum += count;
			return count;
		}
		
		public int read() throws IOException {
			sum++;
			return is.read();
		};
		
		@Override
		public int read(byte[] b) throws IOException {
			int count = super.read(b);
			if (count > 0) sum += count;
			return count;
		}

		@Override
		public int available() throws IOException {
			return is.available();
		}
		
		@Override
		public void close() throws IOException {
			is.close();
		}
		
		@Override
		public synchronized void mark(int readlimit) {
			is.mark(readlimit);
		}
		
		@Override
		public boolean markSupported() {
			return is.markSupported();
		}
		
		@Override
		public synchronized void reset() throws IOException {
			is.reset();
		}
		
		@Override
		public long skip(long n) throws IOException {
			return is.skip(n);
		}
	}
	
	protected void internalInit(int flags) {
		if (log.isDebugEnabled()) log.debug("internalInit(");
		rand = new SecureRandom();
		this.flags = flags;
		if (log.isDebugEnabled()) log.debug(")internalInit");
	}

	public boolean isRetryException(Throwable e) {
		return false;
	}
	
	public int getFlags() {
		return flags;
	}
	
	public BTestAdapter getTestAdapter() {
		return null;
	}
	
	public long getInvalidUntilMillis() {
	  return 0;
	}
	
  public BTargetId getTargetId() {
    return targetId;
  }

  public void setTargetId(BTargetId targetId) {
    this.targetId = targetId;
  }

  public String toString() {
    return "[]";
  }

  protected SecureRandom rand;
	protected Object sess;
	protected int flags;
	private final static Log log = LogFactory.getLog(BWire.class);
  private volatile BTargetId targetId = BTargetId.ZERO;

}
