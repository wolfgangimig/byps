#ifndef QTHTTPCLIENT_HPP
#define QTHTTPCLIENT_HPP


#include "QTHttpClient.h"
#include "QTHttpClientI.h"


namespace com { namespace wilutions { namespace byps { namespace http { namespace qthttp {

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;


/**
 * @brief The QIODevice_PBytes class
 */
class QIODevice_PBytes : public QIODevice {
    BLogger log;
    PBytes bytes;
    qint64 offs;
public:
    QIODevice_PBytes(PBytes bytes)
        : log("QIODevice_PBytes"), bytes(bytes), offs(0) {
    }

    QIODevice_PBytes()
        : log("QIODevice_PBytes"), offs(0) {

    }

    virtual bool isSequential() const{
        l_debug << L"isSequential()=true";
        return true;
    }

    virtual bool reset() {
        offs = 0;
        l_debug << L"reset()=true";
        return true;
    }

    virtual qint64 pos() const {
        l_debug << L"pos()=" << offs;
        return offs;
    }

    virtual qint64 size() const {
        l_debug << L"size()=" << bytes->length;
        return (qint64)bytes->length;
    }

    virtual bool atEnd() const {
        bool ret = offs == (qint64)bytes->length;
        l_debug << L"atEnd()=" << ret;
        return ret;
    }

    virtual qint64 bytesAvailable() const {
        qint64 ret = bytes->length - offs;
        l_debug << L"bytesAvailable()=" << ret;
        return ret;
    }

    virtual qint64 readData(char *data, qint64 maxlen) {
        l_debug << L"readData(maxlen=" << maxlen;
        qint64 ret = -1LL;
        qint64 length = (qint64)bytes->length;

        if (offs < length) {
            ret = std::min(maxlen, length-offs);
            memcpy(data, bytes->data + offs, ret);
            offs += ret;
        }
        else if (offs == length) {
            offs++;
            ret = 0;
        }

        l_debug << L")readData=" << ret;
        return ret;
    }

    virtual qint64 writeData(const char *data, qint64 maxlen) {
        l_debug << L"writeData(maxlen=" << maxlen;
        qint64 ret = -1LL;
        qint64 length = (qint64)bytes->length;

        if (offs < length) {
            ret = std::min(maxlen, length-offs);
            memcpy(bytes->data + offs, data, ret);
            offs += ret;
        }
        else if (offs == length) {
            offs++;
            ret = 0;
        }

        l_debug << L")writeData=" << ret;
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
    BLogger log;
public:
    QTHttpGet_ContentStream(int32_t timeoutSeconds)
        : readPos(0)
        , readLimit(0)
        , contentLength(0)
        , headersAvail(false)
        , timeout(timeoutSeconds * 1000)
        , log("QTHttpGet_ContentStream")
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpGet_ContentStream() {
        l_debug << L"dtor()";
    }

    bool putBytes(QByteArray nbytes) {
        l_debug << L"putBytes(#bytes=" << nbytes.size();
        byps_unique_lock lock(this->mutex);
        while (readPos != readLimit) {
            l_debug << L"wait for write";
            if (waitWrite.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L")putBytes=false timeout";
                return false;
            }
        }

        l_debug << L"write and notify";
        bytes = nbytes;
        readPos = 0;
        readLimit = nbytes.size();
        waitRead.notify_one();
        l_debug << L")putBytes=true";
        return true;
    }

    void writeClose() {
        l_debug << L"writeClose(";
        byps_unique_lock lock(this->mutex);
        this->finished = true;
        waitRead.notify_one();
        l_debug << L")writeClose";
    }

    void writeCancel() {
        l_debug << L"writeCancel(";
        byps_unique_lock lock(this->mutex);
        ex = BException(EX_CANCELLED);
        waitRead.notify_one();
        l_debug << L")writeCancel";
    }

    void writeTimeout() {
        l_debug << L"writeTimeout(";
        byps_unique_lock lock(this->mutex);
        ex = BException(EX_TIMEOUT);
        waitRead.notify_one();
        l_debug << L")writeTimeout";
    }

    void applyHeaders(const std::wstring& contentType, int64_t contentLength) {
        l_debug << L"applyHeaders(contentType=" << contentType << L", contentLength=" << contentLength;
        byps_unique_lock lock(this->mutex);
        this->contentType = contentType;
        this->contentLength = contentLength;
        waitHeaders.notify_one();
        l_debug << L")applyHeaders";
    }

    virtual const std::wstring& getContentType() const {
        l_debug << L"getContentType(";
        QTHttpGet_ContentStream* pThis = const_cast<QTHttpGet_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L"timeout";
                pThis->ex = BException(EX_TIMEOUT);
            }
        }
        if (ex) throw ex;
        l_debug << L")getContentType=" << contentType;
        return contentType;
    }

    virtual int64_t getContentLength() const {
        l_debug << L"getContentLength(";
        QTHttpGet_ContentStream* pThis = const_cast<QTHttpGet_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L"timeout";
                pThis->ex = BException(EX_TIMEOUT);
            }
        }
        if (ex) throw ex;
        l_debug << L")getContentLength=" << contentLength;
        return contentLength;
    }

    virtual int32_t read(char* buf, int32_t offs, int32_t len) {
        l_debug << L"read(";
        byps_unique_lock lock(this->mutex);

        while (!ex && !finished && readPos == readLimit) {
            if (waitRead.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L"timeout";
                ex = BException(EX_TIMEOUT);
            }
        }

        if (ex) throw ex;

        if (finished && readPos == readLimit) {
            l_debug << L")read=-1";
            return -1;
        }

        int32_t max = std::min(len, readLimit-readPos);
        memcpy(buf + offs, bytes.data() + readPos, (size_t)max);

        readPos += max;
        if (readPos == readLimit) {
            waitWrite.notify_one();
        }

        l_debug << L")read=" << max;
        return max;
    }

};

class QTHttpClient : public HHttpClient, public byps_enable_shared_from_this<QTHttpClient> {
    void* app;
    BLogger log;
    QTHttpClientBridge clientBridge;

public:
    QTHttpWorkerThread* worker;

    QTHttpClient(void* app)
        : app(app)
        , log("QTHttpClient")
        , worker(new QTHttpWorkerThread())
    {
        l_debug << L"ctor(";
        worker->start();

        QObject::connect(&clientBridge, SIGNAL(createGetRequest(QNetworkRequest,int32_t,QTHttpRequestBridge**)),
                         worker->getWorkerBridge(), SLOT(createGetRequest(QNetworkRequest,int32_t,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        QObject::connect(&clientBridge, SIGNAL(createPostRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         worker->getWorkerBridge(), SLOT(createPostRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        QObject::connect(&clientBridge, SIGNAL(createPutRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         worker->getWorkerBridge(), SLOT(createPutRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        l_debug << L")ctor";
    }

    virtual ~QTHttpClient() {
        l_debug << L"dtor()";
        worker->quit();
    }

    virtual void init(const std::wstring& ) {
    }

    virtual PHttpGet get(const std::wstring& url);

    virtual PHttpPost post(const std::wstring& url);

    virtual PHttpPut put(const std::wstring& url);

    static QNetworkRequest urlToNetworkRequest(const std::wstring& surl) {
        return QNetworkRequest(QUrl(QString::fromStdWString(surl)));
    }

    void createGetRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createGetRequest(";
        emit clientBridge.createGetRequest(networkRequest, timeout, ppbridge);
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createGetRequest";
    }

    void createPostRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QIODevice* bytesToPost, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createPostRequest(";
        emit clientBridge.createPostRequest(networkRequest, timeout, bytesToPost, ppbridge);
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createPostRequest";
    }

    void createPutRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamToPut, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createPutRequest(";
        emit clientBridge.createPostRequest(networkRequest, timeout, streamToPut, ppbridge);
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createPutRequest";
    }


};

class QTHttpRequest : public virtual HHttpRequest, public byps_enable_shared_from_this<QTHttpRequest> {
protected:
    PQTHttpClient httpClient;
    QNetworkRequest networkRequest;
    QTHttpRequestBridge* bridge;
    bool cancelled;
    int32_t timeoutSeconds;
    BLogger log;
public:
    QTHttpRequest(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : httpClient(httpClient)
        , networkRequest(networkRequest)
        , bridge(0)
        , cancelled(false)
        , timeoutSeconds(0)
        , log("QTHttpRequest")
    {
        l_debug << L"ctor()";
    }

    ~QTHttpRequest() {
        l_debug << L")dtor()";
        if (bridge) {
            delete bridge;
        }
    }

    virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) {
        timeoutSeconds = std::max(connectTimeoutSeconds, sendrecvTimeoutSeconds);
        l_debug << L"setTimeouts() timeoutSeconds=" << timeoutSeconds;
    }

    int32_t getTimeoutSeconds() {
        return timeoutSeconds;
    }

    virtual void close() {
        l_debug << L"close(";
        if (!cancelled) {
            cancelled = true;
            if (bridge) {
                l_debug << L"abort";
                bridge->reply->abort();
            }
        }
        if (bridge) {
            bridge->close();
        }
        l_debug << L")close";
    }

    virtual void httpFinished() = 0;

    virtual void httpReadyRead() = 0;

    virtual void httpTimeout() {
        l_debug << L"httpTimeout(";
        close();
        l_debug << L")httpTimeout";
    }

};

class QTHttpGet : public HHttpGet, public virtual QTHttpRequest {

    byps_weak_ptr<QTHttpGet_ContentStream> stream_weak_ptr;
    bool headersApplied;
    BLogger log;

public:
    QTHttpGet(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , headersApplied(false)
        , log("QTHttpGet")
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpGet() {
        l_debug << L"dtor()";
    }

    virtual PContentStream send() {
        l_debug << L"send(";
        byps_ptr<QTHttpGet_ContentStream> ret(new QTHttpGet_ContentStream(timeoutSeconds));
        this->stream_weak_ptr = ret;

        l_debug << L"networkManager->get...";
        httpClient->createGetRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &bridge);
        l_debug << L"networkManager->get OK";

        l_debug << L")send";
        return ret;
    }

    byps_ptr<QTHttpGet_ContentStream> getStreamOrAbort() {
        l_debug << L"getStreamOrAbort(";
        byps_ptr<QTHttpGet_ContentStream> stream = stream_weak_ptr.lock();
        if (!stream) {
            l_debug << L"abort";
            QTHttpRequest::close();
        }
        l_debug << L")getStreamOrAbort=" << stream.get();
        return stream;
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";
        l_debug << L"cancelled=" << cancelled;
        if (!cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                stream->writeClose();
            }
        }
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadyRead(";
        l_debug << L"cancelled=" << cancelled;
        if (!cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                l_debug << L"headersApplied=" << headersApplied;
                if (!headersApplied) {
                    headersApplied = true;

                    QByteArray headerValue = bridge->reply->rawHeader("Content-Type");
                    std::wstring contentType = BToStdWString(headerValue.data());

                    headerValue = bridge->reply->rawHeader("Content-Length");
                    int64_t contentLength = headerValue.size() ? QString(headerValue).toLongLong() : -1;

                    stream->applyHeaders(contentType, contentLength);
                }
                stream->putBytes(bridge->reply->readAll());
            }
        }
        l_debug << L")httpReadyRead";
    }

    virtual void httpTimeout() {
        l_debug << L"httpTimeout(";
        QTHttpRequest::httpTimeout();
        l_debug << L"cancelled=" << cancelled;
        if (cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {
                stream->writeTimeout();
            }
            cancelled = true;
            l_debug << L"cancelled=" << cancelled;
        }
        l_debug << L")httpTimeout";
    }

    virtual void close() {
        l_debug << L"close(";
        QTHttpRequest::close();
        l_debug << L"cancelled=" << cancelled;
        if (cancelled) {
            byps_ptr<QTHttpGet_ContentStream> stream = stream_weak_ptr.lock();
            if (stream) {
                stream->writeCancel();
            }
        }
        l_debug << L")close";
    }

};


class QTHttpPost : public HHttpPost, public virtual QTHttpRequest {
    QIODevice_PBytes* bytesToPost;
    PAsyncResult asyncBytesReceived;
    PBytes respBytes;
    size_t pos;
    friend class QTHttpPostWorker;
    BLogger log;
public:

    QTHttpPost(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , bytesToPost(NULL)
        , asyncBytesReceived(NULL)
        , respBytes(BBytes::create(10 * 1000))
        , pos(0)
        , log("QTHttpPost")
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpPost() {
        l_debug << L"dtor()";
        if (bytesToPost) delete bytesToPost;
    }

    virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) {
        l_debug << L"send(#bytes=" << bytes->length << L", contentType=" << contentType;
        this->bytesToPost = new QIODevice_PBytes(bytes);
        this->asyncBytesReceived = asyncBytesReceived;

        networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(contentType)));
        networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)bytes->length));
        networkRequest.setAttribute(QNetworkRequest::CacheLoadControlAttribute, QVariant( int(QNetworkRequest::AlwaysNetwork)));

        l_debug << L"networkManager->post...";
        httpClient->createPostRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), bytesToPost, &bridge);
        l_debug << L"networkManager->post OK";

        l_debug << L")send";
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";
        if (asyncBytesReceived) {
            l_debug << L"#bytes=" << pos;
            respBytes->length = pos;
            asyncBytesReceived->setAsyncResult(BVariant(respBytes));
            asyncBytesReceived = NULL;
            respBytes.reset();
        }
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadReady(";
        if (asyncBytesReceived) {

            QByteArray bytes = bridge->reply->readAll();
            l_debug << L"#bytes=" << bytes.size();

            if (pos + (size_t)bytes.size() > respBytes->length) {
                size_t ncapacity = respBytes->length + std::min(respBytes->length, (size_t)1000000);
                l_debug << L"grow buffer to new capacity=" << ncapacity;
                respBytes = BBytes::create(respBytes, ncapacity);
            }

            l_debug << L"copy bytes";
            memcpy(respBytes->data + pos, bytes.data(), (size_t)bytes.size());

            pos += bytes.size();
            l_debug << L"received so far: #bytes=" << pos;
        }
    }

    virtual void httpTimeout() {
        if (asyncBytesReceived) {
            l_debug << L"setAsyncResult EX_TIMEOUT";
            asyncBytesReceived->setAsyncResult(BVariant(EX_TIMEOUT));
            asyncBytesReceived = NULL;
        }
    }

    virtual void close() {
        l_debug << L"close(";
        QTHttpRequest::close();
        if (asyncBytesReceived) {
            l_debug << L"setAsyncResult EX_CANCELLED";
            asyncBytesReceived->setAsyncResult(BVariant(EX_CANCELLED));
            asyncBytesReceived = NULL;
        }
        l_debug << L")close";
    }

};

class QTHttpPut : public HHttpPut, public virtual QTHttpRequest {
    QIODevice_PContentStream* streamToPut;
    PAsyncResult asyncBoolFinished;
    friend class QTHttpPutWorker;
    BLogger log;
public:
    QTHttpPut(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , streamToPut(NULL)
        , asyncBoolFinished(NULL)
        , log("QTHttpPut")
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpPut() {
        l_debug << L"dtor()";
        if (streamToPut) delete streamToPut;
    }

    virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) {
        int64_t contentLength = strm->getContentLength();
        l_debug << L"send(contentLength=" << contentLength << L", contentType=" << strm->getContentType();
        if (contentLength >= 0) {

            this->asyncBoolFinished = asyncBoolFinished;

            streamToPut = new QIODevice_PContentStream(strm);

            networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(strm->getContentType())));
            networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)contentLength));
            networkRequest.setAttribute(QNetworkRequest::CacheLoadControlAttribute, QVariant( int(QNetworkRequest::AlwaysNetwork)));

            l_debug << L"networkManager->put...";
            httpClient->createPutRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), streamToPut, &bridge);
            l_debug << L"networkManager->put OK";

        }
        else {
            l_debug << L"setAsyncResult EX_IOERROR";
            asyncBoolFinished->setAsyncResult(BVariant(
                BException(EX_IOERROR, L"QT does not support chunked encoding. BContentStream must provide a content length."))
            );
        }
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";
        if (asyncBoolFinished) {
            l_debug << L"setAsyncResult true";
            asyncBoolFinished->setAsyncResult(BVariant(true));
            asyncBoolFinished = NULL;
        }
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadyRead(";
        bridge->reply->readAll();
        l_debug << L")httpReadyRead";
    }

    virtual void httpTimeout() {
        if (asyncBoolFinished) {
            l_debug << L"setAsyncResult EX_TIMEOUT";
            asyncBoolFinished->setAsyncResult(BVariant(EX_TIMEOUT));
            asyncBoolFinished = NULL;
        }
    }

    virtual void close() {
        l_debug << L"close(";
        QTHttpRequest::close();
        if (asyncBoolFinished) {
            l_debug << L"setAsyncResult EX_CANCELLED";
            asyncBoolFinished->setAsyncResult(BVariant(EX_CANCELLED));
            asyncBoolFinished = NULL;
        }
        l_debug << L")close";
    }

};

BINLINE QTHttpRequestBridge::QTHttpRequestBridge(QNetworkReply* reply, int32_t timeout)
    : log("QTHttpRequestBridge")
    , reply(reply)
{
    l_debug << L"ctor(";

    l_debug << L"connect signals";
    QObject::connect(reply, SIGNAL(finished()),
                     this, SLOT(httpFinished()));
    QObject::connect(reply, SIGNAL(readyRead()),
                     this, SLOT(httpReadyRead()));
    QObject::connect(reply, SIGNAL(error(QNetworkReply::NetworkError)),
                     this, SLOT(httpError(QNetworkReply::NetworkError)));

    if (timeout) {

        QObject::connect(&timer, SIGNAL(timeout()),
                         this, SLOT(httpTimeout()));

        l_debug << L"start timer";
        timer.setSingleShot(true);
        timer.start(timeout * 1000);
    }

    l_debug << L")ctor";
}

BINLINE QTHttpRequestBridge::~QTHttpRequestBridge() {
    l_debug << L"dtor()";
}

BINLINE void QTHttpRequestBridge::httpFinished() {
    l_debug << L"httpFinished(";
    timer.stop();
    pThis->httpFinished();
    l_debug << L")httpFinished";
}

BINLINE void QTHttpRequestBridge::httpReadyRead() {
    l_debug << L"httpReadyRead(";
    int32_t timeout = pThis->getTimeoutSeconds();
    if (timeout) {
        l_debug << L"restart timer";
        timer.stop();
        timer.start();
    }
    pThis->httpReadyRead();
    l_debug << L")httpReadyRead";
}

BINLINE void QTHttpRequestBridge::httpTimeout() {
    l_debug << L"httpTimeout(";
    timer.stop();
    pThis->httpTimeout();
    l_debug << L")httpTimeout";
}

BINLINE void QTHttpRequestBridge::httpError(QNetworkReply::NetworkError err) {
    l_debug << L"httpError(" << err;
    timer.stop();
    l_debug << L")httpError";
}

BINLINE void QTHttpRequestBridge::close() {
    l_debug << L"close(";
    pThis.reset();
    l_debug << L")close";
}

BINLINE PHttpGet QTHttpClient::get(const std::wstring& url) {
    l_debug << L"get(" << url;
    QTHttpGet* req = new QTHttpGet(shared_from_this(), urlToNetworkRequest(url));
    l_debug << L")get";
    return PHttpGet(req);
}

BINLINE PHttpPost QTHttpClient::post(const std::wstring& url) {
    l_debug << L"post(" << url;
    QTHttpPost* req = new QTHttpPost(shared_from_this(), urlToNetworkRequest(url));
    l_debug << L")post";
    return PHttpPost(req);
}

BINLINE PHttpPut QTHttpClient::put(const std::wstring& url) {
    l_debug << L"put(" << url;
    QTHttpPut* req = new QTHttpPut(shared_from_this(), urlToNetworkRequest(url));
    l_debug << L")put";
    return PHttpPut(req);
}

BINLINE QTHttpWorkerThread::QTHttpWorkerThread()
    : log("QTHttpWorkerThread")
    , workerBridge(NULL)
{
    l_debug << L"ctor()";
}

BINLINE QTHttpWorkerThread::~QTHttpWorkerThread()
{
    l_debug << L"dtor()";
}

BINLINE void QTHttpWorkerThread::run() {
    l_debug << L"run(";
    {
        byps_unique_lock lock(mutex);
        workerBridge = new QTHttpWorkerBridge();
        waitInit.notify_all();
    }
    exec();
    l_debug << L")run";
}

BINLINE QTHttpWorkerBridge* QTHttpWorkerThread::getWorkerBridge() {
    l_debug << L"getWorkerBridge(";
    byps_unique_lock lock(mutex);
    while (!workerBridge) {
        l_debug << L"wait for init...";
        std::chrono::milliseconds timeout(10 * 1000);
        if (waitInit.wait_for(lock, timeout) == std::cv_status::timeout) {
            l_debug << L"timeout while waiting for initialized worker thread";
            return NULL;
        }
        l_debug << L"wait for init OK";
    }
    l_debug << L")getWorkerBridge";
    return workerBridge;
}

BINLINE QTHttpWorkerBridge::QTHttpWorkerBridge()
    : log("QTHttpWorkerBridge")
    , networkManager(new QNetworkAccessManager())
{

}

BINLINE void QTHttpWorkerBridge::createGetRequest(QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createGetRequest(";
    QNetworkReply* reply = networkManager->get(networkRequest);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createGetRequest";
}

BINLINE void QTHttpWorkerBridge::createPostRequest(QNetworkRequest networkRequest, int32_t timeout, QIODevice* bytesToPost, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createPostRequest(";
    QNetworkReply* reply = networkManager->post(networkRequest, bytesToPost);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createPostRequest";
}

BINLINE void QTHttpWorkerBridge::createPutRequest(QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamToPut, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createPutRequest(";
    QNetworkReply* reply = networkManager->put(networkRequest, streamToPut);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createPutRequest";
}

}}}}}


namespace com { namespace wilutions { namespace byps { namespace http {

BINLINE PHttpClient HttpClient_create(void* app) {
    return PHttpClient(new com::wilutions::byps::http::qthttp::QTHttpClient(app));
}

}}}}

#endif // QTHTTPCLIENT_HPP