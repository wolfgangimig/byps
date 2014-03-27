/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HSERVERR_HPP_
#define HSERVERR_HPP_

#include "HServerR.h"

namespace byps { namespace http {

using namespace byps;

class HServerR_LongPoll;
typedef byps_ptr<HServerR_LongPoll> PServerR_LongPoll;
class HServerR_SendLongPoll;
typedef byps_ptr<HServerR_SendLongPoll> PServerR_SendLongPoll;

class HServerR_SendLongPoll : public byps_enable_shared_from_this<HServerR_SendLongPoll> {

	byps_mutex mutex;
	byps_condition_variable serverFinished;
	bool isDone;
	int32_t sleepMillisBeforeRetry;


	PLostConnectionHandler lostConnectionHandler;
	friend class HServerR;

public:
    byps_atomic<int32_t> nbOfActiveLongPolls;

	HServerR_SendLongPoll() 
		: isDone(false)
		, sleepMillisBeforeRetry(60 * 1000)
        , lostConnectionHandler(NULL)
        , nbOfActiveLongPolls(0) {
    }

	bool waitBeforeRetry() {
		byps_unique_lock lock(mutex);
		if (isDone) return true;
		std::chrono::milliseconds timeout(sleepMillisBeforeRetry);
		return !serverFinished.wait_for(lock, timeout, [this]() { return isDone; });
	}

	void done() {
		byps_unique_lock lock(mutex);
		isDone = true;
		serverFinished.notify_all();
	}

    void send(PTransport transport, PServer server, PMessage methodResult);

	void onLostConnection(const BException& ex, PTransport transport, PServer server);
};

class HServerR_LongPoll {
	PServerR_SendLongPoll sendLongPoll;
	PTransport transport;
	PServer server;
	PMessage methodResult;

	class NextAsyncResult : public BAsyncResult {
		byps_weak_ptr<HServerR_SendLongPoll> sendLongPoll;
		byps_weak_ptr<BTransport> transport;
		byps_weak_ptr<BServer> server;
	public:
		NextAsyncResult(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server) 
			: sendLongPoll(sendLongPoll), transport(transport), server(server) {
            sendLongPoll->nbOfActiveLongPolls++;
		}

        virtual ~NextAsyncResult() {
			PServerR_SendLongPoll sendLongPoll = this->sendLongPoll.lock();
			if (sendLongPoll) {
	            sendLongPoll->nbOfActiveLongPolls--;
			}
        }

		virtual void setAsyncResult(const BVariant& varmsg) {
			PServerR_SendLongPoll sendLongPoll = this->sendLongPoll.lock();
			PTransport transport = this->transport.lock();
			PServer server = this->server.lock();
			if (sendLongPoll && transport && server) {

				PMessage msg;
				if (varmsg.isException()) {
					POutput outp = transport->getOutput();
					outp->header.flags = BHEADER_FLAG_RESPONSE;
					outp->setException(varmsg.getException());
					msg = outp->toMessage();
				}
				else {
					POBJECT obj;
					varmsg.get(obj);
					msg = byps_static_ptr_cast<BMessage>(obj);
				}
				sendLongPoll->send(transport, server, msg);
			}

			delete this;
		}
	};

	class NextAsyncMethod : public BAsyncResult {
		byps_weak_ptr<HServerR_SendLongPoll> sendLongPoll;
		byps_weak_ptr<BTransport> transport;
		byps_weak_ptr<BServer> server;
	public:
		NextAsyncMethod(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server) 
			: sendLongPoll(sendLongPoll), transport(transport), server(server) {
		}

        virtual ~NextAsyncMethod() {
            sendLongPoll.reset();
            transport.reset();
            server.reset();
        }

		virtual void setAsyncResult(const BVariant& varmsg) {
			PServerR_SendLongPoll sendLongPoll = this->sendLongPoll.lock();
			PTransport transport = this->transport.lock();
			PServer server = this->server.lock();
			if (sendLongPoll && transport && server) {

				bool failed = varmsg.isException();
				if (failed) {

					BException ex = varmsg.getException();
					switch (ex.getCode()) {

					case BExceptionC::SESSION_CLOSED: // Session was invalidated.
					case BExceptionC::UNAUTHORIZED: // Re-login required
					case BExceptionC::CANCELLED:
						// no retry
						break;
                
					case BExceptionC::RESEND_LONG_POLL:
						// HWireClientR has released the expried long-poll.
						// Ignore the error and send a new long-poll.
						sendLongPoll->send(transport, server, PMessage());
						break;
                
					default:
						sendLongPoll->onLostConnection(ex, transport, server);
						break;
					}

				}
				else {
					POBJECT obj;
					varmsg.get(obj);
					PMessage msg = byps_static_ptr_cast<BMessage>(obj);
					NextAsyncResult* asyncResult = new NextAsyncResult(sendLongPoll, transport, server);
					transport->recv(server, msg, asyncResult);
				}
			}

			delete this;
		}
	};


public:
	
	HServerR_LongPoll(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server, PMessage methodResult) 
		: sendLongPoll(sendLongPoll), transport(transport), server(server), methodResult(methodResult) {
					
		if (!methodResult) {
			POutput outp = transport->getOutput();
			outp->header.flags |= BHEADER_FLAG_RESPONSE;
			outp->store(PSerializable());
			this->methodResult = outp->toMessage();
		}
	}

	virtual ~HServerR_LongPoll() {
		sendLongPoll.reset();
	}

	void run() {

		NextAsyncMethod* nextMethod = new NextAsyncMethod(sendLongPoll, transport, server);
		transport->getWire()->sendR(methodResult, nextMethod);

	}
};

BINLINE HServerR::HServerR(PTransport transport, PServer server, int nbOfConns) 
	: BServerR(transport, server)
	, nbOfConns(nbOfConns)
	, sendLongPoll(new HServerR_SendLongPoll()) {
}

BINLINE HServerR::~HServerR() {
}

BINLINE void HServerR::start() {
	for (int i = 0; i < nbOfConns; i++) {
		sendLongPoll->send(transport, server, PMessage());
	}

}

BINLINE void HServerR::done() {
	sendLongPoll->done();
}

BINLINE void HServerR::setLostConnectionHandler(PLostConnectionHandler lostConnectionHandler) {
	sendLongPoll->lostConnectionHandler = lostConnectionHandler;
}

BINLINE void HServerR_SendLongPoll::send(PTransport transport, PServer server, PMessage methodResult) {
	if (!isDone) {
        HServerR_LongPoll longPoll(shared_from_this(), transport, server, methodResult);
        longPoll.run();
	}
}

//class MyThread {
//public:
//	
//	virtual void run() {
//	}
//
//	static MyThread* start() {
//		byps_unique_lock(mtx);
//
//		for (size_t i = 0; i < stoppedThreads.size(); i++) {
//			delete stoppedThreads[i];
//		}
//		stoppedThreads.clear();
//
//		MyThread* t = new MyThread();
//		t->std_thread = new std::thread(threadFunct, t);
//	}
//
//	void join() {
//	}
//
//private:
//	virtual ~MyThread() {
//	}
//
//	std::thread* std_thread;
//	static byps_mutex mtx;
//	static vector<MyThread*> stoppedThreads;
//
//	static void threadFunct(MyThread* pThread) {
//
//		try {
//			pThread->run();
//		}
//		catch (...) {}
//
//		{
//			byps_unique_lock lock(mtx);
//			stoppedThreads.push_back(pThread);
//		}
//	}
//};

BINLINE void lostConnection(PLostConnectionHandler lostConnectionHandler, BException ex) {
	try {
		lostConnectionHandler->onLostConnection(ex);
	}
	catch (...) {}
}

BINLINE void HServerR_SendLongPoll::onLostConnection(const BException& ex, PTransport transport, PServer server) {
	if (isDone) return;

	if (lostConnectionHandler) {
		std::thread t(lostConnection, lostConnectionHandler, ex);
		t.detach();
	}
	else if (waitBeforeRetry()) { // e.g. Socket error
		send(transport, server, PMessage());
	}
}

}}
#endif
