#ifndef BTHREADPOOL_HPP_
#define BTHREADPOOL_HPP_

#ifndef BTHREADPOOL
#define BTHREADPOOL

#include "Byps.h"

#include <thread>

namespace byps { 

class BThreadPoolImpl;
typedef byps_ptr<BThreadPoolImpl> PThreadPoolImpl;

class BThreadPoolImpl : public BThreadPool, public byps_enable_shared_from_this<BThreadPoolImpl> {
	byps_mutex mutex;
	byps_condition_variable queueItemAdded;
	byps_condition_variable queueItemRemoved;
	std::vector<PRunnable> queue;
	int maxThreads;
	int fullLimit;
	byps_atomic<bool> isDone;
	byps_atomic<int> nbOfBusyThreads;

	typedef byps_ptr<std::thread> PThread;
	std::map<std::thread::id, PThread> allThreads;
	std::map<std::thread::id, bool> threadIdToRunning;

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

		while (true) {
			PRunnable r;

			{
				byps_unique_lock lock(tpool->mutex);
				r = tpool->nextRunnableUnsync(lock);
				if (!r) {
					break;
				}
			}

			tpool->nbOfBusyThreads++;
			try {
				r->run();
			}
			catch (...) {
			}
			tpool->nbOfBusyThreads--;

		}

		{
			byps_unique_lock lock(tpool->mutex);
			tpool->threadIdToRunning[tid] = false;
		}
	}

	void removeStoppedThreadsUnsync(std::vector<PThread>& stoppedThreads) {
		std::vector<std::thread::id> killIds;
		killIds.reserve(threadIdToRunning.size());
		for (std::map<std::thread::id, bool>::iterator it = threadIdToRunning.begin(); it != threadIdToRunning.end(); it++) {
			if ((*it).second) continue;
			killIds.push_back((*it).first);
		}
		for (unsigned i = 0; i < killIds.size(); i++) {
			PThread t = allThreads[killIds[i]];
			stoppedThreads.push_back(t);
			allThreads.erase(killIds[i]);
			threadIdToRunning.erase(killIds[i]);
		}
	}

	void joinThreads(std::vector<PThread>& stoppedThreads) {
		for (unsigned i = 0; i < stoppedThreads.size(); i++) {
			PThread t = stoppedThreads[i];
			if (t && t->joinable()) {
				t->join();
			}
			stoppedThreads[i] = PThread();
		}
	}

public:
	BThreadPoolImpl(int maxThreads) 
		: maxThreads(maxThreads)
		, fullLimit(maxThreads * 2)
		, isDone(false) {
	}

	virtual ~BThreadPoolImpl() {
    }

	virtual void done() {

		bool expectedDone = false;
		if (isDone.compare_exchange_strong(expectedDone, true)) {

			queueItemAdded.notify_all();
			queueItemRemoved.notify_all();

			std::vector<PThread> stoppedThreads;
			{
				byps_unique_lock lock(mutex);

				for (std::map<std::thread::id, bool>::iterator it = threadIdToRunning.begin(); it != threadIdToRunning.end(); it++) {
					(*it).second = false;
				}
				removeStoppedThreadsUnsync(stoppedThreads);
			}
			joinThreads(stoppedThreads);
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

				// Remove stopped threads from threadIdToRunning
				removeStoppedThreadsUnsync(stoppedThreads);

				// add job into queue
				this->queue.push_back(r);

				// Maybe start new thread
				size_t nbOfFreeThreads = threadIdToRunning.size() - (size_t)nbOfBusyThreads;
				if (queue.size() > nbOfFreeThreads) {
					if (threadIdToRunning.size() < (size_t)maxThreads) {
						PThread t(new std::thread(threadFunction, pThis));
						threadIdToRunning[t->get_id()] = true;
						allThreads[t->get_id()] = t;
					}
				}

			}

			this->queueItemAdded.notify_all();
		}
		
		joinThreads(stoppedThreads);

		return !isDone;
	}



	static PThreadPool createInstance();
};

BINLINE PThreadPool BThreadPool::create(void* , int maxThreads) {
	PThreadPoolImpl tpool(new BThreadPoolImpl(maxThreads));
	return tpool;
}



}

#endif // BTHREADPOOL

#endif
