/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BBUFFER_HPP_
#define BBUFFER_HPP_

#include "BBuffer.h"

namespace byps {

#define BCOMPRESS_INTEGER true
#define BBUFFER_GROW (10*1000)

  using namespace ::std;

  BINLINE BBuffer::BBuffer(const BBinaryModel& bmodel, BByteOrder byteOrder) :
    bmodel(bmodel),
    isWrite(true), byteOrder(byteOrder),
    pos(0), limit(0), capacity(0), grow(BBUFFER_GROW), compressInteger(BCOMPRESS_INTEGER) {
  }

  BINLINE BBuffer::BBuffer(const BBinaryModel& bmodel, const PBytes& pBytes, BByteOrder byteOrder) :
    bmodel(bmodel),
    isWrite(false), byteOrder(byteOrder),
    pBytes(pBytes), pos(0), limit((int32_t)pBytes->length), capacity((int32_t)pBytes->length), grow(0), compressInteger(BCOMPRESS_INTEGER) {
  }

  BINLINE const PBytes& BBuffer::getBytes() const {
    pBytes->length = (size_t)pos;
    return pBytes;
  }

  BINLINE void BBuffer::clear() {
    pos = 0;
    limit = 0;
  }

  BINLINE BByteOrder BBuffer::getByteOrder() const {
    return byteOrder;
  }

  BINLINE void BBuffer::setByteOrder(BByteOrder byteOrder) {
    this->byteOrder = byteOrder;
  }

  BINLINE bool BBuffer::isCompressInteger() const {
    return this->compressInteger;
  }

  BINLINE bool BBuffer::setCompressInteger(bool v) {
    bool ret = this->compressInteger;
    this->compressInteger = v;
    return ret;
  }


  BINLINE void BBuffer::serialize(PBytes& v) {
    BLENGTH n = (BLENGTH)(isWrite ? v->length : 0);

    ensureRemaining(n + sizeof(BLENGTH));

    serializeLength(n);

    {
      int8_t* buf = pBytes->data;
      if (isWrite) {
        memcpy(buf + pos, v->data, n);
      }
      else {
        v = BBytes::create(n);
        memcpy(v->data, buf + pos, n);
      }
      pos += n;
    }
  }

  BINLINE void BBuffer::serialize(int8_t& v) {
    ensureRemaining(1);

    {
      if (isWrite) {
        pBytes->data[pos] = v;
      }
      else {
        v = pBytes->data[pos];
      }
      pos++;
    }
  }

  BINLINE void BBuffer::serialize(int16_t& v) {
    serializeIntegerUnaligned(v);
  }

  BINLINE void BBuffer::serialize(int32_t& v) {
    if (compressInteger) {
      serializeIntegerCompressed(v);
    }
    else {
      serializeIntegerUnaligned(v);
    }
  }

  BINLINE void BBuffer::serialize(int64_t& v) {
    if (compressInteger) {
      serializeIntegerCompressed(v);
    }
    else {
      serializeIntegerUnaligned(v);
    }
  }

  BINLINE void BBuffer::serialize(bool& b) {
    if (isWrite) {
      int8_t v = b ? 1 : 0;
      serialize(v);
    }
    else {
      int8_t v = 0;
      serialize(v);
      b = v != 0;
    }
  }

  BINLINE void BBuffer::serialize(wchar_t& c) {
    if (isWrite) {
      int16_t v = (int16_t)c;
      serialize(v);
    }
    else {
      int16_t v = 0;
      serialize(v);
      c = (int16_t)v;
    }
  }

  BINLINE void BBuffer::serialize (float& v) {
    if (isWrite) {
      int32_t IEEE = floatToIEEE(v);
      serializeIntegerUnaligned(IEEE);
    }
    else {
      int32_t IEEE = 0;
      serializeIntegerUnaligned(IEEE);
      v = floatFromIEEE(IEEE);
    }
  }

  BINLINE void BBuffer::serialize (double& v) {
    if (isWrite) {
      int64_t IEEE = doubleToIEEE(v);
      serializeIntegerUnaligned(IEEE);
    }
    else {
      int64_t IEEE = 0;
      serializeIntegerUnaligned(IEEE);
      v = doubleFromIEEE(IEEE);
    }
  }

  BINLINE void BBuffer::serialize(BDateTime& v) {
    if (isWrite) {

      int16_t _mmdd = (int16_t)((v.month << 8) | v.day);
      int16_t _hhmm = (int16_t)((v.hour << 8) | v.minute);
      int16_t _ssuu = (int16_t)((v.second << 10) | (v.millisecond));

      serialize(v.year);
      serialize(_mmdd);
      serialize(_hhmm);
      serialize(_ssuu);

    }
    else {

      int16_t _mmdd = 0;
      int16_t _hhmm = 0;
      int16_t _ssuu = 0;
      serialize(v.year);
      serialize(_mmdd);
      serialize(_hhmm);
      serialize(_ssuu);

      v.month = (_mmdd >> 8) & 0xFF;
      v.day = _mmdd & 0xFF;
      v.hour = (_hhmm >> 8) & 0xFF;
      v.minute = _hhmm & 0xFF;
      v.second = (_ssuu >> 10) & 0x3F;
      v.millisecond = _ssuu & 0x3FF;

    }
  }

  BINLINE void BBuffer::serializePointer(BPOINTER& p) {
    int32_t v = p;
    serialize(v);
    if (!isWrite) p = v;
  }

  BINLINE void BBuffer::serializeTypeId(BTYPEID& p) {
    int32_t v = p;
    serialize(v);
    if (!isWrite) p = v;
  }

  BINLINE void BBuffer::serializeLength(BLENGTH& p) {
    int32_t v = p;
    serialize(v);
    if (!isWrite) p = v;
  }

  BINLINE int32_t BBuffer::getStringLengthUtf8(const ::std::wstring& str) {

    int32_t p = 0;

    for (wstring::const_iterator it = str.begin(); it != str.end(); it++) {

      wchar_t c = (*it);

      if (c <= 0x7F) {
        p++;
      }
      else if (c >= 0x80 && c <= 0x07FF) {
        p += 2;
      }
      else { // if (c >= 0x800 && c <= 0xFFFF) {
        p += 3;
      }
    }

    return p;
  }

  BINLINE void BBuffer::serialize(wstring& str) {
    if (isWrite) {

      int32_t n = 0;

      if (compressInteger) {
        n = getStringLengthUtf8(str);
      }
      else {
        n = (int32_t)(3 * str.size());
      }

      ensureRemaining(4 + n + 1);

      serialize(n);
      int32_t lengthPos = pos - 4;

      if (str.size() != 0) {

        int8_t* buf = pBytes->data;
        int8_t* p = buf + pos;

        for (wstring::iterator it = str.begin(); it != str.end(); it++) {

          wchar_t c = (*it);

          if (c <= 0x7F) {
            *p++ = (int8_t)c;
          }
          else if (c >= 0x80 && c <= 0x07FF) {
            *p++ = (int8_t)(((c >> 6) & 0x1F) | 0xC0);
            *p++ = (int8_t)((c & 0x3F) | 0x80);
          }
          else { // if (c >= 0x800 && c <= 0xFFFF) {
            *p++ = (int8_t)(((c >> 12) & 0xF) | 0xE0);
            *p++ = (int8_t)(((c >> 6) & 0x3F) | 0x80);
            *p++ = (int8_t)((c & 0x3F) | 0x80);
          }
        }

        // correct length
        if (!compressInteger) {
          n = (int32_t)(p - buf) - pos;
          pos = lengthPos;
          serialize(n);
        }

        *p++ = 0;
        pos = (int32_t)(p - buf);
        assert(pos <= capacity);
      }
      else {
        pBytes->data[pos++] = 0;
      }

    }
    else {
      int32_t blen = 0;
      serialize(blen);

      str.clear();
      str.reserve((size_t)blen);

      int8_t* buf = pBytes->data;
      int8_t* p = buf + pos;
      int8_t* pend = p + blen;

      while (p < pend) {
        wchar_t c = (wchar_t)(*p);
        p++;
        int16_t u4bits = (c & 0xF0);
        if (u4bits == 0xC0 || u4bits == 0xD0) {
          c &= 0x1F;
          c <<= 6;
          c |= (wchar_t)((*p++ & 0x3F));
        }
        else if (u4bits == 0xE0) {
          c &= 0xF;
          c <<= 6;
          c |= (wchar_t)((*p++ & 0x3F));
          c <<= 6;
          c |= (wchar_t)((*p++ & 0x3F));
        }

        str += c;
      }

      char _0 = *p++;
      if (_0 != 0) throw new BException(BExceptionC::CORRUPT);

      pos = (int32_t)(p - buf);
    }

  }

  BINLINE void BBuffer::serialize(string& str) {
    if (isWrite) {
      int32_t n = (int32_t)str.size();
      serialize(n);

      int32_t blen = n+1;
      ensureRemaining(blen);

      int8_t* buf = pBytes->data;
      int8_t* p = buf + pos;
      memcpy(p, str.c_str(), blen);

      pos += blen;

    }
    else {
      int32_t n = 0;
      serialize(n);

      int8_t* buf = pBytes->data;
      int8_t* p = buf + pos;
      str = string((char*)p, (size_t)n);

      char _0 = *(p + n);
      if (_0 != 0) throw new BException(BExceptionC::CORRUPT);

      pos += n + 1;
    }
  }

  BINLINE bool BBuffer::isEmpty() {
    return pos == 0;
  }

  BINLINE BBuffer::~BBuffer() {
  }

  BINLINE void BBuffer::growForRemaining(int32_t size) {
    const int32_t requiredCapacity = pos + size;
    int32_t growNow = requiredCapacity - capacity;
    growNow = ((growNow / grow) + 1) * grow;
    int32_t newCap = capacity + growNow;
    pBytes = BBytes::create(pBytes, newCap);
    if (!pBytes) throw BException(BExceptionC::INTERNAL, L"Out of memory.");
    capacity = newCap;
    limit = capacity;
  }

  BINLINE void BBuffer::ensureRemaining(int32_t size) {
    if (!isWrite) return;

    if (pBytes) {
      pBytes->check();
    }
    
    if (pos + size > capacity) {
      growForRemaining(size);
    }
  }

} /* namespace byps */
#endif 
