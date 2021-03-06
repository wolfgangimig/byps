package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import byps.BAsyncResult;
import byps.BException;
import byps.RemoteException;

public class BSyncResult<T> implements BAsyncResult<T> {
	
	protected T result;
	protected Throwable ex;
	private boolean done;
	private Future<T> future;
	
	public BSyncResult() {
	}
	
	@Override
	public void setAsyncResult(T result, Throwable e) {
		synchronized(this) {
			this.result = result;
			this.ex = e;
			this.done = true;
			this.notifyAll();
		}
	}

	public T getResult() throws RemoteException {
		return getResult(Long.MAX_VALUE);
	}
	
	public T getResult(long timeout) throws RemoteException {
		try {
			synchronized(this) {
				long t1 = System.currentTimeMillis();
				while (!done) {
					this.wait(timeout);
					long dt = System.currentTimeMillis() - t1;
					if (dt >= timeout) {
						throw new BException(BExceptionC.TIMEOUT, "Timeout while waiting for result.");
					}
				}
				if (ex != null) {
					if (ex instanceof BException) {
					  // Copy exception information.
					  // The new exception has a more helpful stack trace.
					  throw new BException((BException)ex); 
					}
					else {
					  throw new BException(BExceptionC.REMOTE_ERROR, "", ex);
					}
				}
				return result;
			}
		}
		catch (InterruptedException e) {
			throw new BException(BExceptionC.CANCELLED, e.toString(), e);
		}
	}
	
	public Future<T> getFuture() {
		synchronized(this) {
			if (future == null) {
				future = new MyFuture<T>();
			}
			return future;
		}
	}

	private class MyFuture<V> implements Future<V> {
		
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			if (mayInterruptIfRunning) {
				BSyncResult.this.setAsyncResult(null,
						new BException(BExceptionC.CANCELLED, "Operation canceled."));
			}
			return mayInterruptIfRunning;
		}
	
		@Override
		public boolean isCancelled() {
			synchronized(this) {
				Throwable tx = BSyncResult.this.ex;
				if (tx != null && tx instanceof BException) {
					BException ex = (BException)tx;
					return ex.code == BExceptionC.CANCELLED;
				}
			}
			return false;
		}
	
		@Override
		public boolean isDone() {
			synchronized(this) {
				return done;
			}
		}
	
		@Override
		public V get() throws InterruptedException, ExecutionException {
			try {
				return (V) get(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
			} catch (TimeoutException e) {
				throw new ExecutionException(e);
			}
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public V get(long timeout, TimeUnit unit) throws InterruptedException,
				ExecutionException, TimeoutException {
			try {
				return (V) BSyncResult.this.getResult(unit.toMillis(timeout));
			} catch (RemoteException e) {
				if (e instanceof BException) {
					BException bex = (BException)e;
					Throwable cause = bex.getCause();
					if (cause != null) {
						throw new ExecutionException(cause);
					}
				}
				throw new ExecutionException(e);
			}
		}
	}
}
