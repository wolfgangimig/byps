/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef QTHTTPCLIENTI_H
#define QTHTTPCLIENTI_H

#include "Byps.h"
#include "Bypshttp.h"
#include "BLogger.h"

namespace byps { namespace http { namespace qthttp {

using namespace byps;

class QTHttpRequest;
typedef byps_ptr<QTHttpRequest> PQTHttpRequest;

class QTHttpGet;
typedef byps_ptr<QTHttpGet> PQTHttpGet;

class QTHttpGetStream;
typedef byps_ptr<QTHttpGetStream> PQTHttpGetStream;

class QTHttpPost;
typedef byps_ptr<QTHttpPost> PQTHttpPost;

class QTHttpPutStream;
typedef byps_ptr<QTHttpPutStream> PQTHttpPutStream;

class QTHttpClient;
typedef byps_ptr<QTHttpClient> PQTHttpClient;

typedef byps_ptr<QNetworkAccessManager> PNetworkAccessManager;

class QTHttpRequestBridge : public QObject
{
    Q_OBJECT
    static BLogger log;

public:
    QTHttpRequestBridge(QNetworkReply* reply, int32_t timeoutSeconds);
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
    void createPutStreamRequest(QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamIO, QTHttpRequestBridge**);
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
    void createPutStreamRequest(QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamIO, QTHttpRequestBridge**);

};

class QTPutStreamIODevice : public QIODevice
{
    PContentStream strm;
    Q_OBJECT

public:
    QTPutStreamIODevice(PContentStream strm, QObject* parent = 0);
    virtual ~QTPutStreamIODevice();

    bool open(OpenMode mode);
    void close();
    bool isSequential() const;
    virtual qint64 size() const;
    virtual qint64 bytesAvailable() const;

protected:
    virtual qint64 readData(char* data, qint64 maxSize);
    virtual qint64 writeData(const char* , qint64 );

private:
    Q_DISABLE_COPY(QTPutStreamIODevice)
};


}}}

#endif // QTHTTPCLIENTI_H
