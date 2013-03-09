package com.wilutions.byps.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BWire;
import com.wilutions.byps.test.api.BApiDescriptor_Testser;
import com.wilutions.byps.test.api.BClient_Testser;
import com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF;
import com.wilutions.byps.test.api.srvr.ClientIF;
import com.wilutions.byps.test.api.srvr.ServerIF;

/**
 * The test cases in this class verify that the server is able to invoke an 
 * interface method on the client.
 * Furthermore it checks, whether a client can invoke another client.
 * Streams can be sent from the server back to the client and between clients.
 * Communication between clients work even if one client uses JSON serialization 
 * and the other one uses binary serialization.
 */
public class TestRemoteServerR {
	
	BClient_Testser client;
	ServerIF remote;
	private Log log = LogFactory.getLog(TestRemoteServerR.class);

	@Before
	public void setUp() throws BException, InterruptedException {
		client = TestUtilsHttp.createClient();
		remote = client.serverIF;
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	//@Test
	public void testSimultan() throws InterruptedException {
		Executor tpool = Executors.newCachedThreadPool();
		int nbOfThreads = 5;
		final CountDownLatch cdl = new CountDownLatch(nbOfThreads);
		for (int t = 0; t < nbOfThreads; t++) {
			Runnable run = new Runnable() {
				public void run() {
					TestRemoteServerR testObj = new TestRemoteServerR();
					try {
						testObj.testLoop10();
					} catch (Throwable e) {
						log.error("exception", e);
					}
					finally {
						cdl.countDown();
					}
				}
			};
			tpool.execute(run);
		}
		cdl.await();
	}
	
	final Random rand = new Random();

	//@Test
	public void testLoop10() throws InterruptedException, IOException {
		setUp();
		for (int i = 0; i < 1; i++) {
			Thread.sleep(rand.nextInt(1000));
			testCallClient1FromServer1();
			tearDown(); setUp();
			testCallClient2FromServer1();
			tearDown(); setUp();
			testCallClientFromClient();
			tearDown(); setUp();
			testCallClientFromClientThrowEx();
			tearDown(); setUp();
			testCallClientFromServer();
			tearDown(); setUp();
			testCallClientFromServerNoRemoteImpl();
			tearDown(); setUp();
			testCallDeadClientFromClient();
			tearDown(); setUp();
//			testCallKilledClientFromClient(); might hang due to Tomcat bug, see javadoc of testCallKilledClientFromClient()
//			tearDown(); setUp();
			testPutStreamFromClientToClient();
			tearDown(); setUp();
			testReturnStreamFromClientToClient();
			tearDown(); setUp();
			testServerProvidesStreamForClient();
			tearDown(); setUp();
			testServerRequestsStreamFromClient();
			tearDown(); setUp();
		}
		tearDown();
	}
	

	/**
	 * Call a server function which in turn calls a client function.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClientFromServer() throws BException, InterruptedException {
		log.info("testCallClientFromServer(");
		
		// (1) Provide implementation for interface ClientIF
		client.addRemote(new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		});
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// from step (1)
		log.info("callClientIncrementInt...");
		int r = remote.callClientIncrementInt(5);
		log.info("callClientIncrementInt OK");
		
		TestUtils.assertEquals(log, "incrementInt", 6, r);
		
		log.info(")testCallClientFromServer");
	}
	
	/**
	 * The server tries to use a non-existing client interface implementation.
	 * This must cause an exception. The call must not hang.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClientFromServerNoRemoteImpl() throws BException, InterruptedException {
		log.info("testCallClientFromServerNoRemoteImpl(");
		
		// Do not provide an implementation for the requested interface 
		// omit: client.addRemote(new BSkeleton_ClientIF() { ...
		
		try {
			remote.callClientIncrementInt(5);
			Assert.fail("Exception expected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BException.SERVICE_NOT_IMPLEMENTED, e.code);
		}
		
		log.info(")testCallClientFromServerNoRemoteImpl");
	}

	/**
	 * Call an interface method of another client. 
	 * @throws InterruptedException 
	 * @throws BException 
	 */
	@Test
	public void testCallClientFromClient() throws BException, InterruptedException {
		log.info("testCallClientFromClient(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		
		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.serverIF.setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.serverIF.getPartner();
		
		// Invoke interface of second client.
		int r = partnerIF.incrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		client2.done();
		log.info(")testCallClientFromClient");
	}
	
	/**
	 * Call client2 interface from server-side of client1.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClient2FromServer1() throws BException, InterruptedException {
		log.info("testCallClient2FromServer1(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		
		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.serverIF.setPartner(partner);
		
		// Invoke interface of second client.
		int r = remote.callClientIncrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		client2.done();
		log.info(")testCallClient2FromServer1");
	}

	/**
	 * Call client1 interface from server-side of client1.
	 * This is another way to call the client-side from the server-side as 
	 * tested in testCallClientFromServer.
	 * It makes sure that all we can do with other client interfaces, we
	 * can do with the own client interface too.
	 * @throws BException
	 * @throws InterruptedException
	 * @see testCallClientFromServer
	 */
	@Test
	public void testCallClient1FromServer1() throws BException, InterruptedException {
		log.info("testCallClient1FromServer1(");
		
		// Interface implementation for the first client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		
		// assign interface impl to client
		client.addRemote(partner);
		
		// Pass the interface of the client to the server side 
		client.serverIF.setPartner(partner);
		
		// Invoke interface of client.
		int r = remote.callClientIncrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		log.info(")testCallClient1FromServer1");
	}

	@Test
	public void testCallClientFromClientThrowEx() throws BException, InterruptedException {
		log.info("testCallClientFromClientThrowEx(");
		
		final int exceptionCode = 1111;
		
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				throw new BException(exceptionCode, "my exception", "details");
			}
		};
		
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		client.serverIF.setPartner(partner);
		
		ClientIF partnerIF = client.serverIF.getPartner();
		try {
			partnerIF.incrementInt(7);
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", exceptionCode, e.code);
		}
		
		client2.done();
		log.info(")testCallClientFromClientThrowEx");
	}
	
	/**
	 * Call an interface of a dead client.
	 * The first client calls an interface method of the second client while the second client is no more listening.
	 * The second client has sent the cancel message to the server. 
	 * Thus the server does know, that the client does not listen anymore.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallDeadClientFromClient() throws BException, InterruptedException {
		log.info("testCallDeadClientFromClient(");
		
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				return a+1;
			}
		};
		
		log.info("create second client");
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		log.info("submit interface of second client");
		client.serverIF.setPartner(partner);
				
		log.info("receive interface of second client");
		ClientIF partnerIF = client.serverIF.getPartner();
		
		// stop second client
		log.info("stop second client");
		client2.done();
		
		// The done() method throws BException.CANCELED messages inside the server.
		// If the next call came too early, it would be canceled by this exceptions
		// and the test would fail because it expects an exception code BException.CLIENT_DIED.
		Thread.sleep(1000);
		
		// first client calls interface method of second client
		try {
			log.info("invoke interface method of dead client");
			partnerIF.incrementInt(7);
			Assert.fail("Exception expcected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BException.CLIENT_DIED, e.code);
		}
		log.info(")testCallDeadClientFromClient");
	}
	
	/**
	 * Call an interface of a killed client.
	 * The first client calls an interface method of the second client while the second client has been killed.
	 * The second client did not send the cancel message to the server. 
	 * When the server tries to write the response, a ClientAbortException is throw internally. 
	 * It is caught and replaced by a BException with code BException.CLIENT_DIED.
	 * 
	 * A Tomcat bug causes this test to wait up to HConstants.REQUEST_TIMEOUT_MILLIS sometimes.
	 * See HWriteResponseHelper.writeResponse for more information. 
	 * 
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallKilledClientFromClient() throws BException, InterruptedException {
		log.info("testCallKilledClientFromClient(");
		
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				return a+1;
			}
		};
		
		log.info("create second client");
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		log.info("submit interface of second client");
		client.serverIF.setPartner(partner);
				
		log.info("receive interface of second client");
		ClientIF partnerIF = client.serverIF.getPartner();
		
		// stop second client
		log.info("kill second client");
		client2.transport.wire.getTestAdapter().killClientConnections();
		
		// first client calls interface method of second client
		try {
			log.info("invoke interface method of dead client");
			partnerIF.incrementInt(7);
			Assert.fail("Exception expcected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BException.CLIENT_DIED, e.code);
		}
		log.info(")testCallKilledClientFromClient");
	}

	/**
	 * Server calls a client interface and sends InputStreams.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testServerProvidesStreamForClient() throws InterruptedException, IOException {
		log.info("testServerProvidesStreamForClient(");
		
		// (1) Provide implementation for interface ClientIF
		client.addRemote(new BSkeleton_ClientIF() {
			@Override
			public void putStreams(List<InputStream> streams, int ctrl) throws BException, InterruptedException {
				try {
					final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
					TestUtils.assertEquals(log, "streams.length", arr.size(), streams.size());
					for (int i = 0; i < arr.size(); i++) {
						TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), streams.get(i));
					}
				}
				catch (IOException e) {
					throw new BException(BException.IOERROR, "", e);
				}
			}
		});
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// registered in step (1)
		log.info("call client...");
		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		remote.putStreamsOnClient(arr);
		log.info("call client OK");
		
		log.info(")testServerProvidesStreamForClient");
	}

	/**
	 * The server calls the client to receive an input stream
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testServerRequestsStreamFromClient() throws InterruptedException, IOException {
		log.info("testServerRequestsStreamFromClient(");
				
		// (1) Provide implementation for interface ClientIF
		client.addRemote(new BSkeleton_ClientIF() {
			@Override
			public List<InputStream> getStreams(int ctrl) throws BException,InterruptedException {
				try {
					return TestUtilsHttp.makeTestStreams();
				} catch (IOException e) {
					throw new BException(BException.IOERROR, "", e);
				}
			}
		});
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// registered in step (1)
		log.info("call client...");
		List<InputStream> arrR = remote.getStreamsFromClient();
		log.info("call client OK");

		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		TestUtils.assertEquals(log, "streams.length", arr.size(), arrR.size());
		for (int i = 0; i < arr.size(); i++) {
			TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), arrR.get(i));
		}
		
		log.info(")testServerRequestsStreamFromClient");
	}
	
	/**
	 * Transfer stream data between clients in a return value of an interface function.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testReturnStreamFromClientToClient() throws InterruptedException, IOException {
		log.info("testReturnStreamFromClientToClient(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public List<InputStream> getStreams(int ctrl) throws BException,InterruptedException {
				try {
					return TestUtilsHttp.makeTestStreams();
				} catch (IOException e) {
					throw new BException(BException.IOERROR, "", e);
				}
			}
		};

		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.serverIF.setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.serverIF.getPartner();
		
		log.info("call client...");
		List<InputStream> arrR = partnerIF.getStreams(0);
		log.info("call client OK");

		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		TestUtils.assertEquals(log, "streams.length", arr.size(), arrR.size());
		for (int i = 0; i < arr.size(); i++) {
			TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), arrR.get(i));
		}
		
		client2.done();


		log.info(")testReturnStreamFromClientToClient");
	}
	
	/**
	 * Transfer stream data between clients in an argument of an interface function.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testPutStreamFromClientToClient() throws InterruptedException, IOException {
		log.info("testPutStreamFromClientToClient(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public void putStreams(List<InputStream> streams, int ctrl) throws BException, InterruptedException {
				log.info("putStreams(" + streams.size());
				try {
					final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
					TestUtils.assertEquals(log, "#streams", arr.size(), streams.size());
					for (int i = 0; i < arr.size(); i++) {
						BContentStream estrm = (BContentStream)arr.get(i);
						BContentStream rstrm = (BContentStream)streams.get(i);
						log.info("compare streams, estrm.length=" + estrm.getContentLength() + ", rstrm.length=" + rstrm.getContentLength());
						TestUtils.assertEquals(log, "stream[" + i + "]", estrm, rstrm);
					}
				} catch (IOException e) {
					log.error(e);
					throw new BException(BException.IOERROR, "", e);
				}
				log.info(")putStreams");
			}
		};

		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.serverIF.setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.serverIF.getPartner();
		
		log.info("call client...");
		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		partnerIF.putStreams(arr, 0);
		log.info("call client OK");

		client2.done();

		log.info(")testPutStreamFromClientToClient");
	}
	
	/**
	 * A client with JSON serialization calls another client with binary serialization.
	 * 
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testJsonClientCallsBinClient() throws BException, InterruptedException {
		log.info("testJsonClientCallsBinClient(");
		
		// First client
		BClient_Testser clientJson = TestUtilsHttp.createClient(BBinaryModel.JSON, BWire.FLAG_DEFAULT, BApiDescriptor_Testser.VERSION);
		
		// Create second client
		BClient_Testser clientBin = TestUtilsHttp.createClient(BBinaryModel.MEDIUM, BWire.FLAG_DEFAULT, BApiDescriptor_Testser.VERSION);
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws BException, InterruptedException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		clientBin.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		clientJson.serverIF.setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = clientJson.serverIF.getPartner();
		
		// Invoke interface of second client.
		int r = partnerIF.incrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		clientBin.done();
		clientJson.done();

		log.info(")testJsonClientCallsBinClient");
	}
}