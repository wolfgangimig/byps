package byps.test.api.remote;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.refs.Node;

public interface RemoteReferences extends BRemote {
	Node getNode() throws RemoteException;
	void setNode(Node v) throws RemoteException;
}
