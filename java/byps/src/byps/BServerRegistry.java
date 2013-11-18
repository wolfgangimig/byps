package byps;

import java.util.Collection;

public interface BServerRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws RemoteException;
	public BClient getForwardClientIfForeignTargetId(BTargetId targetId) throws RemoteException;
	public Collection<BClient> getForwardClientsToOtherServers() throws RemoteException;
}
