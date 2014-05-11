/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_HPP_
#define BCONTENTSTREAM_HPP_

#include "BContentStream.h"
#include <sys/stat.h>

namespace byps {

  using namespace ::std;

 
  BINLINE BContentStream::BContentStream() 
    : contentType(BYPS_DEFAULT_CONTENT_TYPE), contentLength(-1), attachment(false), propertiesValid(false) {
  }

  BINLINE BContentStream::BContentStream(const wstring& contentType, int64_t contentLength) 
    : contentType(contentType), contentLength(contentLength), attachment(false), propertiesValid(false) {
  }

  BINLINE const wstring& BContentStream::getContentType() const {
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

  BINLINE const wstring& BContentStream::getFileName() const {
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

  BINLINE bool BContentStream::isAttachment() const {
    return attachment;
  }

  BINLINE void BContentStream::setAttachment(bool b) {
    attachment = b;
  }

  BINLINE void BContentStream::copyProperties(const PContentStream& rhs) {
    if (hasValidProperties()) return;
    if (!rhs || !rhs->hasValidProperties()) return;
    contentType = rhs->getContentType();
    contentLength = rhs->getContentLength();
    fileName = rhs->getFileName();
    attachment = rhs->isAttachment();
    targetId = rhs->getTargetId();
    propertiesValid = true;
  }


  BINLINE bool BContentStream::hasValidProperties() {
    return propertiesValid;
  }

  BINLINE void BContentStream::setPropertiesValid(bool b) {
    propertiesValid = b;
  }

  BINLINE int32_t BContentStreamWrapper::read(char* buf, int32_t offs, int32_t len) {
    if (len < 0) return -1;
    if (innerStream->eof()) return -1;
    innerStream->read(buf + offs, (size_t)len);
    return (int32_t)innerStream->gcount();
  }

 BINLINE BContentStreamWrapper::BContentStreamWrapper(PStream stream, const wstring& contentType, int64_t contentLength) 
    : BContentStream(contentType, contentLength), innerStream(stream) {
  }

  BINLINE BContentStreamWrapper::BContentStreamWrapper(PStream stream) 
    : BContentStream(BYPS_DEFAULT_CONTENT_TYPE, -1), innerStream(stream) {
  }

  BINLINE BContentStreamWrapper::BContentStreamWrapper(const BFile& file) {
    init(file, wstring());
  }
  BINLINE BContentStreamWrapper::BContentStreamWrapper(const BFile& file, const wstring& contentType) {
    init(file, contentType);
  }

  BINLINE void BContentStreamWrapper::init(const BFile& file, const wstring& contentType) {
    this->contentLength = file.size();
    wstring cs = contentType;
    if (cs.size() == 0) {
      cs = getFileContentType(file.getName());
      if (cs.size() == 0) cs = BYPS_DEFAULT_CONTENT_TYPE;
    }
    this->contentType = contentType;
    this->fileName = file.getName();
    innerStream = file.open();
  }

  BINLINE BContentStreamWrapper::~BContentStreamWrapper() {
    PStream s = innerStream;
    ifstream* fstrm = static_cast<ifstream*>(s.get());
    if (fstrm) {
      fstrm->close();
    }
  }

  BINLINE PStream BContentStreamWrapper::getStdStream() {
    return innerStream;
  }


}

#endif
