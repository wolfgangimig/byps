#include <QCoreApplication>

#include "main.h"
#include "AllTests.h"
#include <thread>

using namespace com::wilutions::byps;

class TestRunnable : public BRunnable {
public:
    Task* task;
    TestRunnable(Task* task) : task(task) {}

    virtual void run() {
        AllTests_run();
        emit task->finished();
    }
};

PThreadPool tpool;

void Task::run() {
    tpool->execute(PRunnable(new TestRunnable(this)));
}

int main(int argc, char *argv[])
{
    tpool = BThreadPool::create(12);

    QCoreApplication a(argc, argv);

    // Task parented to the application so that it
    // will be deleted by the application.
    Task *task = new Task(&a);

    // This will cause the application to exit when
    // the task signals finished.
    QObject::connect(task, SIGNAL(finished()), &a, SLOT(quit()));

    // This will run the task from the application event loop.
    QTimer::singleShot(0, task, SLOT(run()));

    int ret = a.exec();

    return ret;
}

