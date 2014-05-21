/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
* BException.h
*
*/

#ifndef BEXCEPTION_H_
#define BEXCEPTION_H_

#include "Byps.h"
#include <exception>

namespace byps {

  using namespace std;

  class BExceptionC {
  public:
    /**
    * Generator error.
    * This code is used by the generator.
    */
    const static int32_t GENERATOR_EXCEPTION = 1;

    /**
    * Connection failed.
    * A connection could not be established or a 
    * communication error occured (SocketException).
    */
    const static int32_t CONNECTION_TO_SERVER_FAILED = 2;

    /**
    * Internal error.
    * Error code for unexpected internal error states.
    * This errors are most likely caused due to a bug in byps.
    */
    const static int32_t INTERNAL = 3;

    /**
    * Corrupt stream data.
    * The data to be deserialized is corrupt.
    */
    const static int32_t CORRUPT = 8;

    /**
    * Undeclared exception.
    * If an undeclared exception is throw in a remote interface implementation,
    * the peer receives a BException object with this code. 
    * An exception is undeclared if it is not defined in the API package and 
    * is not BException, e.g. NullPointerException.
    */
    const static int32_t REMOTE_ERROR = 10;

    /**
    * Service not implemented.
    * This code is used, if a requested remote interface does not have an implementation.
    */
    const static int32_t SERVICE_NOT_IMPLEMENTED = 11; 

    /**
    * Server cannot reach client for reverse request.
    * This code is set in a call from server to client or from client to client,
    * if the receiver is no more connected. 
    */
    const static int32_t CLIENT_DIED = 12;

    /**
    * Communication error.
    * This code is used, if a stream operation fails.
    */
    const static int32_t IOERROR = 14;

    /**
    * Too many requests.
    * This code is used on the client side, if the thread pool for sending requests is exhausted.
    */
    const static int32_t TOO_MANY_REQUESTS = 15;

    /**
    * This code is used on the client size, if the BTransportFactory object
    * does not support reverse connections. 
    */
    const static int32_t NO_REVERSE_CONNECTIONS = 16;

    /**
    * This code is used, if a remote interface implementation does not support the requested method.
    */
    const static int32_t UNSUPPORTED_METHOD = 17;

    /**
    * Operation cancelled.
    * This code is used, if an operation was cancelled or interrupted.
    */
    const static int32_t CANCELLED = 19;

    /**
    * Reverse HTTP request should be sent again.
    * After HConstants#TIMEOUT_LONGPOLL_MILLIS, the server releases
    * a long-poll (reverse) request. The client should open 
    * a new long-poll. The server sends an empty response to the client.
    *  SC_NO_CONTENT
    */
    const static int32_t RESEND_LONG_POLL = 204;

    /**
    * This code can be used, if authentication is required for the method.
    * Same as HttpURLConnection.HTTP_UNAUTHORIZED.
    */
    const static int32_t UNAUTHORIZED = 401;

    /**
    * This code can be used, if authentication has failed.
    * Same as HttpURLConnection.HTTP_FORBIDDEN.
    */
    const static int32_t FORBIDDEN = 403;

    /**
    * Timeout.
    * This code is used, if an operation exceeds its time limit.
    * HWireClientR sends this code for expired long-polls.
    * Same value as HttpURLConnection.HTTP_CLIENT_TIMEOUT.
    */
    const static int32_t TIMEOUT = 408;

    /**
    * Client has already invalidated the session.
    * Same value as HttpURLConnection.HTTP_GONE.
    */
    const static int32_t SESSION_CLOSED = 410;

  };

  class BException : public exception {
  public:

    BException(int32_t code, const wstring& msg) throw();

    BException(int32_t code, const wstring& msg, const wstring& details) throw();

    BException(int32_t code) throw();

    BException(const BException& rhs) throw();

    BException(const exception& ex) throw();

    BException();

    virtual ~BException() throw();

    operator bool() const;

    bool operator !() const;

    int32_t getCode() const;

    wstring getMsg() const;

    wstring getDetails() const;

    wstring toString() const;

    virtual const char* what() const throw();

    void serialize(BIO& bio, const BVERSION version);

  protected:
    struct BExceptionData {
      int32_t code;
      wstring msg;
      wstring details;
      string swhat;
    };

    byps_ptr<BExceptionData> data;

    void init(int32_t code, const wstring& msg, const wstring& details, const string& swhat);
  };

  class BExceptionO {
  public:

    typedef function<wstring (int32_t code, const wstring& msg, const wstring& details, const exception& unused)> FormatMessageFnct;

    static FormatMessageFnct formatMessage;

  };

  
} /* namespace byps */
#endif /* BEXCEPTION_H_ */
