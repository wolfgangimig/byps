/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTRANSPORT_H_
#define BTRANSPORT_H_

#include "Byps.h"

namespace byps {

class BTransport : public byps_enable_shared_from_this<BTransport> {
public:
    const PWire wire;
    const PRemoteRegistry remoteRegistry;
    const PApiDescriptor apiDesc;

    BTransport(PApiDescriptor apiDesc, const PWire& wire, const PRemoteRegistry& remoteRegistry);
    BTransport(const BTransport& rhs, const BTargetId& targetId);
	virtual ~BTransport();

    POutput getOutput();
    POutput getResponse(BMessageHeader& requestHeader);
    PInput getInput(BMessageHeader& header, PBytes &buf);

    BTargetId getTargetId();
    void setTargetId(BTargetId targetId);

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

    PProtocol protocol;
    BTargetId targetId;
	PAuthentication authentication;

    byps_mutex mtx;

	std::chrono::system_clock::time_point lastAuthenticationTime;
	std::vector<PAsyncResult> asyncResultsWaitingForAuthentication;
	BException lastAuthenticationException;
	void setAuthentication(PAuthentication auth, bool onlyIfNull);
	void assignSessionThenSendMethod(PSerializable requestObject, PAsyncResult asyncResult);
	void loginAndRetrySend(PSerializable requestObject, PAsyncResult asyncResult);
	BTYPEID getObjectTypeId(PSerializable ser);

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
