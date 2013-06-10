package com.wilutions.byps.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.net.www.protocol.http.HttpURLConnection;

import com.wilutions.byps.BAsyncResult;
import com.wilutions.byps.BException;
import com.wilutions.byps.BMessage;
import com.wilutions.byps.BMessageHeader;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BServerR;
import com.wilutions.byps.BTransport;

/**
 * LongPoll-Nachricht:
 * 
 */
public class HServerR extends BServerR {
	
	public HServerR(BTransport transport, BServer server, int nbOfConns) {
		super(transport, server);
		this.nbOfConns = nbOfConns;
		this.sleepMillisBeforeRetry = 60 * 1000;
	}
	
	@Override
	public synchronized void start() throws BException {
		if (log.isDebugEnabled()) log.debug("start(");
		for (int i = 0; i < Math.max(1, nbOfConns); i++) {
			sendLongPoll(null);
		}
//		currentLongPoll_access_sync = new LongPoll(null);
//		workerThread.start();
		if (log.isDebugEnabled()) log.debug(")start");
	}
	
	@Override
	public void done() {
		if (log.isDebugEnabled()) log.debug("done(");
		
		synchronized(refDone) {
			refDone[0] = true;
			refDone.notifyAll();
		}
		
		// Wird von HWireClient.done() aufgerufen. 
		// Dort werden die Long-Polls vom Server beendet.
		
//		workerThread.interrupt();
//		
//		try {
//			workerThread.join(1000);
//		}
//		catch (InterruptedException ignored) {}
		
		if (log.isDebugEnabled()) log.debug(")done");
	}
	
	protected class LongPoll implements Runnable {
		
		private final Log log = LogFactory.getLog("LongPoll");
		protected BMessage methodResult;
		
		protected LongPoll(BMessage methodResult) throws BException {
			if (log.isDebugEnabled()) log.debug("LongPoll(" + methodResult);
			if (methodResult != null) {
				this.methodResult = methodResult;
			}
			else {
				BOutput outp = transport.getOutput();
				outp.header.flags |= BMessageHeader.FLAG_RESPONSE;
				outp.store(null); // irgendwas, damit auch der Header in den ByteBuffer geschrieben wird.
				this.methodResult = outp.toMessage();
			}
			if (log.isDebugEnabled()) log.debug(")LongPoll");
		}
		
		public void run() {
			if (log.isDebugEnabled()) log.debug("run(");

			final BAsyncResult<BMessage> asyncResult = new BAsyncResult<BMessage>() {
	
				@Override
				public void setAsyncResult(BMessage msg, Throwable e) {
					if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg);
					try {
						if (e != null) {
							BOutput out = transport.getOutput();
							out.header.flags = BMessageHeader.FLAG_RESPONSE;
							out.setException(e);
							msg = out.toMessage();
						}
						sendLongPoll(msg);
					} catch (BException e1) {
						if (log.isErrorEnabled()) log.error("Failed to send longpoll for obj=" + msg, e1);
					}
					if (log.isDebugEnabled()) log.debug(")setAsyncResult");
				}
	
			};
			
			BAsyncResult<BMessage> nextAsyncMethod = new BAsyncResult<BMessage>() {
	
				@Override
				public void setAsyncResult(BMessage msg, Throwable e) {
					if (log.isDebugEnabled()) log.debug("asyncMethod.setAsyncResult(" + msg);
					try {
						if (e == null && !msg.isEmpty()) {
							// Execute the method received from server.
							transport.recv(server, msg, asyncResult);
						}
						else {
							// Communication to server failed, e.g. server unavailable or timeout
							try {
								boolean isTimeout = HException.isTimeout(e);
								if (!isTimeout) {
									synchronized(refDone) {
										if(!refDone[0]) {
											refDone.wait(sleepMillisBeforeRetry);
										}
									}
								}
								
								asyncResult.setAsyncResult(null, e);
							}
							catch (InterruptedException ignored) {
							}
						}
					} catch (Throwable ex) {
						// transport.recv failed
						if (log.isDebugEnabled()) log.debug("recv failed.", e);
						asyncResult.setAsyncResult(null, ex);
					}
					if (log.isDebugEnabled()) log.debug(")asyncMethod.setAsyncResult");
				}
	
			};
			
			
			// Sende den longPoll-Request
			// Im Body befindet sich die Antwort auf die vorige vom Server gestellte Anfrage.
			// Als Ergebnis des longPoll kommt eine neue Serveranfrage (Methode).
			
			transport.wire.sendR(methodResult, nextAsyncMethod);
			
			if (log.isDebugEnabled()) log.debug(")run");
		}
	
	}
	
	protected void sendLongPoll(BMessage obj) throws BException {
		if (log.isDebugEnabled()) log.debug("sendLongPollInWorkerThread(" + obj);
		synchronized(refDone) {
			if (!refDone[0]) {
				LongPoll lp = new LongPoll(obj);
				lp.run();
			}
		}
//		synchronized(this) {
//			if (log.isDebugEnabled()) log.debug("execute in worker thread");
//			currentLongPoll_access_sync = lp;
//			this.notifyAll();
//		}
		if (log.isDebugEnabled()) log.debug(")sendLongPollInWorkerThread");
	}
	
//	protected class WorkerThread extends Thread {
//		WorkerThread() {
//			setName("longpoll-" + c_longPollCounter.incrementAndGet());
//		}
//		
//		public void run() {
//			if (log.isDebugEnabled()) log.debug("LongPoll.run(");
//			try {
//				while (!isInterrupted()) {
//					LongPoll lp = null;
//					synchronized(HServerR.this) {
//						while (currentLongPoll_access_sync == null) {
//							if (log.isDebugEnabled()) log.debug("wait for LongPoll");
//							HServerR.this.wait();
//						}
//						lp = currentLongPoll_access_sync;
//						currentLongPoll_access_sync = null;
//					}
//					
//					try {
//						if (log.isDebugEnabled()) log.debug("execute LongPoll");
//						lp.run();
//					}
//					catch (Throwable e) {
//						log.error("LongPoll worker thread received uncaught exception.", e);
//					}
//				}
//				if (log.isDebugEnabled()) log.debug("Worker interrupted");
//			}
//			catch (InterruptedException e) {
//				if (log.isDebugEnabled()) log.debug("Recevied "+ e);
//			}
//			if (log.isDebugEnabled()) log.debug(")LongPoll.run");
//		}
//	}
	
	protected int nbOfConns;
	protected boolean[] refDone = new boolean[1];
	protected long sleepMillisBeforeRetry;
//	protected final Thread workerThread = new WorkerThread();
//	protected LongPoll currentLongPoll_access_sync;
	private final Log log = LogFactory.getLog(HServerR.class);
}
