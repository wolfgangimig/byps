#ifndef HTHREADPOOL_H_
#define HTHREADPOOL_H_

#include "Bypshttp.h"

namespace com { namespace wilutions { namespace byps { namespace http {

class HRunnable {
public:
	virtual ~HRunnable() {};
	virtual void run() = 0;
};


class HThreadPool {
public:
	virtual ~HThreadPool() {};

	virtual bool execute(PRunnable r) = 0;

	virtual void done() = 0;

	static PThreadPool create(int maxThreads);
};


}}}}

#endif