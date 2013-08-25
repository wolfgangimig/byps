#ifndef QTHTTPCLIENTI_H
#define QTHTTPCLIENTI_H

#include "Byps.h"
#include "Bypshttp.h"
#include "BLogger.h"

namespace com { namespace wilutions { namespace byps { namespace http { namespace qthttp {

using namespace com::wilutions::byps;

class QTHttpRequest;
typedef byps_ptr<QTHttpRequest> PQTHttpRequest;

class QTHttpGet;
typedef byps_ptr<QTHttpGet> PQTHttpGet;

class QTHttpPost;
typedef byps_ptr<QTHttpPost> PQTHttpPost;

class QTHttpPut;
typedef byps_ptr<QTHttpPut> PQTHttpPut;

class QTHttpClient;
typedef byps_ptr<QTHttpClient> PQTHttpClient;

typedef byps_ptr<QNetworkAccessManager> PNetworkAccessManager;

class QTHttpRequestBridge : public QObject
{
    Q_OBJECT
    static BLogger log;

public:
    QTHttpRequestBridge(QNetworkReply* reply, int32_t timeout);
    virtual ~QTHttpRequestBridge() ;
    void done();

private slots:
    void httpFinished();
    void httpReadyRead();
    void httpTimeout();
    void httpError(QNetworkReply::NetworkError);

public:
    PQTHttpRequest pThis;
    QNetworkReply *reply;
    QTimer timer;

};

class QTHttpWorkerBridge : public QObject
{
    Q_OBJECT
    static BLogger log;

public:
    PNetworkAccessManager networkManager;

    QTHttpWorkerBridge();

public slots:
    void createGetRequest(QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge**);
    void createPostRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPost, QTHttpRequestBridge**);
    void createPutRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* streamToPut, QTHttpRequestBridge**);
};

class QTHttpWorkerThread : public QThread
{
    Q_OBJECT
    static BLogger log;

public:
    QTHttpWorkerBridge* workerBridge;

    QTHttpWorkerThread();
    virtual ~QTHttpWorkerThread();

protected:
    virtual void run();
};

class QTHttpClientBridge : public QObject
{
    Q_OBJECT

public:

signals:
    void createGetRequest(QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge**);
    void createPostRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPost, QTHttpRequestBridge**);
    void createPutRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPut, QTHttpRequestBridge**);

};

}}}}}

#endif // QTHTTPCLIENTI_H
