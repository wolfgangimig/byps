/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTRANSPORT_HPP_
#define BTRANSPORT_HPP_

#include "BTransport.h"

namespace byps {

  using namespace std::chrono;

  BINLINE BTransport::BTransport(PApiDescriptor apiDesc, const PWire& wire, const PRemoteRegistry &remoteRegistry)
    : wire(wire)
    , remoteRegistry(remoteRegistry)
    , apiDesc(apiDesc)
    , protocol(PProtocol())
    , connectedServerId(0)
  {
  }

  BINLINE BTransport::BTransport(const BTransport &rhs, const BTargetId &targetId)
    : wire(rhs.wire)
    , remoteRegistry(rhs.remoteRegistry)
    , apiDesc(rhs.apiDesc)
    , protocol(rhs.protocol)
    , targetId(targetId)
    , connectedServerId(rhs.targetId.getServerId())
  {
  }

  BINLINE BTransport::~BTransport() {
  }

  BINLINE int32_t BTransport::getConnectedServerId() {
    return connectedServerId;
  }

  BINLINE POutput BTransport::getOutput() {

    PTransport pthis = shared_from_this();
    if (!pthis) throw BException(BExceptionC::CANCELLED);

    return getProtocol()->getOutput(pthis, BMessageHeader());
  }

  BINLINE POutput BTransport::getResponse(BMessageHeader& requestHeader) {

    PTransport pthis = shared_from_this();
    if (!pthis) throw BException(BExceptionC::CANCELLED);

    BMessageHeader responseHeader(requestHeader);
    responseHeader.flags |= BHEADER_FLAG_RESPONSE;
    return getProtocol()->getOutput(pthis, responseHeader);
  }

  BINLINE PInput BTransport::getInput(BMessageHeader& header, PBytes& buf) {
    return getProtocol()->getInput(shared_from_this(), header, buf);
  }

  BINLINE BTargetId BTransport::getTargetId() {
    byps_unique_lock lock(mtx);
    return targetId;
  }

  BINLINE void BTransport::setTargetId(BTargetId targetId) {
    byps_unique_lock lock(mtx);
    this->targetId = targetId;
    this->connectedServerId = targetId.getServerId();
  }

  BINLINE string BTransport::getSessionId() {
    byps_unique_lock lock(mtx);
    return sessionId;
  }

  BINLINE void BTransport::setSessionId(const string& sessionId) {
    byps_unique_lock lock(mtx);
    this->sessionId = sessionId;
  }

  BINLINE PProtocol BTransport::getProtocol() {
    byps_unique_lock lock(mtx);
    return protocol;
  }

  BINLINE PWire BTransport::getWire() {
    return wire;
  }

  BINLINE PRemoteRegistry BTransport::getRemoteRegistry() {
    return remoteRegistry;
  }

  BINLINE PApiDescriptor BTransport::getApiDesc() {
    return apiDesc;
  }

  class BTransport_ReloginAndRetrySend;
  typedef BTransport_ReloginAndRetrySend* PTransport_BAsyncOuterResult;

  class BTransport_ReloginAndRetrySend : public BAsyncResult {
    PTransport transport;
    PSerializable requestObject;
    PAsyncResult innerResult;
  public:
    BTransport_ReloginAndRetrySend(PTransport transport, PSerializable requestObject, PAsyncResult innerResult)
      : transport(transport)
      , requestObject(requestObject)
      , innerResult(innerResult)
    {
    }

    virtual void setAsyncResult(const BVariant& result) {
      try {
        if (result.isException()) {
          innerResult->setAsyncResult(result);
        }
        else {
          transport->assignSessionThenSendMethod(requestObject, innerResult);
        }
      }
      catch (const exception& ex) {
        innerResult->setAsyncResult(BVariant(ex));
      }
      delete this;
    }

  };

  class BTransport_MyNegoAsyncResult : public BAsyncResult {
  public:
    PTransport transport;
    PAsyncResult innerResult;

    BTransport_MyNegoAsyncResult(PTransport transport, const PAsyncResult& innerResult)
      : transport(transport), innerResult(innerResult) {
    }
    virtual ~BTransport_MyNegoAsyncResult() {
    }

    virtual void setAsyncResult(const BVariant& result) {
      try {
        if (result.isException()) {
          innerResult->setAsyncResult(result);
        }
        else {
          POBJECT obj;
          result.get(obj);
          PMessage msg = byps_static_ptr_cast<BMessage>(obj);

          BNegotiate nego;
          nego.read(msg->buf);
          {
            byps_unique_lock lock(transport->mtx);
            transport->protocol = transport->createNegotiatedProtocol(nego);
            transport->targetId = nego.targetId;
            transport->connectedServerId = nego.targetId.getServerId();
            transport->sessionId = nego.sessionId;
          }

          transport->internalAuthenticate(innerResult);
        }
      }
      catch (const exception& ex) {
        innerResult->setAsyncResult(BVariant(ex));
      }
      delete this;
    }

  };

  class BTransport_DeserlializeMethodResultMaybeRelogin : public BAsyncResult {
    PTransport transport;
    PSerializable requestObject;
    PAsyncResult innerResult;
  public:
    BTransport_DeserlializeMethodResultMaybeRelogin(PTransport transport, PSerializable requestObject, PAsyncResult innerResult)
      : transport(transport)
      , requestObject(requestObject)
      , innerResult(innerResult)
    {
    }

    virtual ~BTransport_DeserlializeMethodResultMaybeRelogin() {}

    virtual void setAsyncResult(const BVariant& result) {
      bool relogin = false;

      try {
        if (result.isException()) {
          relogin = internalIsReloginException(result.getException());
          if (!relogin) {
            innerResult->setAsyncResult(BVariant(result.getException()));
          }
        }
        else {
          try {
            POBJECT obj;
            result.get(obj);
            if (obj) {
              PMessage msg = byps_static_ptr_cast<BMessage>(obj);

              PInput inp = transport->getInput(msg->header, msg->buf);
              PSerializable sobj = inp->load();
              innerResult->setAsyncResult(BVariant(sobj));
            }
            else {
              BException ex(BExceptionC::CORRUPT, L"Missing message object in result.");
              innerResult->setAsyncResult(BVariant(ex));
            }
          }
          catch (const BException& e) {
            relogin = internalIsReloginException(e);
            if (!relogin) {
              innerResult->setAsyncResult(BVariant(e));
            }
          }
        }

        if (relogin) {
          transport->loginAndRetrySend(requestObject, innerResult);
        }
      }
      catch (const exception& ex) {
        innerResult->setAsyncResult(BVariant(ex));
      }

      delete this;
    }

  private:
    bool internalIsReloginException(BException e) {
      BTYPEID typeId = requestObject->BSerializable_getTypeId();
      return transport->internalIsReloginException(e, typeId);
    }

  };

  BINLINE void BTransport::loginAndRetrySend(const PSerializable& requestObject, const PAsyncResult& asyncResult) {
    // Cancel long-polls.
    // They will be restarted over negotiateProtocolClient and BClient::authentication.
    wire->cancelAllRequests();

    PAsyncResult loginResult(new BTransport_ReloginAndRetrySend(shared_from_this(), requestObject, asyncResult));

    negotiateProtocolClient(loginResult);
  }


  BINLINE void BTransport::negotiateProtocolClient(PAsyncResult asyncResult) {
    PTransport pthis = shared_from_this();
    if (!pthis) return;

    PBytes bytes = BBytes::create(NEGOTIATE_MAX_SIZE);
    BNegotiate nego(apiDesc);
    nego.version = apiDesc->version;
    nego.write(bytes);

    PAsyncResult outerResult = new BTransport_MyNegoAsyncResult(pthis, asyncResult);

    BMessageHeader header;
    header.messageId = wire->makeMessageId();
    vector<PContentStream> streams;
    PMessage msg(new BMessage(header, bytes, streams));

    wire->send(msg, outerResult);
  }

  BINLINE PProtocol BTransport::negotiateProtocolServer(const BTargetId& targetId, PBytes& buf, PAsyncResult asyncResult) {
    try {
      bool succ = BNegotiate::isNegotiateMessage(buf);
      if (succ) {
        BNegotiate nego;
        nego.read(buf);

        {
          byps_unique_lock lock(mtx);
          protocol = createNegotiatedProtocol(nego);
          this->targetId = targetId;
          this->sessionId = targetId.toSessionId();
        }

        PBytes bytes = BBytes::create(NEGOTIATE_MAX_SIZE);
        nego.targetId = targetId;
        nego.sessionId = sessionId;
        nego.write(bytes);

        asyncResult->setAsyncResult(BVariant(bytes));
      }
    }
    catch (const exception& ex) {
      asyncResult->setAsyncResult(BVariant(ex));
    }
    return protocol;
  }

  BINLINE PProtocol BTransport::createNegotiatedProtocol(BNegotiate& nego) {
    PProtocol protocol;

    if (nego.protocols.size() == 0) {
      throw BException(BExceptionC::CORRUPT, L"Protocol negotiation failed. Cannot detect protocol.");
    }

    if (nego.protocols.find(BBinaryModel::MEDIUM().getProtocolId()) != string::npos) {
      int32_t negotiatedBypsVersion = min(nego.bversion, BHEADER_BYPS_VERSION_CURRENT);
      BVERSION negotiatedVersion = min(nego.version, apiDesc->version);
      protocol = PProtocol(new BProtocol(apiDesc, negotiatedBypsVersion, negotiatedVersion, nego.byteOrder));
      nego.protocols = BBinaryModel::MEDIUM().getProtocolId();
      nego.version = negotiatedVersion;
    }
    else {
      throw BException(BExceptionC::CORRUPT, L"Protocol negotiation failed. Cannot detect protocol.");
    }
    return protocol;
  }

  BINLINE PProtocol BTransport::detectProtocolFromInputBuffer(const PBytes&) {
    return PProtocol();
  }

  BINLINE void BTransport::sendMethod(const PMethodRequest& methodRequest, PAsyncResult asyncResult) {
    assignSessionThenSendMethod(methodRequest, asyncResult);
  }

  BINLINE void BTransport::send(const PSerializable& obj, PAsyncResult asyncResult) {

    PTransport pthis = shared_from_this();
    if (!pthis) throw BException(BExceptionC::CANCELLED);

    try {
      POutput outp = getOutput();
      outp->store(obj);

      PAsyncResult outerResult = new BTransport_DeserlializeMethodResultMaybeRelogin(pthis, obj, asyncResult);

      PMessage msg = outp->toMessage();

      wire->send(msg, outerResult);

    }
    catch (const exception& ex) {
      asyncResult->setAsyncResult(BVariant(ex));
    }
  }

  class BTransport_AssingSessionThenSendMethod : public BAsyncResult {
    PTransport pTransport;
    PSerializable requestObject;
    PAsyncResult asyncResult;
  public:
    BTransport_AssingSessionThenSendMethod(PTransport pTransport, PSerializable requestObject, PAsyncResult asyncResult)
      : pTransport(pTransport), requestObject(requestObject), asyncResult(asyncResult) {
    }
    virtual void setAsyncResult(const BVariant& result) {
      if (result.isException()) {
        asyncResult->setAsyncResult(result);
      }
      else {
        PMethodRequest methodRequest = byps_ptr_cast<BMethodRequest>(requestObject);
        if (methodRequest) {
          PSerializable session;
          result.get(session);
          methodRequest->setSession(session);
        }
        pTransport->send(methodRequest, asyncResult);
      }
      delete this;
    }
  };

  BINLINE void BTransport::assignSessionThenSendMethod(const PSerializable& requestObject, const PAsyncResult& asyncResult) {
    if (this->authentication) {
      try {
        BTYPEID typeId = getObjectTypeId(requestObject);
        PAsyncResult sessionResult(new BTransport_AssingSessionThenSendMethod(shared_from_this(), requestObject, asyncResult));
        this->authentication->getSession(PClient(), typeId, sessionResult);
      }
      catch (const BException& ex) {
        asyncResult->setAsyncResult(BVariant(ex));
      }
    }
    else {
      this->send(requestObject, asyncResult);
    }
  }

  BINLINE BTYPEID BTransport::getObjectTypeId(const PSerializable& ser)
  {
    BTYPEID typeId = 0;
      const BSerializable* pser = ser.get();
      const type_info& tinfo = typeid(*pser);
    getProtocol()->getRegistry()->getSerializer(tinfo, typeId);
    return typeId;
  }

  class BTransport_MethodResult : public BAsyncResult {
    POutput outp;
    PAsyncResult innerResult;
  public:
    BTransport_MethodResult(POutput outp, PAsyncResult innerResult)
      : outp(outp), innerResult(innerResult) {
    }
    virtual void setAsyncResult(const BVariant& var) {
      try {
        if (var.isException()) {
          outp->setException(var.getException());
        }
        else {
          PSerializable obj;
          var.get(obj);
          outp->store(obj);
        }
        PMessage msg = outp->toMessage();

        innerResult->setAsyncResult(BVariant(msg));
      }
      catch (const exception& ex) {
        innerResult->setAsyncResult(BVariant(ex));
      }
      delete this;
    }
  };

  BINLINE void BTransport::recv(PServer server, PMessage message, PAsyncResult asyncResult) {

    PInput bin = getInput(message->header, message->buf);
    PSerializable methodObject = bin->load();

    POutput bout = getResponse(bin->header);
    PAsyncResult methodResult(new BTransport_MethodResult(bout, asyncResult));

    BTargetId clientTargetId = bin->header.targetId;
    server->recv(clientTargetId, methodObject, methodResult);

  }

  BINLINE bool BTransport::internalIsReloginException(BException ex, BTYPEID typeId) {
    bool ret = false;

    if (authentication && ex) {
      ret = authentication->isReloginException(PClient(), ex, typeId);
    }

    return ret;
  }

  BINLINE bool BTransport::isReloginException(BException ex, int) {
    bool ret = false;

    // Check exception
    if (ex)
    {
      ret = ex.getCode() == BExceptionC::UNAUTHORIZED;
    }

    return ret;
  }

  BINLINE void BTransport::internalAuthenticate(PAsyncResult innerResult) {

    if (authentication) {
      authentication->authenticate(PClient(), innerResult);
    }
    else {
      innerResult->setAsyncResult(BVariant(true));
    }
  }

  BINLINE void BTransport::setAuthentication(const PAuthentication& auth) {
    byps_unique_lock lock(mtx);
    authentication = auth;
  }

  BINLINE bool BTransport::hasAuthentication() {
    byps_unique_lock lock(mtx);
    return authentication != NULL;
  }


}



#endif
