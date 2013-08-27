package com.wilutions.byps;


/**
 * Exceptions of this class are thrown during serialization and communication.
 * The formatted message has the form [BYPS:code][message][details]
 */
public class BException extends com.wilutions.byps.RemoteException {
	
	// This class is declared final, because JSerializer.internalRead of a 
	// child class could not set the final fields of BException.
	
	private static final long serialVersionUID = 20L;

	/**
	 * Internal error.
	 * Error code for unexpected internal error states.
	 * This errors are most likely caused due to a bug in byps.
	 */
	public final static int INTERNAL = 3;
	
	/**
	 * Corrupt stream data.
	 * The data to be deserialized is corrupt.
	 */
	public final static int CORRUPT = 8;
	
	/**
	 * Undeclared exception.
	 * If an undeclared exception is throw in a remote interface implementation,
	 * the peer receives a BException object with this code. 
	 * An exception is undeclared if it is not defined in the API package and 
	 * is not BException, e.g. NullPointerException.
	 */
	public final static int REMOTE_ERROR = 10;
	
	/**
	 * Service not implemented.
	 * This code is used, if a requested remote interface does not have an implementation.
	 */
	public final static int SERVICE_NOT_IMPLEMENTED = 11; 
	
	/**
	 * Server cannot reach client for reverse request.
	 * This code is set in a call from server to client or from client to client,
	 * if the receiver is no more connected. 
	 */
	public final static int CLIENT_DIED = 12;
	
	/**
	 * Generator error.
	 * This code is used by the generator.
	 */
	public final static int GENERATOR_EXCEPTION = 1000;

	/**
	 * Operation cancelled.
	 * This code is used, if an operation was cancelled or interrupted.
	 */
	public static final int CANCELLED = 100;

	/**
	 * Timeout.
	 * This code is used, if an operation exceeds its time limit.
	 */
	public static final int TIMEOUT = 13;
	
	/**
	 * Communication error.
	 * This code is used, if a stream operation fails.
	 */
	public static final int IOERROR = 14;

	/**
	 * Too many requests.
	 * This code is used on the client side, if the thread pool for sending requests is exhausted.
	 */
	public static final int TOO_MANY_REQUESTS = 15;

	/**
	 * This code is used on the client size, if the BTransportFactory object
	 * does not support reverse connections. 
	 */
	public static final int NO_REVERSE_CONNECTIONS = 16;

	/**
	 * This code is used, if a remote interface implementation does not support the requested method.
	 */
	public static final int UNSUPPORTED_METHOD = 17;

	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 * @param ex Inner exception. The details member is set at ex.toString()
	 */
	public BException(int code, String msg, Throwable ex) {
		super(formatMessage(code, msg, ""), ex);
	}
	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 * @param details More information about the error
	 */
	public BException(int code, String msg, String details) {
		super(formatMessage(code, msg, ""));
	}
	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 */
	public BException(int code, String msg) {
		this(code, msg, "");
	}
	
	/**
	 * Constructor
	 * @param str
	 * @param ex
	 */
	public BException(String str, Throwable ex) {
		super(str, ex);
	}
	
	/**
	 * Constructor
	 * @param str
	 */
	public BException(String str) {
		super(str);
	}
	
	/**
	 * Extract the error code.
	 * This function is used to set the error element in the BMessageHeader.
	 * @return
	 */
	public int getCode() {
		int ret = 0;
		String msg = toString();
		if (msg.startsWith("[BYPS:")) {
			int p = msg.indexOf(']', 6);
			if (p >= 0) {
				ret = Integer.parseInt(msg.substring(6, p));
			}
		}
		return ret;
	}
	
	public String toString() {
		// I do not want the class name in the returned string.
		return getMessage();
	}
	
	private static String formatMessage(int code, String msg, String details) {
		return "[BYPS:" + code + "]" +
				"[" + (msg != null ? msg : "") + "]" +
				"[" + (details != null ? details : "") + "]";		
	}
	
}