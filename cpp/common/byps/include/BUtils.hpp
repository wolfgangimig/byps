/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BUTILS_HPP_
#define BUTILS_HPP_

#include "BUtils.h"

namespace byps {

  //BINLINE wstring BToStdWString(const string& str) {
  //	return BToStdWString(str.c_str(), str.length());
  //}
  //
  //BINLINE wstring BToStdWString(const char* str, size_t blen, bool isUtf8) {
  //	if (str == NULL || blen == 0) return wstring();
  //	if (blen == string::npos) blen = strlen(str);
  //	
  //  wstring wstr;
  //  wstr.reserve(blen);
  //
  //  if (isUtf8) {
  //    const int8_t* buf = (int8_t*)str;
  //    const int8_t* p = buf;
  //    const int8_t* pend = p + blen;
  //
  //    while (p < pend) {
  //        wchar_t c = (wchar_t)(*p);
  //        p++;
  //        int16_t u4bits = (c & 0xF0);
  //        if (u4bits == 0xC0) {
  //            c &= 0x1F;
  //            c <<= 6;
  //            c |= (wchar_t)((*p++ & 0x3F));
  //        }
  //        else if (u4bits == 0xE0) {
  //            c &= 0xF;
  //            c <<= 6;
  //            c |= (wchar_t)((*p++ & 0x3F));
  //            c <<= 6;
  //            c |= (wchar_t)((*p++ & 0x3F));
  //        }
  //
  //        wstr += c;
  //    }
  //
  //  }
  //  else {
  //    for (size_t i = 0; i < blen; i++) {
  //      wstr += (wchar_t)str[i];
  //    }
  //  }
  //
  //	return wstr;
  //}


  BINLINE string toUtf8(const wstring& str) {
    stringstream ss;
    for (wstring::const_iterator it = str.begin(); it != str.end(); it++) {

      wchar_t c = (*it);

      if (c <= 0x7F) {
        ss << (char)c;
      }
      else if (c >= 0x80 && c <= 0x07FF) {
        ss << (char)(((c >> 6) & 0x1F) | 0xC0);
        ss << (char)((c & 0x3F) | 0x80);
      }
      else { // if (c >= 0x800 && c <= 0xFFFF) {
        ss << (char)(((c >> 12) & 0xF) | 0xE0);
        ss << (char)(((c >> 6) & 0x3F) | 0x80);
        ss << (char)((c & 0x3F) | 0x80);
      }
    }
    return ss.str();
  }

  BINLINE wstring fromUtf8(const string& str) {
    wstringstream ss;

    const char* p = str.c_str();
    const char* pend = p + str.size();

    while (p < pend) {

      wchar_t c = (wchar_t)(*p);
      p++;
      int16_t u4bits = (c & 0xF0);
      if (u4bits == 0xC0) {
        c &= 0x1F;
        c <<= 6;
        c |= (wchar_t)((*p++ & 0x3F));
      }
      else if (u4bits == 0xE0) {
        c &= 0xF;
        c <<= 6;
        c |= (wchar_t)((*p++ & 0x3F));
        c <<= 6;
        c |= (wchar_t)((*p++ & 0x3F));
      }

      ss << c;
    }

    return ss.str();
  }

  BINLINE string toAscii(const wstring& w) {
    stringstream ss;
    for (auto it = w.begin(); it != w.end(); it++) {
      ss << (char)((*it) & 0xFF);
    }
    return ss.str();
  }

  BINLINE wstring fromAscii(const string& s) {
    wstringstream wss;
    for (auto it = s.begin(); it != s.end(); it++) {
      wss << (((wchar_t)(*it)) & 0xFF);
    }
    return wss.str();
  }

  BINLINE wstring encodeUrl(const wstring& w, const wstring& charset) {
    static const char lookup[] = "0123456789abcdef";
    string s = (charset == L"UTF-8" || charset == L"utf-8") ? toUtf8(w) : toAscii(w);
    wstringstream ascii;
    wstringstream e;
    for (size_t i = 0, ix = s.length(); i < ix; i++)
    {
      const char& c = s[i];
      if ((48 <= c && c <= 57) ||//0-9
        (65 <= c && c <= 90) ||//abc...xyz
        (97 <= c && c <= 122) || //ABC...XYZ
        (c == L'-' || c == L'_' || c == L'.' || c == L'~')
        )
      {
        e << c;
      }
      else {
        e << L'%';
        e << lookup[(c & 0xF0) >> 4];
        e << lookup[(c & 0x0F)];
      }
    }
    return e.str();
  }

  BINLINE wstring decodeUrl(const wstring& s, const wstring& charset) {
    stringstream ss;
    for (auto it = s.begin(); it != s.end(); it++) {
      char c = ((wchar_t)(*it)) & 0xFF;
      if (c == '%') {
        if (++it != s.end()) {
          char buf[3] = { 0 };
          buf[0] = (*it) & 0xFF;
          if (++it != s.end()) {
            buf[1] = (*it) & 0xFF;
            int n = (int)strtol(buf, nullptr, 16);
            ss << (char)(n & 0xFF);
          }
        }
      }
      else {
        ss << c;
      }
    }
    wstring w = (charset == L"UTF-8" || charset == L"utf-8") ? fromUtf8(ss.str()) : fromAscii(ss.str());
    return w;
  }

  BINLINE wstring trim(const wstring& s, function<bool (wchar_t)> test) {
    std::wstring::const_iterator it = s.begin();

    while (it != s.end() && test(*it))
      it++;

    std::wstring::const_reverse_iterator rit = s.rbegin();
    while (rit.base() != it && test(*rit))
      rit++;

    if (it == s.end() && rit == s.rbegin()) {
      return wstring();
    }
    if (it == s.begin() && rit == s.rbegin()) {
      return s;
    }
    
    return std::wstring(it, rit.base());
  }

  BINLINE wstring trim(const wstring& s, const wstring& charsToTrim) {
    wstring r;
    if (charsToTrim.empty()) {
      r = trim(s, [](wchar_t c) {return isspace(c) != 0; });
    }
    else {
      r = trim(s, [&](wchar_t c) {
        bool succ = charsToTrim.find(c) != wstring::npos;
        return succ; 
      });
    }
    return r;
  }

  BINLINE bool startsWith(const wstring& s, const wstring& f) {
    return s.find(f) == 0;
  }

  BINLINE bool endsWith(const wstring& s, const wstring& f) {
    return s.find(f) == s.length() - 1;
  }

}

#endif /* BUTILS_H_ */
