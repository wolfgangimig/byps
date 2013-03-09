package com.wilutions.byps;

import java.io.IOException;

/**
 * Exceptions of this class are thrown during serialization and communication.
 */
public final class BException extends IOException {
	
	// Die Klasse ist final, weil ich in abgeleiteten Klassen im JSerializer.internalRead 
	// die Elemente code, msg, details nicht setzen kann. 
	
	
	private static final long serialVersionUID = 20L;

	/**
	 * Error code for unexpected internal error states.
	 * This errors are most likely caused due to a bug in byps.
	 */
	public final static int INTERNAL = 3;
	
	/**
	 * The data to be deserialized is corrupt.
	 */
	public final static int CORRUPT = 8;
	
	/**
	 * If an undeclared exception is throw in a remote interface implementation,
	 * the peer receives a BException object with this code. 
	 * An exception is undeclared if it is not defined in the API package and 
	 * is not BException, e.g. NullPointerException.
	 */
	public final static int REMOTE_ERROR = 10;
	
	/**
	 * This code is used, if a requested remote interface does not have an implementation.
	 */
	public final static int SERVICE_NOT_IMPLEMENTED = 11; 
	
	/**
	 * This code is set in a call from server to client or from client to client,
	 * if the receiver is no more connected. 
	 */
	public final static int CLIENT_DIED = 12;
	
	/**
	 * This code is used by the generator.
	 */
	public final static int GENERATOR_EXCEPTION = 1000;

	/**
	 * This code is used, if message data of an already canceled request or stream is accessed.
	 */
	public static final int CANCELED = 100;

	/**
	 * This code is used, if an operation exceeds its time limit.
	 */
	public static final int TIMEOUT = 13;
	
	/**
	 * This code is used, if a stream operation fails.
	 */
	public static final int IOERROR = 14;

	/**
	 * This code is used, if a remote interface implementation does not support the requested method.
	 */
	public static final int UNSUPPORTED_METHOD = 17;

	/**
	 * This code is used on the client side, if the thread pool for sending requests is exhausted.
	 */
	public static final int TOO_MANY_REQUESTS = 15;

	
	/**
	 * Error code.
	 */
	public final int code;
	
	/**
	 * Error message.
	 */
	public final String msg;
	
	/**
	 * Second error message to supply more information.
	 */
	public final String details;
	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 * @param ex Inner exception. The details member is set at ex.toString()
	 */
	public BException(int code, String msg, Throwable ex) {
		super("", ex);
		this.code = code;
		this.msg = msg != null ? msg : "";
		this.details = ex != null ? ex.toString() : "";
	}
	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 * @param details More information about the error
	 */
	public BException(int code, String msg, String details) {
		this.code = code;
		this.msg = msg != null ? msg : "";
		this.details = details != null ? details : "";
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
	 * Return a String of the form [BYPS:code][message][details].
	 * @return Message string
	 */
	@Override
	public String getMessage() {
		return "[BYPS:" + code + "]" +
				"[" + msg + "]" +
				"[" + details + "]";
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
	
}