/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTRANSPORT_H_
#define BTRANSPORT_H_

#include "Byps.h"

namespace byps {

  class BTransport : public byps_enable_shared_from_this<BTransport> {
  public:
    const static unsigned RETRY_AUTHENTICATION_AFTER_MILLIS = 1 * 1000;

    BTransport(PApiDescriptor apiDesc, const PWire& wire, const PRemoteRegistry& remoteRegistry);
    BTransport(const BTransport& rhs, const BTargetId& targetId);
    virtual ~BTransport();

    virtual PWire getWire();
    virtual PRemoteRegistry getRemoteRegistry();
    virtual PApiDescriptor getApiDesc();

    POutput getOutput();
    POutput getResponse(BMessageHeader& requestHeader);
    PInput getInput(BMessageHeader& header, PBytes &buf);

    BTargetId getTargetId();
    void setTargetId(BTargetId targetId);
    string getSessionId();
    void setSessionId(const string& sessionId);
    int32_t getConnectedServerId();

    PProtocol getProtocol();

    void sendMethod(const PMethodRequest& methodRequest, PAsyncResult asyncResult);
    void send(const PSerializable& obj, PAsyncResult asyncResult);
    void recv(PServer server, PMessage message, PAsyncResult asyncResult);

    void negotiateProtocolClient(PAsyncResult asyncResult);
    PProtocol negotiateProtocolServer(const BTargetId& targetId, PBytes& buf, PAsyncResult asyncResult);

    bool isReloginException(BException ex, int typeId);

  protected:
    PProtocol createNegotiatedProtocol(BNegotiate& nego);
    PProtocol detectProtocolFromInputBuffer(const PBytes& buf);
    bool internalIsReloginException(BException ex, BTYPEID typeId);
    void internalAuthenticate(PAsyncResult asyncResult);

    PWire wire;
    PRemoteRegistry remoteRegistry;
    PApiDescriptor apiDesc;
    PProtocol protocol;
    BTargetId targetId;
    string sessionId;
    int32_t connectedServerId;
    PAuthentication authentication;
    byps_mutex mtx;

    void setAuthentication(const PAuthentication& auth);
    bool hasAuthentication();

    void assignSessionThenSendMethod(const PSerializable& requestObject, const PAsyncResult& asyncResult);
    void loginAndRetrySend(const PSerializable& requestObject, const PAsyncResult& asyncResult);
    BTYPEID getObjectTypeId(const PSerializable& ser);

    friend class BTransport_DeserlializeMethodResultMaybeRelogin;
    friend class BTransport_InternalAuthenticate_BAsyncResult;
    friend class BTransport_MyNegoAsyncResult;
    friend class BTransport_ReloginAndRetrySend;
    friend class BClient;

    // Declare BOutput, BInput as friend class to be able to access targetId
    // without byps_unique_lock via getOutput() { getProtocol() { getOutput(transport, ...) { transport->targetId
    friend class BOutput;
    friend class BInput;
  };

}



#endif
