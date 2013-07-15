#ifndef BNEGOTIATE_H_
#define BNEGOTIATE_H_

#include "Byps.h"


namespace com { namespace wilutions { namespace byps {

#define NEGOTIATE_MAGIC_DOUBLE_QUOTES "[\"N\""

#define NEGOTIATE_BINARY_STREAM 'S'



// Maximum size of negotiate message
const size_t NEGOTIATE_MAX_SIZE = 50;

class BNegotiate;
typedef byps_ptr<BNegotiate> PNegotiate;

class BNegotiate {
public:
    std::string protocols;
    int32_t version;
    BByteOrder byteOrder;
    BTargetId targetId;

	BNegotiate();
    void write(const PBytes& bytes);
    void read(const PBytes& bytes);
    static bool isNegotiateMessage(PBytes bytes);
};

}}}

#endif
