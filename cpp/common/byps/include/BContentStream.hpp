/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_HPP_
#define BCONTENTSTREAM_HPP_

#include "BContentStream.h"
#include <sys/stat.h>

namespace byps {

  using namespace ::std;

 
  BINLINE BContentStream::BContentStream() 
    : contentType(BYPS_DEFAULT_CONTENT_TYPE), contentLength(-1), attachmentCode(0) {
  }

  BINLINE BContentStream::BContentStream(const wstring& contentType, int64_t contentLength) 
    : contentType(contentType), contentLength(contentLength), attachmentCode(0) {
  }

  BINLINE wstring BContentStream::getContentType() const {
    return contentType;
  }

  BINLINE void BContentStream::setContentType(const wstring& v) {
    contentType = v;
  }

  BINLINE int64_t BContentStream::getContentLength() const {
    return contentLength;
  }

  BINLINE void BContentStream::setContentLength(int64_t v) {
    contentLength = v;
  }

  BINLINE wstring BContentStream::getFileName() const {
    return fileName;
  }

  BINLINE void BContentStream::setFileName(const wstring& v) {
    fileName = v;
  }

  BINLINE const BTargetId& BContentStream::getTargetId() const {
    return targetId;
  }

  BINLINE void BContentStream::setTargetId(const BTargetId& v) {
    targetId = v;
  }

  BINLINE int32_t BContentStream::getAttachmentCode() const {
    return attachmentCode;
  }

  BINLINE void BContentStream::setAttachmentCode(int32_t b) {
    attachmentCode = b;
  }

  BINLINE void BContentStream::copyProperties(const PContentStream& rhs) {
    if (rhs) {
      contentType = rhs->getContentType();
      contentLength = rhs->getContentLength();
      fileName = rhs->getFileName();
      attachmentCode = rhs->getAttachmentCode();
      targetId = rhs->getTargetId();
    }
  }

  BINLINE void BContentStream::setContentDisposition(const wstring& value) {
    wstring fileName;
    bool att = false;
    if (value.size()) {
      att = value.find(L"attachment;") != wstring::npos;
      size_t p = value.find(L"filename=");
      if (p != wstring::npos) {
        fileName = value.substr(p + 9);
        if (fileName.find(L'\"') == 0) {
          fileName = fileName.substr(1);
          if (fileName.find(L'\"') == fileName.size()-1) {
            fileName = fileName.substr(0, fileName.size()-1);
          }
        }
      }
    }
    this->fileName = fileName;
    this->attachmentCode = att ? ATTACHMENT : INLINE;
  }

  BINLINE wstring BContentStream::getContentDisposition() const {
    wstringstream wss;
    wss << ((getAttachmentCode()==ATTACHMENT) ? L"attachment;" : L"inline;") ;
    wstring fileName = getFileName();
    if (fileName.size()) {
	  wss << L" filename=";
	  bool qu = fileName.find(' ') != wstring::npos;
	  if (qu) wss << L"\"";
	  wss << fileName;
	  if (qu) wss << L"\"";
    }
    return wss.str();
  }

  BINLINE int32_t BContentStreamWrapper::read(char* buf, int32_t offs, int32_t len) {
    int32_t ret = -1;
    if (len < 0) return -1;
    if (stdStream) {
      if (stdStream->eof()) return -1;
      stdStream->read(buf + offs, (size_t)len);
      ret = (int32_t)stdStream->gcount();
    }
    else {
      PContentStream strm = ensureStream();
      ret = strm->read(buf, offs, len);
    }
    return ret;
  }

 BINLINE BContentStreamWrapper::BContentStreamWrapper() {
 }

 BINLINE BContentStreamWrapper::BContentStreamWrapper(PStream stream, const wstring& contentType, int64_t contentLength) 
    : BContentStream(contentType, contentLength), stdStream(stream) {
  }

  BINLINE BContentStreamWrapper::BContentStreamWrapper(PStream stream) 
    : BContentStream(wstring(), -1), stdStream(stream) {
  }

  BINLINE BContentStreamWrapper::BContentStreamWrapper(const BFile& file) {
    init(file, wstring());
  }
  BINLINE BContentStreamWrapper::BContentStreamWrapper(const BFile& file, const wstring& contentType) {
    init(file, contentType);
  }

  BINLINE BContentStreamWrapper::BContentStreamWrapper(PContentStream innerStream, int64_t ) 
    : innerStream(innerStream) {
  }

  BINLINE PContentStream BContentStreamWrapper::openStream() {
    return innerStream;
  }

  BINLINE PContentStream BContentStreamWrapper::ensureStream() {
    if (innerStream) return innerStream;
    byps_unique_lock lock(mutex);
    if (!innerStream) {
      innerStream = openStream();
      copyProperties(innerStream);
    }
    return innerStream;
  }

  BINLINE void BContentStreamWrapper::init(const BFile& file, const wstring& contentType) {
    this->contentLength = file.size();
    wstring cs = contentType;
    if (cs.size() == 0) {
      cs = getFileContentType(file.getName());
      if (cs.size() == 0) cs = BYPS_DEFAULT_CONTENT_TYPE;
    }
    this->contentType = cs;
    
	// Ignore file name.
	// Could contain characters which cause an invalid Content-Disposition header.
	//this->fileName = file.getName();

    stdStream = file.open();
  }

  BINLINE BContentStreamWrapper::~BContentStreamWrapper() {
    PStream s = stdStream;
    ifstream* fstrm = static_cast<ifstream*>(s.get());
    if (fstrm) {
      fstrm->close();
    }
  }

  BINLINE PStream BContentStreamWrapper::getStdStream() {
    return stdStream;
  }

}

#endif
