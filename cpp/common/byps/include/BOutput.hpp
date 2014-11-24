/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BOUTPUT_HPP
#define BOUTPUT_HPP

#include "Byps.h"

namespace byps {

  BINLINE BOutput::BOutput(PTransport transport, int32_t bversion, BVERSION negotiatedVersion, BByteOrder negotiatedByteOrder)
    : BIO(transport, BBinaryModel::MEDIUM(), bversion, negotiatedVersion, negotiatedByteOrder)
    , nextPointer(0)
  {
    header.targetId = transport->getTargetId();
    header.sessionId = transport->getSessionId();
  }

  BINLINE BOutput::BOutput(PTransport transport, const BMessageHeader &responseHeader)
    : BIO(transport, BBinaryModel::MEDIUM(), responseHeader.bversion, responseHeader.version, responseHeader.byteOrder)
    , nextPointer(0)
  {
    header = responseHeader;
    header.targetId = transport->getTargetId();
    header.sessionId = transport->getSessionId();
  }


  BINLINE BOutput::~BOutput() {
  }

  BINLINE void BOutput::store(PSerializable ptr) {
    header.write(bbuf);
    (*this) & ptr;
  }

  BINLINE void BOutput::internalStoreObj(POBJECT pObj, bool, BSERIALIZER ser, BTYPEID typeId) {

    if (pObj != NULL) {

      OBJMAP::iterator it = objMap.find(pObj.get());
      if (it != objMap.end()) {
        BPOINTER id = - (*it).second;
        bbuf.serializePointer(id);
      }
      else {
        BPOINTER id = ++nextPointer;

        objMap.insert( OBJMAP::value_type(pObj.get(), id));

        bbuf.serializePointer(id);

        bbuf.serializeTypeId(typeId);

        PSerializable NULLS;
        ser(*this, pObj, NULLS, NULL);
      }

    }
    else {
      // NULL-Reference
      BPOINTER id = 0;
      bbuf.serializePointer(id);
    }
  }

  BINLINE void BOutput::internalStoreObjS(PSerializable pObjS, bool, BSERIALIZER ser, BTYPEID typeId) {

    if (pObjS != NULL) {

      OBJMAP::iterator it = objMap.find(pObjS.get());
      if (it != objMap.end()) {
        BPOINTER id = - (*it).second;
        bbuf.serializePointer(id);
      }
      else {
        BPOINTER id = ++nextPointer;

        objMap.insert( OBJMAP::value_type(pObjS.get(), id));

        bbuf.serializePointer(id);

        bbuf.serializeTypeId(typeId);

        POBJECT NULLO;
        ser(*this, NULLO, pObjS, NULL);
      }

    }
    else {
      // NULL-Reference
      BPOINTER id = 0;
      bbuf.serializePointer(id);
    }
  }

  BINLINE PContentStream BOutput::createStreamRequest(PContentStream stream) {
    if (stream->getTargetId().isZero()) {
      BTargetId targetId(transport->getConnectedServerId(),
        header.messageId, 
        transport->getWire()->makeMessageId());
      stream->setTargetId(targetId);

      streams.push_back(stream);
    }

    return stream;
  }

  BINLINE PMessage BOutput::toMessage() {
    PMessage msg(new BMessage(header, bbuf.getBytes(), streams));
    return msg;
  }


  BINLINE void BOutput::setException(const BException& bex) {

    bbuf.clear();

    header.error = bex.getCode();
    header.write(bbuf);

    BTYPEID typeId = BTYPEID_EXCEPTION;
    BPOINTER id = ++nextPointer;
    bbuf.serializePointer(id);
    bbuf.serializeTypeId(typeId);

    BException& ex2 = const_cast<BException&>(bex);
    *this & ex2;
  }

}

#endif // BOUTPUT_HPP
