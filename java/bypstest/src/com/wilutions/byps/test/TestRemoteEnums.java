package com.wilutions.byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.enu.EnumPlanets;
import com.wilutions.byps.test.api.remote.RemoteEnums;

/**
 * Tests for interface functions with enum types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteEnums {
	
	BClient_Testser client;
	RemoteEnums remote;
	private Log log = LogFactory.getLog(TestRemoteEnums.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.remoteEnums;
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testRemoteEnums() throws RemoteException {
		log.info("testRemoteEnums(");
		remote.setPlanet(EnumPlanets.Earth);
		EnumPlanets r = remote.getPlanet();
		TestUtils.assertEquals(log, "enum", EnumPlanets.Earth, r);
		
		log.info(")testRemoteEnums");
	}
	
}
