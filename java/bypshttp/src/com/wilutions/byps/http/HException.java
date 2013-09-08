package com.wilutions.byps.http;

import java.net.HttpURLConnection;

import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;

public class HException extends BException {

	private static final long serialVersionUID = 20L;
	
	private int statusCode;

//	public HException(int httpStatusCode) {
//		super(BExceptionO.IOERROR, "HTTP " + httpStatusCode, "");
//		statusCode = httpStatusCode;
//	}
//	
	public HException(int httpStatusCode, Throwable e) {
		super(BExceptionC.IOERROR, "HTTP " + httpStatusCode, e);
		statusCode = httpStatusCode;
	}
	
  public boolean isTimeout() {
    return statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT;
  }
  
  public boolean isForbidden() {
    return statusCode == HttpURLConnection.HTTP_FORBIDDEN;
  }
  
	public static boolean isTimeout(Throwable e) {
    boolean ret = false;
		if (e != null && e instanceof HException) {
			ret = ((HException)e).isTimeout();
		}
		return ret;
	}

  public static boolean isForbidden(Throwable e) {
    boolean ret = false;
    if (e != null && e instanceof HException) {
      ret = ((HException)e).isForbidden();
    }
    return ret;
  }
}
