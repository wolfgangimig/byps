using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using com.wilutions.byps.test.api.list;
using com.wilutions.byps.test.api.prim;
using System.Collections.Generic;

namespace bypstest
{
    [TestClass]
    public class TestRemoteListTypes
    {
        Log log = LogFactory.getLog(typeof(TestRemoteMapTypes));
        BClient_Testser client;
        RemoteListTypes remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient(BWireFlags.GZIP);
            remote = client.RemoteListTypes;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

 	    [TestMethod]
	    public void testRemoteListTypes() {
		    log.info("testRemoteListTypes(");
		
		    ListTypes obj = new ListTypes();
            obj.Boolean1 = new List<bool>(new bool[] { true, false });
		    obj.Byte1 = new List<byte>(new byte[] {(byte)1,(byte)2,(byte)3 });
		    obj.Char1 = new List<char>(new char [] {'a', 'b'});
            obj.Double1 = new List<double>(new double[] { 0.0, 0.1, 0.2 });
            obj.Float1 = new List<float>(new float[] { 1f, 2f, 3f, 4f });
            obj.Int1 = new List<int>(new int[] { 1, 2, 3, 4, 5 });
            obj.Long1 = new List<long>(new long[] { 1L, 2L, 3L, 4L, 5L, 6L });
		    obj.PrimitiveTypes1 = new List<PrimitiveTypes>(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() });
		    obj.Short1 = new List<short>(new short[] {(short)1});
		    obj.String1 = new List<String>(new String[] {"a", "b", "c"});
		    obj.Obj1 = new List<Object>();
		    obj.Obj1.Add(TestUtils.createObjectPrimitiveTypes());
		
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
		    remote.SetObj1(obj.Obj1);
		    TestUtils.assertEquals(log, "obj1", obj.Obj1, remote.GetObj1());
		
		    log.info(")testRemoteListTypes");
	    }
	
	    [TestMethod]
	    public void testRemoteListMapSetListInteger() {
		    log.info("testRemoteListMapSetListInteger(");
		
		    ListListTypes obj = new ListListTypes();
            List<IDictionary<int, IList<HashSet<int>>>> list = new List<IDictionary<int, IList<HashSet<int>>>>();
		    for (int i = 0; i < 2; i++) {
			    IDictionary<int,IList<HashSet<int>>> map = new Dictionary<int,IList<HashSet<int>>>();
			    for (int j = 0; j < 3; j++) {
                    IList<HashSet<int>> list2 = new List<HashSet<int>>();
                    for (int k = 0; k < 4; k++)
                    {
                        HashSet<int> set = new HashSet<int>();
                        list2.Add(set);
					    for (int n = 0; n < 5; n++) {
						    int pt = n * k * j * i;
                            set.Add(pt);
					    }
					    
				    }
				    map[j] = list2;
			    }
			    list.Add(map);
		    }
		    obj.Int3 = list;
		
		    remote.SetInt4(obj.Int3);
		    TestUtils.assertEquals(log, "int4", obj.Int3, remote.GetInt4());
		
		    log.info(")testRemoteListMapSetListint");
	    }

	    [TestMethod]
	    public void testRemoteListListint()  {
		    log.info("testRemoteListListint(");
		
		    ListListTypes obj = new ListListTypes();
		    List<IList<int>> list = new List<IList<int>>();
		    for (int i = 0; i < 3; i++) {
			    List<int> itemList = new List<int>();
			    for (int j = 0; j < i+1; j++) {
				    itemList.Add(j);
			    }
		    }
		    obj.Int2 = list;
		
		    remote.SetInt3(obj.Int2);
		    TestUtils.assertEquals(log, "int3", obj.Int2, remote.GetInt3());
		
		    log.info(")testRemoteListListint");
	    }
    }
}
