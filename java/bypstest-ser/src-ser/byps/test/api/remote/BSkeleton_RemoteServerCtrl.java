package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteSkeleton DO NOT MODIFY.
 */

import byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteServerCtrl.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteServerCtrl extends BSkeleton implements RemoteServerCtrlAsync {
	
	public final static long serialVersionUID = 1652234479L;
	
	// checkpoint byps.gen.j.PrintContext:359
	public void publishRemote(java.lang.String name, BRemote remote, boolean fowardToOtherServers) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void publishRemote(java.lang.String name, BRemote remote, boolean fowardToOtherServers, final BAsyncResult<Object> asyncResult) {
		try {
			publishRemote(name, remote, fowardToOtherServers);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public BRemote getPublishedRemote(java.lang.String name) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getPublishedRemote(java.lang.String name, final BAsyncResult<BRemote> asyncResult) {
		try {
			BRemote ret = getPublishedRemote(name);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void removePublishedRemote(java.lang.String name) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void removePublishedRemote(java.lang.String name, final BAsyncResult<Object> asyncResult) {
		try {
			removePublishedRemote(name);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
