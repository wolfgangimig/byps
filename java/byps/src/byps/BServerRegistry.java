package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.Collection;

public interface BServerRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws RemoteException;
	public BClient getForwardClientIfForeignTargetId(BTargetId targetId) throws RemoteException;
	public Collection<BClient> getForwardClientsToOtherServers() throws RemoteException;
	public BTargetId encryptTargetId(BTargetId targetId, boolean encryptNotDecrypt) throws RemoteException;
	public void done();
}
