package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;

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

	private final static Logger log = LoggerFactory.getLogger(HAsyncErrorListener.class);
}
