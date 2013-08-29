package com.wilutions.byps.http;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionO;

public class HIncomingSplittedStreamAsync extends BContentStream {

	private Log log = LogFactory.getLog(HIncomingSplittedStreamAsync.class);
	protected final File tempDir;
	protected final long streamId;
	protected long readPos;
	protected long currentPartId;
	protected HIncomingStreamAsync currentStreamPart;
	private HashMap<Long, HIncomingStreamAsync> streamParts = new HashMap<Long, HIncomingStreamAsync>();
	
	HIncomingSplittedStreamAsync(String contentType, long totalLength, long streamId, long lifetimeMillis, File tempDir) throws IOException {
		super(contentType, totalLength, lifetimeMillis);
		this.streamId = streamId;
		this.tempDir = tempDir;
	}
	
	public synchronized void addStream(long partId, long contentLength, HRequestContext rctxt) throws IOException {
		if (log.isDebugEnabled()) log.debug("addStream(" + streamId + ", partId=" + partId + ", contentLength=" + contentLength);
		HIncomingStreamAsync streamPart = new HIncomingStreamAsync(contentType, contentLength, streamId, lifetimeMillis, tempDir, rctxt);
		streamParts.put(partId, streamPart);
		notifyAll(); // notify thread that might wait in read()
		if (log.isDebugEnabled()) log.debug(")addStream");
	}
	
	@Override
	public void close() throws IOException {
		if (log.isDebugEnabled()) log.debug("close(");
		
		for (HIncomingStreamAsync strm : streamParts.values()) {
			try {
				strm.close();
			}
			catch (IOException ignored) {}
		}
	

		if (log.isDebugEnabled()) log.debug(")close");
	}
	
	private HIncomingStreamAsync getCurrentStreamPart() throws IOException {
		if (currentStreamPart == null) {
			long t1 = System.currentTimeMillis();
			long timeout = lifetimeMillis;
			synchronized(this) {
				currentStreamPart = streamParts.get(currentPartId);
				while (currentStreamPart == null) {
					try {
						wait(timeout);
						long t2 = System.currentTimeMillis();
						if (t2 - t1 > timeout) {
							throw new BException(BExceptionO.TIMEOUT, "Timeout while reading stream part");
						}
					} catch (InterruptedException e) {
						throw new InterruptedIOException();
					}
					currentStreamPart = streamParts.get(currentPartId);
				}
			}
		}
		return currentStreamPart;
	}
	
	private int internalRead(byte[] b, int off, int len) throws IOException {
		int ret = -1;
		if (readPos != contentLength) { 
			HIncomingStreamAsync streamPart = getCurrentStreamPart();
			if (streamPart != null) {
				ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
				if (ret == -1) {
					currentStreamPart.close();
					currentStreamPart = null;
					currentPartId++;
					streamPart = getCurrentStreamPart();
					ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
				}
			}
		}
		
		if (ret != -1) {
			readPos += ret;
		}
		
		return ret;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return internalRead(b, off, len);
	}

	@Override
	public int read() throws IOException {
		return internalRead(null, 0, 0);
	}
	
	@Override
	public synchronized BContentStream cloneInputStream() throws BException {
		if (readPos != 0) throw new BException(BExceptionO.INTERNAL, "InputStream cannot be copied after bytes alread have been read.");
		HIncomingStreamSync istrm = new HIncomingStreamSync(contentType, contentLength, streamId, lifetimeMillis, tempDir);
		try {
			istrm.assignStream(this);
		} catch (IOException e) {
			throw new BException(BExceptionO.IOERROR, "Failed to clone stream", e);
		}
		return istrm;
	}

}
