#ifndef BOUTPUT_HPP
#define BOUTPUT_HPP

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BOutput::BOutput(PTransport transport, int32_t negotiatedVersion, BByteOrder negotiatedByteOrder)
    : BIO(transport, BBinaryModel::MEDIUM(), negotiatedVersion, negotiatedByteOrder)
    , nextPointer(0)
{
    header.targetId = transport->targetId;
}

BINLINE BOutput::BOutput(PTransport transport, const BMessageHeader &responseHeader)
    : BIO(transport, BBinaryModel::MEDIUM(), responseHeader.version, responseHeader.byteOrder)
    , nextPointer(0)
{
	header = responseHeader;
    header.targetId = transport->targetId;
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

BINLINE PStreamRequest BOutput::createStreamRequest(PContentStream inputStream) {
    PStreamRequest stream(new BStreamRequest());
    stream->messageId = header.messageId;
    stream->streamId = transport->wire->makeMessageId();
    stream->strm = inputStream;
    streams.push_back(stream);
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

}}}

#endif // BOUTPUT_HPP
