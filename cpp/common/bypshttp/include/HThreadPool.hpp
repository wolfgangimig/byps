#ifndef HTHREADPOOL_HPP_
#define HTHREADPOOL_HPP_

#include "Bypshttp.h"
#include <thread>

namespace com { namespace wilutions { namespace byps { namespace http {

class HThreadPoolImpl;
typedef byps_ptr<HThreadPoolImpl> PThreadPoolImpl;

class HThreadPoolImpl : public HThreadPool, public byps_enable_shared_from_this<HThreadPoolImpl> {
	byps_mutex mutex;
	byps_condition_variable queueItemAdded;
	byps_condition_variable queueItemRemoved;
	std::vector<PRunnable> queue;
	int maxThreads;
	int fullLimit;
	byps_atomic<bool> isDone;

	friend class HThreadPool;

	typedef byps_ptr<std::thread> PThread;
	std::map<std::thread::id, PThread> allThreads;
	std::map<std::thread::id, bool> runningThreads;

	PRunnable nextRunnableUnsync(byps_unique_lock& lock) {

		std::chrono::duration<int,std::milli> timeout(100 * 1000);

		bool succ = queueItemAdded.wait_for(lock, timeout, [this](){ 
			return this->isDone || this->queue.size() != 0; 
		});

		PRunnable r;
		if (succ && !isDone) {
			r = queue.front();
			queue.erase(queue.begin());
			queueItemRemoved.notify_all();
		}

		return r;
	}
	
	static void threadFunction(PThreadPoolImpl tpool) {
		std::thread::id tid = std::this_thread::get_id();
		byps_unique_lock lock(tpool->mutex);

		while (true) {
			PRunnable r = tpool->nextRunnableUnsync(lock);
			if (!r) {
				break;
			}

			try {
				r->run();
			}
			catch (...) {
			}

		}

		tpool->runningThreads[tid] = false;
	}

	void removeStoppedThreadsUnsync(std::vector<PThread>& stoppedThreads) {
		std::vector<std::thread::id> killIds;
		killIds.reserve(runningThreads.size());
		for (std::map<std::thread::id, bool>::iterator it = runningThreads.begin(); it != runningThreads.end(); it++) {
			if ((*it).second) continue;
			killIds.push_back((*it).first);
		}
		for (unsigned i = 0; i < killIds.size(); i++) {
			PThread t = allThreads[killIds[i]];
			stoppedThreads.push_back(t);
			allThreads.erase(killIds[i]);
			runningThreads.erase(killIds[i]);
		}
	}

	void killStoppedThreads(std::vector<PThread>& stoppedThreads) {
		for (unsigned i = 0; i < stoppedThreads.size(); i++) {
			PThread t = stoppedThreads[i];
			if (t && t->joinable()) {
				t->join();
			}
			stoppedThreads[i] = PThread();
		}
	}

public:
	HThreadPoolImpl(int maxThreads) 
		: maxThreads(maxThreads)
		, fullLimit(maxThreads * 2)
		, isDone(false) {
	}

	virtual ~HThreadPoolImpl() {
	};

	virtual void done() {

		bool expectedDone = false;
		if (isDone.compare_exchange_strong(expectedDone, true)) {

			queueItemAdded.notify_all();
			queueItemRemoved.notify_all();

			std::vector<PThread> stoppedThreads;
			{
				byps_unique_lock lock(mutex);

				for (std::map<std::thread::id, bool>::iterator it = runningThreads.begin(); it != runningThreads.end(); it++) {
					(*it).second = false;
				}
				removeStoppedThreadsUnsync(stoppedThreads);
			}
			killStoppedThreads(stoppedThreads);
		}
	}

	virtual bool execute(PRunnable r) {
		
		std::vector<PThread> stoppedThreads;

		{
			byps_unique_lock lock(this->mutex);
		
			this->queueItemRemoved.wait(lock, [this](){ 
				return this->isDone || this->queue.size() < (size_t)fullLimit || !shared_from_this(); 
			});

			PThreadPoolImpl pThis = shared_from_this();
			if (pThis && !isDone) {

				removeStoppedThreadsUnsync(stoppedThreads);

				// Start new thread, if all threads busy
				if (queue.size() >= runningThreads.size()) {
					if (runningThreads.size() < (size_t)maxThreads) {
						PThread t(new std::thread(threadFunction, pThis));
						runningThreads[t->get_id()] = true;
						allThreads[t->get_id()] = t;
					}
				}

				this->queue.push_back(r);
			}

			this->queueItemAdded.notify_all();
		}
		
		killStoppedThreads(stoppedThreads);

		return !isDone;
	}



	static PThreadPool createInstance();
};

BINLINE PThreadPool HThreadPool::create(int maxThreads) {
	PThreadPoolImpl tpool(new HThreadPoolImpl(maxThreads));
	return tpool;
};



}}}}

#endif