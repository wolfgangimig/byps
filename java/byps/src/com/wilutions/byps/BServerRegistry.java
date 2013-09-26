package com.wilutions.byps;

import java.util.ArrayList;

public interface BServerRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws RemoteException;
	public BClient getForwardClientIfForeignTargetId(BTargetId targetId) throws RemoteException;
	public ArrayList<BClient> getForwardClientsToOtherServers() throws RemoteException;
}
