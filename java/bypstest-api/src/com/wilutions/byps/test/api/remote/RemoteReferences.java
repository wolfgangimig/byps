package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.refs.Node;

public interface RemoteReferences extends BRemote {
	Node getNode() throws RemoteException;
	void setNode(Node v) throws RemoteException;
}
