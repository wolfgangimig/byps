package byps.test.api.inherit;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteClassAuth DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteClassAsync:68
public interface LemonServiceAuth extends BRemote, 
	byps.test.api.inherit.FruitServiceAuth {
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:383
	public java.lang.String pick(byps.test.api.auth.SessionInfo sess, java.lang.String fromTree) throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:427
	public void pick(byps.test.api.auth.SessionInfo sess, java.lang.String fromTree, final BAsyncResult<String> asyncResult) ;
	
	
}
