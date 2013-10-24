#ifndef ASSERTEXCEPTION_H_
#define ASSERTEXCEPTION_H_

#include <string>
#include <iostream>
#include <exception>

namespace com { namespace wilutions { namespace test {

#define ThrowAssertException(msg) \
	throw AssertException(__FILE__, __LINE__, msg)

class AssertException : public std::exception {
public:
	AssertException(const char* file, int line, const std::wstring& msg);
	AssertException();
	AssertException(const AssertException& rhs);

	operator bool();
	
private:
	std::string file;
	int line;
	std::wstring msg;

	friend std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& strm, const AssertException& ex);
};

std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& strm, const AssertException& ex);

}}}

#endif