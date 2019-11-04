
package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public class HConstants {

  /**
   * Buffer size for internal processing.
   */
  public final static int DEFAULT_BYTE_BUFFER_SIZE = 10 * 1000;

  /**
   * How long a request can take. A request can last up to this number of
   * milliseconds.
   */
  public static long REQUEST_TIMEOUT_MILLIS = 2 * 60 * 1000L;
  
  /**
   * An incoming stream must be available after this millis.
   */
  public static long INCOMING_STREAM_TIMEOUT_MILLIS = 60 * 1000L;

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
   * A long-poll request is returned at latest after this time. 
   * If no reverse request is made from the server to the client,   
   * the HWireClientR object inside the server releases the long-poll after this 
   * time and sends status code 204 to the client. 
   * The client application (HServerR object) has to ignore this response
   * and has to send a new long-poll.
   * This value should be less than {@link #REQUEST_TIMEOUT_MILLIS}.
   * The client application can override this value by setting 
   * appropriate values in BMessageHeader. This is applied in byps.js 
   * for browser clients, where a timeout of 30s is passed.
   */
  public static long TIMEOUT_LONGPOLL_MILLIS = 1 * 60 * 1000L;

  /**
   * Keep message in memory after it was finished. After a message is canceled,
   * further stream or ByteBuffer information might still received by the
   * server, because the client sends the message data in parallel requests. The
   * server has to know, that this requests must be canceled. The server would
   * otherwise create a new message object. The value is measured in
   * milliseconds.
   */
  public static long KEEP_MESSAGE_AFTER_FINISHED = INCOMING_STREAM_TIMEOUT_MILLIS + CLEANUP_MILLIS;

  /**
   * Use Servlet 3.0 asynchronous processing. 
   * If this option is true, a message with streams can be handled by
   * a single thread. Furthermore, asynchronous processing
   * does not read the entire stream into memory or into a temporary file. 
   * (But I encountered problems with Tomcat
   * 7.0.34 and asynchronous processing: - Tomcat returns sporadically 501 in
   * HWireClient.internalPutStream. I received this error in test case
   * TestRemoteStreams.testRemoteStreamsCloseStreamAfterSend.)
   */
  public final static boolean PROCESS_PUT_STREAM_ASYNC = true;

  /**
   * Process messages asynchronously.
   * Since 5.28, messages have to be processed asynchronously (Servlet 3.0) 
   * in order to support BExceptionC#PROCESSING exceptions. 
   */
  public final static boolean PROCESS_MESSAGE_ASYNC = true;

  /**
   * Incoming streams up to this size are kept in memory. If the stream is
   * large, it is written on disc.
   */
  public final static int INCOMING_STREAM_BUFFER = 1000 * 1000;

  /**
   * HttpSession attribute name for BYPS session ID.
   * Older clients do not send the session ID in the BMessageHeader. For this clients,
   * the server finds the session ID in the application server's session object under 
   * this key. This key stores a set of session IDs, because several BYPS sessions 
   * could use the same application server's session, e.g. if the several sessions 
   * are opened in the same browser window. 
   * @see HHttpSessionObject
   */
  public final static String HTTP_SESSION_BYPS_SESSIONS = "BHttpServlet.Session";

  /**
   * Inactive seconds for non-authenticated session.
   * A J2EE session has to be created in the negotiation request to make sure,
   * that subsequent requests are directed to the same server. This
   * session is still not authenticated, if the negotiation request does
   * not handle HTTP authentication. The lifetime of such an half-life session 
   * is given by this value.
   */
  public final static int MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED = 60;

  /**
   * This option overrides MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED. 
   */
  public final static String OPTION_MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED = "byps.maxSecondsNotAuth";

  /**
   * Retry pause time when connection to server fails.
   * This value is used when connecting from one server to other servers. 
   * If the BClient.start fails for another server, the next retry 
   * to connect will not occur before this pause time has passed.
   */
  public final static long CONNECTION_RETRY_PAUSE = 60 * 1000L;
  
  /**
   * Inactive seconds for authenticated session.
   */
  public final static int DEFAULT_INACTIVE_SECONDS_AUTHENTICATED = 10 * 60;

  /**
   * Send response header Keep-Alive: timeout=...
   * The timeout value is read from the system property "byps.keepAliveTimeoutSeconds".
   * if the system property is not set, the Keep-Alive header is not sent.
   */
  public static final String RESPONSE_HEADER_KEEP_ALIVE_TIMEOUT = "byps.keepAliveTimeoutSeconds";

  
  static
  {
    INCOMING_STREAM_TIMEOUT_MILLIS = getSystemPropertyLong("byps.http.incomingStreamTimeoutSeconds", INCOMING_STREAM_TIMEOUT_MILLIS / 1000) * 1000;
    KEEP_MESSAGE_AFTER_FINISHED = INCOMING_STREAM_TIMEOUT_MILLIS + CLEANUP_MILLIS;
    
    TIMEOUT_LONGPOLL_MILLIS = getSystemPropertyLong("byps.http.longPollTimeoutSeconds", TIMEOUT_LONGPOLL_MILLIS / 1000) * 1000;
    REQUEST_TIMEOUT_MILLIS = getSystemPropertyLong("byps.http.requestTimeoutSeconds", REQUEST_TIMEOUT_MILLIS / 1000) * 1000;    
  }

  private static long getSystemPropertyLong(String prop, long defaultValue) {
    long ret = defaultValue;
    String s = System.getProperty(prop);
    try {
      if (s != null) {
         ret = Long.parseLong(s);
      }
    }
    catch (Exception e) {
      System.err.println("Invalid option " + prop + "=" + s);
      e.printStackTrace();
    }
    return ret;
  }

}
