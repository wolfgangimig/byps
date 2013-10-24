package byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteStub:164
public class BStub_EvolveIF extends BStub implements EvolveIFAsync, java.io.Serializable {
	
	// checkpoint byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 15377840L;
	
	public BStub_EvolveIF(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setEvolve(Evolve obj) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		setEvolve(obj, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setEvolve(Evolve obj, final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_EvolveIF_setEvolve req = new BRequest_EvolveIF_setEvolve();		
		req.obj = obj;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public Evolve getEvolve() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Evolve> asyncResult = new BSyncResult<Evolve>();		
		getEvolve(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getEvolve(final BAsyncResult<Evolve> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_EvolveIF_getEvolve req = new BRequest_EvolveIF_getEvolve();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setClient(EvolveIF partner) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		setClient(partner, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setClient(EvolveIF partner, final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_EvolveIF_setClient req = new BRequest_EvolveIF_setClient();		
		req.partner = partner;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public EvolveIF getClient() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<EvolveIF> asyncResult = new BSyncResult<EvolveIF>();		
		getClient(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getClient(final BAsyncResult<EvolveIF> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_EvolveIF_getClient req = new BRequest_EvolveIF_getClient();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void sendEvolveToClient() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		sendEvolveToClient(asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void sendEvolveToClient(final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_EvolveIF_sendEvolveToClient req = new BRequest_EvolveIF_sendEvolveToClient();		
		transport.sendMethod(req, asyncResult);
	}
	
	
}
