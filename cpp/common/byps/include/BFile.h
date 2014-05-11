/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BFILE_H_
#define BFILE_H_

#include "Byps.h"
#include <ostream>

namespace byps {

  using namespace ::std;

  class BFile {
    wstring fname;
    string fnameUtf8;
  public: 
    BFile(const BFile& rhs);
    BFile(const wstring& fname);
    BFile(const string& fnameUtf8);
    wstring getName() const ;
    string getNameUtf8() const;
    const wstring& getFullName() const;
    const string& getFullNameUtf8() const;
    wstring getDirectory() const ;
    string getDirectoryUtf8() const;
    
    int64_t size() const;
    byps_ptr<ifstream> open(ios_base::openmode _Mode = ios_base::in|ios_base::binary) const;
    byps_ptr<ofstream> openWrite(ios_base::openmode _Mode = ios_base::out|ios_base::binary) const;

    bool delet() const ;

    static BFile createTempFile(const wstring& suffix, const wstring& postfix);
  };

}

#endif