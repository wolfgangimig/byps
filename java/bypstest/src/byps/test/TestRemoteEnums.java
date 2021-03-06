package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.enu.EnumPlanets;
import byps.test.api.remote.RemoteEnums;

/**
 * Tests for interface functions with enum types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteEnums {
	
	BClient_Testser client;
	RemoteEnums remote;
	private Logger log = LoggerFactory.getLogger(TestRemoteEnums.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemoteEnums();
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
