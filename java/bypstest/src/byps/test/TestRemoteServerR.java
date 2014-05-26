package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BAsyncResult;
import byps.BAsyncResultIgnored;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BProtocolJson;
import byps.BProtocolS;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.srvr.BSkeleton_ClientIF;
import byps.test.api.srvr.ClientIF;
import byps.test.api.srvr.ServerIF;
import byps.test.api.srvr.ServerIFAsync;

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
	ServerIFAsync remote;
	private Log log = LogFactory.getLog(TestRemoteServerR.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getServerIF();
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
		
		for (int i = 0; i < 100; i++) {
			testCallClientFromClientOnOtherServer();
		}
		
		for (int i = 0; i < 0; i++) {
			Thread.sleep(rand.nextInt(1000));
			testCallClient1FromServer1();
			tearDown(); setUp();
			testCallClient2FromServer1();
			tearDown(); setUp();
			testCallClientFromClientSameServer();
			tearDown(); setUp();
			testCallClientFromClientOnOtherServer();
			tearDown(); setUp();
			testCallClientFromServer();
			tearDown(); setUp();
			testCallClientFromServerNoRemoteImpl();
			tearDown(); setUp();
			testCallDeadClientFromClient();
			tearDown(); setUp();
//			testCallKilledClientFromClient(); might hang due to Tomcat bug, see javadoc of testCallKilledClientFromClient()
//			tearDown(); setUp();
			testPutStreamFromClientToClientSameServer();
			tearDown(); setUp();
			testPutStreamFromClientToClientOnOtherServer();
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
	public void testCallClientFromServer() throws RemoteException {
		log.info("testCallClientFromServer(");
		
		// (1) Provide implementation for interface ClientIF
		client.addRemote(new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
				if (a == -1) throw new BException(123, "Test exception");
				if (a == -2) throw new IllegalStateException("Test error");
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
		
    checkException_callClientIncrementInt(remote);
    
		
		log.info(")testCallClientFromServer");
	}

  private void checkException_callClientIncrementInt(ServerIF remote2) {
    try {
      remote2.callClientIncrementInt(-1);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", 123, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test exception") >= 0);
    }

    try {
      remote2.callClientIncrementInt(-2);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", BExceptionC.REMOTE_ERROR, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test error") >= 0);
    }
  }
	
	/**
	 * Call a server function which in turn calls a client function many times simultaneously.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClientFromServerParallel() throws RemoteException {
		log.info("testCallClientFromServerParallel(");
		
		int nbOfReverseRequests = 10;
		
		// (1) Provide implementation for interface ClientIF
		BClient_Testser client = TestUtilsHttp.createClient(nbOfReverseRequests);
		client.addRemote(new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new BException(BExceptionC.CANCELLED, e.toString(), e);
				}
				log.info(")incrementInt");
				return 1;
			}
		});
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// from step (1)
		log.info("callClientIncrementInt...");
		int r = client.getServerIF().callClientParallel(nbOfReverseRequests);
		log.info("callClientIncrementInt OK");
		
		TestUtils.assertEquals(log, "callClientParallel", 10, r);
		
		log.info(")testCallClientFromServer");
	}
	
	/**
	 * The server tries to use a non-existing client interface implementation.
	 * This must cause an exception. The call must not hang.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClientFromServerNoRemoteImpl() throws RemoteException {
		log.info("testCallClientFromServerNoRemoteImpl(");
		
		// Do not provide an implementation for the requested interface 
		// omit: client.addRemote(new BSkeleton_ClientIF() { ...
		
		try {
			remote.callClientIncrementInt(5);
			Assert.fail("Exception expected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BExceptionC.SERVICE_NOT_IMPLEMENTED, e.code);
		}
		
		log.info(")testCallClientFromServerNoRemoteImpl");
	}

	/**
	 * Call an interface method of another client. 
	 * Both clients are connected to the same server.
	 * However, both servers must be started.
	 * @throws InterruptedException 
	 * @throws BException 
	 */
	@Test
	public void testCallClientFromClientSameServer() throws RemoteException {
		log.info("testCallClientFromClientSameServer(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF remoteImplOfClient2 = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
        if (a == -1) throw new BException(123, "Test exception");
        if (a == -2) throw new IllegalStateException("Test error");
				return a + 11;
			}
		};
		
		// Create second client connected to the same server
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(remoteImplOfClient2);
		
		// Publish the interface to all servers
		client2.getRemoteServerCtrl().publishRemote("remoteOfClient2", remoteImplOfClient2, true);
		
		// First client queries for published interface.
		// The interface should have been transferred to Server1.
		ClientIF remoteOfClient2 = (ClientIF)client.getRemoteServerCtrl().getPublishedRemote("remoteOfClient2");
		TestUtils.assertTrue(log, "Cannot get interface to client2", remoteOfClient2 != null);
		
		// Invoke interface of second client.
		int r = remoteOfClient2.incrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 18, r);
		
    try {
      remoteOfClient2.incrementInt(-1);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", 123, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test exception") >= 0);
    }

    try {
      remoteOfClient2.incrementInt(-2);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", BExceptionC.REMOTE_ERROR, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test error") >= 0);
    }
		
		
		client2.getRemoteServerCtrl().removePublishedRemote("remoteOfClient2");
		
		client2.done();
		log.info(")testCallClientFromClientSameServer");
	}
	
	/**
	 * Call an interface method of another client. 
	 * The clients are connected to different servers.
	 * @throws InterruptedException 
	 * @throws BException 
	 */
	@Test
	public void testCallClientFromClientOnOtherServer() throws RemoteException {
		log.info("testCallClientFromClientOnOtherServer(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF remoteImplOfClient2 = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
        if (a == -1) throw new BException(123, "Test exception");
        if (a == -2) throw new IllegalStateException("Test error");
        return a + 1;
			}
		};
		
		// Create second client connected to Server2
		BClient_Testser client2 = TestUtilsHttp.createClient2();
		client2.addRemote(remoteImplOfClient2);
		
		// Publish the interface to all servers
		client2.getRemoteServerCtrl().publishRemote("remoteOfClient2", remoteImplOfClient2, true);
		
		// First client queries for published interface.
		// The interface should have been transferred to Server1.
		ClientIF remoteOfClient2 = (ClientIF)client.getRemoteServerCtrl().getPublishedRemote("remoteOfClient2");
		TestUtils.assertTrue(log, "Cannot get interface to client2", remoteOfClient2 != null);
		
		// Invoke interface of second client.
		for (int i = 0; i < 100; i++) {
			int r = remoteOfClient2.incrementInt(i);
			TestUtils.assertEquals(log, "incrementInt", i+1, r);
		}
		
		
    try {
      remoteOfClient2.incrementInt(-1);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", 123, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test exception") >= 0);
    }

    try {
      remoteOfClient2.incrementInt(-2);
    }
    catch (RemoteException e) {
      TestUtils.assertEquals(log, "Unexpected exception code", BExceptionC.REMOTE_ERROR, ((BException)e).code);
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Test error") >= 0);
    }

		
		client2.getRemoteServerCtrl().removePublishedRemote("remoteOfClient2");
		
		client2.done();
		log.info(")testCallClientFromClientOnOtherServer");
	}
		
	/**
	 * Call client2 interface from server-side of client1.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClient2FromServer1() throws RemoteException {
		log.info("testCallClient2FromServer1(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
        if (a == -1) throw new BException(123, "Test exception");
        if (a == -2) throw new IllegalStateException("Test error");
				return a + 1;
			}
		};
		
		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.getServerIF().setPartner(partner);
		
		// Invoke interface of second client from the server.
		int r = remote.callClientIncrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		checkException_callClientIncrementInt(remote);
		
		client2.done();
		log.info(")testCallClient2FromServer1");
	}

	/**
	 * Call client interface from the server-side of another server.
	 * This is similar to testCallClient2FromServer1. The difference is that the client 
	 * interface to be called is on another server.
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallClient2FromForeignServer1() throws RemoteException {
		log.info("testCallClient2FromForeignServer1(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
        if (a == -1) throw new BException(123, "Test exception");
        if (a == -2) throw new IllegalStateException("Test error");
				return a + 1;
			}
		};
		
		// Create client2, connected to Server2
		BClient_Testser client2 = TestUtilsHttp.createClient2();
		client2.addRemote(partner);
		
		// Pass the interface of the client2 to the server side of the first client
		client.getServerIF().setPartner(partner);
		
		// Invoke interface of second client from the server.
		int r = remote.callClientIncrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		checkException_callClientIncrementInt(remote);
		
		client2.done();
		log.info(")testCallClient2FromForeignServer1");
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
	public void testCallClient1FromServer1() throws RemoteException {
		log.info("testCallClient1FromServer1(");
		
		// Interface implementation for the first client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		
		// assign interface impl to client
		client.addRemote(partner);
		
		// Pass the interface of the client to the server side 
		client.getServerIF().setPartner(partner);
		
		// Invoke interface of client.
		int r = remote.callClientIncrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		log.info(")testCallClient1FromServer1");
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
	public void testCallDeadClientFromClient() throws RemoteException, InterruptedException {
		log.info("testCallDeadClientFromClient(");
		
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				return a+1;
			}
		};
		
		log.info("create second client");
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		log.info("submit interface of second client");
		client.getServerIF().setPartner(partner);
				
		log.info("receive interface of second client");
		ClientIF partnerIF = client.getServerIF().getPartner();
		
		// stop second client
		log.info("stop second client");
		client2.done();
		
		// The done() method throws BExceptionO.CANCELED messages inside the server.
		// If the next call came too early, it would be canceled by this exceptions
		// and the test would fail because it expects an exception code BExceptionO.CLIENT_DIED.
		Thread.sleep(1000);
		
		// first client calls interface method of second client
		try {
			log.info("invoke interface method of dead client");
			partnerIF.incrementInt(7);
			Assert.fail("Exception expcected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BExceptionC.CLIENT_DIED, e.code);
		}
		log.info(")testCallDeadClientFromClient");
	}
	
	/**
	 * Call an interface of a killed client.
	 * The first client calls an interface method of the second client while the second client has been killed.
	 * The second client did not send the cancel message to the server. 
	 * When the server tries to write the response, a ClientAbortException is throw internally. 
	 * It is caught and replaced by a BException with code BExceptionO.CLIENT_DIED.
	 * 
	 * A Tomcat bug causes this test to wait up to HConstants.REQUEST_TIMEOUT_MILLIS sometimes.
	 * See HWriteResponseHelper.writeResponse for more information. 
	 * 
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testCallKilledClientFromClient() throws RemoteException {
		log.info("testCallKilledClientFromClient(");
		
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				return a+1;
			}
		};
		
		log.info("create second client");
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		log.info("submit interface of second client");
		client.getServerIF().setPartner(partner);
				
		log.info("receive interface of second client");
		ClientIF partnerIF = client.getServerIF().getPartner();
		
		// stop second client
		log.info("kill second client");
		client2.getTransport().getWire().getTestAdapter().killClientConnections();
		
		// first client calls interface method of second client
		try {
			log.info("invoke interface method of dead client");
			partnerIF.incrementInt(7);
			Assert.fail("Exception expcected");
		}
		catch (BException e) {
			TestUtils.assertEquals(log, "exception", BExceptionC.CLIENT_DIED, e.code);
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
			public void putStreams(List<InputStream> streams, int ctrl) throws RemoteException {
				try {
					final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
					TestUtils.assertEquals(log, "streams.length", arr.size(), streams.size());
					for (int i = 0; i < arr.size(); i++) {
						TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), streams.get(i));
					}
				}
				catch (IOException e) {
					throw new BException(BExceptionC.IOERROR, "", e);
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
			public List<InputStream> getStreams(int ctrl) throws RemoteException {
				try {
					return TestUtilsHttp.makeTestStreams();
				} catch (IOException e) {
					throw new BException(BExceptionC.IOERROR, "", e);
				}
			}
		});
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// registered in step (1)
		log.info("call client...");
		List<InputStream> arrR = remote.getStreamsFromClient(true);
		log.info("call client OK");

		ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		TestUtils.assertEquals(log, "streams.length", arr.size(), arrR.size());
		for (int i = 0; i < arr.size(); i++) {
			TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), arrR.get(i));
		}
		
    // (3) Call server method, but do not materialize (buffer temporarily) the streams. 
    log.info("call client...");
    arrR = remote.getStreamsFromClient(false);
    log.info("call client OK");

    arr = TestUtilsHttp.makeTestStreams();
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
			public List<InputStream> getStreams(int ctrl) throws RemoteException {
				try {
					return TestUtilsHttp.makeTestStreams();
				} catch (IOException e) {
					throw new BException(BExceptionC.IOERROR, "", e);
				}
			}
		};

		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.getServerIF().setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.getServerIF().getPartner();
		
		log.info("call client...");
		List<InputStream> arrR = partnerIF.getStreams(0);
		log.info("call client OK");

		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		TestUtils.assertEquals(log, "streams.length", arr.size(), arrR.size());
		for (int i = 0; i < arr.size(); i++) {
			TestUtils.assertEquals(log, "stream[" + i + "]", arr.get(i), arrR.get(i));
		}
		
		TestUtils.checkTempDirEmpty(client);
		TestUtils.checkTempDirEmpty(client2);
		
		client2.done();

		log.info(")testReturnStreamFromClientToClient");
	}
	
	/**
	 * Transfer stream data between clients in an argument of an interface function.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testPutStreamFromClientToClientSameServer() throws InterruptedException, IOException {
		log.info("testPutStreamFromClientToClientSameServer(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public void putStreams(List<InputStream> streams, int ctrl) throws RemoteException {
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
					throw new BException(BExceptionC.IOERROR, "", e);
				}
				log.info(")putStreams");
			}
		};

		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.getServerIF().setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.getServerIF().getPartner();
		
		log.info("call client...");
		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		partnerIF.putStreams(arr, 0);
		log.info("call client OK");

    TestUtils.checkTempDirEmpty(client);
    TestUtils.checkTempDirEmpty(client2);
		
		client2.done();

		log.info(")testPutStreamFromClientToClientSameServer");
	}
	
	/**
	 * Transfer stream data between clients in an argument of an interface function.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void testPutStreamFromClientToClientOnOtherServer() throws InterruptedException, IOException {
		log.info("testPutStreamFromClientToClientOnOtherServer(");
		
		// Interface implementation for the second client
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public void putStreams(List<InputStream> streams, int ctrl) throws RemoteException {
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
					throw new BException(BExceptionC.IOERROR, "", e);
				}
				log.info(")putStreams");
			}
		};

		// Create second client
		BClient_Testser client2 = TestUtilsHttp.createClient2();
		client2.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		client.getServerIF().setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = client.getServerIF().getPartner();
		
		log.info("call client...");
		final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
		partnerIF.putStreams(arr, 0);
		log.info("call client OK");

    TestUtils.checkTempDirEmpty(client);
    TestUtils.checkTempDirEmpty(client2);

		client2.done();

		log.info(")testPutStreamFromClientToClientOnOtherServer");
	}	
	/**
	 * A client with JSON serialization calls another client with binary serialization.
	 * 
	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testJsonClientCallsBinClient() throws RemoteException {
		log.info("testJsonClientCallsBinClient(");
		
		// First client
		BClient_Testser clientJson = TestUtilsHttp.createClient(BProtocolJson.BINARY_MODEL, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, 1);
		
		// Create second client
		BClient_Testser clientBin = TestUtilsHttp.createClient(BProtocolS.BINARY_MODEL, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, 1);
		BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
			@Override
			public int incrementInt(int a) throws RemoteException {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
		};
		clientBin.addRemote(partner);
		
		// Pass the interface of the second client to the server side of the first client
		clientJson.getServerIF().setPartner(partner);
		
		// First client queries the interface of the second client from the server side
		ClientIF partnerIF = clientJson.getServerIF().getPartner();
		
		// Invoke interface of second client.
		int r = partnerIF.incrementInt(7);
		TestUtils.assertEquals(log, "incrementInt", 8, r);
		
		clientBin.done();
		clientJson.done();

		log.info(")testJsonClientCallsBinClient");
	}
	
  /**
   * A stream returned from the server can be passed from one client to another client.
   * It is not required to copy the stream.
   * @throws IOException 
   */
  @Test
  public void testHandoverStreamFromClientToClientSameServer() throws InterruptedException, IOException {
    handoverStreamFromClientToClient(false);
  } 
  
  /**
    * A stream returned from the server can be passed from one client to another client.
    * It is not required to copy the stream.
    * Clients are connected to different servers.
   * @throws IOException 
   */
  @Test
  public void testHandoverStreamFromClientToClientOtherServer() throws InterruptedException, IOException {
    handoverStreamFromClientToClient(true);
  } 
  
  private void handoverStreamFromClientToClient(boolean otherServer) throws IOException {
    log.info("handoverStreamFromClientToClient(otherServer=" + otherServer);
    
    // Interface implementation for the second client
    BSkeleton_ClientIF partner = new BSkeleton_ClientIF() {
      @Override
      public void putStreams(List<InputStream> streams, int ctrl) throws RemoteException {
        log.info("putStreams(" + streams.size());
        try {
          final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
          TestUtils.assertEquals(log, "#streams", arr.size(), streams.size());
          for (int i = 0; i < arr.size(); i++) {
            BContentStream estrm = (BContentStream)arr.get(i);
            BContentStream rstrm = (BContentStream)streams.get(i);
            TestUtils.assertEquals(log, "stream[" + i + "]="+ estrm, estrm, rstrm);
          }
        } catch (IOException e) {
          log.error(e);
          throw new BException(BExceptionC.IOERROR, "", e);
        }
        log.info(")putStreams");
      }
    };

    // Create second client
    BClient_Testser client2 = otherServer ? TestUtilsHttp.createClient2() : TestUtilsHttp.createClient();
    client2.addRemote(partner);
    
    // Pass the interface of the second client to the server side of the first client
    client.getServerIF().setPartner(partner);
    
    // First client queries the interface of the second client from the server side
    ClientIF partnerIF = client.getServerIF().getPartner();
   
    // Upload test streams to the server.
    // Obtain the streams from the server - but do not download the contents.
    final ArrayList<InputStream> arr = TestUtilsHttp.makeTestStreams();
    final ArrayList<InputStream> receivedStreams = new ArrayList<InputStream>();
    for (InputStream istream : arr) {
      // Upload
      client.getRemoteStreams().setImage(istream);
      // Get stream object from server
      InputStream rstream = client.getRemoteStreams().getImage();
      receivedStreams.add(rstream);
    }
    client.getRemoteStreams().setImage(null);
    
    // Send stream objects (which are not downloaded) to the other client.
    log.info("call client...");
    partnerIF.putStreams(receivedStreams, 0);
    log.info("call client OK");

    TestUtils.checkTempDirEmpty(client);
    TestUtils.checkTempDirEmpty(client2);

    client2.done();

    log.info(")handoverStreamFromClientToClient");
    
  }

  
  /**
   * This test simulates a pause time where the client has no active long-pool 
   * and the server tries to contact the client.
   * @throws RemoteException
   * @throws InterruptedException
   */
  @Test
  public void testServerCallsClientNoActiveLongPoll() throws RemoteException, InterruptedException{
    log.info("testServerCallsClientNoActiveLongPoll(");
        
    final boolean[] holdClient = new boolean[] {true};
    final AtomicInteger r1 = new AtomicInteger();
    final AtomicInteger r2 = new AtomicInteger();
    final AtomicInteger r3 = new AtomicInteger();
    final AtomicReference<Throwable> ex = new AtomicReference<Throwable>();
    final CountDownLatch countDown = new CountDownLatch(3);
    
    BClient_Testser client = TestUtilsHttp.createClient(1);
    ServerIFAsync remote = client.getServerIF();
    
    // Provide implementation for interface ClientIF
    client.addRemote(new BSkeleton_ClientIF() {
      @Override
      public int incrementInt(int a) throws RemoteException {
        log.info("incrementInt(" + a + ")");
        
        try {
          synchronized(holdClient) {
            while (holdClient[0]) {
              // (1) wait until (4)
              holdClient.wait(100*1000);
            }
          }
        }
        catch (Throwable e) {
        }

        return a + 1;
      }
    });
    
    // (2) Trigger one client invocation to allocate the current active long-poll.
    // The client will receive the request and will wait in (1).
    remote.callClientIncrementInt(0, new BAsyncResultIgnored<Integer>());
    
    // (3) Trigger server to invoke client.
    // Server will try to send requests to the client but there is no open long-poll.
    // Server has to wait until it receives a long-poll.
    internalCallClientAsync(remote, 5, r1, ex, countDown);
    internalCallClientAsync(remote, 6, r2, ex, countDown);
    internalCallClientAsync(remote, 7, r3, ex, countDown);
    
    // (4) release the long-pool hold in (1).
    synchronized(holdClient) {
      holdClient[0] = false;
      holdClient.notifyAll();
    }
    
    // Now the server can send the pending requests from (3) 
    // to the client.
    
    // Wait until all requests were processed.
    countDown.await(10, TimeUnit.SECONDS);
    
    TestUtils.assertEquals(log, "r1", 6, r1.get());
    TestUtils.assertEquals(log, "r2", 7, r2.get());
    TestUtils.assertEquals(log, "r3", 8, r3.get());

    log.info(")testServerCallsClientNoActiveLongPoll");
  }

  private void internalCallClientAsync(ServerIFAsync remote, int value, final AtomicInteger r1, final AtomicReference<Throwable> ex, final CountDownLatch countDown) {
    remote.callClientIncrementInt(value, new BAsyncResult<Integer>() {
      public void setAsyncResult(Integer result, Throwable exception) {
        if (exception != null) {
          ex.set(exception);
        }
        else {
          r1.set(result);
        }
        countDown.countDown();
      }
    });
  }
}
