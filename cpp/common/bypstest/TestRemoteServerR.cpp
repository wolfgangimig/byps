#include "AllTests.h"
#include <chrono>
#include <thread>

using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::srvr;

class ClientIFImpl : public BSkeleton_ClientIF {
	static BLogger log;
public:
	const static int vi = 100;
	virtual int32_t incrementInt(int32_t a) {
		int32_t r = a+1;
		l_info << L"incrementInt(" << a << L")=" << r;
		return r;
	}
};

BLogger ClientIFImpl::log("ClientIFImpl");

class ClientIFImplThrowEx : public BSkeleton_ClientIF {
public:
	const static int code = 1111;
	virtual int32_t incrementInt(int32_t a) {
		throw BException(code);
	}
};

class ClientIFImplPutStreams : public BSkeleton_ClientIF {
	static BLogger log;
public:
	virtual void putStreams(const byps_ptr< std::vector< PContentStream > >& vecR, int32_t ctrl) {
		l_info << L"putStreams(";
		try {
			byps_ptr< std::vector< PContentStream > > vec = TestUtilHttp::makeTestStreams();
			TASSERT(L"#streams", vec->size(), vecR->size());

			for (unsigned i = 0; i < vec->size(); i++) {
				PContentStream strm = (*vec)[i];
				PContentStream strmR = (*vecR)[i];
				l_info << L"compare stream, contentLength=" << strmR->getContentLength();
				TestUtilHttp::tassert(__FILE__, __LINE__, L"stream", strm, strmR);
			}
		}
		catch (const std::exception& e) {
			throw BException(e);
		}
		l_info << L")putStreams";
	}
};

BLogger ClientIFImplPutStreams::log("ClientIFImplPutStreams");

class TestRemoteServerR : public TestBase {
	static BLogger log;
public:
	TestRemoteServerR(void* app) : TestBase(app) {}

	/**
	 * Call a server function which in turn calls a client function.
	 */
	void testCallClientFromServer() {
		l_info << L"testCallClientFromServer(";

		client->addRemote(PSkeleton_ClientIF(new ClientIFImpl()));

		PServerIF r = client->serverIF;
		l_info << L"callClientIncrementInt...";
		int ret = r->callClientIncrementInt(5);
		l_info << L"callClientIncrementInt OK";

		TASSERT(L"callClientIncrementInt failed.", 6, ret);

		l_info << L")testCallClientFromServer";
	}

	/**
	 * The server tries to use a non-existing client interface implementation.
	 * This must cause an exception. The call must not hang.
	 */
	void testCallClientFromServerNoRemoteImpl() {
		l_info << L"testCallClientFromServerNoRemoteImpl(";

		client->addRemote(PSkeleton_ClientIF());
		PServerIF r = client->serverIF;
		try {
			l_info << L"callClientIncrementInt...";
            r->callClientIncrementInt(5);
			TFAIL(L"callClientIncrementInt must fail.");
		}
		catch (const BException& ex) {
			TASSERT(L"Wrong exepction", EX_SERVICE_NOT_IMPLEMENTED, ex.getCode());
		}

		l_info << L")testCallClientFromServerNoRemoteImpl";
	}

	/**
	 * Call a server function which in turn calls a client function many times simultaneously.
	 */
	void testCallClientFromServerParallel() {
		l_info << L"testCallClientFromServerParallel(";

		client->addRemote(PSkeleton_ClientIF(new ClientIFImpl()));
		
		PServerIF r = client->serverIF;
		l_info << L"callClientParallel...";
		int ret = r->callClientParallel(10);
		l_info << L"callClientParallel OK, ret=" << ret;
		
		TASSERT(L"callClientParallel failed.", 10, ret);
		
		l_info << L")testCallClientFromServerParallel";
	}

	void testCallClientFromClient() {
		
		// Interface implementation for the second client
		PSkeleton_ClientIF partner = PSkeleton_ClientIF(new ClientIFImpl());
		
		// Create second client
		PClient_Testser client2 = TestUtilHttp::createClient(app);
		client2->addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		l_info << "setPartner...";
		client->serverIF->setPartner(partner);
		l_info << "setPartner OK";
		
		// First client queries the interface of the second client from the server side
		l_info << "getPartner...";
		PClientIF partnerIF = client->serverIF->getPartner();
		l_info << "setPartner...";

		// Invoke interface of second client.
		int r = partnerIF->incrementInt(7);
		TASSERT(L"incrementInt", 8, r);
		
		client->serverIF->setPartner(PClientIF());
		client2->done();
		
	}

	void testCallClient2FromServer1() {
	
		client->serverIF->setPartner(PClientIF());
		PServerIF remote = client->serverIF;

		// Interface implementation for the second client
		PSkeleton_ClientIF partner = PSkeleton_ClientIF(new ClientIFImpl());
		
		// Create second client
		PClient_Testser client2 = TestUtilHttp::createClient(app);
		client2->addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		l_info << "setPartner...";
		client->serverIF->setPartner(partner);
		l_info << "setPartner OK";
		
		// Invoke interface of second client from the server.
		int r = remote->callClientIncrementInt(7);
		TASSERT(L"incrementInt", 8, r);
		
		client->serverIF->setPartner(PClientIF());
		client2->done();
		
	}

	void testCallClientFromClientThrowEx() {
		
		PSkeleton_ClientIF partner(new ClientIFImplThrowEx());
		
		PClient_Testser client2 = TestUtilHttp::createClient(app);
		client2->addRemote(partner);
		
		client->serverIF->setPartner(partner);
		
		PClientIF partnerIF = client->serverIF->getPartner();
		try {
			partnerIF->incrementInt(7);
		}
		catch (BException e) {
            l_info << L"OK, exception=" << e.toString();
			TASSERT(L"exception", ClientIFImplThrowEx::code, e.getCode());
		}

		client->serverIF->setPartner(PSkeleton_ClientIF());
		client2->done();
	}

	void testCallDeadClientFromClient() {
		
		PSkeleton_ClientIF partner(new ClientIFImpl());
		
		l_info << "create second client";
		PClient_Testser client2 = TestUtilHttp::createClient(app);
		client2->addRemote(partner);
		
		l_info << "submit interface of second client";
		client->serverIF->setPartner(partner);
				
		l_info << "receive interface of second client";
		PClientIF partnerIF = client->serverIF->getPartner();
		
		// stop second client
		l_info << "stop second client";
		client2->done();
		
		// The done() method throws BException.CANCELED messages inside the server.
		// If the next call came too early, it would be canceled by this exceptions
		// and the test would fail because it expects an exception code BException.CLIENT_DIED.
		std::this_thread::sleep_for(std::chrono::milliseconds(1000));
		
		// first client calls interface method of second client
		try {
			l_info << "invoke interface method of dead client";
			partnerIF->incrementInt(7);
			TASSERT(L"Exception expected", true, false);
		}
        catch (const BException& e) {
            l_info << L"OK, exception=" << e.toString();
			TASSERT(L"Exception", EX_CLIENT_DIED, e.getCode());
		}
	}


	void testCallKilledClientFromClient() {
		

		l_info << "client.targetId=" << client->transport->getTargetId().toString();
		
		l_info << "create second client";
		PClient_Testser client2 = TestUtilHttp::createClient(app);
		BTargetId targetId2 = client2->transport->getTargetId();
		l_info << "client2.targetId=" << targetId2.toString();

		// Add interface impl to client2
		PSkeleton_ClientIF partner(new ClientIFImpl());
		client2->addRemote(partner);
		BTargetId targetIdPartner = partner->BRemote_getTargetId();
		l_info << "partner.targetId=" << targetIdPartner.toString();

		// client2 and partner must have the same targetId
		TASSERT(L"TargetId", targetId2, targetIdPartner);

		l_info << "submit interface of second client";
		client->serverIF->setPartner(partner);
				
		l_info << "receive interface of second client";
		PClientIF partnerIF = client->serverIF->getPartner();
		BTargetId targetIdPartnerIF = partnerIF->BRemote_getTargetId();
		l_info << "partnerIF.targetId=" << targetIdPartnerIF.toString();

		// partner and partnerIF must have the same targetId
		TASSERT(L"targetIdPartner == targetIdPartnerIF", targetIdPartner, targetIdPartnerIF);

		// stop second client
		l_info << "stop second client";
		client2->transport->wire->getTestAdapter()->killClientConnections();
		
		// first client calls interface method of second client
		try {
            l_info << L"invoke interface method of dead client";
            int32_t ret = partnerIF->incrementInt(7);
            l_info << L"ret=" << ret;
			TASSERT(L"Exception expected", true, false);
		}
        catch (const BException& e) {
            l_info << L"OK, exception=" << e.toString();
			TASSERT(L"Exception", EX_CLIENT_DIED, e.getCode());
		}

        client2->done();
	}

	/**
	 * Server calls a client interface and sends InputStreams.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	void testServerProvidesStreamForClient() {
		
		// (1) Provide implementation for interface ClientIF
		client->addRemote(PSkeleton_ClientIF(new ClientIFImplPutStreams()));
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// registered in step (1)
		l_info << "call client...";
		byps_ptr<std::vector<PContentStream> > arr = TestUtilHttp::makeTestStreams();
		client->serverIF->putStreamsOnClient(arr);
		l_info << "call client OK";
		
		
	}

	virtual void init() {
        ADD_TEST(testCallClientFromServer);
        ADD_TEST(testCallDeadClientFromClient);
        ADD_TEST(testCallClientFromClientThrowEx);
        ADD_TEST(testCallClientFromServerNoRemoteImpl);
        ADD_TEST(testCallClientFromClient);
        ADD_TEST(testCallClient2FromServer1);
        ADD_TEST(testCallClientFromServerParallel);
        ADD_TEST(testServerProvidesStreamForClient);
        ADD_TEST(testCallKilledClientFromClient);
    }

};

BLogger TestRemoteServerR::log(__FILE__);

TestCase* TestRemoteServerR_create(void* app) {
	return new TestRemoteServerR(app);
}
