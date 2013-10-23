#ifndef BSTREAMREQUEST_H
#define BSTREAMREQUEST_H

#include "Byps.h"

namespace byps {

class BStreamRequest {
public:
    BStreamRequest();
    BStreamRequest(const BStreamRequest& rhs);
    int64_t streamId;
    int64_t messageId;
    PContentStream strm;
};



}

#endif // BSTREAMREQUEST_H
