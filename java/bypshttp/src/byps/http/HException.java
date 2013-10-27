package byps.http;

import java.net.HttpURLConnection;

import byps.BException;

public class HException extends BException {

	private static final long serialVersionUID = 20L;
	
	private int statusCode;

//	public HException(int httpStatusCode) {
//		super(BExceptionO.IOERROR, "HTTP " + httpStatusCode, "");
//		statusCode = httpStatusCode;
//	}
//	
	public HException(int httpStatusCode, Throwable e) {
		super(httpStatusCode, "", "", e);
		statusCode = httpStatusCode;
	}
	
  public boolean isTimeout() {
    return statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT;
  }
  
  public boolean isForbidden() {
    return statusCode == HttpURLConnection.HTTP_FORBIDDEN;
  }
  
  public boolean isConnectFailed() {
    return statusCode == 0;
  }
  
  public boolean isSessionDead() {
    return statusCode == HttpURLConnection.HTTP_GONE;
  }
  
}
