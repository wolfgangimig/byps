#ifndef BBYTES_HPP_
#define BBYTES_HPP_

#include "BBytes.h"
#include <cstdarg>
#include <assert.h>

namespace byps {

const int64_t DEBUG_END_MARKER = 0x0102030405060708LL;

BINLINE BBytes* BBytes::myalloc(size_t length) {
	size_t n =  length + sizeof(size_t) + sizeof(int64_t);
	int8_t* mem = new int8_t[n];
	int64_t endm = DEBUG_END_MARKER;
	memcpy(mem + n - sizeof(DEBUG_END_MARKER), &endm, sizeof(int64_t));
	BBytes* p = (BBytes*)(mem);
	p->length = length;
	return p;
}

void BBytes::check() {
	int8_t* mem = (int8_t*)this;
	int8_t* pcheck = mem + sizeof(size_t) + this->length;
	int64_t endm = DEBUG_END_MARKER;
	int cmp = memcmp(pcheck, &endm, sizeof(int64_t));
    assert(cmp == 0);
}

BINLINE PBytes BBytes::create(size_t length) {
	return PBytes(myalloc(length));
}

BINLINE PBytes BBytes::create(size_t length, int v0, ...) {
	BBytes* p = myalloc(length);
	va_list args;
	va_start(args, v0);
	p->data[0] = (int8_t)(v0 & 0xFF);
	for (size_t i = 1; i < length; i++) {
        p->data[i] = (int8_t)(va_arg(args, int) & 0xFF);
	}
	va_end(args);
	return PBytes(p);
}

BINLINE PBytes BBytes::create(const PBytes& p, size_t length) {
	if (length == 0) length = p->length;
	PBytes q = create(length);
	if (p) {
		size_t n = (p->length < length) ? p->length : length;
		memcpy(q->data, p->data, n);
	}
	return q;
}

PBytes BBytes::create(const void* p, size_t length) {
	PBytes q = create(length);
	if (p) {
		memcpy(q->data, p, length);
	}
	return q;
}


}

#endif
