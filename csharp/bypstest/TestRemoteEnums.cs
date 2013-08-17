using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using System.Collections.Generic;
using com.wilutions.byps.test.api.enu;

namespace bypstest
{
    [TestClass]
    public class TestRemoteEnums
    {
        Log log = LogFactory.getLog(typeof(TestRemoteEnums));
        BClient_Testser client;
        RemoteEnums remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient(BWireFlags.GZIP);
            remote = client.RemoteEnums;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
	    public void testRemoteEnums() 
        {
		    log.info("testRemoteEnums(");
		    remote.SetPlanet(EnumPlanets.Earth);
		    EnumPlanets r = remote.GetPlanet();
		    TestUtils.assertEquals(log, "enum", EnumPlanets.Earth, r);
		
		    log.info(")testRemoteEnums");
	    }

    }
}
