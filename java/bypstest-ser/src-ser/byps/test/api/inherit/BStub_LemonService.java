package byps.test.api.inherit;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteStub:164
public class BStub_LemonService extends BStub implements LemonServiceAuth, java.io.Serializable {
	
	// checkpoint byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 605543968L;
	
	public BStub_LemonService(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint byps.gen.j.PrintContext:365
	public java.lang.String grow() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		grow(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:409
	public void grow(final BAsyncResult<String> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_PlantService_grow req = new BRequest_PlantService_grow();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:365
	public java.lang.String squeeze() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		squeeze(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:409
	public void squeeze(final BAsyncResult<String> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:365
	public java.lang.String pick(byps.test.api.auth.SessionInfo sess, java.lang.String fromTree) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		pick(sess, fromTree, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:409
	public void pick(byps.test.api.auth.SessionInfo sess, java.lang.String fromTree, final BAsyncResult<String> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_LemonService_pick req = new BRequest_LemonService_pick();		
		req.sess = sess;
		req.fromTree = fromTree;
		transport.sendMethod(req, asyncResult);
	}
	
	
}
