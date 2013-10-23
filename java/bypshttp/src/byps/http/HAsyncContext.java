package byps.http;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HAsyncContext implements HRequestContext {
	
	private AsyncContext actxt;
	
	public HAsyncContext(AsyncContext actxt) {
		this.actxt = actxt;
	}

	@Override
	public void addListener(AsyncListener arg0) {
		actxt.addListener(arg0);
	}

	@Override
	public void complete() {
		actxt.complete();
	}

	@Override
	public ServletRequest getRequest() {
		return actxt.getRequest();
	}

	@Override
	public ServletResponse getResponse() {
		return actxt.getResponse();
	}

	@Override
	public void setTimeout(long arg0) {
		actxt.setTimeout(arg0);
	}

	@Override
	public void start(Runnable arg0) {
		actxt.start(arg0);
	}

	@Override
	public boolean isAsync() {
		return true;
	}
}
