package com.wilutions.byps.test.api.refs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Node implements Serializable {

	private static final long serialVersionUID = 9001L;

	public Node next;
	
	public Node me;
	
	public Map<String, Node> mapOfNodes;
	
	public List<Node> listOfNodes;
	
}