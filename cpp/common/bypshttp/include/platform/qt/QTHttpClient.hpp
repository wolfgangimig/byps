/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef QTHTTPCLIENT_HPP
#define QTHTTPCLIENT_HPP


#include "QTHttpClient.h"
#include "QTHttpClientI.h"
#include <QStack>

namespace byps { namespace http { namespace qthttp {

using namespace byps;
using namespace byps::http;

#define MAX_STREAM_PART_SIZE (1000 * 1000)

class QTHttpGetStream_ContentStream : public BContentStream {
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
    QTHttpGetStream_ContentStream(int32_t timeoutSeconds)
        : finished(false)
        , readPos(0)
        , readLimit(0)
        , contentLength(0)
        , headersAvail(false)
        , timeout(timeoutSeconds * 1000)
    {
        l_debug << L"ctor(timeoutSeconds=" << timeoutSeconds << L")";
    }

    virtual ~QTHttpGetStream_ContentStream() {
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
        QTHttpGetStream_ContentStream* pThis = const_cast<QTHttpGetStream_ContentStream*>(this);
        byps_unique_lock lock(pThis->mutex);
        while(!ex && !headersAvail) {
            if (pThis->waitHeaders.wait_for(lock, timeout) == std::cv_status::timeout) {
                l_debug << L"timeout";
                pThis->ex = BException(EX_TIMEOUT, L"Timeout while waiting for response headers.");
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
                ex = BException(EX_TIMEOUT, L"Timeout while waiting for response data.");
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
    PHttpCredentials credentials;

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

        QObject::connect(&clientBridge, SIGNAL(createPutStreamRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         worker->workerBridge, SLOT(createPutStreamRequest(QNetworkRequest,int32_t,QIODevice*,QTHttpRequestBridge**)),
                         Qt::BlockingQueuedConnection);

        l_debug << L")ctor";
    }

    virtual ~QTHttpClient() {
        l_debug << L"dtor()";
    }

    virtual void init(const std::wstring& , PHttpCredentials creds) {
        credentials = creds;
    }

    virtual void done() {
        l_debug << L"done(";
        emit worker->quit();
        worker->wait();
        delete worker;
        l_debug << L")done";
    }

    virtual PHttpGetStream getStream(const std::wstring& url);

    virtual PHttpGet get(const std::wstring& url);

    virtual PHttpPost post(const std::wstring& url);

    virtual PHttpPutStream putStream(const std::wstring& url);

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

    void createPutStreamRequest(PQTHttpRequest req, QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamIO, QTHttpRequestBridge** ppbridge) {
        l_debug << L"createPutStreamRequest(";
        if (QThread::currentThread() == worker) {
            // This function is called from the worker thread, if subsequent
            // stream parts have to be sent.
            worker->workerBridge->createPutStreamRequest(networkRequest, timeout, streamIO, ppbridge);
        }
        else {
            emit clientBridge.createPutStreamRequest(networkRequest, timeout, streamIO, ppbridge);
        }
        l_debug << L"bridge=" << (void*)*ppbridge;
        (*ppbridge)->pThis = req;
        l_debug << L")createPutStreamRequest";
    }

};

class QTHttpRequest : public virtual HHttpRequest, public byps_enable_shared_from_this<QTHttpRequest> {
protected:
    byps_weak_ptr<QTHttpClient> httpClient;
    std::wstring surl;
    QTHttpRequestBridge* bridge;
    int32_t timeoutSeconds;
    bool requestAborted;
    bool requestFinished;

    PBytes respBytes;
    size_t respPos;

    PAsyncResult asyncBytesReceived;

    BVariant result;
    static BLogger log;

public:
    QTHttpRequest(PQTHttpClient httpClient, const std::wstring& url)
        : httpClient(httpClient)
        , surl(url)
        , bridge(0)
        , timeoutSeconds(0)
        , requestAborted(false)
        , requestFinished(false)
        , respPos(0)
        , asyncBytesReceived(NULL)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpRequest() {
        l_debug << L"dtor(";
        // bridge is deleted with bridge->reply
        l_debug << L")dtor";
    }

    virtual void setTimeouts(int32_t, int32_t sendrecvTimeoutSeconds) {
        timeoutSeconds = sendrecvTimeoutSeconds;
        l_debug << L"setTimeouts() timeoutSeconds=" << timeoutSeconds;
    }

    int32_t getTimeoutSeconds() {
        return timeoutSeconds;
    }

    virtual void done() {
        l_debug << L"done(";
        PQTHttpRequest keepthis = shared_from_this();
        if (!requestFinished) {
            requestFinished = true;
            if (bridge) {
                bridge->done();
            }
            internalApplyResult();
        }
        keepthis.reset();
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
            l_debug << L"#bytes=" << respPos;
            respBytes->length = respPos;
            if (!result.isException()) {
                result = BVariant(respBytes);
            }
        }
        done();
        l_debug << L")httpFinished";
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadReady(";

        QByteArray bytes = bridge->reply->readAll();
        size_t bsize = bytes.size();
        l_debug << L"received #bytes=" << bsize;

        if (!respBytes) {
            respBytes = BBytes::create(bsize);
        }
        else if (respPos + bsize > respBytes->length) {
            size_t grow = std::min(respBytes->length, (size_t)1000000);
            size_t ncapacity = std::max(respBytes->length + grow, respPos + bsize);
            l_debug << L"grow buffer to new capacity=" << ncapacity;
            respBytes = BBytes::create(respBytes, ncapacity);
        }

        l_debug << L"copy bytes";
        memcpy(respBytes->data + respPos, bytes.data(), bsize);

        respPos += bsize;
        l_debug << L"received so far: #bytes=" << respPos;

    }

    virtual void httpTimeout() {
        l_debug << L"httpTimeout(";
        httpError(BException(EX_TIMEOUT, L"HTTP request timeout"));
        l_debug << L")httpTimeout";
    }

    virtual void httpError(const BException& ex) {
        l_debug << L"httpError(" << ex;
        if (!requestFinished && !requestAborted) {
            result = BVariant(ex);
            abort();
        }
        l_debug << L")httpError";
    }

    virtual void close() {
        l_debug << L"close(";
        if (!requestFinished) {
            httpError(BException(EX_CANCELLED, L"HTTP request cancelled"));
        }
        l_debug << L")close";
    }


};

class QTHttpGetStream : public HHttpGetStream, public virtual QTHttpRequest {

    byps_weak_ptr<QTHttpGetStream_ContentStream> stream_weak_ptr;
    bool headersApplied;
    static BLogger log;

public:
    QTHttpGetStream(PQTHttpClient httpClient, const std::wstring& url)
        : QTHttpRequest(httpClient, url)
        , headersApplied(false)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpGetStream() {
        l_debug << L"dtor()";
    }

    virtual PContentStream send() {
        l_debug << L"send(";
        byps_ptr<QTHttpGetStream_ContentStream> ret(new QTHttpGetStream_ContentStream(timeoutSeconds));
        this->stream_weak_ptr = ret;

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {
            l_debug << L"networkManager->get...";
            QNetworkRequest networkRequest(QUrl(QString::fromStdWString(surl)));
            httpClient->createGetRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &bridge);
            l_debug << L"networkManager->get OK";
        }

        l_debug << L")send";
        return ret;
    }

    byps_ptr<QTHttpGetStream_ContentStream> getStreamOrAbort() {
        l_debug << L"getStreamOrAbort(";
        byps_ptr<QTHttpGetStream_ContentStream> stream = stream_weak_ptr.lock();
        if (!stream && !bridge->reply->isFinished()) {
             abort();
        }
        l_debug << L")getStreamOrAbort=" << stream.get();
        return stream;
    }

    virtual void internalApplyResult() {
        l_debug << L"internalApplyResult(";
        byps_ptr<QTHttpGetStream_ContentStream> stream = getStreamOrAbort();
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
        byps_ptr<QTHttpGetStream_ContentStream> stream = getStreamOrAbort();
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

            byps_ptr<QTHttpGetStream_ContentStream> stream = getStreamOrAbort();
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

class QTHttpGet : public HHttpGet, public virtual QTHttpRequest {
    friend class QTHttpPostWorker;
    static BLogger log;
public:

    QTHttpGet(PQTHttpClient httpClient, const std::wstring& url)
        : QTHttpRequest(httpClient, url)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpGet() {
        l_debug << L"dtor()";
    }

    virtual void send(PAsyncResult asyncBytesReceived) {
        l_debug << L"send(";
         this->asyncBytesReceived = asyncBytesReceived;

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {
            l_debug << L"networkManager->post...";
            QNetworkRequest networkRequest(QUrl(QString::fromStdWString(surl)));
            httpClient->createGetRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &bridge);
            l_debug << L"networkManager->post OK";
        }

        l_debug << L")send";
    }

};


class QTHttpPost : public HHttpPost, public virtual QTHttpRequest {
    QByteArray* bytesToPost;
    friend class QTHttpPostWorker;
    static BLogger log;
public:

    QTHttpPost(PQTHttpClient httpClient, const std::wstring& url)
        : QTHttpRequest(httpClient, url)
        , bytesToPost(NULL)
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

        QNetworkRequest networkRequest(QUrl(QString::fromStdWString(surl)));
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

};

QTPutStreamIODevice::QTPutStreamIODevice(PContentStream strm, QObject* parent)
    : QIODevice(parent)
    , strm(strm) {
}

QTPutStreamIODevice::~QTPutStreamIODevice() {
    strm.reset();
}

bool QTPutStreamIODevice::open(OpenMode mode) {
    bool succ = ((mode & ~ReadOnly) != 0);
    if (succ) {
        setOpenMode(mode);
    }
    return succ;
}

void QTPutStreamIODevice::close() {
    strm.reset();
    setOpenMode(NotOpen);
}

bool QTPutStreamIODevice::isSequential() const {
    return false;
}

qint64 QTPutStreamIODevice::size() const {
    return strm->getContentLength();
}

qint64 QTPutStreamIODevice::bytesAvailable() const {
    return size();
}

qint64 QTPutStreamIODevice::readData(char* data, qint64 maxSize) {
    int32_t len = (int32_t)(maxSize & 0x7FFFFFFFF);
    return strm->read(data, 0, len);
}

qint64 QTPutStreamIODevice::writeData(const char* , qint64 ) {
    return -1;
}


class QTHttpPutStream : public HHttpPutStream, public virtual QTHttpRequest {
    PContentStream streamToPut;
    PAsyncResult asyncBoolFinished;
    int64_t partId;
    int64_t nbOfParts;
    int64_t totalLength;
    bool isLastPart;

    QTPutStreamIODevice* streamIO;

    QByteArray bytesToPut;
    void* data; // just for debugging QByteArray, i want to see, whether resize() changes the internal buffer

    PQTHttpRequest keepThisUntilLastPart;

    std::wstring baseUrl;
    friend class QTHttpPutStreamWorker;
    static BLogger log;
public:
    QTHttpPutStream(PQTHttpClient httpClient, const std::wstring& url)
        : QTHttpRequest(httpClient, url)
        , streamToPut(NULL)
        , asyncBoolFinished(NULL)
        , partId(0)
        , nbOfParts(0)
        , totalLength(0)
        , isLastPart(false)
        , streamIO(NULL)
        , data(NULL)
    {
        l_debug << L"ctor()";
    }

    virtual ~QTHttpPutStream() {
        l_debug << L"dtor()";
    }

    virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) {
        internalSendAsByteArray(strm, asyncBoolFinished);
    }

    void internalSendAsIODevice(PContentStream strm, PAsyncResult asyncBoolFinished) {
        int64_t contentLength = strm->getContentLength();
        l_debug << L"send(contentLength=" << contentLength << L", contentType=" << strm->getContentType();

        PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {

            this->asyncBoolFinished = asyncBoolFinished;
            this->streamToPut = strm;
            this->totalLength = contentLength;
            this->baseUrl = surl;
            this->streamIO = new QTPutStreamIODevice(strm);

            l_debug << L"header contentType=" << streamToPut->getContentType();
            l_debug << L"header contentLength=" << contentLength;
            QNetworkRequest networkRequest(QUrl(QString::fromStdWString(surl)));
            networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(streamToPut->getContentType())));
            networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)contentLength));
            networkRequest.setAttribute(QNetworkRequest::DoNotBufferUploadDataAttribute, QVariant(true));

            l_debug << L"networkManager->put...";
            httpClient->createPutStreamRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), streamIO, &bridge);
            l_debug << L"networkManager->put OK";
        }
        else {
            BException ex(EX_CANCELLED, L"HTTP client already deleted.");
            httpError(ex);
        }
    }

    void internalSendAsByteArray(PContentStream strm, PAsyncResult asyncBoolFinished) {
        int64_t contentLength = strm->getContentLength();
        l_debug << L"send(contentLength=" << contentLength << L", contentType=" << strm->getContentType();

        this->asyncBoolFinished = asyncBoolFinished;
        this->streamToPut = strm;
        this->totalLength = contentLength;
        this->baseUrl = surl;

        if (totalLength >= 0) {
            nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
            if (totalLength % MAX_STREAM_PART_SIZE) {
                nbOfParts++;
            }
        }
        else {
            nbOfParts = INT64_MAX;
        }

        keepThisUntilLastPart = shared_from_this();

        sendNextPart(0);
    }

    void sendNextPart(int64_t nextPartId) {
        l_debug << L"sendNextPart(nextPartId=" << nextPartId;

        this->partId = nextPartId;

         PQTHttpClient httpClient = getHttpClient();
        if (httpClient) {

            int32_t contentLength = 0;

            bytesToPut.clear();

            // Read stream part into buffer
            if (totalLength >= 0) {
                size_t capacity = std::min((size_t)totalLength, (size_t)MAX_STREAM_PART_SIZE);
                bytesToPut.resize(capacity);

                data = bytesToPut.data();
                l_debug << L"read from stream..." << (void*)data;
                contentLength = streamToPut->read((char*)data, 0, capacity);
                if (contentLength < 0) contentLength = 0; // true, if stream is empty
                l_debug << L"read from stream OK, #bytes=" << contentLength;
                isLastPart = partId >= nbOfParts-1; // nbOfParts might be 0
                l_debug << L"isLastPart=" << isLastPart;
            }
            else {
                size_t capacity = MAX_STREAM_PART_SIZE;
                bytesToPut.resize(capacity);

                data = bytesToPut.data();
                l_debug << L"read from stream..." << (void*)data;
                contentLength = streamToPut->read((char*)data, 0, capacity);
                l_debug << L"read from stream OK, #bytes=" << contentLength;
                if (contentLength < 0) contentLength = 0; // true, if stream is empty or stream size is a multiple of MAX_STREAM_PART_SIZE
                isLastPart = contentLength < MAX_STREAM_PART_SIZE;
                l_debug << L"isLastPart=" << isLastPart;
            }

            bytesToPut.resize(contentLength);
            data = bytesToPut.data();
            l_debug << L"buffer resized to contentLength, " << (void*)data;

            // Append partid, totallength to URL
            QString partUrl(QString::fromStdWString(baseUrl));
            partUrl.append("&partid=").append(QString::number(partId));
            partUrl.append("&total=").append(QString::number(totalLength));
            partUrl.append("&last=").append(QString::number(isLastPart));
            l_debug << L"partUrl=" << partUrl.toStdWString();

            l_debug << L"header contentType=" << streamToPut->getContentType();
            l_debug << L"header contentLength=" << contentLength;
            QNetworkRequest networkRequest(partUrl);
            networkRequest.setHeader(QNetworkRequest::ContentTypeHeader, QVariant(QString::fromStdWString(streamToPut->getContentType())));
            networkRequest.setHeader(QNetworkRequest::ContentLengthHeader, QVariant((qulonglong)contentLength));
            networkRequest.setAttribute(QNetworkRequest::DoNotBufferUploadDataAttribute, QVariant(true));

            l_debug << L"networkManager->put...";
            httpClient->createPutRequest(shared_from_this(), networkRequest, getTimeoutSeconds(), &bytesToPut, &bridge);
            l_debug << L"networkManager->put OK";

        }
        else {
            // httpClient is already released. This should not happend during the HTTP request.
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
        if (streamIO) {
            l_debug << L"stream was sent";
        }
        else {
            l_debug << L"isLastPart=" << isLastPart;
            if (isLastPart) {

                keepThisUntilLastPart.reset();

                if (!result.isException()) {
                    result = BVariant(true);
                }
                done();
            }
            else {

                sendNextPart(partId+1);
            }
        }
        l_debug << L")httpFinished";
    }

    virtual void httpError(const BException& ex) {

        keepThisUntilLastPart.reset();

        QTHttpRequest::httpError(ex);
    }

    virtual void httpReadyRead() {
        l_debug << L"httpReadyRead(";
        bridge->reply->readAll();
        l_debug << L")httpReadyRead";
    }

};

BINLINE QTHttpRequestBridge::QTHttpRequestBridge(QNetworkReply* reply, int32_t timeoutSeconds)
    : QObject(reply)
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

    if (timeoutSeconds) {

        QObject::connect(&timer, SIGNAL(timeout()),
                         this, SLOT(httpTimeout()));

        l_debug << L"start timer, timeoutSeconds=" << timeoutSeconds;
        timer.setSingleShot(true);
        timer.start(timeoutSeconds * 1000);
    }



    l_debug << L")ctor";
}

BINLINE QTHttpRequestBridge::~QTHttpRequestBridge() {
    l_debug << L"dtor(";
    //reply->deleteLater();
    l_debug << L")dtor";
}

BINLINE void QTHttpRequestBridge::httpFinished() {
    l_debug << L"httpFinished(";
    timer.stop();
    if (pThis) {
       pThis->httpFinished();
       pThis.reset();
    }
    reply->deleteLater();
    l_debug << L")httpFinished";
}

BINLINE void QTHttpRequestBridge::httpReadyRead() {
    l_debug << L"httpReadyRead(";
    if (pThis) {
        int32_t timeoutSeconds = pThis->getTimeoutSeconds();
        if (timeoutSeconds) {
            l_debug << L"restart timer, timeoutSeconds=" << timeoutSeconds;
            timer.stop();
            timer.start(timeoutSeconds * 1000);
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

BINLINE PHttpGetStream QTHttpClient::getStream(const std::wstring& url) {
    l_debug << L"getStream(" << url;
    QTHttpGetStream* req = new QTHttpGetStream(shared_from_this(), url);
    l_debug << L")getStream";
    return PHttpGetStream(req);
}

BINLINE PHttpGet QTHttpClient::get(const std::wstring& url) {
    l_debug << L"get(" << url;
    QTHttpGet* req = new QTHttpGet(shared_from_this(), url);
    l_debug << L")get";
    return PHttpGet(req);
}

BINLINE PHttpPost QTHttpClient::post(const std::wstring& url) {
    l_debug << L"post(" << url;
    QTHttpPost* req = new QTHttpPost(shared_from_this(), url);
    l_debug << L")post";
    return PHttpPost(req);
}

BINLINE PHttpPutStream QTHttpClient::putStream(const std::wstring& url) {
    l_debug << L"putStream(" << url;
    QTHttpPutStream* req = new QTHttpPutStream(shared_from_this(), url);
    l_debug << L")putStream";
    return PHttpPutStream(req);
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

BINLINE void QTHttpWorkerBridge::createPutStreamRequest(QNetworkRequest networkRequest, int32_t timeout, QIODevice* streamIO, QTHttpRequestBridge ** ppbridge)
{
    l_debug << L"createPutRequest(";
    QNetworkReply* reply = networkManager->put(networkRequest, streamIO);
    *ppbridge = new QTHttpRequestBridge(reply, timeout);
    l_debug << L")createPutRequest";
}


BLogger QTHttpGetStream_ContentStream::log("QTHttpGetStream_ContentStream");
BLogger QTHttpClient::log("QTHttpClient");
BLogger QTHttpRequest::log("QTHttpRequest");
BLogger QTHttpGetStream::log("QTHttpGetStream");
BLogger QTHttpPost::log("QTHttpPost");
BLogger QTHttpGet::log("QTHttpGet");
BLogger QTHttpPutStream::log("QTHttpPutStream");
BLogger QTHttpWorkerThread::log("QTHttpWorkerThread");
BLogger QTHttpRequestBridge::log("QTHttpRequestBridge");
BLogger QTHttpWorkerBridge::log("QTHttpWorkerBridge");

}}}


namespace byps { namespace http {

BINLINE PHttpClient HttpClient_create(void* app) {
    return PHttpClient(new byps::http::qthttp::QTHttpClient(app));
}

}}

#endif // QTHTTPCLIENT_HPP
