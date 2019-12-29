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
   * @param trackingId 
   *        An ID that allows to follow requests in the log file. 
   * @param url
   *          URL to GET, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result.
   * @return GET object.
   */
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult);

  /**
   * Create a GET request object to read large streams.
   * 
   * @param trackingId 
   *        An ID that allows to follow requests in the log file. 
   * @param url
   *          URL to GET, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result.
   * @return GET object
   */
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult);

  /**
   * Create a POST request object to send bytes.
   * 
   * @param trackingId 
   *        An ID that allows to follow requests in the log file. 
   * @param url
   *          URL to POST, must address the same server and port as in
   *          {@link #init(String)}.
   * @param buf
   *          Data to be sent.
   * @param asyncResult
   *          Asynchronous result.
   * @return POST object
   */
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult);

  /**
   * Create a PUT request object to send large streams.
   * 
   * @param trackingId 
   *        An ID that allows to follow requests in the log file. 
   * @param url
   *          URL to PUT, must address the same server and port as in
   *          {@link #init(String)}.
   * @param asyncResult
   *          Asynchronous result. Only the exception parameter is used.
   * @return PUT object
   */
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult);
  
  /**
   * Return HTTP session ID.
   * E.g. returns cookie JSESIONID from Tomcat.
   * @return Session ID
   */
  public String getHttpSession();
  
}
