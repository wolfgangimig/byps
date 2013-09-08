package com.wilutions.byps;

public class BExceptionC {

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
   * This code can be used, if authentication is required for the method.
   */
  public static final int AUTHENTICATION_REQUIRED = 18;
  
}
