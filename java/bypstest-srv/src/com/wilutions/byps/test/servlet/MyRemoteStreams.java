package com.wilutions.byps.test.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BContentStreamWrapper;
import com.wilutions.byps.BException;
import com.wilutions.byps.BWire;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteStreams;

public class MyRemoteStreams extends BSkeleton_RemoteStreams {
	
	private Log log = LogFactory.getLog(MyRemoteStreams.class);
	private volatile BContentStream imageStream;
	private volatile Map<Integer, ByteBuffer> mapStreamBytes;
	private volatile BException lastException;
	
	void done() {
		closeImageStream();
	}

	protected void closeImageStream() {
		if (imageStream != null) {
			try {
				imageStream.close();
			} catch (IOException e) {
			}
			imageStream = null;
		}
	}
	
	@Override
	public void setImage(InputStream istrm) throws BException, InterruptedException {
		if (log.isDebugEnabled()) log.debug("setImage(" + istrm);
		closeImageStream();
		if (istrm != null) {
			try {
				// Clone the stream to be able to store it in a member variable
				imageStream = ((BContentStream)istrm).cloneInputStream();
			} catch (IOException e) {
				throw new BException(BException.IOERROR, "", e);
			}
		}
		if (log.isDebugEnabled()) log.debug(")setImage");
	}
	
	@Override
	public InputStream getImage() throws BException, InterruptedException {
		if (log.isDebugEnabled()) log.debug("getImage(");
		InputStream istrm;
		try {
			istrm = imageStream.cloneInputStream();
		} catch (IOException e) {
			throw new BException(BException.IOERROR, "", e);
		}
		if (log.isDebugEnabled()) log.debug(")getImage=" + istrm);
		return istrm;
	}

	@Override
	public TreeMap<Integer, InputStream> getImages() throws BException,	InterruptedException {
		if (log.isDebugEnabled()) log.debug("getImages(");
		Map<Integer, ByteBuffer> mapStreamBytes = this.mapStreamBytes;
		if (mapStreamBytes == null) return null;
		TreeMap<Integer, InputStream> map = new TreeMap<Integer, InputStream>();
		for (Integer k : mapStreamBytes.keySet()) {
			ByteBuffer buf = mapStreamBytes.get(k);
			InputStream istrm = new ByteArrayInputStream(buf.array(), buf.position(), buf.remaining());
			map.put(k, istrm);
		}
		if (log.isDebugEnabled()) log.debug(")getImages=" + map);
		return map;
	}

	@Override
	public void setImages(Map<Integer, InputStream> istrms, int doNotReadStreamAtKey) throws BException, InterruptedException {
		if (log.isDebugEnabled()) log.debug("setImages(");
		lastException = null;
		mapStreamBytes = new HashMap<Integer, ByteBuffer>(istrms.size());
		for (Integer k : istrms.keySet()) {
			
			// see TestRemoteStreams.testRemoteStreamsCloseStreamAfterSend
			if (k == doNotReadStreamAtKey) {
				if (log.isDebugEnabled()) log.debug("skip stream at key=" + k);
				continue;
			}
			
			InputStream istrm = istrms.get(k);
			if (log.isDebugEnabled()) log.debug("read stream[" + k + "]=" + istrm);
			try {
				ByteBuffer buf = BWire.bufferFromStream(istrm);
				if (log.isDebugEnabled()) log.debug("read buf=" + buf);
				mapStreamBytes.put(k, buf);
			} catch (Throwable e) { // If the underlying message is canceled an this istrm is closed, a NPE can occur deep inside CoyoteInputStream.
				if (log.isDebugEnabled()) log.debug("received exception=" + e);
				lastException = new BException(BException.IOERROR, "", e);
				throw lastException;
			}
		}
		if (log.isDebugEnabled()) log.debug(")setImages");
	}

	@Override
	public void throwLastException() throws BException, InterruptedException {
		if (lastException != null) throw lastException;
	}
	
	@Override
	public InputStream getTextStream() throws BException, InterruptedException {
		final String text = "text-stream euro=€";
		return new BContentStreamWrapper() {
			@Override
			protected InputStream openStream() throws IOException {
				return new ByteArrayInputStream(text.getBytes("UTF-8"));
			}
			@Override
			public String getContentType() {
				return "text/plain; charset=utf-8";
			}
		};
		
	}
}
