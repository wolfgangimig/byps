#ifndef BCONTENTSTREAM_HPP_
#define BCONTENTSTREAM_HPP_

#include "BContentStream.h"
#include <fstream>

namespace com { namespace wilutions { namespace byps {

BINLINE BContentStreamImpl::BContentStreamImpl(const std::wstring& contentType, int64_t contentLength, PStream stream) 
	: contentType(contentType), contentLength(contentLength), stream(stream) {
}

BINLINE BContentStreamImpl::BContentStreamImpl(PStream stream) 
	: contentLength(-1), stream(stream) {
}

BINLINE BContentStreamImpl::BContentStreamImpl() 
	: contentLength(-1) {
}

BINLINE const std::wstring& BContentStreamImpl::getContentType() const {
	return contentType;
}

BINLINE int64_t BContentStreamImpl::getContentLength() const {
	return contentLength;
}

BINLINE int32_t BContentStreamImpl::read(char* buf, int32_t offs, int32_t len) {
	if (len < 0) return -1;
	if (stream->eof()) return -1;
	stream->read(buf, (size_t)len);
	return (int32_t)stream->gcount();
}

#ifdef BFSTREAM_WCHAR
BINLINE BContentStreamFile::BContentStreamFile(const std::wstring& fname) {
    std::ifstream* fstrm = new std::ifstream(fname.c_str(), std::ios_base::binary|std::ios_base::in);
    init(fstrm);
}
#endif

BINLINE BContentStreamFile::BContentStreamFile(const std::string& fname) {
    std::ifstream* fstrm = new std::ifstream(fname.c_str(), std::ios_base::binary|std::ios_base::in);
    init(fstrm);
}

BINLINE void BContentStreamFile::init(std::ifstream* fstrm) {
    fstrm->seekg(0, std::ios_base::end);
    std::streampos flen = fstrm->tellg();
    fstrm->seekg(0, std::ios_base::beg);
    contentLength = (int64_t)flen;
    contentType = L"application/octet-stream";
    stream = PStream(fstrm);
}

BINLINE BContentStreamFile::~BContentStreamFile() {
	std::ifstream* fstrm = static_cast<std::ifstream*>(stream.get());
	fstrm->close();
}

BINLINE void BContentStream::serialize(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {

	if (bio.is_loading) {
		if (!pObjS) {
			int64_t streamId = 0;
			bio & streamId;
			pObjS = bio.transport->wire->getStream(bio.header.messageId, streamId);
		}
	}
	else {
		PContentStream strm = byps_ptr_cast<BContentStream>(pObjS);
		PStreamRequest streamRequest = bio.createStreamRequest(strm);
		int64_t streamId = streamRequest->streamId;
		bio & streamId;
	}

}

}}}

#endif
