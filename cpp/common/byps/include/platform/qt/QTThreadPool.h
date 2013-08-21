#ifndef QTTHREADPOOLI_H
#define QTTHREADPOOLI_H

#include <QThread>
#include <QRunnable>
#include "Byps.h"

namespace com { namespace wilutions { namespace byps { namespace QT {

//http://mayaposch.wordpress.com/2011/11/01/how-to-really-truly-use-qthreads-the-full-explanation/

class BThreadPoolImpl;
class PoolThread;

class PoolThreadWorker : public QObject {
    Q_OBJECT
public:
    byps_weak_ptr<BThreadPoolImpl> tpool;
    PoolThread* thread;

    PoolThreadWorker(byps_ptr<BThreadPoolImpl> tpool, PoolThread* thread);
    virtual ~PoolThreadWorker();

public slots:
    void slot_execute(QRunnable*);
};

class PoolThread : public QThread {
    Q_OBJECT
public:
    PoolThread();
signals:
    void signal_execute(QRunnable*);
};


}}}}

#endif // QTTHREADPOOLI_H
