using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.remote;
using byps.test.api.prim;
using byps.test.api.arr;
using byps.test.api.map;
using byps.test.api.set;
using System.Collections.Generic;

namespace bypstest
{
    [TestClass]
    public class TestRemoteSetTypes
    {

        Log log = LogFactory.getLog(typeof(TestRemoteSetTypes));
        BClient_Testser client;
        RemoteSetTypes remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient(BWireFlags.GZIP);
            remote = client.RemoteSetTypes;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
	    public void testRemoteSetTypes() {
		    log.info("testRemoteSetTypes(");
		
		    SetTypes obj = new SetTypes();
            SetTypes objR = new SetTypes();
 
            obj.Boolean1 = new HashSet<bool>(new bool[] { true, false });
		    obj.Byte1 = new HashSet<byte>(new byte[] {1,2,3});
            obj.Char1 = new HashSet<char>(new char[] { 'a', 'b' });
            obj.Double1 = new HashSet<double>(new double[] { 0.2, 0.4, 0.8 });
            obj.Float1 = new HashSet<float>(new float[] { 1f, 2f, 3f });
            obj.Int1 = new HashSet<int>(new int[] { 4, 5, 6 });
            obj.Long1 = new HashSet<long>(new long[] { 8, 9, 6 });
		    obj.PrimitiveTypes1 = new HashSet<PrimitiveTypes>(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() });
            obj.Short1 = new HashSet<short>(new short[] { 1 });
            obj.String1 = new HashSet<String>(new String[] { "a", "b", "c" });
            obj.Date1 = new HashSet<DateTime>(new DateTime[] { new DateTime(3010, 8, 9, 10, 11, 12, 13) });
		    obj.Obj1 = new HashSet<Object>(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() });

            for (int i = 0; i < 1; i++)
            {
                remote.SetBoolean1(obj.Boolean1);
                remote.SetByte1(obj.Byte1);
                remote.SetChar1(obj.Char1);
                remote.SetDouble1(obj.Double1);
                remote.SetFloat1(obj.Float1);
                remote.SetInt1(obj.Int1);
                remote.SetLong1(obj.Long1);
                remote.SetPrimitiveTypes1(obj.PrimitiveTypes1);
                remote.SetShort1(obj.Short1);
                remote.SetString1(obj.String1);
                remote.SetDate1(obj.Date1);
                remote.SetObj1(obj.Obj1);

                objR.Boolean1 = remote.GetBoolean1();
                objR.Byte1 = remote.GetByte1();
                objR.Char1 = remote.GetChar1();
                objR.Double1 = remote.GetDouble1();
                objR.Float1 = remote.GetFloat1();
                objR.Int1 = remote.GetInt1();
                objR.Long1 = remote.GetLong1();
                objR.PrimitiveTypes1 = remote.GetPrimitiveTypes1();
                objR.Short1 = remote.GetShort1();
                objR.String1 = remote.GetString1();
                objR.Date1 = remote.GetDate1();
                objR.Obj1 = remote.GetObj1();
            }

            TestUtils.assertEquals(log, "SetTypes", obj, objR);
		
		    log.info(")testRemoteSetTypes");
	    }

     }

}
