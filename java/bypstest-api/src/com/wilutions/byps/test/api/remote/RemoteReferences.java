package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.refs.Node;

public interface RemoteReferences extends BRemote {
	Node getNode();
	void setNode(Node v);
}
