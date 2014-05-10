using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    /**
     * BException error codes.
     * This error codes can be set in a BException.  
     * Furthermore, a BException can uses a HTTP status code as error code. 
     */
    public class BExceptionC {

      /**
       * Generator error.
       * This code is used by the generator.
       */
      public const int GENERATOR_EXCEPTION = 1;

      /**
       * Connection failed.
       * A connection could not be established or a 
       * communication error occured (SocketException).
       */
      public const int CONNECTION_TO_SERVER_FAILED = 2;
  
      /**
       * Internal error.
       * Error code for unexpected internal error states.
       * This errors are most likely caused due to a bug in byps.
       */
      public const int INTERNAL = 3;
  
      /**
       * Corrupt stream data.
       * The data to be deserialized is corrupt.
       */
      public const int CORRUPT = 8;
  
      /**
       * Undeclared exception.
       * If an undeclared exception is throw in a remote interface implementation,
       * the peer receives a BException object with this code. 
       * An exception is undeclared if it is not defined in the API package and 
       * is not BException, e.g. NullPointerException.
       */
      public const int REMOTE_ERROR = 10;
  
      /**
       * Service not implemented.
       * This code is used, if a requested remote interface does not have an implementation.
       */
      public const int SERVICE_NOT_IMPLEMENTED = 11; 
  
      /**
       * Server cannot reach client for reverse request.
       * This code is set in a call from server to client or from client to client,
       * if the receiver is no more connected. 
       */
      public const int CLIENT_DIED = 12;
  
      /**
       * Communication error.
       * This code is used, if a stream operation fails.
       */
      public const int IOERROR = 14;

      /**
       * Too many requests.
       * This code is used on the client side, if the thread pool for sending requests is exhausted.
       */
      public const int TOO_MANY_REQUESTS = 15;

      /**
       * This code is used on the client size, if the BTransportFactory object
       * does not support reverse connections. 
       */
      public const int NO_REVERSE_CONNECTIONS = 16;

      /**
       * This code is used, if a remote interface implementation does not support the requested method.
       */
      public const int UNSUPPORTED_METHOD = 17;
  
      /**
       * Operation cancelled.
       * This code is used, if an operation was cancelled or interrupted.
       */
      public const int CANCELLED = 19;

      /**
       * Reverse HTTP request should be sent again.
       * After HConstants#TIMEOUT_LONGPOLL_MILLIS, the server releases
       * a long-poll (reverse) request. The client should open 
       * a new long-poll. The server sends an empty response to the client.
       *  SC_NO_CONTENT
       */
      public const int RESEND_LONG_POLL = 204;

      /* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
      /**
       * This code can be used, if authentication is required for the method.
       * Same as HttpURLConnection.HTTP_UNAUTHORIZED.
       */
      public const int UNAUTHORIZED = 401;
  
      /**
       * This code can be used, if authentication has failed.
       * Same as HttpURLConnection.HTTP_FORBIDDEN.
       */
      public const int FORBIDDEN = 403;

       /**
       * Timeout.
       * This code is used, if an operation exceeds its time limit.
       * HWireClientR sends this code for expired long-polls.
       * Same value as HttpURLConnection.HTTP_CLIENT_TIMEOUT.
       */
      public const int TIMEOUT = 408;
  
      /**
       * Client has already invalidated the session.
       * Same value as HttpURLConnection.HTTP_GONE.
       */
      public const int SESSION_CLOSED = 410;
  
    }
}