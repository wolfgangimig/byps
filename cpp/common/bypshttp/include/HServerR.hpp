#ifndef HSERVERR_HPP_
#define HSERVERR_HPP_

#include "HServerR.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HServerR_LongPoll;
typedef byps_ptr<HServerR_LongPoll> PServerR_LongPoll;
class HServerR_SendLongPoll;
typedef byps_ptr<HServerR_SendLongPoll> PServerR_SendLongPoll;

class HServerR_SendLongPoll {

	byps_mutex mutex;
	byps_condition_variable serverFinished;
	bool isDone;
	int32_t sleepMillisBeforeRetry;
	

public:
    byps_atomic<int32_t> nbOfActiveLongPolls;

	HServerR_SendLongPoll() : isDone(false), sleepMillisBeforeRetry(60 * 1000), nbOfActiveLongPolls(0) {}

	bool checkDoneMaybeWait() {
		byps_unique_lock lock(mutex);
		std::chrono::milliseconds timeout(sleepMillisBeforeRetry);
		return serverFinished.wait_for(lock, timeout, [this]() { return isDone; });
	}

	void done() {
		byps_unique_lock lock(mutex);
		isDone = true;
		serverFinished.notify_all();
	}

    static void send(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server, PMessage methodResult);
};

class HServerR_LongPoll {
	PServerR_SendLongPoll sendLongPoll;
	PTransport transport;
	PServer server;
	PMessage methodResult;

	class NextAsyncResult : public BAsyncResult {
		PServerR_SendLongPoll sendLongPoll;
		PTransport transport;
		PServer server;
	public:
		NextAsyncResult(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server) 
			: sendLongPoll(sendLongPoll), transport(transport), server(server) {
            sendLongPoll->nbOfActiveLongPolls++;
		}

        virtual ~NextAsyncResult() {
            sendLongPoll->nbOfActiveLongPolls--;
            sendLongPoll.reset();
            transport.reset();
            server.reset();
        }

		virtual void setAsyncResult(const BVariant& varmsg) {
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
			HServerR_SendLongPoll::send(sendLongPoll, transport, server, msg);
			delete this;
		}
	};

	class NextAsyncMethod : public BAsyncResult {
		PServerR_SendLongPoll sendLongPoll;
		PTransport transport;
		PServer server;
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
			bool failed = varmsg.isException();
			if (failed) {
				BException ex = varmsg.getException();
				if (ex.getCode() != EX_CANCELLED) {
					if (ex.getCode() == EX_TIMEOUT || !sendLongPoll->checkDoneMaybeWait()) {
						HServerR_SendLongPoll::send(sendLongPoll, transport, server, PMessage());
					}
				}
			}
			else {
				POBJECT obj;
				varmsg.get(obj);
				PMessage msg = byps_static_ptr_cast<BMessage>(obj);
				NextAsyncResult* asyncResult = new NextAsyncResult(sendLongPoll, transport, server);
				transport->recv(server, msg, asyncResult);
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
		transport->wire->sendR(methodResult, nextMethod);

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
		HServerR_SendLongPoll::send(sendLongPoll, transport, server, PMessage());
	}

}

BINLINE void HServerR::done() {
	sendLongPoll->done();
}

BINLINE void HServerR_SendLongPoll::send(PServerR_SendLongPoll sendLongPoll, PTransport transport, PServer server, PMessage methodResult) {
	if (!sendLongPoll->isDone) {
        HServerR_LongPoll longPoll(sendLongPoll, transport, server, methodResult);
        longPoll.run();
	}
}


}}}}
#endif
