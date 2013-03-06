package com.wilutions.byps.test.api.refs;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public class Node implements BSerializable {

	public Node next;
	public Node me;
	public java.util.Map<java.lang.String,Node> mapOfNodes;
	public java.util.List<Node> listOfNodes;
	
	private final static long serialVersionUID = 9001L;
	
	public Node() {
	}	
	
	public Node(Node next, Node me, java.util.Map<java.lang.String,Node> mapOfNodes, java.util.List<Node> listOfNodes) {
		this.next = next;
		this.me = me;
		this.mapOfNodes = mapOfNodes;
		this.listOfNodes = listOfNodes;
	}	
	
}
