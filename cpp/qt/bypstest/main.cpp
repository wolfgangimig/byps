#include <QCoreApplication>
#include <QtDebug>

#include "main.h"
#include "AllTests.h"
#include "Bypshttp.h"
#include <thread>
#include "BLogger.h"

PHttpClient client;
PHttpGet hget;
PContentStream strm;

void Task::run() {
    try {
        throw BException(123, L"hallo");
    }
    catch (const BException& ex) {
        client.reset();
    }

    AllTests_run(this->parent());

//    client = HttpClient_create(NULL);
//    get = client->get(L"http://www.leo.org");
//    strm = get->send();

//    MyApp* app = (MyApp*)this->parent();
//    app->downloadFile();

//   emit finished();
}

static com::wilutions::byps::BLogger g_log("main");

void myMessageOutput(QtMsgType type, const QMessageLogContext &, const QString &msg)
{
     //in this function, you can write the message to any stream!
     switch (type) {
     case QtDebugMsg:
         if (g_log.isDebugEnabled()) g_log.debug() << msg.toStdWString();
         break;
     case QtWarningMsg:
         if (g_log.isWarnEnabled()) g_log.warn() << msg.toStdWString();
         break;
     case QtCriticalMsg:
         if (g_log.isErrorEnabled()) g_log.error() << msg.toStdWString();
         break;
     case QtFatalMsg:
         if (g_log.isErrorEnabled()) g_log.error() << msg.toStdWString();
         abort();
     }

}


int main(int argc, char *argv[])
{
    qInstallMessageHandler(myMessageOutput);

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


    strm.reset();
    hget.reset();
    client.reset();

    return ret;
}

