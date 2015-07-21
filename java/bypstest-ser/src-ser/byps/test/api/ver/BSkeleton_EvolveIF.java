package byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteSkeleton DO NOT MODIFY.
 */

import byps.*;

/**
 * This class provides a skeleton implementation of the interface EvolveIF.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_EvolveIF extends BSkeleton implements EvolveIFAsync {
	
	public final static long serialVersionUID = 15377840L;
	
	// checkpoint byps.gen.j.PrintContext:383
	public void setEvolve(Evolve obj) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:427
	public void setEvolve(Evolve obj, final BAsyncResult<Object> asyncResult) {
		try {
			setEvolve(obj);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:383
	public Evolve getEvolve() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:427
	public void getEvolve(final BAsyncResult<Evolve> asyncResult) {
		try {
			Evolve ret = getEvolve();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:383
	public void setClient(EvolveIF partner) throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:427
	public void setClient(EvolveIF partner, final BAsyncResult<Object> asyncResult) {
		try {
			setClient(partner);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:383
	public EvolveIF getClient() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:427
	public void getClient(final BAsyncResult<EvolveIF> asyncResult) {
		try {
			EvolveIF ret = getClient();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	// checkpoint byps.gen.j.PrintContext:383
	public void sendEvolveToClient() throws RemoteException {
		throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
	}
	// checkpoint byps.gen.j.PrintContext:427
	public void sendEvolveToClient(final BAsyncResult<Object> asyncResult) {
		try {
			sendEvolveToClient();
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
