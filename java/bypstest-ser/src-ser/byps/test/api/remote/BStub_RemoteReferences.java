package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteStub:164
public class BStub_RemoteReferences extends BStub implements RemoteReferencesAsync, java.io.Serializable {
	
	// checkpoint byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 568637225L;
	
	public BStub_RemoteReferences(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint byps.gen.j.PrintContext:365
	public byps.test.api.refs.Node getNode() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<byps.test.api.refs.Node> asyncResult = new BSyncResult<byps.test.api.refs.Node>();		
		getNode(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:409
	public void getNode(final BAsyncResult<byps.test.api.refs.Node> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:365
	public void setNode(byps.test.api.refs.Node v) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		setNode(v, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:409
	public void setNode(byps.test.api.refs.Node v, final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();		
		req.v = v;
		transport.sendMethod(req, asyncResult);
	}
	
	
}
