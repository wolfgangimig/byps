package com.wilutions.byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BSyncResult;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.remote.RemotePrimitiveTypesAsync;

/**
 * Test asynchronous execution.
 */
public class TestRemoteAsyncCall {
	
	BClient_Testser client;
	RemotePrimitiveTypesAsync remote;
	private Log log = LogFactory.getLog(TestRemoteAsyncCall.class);

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
	public void testRemotePrimitiveTypesAsync() throws BException, InterruptedException {
		log.info("testRemotePrimitiveTypesAsync(");
		
		BSyncResult<Object> result = new BSyncResult<Object>();
		remote.async_setInt(1122, result);
		result.getResult();
		
		BSyncResult<Integer> result2 = new BSyncResult<Integer>();
		remote.async_getInt(result2);
		int valueR = result2.getResult();
		TestUtils.assertEquals(log, "async_getInt", 1122, valueR);
		
		log.info(")testRemotePrimitiveTypesAsync");
	}
	
}