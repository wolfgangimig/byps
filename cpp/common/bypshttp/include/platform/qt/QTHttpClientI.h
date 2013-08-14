#ifndef QTHTTPCLIENTI_H
#define QTHTTPCLIENTI_H

#include "Byps.h"
#include "Bypshttp.h"


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

class QTHttpRequestBridge : public QObject
{
    Q_OBJECT

public:
    QTHttpRequestBridge();
    virtual ~QTHttpRequestBridge() ;
    void close();

    void create(PQTHttpRequest pThis, QNetworkReply* reply);

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


class QTHttpClientCmd {
    byps_mutex mutex;
    byps_condition_variable ready;
    PQTHttpRequest request;
    BException ex;
public:
    const PQTHttpClient httpClient;

    enum Type { done,
                createHttpGet,
                createHttpPost,
                createHttpPut,
                sendHttpGet,
                sendHttpPost,
                sendHttpPut
              };
    const Type type;

    const std::wstring url;

    QTHttpClientCmd(PQTHttpClient httpClient, Type type, const std::wstring& url);
    QTHttpClientCmd(PQTHttpClient httpClient, Type type, PQTHttpRequest request);

    PQTHttpRequest getRequestAndDeleteThis();
    PQTHttpRequest getRequest();

    void setRequestAndNotify(PQTHttpRequest request);
    void setExceptionAndNotify(BException ex);

    void maybeDeleteAfterExec();
};


typedef byps_ptr<QNetworkAccessManager> PNetworkAccessManager;

class QTHttpClientWorker : public QThread {
    Q_OBJECT
    PNetworkAccessManager networkManager;
    bool isEventQueueRunning;
    byps_mutex mutex;
    byps_condition_variable running;

    static QNetworkRequest urlToNetworkRequest(const std::wstring& surl);

public:
    QTHttpClientWorker();
    virtual void run();

    void executeCommand(QTHttpClientCmd* cmd);
    void done();
    void waitForRunning(); // throws BException

private slots:
    void executeCommandSlot(QTHttpClientCmd* cmd);
    void onStarted();

signals:
    void executeCommandSignal(QTHttpClientCmd* cmd);


};




}}}}}

#endif // QTHTTPCLIENTI_H
