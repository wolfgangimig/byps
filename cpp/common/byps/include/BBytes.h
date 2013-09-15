#ifndef BBYTES_H_
#define BBYTES_H_

#include "Byps.h"
#include "BAsyncResult.h"

namespace com { namespace wilutions { namespace byps {

class BBytes {
public:

	size_t length;
	int8_t data[1];

	static PBytes create(size_t length);
	static PBytes create(const PBytes& p, size_t length = 0);
	static PBytes create(const void* p, size_t length);
	
    static PBytes create(size_t length, int v0, ...);

	void check();

private:
	static BBytes* myalloc(size_t length);

};

}}}

#endif
