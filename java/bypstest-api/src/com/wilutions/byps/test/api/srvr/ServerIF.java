package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;

public interface ServerIF extends BRemote {

	public int callClientIncrementInt(int v) throws RemoteException;
	
	public void setPartner(ClientIF client) throws RemoteException;
	
	public ClientIF getPartner() throws RemoteException;
	
	public List<InputStream> getStreamsFromClient() throws RemoteException;
	
	public void putStreamsOnClient(List<InputStream> streams) throws RemoteException;
	
	public void registerWithClientMap(int id) throws RemoteException;
	
	public ClientIF getClient(int id) throws RemoteException;
	
	public Set<Integer> getClientIds() throws RemoteException;

	public int callClientParallel(int v) throws RemoteException;
	
}
