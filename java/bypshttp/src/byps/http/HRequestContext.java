package byps.http;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

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