package com.wilutions.byps.test.api.ver;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;

/**
 */
public interface EvolveIF extends BRemote {

	public void setEvolve(Evolve obj) throws RemoteException;
	
	public Evolve getEvolve() throws RemoteException;
	
	public void setClient(EvolveIF partner) throws RemoteException;
	
	public EvolveIF getClient() throws RemoteException;
	
	public void sendEvolveToClient() throws RemoteException;
}
