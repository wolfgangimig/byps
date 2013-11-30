package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public interface BContentStreamAsyncCallback {

  void onReceivedContentType(String contentType);

  void onReceivedContentLength(long contentLength);

  boolean onReceivedData(byte[] buf, int len);

  void onReceivedException(Throwable e);

  void onFinished();

}
