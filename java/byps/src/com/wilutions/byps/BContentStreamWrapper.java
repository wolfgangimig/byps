package com.wilutions.byps;

import java.io.IOException;
import java.io.InputStream;

public class BContentStreamWrapper extends BContentStream {
	
	protected volatile InputStream innerStream;

	public BContentStreamWrapper() {
	}
	
	public BContentStreamWrapper(InputStream innerStream) {
		this(innerStream, "application/octet-stream", -1L, 0L);
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
		if (contentType != null && contentType.length() != 0) return contentType;
		if (innerStream instanceof BContentStream) {
			contentType = ((BContentStream)innerStream).getContentType();
			if (contentType != null && contentType.length() != 0) return contentType;
		}
		return DEFAULT_CONTENT_TYPE;
	}
	
	private static long makeValidContentLength(InputStream innerStream, long contentLength) {
		if (contentLength > -1L) return contentLength;
		if (innerStream instanceof BContentStream) {
			contentLength = ((BContentStream)innerStream).getContentLength();
			return contentLength;
		}
		return -1L;
	}
	
	protected InputStream openStream() throws IOException {
		return this.innerStream;
	}
	
	protected InputStream ensureStream() throws IOException {
		if (innerStream != null) return innerStream;
		
		synchronized(this) {
			if (innerStream == null) {
				innerStream = openStream();
			}
		}
		
		return innerStream;
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
