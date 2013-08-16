#ifndef MAIN_H
#define MAIN_H

#include <QObject>
#include "Bypshttp.h"

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;

class Task : public QObject
{
    Q_OBJECT

public:
    Task(QObject *parent = 0) : QObject(parent) {}

public slots:
    void run();

signals:
    void finished();
};


class MyApp : public QCoreApplication {
    Q_OBJECT
public:
    MyApp(int argc, char *argv[]);

    void downloadFile();

private slots:
    void httpFinished();
    void httpReadyRead();
    //void metaDataChanged();
    //void encrypted();
    void httpError(QNetworkReply::NetworkError);
    //void updateDataReadProgress(qint64 bytesRead, qint64 totalBytes);

    void nm_networkSessionConnected();
//    void nm_networkAccessibleChanged(QNetworkAccessManager::NetworkAccessibility accessible);
//    void nm_authenticationRequired(QNetworkReply*,QAuthenticator *);
//    void nm_sslErrors(QNetworkReply*,const QList<QSslError> &errors);

private:
    void startRequest(QUrl url);

    QUrl url;
    QNetworkAccessManager qnam;
    QNetworkReply *reply;
    QFile *file;
    int httpGetId;
    bool httpRequestAborted;

};

#endif // MAIN_H
