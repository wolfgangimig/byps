/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMESSAGE_HPP
#define BMESSAGE_HPP

#include "BMessage.h"
#include "BBuffer.h"

namespace byps {

BINLINE BMessage::BMessage(const BMessageHeader& header, PBytes buf, const vector<PContentStream>& streams)
    : header(header), buf(buf), streams(streams) {
}

BINLINE bool BMessage::isEmpty() const {
  return (buf == NULL || buf->length == 0);
}

}

#endif // BMESSAGE_HPP
