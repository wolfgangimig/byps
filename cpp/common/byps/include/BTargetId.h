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
    int32_t remoteId;
    int64_t v1;
    int64_t v2;
    int64_t signature;

  public:
    BTargetId();

    BTargetId(int32_t serverId, int64_t v1, int64_t v2);
    BTargetId(int32_t serverId, int32_t, int64_t v1, int64_t v2, int64_t signature);

    int32_t getServerId() const;
    int64_t getMessageId() const;
    int64_t getStreamId() const;
    int32_t getRemoteId() const;
    int64_t getSignature() const;

    bool isZero() const;

    void serialize(BBuffer& bbuf, int32_t bversion);

    bool operator == (const BTargetId& rhs) const;

    static BTargetId parseString(const string& s);

    std::wstring makeHeaderString() const;
    std::wstring toString() const;

    string toSessionId() const;

    static void writeSessionId(BBuffer& bbuf, const string& sessionId);
    static string readSessionId(BBuffer& bbuf);

    template <typename _CHAR> 
    friend std::basic_ostream<_CHAR>& operator << (std::basic_ostream<_CHAR>& os, const BTargetId& targetId) {
      os << (_CHAR)'[' << targetId.serverId << (_CHAR)'.' << targetId.v1 << (_CHAR)'.' << targetId.v2;
      if (targetId.remoteId != 0) {
        os << (_CHAR)'.' << targetId.remoteId << (_CHAR)'.' << targetId.signature;
      }
      os << (_CHAR)']';
      return os;
    }

  private:
    static string toSessionId(int64_t v1, int64_t v2);

  };



}


#endif
