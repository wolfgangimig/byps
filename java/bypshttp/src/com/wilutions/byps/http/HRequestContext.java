package com.wilutions.byps.http;

import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface HRequestContext {

	public void addListener(AsyncListener lsn);

	public void complete();

	public ServletRequest getRequest();

	public ServletResponse getResponse();

	public void setTimeout(long arg0);

	public void start(Runnable arg0);
	
	public boolean isAsync();
	
}
