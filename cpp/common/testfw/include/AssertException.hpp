#ifndef ASSERTEXCEPTION_HPP_
#define ASSERTEXCEPTION_HPP_

#include <string>
#include "AssertException.h"

namespace com { namespace wilutions { namespace test {

TINLINE AssertException::AssertException(const char* file, int line, const std::wstring& msg)
	: file(file), line(line), msg(msg) {
}

TINLINE AssertException::AssertException()
	: line(0) {
}

TINLINE AssertException::AssertException(const AssertException& ex)
	: file(ex.file), line(ex.line), msg(ex.msg) {
}

TINLINE AssertException::operator bool() {
	return line != 0;
}

TINLINE std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& strm, const AssertException& ex) {
	strm << L"  ";
	for (unsigned i = 0; i < ex.file.size(); i++) {
		strm << ((wchar_t)ex.file[i]);
	}
	strm << ":" << ex.line << L" " << std::endl << L"    " << ex.msg << std::endl;
	return strm;
}

}}}

#endif