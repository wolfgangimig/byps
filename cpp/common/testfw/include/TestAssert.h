#ifndef TESTASSERT_H_
#define TESTASSERT_H_

#include "AssertException.h"
#include <sstream>
#include <memory>

#define TASSERT(msg, expectedValue, readValue) com::wilutions::test::tassert(__FILE__, __LINE__, msg, (expectedValue), (readValue))
#define TFAIL(msg) throw AssertException(__FILE__, __LINE__, msg)

namespace com { namespace wilutions { namespace test {

void tassert(const char* file, int line, const std::wstring& msg, 
									  std::string expectedValue, 
									  std::string readValue);

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   _Type expectedValue, 
									   _Type readValue);

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   std::shared_ptr<_Type> expectedValue, 
									   std::shared_ptr<_Type> readValue);

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   const std::vector<std::shared_ptr<_Type> >& expectedValue, 
									   const std::vector<std::shared_ptr<_Type> >& readValue);

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   const std::vector<_Type>& expectedValue, 
									   const std::vector<_Type>& readValue);

template <typename _Type> void tassert_cmp(const char* file, int line, const std::wstring& msg, _Type expectedValue, _Type readValue) {
	if (!(expectedValue == readValue)) {
		std::wstringstream ss;
		ss << msg;
		ss << L" expected: " << expectedValue;
		ss << L" read: " << readValue;
		throw AssertException(file, line, ss.str());
	}
}

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, _Type expectedValue, _Type readValue) {
	tassert_cmp(file, line, msg, expectedValue, readValue);
}

inline void tassert(const char* file, int line, const std::wstring& msg, 
									  std::string expectedValue, 
									  std::string readValue) {
	if (!(expectedValue == readValue)) {
		std::wstringstream ss;
		ss << msg;
		ss << L" expected: ";
		for (unsigned i = 0; i < expectedValue.size(); i++) {
			ss << (wchar_t)expectedValue[i];
		}
		ss << L" read: ";
		for (unsigned i = 0; i < readValue.size(); i++) {
			ss << (wchar_t)readValue[i];
		}

		throw AssertException(file, line, ss.str());
	}
}

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   const std::vector<std::shared_ptr<_Type> >& expectedValue, 
									   const std::vector<std::shared_ptr<_Type> >& readValue) {
	tassert_cmp(file, line, msg + L".size()", expectedValue.size(), readValue.size());
	for (unsigned i = 0; i < expectedValue.size(); i++) {
		std::shared_ptr<_Type> e = expectedValue[i];
		std::shared_ptr<_Type> r = readValue[i];
		tassert(file, line, msg, *e, *r);
	}
}

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   const std::vector<_Type>& expectedValue, 
									   const std::vector<_Type>& readValue) {
	tassert_cmp(file, line, msg + L".size()", expectedValue.size(), readValue.size());
	for (unsigned i = 0; i < expectedValue.size(); i++) {
		_Type e = expectedValue[i];
		_Type r = readValue[i];
		tassert(file, line, msg, e, r);
	}
}

template <typename _Type> void tassert(const char* file, int line, const std::wstring& msg, 
									   std::shared_ptr<_Type> expectedValue, 
									   std::shared_ptr<_Type> readValue) {
	tassert_cmp(file, line, msg + L" != NULL", !!expectedValue, !!readValue);
	if (!expectedValue || !readValue) return;
	tassert(file, line, msg, *expectedValue, *readValue);
}

}}}

#endif