package byps.test.api.inherit;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteClassAuth DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteClassAsync:68
public interface FruitServiceAuth extends BRemote, 
	byps.test.api.inherit.PlantServiceAuth {
	/**
	*/
	// checkpoint byps.gen.j.PrintContext:383
	public java.lang.String squeeze() throws RemoteException;
	// checkpoint byps.gen.j.PrintContext:427
	public void squeeze(final BAsyncResult<String> asyncResult) ;
	
	
}
