#ifndef BMESSAGE_H
#define BMESSAGE_H

#include "Byps.h"

namespace byps {

using namespace ::std;

class BMessage {
public:
    BMessageHeader header;
    PBytes buf;
    vector<PStreamRequest> streams;

    BMessage(const BMessageHeader& header, PBytes buf, const vector<PStreamRequest>& streams);

    bool isEmpty() const;
};


}

#endif // BMESSAGE_H
