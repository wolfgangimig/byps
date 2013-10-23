package byps;

import java.util.ArrayList;

import byps.BRemote;
import byps.BTargetId;
import byps.RemoteException;

public interface BServerRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws RemoteException;
	public BClient getForwardClientIfForeignTargetId(BTargetId targetId) throws RemoteException;
	public ArrayList<BClient> getForwardClientsToOtherServers() throws RemoteException;
}
