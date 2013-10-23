using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.remote;
using byps.test.api.prim;
using byps.test.api.arr;
using byps.test.api.map;

namespace bypstest
{
    [TestClass]
    public class TestRemoteMapTypes
    {

        Log log = LogFactory.getLog(typeof(TestRemoteMapTypes));
        BClient_Testser client;
        RemoteMapTypes remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient(BWireFlags.GZIP);
            remote = client.RemoteMapTypes;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
        public void testRemoteMapTypes() {
		    log.info("testRemoteMapTypes(");
		
		    MapTypes obj = new MapTypes();
		    obj.Boolean1 = new MyMap<String,bool>().add("bool1", true).add("bool2", false);
		    obj.Byte1 = new MyMap<double,byte>().add(1.0, (byte)1).add(2.0, (byte)2);
		    obj.Char1 = new MyMap<float, char>().add(-1.0f, 'a').add(1.0e-1f, 'b');
		    obj.Double1 = new MyMap<byte, double>().add((byte)3, -1.0e12);
		    obj.Float1 = new MyMap<char, float>().add('A', 1.0f).add('¶', 2.0f).add('€', -1.2468e-3f);
		    obj.Int1 = new MyMap<int, int>().add(1,2).add(2, 3);
		    obj.Long1 = new MyMap<short, long>().add((short)99, 33L).add((short)-99, -33L);
		    obj.PrimitiveTypes1 = new MyMap<int, PrimitiveTypes>().add(1, TestUtils.createObjectPrimitiveTypes()).add(2, TestUtils.createObjectPrimitiveTypes());
		    obj.Short1 = new MyMap<long, short>().add(-55L, (short)1234).add(0x5555555555555555L, (short)5555);
		    obj.String1 = new MyMap<String, String>().add("A", "a").add("B","b");

		    remote.SetBoolean1(obj.Boolean1);
		    TestUtils.assertEquals(log, "boolean1", obj.Boolean1, remote.GetBoolean1());
		    remote.SetByte1(obj.Byte1);
		    TestUtils.assertEquals(log, "byte1", obj.Byte1, remote.GetByte1());
		    remote.SetChar1(obj.Char1);
		    TestUtils.assertEquals(log, "char1", obj.Char1, remote.GetChar1());
		    remote.SetDouble1(obj.Double1);
		    TestUtils.assertEquals(log, "double1", obj.Double1, remote.GetDouble1());
		    remote.SetFloat1(obj.Float1);
		    TestUtils.assertEquals(log, "float1", obj.Float1, remote.GetFloat1());
		    remote.SetInt1(obj.Int1);
		    TestUtils.assertEquals(log, "int1", obj.Int1, remote.GetInt1());
		    remote.SetLong1(obj.Long1);
		    TestUtils.assertEquals(log, "long1", obj.Long1, remote.GetLong1());
		    remote.SetPrimitiveTypes1(obj.PrimitiveTypes1);
		    TestUtils.assertEquals(log, "primitiveTypes1", obj.PrimitiveTypes1, remote.GetPrimitiveTypes1());
		    remote.SetShort1(obj.Short1);
		    TestUtils.assertEquals(log, "short1", obj.Short1, remote.GetShort1());
		    remote.SetString1(obj.String1);
		    TestUtils.assertEquals(log, "string1", obj.String1, remote.GetString1());
		
		    log.info(")testRemoteMapTypes");
	    }

     }

}
