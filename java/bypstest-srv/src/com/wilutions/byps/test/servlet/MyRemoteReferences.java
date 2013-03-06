package com.wilutions.byps.test.servlet;

import com.wilutions.byps.test.api.refs.Node;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteReferences;

public class MyRemoteReferences extends BSkeleton_RemoteReferences {

	private Node node;

	@Override
	public Node getNode() {
		return node;
	}

	@Override
	public void setNode(Node node) {
		this.node = node;
	}
	
	
}
