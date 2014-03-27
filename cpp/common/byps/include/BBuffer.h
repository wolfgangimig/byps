/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BBUFFER_H_
#define BBUFFER_H_

#include "Byps.h"
#include "BException.h"
#include "BByteOrder.h"
#include "BApiDescriptor.h"
#include "BBytes.h"
#include "BAsyncResult.h"
#include <string>
#include <vector>

namespace byps {

  // wird als Version von BInputC und BOutputC verwendet
  const int32_t BDISABLE_VERSION_CHECK = 0x7FFFFFFF;

  class BBuffer {
  public:

    BBuffer(const BBinaryModel& bmodel, BByteOrder byteOrder);
    BBuffer(const BBinaryModel& bmodel, const PBytes& pBytes, BByteOrder byteOrder);

    const PBytes& getBytes() const;

    void clear();

    BByteOrder getByteOrder() const;

    void setByteOrder(BByteOrder byteOrder);

    bool isCompressInteger() const;
    bool setCompressInteger(bool v);

    void serialize(PBytes& v);

    void serialize(int8_t& v);
    void serialize(int16_t& v);
    void serialize(int32_t& v);
    void serialize(int64_t& v);
    void serialize(bool& b);
    void serialize(wchar_t& c);
    void serialize(float& v);
    void serialize(double& v);
    void serialize(BDateTime& v);

    void serializePointer(BPOINTER& p);

    void serializeTypeId(BTYPEID& p);

    void serializeLength(BLENGTH& p);

    void serialize(wstring& str);

    void serialize(string& str);

    bool isEmpty();

    virtual ~BBuffer();

  private:

    void ensureRemaining(int32_t size);
    void growForRemaining(int32_t size);

    template<typename _int163264> void serializeIntegerUnaligned(_int163264& v) {

      ensureRemaining(sizeof(v));

      {
        int8_t* p = pBytes->data + pos;
        if (isWrite) {
          _int163264 v1 = byteOrder.swapIf(v);
          writeUnalignedInt163264(p, v1);
        }
        else {
          _int163264 v1 = _int163264();
          readUnalignedInt163264(p, v1);
          v = byteOrder.swapIf(v1);
        }

        pos += sizeof(_int163264);
      }
    }

    template<typename _int3264> void serializeIntegerCompressed(_int3264& v1) {

      register int64_t v = v1;

      if (isWrite) {

        if (v == 0) {
          ensureRemaining(1);
          pBytes->data[pos++] = 0;
        }
        else {
          ensureRemaining(sizeof(v) + 2);
          int8_t *p = pBytes->data + pos;

          bool neg = v < 0;
          if (neg) v = -(v + 1);
          v <<= 1;
          if (neg) v |= 1;

          int i = 0;
          for (; i < 10 && v != 0; i++)
          {
            bool moreBytes = (v & ~0x7F) != 0;
            int h = ((int)v) & 0x7F;
            if (moreBytes) h |= 0x80;
            p[i] = (int8_t)h;
            v = (int64_t)((uint64_t)v >> 7);
          }

          pos += i;
        }
      }

      else {

        int8_t *p = pBytes->data + pos;

        v = 0;

        if (*p == 0) {
          ensureRemaining(1);
          pos++;
        }
        else {
          int i = 0;
          int shift = 0;
          bool moreBytes = true;
          for (; i < 10 && moreBytes; i++) {
            int h = p[i];
            moreBytes = (h & 0x80) != 0;
            v |= ((int64_t)(h & 0x7F)) << shift;
            shift += 7;
          }

          if (moreBytes) {
            throw BException(BExceptionC::CORRUPT, L"Read integer failed.");
          }

          bool neg = (v & 0x01) != 0;
          v = (int64_t)((uint64_t)v >> 1);   
          if (neg) v = -(v+1);

          pos += i;
        }

        v1 = (_int3264)v;

      }
    }

    int32_t getStringLengthUtf8(const ::std::wstring& str);

    BBinaryModel bmodel;
    bool isWrite;
    BByteOrder byteOrder;
    PBytes pBytes;
    int32_t pos, limit, capacity;
    int32_t grow;
    bool compressInteger;
  };

} /* namespace byps */
#endif /* BMEM_H_ */
