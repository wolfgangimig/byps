package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BException;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.ver.BSkeleton_EvolveIF;
import byps.test.api.ver.Evolve;
import byps.test.api.ver.EvolveIF;

/**
 * Verifies that client and server can communicate if their API classes are of different versions.
 * For binary serialization, the transport version has to be negotiated. It is the 
 * lower one of client and server version.
 * @see TestSerializeDifferentVersions
 */
public class TestRemoteDifferentVersions {
	
	private Log log = LogFactory.getLog(TestRemoteDifferentVersions.class);

	@Before
	public void setUp() throws RemoteException {
	}
	
	@After
	public void tearDown() throws RemoteException {
		setServerAppVersion(BApiDescriptor_Testser.VERSION);
	}
	
	/**
	 * Checks serialization between client and server.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testClientCallsServer() throws RemoteException {
		log.info("testClientCallsServer(");
		
		for (int clientVersion = 0; clientVersion < 5; clientVersion++) {
			for (int serverVersion = 0; serverVersion < 5; serverVersion++) {
				internaltestClientCallsServer(clientVersion, serverVersion);
			}
		}
		
		log.info(")testClientCallsServer");
	}
	
	private void internaltestClientCallsServer(int clientVersion, int serverVersion) throws RemoteException {
		log.info("internaltestClientCallsServer(clientVersion=" + clientVersion + ", serverVersion=" + serverVersion);
		Evolve obj = TestSerializeDifferentVersions.createEvolve(clientVersion);
		
		setServerAppVersion(serverVersion);
		
		BClient_Testser client2 = TestUtilsHttp.createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, clientVersion);
		client2.getEvolveIF().setEvolve(obj);
		Evolve objR = client2.getEvolveIF().getEvolve();
		
		TestSerializeDifferentVersions.compareEvolve(log, obj, objR, clientVersion, serverVersion);
		
		client2.done();

		log.info(")internaltestClientCallsServer");
	}

	/**
	 * Set the server version via the BWire.testAdapter function.
	 * @param version
	 * @throws BException
	 * @throws InterruptedException
	 */
	private void setServerAppVersion(long version) throws RemoteException {
		BClient_Testser client = TestUtilsHttp.createClient();
		client.getTransport().getWire().getTestAdapter().setServerAppVersion(version);
		client.done();
	}
	
	/**
	 * Check serialization between server and client via long-poll.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testServerCallsClient() throws RemoteException {
		log.info("testServerCallsClient(");
		
		for (int clientVersion = 0; clientVersion < 5; clientVersion++) {
			for (int serverVersion = 0; serverVersion < 5; serverVersion++) {
				internaltestServerCallsClient(clientVersion, serverVersion);
			}
		}
		
		log.info(")testServerCallsClient");
	}
	
	private void internaltestServerCallsClient(int clientVersion, int serverVersion) throws RemoteException {
		log.info("internaltestServerCallsClient(clientVersion=" + clientVersion + ", serverVersion=" + serverVersion);
		
		setServerAppVersion(serverVersion);
		
		// This array receives the result in item 0.
		final Evolve[] refObj = new Evolve[1];
		
		// Create a client and provide the setEvolve function.
		BClient_Testser client2 = TestUtilsHttp.createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, clientVersion);
		client2.addRemote(new BSkeleton_EvolveIF() {
			@Override
			public void setEvolve(Evolve obj) throws RemoteException {
				// store into array element 0
				refObj[0] = obj;
			}
		});
		
		// Create a sample object and store it on the server side, see MyEvolve class.
		Evolve obj = TestSerializeDifferentVersions.createEvolve(clientVersion);
		client2.getEvolveIF().setEvolve(obj);
		
		// Send the object back to the client.
		client2.getEvolveIF().sendEvolveToClient();
		
		TestSerializeDifferentVersions.compareEvolve(log, obj, refObj[0], clientVersion, serverVersion);
		
		client2.done();

		log.info(")internaltestServerCallsClient");
	}

	/**
	 * Check serialization between two clients.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testClientCallsAnotherClient() throws RemoteException {
		log.info("testClientCallsAnotherClient(");
		
		for (int clientVersion = 0; clientVersion < 5; clientVersion++) {
			for (int clientVersion2 = 0; clientVersion2 < 5; clientVersion2++) {
				internaltestClientCallsAnotherClient(clientVersion, clientVersion2);
			}
		}
		
		log.info(")testClientCallsAnotherClient");
	}
	
	private void internaltestClientCallsAnotherClient(int clientVersion, int clientVersion2) throws RemoteException {
		log.info("internaltestClientCallsAnotherClient(clientVersion=" + clientVersion + ", clientVersion2=" + clientVersion2);
		
		
		BClient_Testser client1 = TestUtilsHttp.createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, clientVersion);
		
		// This array receives the result in item 0.
		final Evolve[] refObj = new Evolve[1];
		
		// Create a client and provide the setEvolve function.
		BSkeleton_EvolveIF remote2 = new BSkeleton_EvolveIF() {
			@Override
			public void setEvolve(Evolve obj) throws RemoteException {
				// store into array element 0
				refObj[0] = obj;
			}
		};
		BClient_Testser client2 = TestUtilsHttp.createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, clientVersion2);
		client2.addRemote(remote2);
		
		// Pass interface of client2 to the server-side of client1
		client1.getEvolveIF().setClient(remote2);
		
		// Read this interface from the server
		EvolveIF remoteOfClient2 = client1.getEvolveIF().getClient();
		
		// Create a sample object and pass it to the interface of client2.
		Evolve obj = TestSerializeDifferentVersions.createEvolve(clientVersion);
		remoteOfClient2.setEvolve(obj);
		
		TestSerializeDifferentVersions.compareEvolve(log, obj, refObj[0], clientVersion, clientVersion2);
		
		client1.done();
		client2.done();
		
		log.info(")internaltestClientCallsAnotherClient");
	}

}