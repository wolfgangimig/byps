using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using com.wilutions.byps.test.api.prim;
using com.wilutions.byps.test.api.arr;
using com.wilutions.byps.test.api.inl;

namespace bypstest
{
    [TestClass]
    public class TestRemoteArrayTypes
    {

        Log log = LogFactory.getLog(typeof(TestRemoteArrayTypes));
        BClient_Testser client;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient();
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
 	    public void testRemoteArrayTypes1dimPerformance() {
		    log.info("testRemoteArrayTypes1dimPerformance(");

		    int loopCount = 100;
		
		    internalTestPerformance(BBinaryModel.MEDIUM, 0, loopCount, 10);
		    internalTestPerformance(BBinaryModel.MEDIUM, 0, loopCount, 100);
            //internalTestPerformance(BBinaryModel.MEDIUM, 0, loopCount, 1000);
            //internalTestPerformance(BBinaryModel.MEDIUM, 0, loopCount, 10000);


		    log.info(")testRemoteArrayTypes1dimPerformance");
        }
	
	    private void internalTestPerformance(BBinaryModel bmodel, int gzip, int loopCount, int objCount) 
        {
		    BClient_Testser client = TestUtilsHttp.createClient();

		    PrimitiveTypes[] primitiveTypes1 = new PrimitiveTypes[objCount];
		    for (int i = 0; i < primitiveTypes1.Length; i++) {
			    primitiveTypes1[i] = TestUtils.createObjectPrimitiveTypes();
		    }
		
		    long t1 = DateTime.Now.Ticks;
		    for (int i = 0; i < loopCount; i++) {
			    client.RemoteArrayTypes1dim.SetPrimitiveTypes(primitiveTypes1);
		    }
		    long t2 = DateTime.Now.Ticks;
		
		    long t3 = DateTime.Now.Ticks;
		    for (int i = 0; i < loopCount; i++) {
			    client.RemoteArrayTypes1dim.GetPrimitiveTypes();
		    }
		    long t4 = DateTime.Now.Ticks;
		
		    client.done();

            t1 /= 10000;
            t2 /= 10000;
            t3 /= 10000;
            t4 /= 10000;
		
		    log.info("bmodel=" + bmodel.ToString().Substring(0,2) +
				    ", gzip=" + gzip + 
				    ", #objs=" + objCount.ToString("000000") +
                    ", #loops=" + loopCount.ToString("000000") +
                    ", call-ms=" + ((t2 - t1) + (t4 - t3)).ToString("000000") +
                    "/" + (t2 - t1).ToString("000000") +
                    "/" + (t4 - t3).ToString("000000")
                    );
		
	    }
	
	    [TestMethod]
	    public void testRemoteArrayTypes1dim() {
		    log.info("testRemoteArrayTypes1dim(");

		    RemoteArrayTypes1dim remote;
		    remote = client.RemoteArrayTypes1dim;

		    bool[] bool1 = new bool[] {true, false, true};
		    byte[] byte1 = new byte[] {1,2,3};
		    char[] char1 = new char[] {'a', 'b', 'c' };
		    short[] short1 = new short[] { 55,66,77};
		    int[] int1 = new int[] {12,34,56};
		    long[] long1 = new long[] {999,88,7};
		    float[] float1 = new float[] {1.2f, 2.2f, 3.2f};
		    double[] double1 = new double[] {1e1, 1e2, 1e3};
		    String[] string1 = new String[] {"ôôôô"};
		    PrimitiveTypes[] primitiveTypes1 = new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() };
		    Object[] object1 = new ArrayTypes1dim[] { new ArrayTypes1dim() };

		    remote.SetBool(bool1);
		    TestUtils.assertEquals(log, "bool", bool1, remote.GetBool());
		    remote.SetByte(byte1);
		    TestUtils.assertEquals(log, "byte", byte1, remote.GetByte());
		    remote.SetChar(char1);
		    TestUtils.assertEquals(log, "char", char1, remote.GetChar());
		    remote.SetShort(short1);
		    TestUtils.assertEquals(log, "short", short1, remote.GetShort());
		    remote.SetInt(int1);
		    TestUtils.assertEquals(log,  "int", int1, remote.GetInt());
		    remote.SetLong(long1);
		    TestUtils.assertEquals(log, "long", long1, remote.GetLong());
		    remote.SetFloat(float1);
		    TestUtils.assertEquals(log,  "float", float1, remote.GetFloat());
		    remote.SetDouble(double1);
		    TestUtils.assertEquals(log,  "double", double1, remote.GetDouble());
		    remote.SetString(string1);
		    TestUtils.assertEquals(log,  "String", string1, remote.GetString());
		
		    remote.SetObject(object1);
		    TestUtils.assertEquals(log,  "Object", object1, remote.GetObject());
		
		    remote.SetPrimitiveTypes(primitiveTypes1);
		    TestUtils.assertEquals(log,  "PrimitiveTypes", primitiveTypes1, remote.GetPrimitiveTypes());
		
		    log.info(")testRemoteArrayTypes1dim");
	    }

        [TestMethod]
        public void testRemoteArrayTypes4dim() 
        {
		    log.info("testRemoteArrayTypes4dim(");

		    RemoteArrayTypes4dim remote;
		    remote = client.RemoteArrayTypes4dim;

		    ArrayTypes4dim obj = new ArrayTypes4dim();
		    obj.Boolean4 = new bool[,,,] {{{{true}}}};
		    obj.Byte4 = new byte[,,,] {{{{1,2,3,4}}}};
		    obj.Char4 = new char[,,,] {{{{'a','b','c'}}}};
		    obj.Double4 = new double[,,,] {{{{1},{2}}}};
		    obj.Float4 = new float[,,,] {{{{3},{4}}}};
		    obj.Int4 = new int[,,,] {{{{5},{6}}}};
		    obj.Long4 = new long[,,,] {{{{7},{8}}}};
		    obj.PrimitiveTypes4 = new PrimitiveTypes[,,,] {{{{ TestUtils.createObjectPrimitiveTypes() }}}};
		    obj.Short4 = new short[,,,] {{{{4,2,3,4,5,6,7}}}};
		    obj.String4 = new String[,,,] {{{{"a", "b", "c"}}}};
		    Object[,,,] object4 = new ArrayTypes4dim[,,,] { { { { new ArrayTypes4dim() } } } };

		    remote.SetBool(obj.Boolean4);
		    TestUtils.assertEquals(log, "bool", obj.Boolean4, remote.GetBool());
		    remote.SetByte(obj.Byte4);
		    TestUtils.assertEquals(log, "byte", obj.Byte4, remote.GetByte());
		    remote.SetChar(obj.Char4);
		    TestUtils.assertEquals(log, "char", obj.Char4, remote.GetChar());
		    remote.SetShort(obj.Short4);
		    TestUtils.assertEquals(log, "short", obj.Short4, remote.GetShort());
		    remote.SetInt(obj.Int4);
		    TestUtils.assertEquals(log,  "int", obj.Int4, remote.GetInt());
		    remote.SetLong(obj.Long4);
		    TestUtils.assertEquals(log, "long", obj.Long4, remote.GetLong());
		    remote.SetFloat(obj.Float4);
		    TestUtils.assertEquals(log,  "float", obj.Float4, remote.GetFloat());
		    remote.SetDouble(obj.Double4);
		    TestUtils.assertEquals(log,  "double", obj.Double4, remote.GetDouble());
		    remote.SetString(obj.String4);
		    TestUtils.assertEquals(log,  "String", obj.String4, remote.GetString());
		
		    remote.SetPrimitiveTypes(obj.PrimitiveTypes4);
		    TestUtils.assertEquals(log,  "PrimitiveTypes", obj.PrimitiveTypes4, remote.GetPrimitiveTypes());
		
		    remote.SetObject(object4);
		    TestUtils.assertEquals(log,  "Object", object4, remote.GetObject());
		
		    log.info(")testRemoteArrayTypes4dim");
        }

	    [TestMethod]
	    public void testRemoteArraysDims23() {
		    log.info("testRemoteArraysDims23(");

            RemoteArrayTypes23 remote;
            remote = client.RemoteArrayTypes23;

            {
			    int[] arr1 = new int[3];
			    int[,] arr2 = new int[7,6];
			    int[,,] arr3 = new int[7,5,3];
			    int[,,,] arr4 = new int[3,4,6,7];
			
			    for (int i2 = 0; i2 < arr2.GetLength(0); i2++) 
				    for (int i1 = 0; i1 < arr2.GetLength(1); i1++)
					    arr2[i2,i1] = i2+i1;
			    for (int i3 = 0; i3 < arr3.GetLength(0); i3++) 
				    for (int i2 = 0; i2 < arr3.GetLength(1); i2++) 
					    for (int i1 = 0; i1 <arr3.GetLength(2); i1++)
						    arr3[i3,i2,i1] = i3+i2+i1;
			    for (int i4 = 0; i4 < arr4.GetLength(0); i4++) 
				    for (int i3 = 0; i3 < arr4.GetLength(1); i3++) 
					    for (int i2 = 0; i2 < arr4.GetLength(2); i2++) 
						    for (int i1 = 0; i1 < arr4.GetLength(3); i1++)
							    arr4[i4,i3,i2,i1] = i4+i3+i2+i1;
			
			    arr1[0] = arr2[1,1];
			    arr1[1] = arr3[1,1,1];
			    arr1[2] = arr4[1,1,1,1];
			
			    int[] arrR = remote.SendArraysInt(arr2, arr3, arr4);
			    TestUtils.assertEquals(log,  "int", arr1, arrR);
		    }
		
		    {
			    String[] arr1 = new String[3];
			    String[,] arr2 = new String[7,6];
			    String[,,] arr3 = new String[7,5,3];
			    String[,,,] arr4 = new String[3,4,6,7];
			
			    for (int i2 = 0; i2 < arr2.GetLength(0); i2++) 
				    for (int i1 = 0; i1 < arr2.GetLength(1); i1++)
					    arr2[i2,i1] = ""+i2+i1;
			    for (int i3 = 0; i3 < arr3.GetLength(0); i3++) 
				    for (int i2 = 0; i2 < arr3.GetLength(1); i2++) 
					    for (int i1 = 0; i1 <arr3.GetLength(2); i1++)
						    arr3[i3,i2,i1] = ""+i3+i2+i1;
			    for (int i4 = 0; i4 < arr4.GetLength(0); i4++) 
				    for (int i3 = 0; i3 < arr4.GetLength(1); i3++) 
					    for (int i2 = 0; i2 < arr4.GetLength(2); i2++) 
						    for (int i1 = 0; i1 < arr4.GetLength(3); i1++)
							    arr4[i4,i3,i2,i1] = ""+i4+i3+i2+i1;
			
			    arr1[0] = arr2[1,1];
			    arr1[1] = arr3[1,1,1];
			    arr1[2] = arr4[1,1,1,1];
			
			    String[] arrR = remote.SendArraysString(arr2, arr3, arr4);
			    TestUtils.assertEquals(log,  "String", arr1, arrR);
		    }

		    {
			    PrimitiveTypes[] arr1 = new PrimitiveTypes[3];
			    PrimitiveTypes[,] arr2 = new PrimitiveTypes[7,6];
			    PrimitiveTypes[,,] arr3 = new PrimitiveTypes[7,5,3];
			    PrimitiveTypes[,,,] arr4 = new PrimitiveTypes[3,4,6,7];
			
			    for (int i2 = 0; i2 < arr2.GetLength(0); i2++) 
				    for (int i1 = 0; i1 < arr2.GetLength(1); i1++)
					    arr2[i2,i1] = TestUtils.createObjectPrimitiveTypes();
			    for (int i3 = 0; i3 < arr3.GetLength(0); i3++) 
				    for (int i2 = 0; i2 < arr3.GetLength(1); i2++) 
					    for (int i1 = 0; i1 <arr3.GetLength(2); i1++)
						    arr3[i3,i2,i1] = TestUtils.createObjectPrimitiveTypes();
			    for (int i4 = 0; i4 < arr4.GetLength(0); i4++) 
				    for (int i3 = 0; i3 < arr4.GetLength(1); i3++) 
					    for (int i2 = 0; i2 < arr4.GetLength(2); i2++) 
						    for (int i1 = 0; i1 < arr4.GetLength(3); i1++)
							    arr4[i4,i3,i2,i1] = TestUtils.createObjectPrimitiveTypes();
			
			    arr1[0] = arr2[1,1];
			    arr1[1] = arr3[1,1,1];
			    arr1[2] = arr4[1,1,1,1];
		
			    PrimitiveTypes[] arrR = remote.SendArraysClass(arr2, arr3, arr4);
			    TestUtils.assertEquals(log,  "PrimitiveTypes", arr1, arrR);
		    }
	
		    {
			    Object[] arr1 = new Object[3];
			    Object[,] arr2 = new Object[7,6];
			    Object[,,] arr3 = new Object[7,5,3];
			    Object[,,,] arr4 = new Object[3,4,6,7];
			
			    for (int i2 = 0; i2 < arr2.GetLength(0); i2++) 
				    for (int i1 = 0; i1 < arr2.GetLength(1); i1++)
					    arr2[i2,i1] = TestUtils.createObjectPrimitiveTypes();
			    for (int i3 = 0; i3 < arr3.GetLength(0); i3++) 
				    for (int i2 = 0; i2 < arr3.GetLength(1); i2++) 
					    for (int i1 = 0; i1 <arr3.GetLength(2); i1++)
						    arr3[i3,i2,i1] = TestUtils.createObjectPrimitiveTypes();
			    for (int i4 = 0; i4 < arr4.GetLength(0); i4++) 
				    for (int i3 = 0; i3 < arr4.GetLength(1); i3++) 
					    for (int i2 = 0; i2 < arr4.GetLength(2); i2++) 
						    for (int i1 = 0; i1 < arr4.GetLength(3); i1++)
							    arr4[i4,i3,i2,i1] = TestUtils.createObjectPrimitiveTypes();
			
			    arr1[0] = arr2[1,1];
			    arr1[1] = arr3[1,1,1];
			    arr1[2] = arr4[1,1,1,1];
		
			    Object[] arrR = remote.SendArraysObject(arr2, arr3, arr4);
			    TestUtils.assertEquals(log,  "Object", arr1, arrR);
		    }
		
		    {
			    Point2D[] arr1 = new Point2D[3];
			    Point2D[,] arr2 = new Point2D[7,6];
			    Point2D[,,] arr3 = new Point2D[7,5,3];
			    Point2D[,,,] arr4 = new Point2D[3,4,6,7];
			
			    for (int i2 = 0; i2 < arr2.GetLength(0); i2++) 
				    for (int i1 = 0; i1 < arr2.GetLength(1); i1++)
					    arr2[i2,i1] = TestUtils.createPoint2D();
			    for (int i3 = 0; i3 < arr3.GetLength(0); i3++) 
				    for (int i2 = 0; i2 < arr3.GetLength(1); i2++) 
					    for (int i1 = 0; i1 <arr3.GetLength(2); i1++)
						    arr3[i3,i2,i1] = TestUtils.createPoint2D();
			    for (int i4 = 0; i4 < arr4.GetLength(0); i4++) 
				    for (int i3 = 0; i3 < arr4.GetLength(1); i3++) 
					    for (int i2 = 0; i2 < arr4.GetLength(2); i2++) 
						    for (int i1 = 0; i1 < arr4.GetLength(3); i1++)
							    arr4[i4,i3,i2,i1] = TestUtils.createPoint2D();
			
			    arr1[0] = arr2[1,1];
			    arr1[1] = arr3[1,1,1];
			    arr1[2] = arr4[1,1,1,1];
		
			    Point2D[] arrR = remote.SendArraysInline(arr2, arr3, arr4);
			    TestUtils.assertEquals(log,  "Point2D", arr1, arrR);
		    }
		
		    log.info(")testRemoteArraysDims23");
	    }
	
    }

}
