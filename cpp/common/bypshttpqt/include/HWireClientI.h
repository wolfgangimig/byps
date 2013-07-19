#ifndef HWIRECLIENTI_H
#define HWIRECLIENTI_H

#include "HWireClient.h"
#include <QtNetwork>

namespace com { namespace wilutions { namespace byps { namespace http {

class HWireClient_AsyncResultAfterAllRequests;
class HWireClient_RequestToCancel;
class HWireClient_RequestsToCancel;
typedef byps_ptr<HWireClient_RequestToCancel> PWireClient_RequestToCancel;
typedef byps_ptr<HWireClient_RequestsToCancel> PWireClient_RequestsToCancel;

class QIODevice_PBytes : public QIODevice {
    PBytes bytes;
    qint64 pos;

public:
    QIODevice_PBytes(PBytes bytes);

    QIODevice_PBytes();

    PBytes getBytes();

    virtual bool isSequential() const;

    virtual bool reset();

    virtual qint64 size() const;

    virtual qint64 readData(char *data, qint64 maxlen);

    virtual qint64 writeData(const char *data, qint64 len);

};

class HWireClient_RequestsToCancel {
public:

    HWireClient_RequestsToCancel(QNetworkAccessManager* netwManager);

    virtual ~HWireClient_RequestsToCancel();
    bool add(intptr_t id, PWireClient_RequestToCancel r);
    void addCancelMessage(intptr_t id, PWireClient_RequestToCancel r);
    void remove(intptr_t id);
    void cancel();

    QNetworkAccessManager* getNetworkManager();

private:

    QNetworkAccessManager* netwManager;
    bool isCanceled;
    byps_mutex mutex;
    std::map<intptr_t, PWireClient_RequestToCancel> map;
};

class HWireClient_RequestToCancel : public QObject {
    Q_OBJECT

public:
    const intptr_t id;

    HWireClient_RequestToCancel(
    const std::wstring& urlPath,
            int32_t urlFlags,
            int64_t timeoutMillisClient,
            int64_t timeoutMillisRequest,
            PWireClient_RequestsToCancel requestsToCancel,
            PAsyncResult asyncResult);

    virtual void send() = 0;

    virtual void cancel();

    virtual void close();

    bool isCanceled();

    PWireClient_RequestsToCancel requestsToCancel;
    PAsyncResult asyncResult;

protected:
    QUrl url;
    int32_t urlFlags;
    int64_t timeoutMillisClient;
    int64_t timeoutMillisRequest;

    DWORD statusCode;
    std::wstring contentType;
    int64_t contentLength;

    QNetworkReply *reply;

    void get();
    void post(QIODevice* postData);
    void put(QIODevice* postData);

    virtual void onReadComplete();
    virtual void finishOnError(const BException& ex);
    virtual void finishOnOK();

    void httpFinished();
    void httpReadyRead();
    void connectEvents();
};


class HWireClient_SendMessage : public HWireClient_RequestToCancel {
public:
    HWireClient_SendMessage(
        const std::wstring& urlPath,
        int32_t urlFlags,
        int64_t timeoutMillisClient,
        int64_t timeoutMillisRequest,
        PWireClient_RequestsToCancel requestsToCancel,
        PAsyncResult asyncResult,
        int64_t messageId,
        PBytes bytes);
    virtual ~HWireClient_SendMessage();

    virtual void send();

protected:
    const int64_t messageId;
    QIODevice_PBytes* requestData;
    QIODevice_PBytes* responseData;

    virtual void onReadComplete();
    virtual void finishOnOK();
};

}}}}

#endif // HWIRECLIENTI_H
