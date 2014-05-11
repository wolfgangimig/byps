/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BFILE_HPP_
#define BFILE_HPP_

#include "BFile.h"

namespace byps {

  BINLINE BFile::BFile(const BFile& file) : fname(file.fname), fnameUtf8(file.fnameUtf8) {
  }

  BINLINE BFile::BFile(const wstring& fname) : fname(fname) {
  }

  BINLINE BFile::BFile(const string& fnameUtf8) : fnameUtf8(fnameUtf8) {
  }

  BINLINE wstring BFile::getName() const {
    wstring dir, name;
    splitpath(getFullName(), dir, name);
    return name;
  }

  BINLINE string BFile::getNameUtf8() const {
    string dir, name;
    splitpath(getFullNameUtf8(), dir, name);
    return name;
  }

  BINLINE wstring BFile::getDirectory() const {
    wstring dir, name;
    splitpath(getFullName(), dir, name);
    return dir;
  }

  BINLINE string BFile::getDirectoryUtf8() const {
    string dir, name;
    splitpath(getFullNameUtf8(), dir, name);
    return dir;
  }

  BINLINE const string& BFile::getFullNameUtf8() const {
    if (fnameUtf8.size() == 0) {
      BFile* pthis = const_cast<BFile*>(this);
      pthis->fnameUtf8 = toUtf8(fname);
    }
    return fnameUtf8;
  }

  BINLINE const wstring& BFile::getFullName() const {
    if (fname.size() == 0) {
      BFile* pthis = const_cast<BFile*>(this);
      pthis->fname = fromUtf8(fnameUtf8);
    }
    return fname;
  }

  BINLINE int64_t BFile::size() const {
    string n = getFullNameUtf8();
    struct stat stat_buf;
    int rc = stat(n.c_str(), &stat_buf);
    return rc == 0 ? stat_buf.st_size : -1;
  }

#ifdef _MSC_VER
#pragma warning( disable : 4996 ) 
#endif

  BINLINE BFile BFile::createTempFile(const wstring& suffix, const wstring& postfix) {
    char fnameBuf[L_tmpnam] = {0};
    tmpnam(fnameBuf);
    wstring path = fromUtf8(fnameBuf);
    wstring dir, name;
    splitpath(path, dir, name);
    wstringstream wss;
    bool nameEndsWithDot = name.size() != 0 && name.find_last_of(L'.') == name.size()-1;
    bool postfixStartsWithDot = postfix.find(L'.') == 0;
    wss << dir << suffix << name;
    if (nameEndsWithDot && postfixStartsWithDot) {
      wss << postfix.substr(1);
    }
    else {
      wss << postfix;
    }

    return BFile(wss.str());
  }

  byps_ptr<ifstream> BFile::open(ios_base::openmode mode) const {
     ifstream* fstrm = new ifstream(getFullNameUtf8().c_str(), mode);
     return byps_ptr<ifstream>(fstrm);
  }

  byps_ptr<ofstream> BFile::openWrite(ios_base::openmode mode) const {
     ofstream* fstrm = new ofstream(getFullNameUtf8().c_str(), mode);
     return byps_ptr<ofstream>(fstrm);
  }

  bool BFile::delet() const {
    bool ret = remove(getFullNameUtf8().c_str()) == 0;
    return ret;
  }
}

#endif