/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HEXCEPTION_HPP_
#define HEXCEPTION_HPP_

#include "Bypshttp.h"
#include "HException.h"

namespace byps { namespace http { namespace winhttp {

using namespace byps;

BINLINE LPCWSTR HException::getWinHttpErrorMessage(DWORD err) {
  switch (err) {
    case ERROR_WINHTTP_AUTO_PROXY_SERVICE_ERROR:
      return L"Returned by WinHttpGetProxyForUrl when a proxy for the specified URL cannot be located.";
    case ERROR_WINHTTP_AUTODETECTION_FAILED:
      return L"Returned by WinHttpDetectAutoProxyConfigUrl if WinHTTP was unable to discover the URL of the Proxy Auto-Configuration (PAC) file.";
    case ERROR_WINHTTP_BAD_AUTO_PROXY_SCRIPT:
      return L"An error occurred executing the script code in the Proxy Auto-Configuration (PAC) file.";
    case ERROR_WINHTTP_CANNOT_CALL_AFTER_OPEN:
      return L"Returned by the HttpRequest object if a specified option cannot be requested after the Open method has been called.";
    case ERROR_WINHTTP_CANNOT_CALL_AFTER_SEND: 
      return L"Returned by the HttpRequest object if a requested operation cannot be performed after calling the Send method.";
    case ERROR_WINHTTP_CANNOT_CALL_BEFORE_OPEN:
      return L"Returned by the HttpRequest object if a requested operation cannot be performed before calling the Open method.";
    case ERROR_WINHTTP_CANNOT_CALL_BEFORE_SEND:
      return L"Returned by the HttpRequest object if a requested operation cannot be performed before calling the Send method.";
    case ERROR_WINHTTP_CANNOT_CONNECT:
      return L"Returned if connection to the server failed.";
    case ERROR_WINHTTP_CLIENT_AUTH_CERT_NEEDED:
      return L"The server requires SSL client Authentication.";
//    case ERROR_WINHTTP_CLIENT_CERT_NO_ACCESS_PRIVATE_KEY:
//      return L"The application does not have the required privileges to access the private key associated with the client certificate.";
//    case ERROR_WINHTTP_CLIENT_CERT_NO_PRIVATE_KEY:
//      return L"The context for the SSL client certificate does not have a private key associated with it. The client certificate may have been imported to the computer without the private key.";
    case ERROR_WINHTTP_CHUNKED_ENCODING_HEADER_SIZE_OVERFLOW:
      return L"Returned by WinHttpReceiveResponse when an overflow condition is encountered in the course of parsing chunked encoding.";
//    case ERROR_WINHTTP_CLIENT_AUTH_CERT_NEEDED:
//      return L"Returned by WinHttpReceiveResponse when the server requests client authentication.";
    case ERROR_WINHTTP_CONNECTION_ERROR:
      return L"The connection with the server has been reset or terminated, or an incompatible SSL protocol was encountered. For example, WinHTTP version 5.1 does not support SSL2 unless the client specifically enables it.";
//    case ERROR_WINHTTP_HEADER_ALREADY_EXISTS:
//      return L"Obsolete; no longer used.";
    case ERROR_WINHTTP_HEADER_COUNT_EXCEEDED:
      return L"Returned by WinHttpReceiveResponse when a larger number of headers were present in a response than WinHTTP could receive.";
    case ERROR_WINHTTP_HEADER_NOT_FOUND:
      return L"The requested header cannot be located.";
    case ERROR_WINHTTP_HEADER_SIZE_OVERFLOW:
      return L"Returned by WinHttpReceiveResponse when the size of headers received exceeds the limit for the request handle.";
    case ERROR_WINHTTP_INCORRECT_HANDLE_STATE:
      return L"The requested operation cannot be carried out because the handle supplied is not in the correct state.";
    case ERROR_WINHTTP_INCORRECT_HANDLE_TYPE:
      return L"The type of handle supplied is incorrect for this operation.";
    case ERROR_WINHTTP_INTERNAL_ERROR:
      return L"An internal error has occurred.";
    case ERROR_WINHTTP_INVALID_OPTION:
      return L"A request to WinHttpQueryOption or WinHttpSetOption specified an invalid option value.";
//    case ERROR_WINHTTP_INVALID_QUERY_REQUEST:
//      return L"Obsolete; no longer used.";
    case ERROR_WINHTTP_INVALID_SERVER_RESPONSE:
      return L"The server response cannot be parsed.";
    case ERROR_WINHTTP_INVALID_URL:
      return L"The URL is not valid.";
    case ERROR_WINHTTP_LOGIN_FAILURE:
      return L"The login attempt failed.";
    case ERROR_WINHTTP_NAME_NOT_RESOLVED:
      return L"The server name cannot be resolved.";
//    case ERROR_WINHTTP_NOT_INITIALIZED:
//      return L"Obsolete; no longer used.";
    case ERROR_WINHTTP_OPERATION_CANCELLED:
      return L"The operation was canceled, usually because the handle on which the request was operating was closed before the operation completed.";
    case ERROR_WINHTTP_OPTION_NOT_SETTABLE:
      return L"The requested option cannot be set, only queried.";
//    case ERROR_WINHTTP_OUT_OF_HANDLES:
//      return L"Obsolete; no longer used.";
    case ERROR_WINHTTP_REDIRECT_FAILED:
      return L"The redirection failed because either the scheme changed or all attempts made to redirect failed (default is five attempts).";
    case ERROR_WINHTTP_RESEND_REQUEST:
      return L"The WinHTTP function failed. The desired function can be retried on the same request handle.";
    case ERROR_WINHTTP_RESPONSE_DRAIN_OVERFLOW:
      return L"Returned when an incoming response exceeds an internal WinHTTP size limit.";
    case ERROR_WINHTTP_SECURE_CERT_CN_INVALID:
      return L"Returned when a certificate CN name does not match the passed value (equivalent to a CERT_E_CN_NO_MATCH error).";
    case ERROR_WINHTTP_SECURE_CERT_DATE_INVALID:
      return L"Indicates that a required certificate is not within its validity period when verifying against the current system clock or the timestamp in the signed file, or that the validity periods of the certification chain do not nest correctly (equivalent to a CERT_E_EXPIRED or a CERT_E_VALIDITYPERIODNESTING error).";
    case ERROR_WINHTTP_SECURE_CERT_REV_FAILED:
      return L"Indicates that revocation cannot be checked because the revocation server was offline (equivalent to CRYPT_E_REVOCATION_OFFLINE).";
    case ERROR_WINHTTP_SECURE_CERT_REVOKED:
      return L"Indicates that a certificate has been revoked (equivalent to CRYPT_E_REVOKED).";
    case ERROR_WINHTTP_SECURE_CERT_WRONG_USAGE:
      return L"Indicates that a certificate is not valid for the requested usage (equivalent to CERT_E_WRONG_USAGE).";
    case ERROR_WINHTTP_SECURE_CHANNEL_ERROR:
      return L"Indicates that an error occurred having to do with a secure channel.";
    case ERROR_WINHTTP_SECURE_FAILURE:
      return L"One or more errors were found in the Secure Sockets Layer (SSL) certificate sent by the server.";
    case ERROR_WINHTTP_SECURE_INVALID_CA:
      return L"Indicates that a certificate chain was processed, but terminated in a root certificate that is not trusted by the trust provider (equivalent to CERT_E_UNTRUSTEDROOT).";
    case ERROR_WINHTTP_SECURE_INVALID_CERT:
      return L"Indicates that a certificate is invalid (equivalent to errors such as CERT_E_ROLE, CERT_E_PATHLENCONST, CERT_E_CRITICAL, CERT_E_PURPOSE, CERT_E_ISSUERCHAINING, CERT_E_MALFORMED and CERT_E_CHAINING).";
    case ERROR_WINHTTP_SHUTDOWN:
      return L"The WinHTTP function support is being shut down or unloaded.";
    case ERROR_WINHTTP_TIMEOUT:
      return L"The request has timed out.";
    case ERROR_WINHTTP_UNABLE_TO_DOWNLOAD_SCRIPT:
      return L"The PAC file cannot be downloaded. For example, the server referenced by the PAC URL may not have been reachable, or the server returned a 404 NOT FOUND response.";
    case ERROR_WINHTTP_UNRECOGNIZED_SCHEME: 
      return L"The URL specified a scheme other than \"http:\" or \"https:\".";
  }
  return L"";
}

BINLINE HException::HException(LPCWSTR fnctName, DWORD err) : BException() {

	int32_t code;
	std::wstring msg;
	std::wstring details;

	switch(err) {
	case ERROR_WINHTTP_TIMEOUT : code = BExceptionC::TIMEOUT; break;
	case ERROR_WINHTTP_OPERATION_CANCELLED : code = BExceptionC::CANCELLED; break;
	default : code = BExceptionC::CONNECTION_TO_SERVER_FAILED;
	}

	{
		std::wstringstream ss;
		ss << L"HTTP communication error";
		LPCWSTR winmsg = getWinHttpErrorMessage(err);
		if (winmsg && *winmsg) ss << L": " << winmsg;
		msg = ss.str();
	}

	{
		std::wstringstream ss;
		ss << fnctName << L" failed, windows error code=" << err;
		details = ss.str();
	}

	init(code, msg, details, "");
}

BINLINE HException::HException(DWORD httpStatus) : BException() {

	int32_t code = httpStatus;
	std::wstring msg;

	std::wstringstream ss;
	ss << L"HTTP " << httpStatus;
	msg = ss.str();

	init(code, msg, L"", "");
}

}}}

#endif