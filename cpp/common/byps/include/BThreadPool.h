/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HTHREADPOOL_H_
#define HTHREADPOOL_H_

#include "Byps.h"

namespace byps { 

class BRunnable {
public:
    virtual ~BRunnable() {}
	virtual void run() = 0;
};


class BThreadPool {
public:
    virtual ~BThreadPool() {}

	virtual bool execute(PRunnable r) = 0;

    virtual void done() = 0;

    static PThreadPool create(void* app, int maxThreads);
};


}

#endif
