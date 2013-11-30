/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
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
	vector<PRunnable> queue;
	int maxThreads;
	int fullLimit;
	byps_atomic<bool> isDone;

	typedef byps_ptr<thread> PThread;
	map<thread::id, PThread> allThreads;
	map<thread::id, bool> runningThreads;

	PRunnable nextRunnableUnsync(byps_unique_lock& lock) {

		chrono::duration<int,milli> timeout(100 * 1000);

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
		thread::id tid = this_thread::get_id();

		while (true) {
			PRunnable r;

			{
				byps_unique_lock lock(tpool->mutex);
				r = tpool->nextRunnableUnsync(lock);
				if (!r) {
					break;
				}
			}

			try {
				r->run();
			}
			catch (...) {
			}

		}

		{
			byps_unique_lock lock(tpool->mutex);
			tpool->runningThreads[tid] = false;
		}
	}

	void removeStoppedThreadsUnsync(vector<PThread>& stoppedThreads) {
		vector<thread::id> killIds;
		killIds.reserve(runningThreads.size());
		for (map<thread::id, bool>::iterator it = runningThreads.begin(); it != runningThreads.end(); it++) {
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

	void killStoppedThreads(vector<PThread>& stoppedThreads) {
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

			vector<PThread> stoppedThreads;
			{
				byps_unique_lock lock(mutex);

				for (map<thread::id, bool>::iterator it = runningThreads.begin(); it != runningThreads.end(); it++) {
					(*it).second = false;
				}
				removeStoppedThreadsUnsync(stoppedThreads);
			}
			killStoppedThreads(stoppedThreads);
		}
	}

	virtual bool execute(PRunnable r) {
		
		vector<PThread> stoppedThreads;

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
						PThread t(new thread(threadFunction, pThis));
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

BINLINE PThreadPool BThreadPool::create(void* app, int maxThreads) {
	PThreadPoolImpl tpool(new BThreadPoolImpl(maxThreads));
	return tpool;
}



}

#endif // BTHREADPOOL

#endif
