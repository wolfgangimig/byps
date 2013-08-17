using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using System.Collections.Generic;
using com.wilutions.byps.test.api.enu;
using com.wilutions.byps.test.api.cons;

namespace bypstest
{
    [TestClass]
    public class TestRemoteConstants
    {
        Log log = LogFactory.getLog(typeof(TestRemoteConstants));
        BClient_Testser client;
        RemoteConstants remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient(BWireFlags.GZIP);
            remote = client.RemoteConstants;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
        public void TestCompareConstants()
        {
            log.info("TestCompareConstants(");

            remote.Compare_HebrewC(HebrewC.ALEPH, HebrewC.BETH);

            remote.Compare_AllTypesC(
                AllTypesC.Bool1s,
                AllTypesC.Bool2s,
                AllTypesC.Char1s,
                AllTypesC.StringNull,
                AllTypesC.Char2s,
                AllTypesC.Short1s,
                AllTypesC.Int1s,
                AllTypesC.Long1s,
                AllTypesC.Float1s,
                AllTypesC.Double1s,
                AllTypesC.String1s,
                AllTypesC.ALL,
                AllTypesC.ArrInt,
                AllTypesC.ArrInt4,
                AllTypesC.ArrStrings,
                AllTypesC.ArrStrings4,
                AllTypesC.ArrALL);

            log.info(")TestCompareConstants");
        }

    }
}
