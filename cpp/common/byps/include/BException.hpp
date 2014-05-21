/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BEXCEPTION_HPP_
#define BEXCEPTION_HPP_

#include "BException.h"

namespace byps {

  using namespace std;

  BINLINE BException::BException(int32_t code, const wstring& msg) throw() {
    init(code, msg, L"", "");
  }

  BINLINE BException::BException(int32_t code, const wstring& msg, const wstring& details) throw() {
    init(code, msg, details, "");
  }

  BINLINE BException::BException(int32_t code) throw() {
    init(code, L"", L"", "");
  }

  BINLINE BException::BException(const BException& rhs) throw() {
    this->data = rhs.data;
  }

  BINLINE BException::BException(const exception& ex) throw() {
    const BException* bex = dynamic_cast<const BException*>(&ex);
    if (bex) {
      data = bex->data;
    }
    else {
      init(BExceptionC::INTERNAL, L"", L"", ex.what());
    }
  }

  BINLINE BException::BException() {
  }

  BINLINE BException::~BException() throw() {
  }

  BINLINE BException::operator bool() const {
    return !!data;
  }

  BINLINE bool BException::operator !() const {
    return !data;
  }

  BINLINE int32_t BException::getCode() const {
    return data ? data->code : 0;
  }

  BINLINE wstring BException::getMsg() const {
    return data ? data->msg : L"";
  }

  BINLINE wstring BException::getDetails() const {
    return data ? data->details : L"";
  }

  BINLINE wstring BException::toString() const {
    return BExceptionO::formatMessage(getCode(), getMsg(), getDetails(), exception());
  }

  BINLINE const char* BException::what() const throw() {
    if (!data) return "";

    if (data->swhat.size() == 0) {
      wstring str = toString();
      stringstream ss;
      for (unsigned i = 0; i < str.size(); i++) {
        ss << (char)(str[i]);
      }
      const_cast<BException*>(this)->data->swhat = ss.str();
    }

    return data->swhat.c_str();
  }

  BINLINE void BException::init(int32_t code, const wstring& msg, const wstring& details, const string& swhat) {
    BExceptionData* p = new BExceptionData();
    p->code = code;
    p->msg = msg;
    p->details = details;
    p->swhat = swhat;
    data = byps_ptr<BExceptionData>(p);
  }

  BINLINE void BException::serialize(BIO& bio, const BVERSION ) {

    int32_t code = data ? data->code : 0;
    wstring msg = data ? data->msg : L"";
    wstring details = data ? data->details : L"";

    bio & code;
    bio & msg;
    bio & details;

    if (bio.is_loading) {
      init(code, msg, details, "");
    }
  }

  BExceptionO::FormatMessageFnct BExceptionO::formatMessage = [] (int32_t code, const wstring& msg, const wstring& details, const exception& ) -> wstring {
    std::wstringstream ss;
    ss << L"[BYPS:" << code << L"][" << msg << L"][" << details << L"]";
    return ss.str();
  };

}

#endif