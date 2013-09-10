using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using com.wilutions.byps.test.api.prim;
using com.wilutions.byps.test.api.arr;
using com.wilutions.byps.test.api.inl;
using com.wilutions.byps.test.api.auth;

namespace bypstest
{
    [TestClass]
    public class TestRemoteWithAuthentication
    {

        Log log = LogFactory.getLog(typeof(TestRemoteWithAuthentication));
        BClient_Testser client;
        RemoteWithAuthenticationAuth remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient();
            remote = client.RemoteWithAuthentication;
        }

        [TestCleanup]
        public void tearDown()
        {
            if (client != null)
            {
                try
                {
                    remote.SetUseAuthentication(false);
                }
                catch (Exception) { }
                client.done();
            }
        }

        [TestMethod]
 	    public void testNoAuthObjectSupplied() 
        {
            log.info("testNoAuthObjectSupplied(");
    
            SessionInfo sess = remote.Login("Fritz", "abc");
            log.info("sess=" + sess);
    
            log.info(")testNoAuthObjectSupplied");
        }
	
 
	
    }

}
