#ifndef QTHTTPCLIENT_HPP
#define QTHTTPCLIENT_HPP


#include "QTHttpClient.h"
#include "QTHttpClientI.h"
#include <QStack>

namespace com { namespace wilutions { namespace byps { namespace http { namespace qthttp {

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;

#define MAX_STREAM_PART_SIZE (1000 * 1000)

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
    static BLogger log;
public:
    QTHttpGet_ContentStream(int32_t timeoutSeconds)
        : readPos(0)
        , readLimit(0)
        , contentLength(0)
        , headersAvail(false)
        , timeout(timeoutSeconds * 1000)
    {
        l_debug << L"ctor(timeoutSeconds=" << timeoutSeconds << L")";
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

    void writeError(BException ex) {
        l_debug << L"writeError(";
        byps_unique_lock lock(this->mutex);
        this->ex = ex;
        waitRead.notify_one();
        l_debug << L")writeError";
    }

    void applyHeaders(const std::wstring& contentType, int64_t contentLength) {
        l_debug << L"applyHeaders(contentType=" << contentType << L", contentLength=" << contentLength;
        byps_unique_lock lock(this->mutex);
        this->contentType = contentType;
        this->contentLength = contentLength;
        this->headersAvail = true;
        waitHeaders.notify_one();
        l_debug << L")applyHeaders";
    }

    void maybeWaitUntilHeadersAvail() const {
        l_debug << L"maybeWaitUntilHeadersAvail(";
        QTHttpGet_ContentStream* pThis = const_cast<QTHttpGet_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L"timeout";
                pThis->ex = BException(EX_TIMEOUT);
            }
        }
        if (ex) {
            l_debug << L"throw exception=" << ex.toString();
            throw ex;
        }
        l_debug << L")maybeWaitUntilHeadersAvail=" << headersAvail;
    }

    virtual const std::wstring& getContentType() const {
        l_debug << L"getContentType(";
        maybeWaitUntilHeadersAvail();
        l_debug << L")getContentType=" << contentType;
        return contentType;
    }

    virtual int64_t getContentLength() const {
        l_debug << L"getContentLength(";
        maybeWaitUntilHeadersAvail();
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
    static BLogger log;
    QTHttpClientBridge clientBridge;

public:
    QTHttpWorkerThread* worker;

    QTHttpClient(void* app)
        : app(app)
        , worker(new QTHttpWorkerThread())
    {
        l_debug << L"ctor(";
        worker->start();

        QObject::connect(&clientBridge, SIGNAL(createGetRequest(QNetworkRequest,int32_t,QTHttpRequestBridge**)),
                         worker->workerBridge, SLOT(createGetRequest(QNetworkRequest,int32_t,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        QObject::connect(&clientBridge, SIGNAL(createPostRequest(QNetworkRequest,int32_t,QByteArray*,QTHttpRequestBridge**)),
                         worker->workerBridge, SLOT(createPostRequest(QNetworkRequest,int32_t,QByteArray*,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        QObject::connect(&clientBridge, SIGNAL(createPutRequest(QNetworkRequest,int32_t,QByteArray*,QTHttpRequestBridge**)),
                         worker->workerBridge, SLOT(createPutRequest(QNetworkRequest,int32_t,QByteArray*,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        l_debug << L")ctor";
    }

    virtual ~QTHttpClient() {
        l_debug << L"dtor()";
    }

    virtual void init(const std::wstring& ) {
    }

    virtual void done() {
        l_debug << L"done(";
        emit worker->quit();
        worker->wait();
        delete worker;
        l_debug << L")done";
    }

    virtual PHttpGet get(const std::wstring& url);

    virtual PHttpPost post(const std::wstring& url);

    virtual PHttpPut put(const std::wstring& url);

    static QNetworkRequest urlToNetworkRequest(const std::wstring& surl) {
        return QNetworkRequest(QUrl(QString::fromStdWString(surl)));
    }

    void createGetRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createGetRequest(";
        if (QThread::currentThread() == worker) {
            // This function is called from the worker thread, if an error occurs in a message
            // and the message is to be cancelled. Cancelling a message is performed with a
            // special GET request in HWireClient::sendCancelMessage.
            // see HWireClient_AsyncResultAfterAllRequests::setAsyncResult
            worker->workerBridge->createGetRequest(networkRequest, timeout, ppbridge);
        }
        else {
          emit clientBridge.createGetRequest(networkRequest, timeout, ppbridge);
        }
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createGetRequest";
    }

    void createPostRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPost, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createPostRequest(";
        if (QThread::currentThread() == worker) {
            // This function is called from the worker thread, if the serverR is
            // started in BClient::authenticate
            worker->workerBridge->createPostRequest(networkRequest, timeout, bytesToPost, ppbridge);
        }
        else {
            emit clientBridge.createPostRequest(networkRequest, timeout, bytesToPost, ppbridge);
        }
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createPostRequest";
    }

    void createPutRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPut, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createPutRequest(";
        if (QThread::currentThread() == worker) {
            // This function is called from the worker thread, if subsequent
            // stream parts have to be sent.
            worker->workerBridge->createPutRequest(networkRequest, timeout, bytesToPut, ppbridge);
        }
        else {
            emit clientBridge.createPutRequest(networkRequest, timeout, bytesToPut, ppbridge);
        }
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createPutRequest";
    }


};

class QTHttpRequest : public virtual HHttpRequest, public byps_enable_shared_from_this<QTHttpRequest> {
protected:
    byps_weak_ptr<QTHttpClient> httpClient;
    QNetworkRequest networkRequest;
    QTHttpRequestBridge* bridge;
    int32_t timeoutSeconds;
    bool requestAborted;
    bool requestFinished;
    BVariant result;
    static BLogger log;
public:
    QTHttpRequest(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : httpClient(httpClient)
        , networkRequest(networkRequest)
        , bridge(0)
        , timeoutSeconds(0)
        , requestAborted(false)
        , requestFinished(false)
    {
        l_debug << L"ctor()";
    }

    ~QTHttpRequest() {
        l_debug << L"dtor(";
        if (bridge) {
            delete bridge;
        }
        l_debug << L")dtor";
    }

    virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) {
        timeoutSeconds = std::max(connectTimeoutSeconds, sendrecvTimeoutSeconds);
        l_debug << L"setTimeouts() timeoutSeconds=" << timeoutSeconds;
    }

    int32_t getTimeoutSeconds() {
        return timeoutSeconds;
    }

    virtual void done() {
        l_debug << L"done(";
        if (!requestFinished) {
            requestFinished = true;
            PQTHttpRequest keepthis = shared_from_this();
            if (bridge) {
                bridge->done();
            }
            internalApplyResult();
            keepthis.reset();
        }
        l_debug << L")done";
    }

    void abort() {
        l_debug << L"abort(";
        if (bridge && !requestAborted) {
            requestAborted = true;

            bool alreadyFinished = bridge->reply->isFinished();
            if (!alreadyFinished) {
                l_debug << L"abort";
                bridge->reply->abort();
                // reply->abort() will fire httpFinished() which
                // calls done and deletes this
            }
        }
        l_debug << L")abort";
    }

    PQTHttpClient getHttpClient() {
        PQTHttpClient httpClient = this->httpClient.lock();
        if (!httpClient) {
            result = BVariant(BException(EX_CANCELLED, L"HttpClient object already deleted."));
            internalApplyResult();
        }
        return httpClient;
    }

    virtual void internalApplyResult() = 0;

    virtual void httpFinished() = 0;

    virtual void httpReadyRead() = 0;

    virtual void httpTimeout() {
        l_debug << L"httpTimeout(";
        httpError(BException(EX_TIMEOUT, L"HTTP request timeout"));
        l_debug << L")httpTimeout";
    }

    virtual void httpError(const BException& ex) {
        l_debug << L"httpError(" << ex;
        if (!requestFinished) {
            result = BVariant(ex);
        }
        l_debug << L")httpError";
    }

    virtual void close() {
        l_debug << L"close(";
        if (!requestFinished) {
            httpError(BException(EX_CANCELLED, L"HTTP request cancelled"));
            abort();
        }
        l_debug << L")close";
    }


};

class QTHttpGet : public HHttpGet, public virtual QTHttpRequest {

    byps_weak_ptr<QTHttpGet_ContentStream> stream_weak_ptr;
    bool headersApplied;
    static BLogger log;

public:
    QTHttpGet(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , headersApplied(false)
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

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {
            l_debug << L"networkManager->get...";
            httpClient->createGetRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &bridge);
            l_debug << L"networkManager->get OK";
        }

        l_debug << L")send";
        return ret;
    }

    byps_ptr<QTHttpGet_ContentStream> getStreamOrAbort() {
        l_debug << L"getStreamOrAbort(";
        byps_ptr<QTHttpGet_ContentStream> stream = stream_weak_ptr.lock();
        if (!stream && !bridge->reply->isFinished()) {
             abort();
        }
        l_debug << L")getStreamOrAbort=" << stream.get();
        return stream;
    }

    virtual void internalApplyResult() {
        l_debug << L"internalApplyResult(";
        byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
        if (stream) {
            if (result.isException()) {
                l_debug << L"stream->writeError " << result.getException().toString();
                stream->writeError(result.getException());
            }
            else {
                l_debug << L"stream->writeClose";
                stream->writeClose();
            }
         }
         l_debug << L")internalApplyResult";
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";
        applyHeadersIfNot();
        if (!result.isException()) {
            result = BVariant(true);
        }
        done();
        l_debug << L")httpFinished";
       }

    virtual void httpReadyRead() {
        l_debug << L"httpReadyRead(";
        applyHeadersIfNot();
        byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
        if (stream) {
            stream->putBytes(bridge->reply->readAll());
        }
        l_debug << L")httpReadyRead";
    }

    void applyHeadersIfNot() {
        l_debug << L"applyHeadersIfNot(";
        l_debug << L"headersApplied=" << headersApplied;
        if (!headersApplied) {
            headersApplied = true;

            byps_ptr<QTHttpGet_ContentStream> stream = getStreamOrAbort();
            if (stream) {

                QByteArray headerValue = bridge->reply->rawHeader("Content-Type");
                std::wstring contentType = BToStdWString(headerValue.data());

                headerValue = bridge->reply->rawHeader("Content-Length");
                int64_t contentLength = headerValue.size() ? QString(headerValue).toLongLong() : -1;

                stream->applyHeaders(contentType, contentLength);
            }
        }
        l_debug << L")applyHeadersIfNot";
    }
};


class QTHttpPost : public HHttpPost, public virtual QTHttpRequest {
    QByteArray* bytesToPost;
    PAsyncResult asyncBytesReceived;
    PBytes respBytes;
    size_t pos;
    friend class QTHttpPostWorker;
    static BLogger log;
public:

    QTHttpPost(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , bytesToPost(NULL)
        , asyncBytesReceived(NULL)
        , respBytes(BBytes::create(10 * 1000))
        , pos(0)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpPost() {
        l_debug << L"dtor()";
        if (bytesToPost) delete bytesToPost;
    }

    virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) {
        l_debug << L"send(#bytes=" << bytes->length << L", contentType=" << contentType;
        this->bytesToPost = new QByteArray((const char*)bytes->data, bytes->length);
        this->asyncBytesReceived = asyncBytesReceived;

        networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(contentType)));
        networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)bytes->length));

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {
            l_debug << L"networkManager->post...";
            httpClient->createPostRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), bytesToPost, &bridge);
            l_debug << L"networkManager->post OK";
        }

        l_debug << L")send";
    }

    virtual void internalApplyResult() {
        l_debug << L"internalApplyResult(";
        if (asyncBytesReceived) {
            l_debug << L"result=" << result.toString();
            asyncBytesReceived->setAsyncResult(result);
            asyncBytesReceived = NULL;
        }
        l_debug << L")internalApplyResult";
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";

        if (bridge) {
            QVariant varContentLength = bridge->reply->header(QNetworkRequest::ContentLengthHeader);
            qulonglong contentLength = varContentLength.toULongLong();
            l_debug << L"contentLength=" << contentLength;
            QVariant varContentType = bridge->reply->header(QNetworkRequest::ContentTypeHeader);
            QString contentType = varContentType.toString();
            l_debug << L"contentType=" << contentType.toStdWString();
        }

        if (respBytes) {
            l_debug << L"#bytes=" << pos;
            respBytes->length = pos;
            if (!result.isException()) {
                result = BVariant(respBytes);
            }
        }
        done();
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadReady(";
        if (asyncBytesReceived) {

            QByteArray bytes = bridge->reply->readAll();
            size_t bsize = bytes.size();
            l_debug << L"received #bytes=" << bsize;

            if (pos + bsize > respBytes->length) {
                size_t grow = std::min(respBytes->length, (size_t)1000000);
                size_t ncapacity = std::max(respBytes->length + grow, pos + bsize);
                l_debug << L"grow buffer to new capacity=" << ncapacity;
                respBytes = BBytes::create(respBytes, ncapacity);
            }

            l_debug << L"copy bytes";
            memcpy(respBytes->data + pos, bytes.data(), bsize);

            pos += bsize;
            l_debug << L"received so far: #bytes=" << pos;
        }
    }

};

class QTHttpPut : public HHttpPut, public virtual QTHttpRequest {
    PContentStream streamToPut;
    PAsyncResult asyncBoolFinished;
    int64_t partId;
    int64_t nbOfParts;
    int64_t totalLength;
    bool isLastPart;
    PBytes bytesToPut;
    QString baseUrl;
    friend class QTHttpPutWorker;
    static BLogger log;
public:
    QTHttpPut(PQTHttpClient httpClient, QNetworkRequest networkRequest)
        : QTHttpRequest(httpClient, networkRequest)
        , streamToPut(NULL)
        , asyncBoolFinished(NULL)
        , partId(0)
        , nbOfParts(0)
        , totalLength(0)
        , isLastPart(false)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpPut() {
        l_debug << L"dtor()";
    }

    virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) {
        int64_t contentLength = strm->getContentLength();
        l_debug << L"send(contentLength=" << contentLength << L", contentType=" << strm->getContentType();

        this->asyncBoolFinished = asyncBoolFinished;
        this->streamToPut = strm;
        this->totalLength = contentLength;
        this->baseUrl = networkRequest.url().url();

        if (totalLength >= 0) {
            nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
            if (totalLength % MAX_STREAM_PART_SIZE) {
                nbOfParts++;
            }
        }
        else {
            nbOfParts = INT64_MAX;
        }

        sendNextPart(0);
    }

    void sendNextPart(int64_t nextPartId) {
        l_debug << L"sendNextPart(nextPartId=" << nextPartId;

        this->partId = nextPartId;

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {

            int32_t contentLength = 0;

            // Read stream part into buffer
            if (totalLength >= 0) {
                if (bytesToPut == NULL) {
                    size_t capacity = std::min((size_t)totalLength, (size_t)MAX_STREAM_PART_SIZE);
                    l_debug << L"create buffer with capacity=" << capacity;
                    bytesToPut = BBytes::create(capacity);
                }
                l_debug << L"read from stream...";
                contentLength = streamToPut->read((char*)bytesToPut->data, 0, bytesToPut->length);
                if (contentLength < 0) contentLength = 0; // true, if stream is empty
                l_debug << L"read from stream OK, #bytes=" << contentLength;
                isLastPart = partId >= nbOfParts-1; // nbOfParts might be 0
                l_debug << L"isLastPart=" << isLastPart;
            }
            else {
                if (bytesToPut == NULL) {
                    l_debug << L"create buffer with capacity=" << MAX_STREAM_PART_SIZE;
                    bytesToPut = BBytes::create(MAX_STREAM_PART_SIZE);
                }
                l_debug << L"read from stream...";
                contentLength = streamToPut->read((char*)bytesToPut->data, 0, bytesToPut->length);
                l_debug << L"read from stream OK, #bytes=" << contentLength;
                if (contentLength < 0) contentLength = 0; // true, if stream is empty or stream size is a multiple of MAX_STREAM_PART_SIZE
                isLastPart = contentLength < MAX_STREAM_PART_SIZE;
                l_debug << L"isLastPart=" << isLastPart;
            }

            // Append partid, totallength to URL
            QString partUrl = baseUrl;
            partUrl.append("&partid=").append(QString::number(partId));
            partUrl.append("&total=").append(QString::number(totalLength));
            partUrl.append("&last=").append(QString::number(isLastPart));
            l_debug << L"partUrl=" << partUrl.toStdWString();
            networkRequest.setUrl(partUrl);

            l_debug << L"header contentType=" << streamToPut->getContentType();
            l_debug << L"header contentLength=" << contentLength;
            networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(streamToPut->getContentType())));
            networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)contentLength));

            l_debug << L"networkManager->put...";
            QByteArray qbytes = QByteArray::fromRawData((char*)bytesToPut->data, contentLength);
            httpClient->createPutRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &qbytes, &bridge);
            l_debug << L"networkManager->put OK";

        }
        else {
            // httpClient is already release. This should not happend during the HTTP request.
            result = BVariant(BException(EX_CANCELLED, L"HTTP client has already been released."));
            internalApplyResult();
        }

        l_debug << L")sendNextPart";
    }

    virtual void internalApplyResult() {
        if (asyncBoolFinished) {
            l_debug << L"result=" << result.toString();
            asyncBoolFinished->setAsyncResult(result);
            asyncBoolFinished = NULL;
        }
    }

    virtual void httpFinished() {
        l_debug << L"httpFinished(";
        l_debug << L"isLastPart=" << isLastPart;
        if (isLastPart) {
            if (!result.isException()) {
                result = BVariant(true);
            }
            done();
        }
        else {
            sendNextPart(partId+1);
        }
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadyRead(";
        bridge->reply->readAll();
        l_debug << L")httpReadyRead";
    }

};

BINLINE QTHttpRequestBridge::QTHttpRequestBridge(QNetworkReply* reply, int32_t timeout)
    : reply(reply)
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
    if (pThis) {
       pThis->httpFinished();
    }
    l_debug << L")httpFinished";
}

BINLINE void QTHttpRequestBridge::httpReadyRead() {
    l_debug << L"httpReadyRead(";
    if (pThis) {
        int32_t timeout = pThis->getTimeoutSeconds();
        if (timeout) {
            l_debug << L"restart timer";
            timer.stop();
            timer.start();
        }
        pThis->httpReadyRead();
    }
    l_debug << L")httpReadyRead";
}

BINLINE void QTHttpRequestBridge::httpTimeout() {
    l_debug << L"httpTimeout(";
    timer.stop();
    if (pThis) {
        pThis->httpTimeout();
    }
    l_debug << L")httpTimeout";
}

BINLINE void QTHttpRequestBridge::httpError(QNetworkReply::NetworkError err) {
    l_debug << L"httpError(" << err;
    timer.stop();
    QString str = reply->errorString();
    std::wstring msg = str.toStdWString();
    if (pThis) {
        pThis->httpError(BException(EX_IOERROR, msg));
    }
    l_debug << L")httpError";
}

BINLINE void QTHttpRequestBridge::done() {
    l_debug << L"done()";
    pThis.reset();
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
    : workerBridge(new QTHttpWorkerBridge())
{
    l_debug << L"ctor()";
    workerBridge->moveToThread(this);
    workerBridge->networkManager->moveToThread(this);
}

BINLINE QTHttpWorkerThread::~QTHttpWorkerThread()
{
    l_debug << L"dtor()";
    delete workerBridge;
}

BINLINE void QTHttpWorkerThread::run() {
    l_debug << L"run(";
    exec();
    l_debug << L")run";
}

BINLINE QTHttpWorkerBridge::QTHttpWorkerBridge()
    : networkManager(new QNetworkAccessManager())
{
}

BINLINE void QTHttpWorkerBridge::createGetRequest(QNetworkRequest networkRequest, int32_t timeout, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createGetRequest(";
    QNetworkReply* reply = networkManager->get(networkRequest);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createGetRequest";
}

BINLINE void QTHttpWorkerBridge::createPostRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPost, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createPostRequest(";
    QNetworkReply* reply = networkManager->post(networkRequest, *bytesToPost);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createPostRequest";
}

BINLINE void QTHttpWorkerBridge::createPutRequest(QNetworkRequest networkRequest, int32_t timeout, QByteArray* bytesToPut, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createPutRequest(";
    QNetworkReply* reply = networkManager->put(networkRequest, *bytesToPut);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createPutRequest";
}


BLogger QTHttpGet_ContentStream::log("QTHttpGet_ContentStream");
BLogger QTHttpClient::log("QTHttpClient");
BLogger QTHttpRequest::log("QTHttpRequest");
BLogger QTHttpGet::log("QTHttpGet");
BLogger QTHttpPost::log("QTHttpPost");
BLogger QTHttpPut::log("QTHttpPut");
BLogger QTHttpWorkerThread::log("QTHttpWorkerThread");
BLogger QTHttpRequestBridge::log("QTHttpRequestBridge");
BLogger QTHttpWorkerBridge::log("QTHttpWorkerBridge");

}}}}}


namespace com { namespace wilutions { namespace byps { namespace http {

BINLINE PHttpClient HttpClient_create(void* app) {
    return PHttpClient(new com::wilutions::byps::http::qthttp::QTHttpClient(app));
}

}}}}

#endif // QTHTTPCLIENT_HPP
