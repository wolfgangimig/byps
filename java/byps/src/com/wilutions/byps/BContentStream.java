package com.wilutions.byps;

import java.io.IOException;
import java.io.InputStream;

public abstract class BContentStream extends InputStream {
	
	/**
	 * Default content type: application/octet-stream
	 */
	public final static String DEFAULT_CONTENT_TYPE = "application/octet-stream";

	public BContentStream(String contentType, long contentLength) {
		this.lifetimeMillis = 0;
		this.contentType = contentType != null && contentType.length() != 0 ? contentType : DEFAULT_CONTENT_TYPE;
		this.contentLength = contentLength;
		extendLifetime();
	}
	
	public BContentStream(String contentType, long contentLength, long lifetimeMillis) {
		this.lifetimeMillis = lifetimeMillis;
		this.contentType = contentType != null && contentType.length() != 0 ? contentType : DEFAULT_CONTENT_TYPE;
		this.contentLength = contentLength;
		extendLifetime();
	}
	
	public BContentStream(BContentStream rhs) {
		this.lifetimeMillis = rhs.lifetimeMillis;
		this.contentType = rhs.contentType;
		this.contentLength = rhs.contentLength;
		extendLifetime();
	}
	
	public BContentStream() {
		this.lifetimeMillis = 0;
		this.contentType = DEFAULT_CONTENT_TYPE;
		this.contentLength = -1L;
	}
	
	public String getContentType() {
		return contentType; // e.g. "text/plain; charset=utf-8"
	}
	
	public long getContentLength() {
		return contentLength; // -1 means that length is unknown
	}
	
	public BContentStream cloneInputStream() throws IOException {
		throw new IOException("Stream cannot be cloned.");
	}
	
	public boolean isExpired() {
		boolean exp = lifetimeMillis > 0 && System.currentTimeMillis() > bestBefore;
		return exp;
	}
	
	protected void extendLifetime() {
		bestBefore = lifetimeMillis > 0 ? (System.currentTimeMillis() + lifetimeMillis) : 0;
	}
	
	protected long getLifetimeMillis() {
		return lifetimeMillis;
	}
	
	private volatile long bestBefore;
	protected final long lifetimeMillis;
	protected final String contentType;
	protected final long contentLength;

}
