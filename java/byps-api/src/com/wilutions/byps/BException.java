package com.wilutions.byps;

import java.io.IOException;


// Die Klasse ist final, weil ich in abgeleiteten Klassen im JSerializer.internalRead 
// die Elemente code, msg, details nicht setzen kann. 
public final class BException extends IOException {
	
	private static final long serialVersionUID = 20L;

	public final static int UNKNOWN_TYPEID = 2;
	public final static int INTERNAL = 3;
	public final static int UNSUPPORTED_OBJECT_TYPE = 4;
	public final static int INVALID_BINARY_MODEL = 5;
	public final static int MESSAGE_TOO_LONG = 7;
	public final static int CORRUPT = 8;
	public final static int EXECUTION = 9;
	public final static int REMOTE_ERROR = 10;
	public final static int SERVICE_NOT_IMPLEMENTED = 11; // Server bietet diesen Service (Remote) nicht an.
	public final static int CLIENT_DIED = 12;	// Client has closed the connection
	public final static int GENERATOR_EXCEPTION = 1000;

	public static final int CANCELED = 100;

	public static final int TIMEOUT = 13;
	public static final int IOERROR = 14;

	public static final int INPUT_STREAM_RECEIVE_ONLY = 16;

	public static final int UNSUPPORTED_METHOD = 17;

	public static final int TOO_MANY_REQUESTS = 15;

	
	
	public final int code;
	public final String msg;
	public final String details;
	
	public BException(int code, String msg, Throwable ex) {
		super("", ex);
		this.code = code;
		this.msg = msg != null ? msg : "";
		this.details = ex != null ? ex.toString() : "";
	}
	public BException(int code, String msg, String details) {
		this.code = code;
		this.msg = msg != null ? msg : "";
		this.details = details != null ? details : "";
	}
	public BException(int code, String msg) {
		this(code, msg, "");
	}
	
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