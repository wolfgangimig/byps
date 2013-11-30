/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.remote;
using System.Collections.Generic;
using byps.test.api.enu;
using byps.test.api.cons;

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
