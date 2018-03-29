/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * BException error codes.
 * This error codes can be set in a BException.
 * Furthermore, a BException can uses a HTTP status code as error code.
 * Application defined error codes start at value 1000.
 */
public class BExceptionC {
    
    /**
     * Generator error.
     * This code is used by the generator.
     */
    public static let GENERATOR_EXCEPTION : Int32 = 1
    
    /**
     * Connection failed.
     * A connection could not be established or a
     * communication error occured (SocketException).
     */
    public static let CONNECTION_TO_SERVER_FAILED : Int32 = 2
    
    /**
     * Internal error.
     * Error code for unexpected internal error states.
     * This errors are most likely caused due to a bug in byps.
     */
    public static let INTERNAL : Int32 = 3
    
    /**
     * Corrupt stream data.
     * The data to be deserialized is corrupt.
     */
    public static let CORRUPT : Int32 = 8
    
    /**
     * Undeclared exception.
     * If an undeclared exception is throw in a remote interface implementation,
     * the peer receives a BException object with this code.
     * An exception is undeclared if it is not defined in the API package and
     * is not BException, e.g. NullPointerException.
     */
    public static let REMOTE_ERROR : Int32 = 10
    
    /**
     * Service not implemented.
     * This code is used, if a requested remote interface does not have an implementation.
     */
    public static let SERVICE_NOT_IMPLEMENTED : Int32 = 11
    
    /**
     * Server cannot reach client for reverse request.
     * This code is set in a call from server to client or from client to client,
     * if the receiver is no more connected.
     */
    public static let CLIENT_DIED : Int32 = 12
    
    /**
     * Communication error.
     * This code is used, if a stream operation fails.
     */
    public static let IOERROR : Int32 = 14
    
    /**
     * Too many requests.
     * This code is used on the client side, if the thread pool for sending requests is exhausted.
     */
    public static let TOO_MANY_REQUESTS : Int32 = 15
    
    /**
     * This code is used on the client size, if the BTransportFactory object
     * does not support reverse connections.
     */
    public static let NO_REVERSE_CONNECTIONS : Int32 = 16
    
    /**
     * This code is used, if a remote interface implementation does not support the requested method.
     */
    public static let UNSUPPORTED_METHOD : Int32 = 17
    
    /**
     * Operation cancelled.
     * This code is used, if an operation was cancelled or interrupted.
     */
    public static let CANCELLED : Int32 = 19
    
    /**
     * Reverse HTTP request should be sent again.
     * After HConstants#TIMEOUT_LONGPOLL_MILLIS, the server releases
     * a long-poll (reverse) request. The client should open
     * a new long-poll. The server sends an empty response to the client.
     * Same as HttpURLConnection.HTTP_NO_CONTENT.
     */
    public static let RESEND_LONG_POLL : Int32 = 204
    
    /**
     * This code can be used, if authentication is required for the method.
     * Same as HttpURLConnection.HTTP_UNAUTHORIZED.
     */
    public static let UNAUTHORIZED : Int32 = 401
    
    /**
     * This code can be used, if authentication has failed.
     * Same as HttpURLConnection.HTTP_FORBIDDEN.
     */
    public static let FORBIDDEN : Int32 = 403
    
    /**
     * Timeout.
     * This code is used, if an operation exceeds its time limit.
     * Same value as HttpURLConnection.HTTP_CLIENT_TIMEOUT.
     */
    public static let TIMEOUT : Int32 = 408
    
    /**
     * Client has already invalidated the session.
     * Same value as HttpURLConnection.HTTP_GONE.
     */
    public static let SESSION_CLOSED : Int32 = 410
    
}

