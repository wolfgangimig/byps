/*
 * BException.h
 *
 */

#ifndef BEXCEPTION_H_
#define BEXCEPTION_H_

#include "Byps.h"
#include <exception>

namespace byps {

const int32_t EX_NO_SERIALIZER = 1;
const int32_t EX_UNKNOWN_TYPEID = 2;
const int32_t EX_INTERNAL = 3;
const int32_t EX_UNSUPPORTED_OBJECT_TYPE = 4;
const int32_t EX_INVALID_BINARY_MODEL = 5;
const int32_t EX_SERIAL_VERSION_UID_NOT_FOUND = 6;
const int32_t EX_MESSAGE_TOO_LONG = 7;
const int32_t EX_CORRUPT = 8;
const int32_t EX_EXECUTION = 9;
const int32_t EX_REMOTE = 10;
const int32_t EX_SERVICE_NOT_IMPLEMENTED = 11; // Server bietet diesen Service (Remote) nicht an.
const int32_t EX_GENERATOR_EXCEPTION = 1000;
const int32_t EX_CANCELLED = 100;
const int32_t EX_TIMEOUT = 13;
const int32_t EX_IOERROR = 14;
const int32_t EX_TOO_MANY_REQUESTS = 15;
const int32_t EX_NO_REVERSE_CONNECTIONS = 16;
const int32_t EX_UNSUPPORTED_METHOD = 17;
const int32_t EX_AUTHENTICATION_REQUIRED = 18;
const int32_t EX_CLIENT_DIED = 12;

class BException : public exception {
public:
    BException(int32_t code, const wstring& msg) throw() : code(code), msg(msg) {
	}

    BException(int32_t code, const wstring& msg, const wstring& details) throw() : code(code), msg(msg), details(details) {
	}

    BException(int32_t code) throw() : code(code) {
	}

    BException(const BException& rhs) throw() : code(rhs.code), msg(rhs.msg), details(rhs.details) {
	}

	BException(const exception& ex) throw() : code(EX_INTERNAL), swhat(ex.what()) {
		const BException* bex = dynamic_cast<const BException*>(&ex);
		if (bex) {
			code = bex->code;
			msg = bex->msg;
			details = bex->details;
		}
	}

    BException() : code(0) {
    }

	virtual ~BException() throw() {}

    operator bool() const {
		return code != 0;
	}

    bool operator !() const {
        return code == 0;
    }

    int32_t getCode() const {
        return code;
	}

    const wstring& getMsg() const {
        return msg;
	}

    const wstring& getDetails() const {
        return details;
    }

	const wstring toString() const {
		wstringstream ss;
		ss << L"[BYPS:" << code << L"][" << msg << L"][" << details << L"]";
		return ss.str();
	}

	virtual const char* what() const throw() {
		if (swhat.size() == 0) {
			wstring str = toString();
			stringstream ss;
			for (unsigned i = 0; i < str.size(); i++) {
				ss << (char)(str[i]);
			}
			const_cast<BException*>(this)->swhat = ss.str();
		}
		return swhat.c_str();
	}

	void serialize(BIO& bio, const BVERSION version);

protected:
    int32_t code;
    wstring msg;
    wstring details;
	string swhat;

    

};

} /* namespace byps */
#endif /* BEXCEPTION_H_ */
