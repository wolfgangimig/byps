#ifndef QTTHREADPOOL_HPP_
#define QTTHREADPOOL_HPP_

#ifndef BTHREADPOOL
#define BTHREADPOOL

#include "Byps.h"

#include <QThreadPool>

namespace com { namespace wilutions { namespace byps { 

class BThreadPoolImpl;
typedef byps_ptr<BThreadPoolImpl> PThreadPoolImpl;

class BThreadPoolImpl : public BThreadPool {

    int maxThreads;
    QThreadPool* qool;

public:

    BThreadPoolImpl(int maxThreads)
        : maxThreads(maxThreads)
        , qool(NULL){

        qool = new QThreadPool();
        qool->setMaxThreadCount(maxThreads);
    }

    virtual ~BThreadPoolImpl() {
        if (qool) {
            delete qool;
        }
    }

    virtual void done() {
        if (qool) {
            qool->waitForDone();
        }
    }

    class MyRunnable : public QRunnable {
    public:
        PRunnable r;
        virtual void run() {
            r->run();
        }
    };

    virtual bool execute(PRunnable r) {
        if (!qool) return false;
        MyRunnable* mr = new MyRunnable();
        mr->r = r;
        qool->start(mr);
        return true;
    }
};

BINLINE PThreadPool BThreadPool::create(int maxThreads) {
    PThreadPoolImpl tpool(new BThreadPoolImpl(maxThreads));
    return tpool;
}

}}}

#endif // BTHREADPOOL

#endif
