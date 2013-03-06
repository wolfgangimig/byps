package com.wilutions.byps.http;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract class HAsyncErrorListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onTimeout(" + arg0 + ")");
		onError(arg0);
	}
	
	// implemented by subclass
//	@Override
//	public void onError(AsyncEvent arg0) throws IOException {
//	}

	private final Log log = LogFactory.getLog(HAsyncErrorListener.class);
}
