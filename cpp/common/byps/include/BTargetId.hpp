/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTARGETID_HPP
#define BTARGETID_HPP

#include "BTargetId.h"
#include "BBuffer.h"

namespace byps {

  BINLINE BTargetId::BTargetId() : serverId(0), remoteId(0), v1(0), v2(0), signature(0) {
  }

  BINLINE BTargetId::BTargetId(int32_t serverId, int64_t v1, int64_t v2) 
    : serverId(serverId), remoteId(0), v1(v1), v2(v2), signature(0) {
  }

  BINLINE BTargetId::BTargetId(int32_t serverId, int32_t remoteId, int64_t v1, int64_t v2, int64_t signature) 
    : serverId(serverId), remoteId(remoteId), v1(v1), v2(v2), signature(signature) {
  }

  BINLINE bool BTargetId::isZero() const {
    return serverId == 0 && v1 == 0 && v2 == 0;
  }
  BINLINE int32_t BTargetId::getServerId() const {
    return serverId;
  }
  BINLINE int64_t BTargetId::getMessageId() const {
    return v1;
  }
  BINLINE int64_t BTargetId::getStreamId() const {
    return v2;
  }

  BINLINE bool BTargetId::operator==(const BTargetId& rhs) const {
    return serverId == rhs.serverId && v1 == rhs.v1 && v2 == rhs.v2;
  }
  
  int32_t BTargetId::getRemoteId() const {
    return remoteId;
  }

  int64_t BTargetId::getSignature() const {
    return signature;
  }

  std::wstring BTargetId::makeHeaderString() const {
    std::wstringstream ss;
    ss << serverId << L'.' << v1 << L'.' << v2 << L'.';
    if (remoteId) {
      ss << remoteId << L'.' << signature << L'.';
    }
    return ss.str();
  };
  
  std::wstring BTargetId::toString() const {
    std::wstringstream ss;
    ss << (*this);
    return ss.str();
  }
  //  return makeSerializeString(BHEADER_BYPS_VERSION_ENCRYPTED_TARGETID);
  //}

  //std::wstring BTargetId::makeHeaderString() const {
  //  return makeSerializeString(0);
  //}

  //BINLINE std::wstring BTargetId::makeSerializeString(int32_t bversion) const {
  //  std::wstringstream ss;
  //  ss << serverId << L'.' << v1 << L'.' << v2;
  //  if (bversion >= BHEADER_BYPS_VERSION_ENCRYPTED_TARGETID) {
  //    ss << L'.' << remoteId << L'.' << signature;
  //  }
  //  return ss.str();
  //}

  BINLINE BTargetId BTargetId::parseString(const string& s) {
    int32_t serverId = 0, remoteId = 0;
    int64_t v1 = 0, v2 = 0, signature = 0;

    stringstream ss;
    for (string::const_iterator it = s.begin(); it != s.end(); it++) {
      ss << ((*it == '.') ? ' ' : *it);
    }

    ss >> serverId >> v1 >> v2 >> remoteId >> signature;

    return BTargetId(serverId, remoteId, v1, v2, signature);
  }

  BINLINE void BTargetId::serialize(BBuffer& bbuf, int32_t bversion) {
    bool cpr = bbuf.setCompressInteger(false);
    bbuf.serialize(serverId);
    bbuf.serialize(v1);
    bbuf.serialize(v2);
    if (bversion >= BHEADER_BYPS_VERSION_ENCRYPTED_TARGETID) {
      bbuf.serialize(remoteId);
      bbuf.serialize(signature);
    }
    bbuf.setCompressInteger(cpr);
  }

  BINLINE string BTargetId::toSessionId() const {
    return toSessionId(v1, v2);
  }
  
  BINLINE string BTargetId::toSessionId(int64_t v1, int64_t v2) {
    stringstream ss;
    ss << std::hex << v1 << v2;
    return ss.str();
  }
  
  BINLINE void BTargetId::writeSessionId(BBuffer& buf, const string& sessionId) {
    int64_t v1 = 0, v2 = 0;
    if (sessionId.size()) {
      size_t endIdx = 0;
      v1 = (int64_t)std::stoull(sessionId.substr(0,16).c_str(), &endIdx, 16);
      endIdx = 0;
      v2 = (int64_t)std::stoull(sessionId.substr(16,16).c_str(), &endIdx, 16);
    }

    bool cpr = buf.isCompressInteger();
    buf.setCompressInteger(false);
    BByteOrder bo = buf.getByteOrder();
    buf.setByteOrder(BBIG_ENDIAN);
    buf.serialize(v1);
    buf.serialize(v2);
    buf.setCompressInteger(cpr);
    buf.setByteOrder(bo);
  }
  
  BINLINE string BTargetId::readSessionId(BBuffer& buf) {
    bool cpr = buf.isCompressInteger();
    buf.setCompressInteger(false);
    BByteOrder bo = buf.getByteOrder();
    buf.setByteOrder(BBIG_ENDIAN);
    int64_t v1 = 0;
    int64_t v2 = 0;
    buf.serialize(v1);
    buf.serialize(v2);
    buf.setCompressInteger(cpr);
    buf.setByteOrder(bo);

    string s = toSessionId(v1,v2);
    return s;
  }


}

#endif // BTARGETID_HPP
