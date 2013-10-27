package byps.test.api.inherit;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteStub:164
public class BStub_BioFruitService extends BStub implements BioFruitServiceAuth, java.io.Serializable {
	
	// checkpoint byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 363642571L;
	
	public BStub_BioFruitService(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public boolean certify(java.lang.String param) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Boolean> asyncResult = new BSyncResult<Boolean>();		
		certify(param, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void certify(java.lang.String param, final BAsyncResult<Boolean> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();		
		req.param = param;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.lang.String grow() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		grow(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void grow(final BAsyncResult<String> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_PlantService_grow req = new BRequest_PlantService_grow();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.lang.String squeeze() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		squeeze(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void squeeze(final BAsyncResult<String> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();		
		transport.sendMethod(req, asyncResult);
	}
	
	
}