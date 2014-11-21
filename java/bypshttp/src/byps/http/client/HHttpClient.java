package byps.http.client;

import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;

/**
 * Interface for sending and receiving HTTP requests.
 * 
 */
public interface HHttpClient {

  /**
   * Disconnect.
   */
  public void done();

  /**
   * Create a GET request object to read few bytes.
   * 
   * @param url
   *          URL to GET, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result.
   * @return GET object.
   */
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult);

  /**
   * Create a GET request object to read large streams.
   * 
   * @param url
   *          URL to GET, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result.
   * @return GET object
   */
  public HHttpRequest getStream(String url, BAsyncResult<BContentStream> asyncResult);

  /**
   * Create a POST request object to send bytes.
   * 
   * @param url
   *          URL to POST, must address the same server and port as in
   *          {@link #init(String)}.
   * @param buf
   *          Data to be sent.
   * @param asyncResult
   *          Asynchronous result.
   * @return POST object
   */
  public HHttpRequest post(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult);

  /**
   * Create a PUT request object to send large streams.
   * 
   * @param url
   *          URL to PUT, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result. Only the exception parameter is used.
   * @return PUT object
   */
  public HHttpRequest putStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult);

  /**
   * Clear HTTP Session cookie.
   */
  @Deprecated
  public void clearHttpSession();
  
}
