#ifndef BMESSAGE_H
#define BMESSAGE_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

class BMessage {
public:
    BMessageHeader header;
    PBytes buf;
    std::vector<PStreamRequest> streams;

    BMessage(const BMessageHeader& header, PBytes buf, const std::vector<PStreamRequest>& streams);

    bool isEmpty() const;
};


}}}

#endif // BMESSAGE_H
