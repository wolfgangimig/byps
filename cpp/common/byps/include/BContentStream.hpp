/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_HPP_
#define BCONTENTSTREAM_HPP_

#include "BContentStream.h"

namespace byps {

using namespace ::std;

BINLINE BContentStreamImpl::BContentStreamImpl(const wstring& contentType, int64_t contentLength, PStream stream) 
	: contentType(contentType), contentLength(contentLength), stream(stream) {
}

BINLINE BContentStreamImpl::BContentStreamImpl(PStream stream) 
	: contentLength(-1), stream(stream) {
}

BINLINE BContentStreamImpl::BContentStreamImpl() 
	: contentLength(-1) {
}

BINLINE const wstring& BContentStreamImpl::getContentType() const {
	return contentType;
}

BINLINE int64_t BContentStreamImpl::getContentLength() const {
	return contentLength;
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
	this->contentType = BToStdWString(contentType);
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

}

#endif
