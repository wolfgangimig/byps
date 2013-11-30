/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.srvr;
using System.Collections.Generic;
using System.IO;
using System.Threading;

namespace bypstest
{
    [TestClass]
    public class TestRemoteServerR
    {
        Log log = LogFactory.getLog(typeof(TestRemoteServerR));
        BClient_Testser client;
        ServerIF remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient();
            remote = client.ServerIF;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        private class ClientIFimpl : BSkeleton_ClientIF
        {
            Log log = LogFactory.getLog(typeof(TestRemoteServerR));

 			public override int IncrementInt(int a) 
            {
				log.info("incrementInt(" + a + ")");
				return a + 1;
			}
        }

        [TestMethod]
	    public void testCallClientFromServer() 
        {
		    log.info("testCallClientFromServer(");
		
		    // (1) Provide implementation for interface ClientIF
            client.addRemote(new ClientIFimpl());
		
		    // (2) Call server method. 
		    // On the server, this method calls the client-side interface 
		    // registered in step (1)
		    log.info("callClientIncrementInt...");
		    int r = remote.CallClientIncrementInt(5);
		    log.info("callClientIncrementInt OK");
		
		    TestUtils.assertEquals(log, "incrementInt", 6, r);

 		    log.info(")testCallClientFromServer");
	    }
	
        [TestMethod]
	    public void testCallClientFromServerNoRemoteImpl() 
        {
		    log.info("testCallClientFromServerNoRemoteImpl(");
		
		    // Do not provide an implementation for the requested interface 
		    // omit: client.addRemote(new BSkeleton_ClientIF() { ...
		
		    try {
			    remote.CallClientIncrementInt(5);
			    Assert.Fail("Exception expected");
		    }
		    catch (BException e) {
			    TestUtils.assertEquals(log, "exception", BExceptionC.SERVICE_NOT_IMPLEMENTED, e.Code);
		    }
		
		    log.info(")testCallClientFromServerNoRemoteImpl");
	    }

        class MyClientIF_withIncrementInt : BSkeleton_ClientIF
        {
            Log log = LogFactory.getLog(typeof(TestRemotePrimitiveTypes));
            public override int IncrementInt(int a)
            {
                log.info("incrementInt(" + a + ")");
                return a + 1;
            }
        }

        [TestMethod]
        public void testCallClientFromClient()
        {
            log.info("testCallClientFromClient(");

            BSkeleton_ClientIF partner = new MyClientIF_withIncrementInt();

            BClient_Testser client2 = TestUtilsHttp.createClient();
            client2.addRemote(partner);

            client.ServerIF.SetPartner(partner);

            ClientIF partnerIF = client.ServerIF.GetPartner();
            int r = partnerIF.IncrementInt(7);
            TestUtils.assertEquals(log, "incrementInt", 8, r);

            log.info(")testCallClientFromClient");
        }

        const int exceptionCode = 1111;

        class MyClientIF_throwEx : BSkeleton_ClientIF
        {
            Log log = LogFactory.getLog(typeof(TestRemotePrimitiveTypes));
            public override int IncrementInt(int a)
            {
                throw new BException(exceptionCode, "my exception", "details");
            }
        }

        [TestMethod]
        public void testCallClientFromClientThrowEx()
        {
            log.info("testCallClientFromClientThrowEx(");


            BSkeleton_ClientIF partner = new MyClientIF_throwEx();

            BClient_Testser client2 = TestUtilsHttp.createClient();
            client2.addRemote(partner);

            client.ServerIF.SetPartner(partner);

            ClientIF partnerIF = client.ServerIF.GetPartner();
            try
            {
                partnerIF.IncrementInt(7);
            }
            catch (BException e)
            {
                TestUtils.assertEquals(log, "exception", exceptionCode, e.Code);
            }
            log.info(")testCallClientFromClientThrowEx");
        }

        private class ClientIF_putStreams : BSkeleton_ClientIF 
        {
            Log log = LogFactory.getLog(typeof(ClientIF_putStreams));

            public override void PutStreams(IList<Stream> streams, int ctrl)
            {
 			    try 
                {
					List<Stream> arr = TestUtilsHttp.makeTestStreams();
					TestUtils.assertEquals(log, "streams.length", arr.Count, streams.Count);
					for (int i = 0; i < arr.Count; i++) 
                    {
						TestUtils.assertEquals(log, "stream[" + i + "]", arr[i], streams[i]);
					}
				}
				catch (IOException e)
                {
					throw new BException(BExceptionC.IOERROR, "", e);
				}
            }
        }

        [TestMethod]
	    public void testServerProvidesStreamForClient() 
        {
		    log.info("testServerProvidesStreamForClient(");
		
		    // (1) Provide implementation for interface ClientIF
		    client.addRemote(new ClientIF_putStreams());
		
		    // (2) Call server method. 
		    // On the server, this method calls the client-side interface 
		    // registered in step (1)
		    log.info("call client...");
		    List<Stream> arr = TestUtilsHttp.makeTestStreams();
		    remote.PutStreamsOnClient(arr);
		    log.info("call client OK");
		
		    log.info(")testServerProvidesStreamForClient");
	    }

        class MyClientIF_getStreams : BSkeleton_ClientIF
        {
 			public override IList<Stream> GetStreams(int ctrl) {
				try {
					return TestUtilsHttp.makeTestStreams();
				} catch (IOException e) {
					throw new BException(BExceptionC.IOERROR, "", e);
				}
			}
       }

        [TestMethod]
	    public void testServerRequestsStreamFromClient() {
		    log.info("testServerRequestsStreamFromClient(");
				
		    // (1) Provide implementation for interface ClientIF
		    client.addRemote(new MyClientIF_getStreams());
		
		    // (2) Call server method. 
		    // On the server, this method calls the client-side interface 
		    // registered in step (1)
		    log.info("call client...");
		    IList<Stream> arrR = remote.GetStreamsFromClient();
		    log.info("call client OK");

		    List<Stream> arr = TestUtilsHttp.makeTestStreams();
            TestUtils.assertEquals(log, "streams.length", arr.Count, arrR.Count);
            for (int i = 0; i < arr.Count; i++)
            {
			    TestUtils.assertEquals(log, "stream[" + i + "]", arr[i], arrR[i]);
		    }
		
		    log.info(")testServerRequestsStreamFromClient");
	    }


        [TestMethod]
	    public void testReturnStreamFromClientToClient() {
		    log.info("testReturnStreamFromClientToClient(");
		
		    // Interface implementation for the second client
		    BSkeleton_ClientIF partner = new MyClientIF_getStreams();

		    // Create second client
		    BClient_Testser client2 = TestUtilsHttp.createClient();
		    client2.addRemote(partner);
		
		    // Pass the interface of the second client to the server side of the first client
		    client.ServerIF.SetPartner(partner);
		
		    // First client queries the interface of the second client from the server side
		    ClientIF partnerIF = client.ServerIF.GetPartner();
		
		    log.info("call client...");
		    IList<Stream> arrR = partnerIF.GetStreams(0);
		    log.info("call client OK");

		    List<Stream> arr = TestUtilsHttp.makeTestStreams();
		    TestUtils.assertEquals(log, "streams.length", arr.Count, arrR.Count);
		    for (int i = 0; i < arr.Count; i++) {
			    TestUtils.assertEquals(log, "stream[" + i + "]", arr[i], arrR[i]);
		    }
		
		    client2.done();


		    log.info(")testReturnStreamFromClientToClient");
	    }

        [TestMethod]
	    public void testPutStreamFromClientToClient() 
        {
		    log.info("testPutStreamFromClientToClient(");
		
		    // Interface implementation for the second client
		    BSkeleton_ClientIF partner = new ClientIF_putStreams();

		    // Create second client
		    BClient_Testser client2 = TestUtilsHttp.createClient();
		    client2.addRemote(partner);
		
		    // Pass the interface of the second client to the server side of the first client
		    client.ServerIF.SetPartner(partner);
		
		    // First client queries the interface of the second client from the server side
		    ClientIF partnerIF = client.ServerIF.GetPartner();
		
		    log.info("call client...");
		    IList<Stream> arr = TestUtilsHttp.makeTestStreams();
		    partnerIF.PutStreams(arr, 0);
		    log.info("call client OK");

		    client2.done();

		    log.info(")testPutStreamFromClientToClient");
	    }

    }
}
