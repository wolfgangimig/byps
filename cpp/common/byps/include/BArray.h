#ifndef BARRAY_H
#define BARRAY_H

#include "Byps.h"
#include "BIO.h"
#include <cstdarg>

namespace com { namespace wilutions { namespace byps {

template<typename _Type> class BSerializerT;

template<typename _Type> class BArray1 {

	// Use BBytes instead of BArray1<byte> 

public:
    BArray1(size_t length);
    BArray1();
	BArray1(const std::vector<_Type>& vec);
	BArray1(size_t length, _Type v0, ...);
	template<typename _Iter> BArray1(_Iter begin, _Iter end);

    virtual ~BArray1();
    size_t length() const;
    _Type& at(size_t idx);
    const _Type& at(size_t idx) const;
    _Type& operator[](size_t idx);
    const _Type& operator[] (size_t idx) const;
    _Type* ptr();
    const _Type* ptr() const;
	BArray1* set(int idx, _Type value);

    void serialize(BIO& ar, const unsigned int );

private:
    void init(size_t length);
    size_t lengths[1];
    _Type* data;
};

// Use BBytes for Byte arrays instead of BArray<int8_t> or BArray<char> 
template<> class BArray1<int8_t> { private: BArray1() {} BArray1(size_t) {} };
template<> class BArray1<char> { private: BArray1() {} BArray1(size_t) {} };

typedef BArray1<bool> BArrayBool;
typedef BArray1<int16_t> BArrayShort;
typedef BArray1<int32_t> BArrayInt;
typedef BArray1<int64_t> BArrayLong;
typedef BArray1<float> BArrayFloat;
typedef BArray1<double> BArrayDouble;
typedef BArray1<std::wstring> BArrayString;

typedef byps_ptr<BArray1<bool> > PArrayBool;
typedef byps_ptr<BArray1<int16_t> > PArrayShort;
typedef byps_ptr<BArray1<int32_t> > PArrayInt;
typedef byps_ptr<BArray1<int64_t> > PArrayLong;
typedef byps_ptr<BArray1<float> > PArrayFloat;
typedef byps_ptr<BArray1<double> > PArrayDouble;
typedef byps_ptr<BArray1<std::wstring> > PArrayString;

template<typename _Type> class BArray2 {
public:
    BArray2(size_t length1, size_t length0);
    BArray2();
	BArray2(size_t length1, size_t length0, _Type v0, ...);
    virtual ~BArray2();
    size_t length1() const;
    size_t length0() const;
    _Type& at(size_t i1, size_t i0);
    const _Type& at(size_t i1, size_t i0) const;
    _Type* ptr();
    const _Type* ptr() const;
	BArray2* set(int i1, int i0, _Type value);
    void serialize(BIO& ar, const unsigned int );

private:
    void init(size_t length1, size_t length0);
    size_t lengths[2];
    _Type* data;
};



template<typename _Type> class BArray3 {
public:
    BArray3(size_t length2, size_t length1, size_t length0);
    BArray3();
	BArray3(size_t length2, size_t length1, size_t length0, _Type v0, ...);
    virtual ~BArray3();
    size_t length2() const;
    size_t length1() const;
    size_t length0() const;
    _Type& at(size_t i2, size_t i1, size_t i0);
    const _Type& at(size_t i2, size_t i1, size_t i0) const;
    _Type* ptr();
    const _Type* ptr() const;
	BArray3* set(int i2, int i1, int i0, _Type value);
    void serialize(BIO& ar, const unsigned int );

private:
    void init(size_t length2, size_t length1, size_t length0);
    size_t lengths[3];
    _Type* data;
};




template<typename _Type> class BArray4 {
public:
    BArray4(size_t length3, size_t length2, size_t length1, size_t length0);
    BArray4();
    BArray4(size_t length3, size_t length2, size_t length1, size_t length0, _Type v0, ...);
    virtual ~BArray4();
    size_t length3() const;
    size_t length2() const;
    size_t length1() const;
    size_t length0() const;
    _Type& at(size_t i3, size_t i2, size_t i1, size_t i0);
    const _Type& at(size_t i3, size_t i2, size_t i1, size_t i0) const;
    _Type* ptr();
    const _Type* ptr() const;
	BArray4* set(int i3, int i2, int i1, int i0, _Type value);
    void serialize(BIO& ar, const unsigned int );

private:
    void init(size_t length3, size_t length2, size_t length1, size_t length0);
    size_t lengths[4];
    _Type* data;
};



// -----------------------------------------------------------------
// BArray1

template<typename _Type> void BArray1<_Type>::init(size_t length) {
    lengths[0] = length;
    data = length ? new _Type[length] : 0;
}

template<typename _Type> BArray1<_Type>::BArray1(size_t length) {
    init(length);
}

template<typename _Type> BArray1<_Type>::BArray1() {
	init(0);
}

template<typename _Type> BArray1<_Type>::BArray1(const std::vector<_Type>& vec) {
    init(vec.size());
	for (size_t i = 0; i < vec.size(); i++) {
		data[i] = vec[i];
	}
}

template<typename _Type> BArray1<_Type>::BArray1(size_t length, _Type v0, ...) {
	init(length);
	va_list args;
	va_start(args, v0);
	data[0] = v0;
	for (size_t i = 1; i < length; i++) {
		data[i] = va_arg(args, _Type);
	}
	va_end(args);
}

template<typename _Type> template<typename _Iter> BArray1<_Type>::BArray1(_Iter begin, _Iter end) {
	size_t length = end - begin;
	init(length);
	_Type* q = data;
	for (_Iter p = begin; p != end; p++, q++) {
		*q = *p;
	}
}

template<typename _Type> BArray1<_Type>::~BArray1() {
    if (data) delete[] data;
}

template<typename _Type> _Type& BArray1<_Type>::at(size_t idx) {
    return data[idx];
}

template<typename _Type> const _Type& BArray1<_Type>::at(size_t idx) const {
    return data[idx];
}

template<typename _Type> _Type& BArray1<_Type>::operator[](size_t idx) {
    return data[idx];
}

template<typename _Type> const _Type& BArray1<_Type>::operator[](size_t idx) const {
    return data[idx];
}

template<typename _Type> size_t BArray1<_Type>::length() const {
    return lengths[0];
}

template<typename _Type> _Type* BArray1<_Type>::ptr() {
    return data;
}

template<typename _Type> const _Type* BArray1<_Type>::ptr() const {
    return data;
}

template<typename _Type> BArray1<_Type> * BArray1<_Type>::set(int i, _Type value) {
	at(i) = value;
	return this;
}

// -----------------------------------------------------------------
// BArray2

template<typename _Type> void BArray2<_Type>::init(size_t length1, size_t length0) {
    lengths[1] = length1;
    lengths[0] = length0;
    data = length1 && length0 ? new _Type[length1*length0] : 0;
}

template<typename _Type> BArray2<_Type>::BArray2(size_t length1, size_t length0) {
    init(length1, length0);
}

template<typename _Type> BArray2<_Type>::BArray2() {
	init(0, 0);
}

template<typename _Type> BArray2<_Type>::BArray2(size_t length1, size_t length0, _Type v0, ...) {
	init(length1, length0);
	va_list args;
	va_start(args, v0);
	data[0] = v0;
	for (size_t i = 1; i < length1*length0; i++) {
		data[i] = va_arg(args, _Type);
	}
	va_end(args);
}

template<typename _Type> BArray2<_Type>::~BArray2() {
    if (data) delete[] data;
}

template<typename _Type> _Type& BArray2<_Type>::at(size_t i1, size_t i0) {
    size_t idx = i1 * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> const _Type& BArray2<_Type>::at(size_t i1, size_t i0) const {
    size_t idx = i1 * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> size_t BArray2<_Type>::length1() const {
    return lengths[1];
}

template<typename _Type> size_t BArray2<_Type>::length0() const {
    return lengths[0];
}

template<typename _Type> _Type* BArray2<_Type>::ptr() {
    return data;
}

template<typename _Type> const _Type* BArray2<_Type>::ptr() const {
    return data;
}

template<typename _Type> BArray2<_Type> * BArray2<_Type>::set(int i1, int i0, _Type value) {
	at(i1,i0) = value;
	return this;
}
// -----------------------------------------------------------------
// BArray3

template<typename _Type> void BArray3<_Type>::init(size_t length2, size_t length1, size_t length0) {
    lengths[2] = length2;
    lengths[1] = length1;
    lengths[0] = length0;
    data = length2 && length1 && length0 ? new _Type[length2*length1*length0] : 0;
}

template<typename _Type> BArray3<_Type>::BArray3(size_t length2, size_t length1, size_t length0) {
    init(length2, length1, length0);
}

template<typename _Type> BArray3<_Type>::BArray3() {
	init(0, 0, 0);
}

template<typename _Type> BArray3<_Type>::BArray3(size_t length2, size_t length1, size_t length0, _Type v0, ...) {
	init(length2, length1, length0);
	va_list args;
	va_start(args, v0);
	data[0] = v0;
	for (size_t i = 1; i < length2*length1*length0; i++) {
		data[i] = va_arg(args, _Type);
	}
	va_end(args);
}

template<typename _Type> BArray3<_Type>::~BArray3() {
    if (data) delete[] data;
}

template<typename _Type> _Type& BArray3<_Type>::at(size_t i2, size_t i1, size_t i0) {
    size_t idx = (i2 * lengths[1] + i1) * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> const _Type& BArray3<_Type>::at(size_t i2, size_t i1, size_t i0) const {
    size_t idx = (i2 * lengths[1] + i1) * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> size_t BArray3<_Type>::length2() const {
    return lengths[2];
}

template<typename _Type> size_t BArray3<_Type>::length1() const {
    return lengths[1];
}

template<typename _Type> size_t BArray3<_Type>::length0() const {
    return lengths[0];
}

template<typename _Type> _Type* BArray3<_Type>::ptr() {
    return data;
}

template<typename _Type> const _Type* BArray3<_Type>::ptr() const {
    return data;
}

template<typename _Type> BArray3<_Type> * BArray3<_Type>::set(int i2, int i1, int i0, _Type value) {
	at(i2,i1,i0) = value;
	return this;
}


// -----------------------------------------------------------------
// BArray4

template<typename _Type> void BArray4<_Type>::init(size_t length3, size_t length2, size_t length1, size_t length0) {
    lengths[3] = length3;
    lengths[2] = length2;
    lengths[1] = length1;
    lengths[0] = length0;
    data = length3 && length2 && length1 && length0 ? new _Type[length3*length2*length1*length0] : 0;
}

template<typename _Type> BArray4<_Type>::BArray4(size_t length3, size_t length2, size_t length1, size_t length0) {
    init(length3, length2, length1, length0);
}

template<typename _Type> BArray4<_Type>::BArray4() {
	init(0, 0, 0, 0);
}

template<typename _Type> BArray4<_Type>::BArray4(size_t length3, size_t length2, size_t length1, size_t length0, _Type v0, ...) {
	init(length3, length2, length1, length0);
	va_list args;
	va_start(args, v0);
	data[0] = v0;
	for (size_t i = 1; i < length3*length2*length1*length0; i++) {
		data[i] = va_arg(args, _Type);
	}
	va_end(args);
}

template<typename _Type> BArray4<_Type>::~BArray4() {
    if (data) delete[] data;
}

template<typename _Type> _Type& BArray4<_Type>::at(size_t i3, size_t i2, size_t i1, size_t i0) {
    size_t idx = ((i3 * lengths[2] + i2) * lengths[1] + i1) * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> const _Type& BArray4<_Type>::at(size_t i3, size_t i2, size_t i1, size_t i0) const {
    size_t idx = ((i3 * lengths[2] + i2) * lengths[1] + i1) * lengths[0] + i0;
    return data[idx];
}

template<typename _Type> size_t BArray4<_Type>::length3() const {
    return lengths[3];
}

template<typename _Type> size_t BArray4<_Type>::length2() const {
    return lengths[2];
}

template<typename _Type> size_t BArray4<_Type>::length1() const {
    return lengths[1];
}

template<typename _Type> size_t BArray4<_Type>::length0() const {
    return lengths[0];
}

template<typename _Type> _Type* BArray4<_Type>::ptr() {
    return data;
}

template<typename _Type> const _Type* BArray4<_Type>::ptr() const {
    return data;
}

template<typename _Type> BArray4<_Type> * BArray4<_Type>::set(int i3, int i2, int i1, int i0, _Type value) {
	at(i3,i2,i1,i0) = value;
	return this;
}

template<typename _Type> void BArray1<_Type>::serialize(BIO& ar, const unsigned int ) {
    int32_t n0 = ar.is_loading ? 0 : (int32_t)lengths[0];
    ar & n0;
    if (ar.is_loading) init((size_t)n0);
    for (size_t i0 = 0; i0 < (size_t)n0; i0++) {
        ar & data[i0];
    }
}

template<typename _Type> void BArray2<_Type>::serialize(BIO& ar, const unsigned int ) {
    int32_t n1 = ar.is_loading ? 0 : (int32_t)lengths[1];
    int32_t n0 = ar.is_loading ? 0 : (int32_t)lengths[0];
    ar & n1;
    ar & n0;
    if (ar.is_loading) init((size_t)n1, (size_t)n0);
    for (size_t i1 = 0; i1 < (size_t)n1; i1++) {
        for (size_t i0 = 0; i0 < (size_t)n0; i0++) {
            ar & at(i1, i0);
        }
    }
}

template<typename _Type> void BArray3<_Type>::serialize(BIO& ar, const unsigned int ) {
    int32_t n2 = ar.is_loading ? 0 : (int32_t)lengths[2];
    int32_t n1 = ar.is_loading ? 0 : (int32_t)lengths[1];
    int32_t n0 = ar.is_loading ? 0 : (int32_t)lengths[0];
    ar & n2;
    ar & n1;
    ar & n0;
    if (ar.is_loading) init((size_t)n2, (size_t)n1, (size_t)n0);
    for (size_t i2 = 0; i2 < (size_t)n2; i2++) {
        for (size_t i1 = 0; i1 < (size_t)n1; i1++) {
            for (size_t i0 = 0; i0 < (size_t)n0; i0++) {
                ar & at(i2, i1, i0);
            }
        }
    }
}

template<typename _Type> void BArray4<_Type>::serialize(BIO& ar, const unsigned int ) {
    int32_t n3 = ar.is_loading ? 0 : (int32_t)lengths[3];
    int32_t n2 = ar.is_loading ? 0 : (int32_t)lengths[2];
    int32_t n1 = ar.is_loading ? 0 : (int32_t)lengths[1];
    int32_t n0 = ar.is_loading ? 0 : (int32_t)lengths[0];
    ar & n3;
    ar & n2;
    ar & n1;
    ar & n0;
    if (ar.is_loading) init((size_t)n3, (size_t)n2, (size_t)n1, (size_t)n0);
    for (size_t i3 = 0; i3 < (size_t)n3; i3++) {
        for (size_t i2 = 0; i2 < (size_t)n2; i2++) {
          for (size_t i1 = 0; i1 < (size_t)n1; i1++) {
                for (size_t i0 = 0; i0 < (size_t)n0; i0++) {
                    ar & at(i3, i2, i1, i0);
                }
            }
        }
    }
}

}}}

#endif // BARRAY_H
