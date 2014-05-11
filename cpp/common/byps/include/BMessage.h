/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMESSAGE_H
#define BMESSAGE_H

#include "Byps.h"

namespace byps {

using namespace ::std;

class BMessage {
public:
    BMessageHeader header;
    PBytes buf;
    vector<PContentStream> streams;

    BMessage(const BMessageHeader& header, PBytes buf, const vector<PContentStream>& streams);

    bool isEmpty() const;
};


}

#endif // BMESSAGE_H
