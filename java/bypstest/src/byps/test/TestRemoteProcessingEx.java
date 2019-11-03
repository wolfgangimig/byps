package byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;

/**
 * Tests for continuing after a BExceptionC#PROCESSING.
 * 
 * BYPS-9: Avoid socket exception while uploading large files.
 */
public class TestRemoteProcessingEx {
	
	BClient_Testser client;
	private Log log = LogFactory.getLog(TestRemoteProcessingEx.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	/**
	 * Test continue processing after BExceptionC#PROCESSING.
	 * @throws RemoteException
	 */
	@Test
	public void testContinueOnProcessingException() throws RemoteException {
		log.info("testContinueOnProcessingException(");
		
		// Set 1s timeout until BExceptionC#PROCESSING is thrown.
		client.getTransport().getWire().getTestAdapter().setTimeoutForProcessingException(1);
		try {
		  
		  for (int i = 0; i < 20; i++) {
		    int sleepSeconds = i % 5;
		    
		    // Invoke a function that sleeps for some seconds. 
		    // A BExceptionC#PROCESSING might be processed several times.
		    boolean ret = client.getRemoteProcessingEx().getValueAfterProcessingExceptions(sleepSeconds);
		    log.info("getValueAfterProcessingExceptions=" + ret);
		  }
		}
		finally {
		  
		  // Reset timeout to default.
		  client.getTransport().getWire().getTestAdapter().setTimeoutForProcessingException(0);
		}
		
		log.info(")testContinueOnProcessingException");
	}
	

}
