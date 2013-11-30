/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef QTTHREADPOOL_HPP_
#define QTTHREADPOOL_HPP_

#ifndef BTHREADPOOL
#define BTHREADPOOL

#include "Byps.h"
#include "QTThreadPool.h"

namespace byps { namespace QT {

using namespace ::std;

class BThreadPoolImpl;
typedef byps_ptr<BThreadPoolImpl> PThreadPoolImpl;



class BThreadPoolImpl : public BThreadPool, public byps_enable_shared_from_this<BThreadPoolImpl> {

    int maxThreads;
    vector<PoolThreadWorker*> allWorkers;
    vector<PoolThreadWorker*> freeWorkers;
    byps_mutex mutex;
    byps_condition_variable waitFreeWorker;
    bool shutdownPhase;

public:

    BThreadPoolImpl(int maxThreads)
        : maxThreads(maxThreads)
        , shutdownPhase(false)
    {

    }

    virtual ~BThreadPoolImpl() {
        byps_unique_lock lock(mutex);
        for (auto it = freeWorkers.begin(); it != freeWorkers.end(); it++) {
            PoolThreadWorker* worker = *it;
            emit worker->thread->quit();
        }
    }

    virtual void done() {
        byps_unique_lock lock(mutex);
        shutdownPhase = true;

        while (freeWorkers.size() != allWorkers.size()) {
            std::chrono::milliseconds timeout(10 * 1000);
            waitFreeWorker.wait_for(lock, timeout);
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
        PoolThreadWorker* worker = allocWorker();
        if (!worker) return false;

        MyRunnable* mr = new MyRunnable();
        mr->r = r;

        emit worker->thread->signal_execute(mr);

        return true;
    }

    void releaseWorker(PoolThreadWorker* worker) {
        byps_unique_lock lock(mutex);
        freeWorkers.push_back(worker);
        waitFreeWorker.notify_all();
    }

    PoolThreadWorker* allocWorker() {
        byps_unique_lock lock(mutex);
        PoolThreadWorker* ret = NULL;

        if (!shutdownPhase) {

            while (freeWorkers.size() == 0 && allWorkers.size() == (size_t)maxThreads) {
                std::chrono::milliseconds timeout(10 * 1000);
                waitFreeWorker.wait_for(lock, timeout);
            }

            if (freeWorkers.size() != 0) {
                ret = *freeWorkers.rbegin();
                freeWorkers.pop_back();
            }
            else if (allWorkers.size() < (size_t) maxThreads){
                ret = createWorker();
                allWorkers.push_back(ret);
            }

        }

        return ret;
    }

    PoolThreadWorker* createWorker() {
        PoolThread* thread = new PoolThread();
        PoolThreadWorker* worker = new PoolThreadWorker(shared_from_this(), thread);
        worker->moveToThread(thread);
        QObject::connect(thread, SIGNAL(finished()), worker, SLOT(deleteLater()));
        QObject::connect(thread, SIGNAL(finished()), thread, SLOT(deleteLater()));
        QObject::connect(thread, SIGNAL(signal_execute(QRunnable*)), worker, SLOT(slot_execute(QRunnable*)));
        thread->start();
        return worker;
    }
};

PoolThreadWorker::PoolThreadWorker(byps_ptr<BThreadPoolImpl> tpool, PoolThread* thread)
    : tpool(tpool)
    , thread(thread)
{
}

PoolThreadWorker::~PoolThreadWorker() {
}

void PoolThreadWorker::slot_execute(QRunnable* r) {
    r->run();
    delete r;
    byps_ptr<BThreadPoolImpl> tpool = this->tpool.lock();
    if (tpool) {
        tpool->releaseWorker(this);
    }
}

PoolThread::PoolThread() {

}

}}

namespace byps {

BINLINE PThreadPool BThreadPool::create(void* , int maxThreads) {
    byps::QT::PThreadPoolImpl tpool(new byps::QT::BThreadPoolImpl(maxThreads));
    return tpool;
}

}

#endif // BTHREADPOOL

#endif
