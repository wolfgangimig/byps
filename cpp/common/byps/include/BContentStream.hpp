/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_HPP_
#define BCONTENTSTREAM_HPP_

#include "BContentStream.h"

namespace byps {

  using namespace ::std;

  BINLINE BContentStreamImpl::BContentStreamImpl(const wstring& contentType, int64_t contentLength, PStream stream) 
    : contentType(contentType), contentLength(contentLength), stream(stream), attachment(false) {
  }

  BINLINE BContentStreamImpl::BContentStreamImpl(PStream stream) 
    : contentType(BYPS_DEFAULT_CONTENT_TYPE), contentLength(-1), stream(stream), attachment(false) {
  }

  BINLINE BContentStreamImpl::BContentStreamImpl() 
    : contentType(BYPS_DEFAULT_CONTENT_TYPE), contentLength(-1), attachment(false) {
  }

  BINLINE const wstring& BContentStreamImpl::getContentType() const {
    return contentType;
  }

  BINLINE void BContentStreamImpl::setContentType(const wstring& v) {
    contentType = v;
  }

  BINLINE int64_t BContentStreamImpl::getContentLength() const {
    return contentLength;
  }

  BINLINE void BContentStreamImpl::setContentLength(int64_t v) {
    contentLength = v;
  }

  BINLINE const wstring& BContentStreamImpl::getFileName() const {
    return fileName;
  }

  BINLINE void BContentStreamImpl::setFileName(const wstring& v) {
    fileName = v;
  }

  BINLINE const BTargetId& BContentStreamImpl::getTargetId() const {
    return targetId;
  }

  BINLINE void BContentStreamImpl::setTargetId(const BTargetId& v) {
    targetId = v;
  }

  BINLINE bool BContentStreamImpl::isAttachment() const {
    return attachment;
  }

  BINLINE void BContentStreamImpl::setAttachment(bool b) {
    attachment = b;
  }

  BINLINE void BContentStreamImpl::copyProperties(const PContentStream& rhs) {
    if (!rhs) return;
    contentType = rhs->getContentType();
    contentLength = rhs->getContentLength();
    fileName = rhs->getFileName();
    attachment = rhs->isAttachment();
    targetId = rhs->getTargetId();
  }

  BINLINE int32_t BContentStreamImpl::read(char* buf, int32_t offs, int32_t len) {
    if (len < 0) return -1;
    if (stream->eof()) return -1;
    stream->read(buf + offs, (size_t)len);
    return (int32_t)stream->gcount();
  }

#ifdef BFSTREAM_WCHAR
  BINLINE BContentStreamFile::BContentStreamFile(const wstring& fname) {
    ifstream* fstrm = new ifstream(fname.c_str(), ios_base::binary|ios_base::in);
    init(fstrm);
  }
  BINLINE BContentStreamFile::BContentStreamFile(const wstring& fname, const wstring& contentType, int64_t contentLength) {
    ifstream* fstrm = new ifstream(fname.c_str(), ios_base::binary|ios_base::in);
    this->stream = PStream(fstrm);
    this->contentType = contentType;
    this->contentLength = contentLength;
  }
#endif

  BINLINE BContentStreamFile::BContentStreamFile(const string& fname) {
    ifstream* fstrm = new ifstream(fname.c_str(), ios_base::binary|ios_base::in);
    init(fstrm);
  }
  BINLINE BContentStreamFile::BContentStreamFile(const string& fname, const string& contentType, int64_t contentLength) {
    ifstream* fstrm = new ifstream(fname.c_str(), ios_base::binary|ios_base::in);
    this->stream = PStream(fstrm);
    this->contentType = fromUtf8(contentType);
    this->contentLength = contentLength;
  }

  BINLINE void BContentStreamFile::init(ifstream* fstrm) {
    fstrm->seekg(0, ios_base::end);
    streampos flen = fstrm->tellg();
    fstrm->seekg(0, ios_base::beg);
    contentLength = (int64_t)flen;
    contentType = L"application/octet-stream";
    stream = PStream(fstrm);
  }

  BINLINE BContentStreamFile::~BContentStreamFile() {
    ifstream* fstrm = static_cast<ifstream*>(stream.get());
    fstrm->close();
  }


  BINLINE void BContentStream::serialize(BIO& bio, POBJECT& , PSerializable& pObjS, void* ) {

    if (bio.is_loading) {
      if (!pObjS) {
        BTargetId targetId;
        int64_t contentLength = 0;
        wstring contentType = BYPS_DEFAULT_CONTENT_TYPE;
        bool attachment = false;
        wstring fileName;

        if (bio.header.bversion >= BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION) {
          bio & targetId;
          bio & contentLength;
          bio & contentType;
          bio & attachment;
          bio & fileName;
        }
        else {
          int32_t serverId = bio.transport->getTargetId().getServerId();
          int64_t messageId = bio.header.messageId;
          int64_t streamId = 0;
          bio & streamId;
          targetId = BTargetId(serverId, messageId, streamId);
        }

        PContentStream stream = bio.transport->getWire()->getStream(targetId);
        stream->setContentType(contentType);
        stream->setContentLength(contentLength);
        stream->setAttachment(attachment);
        stream->setFileName(fileName);
        pObjS = stream;
      }
    }
    else {
      PContentStream strm = byps_ptr_cast<BContentStream>(pObjS);
      bio.createStreamRequest(strm);

      BTargetId targetId = strm->getTargetId();

      if (bio.header.bversion >= BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION) {
        int64_t contentLength = strm->getContentLength();
        wstring contentType = strm->getContentType();
        bool attachment = strm->isAttachment();
        wstring fileName = strm->getFileName();
        bio & targetId;
        bio & contentLength;
        bio & contentType;
        bio & attachment;
        bio & fileName;
      }
      else {
        int64_t streamId = targetId.getStreamId();
        bio & streamId;
      }

    }

  }

}

#endif
