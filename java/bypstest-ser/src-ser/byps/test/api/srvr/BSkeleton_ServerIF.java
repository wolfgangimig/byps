package byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteSkeleton DO NOT MODIFY.
 */

import byps.*;

/**
 * This class provides a skeleton implementation of the interface ServerIF.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_ServerIF extends BSkeleton implements ServerIFAsync {
	
	public final static long serialVersionUID = 1775199834L;
	
	// checkpoint byps.gen.j.PrintContext:359
	public int callClientIncrementInt(int v) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void callClientIncrementInt(int v, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = callClientIncrementInt(v);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setPartner(ClientIF client) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setPartner(ClientIF client, final BAsyncResult<Object> asyncResult) {
		try {
			setPartner(client);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public ClientIF getPartner() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getPartner(final BAsyncResult<ClientIF> asyncResult) {
		try {
			ClientIF ret = getPartner();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.util.List<java.io.InputStream> getStreamsFromClient() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getStreamsFromClient(final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) {
		try {
			java.util.List<java.io.InputStream> ret = getStreamsFromClient();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams, final BAsyncResult<Object> asyncResult) {
		try {
			putStreamsOnClient(streams);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void registerWithClientMap(int id) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void registerWithClientMap(int id, final BAsyncResult<Object> asyncResult) {
		try {
			registerWithClientMap(id);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public ClientIF getClient(int id) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getClient(int id, final BAsyncResult<ClientIF> asyncResult) {
		try {
			ClientIF ret = getClient(id);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.util.Set<java.lang.Integer> getClientIds() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getClientIds(final BAsyncResult<java.util.Set<java.lang.Integer>> asyncResult) {
		try {
			java.util.Set<java.lang.Integer> ret = getClientIds();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public int callClientParallel(int v) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void callClientParallel(int v, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = callClientParallel(v);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
