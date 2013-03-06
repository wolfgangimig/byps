package com.wilutions.byps.test;

import java.util.Arrays;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.remote.FirstException;
import com.wilutions.byps.test.api.remote.RemoteException;
import com.wilutions.byps.test.api.remote.SecondException;

/**
 * Tests for interface functions with list types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteException {
	
	BClient_Testser client;
	RemoteException remote;
	private Log log = LogFactory.getLog(TestRemoteException.class);

	@Before
	public void setUp() throws BException, InterruptedException {
		client = TestUtilsHttp.createClient();
		remote = client.remoteException;
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testThrowBException() {
		log.info("testThrowBException(");
		try {
			remote.throwBException(123, "teststring");
			Assert.fail("Exception expected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "code", 123, e.code);
			TestUtils.assertEquals(log, "msg", "teststring", e.msg);
			TestUtils.assertEquals(log, "details", "java.io.IOException: Hello IOException", e.details);
		}
		catch (Throwable e) {
			Assert.fail("Wrong exception: " + e);
		}
		log.info(")testThrowBException");
		
	}
	
	@Test
	public void testThrowFirstException() {
		log.info("testThrowFirstException(");
		try {
			remote.throwFirstException();
			Assert.fail("Exception expected");
		}
		catch (FirstException e) {
			log.info("cause=" + e.getCause());
			log.info("strings=" + e.listOfStrings);
			
			SecondException expectedCause = new SecondException("illegal state thrown from MyRemoteException");
			TestUtils.assertEquals(log, "cause", expectedCause, e.getCause());
			
			TestUtils.assertEquals(log, "string", Arrays.asList("string1", "string2"), e.listOfStrings);
		}
		catch (Throwable e) {
			Assert.fail("Wrong exception: " + e);
		}
		log.info(")testThrowFirstException");
	}
	
	@Test
	public void testThrowException() {
		log.info("testThrowException(");
		try {
			remote.throwException(1);
			Assert.fail("Exception expected");
		}
		catch (FirstException e) {
			TestUtils.assertEquals(log, "ex", new FirstException(), e);
		}
		catch (Throwable e) {
			Assert.fail("Wrong exception: " + e);
		}
		
		try {
			remote.throwException(2);
			Assert.fail("Exception expected");
		}
		catch (SecondException e) {
			TestUtils.assertEquals(log, "ex", new SecondException(""), e);
		}
		catch (Throwable e) {
			Assert.fail("Wrong exception: " + e);
		}
		log.info(")testThrowException");
	}
	
	@Test
	public void testThrowNPE() {
		log.info("testThrowNPE(");
		try {
			remote.throwNullPointerException();
			Assert.fail("Exception expected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "code", BException.REMOTE_ERROR, e.code);
			TestUtils.assertEquals(log, "msg", "", e.msg);
			TestUtils.assertEquals(log, "details", "java.lang.NullPointerException", e.details);
		}
		catch (Throwable e) {
			Assert.fail("Wrong exception: " + e);
		}
		log.info(")testThrowNPE");
		
	}
	
	
}
