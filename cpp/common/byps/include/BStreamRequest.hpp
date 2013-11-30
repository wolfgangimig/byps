/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSTREAMREQUEST_HPP
#define BSTREAMREQUEST_HPP


namespace byps {

BINLINE BStreamRequest::BStreamRequest()
    : streamId(0), messageId(0) {
}

BINLINE BStreamRequest::BStreamRequest(const BStreamRequest& rhs)
    : streamId(rhs.streamId)
    , messageId(rhs.messageId)
    , strm(rhs.strm) {
}

}


#endif // BSTREAMREQUEST_HPP
