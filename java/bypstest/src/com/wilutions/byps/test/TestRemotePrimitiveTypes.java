package com.wilutions.byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.RemotePrimitiveTypes;

/**
 * Tests for interface functions with primitive types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemotePrimitiveTypes {
	
	BClient_Testser client;
	RemotePrimitiveTypes remote;
	private Log log = LogFactory.getLog(TestRemotePrimitiveTypes.class);

	@Before
	public void setUp() throws BException, InterruptedException {
		client = TestUtilsHttp.createClient();
		remote = client.remotePrimitiveTypes;
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testRemotePrimitiveTypes() throws BException, InterruptedException {
		log.info("testRemotePrimitiveTypes(");
		
		remote.setBool(true);
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		remote.setBool(false);
		TestUtils.assertEquals(log, "bool", false, remote.getBool());
		remote.setByte((byte)11);
		TestUtils.assertEquals(log, "byte", (byte)11, remote.getByte());
		remote.setChar('€');
		TestUtils.assertEquals(log, "char", '€', remote.getChar());
		remote.setShort((short)1234);
		TestUtils.assertEquals(log, "short", (short)1234, remote.getShort());
		remote.setInt(5678);
		TestUtils.assertEquals(log,  "int", 5678, remote.getInt());
		remote.setLong(890L);
		TestUtils.assertEquals(log, "long", 890L, remote.getLong());
		remote.setFloat(1.2f);
		TestUtils.assertEquals(log,  "float", 1.2f, remote.getFloat());
		remote.setDouble(1.8);
		TestUtils.assertEquals(log,  "double", 1.8, remote.getDouble());
		remote.setString("ABC");
		TestUtils.assertEquals(log,  "String", "ABC", remote.getString());
		
		PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
		remote.setObject(pt);
		TestUtils.assertEquals(log,  "Object", pt, remote.getObject());
		
		pt = TestUtils.createObjectPrimitiveTypes();
		remote.setPrimitiveTypes(pt);
		TestUtils.assertEquals(log,  "PrimitiveTypes", pt, remote.getPrimitiveTypes());
		
		log.info(")testRemotePrimitiveTypes");
	}
	
	@Test
	public void testRemotePrimitiveTypesSendAll() throws BException, InterruptedException {
		log.info("testRemotePrimitiveTypesSendAll(");
		
		PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
		PrimitiveTypes pt2  =TestUtils.createObjectPrimitiveTypes();
		remote.sendAllTypes(true, 'Q', (short)34, 56, 45, 7.4f, 9.8, "23", pt, pt2);
		
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		TestUtils.assertEquals(log, "char", 'Q', remote.getChar());
		TestUtils.assertEquals(log, "short", (short)34, remote.getShort());
		TestUtils.assertEquals(log,  "int", 56, remote.getInt());
		TestUtils.assertEquals(log, "long", 45L, remote.getLong());
		TestUtils.assertEquals(log,  "float", 7.4f, remote.getFloat());
		TestUtils.assertEquals(log,  "double", 9.8, remote.getDouble());
		TestUtils.assertEquals(log,  "String", "23", remote.getString());
		TestUtils.assertEquals(log,  "PrimtitiveTypes", pt, remote.getPrimitiveTypes());
		TestUtils.assertEquals(log,  "Object", pt2, remote.getObject());

		log.info(")testRemotePrimitiveTypesSendAll");
	}
	
	@Test
	public void testPrimitiveTypesReferenceToOtherObject() throws BException, InterruptedException {	
		log.info("testPrimitiveTypesReferenceToOtherObject(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = new PrimitiveTypes();
		((PrimitiveTypes)obj1.objVal).intVal = 456;
		
		remote.setPrimitiveTypes(obj1);
		PrimitiveTypes objR = remote.getPrimitiveTypes();
		
		TestUtils.assertEquals(log,  "PrimitiveTypes", obj1, objR);
		TestUtils.assertTrue(log, "this.objVal != this.objVal2", objR.objVal == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToOtherObject");
	}
	
	@Test
	public void testPrimitiveTypesReferenceToSelf() throws BException, InterruptedException {	
		log.info("testPrimitiveTypesReferenceToSelf(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = obj1;
		
		remote.setPrimitiveTypes(obj1);
		PrimitiveTypes objR = remote.getPrimitiveTypes();
		
		TestUtils.assertTrue(log, "this != this.objVal", objR == objR.objVal);
		TestUtils.assertTrue(log, "this != this.objVal2", objR == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToSelf");
	}


}
