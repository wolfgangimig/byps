
package com.wilutions.byps.http;

public class HConstants {

  /**
   * Buffer size for internal processing.
   */
  public final static int DEFAULT_BYTE_BUFFER_SIZE = 10 * 1000;

  /**
   * How long a request can take. A request can last up to this number of
   * milliseconds.
   */
  public final static long REQUEST_TIMEOUT_MILLIS = 60 * 60 * 1000L;

  /**
   * Time for internal cleanup operations.
   */
  public final static long CLEANUP_MILLIS = 10 * 1000;

  /**
   * The maximum time the server waits for a long-poll request. If the server
   * has to send a request to the client, it waits at most this number of
   * milliseconds until a timeout exception is thrown.
   */
  public final static long MAX_WAIT_FOR_LONGPOLL_MILLIS = 30 * 1000L;

  /**
   * Keep message in memory after it was finished. After a message is canceled,
   * further stream or ByteBuffer information might still received by the
   * server, because the client sends the message data in parallel requests. The
   * server has to know, that this requests must be canceled. The server would
   * otherwise create a new message object. The value is measured in
   * milliseconds.
   */
  public final static long KEEP_MESSAGE_AFTER_FINISHED = 10L * 1000L;

  /**
   * Use Servlet 3.0 asynchronous processing. I encountered problems with Tomcat
   * 7.0.34 and asynchronous processing: - Tomcat returns sporadically 501 in
   * HWireClient.internalPutStream. I received this error in test case
   * TestRemoteStreams.testRemoteStreamsCloseStreamAfterSend.
   */
  public final static boolean PROCESS_PUT_STREAM_ASYNC = false;

  /**
   * Process reverse HTTP calls asynchronously.
   */
  public final static boolean PROCESS_LONGPOLL_ASYNC = true;

  /**
   * Process messages asynchronously.
   */
  public final static boolean PROCESS_MESSAGE_ASYNC = false;

  /**
   * Incoming streams up to this size are kept in memory. If the stream is
   * large, it is written on disc.
   */
  public final static int INCOMING_STREAM_BUFFER = 1000 * 1000;

  /**
   * HttpSession attribute name for BYPS session.
   */
  public final static String HTTP_SESSION_ATTRIBUTE_NAME = "BHttpServlet.Session";

  /**
   * Inactive seconds before session is authenticated.
   * A J2EE session has to be created in the negotiation request to make sure,
   * that subsequent requests are directed to the same server. This
   * session is still not authenticated, if the negotiation request does
   * not handle HTTP authentication. The lifetime of such an half-life session 
   * is given by this value.
   */
  public final static int MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED = 1000;

  /**
   * Retry pause time when connection to server fails.
   * This value is used when connecting from one server to other servers. 
   * If the BClient.start fails for another server, the next retry 
   * to connect will not occur before this pause time has passed.
   */
  public final static long CONNECTION_RETRY_PAUSE = 60 * 1000L;
  
}
