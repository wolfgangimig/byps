/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BNEGOTIATE_H_
#define BNEGOTIATE_H_

#include "Byps.h"


namespace byps {

using namespace ::std;

#define NEGOTIATE_MAGIC_DOUBLE_QUOTES "[\"N\""


// Maximum size of negotiate message
const size_t NEGOTIATE_MAX_SIZE = 50;

class BNegotiate;
typedef byps_ptr<BNegotiate> PNegotiate;

class BNegotiate {
public:
    string protocols;
    BVERSION version;
    BByteOrder byteOrder;
    BTargetId targetId;
    int32_t bversion;

	BNegotiate();
	BNegotiate(PApiDescriptor apiDesc);
    void write(const PBytes& bytes);
    void read(const PBytes& bytes);
    static bool isNegotiateMessage(PBytes bytes);
};

}

#endif
