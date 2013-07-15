#ifndef BBYTES_HPP_
#define BBYTES_HPP_

#include "BBytes.h"
#include <cstdarg>

namespace com { namespace wilutions { namespace byps {

BINLINE PBytes BBytes::create(size_t length) {
	size_t n =  length + sizeof(BBytes);
	BBytes* p = (BBytes*)(new int8_t[n]);
	if (p) {
		p->length = length;
	}
	return PBytes(p);
}

BINLINE PBytes BBytes::create(size_t length, int v0, ...) {
	size_t n =  length + sizeof(BBytes);
	BBytes* p = (BBytes*)(new int8_t[n]);
	if (p) {
		p->length = length;
	}
	va_list args;
	va_start(args, v0);
	p->data[0] = v0;
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

}}}

#endif
