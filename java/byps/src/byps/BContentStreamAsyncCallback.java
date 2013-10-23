package byps;

public interface BContentStreamAsyncCallback {

  void onReceivedContentType(String contentType);

  void onReceivedContentLength(long contentLength);

  boolean onReceivedData(byte[] buf, int len);

  void onReceivedException(Throwable e);

  void onFinished();

}
