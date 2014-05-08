/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTargetId_H_
#define BTargetId_H_

#include "Byps.h"
#include <iomanip>

namespace byps {

  class BBuffer;

  class BTargetId
  {
    int32_t serverId;
    int64_t v1;
    int64_t v2;

  public:
    BTargetId();

    BTargetId(int32_t serverId, int64_t v1, int64_t v2);

    int32_t getServerId() const;
    int64_t getMessageId() const;
    int64_t getStreamId() const;

    bool isZero() const;

    void serialize(BBuffer& bbuf);

    bool operator == (const BTargetId& rhs) const;

    static BTargetId parseString(const string& s);

    std::wstring toString() const;

    template <typename _CHAR> 
    friend std::basic_ostream<_CHAR>& operator << (std::basic_ostream<_CHAR>& os, const BTargetId& targetId) {
      os << (_CHAR)'[' << targetId.serverId << (_CHAR)'.' << targetId.v1 << (_CHAR)'.' << targetId.v2 <<  (_CHAR)']';
      return os;
    }
  };



}


#endif
