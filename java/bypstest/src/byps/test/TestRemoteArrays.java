package byps.test;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BBinaryModel;
import byps.BException;
import byps.BProtocolJson;
import byps.BProtocolS;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.arr.ArrayTypes1dim;
import byps.test.api.arr.ArrayTypes4dim;
import byps.test.api.inl.Point2D;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.RemoteArrayTypes1dim;
import byps.test.api.remote.RemoteArrayTypes23;
import byps.test.api.remote.RemoteArrayTypes4dim;

/**
 * Tests for interface functions with array types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteArrays {
	
	BClient_Testser client;
	private Log log = LogFactory.getLog(TestRemoteArrays.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	/**
	 * Performance test.
	 * Client + Server on same machine:
09:01:28,559 main   INFO  (TestRemoteArrays.java:43) - testRemoteArrayTypes1dimPerformance(
09:01:30,519 main   INFO  (TestRemoteArrays.java:82) - bmodel=JS, gzip=0, #objs=    10, #loops=  1000, call-ms=  1950/  1108/   842
09:01:34,007 main   INFO  (TestRemoteArrays.java:82) - bmodel=JS, gzip=0, #objs=   100, #loops=  1000, call-ms=  3485/  1895/  1590
09:01:55,375 main   INFO  (TestRemoteArrays.java:82) - bmodel=JS, gzip=0, #objs=  1000, #loops=  1000, call-ms= 21364/ 10775/ 10589
09:01:56,155 main   INFO  (TestRemoteArrays.java:82) - bmodel=ME, gzip=0, #objs=    10, #loops=  1000, call-ms=   777/   421/   356
09:01:56,876 main   INFO  (TestRemoteArrays.java:82) - bmodel=ME, gzip=0, #objs=   100, #loops=  1000, call-ms=   718/   380/   338
09:01:58,891 main   INFO  (TestRemoteArrays.java:82) - bmodel=ME, gzip=0, #objs=  1000, #loops=  1000, call-ms=  2013/  1025/   988
09:01:58,891 main   INFO  (TestRemoteArrays.java:56) - )testRemoteArrayTypes1dimPerformance

	 * @throws BException
	 * @throws InterruptedException
	 */
	@Test
	public void testRemoteArrayTypes1dimPerformance() throws RemoteException {
		log.info("testRemoteArrayTypes1dimPerformance(");

		int loopCount = 100;
		for (int gzip = 0; gzip < 1; gzip++) {
			
			int flags = gzip != 0 ? BWire.FLAG_GZIP : BWire.FLAG_DEFAULT;
		
			internalTestPerformance(BProtocolJson.BINARY_MODEL, flags, loopCount, 10);
			internalTestPerformance(BProtocolJson.BINARY_MODEL, flags, loopCount, 100);
			internalTestPerformance(BProtocolJson.BINARY_MODEL, flags, loopCount, 1000);
			
			internalTestPerformance(BProtocolS.BINARY_MODEL, flags, loopCount, 10);
			internalTestPerformance(BProtocolS.BINARY_MODEL, flags, loopCount, 100);
			internalTestPerformance(BProtocolS.BINARY_MODEL, flags, loopCount, 1000);
			//internalTestPerformance(BBinaryModel.MEDIUM, 0, loopCount, 10000);
		
		}
		
		log.info(")testRemoteArrayTypes1dimPerformance");
	}
	
	private void internalTestPerformance(BBinaryModel protocol, int flags, int loopCount, int objCount) throws RemoteException {
		TestUtils.protocol = protocol;
		BClient_Testser client = TestUtilsHttp.createClient(TestUtils.protocol, flags, BApiDescriptor_Testser.VERSION);
		
		client.transport.wire.clearStatistics();

		PrimitiveTypes[] primitiveTypes1 = new PrimitiveTypes[objCount];
		for (int i = 0; i < primitiveTypes1.length; i++) {
			primitiveTypes1[i] = TestUtils.createObjectPrimitiveTypes();
		}
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < loopCount; i++) {
			client.remoteArrayTypes1dim.setPrimitiveTypes(primitiveTypes1);
		}
		long t2 = System.currentTimeMillis();
		
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < loopCount; i++) {
			client.remoteArrayTypes1dim.getPrimitiveTypes();
		}
		long t4 = System.currentTimeMillis();

		BWire.Statistics stats = client.transport.wire.getStatistics();
		
		client.done();
		
		log.info("protocol=" + protocol.toString() +
				", gzip=" + flags + 
				", #objs=" + String.format("%6d", objCount) + 
				", #loops=" + String.format("%6d", loopCount) +
				", #bytes/loop=" + String.format("%6d", (stats.bytesSent + stats.bytesReceived) / loopCount) +  
				", call-ms=" + String.format("%6d", (t2-t1) + (t4-t3)) + 
				"/" + String.format("%6d", (t2-t1)) + 
				"/" + String.format("%6d", (t4-t3)));
		
	}
	
	@Test
	public void testRemoteArrayTypes1dim() throws RemoteException {
		log.info("testRemoteArrayTypes1dim(");

		RemoteArrayTypes1dim remote;
		remote = client.remoteArrayTypes1dim;

		boolean[] boolean1 = new boolean[] {true, false, true};
		byte[] byte1 = new byte[] {1,2,3};
		char[] char1 = new char[] {'a', 'b', 'c' };
		short[] short1 = new short[] { 55,66,77};
		int[] int1 = new int[] {12,34,56};
		long[] long1 = new long[] {999,88,7};
		float[] float1 = new float[] {1.2f, 2.2f, 3.2f};
		double[] double1 = new double[] {1e1, 1e2, 1e3};
		String[] string1 = new String[] {"ττ\0ττ"};
		PrimitiveTypes[] primitiveTypes1 = new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() };
		Object[] object1 = new ArrayTypes1dim[] { new ArrayTypes1dim() };
		Date[] date1 = new Date[] { new Date(System.currentTimeMillis()), null, new Date(System.currentTimeMillis() + 1)};

		remote.setBool(boolean1);
		TestUtils.assertEquals(log, "bool", boolean1, remote.getBool());
		remote.setByte(byte1);
		TestUtils.assertEquals(log, "byte", byte1, remote.getByte());
		remote.setChar(char1);
		TestUtils.assertEquals(log, "char", char1, remote.getChar());
		remote.setShort(short1);
		TestUtils.assertEquals(log, "short", short1, remote.getShort());
		remote.setInt(int1);
		TestUtils.assertEquals(log,  "int", int1, remote.getInt());
		remote.setLong(long1);
		TestUtils.assertEquals(log, "long", long1, remote.getLong());
		remote.setFloat(float1);
		TestUtils.assertEquals(log,  "float", float1, remote.getFloat());
		remote.setDouble(double1);
		TestUtils.assertEquals(log,  "double", double1, remote.getDouble());
		remote.setString(string1);
		TestUtils.assertEquals(log,  "String", string1, remote.getString());
		remote.setDate(date1);
		TestUtils.assertEquals(log,  "date", date1, remote.getDate());
		remote.setObject(object1);
		TestUtils.assertEquals(log,  "Object", object1, remote.getObject());
		
		remote.setPrimitiveTypes(primitiveTypes1);
		TestUtils.assertEquals(log,  "PrimitiveTypes", primitiveTypes1, remote.getPrimitiveTypes());
		
		log.info(")testRemoteArrayTypes1dim");
	}

	@Test
	public void testRemoteArrayTypes4dim() throws RemoteException {
		log.info("testRemoteArrayTypes4dim(");

		RemoteArrayTypes4dim remote;
		remote = client.remoteArrayTypes4dim;

		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.boolean4 = new boolean[][][][] {{{{true}}}};
		obj.byte4 = new byte[][][][] {{{"hello".getBytes()}}};
		obj.char4 = new char[][][][] {{{"ulla".toCharArray()}}};
		obj.double4 = new double[][][][] {{{{1},{2}}}};
		obj.float4 = new float[][][][] {{{{3},{4}}}};
		obj.int4 = new int[][][][] {{{{5},{6}}}};
		obj.long4 = new long[][][][] {{{{7},{8}}}};
		obj.primitiveTypes4 = new PrimitiveTypes[][][][] {{{{ TestUtils.createObjectPrimitiveTypes() }}}};
		obj.short4 = new short[][][][] {{{{4,2,3,4,5,6,7}}}};
		obj.string4 = new String[][][][] {{{{"a", "b", "c"}}}};
		Object[][][][] object4 = new ArrayTypes4dim[][][][] { { { { new ArrayTypes4dim() } } } };
		Date[][][][] date4 = new Date[][][][] {{{{ new Date(0) }}}};

		remote.setBool(obj.boolean4);
		TestUtils.assertEquals(log, "bool", obj.boolean4, remote.getBool());
		remote.setByte(obj.byte4);
		TestUtils.assertEquals(log, "byte", obj.byte4, remote.getByte());
		remote.setChar(obj.char4);
		TestUtils.assertEquals(log, "char", obj.char4, remote.getChar());
		remote.setShort(obj.short4);
		TestUtils.assertEquals(log, "short", obj.short4, remote.getShort());
		remote.setInt(obj.int4);
		TestUtils.assertEquals(log,  "int", obj.int4, remote.getInt());
		remote.setLong(obj.long4);
		TestUtils.assertEquals(log, "long", obj.long4, remote.getLong());
		remote.setFloat(obj.float4);
		TestUtils.assertEquals(log,  "float", obj.float4, remote.getFloat());
		remote.setDouble(obj.double4);
		TestUtils.assertEquals(log,  "double", obj.double4, remote.getDouble());
		remote.setString(obj.string4);
		TestUtils.assertEquals(log,  "String", obj.string4, remote.getString());
		remote.setDate(date4);
		TestUtils.assertEquals(log,  "date", date4, remote.getDate());
		
		remote.setPrimitiveTypes(obj.primitiveTypes4);
		TestUtils.assertEquals(log,  "PrimitiveTypes", obj.primitiveTypes4, remote.getPrimitiveTypes());
		
		remote.setObject(object4);
		TestUtils.assertEquals(log,  "Object", object4, remote.getObject());
		
		log.info(")testRemoteArrayTypes4dim");
	}

	/**
	 * Check serialization of arrays of all supported dimensions.
	 * @throws InterruptedException 
	 * @throws BException 
	 */
	@Test
	public void testRemoteArraysDims23() throws RemoteException{
		log.info("testRemoteArraysDims23(");
		
		{
			int[] arr1 = new int[3];
			int[][] arr2 = new int[7][6];
			int[][][] arr3 = new int[7][5][3];
			int[][][][] arr4 = new int[3][4][6][7];
			
			for (int i2 = 0; i2 < arr2.length; i2++) 
				for (int i1 = 0; i1 < arr2[i2].length; i1++)
					arr2[i2][i1] = i2+i1;
			for (int i3 = 0; i3 < arr3.length; i3++) 
				for (int i2 = 0; i2 < arr3[i3].length; i2++) 
					for (int i1 = 0; i1 < arr3[i3][i2].length; i1++)
						arr3[i3][i2][i1] = i3+i2+i1;
			for (int i4 = 0; i4 < arr4.length; i4++) 
				for (int i3 = 0; i3 < arr4[i4].length; i3++) 
					for (int i2 = 0; i2 < arr4[i4][i3].length; i2++) 
						for (int i1 = 0; i1 < arr4[i4][i3][i2].length; i1++)
							arr4[i4][i3][i2][i1] = i4+i3+i2+i1;
			
			arr1[0] = arr2[1][1];
			arr1[1] = arr3[1][1][1];
			arr1[2] = arr4[1][1][1][1];
			
			RemoteArrayTypes23 remote;
			remote = client.remoteArrayTypes23;
			
			int[] arrR = remote.sendArraysInt(arr2, arr3, arr4);
			TestUtils.assertEquals(log,  "int", arr1, arrR);
		}
		
		{
			String[] arr1 = new String[3];
			String[][] arr2 = new String[7][6];
			String[][][] arr3 = new String[7][5][3];
			String[][][][] arr4 = new String[3][4][6][7];
			
			for (int i2 = 0; i2 < arr2.length; i2++) 
				for (int i1 = 0; i1 < arr2[i2].length; i1++)
					arr2[i2][i1] = ""+i2+i1;
			for (int i3 = 0; i3 < arr3.length; i3++) 
				for (int i2 = 0; i2 < arr3[i3].length; i2++) 
					for (int i1 = 0; i1 < arr3[i3][i2].length; i1++)
						arr3[i3][i2][i1] = ""+i3+i2+i1;
			for (int i4 = 0; i4 < arr4.length; i4++) 
				for (int i3 = 0; i3 < arr4[i4].length; i3++) 
					for (int i2 = 0; i2 < arr4[i4][i3].length; i2++) 
						for (int i1 = 0; i1 < arr4[i4][i3][i2].length; i1++)
							arr4[i4][i3][i2][i1] = ""+i4+i3+i2+i1;
			
			arr1[0] = arr2[1][1];
			arr1[1] = arr3[1][1][1];
			arr1[2] = arr4[1][1][1][1];
			
			RemoteArrayTypes23 remote;
			remote = client.remoteArrayTypes23;
			
			String[] arrR = remote.sendArraysString(arr2, arr3, arr4);
			TestUtils.assertEquals(log,  "String", arr1, arrR);
		}

		{
			PrimitiveTypes[] arr1 = new PrimitiveTypes[3];
			PrimitiveTypes[][] arr2 = new PrimitiveTypes[7][6];
			PrimitiveTypes[][][] arr3 = new PrimitiveTypes[7][5][3];
			PrimitiveTypes[][][][] arr4 = new PrimitiveTypes[3][4][6][7];
			
			for (int i2 = 0; i2 < arr2.length; i2++) 
				for (int i1 = 0; i1 < arr2[i2].length; i1++)
					arr2[i2][i1] = TestUtils.createObjectPrimitiveTypes();
			for (int i3 = 0; i3 < arr3.length; i3++) 
				for (int i2 = 0; i2 < arr3[i3].length; i2++) 
					for (int i1 = 0; i1 < arr3[i3][i2].length; i1++)
						arr3[i3][i2][i1] = TestUtils.createObjectPrimitiveTypes();
			for (int i4 = 0; i4 < arr4.length; i4++) 
				for (int i3 = 0; i3 < arr4[i4].length; i3++) 
					for (int i2 = 0; i2 < arr4[i4][i3].length; i2++) 
						for (int i1 = 0; i1 < arr4[i4][i3][i2].length; i1++)
							arr4[i4][i3][i2][i1] = TestUtils.createObjectPrimitiveTypes();
			
			arr1[0] = arr2[1][1];
			arr1[1] = arr3[1][1][1];
			arr1[2] = arr4[1][1][1][1];
		
			RemoteArrayTypes23 remote;
			remote = client.remoteArrayTypes23;
			
			PrimitiveTypes[] arrR = remote.sendArraysClass(arr2, arr3, arr4);
			TestUtils.assertEquals(log,  "PrimitiveTypes", arr1, arrR);
		}
	
		{
			Object[] arr1 = new Object[3];
			Object[][] arr2 = new Object[7][6];
			Object[][][] arr3 = new Object[7][5][3];
			Object[][][][] arr4 = new Object[3][4][6][7];
			
			for (int i2 = 0; i2 < arr2.length; i2++) 
				for (int i1 = 0; i1 < arr2[i2].length; i1++)
					arr2[i2][i1] = TestUtils.createObjectPrimitiveTypes();
			for (int i3 = 0; i3 < arr3.length; i3++) 
				for (int i2 = 0; i2 < arr3[i3].length; i2++) 
					for (int i1 = 0; i1 < arr3[i3][i2].length; i1++)
						arr3[i3][i2][i1] = TestUtils.createObjectPrimitiveTypes();
			for (int i4 = 0; i4 < arr4.length; i4++) 
				for (int i3 = 0; i3 < arr4[i4].length; i3++) 
					for (int i2 = 0; i2 < arr4[i4][i3].length; i2++) 
						for (int i1 = 0; i1 < arr4[i4][i3][i2].length; i1++)
							arr4[i4][i3][i2][i1] = TestUtils.createObjectPrimitiveTypes();
			
			arr1[0] = arr2[1][1];
			arr1[1] = arr3[1][1][1];
			arr1[2] = arr4[1][1][1][1];
		
			RemoteArrayTypes23 remote;
			remote = client.remoteArrayTypes23;
			
			Object[] arrR = remote.sendArraysObject(arr2, arr3, arr4);
			TestUtils.assertEquals(log,  "Object", arr1, arrR);
		}
		
		{
			Point2D[] arr1 = new Point2D[3];
			Point2D[][] arr2 = new Point2D[7][6];
			Point2D[][][] arr3 = new Point2D[7][5][3];
			Point2D[][][][] arr4 = new Point2D[3][4][6][7];
			
			for (int i2 = 0; i2 < arr2.length; i2++) 
				for (int i1 = 0; i1 < arr2[i2].length; i1++)
					arr2[i2][i1] = TestUtils.createPoint2D();
			for (int i3 = 0; i3 < arr3.length; i3++) 
				for (int i2 = 0; i2 < arr3[i3].length; i2++) 
					for (int i1 = 0; i1 < arr3[i3][i2].length; i1++)
						arr3[i3][i2][i1] = TestUtils.createPoint2D();
			for (int i4 = 0; i4 < arr4.length; i4++) 
				for (int i3 = 0; i3 < arr4[i4].length; i3++) 
					for (int i2 = 0; i2 < arr4[i4][i3].length; i2++) 
						for (int i1 = 0; i1 < arr4[i4][i3][i2].length; i1++)
							arr4[i4][i3][i2][i1] = TestUtils.createPoint2D();
			
			arr1[0] = arr2[1][1];
			arr1[1] = arr3[1][1][1];
			arr1[2] = arr4[1][1][1][1];
		
			RemoteArrayTypes23 remote;
			remote = client.remoteArrayTypes23;
			
			Point2D[] arrR = remote.sendArraysInline(arr2, arr3, arr4);
			TestUtils.assertEquals(log,  "Point2D", arr1, arrR);
		}
		
		log.info(")testRemoteArraysDims23");
	}
	

}
