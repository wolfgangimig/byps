package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
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
	
	/**
	 * Returns true, if the request has been completed.
	 * BYPS-39
	 * @return true, if {@link #complete()} has been called.
	 */
	public boolean isCompleted();
	
}