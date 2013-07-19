#ifndef HWIRECLIENT_H
#define HWIRECLIENT_H

#include "BWire.h"
#include <random>
#include <QNetworkAccessManager>
#include <QUrl>

namespace com { namespace wilutions { namespace byps { namespace http {

class HWireClient_RequestsToCancel;
typedef byps_ptr<HWireClient_RequestsToCancel> PWireClient_RequestsToCancel;

class HWireClient :  public BWire, public std::enable_shared_from_this<HWireClient> {
public:
    const std::wstring url;

    static PWire create(const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool);

    virtual ~HWireClient();

    virtual void send(const PMessage& bytes, PAsyncResult asyncResult);

    virtual void sendR(const PMessage& msg, PAsyncResult asyncResult);

    virtual PContentStream getStream(int64_t messageId, int64_t streamId);

    virtual int64_t makeMessageId();

    virtual void done();

    virtual void cancelAllRequests();

    virtual PTestAdapter getTestAdapter();

protected:

    HWireClient(const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool);

    void init();

    QNetworkAccessManager netwManager;

    PWireClient_RequestsToCancel requestsToCancel;

    BException lastException;
    std::wstring urlPath;
    int32_t urlFlags;
    int64_t timeoutMillisClient;
    PThreadPool tpool;
    bool isMyThreadPool;
    byps_atomic<bool> isDone;

    std::mt19937_64 rand;

    void internalCancelAllRequests(int64_t cancelMessageId, PAsyncResult asyncResult);

    void internalSend(const PMessage& msg, PAsyncResult asyncResult, int64_t timeoutMillis);

    friend class HWireClient_TestAdapter;
};

}}}}

#endif // HWIRECLIENT_H
