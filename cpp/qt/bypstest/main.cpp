#include <QCoreApplication>

#include "main.h"
#include "AllTests.h"
#include "Bypshttp.h"
#include <thread>


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


MyApp::MyApp(int argc, char *argv[])
    : QCoreApplication(argc, argv)
    , reply(NULL), file(NULL), httpGetId(0), httpRequestAborted(false)
{
}

void MyApp::startRequest(QUrl url)
{
    reply = qnam.get(QNetworkRequest(url));
    connect(reply, SIGNAL(finished()),
            this, SLOT(httpFinished()));
    connect(reply, SIGNAL(readyRead()),
            this, SLOT(httpReadyRead()));

    connect(reply, SIGNAL(error(QNetworkReply::NetworkError)),
            this, SLOT(httpError(QNetworkReply::NetworkError)));

    connect(&qnam, SIGNAL(networkSessionConnected()),
            this, SLOT(nm_networkSessionConnected()));
}

void MyApp::nm_networkSessionConnected()
{
    httpRequestAborted = false;
}

void MyApp::httpError(QNetworkReply::NetworkError err)
{
    std::wstringstream wss;
    wss << (int)err;
    std::wstring str = wss.str();
    url = "";
}

void MyApp::downloadFile()
{
    url = "http://www.leo.org";

    QFileInfo fileInfo(url.path());
    QString fileName = fileInfo.fileName();
    if (fileName.isEmpty())
        fileName = "index.html";

    file = new QFile(fileName);
    if (!file->open(QIODevice::WriteOnly)) {
//        QMessageBox::information(this, tr("HTTP"),
//                                 tr("Unable to save the file %1: %2.")
//                                 .arg(fileName).arg(file->errorString()));
        delete file;
        file = 0;
        return;
    }

    // schedule the request
    httpRequestAborted = false;
    startRequest(url);
}

void MyApp::httpFinished()
{
    if (httpRequestAborted) {
        if (file) {
            file->close();
            file->remove();
            delete file;
            file = 0;
        }
        reply->deleteLater();
        return;
    }

    file->flush();
    file->close();


    QVariant redirectionTarget = reply->attribute(QNetworkRequest::RedirectionTargetAttribute);
    if (reply->error()) {
        file->remove();
//        QMessageBox::information(this, tr("HTTP"),
//                                 tr("Download failed: %1.")
//                                 .arg(reply->errorString()));
    } else if (!redirectionTarget.isNull()) {
        QUrl newUrl = url.resolved(redirectionTarget.toUrl());
//        if (QMessageBox::question(this, tr("HTTP"),
//                                  tr("Redirect to %1 ?").arg(newUrl.toString()),
//                                  QMessageBox::Yes | QMessageBox::No) == QMessageBox::Yes)
        {
            url = newUrl;
            reply->deleteLater();
            file->open(QIODevice::WriteOnly);
            file->resize(0);
            startRequest(url);
            return;
        }
    } else {
//        QString fileName = QFileInfo(QUrl(urlLineEdit->text()).path()).fileName();
//        statusLabel->setText(tr("Downloaded %1 to %2.").arg(fileName).arg(QDir::currentPath()));
//        downloadButton->setEnabled(true);
    }

    reply->deleteLater();
    reply = 0;
    delete file;
    file = 0;
}

void MyApp::httpReadyRead()
{
    // this slot gets called every time the QNetworkReply has new data.
    // We read all of its new data and write it into the file.
    // That way we use less RAM than when reading it at the finished()
    // signal of the QNetworkReply
    if (file)
        file->write(reply->readAll());
}

int main(int argc, char *argv[])
{
    MyApp a(argc, argv);

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

