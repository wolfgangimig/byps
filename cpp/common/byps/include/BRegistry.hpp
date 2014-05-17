/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
 * BRegistry.h
 *
 *  Created on: 29.07.2012
 *      Author: Wolfgang
 */

#ifndef BREGISTRY_HPP_
#define BREGISTRY_HPP_

#include "BRegistry.h"

namespace byps {


BINLINE void BSerializer_12(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		vector< PSerializable >& r = * reinterpret_cast<vector< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new vector< PSerializable >());
	}
}

BINLINE void BSerializer_14(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		set< PSerializable >& r = * reinterpret_cast<set< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new set< PSerializable >());
	}
}

BINLINE void BSerializer_15(BIO& bio, POBJECT& , PSerializable& pObjS, void* ) {
  
  if (bio.is_loading && pObjS) return;

  int64_t streamId = 0;
  BTargetId targetId;
  bool withProps = bio.header.bversion >= BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION;
  int64_t contentLength = -1;
  wstring contentType = BYPS_DEFAULT_CONTENT_TYPE;
  int32_t attachmentCode = 0;
  wstring fileName;

  if (!bio.is_loading) {
    PContentStream strm = byps_ptr_cast<BContentStream>(pObjS);
    bio.createStreamRequest(strm);

    targetId = strm->getTargetId();
    streamId = targetId.getStreamId();

    if (bio.header.bversion >= BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION) {
      contentLength = strm->getContentLength();
      contentType = strm->getContentType();
      attachmentCode = strm->getAttachmentCode();
      fileName = strm->getFileName();
    }
  }

  if (withProps) {
    bio & targetId;
    bio & contentLength;
    bio & contentType;
    bio & attachmentCode;
    bio & fileName;
  }
  else {
    int32_t serverId = bio.transport->getTargetId().getServerId();
    int64_t messageId = bio.header.messageId;
    int64_t streamId = 0;
    bio & streamId;
    targetId = BTargetId(serverId, messageId, streamId);
  }

  if (bio.is_loading) {
    PContentStream stream;
    pObjS = stream = bio.transport->getWire()->getStream(targetId);

    if (!stream) throw BException(BExceptionC::INTERNAL, L"Serialized stream object must not be NULL");

    stream->setContentLength(contentLength);
    stream->setContentType(contentType);
    stream->setAttachmentCode(attachmentCode);
    stream->setFileName(fileName);
  }

}

void BSerializer_16(BIO& bio, POBJECT& , PSerializable& pObjS, void*, NewStubFunction newstub, int32_t remoteId ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(newstub(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
    BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}

BINLINE BRegistry::BRegistry() {
	registerClass(typeid(BContentStream), BSerializer_15, BTYPEID_STREAM);
	registerClass(typeid(vector<PSerializable>), BSerializer_12, BTYPEID_LIST);
	registerClass(typeid(set<PSerializable>), BSerializer_14, BTYPEID_SET);
}

BINLINE BRegistry::~BRegistry() {
}

BINLINE void BRegistry::registerClass(const type_info& tinfo, BSERIALIZER ser, BTYPEID typeId) {
    mapSerializer[typeId] = ser;
    size_t hc = tinfo.hash_code();
    mapTypeIds[hc] = typeId;
}


BINLINE BSERIALIZER BRegistry::getSerializer(const type_info& tinfo, BTYPEID &typeId) {
    BSERIALIZER ser = NULL;
    size_t hc = tinfo.hash_code();
    typeId = mapTypeIds[hc];
    if (typeId != 0) {
        ser = mapSerializer[typeId];
    }
    if (!ser) {
        wstringstream ss; ss << L"Missing serializer for " << fromUtf8(tinfo.name());
        throw BException(BExceptionC::CORRUPT, ss.str());
    }
    return ser;
}

BINLINE BSERIALIZER BRegistry::getSerializer(BTYPEID typeId) {
    BSERIALIZER ser = mapSerializer[typeId];
    if (!ser) {
        wstringstream ss; ss << L"Missing serializer for typeId=" << typeId;
        throw BException(BExceptionC::CORRUPT, ss.str());
    }
    return ser;
}

}

#endif /* BREGISTRY_H_ */
