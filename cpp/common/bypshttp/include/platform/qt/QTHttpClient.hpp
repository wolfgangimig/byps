#ifndef QTHTTPCLIENT_HPP
#define QTHTTPCLIENT_HPP


#include "QTHttpClient.h"
#include "QTHttpClientI.h"

namespace com { namespace wilutions { namespace byps { namespace http { namespace qthttp {

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;

typedef byps_ptr<QNetworkAccessManager> PNetworkAccessManager;

/**
 * @brief The QIODevice_PBytes class
 */
class QIODevice_PBytes : public QIODevice {
    PBytes bytes;
    qint64 pos;

public:
    QIODevice_PBytes(PBytes bytes)
        : bytes(bytes), pos(0) {
    }

    QIODevice_PBytes()
        : pos(0) {

    }

    virtual bool isSequential() const{
        return true;
    }

    virtual bool reset() {
        pos = 0;
        return true;
    }

    virtual qint64 size() const {
        return (qint64)bytes->length;
    }

    virtual qint64 readData(char *data, qint64 maxlen) {
        qint64 ret = -1LL;
        qint64 length = (qint64)bytes->length;

        if (pos < length) {
            ret = std::min(maxlen, length-pos);
            memcpy(data, bytes->data + pos, ret);
            pos += ret;
        }
        else if (pos == length) {
            pos++;
            ret = 0;
        }

        return ret;
    }

    virtual qint64 writeData(const char *data, qint64 maxlen) {
        qint64 ret = -1LL;
        qint64 length = (qint64)bytes->length;

        if (pos < length) {
            ret = std::min(maxlen, length-pos);
            memcpy(bytes->data + pos, data, ret);
            pos += ret;
        }
        else if (pos == length) {
            pos++;
            ret = 0;
        }

        return ret;
    }
};

class QIODevice_PContentStream : public QIODevice {
    PContentStream strm;

public:
    QIODevice_PContentStream(PContentStream strm)
        : strm(strm) {
    }

    QIODevice_PContentStream()
    {

    }

    virtual bool isSequential() const{
        return true;
    }

    virtual bool reset() {
        return false;
    }

    virtual qint64 size() const {
        int64_t contentLength = strm->getContentLength();
        return (qint64)(contentLength >= 0 ? contentLength : 1);
    }

    virtual qint64 readData(char *data, qint64 maxlen) {
        int32_t len = (int32_t)std::min(maxlen, 0x7FFFFFFFLL);
        qint64 cb = strm->read(data, 0, len);
        return cb;
    }

    virtual qint64 writeData(const char *, qint64 ) {
        return -1LL;
    }
};

class QTHttpClient;
typedef byps_ptr<QTHttpClient> PQTHttpClient;

class QTHttpRequest : public virtual HHttpRequest, public byps_enable_shared_from_this<QTHttpRequest> {
protected:
    PQTHttpClient httpClient;
    PNetworkAccessManager networkManager;
    QNetworkRequest networkRequest;
    QTHttpRequestBridge* bridge;
    bool cancelled;
    int32_t timeoutSeconds;

public:
    QTHttpRequest(PQTHttpClient httpClient, PNetworkAccessManager networkManager, QNetworkRequest networkRequest)
        : httpClient(httpClient)
        , networkManager(networkManager)
        , networkRequest(networkRequest)
        , bridge(NULL)
        , cancelled(false)
        , timeoutSeconds(0)
    {

    }

    ~QTHttpRequest() {
        if (bridge) delete bridge;
    }

    virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) {
        timeoutSeconds = std::max(connectTimeoutSeconds, sendrecvTimeoutSeconds);
    }

    int32_t getTimeoutSeconds() {
        return timeoutSeconds;
    }

    virtual void close() {
        if (!cancelled) {
            cancelled = true;
            if (bridge) {
                bridge->reply->abort();
            }
        }
        if (bridge) {
            bridge->close();
        }
    }

    virtual void httpFinished() {

    }

    virtual void httpReadyRead() {

    }

    virtual void httpTimeout() {
        close();
    }

    QTHttpRequestBridge* getBridge() {
        return bridge;
    }

    QNetworkRequest getNetworkRequest() {
        return networkRequest;
    }

    virtual QIODevice* getDataToSend() {
        return NULL;
    }

};

class QTHttpGet_ContentStream : public BContentStream {
    byps_condition_variable waitRead;
    byps_condition_variable waitWrite;
    byps_condition_variable waitHeaders;
    byps_mutex mutex;
    QByteArray bytes;
    bool finished;
    int32_t readPos;
    int32_t readLimit;
    std::wstring contentType;
    int64_t contentLength;
    bool headersAvail;
    std::chrono::milliseconds timeout;
    BException ex;
public:
    QTHttpGet_ContentStream(int32_t timeoutSeconds)
        : readPos(0)
        , readLimit(0)
        , contentLength(0)
        , headersAvail(false)
        , timeout(timeoutSeconds * 1000) {
    }

    virtual ~QTHttpGet_ContentStream() {
    }

    bool putBytes(QByteArray nbytes) {
        byps_unique_lock lock(this->mutex);
        while (readPos != readLimit) {
            if (waitWrite.wait_for(lock, timeout) == std::cv_status::timeout) {
                return false;
            }
        }
        bytes = nbytes;
        readPos = 0;
        readLimit = nbytes.size();
        waitRead.notify_one();
        return true;
    }

    void writeClose() {
        byps_unique_lock lock(this->mutex);
        this->finished = true;
        waitRead.notify_one();
    }

    void writeCancel() {
        byps_unique_lock lock(this->mutex);
        ex = BException(EX_CANCELLED);
        waitRead.notify_one();
    }

    void writeTimeout() {
        byps_unique_lock lock(this->mutex);
        ex = BException(EX_TIMEOUT);
        waitRead.notify_one();
    }

    void applyHeaders(const std::wstring& contentType, int64_t contentLength) {
        byps_unique_lock lock(this->mutex);
        this->contentType = contentType;
        this->contentLength = contentLength;
        waitHeaders.notify_one();
    }

    virtual const std::wstring& getContentType() const {
        QTHttpGet_ContentStream* pThis = const_cast<QTHttpGet_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                pThis->ex = BException(EX_TIMEOUT);
            }
        }
        if (ex) throw ex;
        return contentType;
    }

    virtual int64_t getContentLength() const {
        QTHttpGet_ContentStream* pThis = const_cast<QTHttpGet_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                pThis->ex = BException(EX_TIMEOUT);
            }
        }
        if (ex) throw ex;
        return contentLength;
    }

    virtual int32_t read(char* buf, int32_t offs, int32_t len) {
        byps_unique_lock lock(this->mutex);

        while (!ex && !finished && readPos == readLimit) {
            if (waitRead.wait_for(lock, timeout) == std::cv_status::timeout) {
                ex = BException(EX_TIMEOUT);
            }
        }

        if (ex) throw ex;

        if (finished && readPos == readLimit) {
            return -1;
        }

        int32_t max = std::min(len, readLimit-readPos);
        memcpy(buf + offs, bytes.data() + readPos, (size_t)max);

        readPos += max;
        if (readPos == readLimit) {
            waitWrite.notify_one();
        }

        return max;
    }

};

class QTHttpClient : public HHttpClient, public byps_enable_shared_from_this<QTHttpClient> {

public:
    QTHttpClientWorker workerThread;

    QTHttpClient()
    {
    }

    virtual ~QTHttpClient() {
        workerThread.done();
        workerThread.wait();
    }

    virtual void init(const std::wstring& ) {
        workerThread.start();
    }

    virtual PHttpGet get(const std::wstring& url) {
        QTHttpClientCmd* cmd = new QTHttpClientCmd(shared_from_this(), QTHttpClientCmd::createHttpGet, url);
        workerThread.executeCommand(cmd);
        return byps_ptr_cast<HHttpGet>(cmd->getRequestAndDeleteThis());
    }

    virtual PHttpPost post(const std::wstring& url) {
        QTHttpClientCmd* cmd = new QTHttpClientCmd(shared_from_this(), QTHttpClientCmd::createHttpPost, url);
        workerThread.executeCommand(cmd);
        return byps_ptr_cast<HHttpPost>(cmd->getRequestAndDeleteThis());
    }

    virtual PHttpPut put(const std::wstring& url) {
        QTHttpClientCmd* cmd = new QTHttpClientCmd(shared_from_this(), QTHttpClientCmd::createHttpPut, url);
        workerThread.executeCommand(cmd);
        return byps_ptr_cast<HHttpPut>(cmd->getRequestAndDeleteThis());
    }

};


class QTHttpGet : public HHttpGet, public virtual QTHttpRequest {

    byps_weak_ptr<QTHttpGet_ContentStream> stream_weak_ptr;
    bool headersApplied;


public:
    QTHttpGet(PQTHttpClient httpClient, PNetworkAccessManager networkManager, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkManager, networkRequest)
        , headersApplied(false)
    {
    }

    virtual ~QTHttpGet() {
    }

    virtual PContentStream send() {
        byps_ptr<QTHttpGet_ContentStream> ret(new QTHttpGet_ContentStream(timeoutSeconds));
        this->stream_weak_ptr = ret;
        QTHttpClientCmd* cmd = new QTHttpClientCmd(httpClient, QTHttpClientCmd::sendHttpGet, shared_from_this());
        httpClient->workerThread.executeCommand(cmd);
        return ret;
    }

    byps_ptr<QTHttpGet_ContentStream> getStreamOrAbort() {
        byps_ptr<QTHttpGet_ContentStream> stream = stream_weak_ptr.lock();
        if (!stream) {
            QTHttpRequest::close();
        }
        return stream;
    }

    virtual void httpFinished() {
        if (!cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                stream->writeClose();
            }
        }
        QTHttpRequest::httpFinished();
    }

    virtual void httpReadyRead() {
        if (!cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                if (!headersApplied) {
                    headersApplied = true;

                    QByteArray headerValue = bridge->reply->rawHeader("Content-Type");
                    std::wstring contentType = BToStdWString(headerValue.data());

                    headerValue = bridge->reply->rawHeader("Content-Length");
                    int64_t contentLength = QString(headerValue).toLongLong();

                    stream->applyHeaders(contentType, contentLength);
                }
                stream->putBytes(bridge->reply->readAll());
            }
        }
    }

    virtual void httpTimeout() {
        QTHttpRequest::httpTimeout();
        if (cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                stream->writeTimeout();
            }
            cancelled = true;
        }
    }

    virtual void close() {
        QTHttpRequest::close();
        if (cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = stream_weak_ptr.lock();
            if (stream) {
                stream->writeCancel();
            }
        }
    }

};


class QTHttpPost : public HHttpPost, public virtual QTHttpRequest {
    QIODevice_PBytes* bytesToPost;
    PAsyncResult asyncBytesReceived;
    PBytes respBytes;
    size_t pos;
    friend class QTHttpPostWorker;
public:

    QTHttpPost(PQTHttpClient httpClient, PNetworkAccessManager networkManager, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkManager, networkRequest)
        , bytesToPost(NULL)
        , asyncBytesReceived(NULL)
        , respBytes(BBytes::create(10 * 1000))
        , pos(0)
    {
    }

    virtual ~QTHttpPost() {
        if (bytesToPost) delete bytesToPost;
    }

    virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) {
        this->bytesToPost = new QIODevice_PBytes(bytes);
        this->asyncBytesReceived = asyncBytesReceived;

        networkRequest.setRawHeader("Content-Type", QString::fromStdWString(contentType).toUtf8());
        networkRequest.setRawHeader("Content-Length", QString::number(bytes->length).toUtf8());

        QTHttpClientCmd* cmd = new QTHttpClientCmd(httpClient, QTHttpClientCmd::sendHttpPost, shared_from_this());
        httpClient->workerThread.executeCommand(cmd);
    }

    virtual void httpFinished() {
        if (asyncBytesReceived) {
            respBytes->length = pos;
            asyncBytesReceived->setAsyncResult(BVariant(respBytes));
            asyncBytesReceived = NULL;
            respBytes.reset();
        }

        QTHttpRequest::httpFinished();
    }

    virtual void httpReadyRead() {
        if (asyncBytesReceived) {

            QByteArray bytes = bridge->reply->readAll();

            if (pos + bytes.size() > respBytes->length) {
                size_t ncapacity = respBytes->length + std::min(respBytes->length, (size_t)1000000);
                respBytes = BBytes::create(respBytes, ncapacity);
            }

            memcpy(respBytes->data + pos, bytes.data(), bytes.size());
            pos += bytes.size();
        }
    }

    virtual void httpTimeout() {
        if (asyncBytesReceived) {
            asyncBytesReceived->setAsyncResult(BVariant(EX_TIMEOUT));
            asyncBytesReceived = NULL;
        }
    }

    virtual void close() {
        QTHttpRequest::close();
        if (asyncBytesReceived) {
            asyncBytesReceived->setAsyncResult(BVariant(EX_CANCELLED));
            asyncBytesReceived = NULL;
        }
    }

    virtual QIODevice* getDataToSend() {
        return bytesToPost;
    }
};

class QTHttpPut : public HHttpPut, public virtual QTHttpRequest {
    QIODevice_PContentStream* streamToPut;
    PAsyncResult asyncBoolFinished;
    friend class QTHttpPutWorker;
public:
    QTHttpPut(PQTHttpClient httpClient, PNetworkAccessManager networkManager, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkManager, networkRequest)
        , streamToPut(NULL)
        , asyncBoolFinished(NULL)
    {

    }

    virtual ~QTHttpPut() {
        if (streamToPut) delete streamToPut;
    }

    virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) {

        int64_t contentLength = strm->getContentLength();
        if (contentLength >= 0) {

            this->asyncBoolFinished = asyncBoolFinished;

            streamToPut = new QIODevice_PContentStream(strm);

            networkRequest.setRawHeader("Content-Type", QString::fromStdWString(strm->getContentType()).toUtf8());
            networkRequest.setRawHeader("Content-Length", QString::number(contentLength).toUtf8());

            QTHttpClientCmd* cmd = new QTHttpClientCmd(httpClient, QTHttpClientCmd::sendHttpPut, shared_from_this());
            httpClient->workerThread.executeCommand(cmd);

        }
        else {

            asyncBoolFinished->setAsyncResult(BVariant(
                BException(EX_IOERROR, L"QT does not support chunked encoding. BContentStream must provide a content length."))
            );
        }
    }

    virtual void httpFinished() {
        if (asyncBoolFinished) {
            asyncBoolFinished->setAsyncResult(BVariant(true));
            asyncBoolFinished = NULL;
        }
        QTHttpRequest::httpFinished();
    }

    virtual void httpReadyRead() {
        bridge->reply->readAll();
    }

    virtual void httpTimeout() {
        if (asyncBoolFinished) {
            asyncBoolFinished->setAsyncResult(BVariant(EX_TIMEOUT));
            asyncBoolFinished = NULL;
        }
    }

    virtual void close() {
        QTHttpRequest::close();
        if (asyncBoolFinished) {
            asyncBoolFinished->setAsyncResult(BVariant(EX_CANCELLED));
            asyncBoolFinished = NULL;
        }
    }

    virtual QIODevice* getDataToSend() {
        return streamToPut;
    }
};




BINLINE QTHttpRequestBridge::QTHttpRequestBridge() : reply(NULL)
{
    timer.setSingleShot(true);
}

BINLINE QTHttpRequestBridge::~QTHttpRequestBridge() {

}

BINLINE void QTHttpRequestBridge::create(PQTHttpRequest pThis, QNetworkReply* reply) {

    this->pThis = pThis;
    this->reply = reply;

    QObject::connect(reply, SIGNAL(finished()),
                     this, SLOT(httpFinished()));
    QObject::connect(reply, SIGNAL(readyRead()),
                     this, SLOT(httpReadyRead()));
    QObject::connect(reply, SIGNAL(error(QNetworkReply::NetworkError)),
                     this, SLOT(httpError(QNetworkReply::NetworkError)));

    int32_t timeout = pThis->getTimeoutSeconds();
    if (timeout) {

        QObject::connect(&timer, SIGNAL(timeout()),
                this, SLOT(httpTimeout()));

        timer.start(timeout * 1000);
    }
}

BINLINE void QTHttpRequestBridge::httpFinished() {
    timer.stop();
    pThis->httpFinished();
    pThis.reset();
}

BINLINE void QTHttpRequestBridge::httpReadyRead() {
    int32_t timeout = pThis->getTimeoutSeconds();
    if (timeout) {
        timer.stop();
        timer.start();
    }
    pThis->httpReadyRead();
}

BINLINE void QTHttpRequestBridge::httpTimeout() {
    timer.stop();
    pThis->httpTimeout();
}

BINLINE void QTHttpRequestBridge::httpError(QNetworkReply::NetworkError) {
    timer.stop();
}

BINLINE void QTHttpRequestBridge::close() {
    pThis.reset();
}




BINLINE QTHttpClientCmd::QTHttpClientCmd(PQTHttpClient httpClient, Type type, const std::wstring& url)
    : httpClient(httpClient), type(type), url(url) {
}

BINLINE QTHttpClientCmd::QTHttpClientCmd(PQTHttpClient httpClient, Type type, PQTHttpRequest request)
    : request(request), httpClient(httpClient), type(type) {
}

BINLINE PQTHttpRequest QTHttpClientCmd::getRequestAndDeleteThis() {
    PQTHttpRequest ret;
    BException rex;

    {
        byps_unique_lock lock(mutex);
        while (!request && !ex) {
            std::chrono::milliseconds timeoutMillis(10 * 1000);
            if (ready.wait_for(lock, timeoutMillis) == std::cv_status::timeout) {
                ex = BException(EX_TIMEOUT, L"Cannot create HTTP command.");
                break;
            }
        }
        rex = ex;
        ret = request;
    }

    delete this;

    if (rex) throw rex;
    return ret;
}

BINLINE void QTHttpClientCmd::setRequestAndNotify(PQTHttpRequest request) {
    byps_unique_lock lock(mutex);
    this->request = request;
    ready.notify_one();
}

BINLINE void QTHttpClientCmd::setExceptionAndNotify(BException ex) {
    byps_unique_lock lock(mutex);
    this->ex = ex;
    ready.notify_one();
}

BINLINE PQTHttpRequest QTHttpClientCmd::getRequest() {
    return request;
}

BINLINE void QTHttpClientCmd::maybeDeleteAfterExec() {
    switch(type) {
    case QTHttpClientCmd::createHttpGet:
    case QTHttpClientCmd::createHttpPost:
    case QTHttpClientCmd::createHttpPut:
        break;
    default:
        delete this;
        break;
    }
}


BINLINE QTHttpClientWorker::QTHttpClientWorker() : isEventQueueRunning(false) {
}

BINLINE void QTHttpClientWorker::run() {
    networkManager = PNetworkAccessManager(new QNetworkAccessManager());

    QObject::connect(this, SIGNAL(started()),
                     this, SLOT(onStarted()));

    QObject::connect(this, SIGNAL(executeCommandSignal(QTHttpClientCmd*)),
                     this, SLOT(executeCommandSlot(QTHttpClientCmd*)));

    exec();
}

BINLINE void QTHttpClientWorker::waitForRunning() {
    byps_unique_lock lock(mutex);
    while (!isEventQueueRunning) {
        std::chrono::milliseconds timeout(10 *1000);
        if (running.wait_for(lock, timeout) == std::cv_status::timeout) {
            throw BException(EX_TIMEOUT, L"Cannot create worker thread.");
        }
    }
}

BINLINE void QTHttpClientWorker::onStarted() {
    byps_unique_lock lock(mutex);
    isEventQueueRunning = true;
    running.notify_all();
}

BINLINE void QTHttpClientWorker::executeCommand(QTHttpClientCmd* cmd) {
    waitForRunning();
    emit executeCommandSignal(cmd);
}

BINLINE void QTHttpClientWorker::executeCommandSlot(QTHttpClientCmd* cmd) {

    switch(cmd->type) {
    case QTHttpClientCmd::done:
        quit();
        break;

    case QTHttpClientCmd::createHttpGet:
        cmd->setRequestAndNotify(
            PQTHttpRequest(new QTHttpGet(cmd->httpClient, networkManager, urlToNetworkRequest(cmd->url)))
        );
        break;
    case QTHttpClientCmd::createHttpPost:
        cmd->setRequestAndNotify(
            PQTHttpRequest(new QTHttpPost(cmd->httpClient, networkManager, urlToNetworkRequest(cmd->url)))
        );
        break;
    case QTHttpClientCmd::createHttpPut:
        cmd->setRequestAndNotify(
            PQTHttpRequest(new QTHttpPut(cmd->httpClient, networkManager, urlToNetworkRequest(cmd->url)))
        );
        break;

    case QTHttpClientCmd::sendHttpGet:
    {
        PQTHttpRequest request = cmd->getRequest();
        QNetworkRequest networkRequest = request->getNetworkRequest();
        QNetworkReply* reply = networkManager->get(networkRequest);
        request->getBridge()->create(request, reply);
        break;
    }

    case QTHttpClientCmd::sendHttpPost:
    {
        PQTHttpRequest request = cmd->getRequest();
        QNetworkRequest networkRequest = request->getNetworkRequest();
        QIODevice* data = request->getDataToSend();
        QNetworkReply* reply = networkManager->post(networkRequest, data);
        request->getBridge()->create(request, reply);
        break;
    }

    case QTHttpClientCmd::sendHttpPut:
    {
        PQTHttpRequest request = cmd->getRequest();
        QNetworkRequest networkRequest = request->getNetworkRequest();
        QIODevice* data = request->getDataToSend();
        QNetworkReply* reply = networkManager->put(networkRequest, data);
        request->getBridge()->create(request, reply);
        break;
    }


    }

    cmd->maybeDeleteAfterExec();
}

BINLINE void QTHttpClientWorker::done() {
    QTHttpClientCmd* cmd = new QTHttpClientCmd(PQTHttpClient(), QTHttpClientCmd::done, L"");
    emit executeCommandSignal(cmd);
}

BINLINE QNetworkRequest QTHttpClientWorker::urlToNetworkRequest(const std::wstring& surl) {
    return QNetworkRequest(QUrl(QString::fromStdWString(surl)));
}


}}}}}


namespace com { namespace wilutions { namespace byps { namespace http {

BINLINE PHttpClient HttpClient_create() {
    return PHttpClient(new com::wilutions::byps::http::qthttp::QTHttpClient());
}

}}}}

#endif // QTHTTPCLIENT_HPP
