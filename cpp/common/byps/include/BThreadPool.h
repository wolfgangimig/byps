#ifndef HTHREADPOOL_H_
#define HTHREADPOOL_H_

#include "Byps.h"

namespace com { namespace wilutions { namespace byps { 

class BRunnable {
public:
	virtual ~BRunnable() {};
	virtual void run() = 0;
};


class BThreadPool {
public:
	virtual ~BThreadPool() {};

	virtual bool execute(PRunnable r) = 0;

	virtual void done() = 0;

	static PThreadPool create(int maxThreads);
};


}}}

#endif
