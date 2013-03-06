package com.wilutions.byps.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.refs.Node;

/**
 * Serialize objects graphs with circular references.
 *
 */
public class TestSerializeReferences {
	
	BTransport transport = TestUtils.createTransport();
	private Log log = LogFactory.getLog(TestSerializeReferences.class);
	
	/**
	 * Serializes an object with a member that refers to itself.
	 * @throws BException
	 */
	@Test
	public void testSerializeSelfReference() throws BException {
		Node node = new Node();
		node.me = node;
		Node nodeR = internalTestSerializeObject(node);
		Assert.assertTrue("me", nodeR == nodeR.me);
	}
	
	/**
	 * Serializes two objects that have a bidirectional relation. 
	 * @throws BException 
	 */
	@Test
	public void testSerializeCircularRef() throws BException {
		Node node1 = new Node();
		node1.next = new Node();
		node1.next.next = node1;
		Node nodeR = internalTestSerializeObject(node1);
		Assert.assertTrue("next", nodeR.next.next == nodeR);
	}
	
	/**
	 * Serializes an object with a map, whereby a map item refers to the object.
	 * @throws BException 
	 */
	@Test
	public void testSerializeSelfRefInMap() throws BException {
		Node node1 = new Node();
		node1.mapOfNodes = new TreeMap<String, Node>();
		node1.mapOfNodes.put("node1", node1);
		Node nodeR = internalTestSerializeObject(node1);
		Assert.assertTrue("node1.mapOfNodes[node1]", nodeR.mapOfNodes.get("node1") == nodeR);
	}

	/**
	 * Serializes an object with a list, whereby a list item refers to the object.
	 * @throws BException 
	 */
	@Test
	public void testSerializeSelfRefInList() throws BException {
		Node node1 = new Node();
		node1.listOfNodes = new ArrayList<Node>();
		node1.listOfNodes.add(node1);
		Node nodeR = internalTestSerializeObject(node1);
		Assert.assertTrue("node1.listOfNodes[0]", nodeR.listOfNodes.get(0) == nodeR);
	}

	private Node internalTestSerializeObject(Node obj) throws BException {
		log.info("internalTestSerializeObject(" + obj);
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		Node objR = (Node)bin.load();
		TestUtils.assertEquals(log, "object", obj, objR);
		log.info(")internalTestSerializeObject");
		return objR;
	}
	
}
