package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteSkeleton DO NOT MODIFY.
 */

import byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteReferences.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteReferences extends BSkeleton implements RemoteReferencesAsync {
	
	public final static long serialVersionUID = 568637225L;
	
	// checkpoint byps.gen.j.PrintContext:359
	public byps.test.api.refs.Node getNode() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getNode(final BAsyncResult<byps.test.api.refs.Node> asyncResult) {
		try {
			byps.test.api.refs.Node ret = getNode();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setNode(byps.test.api.refs.Node v) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setNode(byps.test.api.refs.Node v, final BAsyncResult<Object> asyncResult) {
		try {
			setNode(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
