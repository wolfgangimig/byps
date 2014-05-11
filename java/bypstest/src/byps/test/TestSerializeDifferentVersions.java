package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BException;
import byps.BInput;
import byps.BMessageHeader;
import byps.BOutput;
import byps.BTransport;
import byps.BWire;
import byps.test.api.strm.Stream1;
import byps.test.api.ver.Evolve;
import byps.test.api.ver.Evolve2;

/**
 * This class defines tests for serialization between different versions.
 *
 */
public class TestSerializeDifferentVersions {

	private Log log = LogFactory.getLog(TestSerializeDifferentVersions.class);

  @Test
  public void testDifferentVersions() throws BException {
    log.info("testDifferentVersions(");
    
    for (int appVersion = 0; appVersion < 5; appVersion++) {
      for (int negotiatedVersion = 0; negotiatedVersion <= appVersion; negotiatedVersion++) {
        internalTestDifferentVersions(appVersion, 0, negotiatedVersion);
      }
    }
    
    log.info(")testDifferentVersions");
  }
  
  private void internalTestDifferentVersions(int appVersion, int bypsVersion, int negotiatedVersion) throws BException {
		log.info("internalTestDifferentVersions(appVersion=" + appVersion + ", negotiatedVersion=" + negotiatedVersion);
		Evolve obj = createEvolve(appVersion);
		
		BTransport transport = TestUtils.createTransport(BWire.FLAG_DEFAULT, bypsVersion, negotiatedVersion);
		
		BOutput bout = transport.getOutput();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		Evolve objR = (Evolve)bin.load();
		
		compareEvolve(log, obj, objR, appVersion, negotiatedVersion);

		log.info(")internalTestdifferentVersions");
	}
	
	public static Evolve createEvolve(int version) {
		Evolve ev = new Evolve();
		ev.bool1 = true;
		ev.byte1 = (byte)1;
		ev.char1 = 'a';
		ev.short1 = (short)2;
		ev.int1 = 3;
		ev.long1 = 4;
		ev.float1 = 5.0f;
		ev.double1 = 6.0;
		ev.str1 = "7";
		ev.obj1 = new Evolve2(1);
		ev.evo1 = new Evolve2(2);
		ev.bools1 = new boolean[] {false, true};
		ev.bytes1 = new byte[] {1,2};
		ev.chars1 = new char[] {'a', 'b'};
		ev.shorts1 = new short[] {3,4};
		ev.ints1 = new int[] {5,6};
		ev.longs1 = new long[] {7,8};
		ev.floats1 = new float[] {9.0f, 10.0f};
		ev.doubles1 = new double[] {11.0, 12.0};
		ev.list1 = Arrays.asList(14,15);
		ev.set1 = new HashSet<Integer>(Arrays.asList(16,17));
		ev.map1 = new HashMap<Integer,Integer>();
		ev.map1.put(18,19); ev.map1.put(20,21);
		
		if (version >= 2) {
			ev.bool2 = false;
			ev.byte2 = (byte)2;
			ev.char2 = 'b';
			ev.short2 = (short)3;
			ev.int2 = 4;
			ev.long2 = 5;
			ev.float2 = 6.0f;
			ev.double2 = 7.0;
			ev.str2 = "8";
			ev.obj2 = new Evolve2(3);
			ev.evo2 = new Evolve2(4);
			ev.bools2 = new boolean[] {false, true, false};
			ev.bytes2 = new byte[] {1,2,3};
			ev.chars2 = new char[] {'a', 'b', 'c'};
			ev.shorts2 = new short[] {3,4,5};
			ev.ints2 = new int[] {5,6,7};
			ev.longs2 = new long[] {7,8,9};
			ev.floats2 = new float[] {9.0f, 10.0f, 11.0f};
			ev.doubles2 = new double[] {11.0, 12.0, 13.0};
			ev.list2 = Arrays.asList(14,15,16);
			ev.set2 = new HashSet<Integer>(Arrays.asList(16,17,18));
			ev.map2 = new HashMap<Integer,Integer>();
			ev.map1.put(18,19); ev.map1.put(20,21); ev.map1.put(22,23);
		}
		
		if (version >= 3) {
			ev.bool3 = false;
			ev.byte3 = (byte)3;
			ev.char3 = 'c';
			ev.short3 = (short)4;
			ev.int3 = 5;
			ev.long3 = 6;
			ev.float3 = 7.0f;
			ev.double3 = 8.0;
			ev.str3 = "9";
			ev.obj3 = new Evolve2(5);
			ev.evo3 = new Evolve2(6);
			ev.bools3 = new boolean[] {false, true, false, true};
			ev.bytes3 = new byte[] {1,2,3,4};
			ev.chars3 = new char[] {'a', 'b', 'c', 'd'};
			ev.shorts3 = new short[] {3,4,5,6};
			ev.ints3 = new int[] {5,6,7,8};
			ev.longs3 = new long[] {7,8,9,10};
			ev.floats3 = new float[] {9.0f, 10.0f, 11.0f, 12.0f};
			ev.doubles3 = new double[] {11.0, 12.0, 13.0, 14};
			ev.list3 = Arrays.asList(14,15,16,17);
			ev.set3 = new HashSet<Integer>(Arrays.asList(16,17,18,19));
			ev.map3 = new HashMap<Integer,Integer>();
			ev.map1.put(18,19); ev.map1.put(20,21); ev.map1.put(22,23); ev.map1.put(24,25);
		}
		
		return ev;
	}
	
	public static void compareEvolve(Log log, Evolve lhs, Evolve rhs, int clientVersion, int serverVersion) {
		int negotiatedVersion = Math.min(clientVersion, serverVersion);
		String msg = clientVersion + "/" + serverVersion + " ";
		TestUtils.assertEquals(log, msg+"bool1", lhs.bool1, rhs.bool1);
		TestUtils.assertEquals(log, msg+"byte1", lhs.byte1, rhs.byte1);
		TestUtils.assertEquals(log, msg+"char1", lhs.char1, rhs.char1);
		TestUtils.assertEquals(log, msg+"short1", lhs.short1, rhs.short1);
		TestUtils.assertEquals(log, msg+"int1", lhs.int1, rhs.int1);
		TestUtils.assertEquals(log, msg+"long1", lhs.long1, rhs.long1);
		TestUtils.assertEquals(log, msg+"float1", lhs.float1, rhs.float1);
		TestUtils.assertEquals(log, msg+"double1", lhs.double1, rhs.double1);
		TestUtils.assertEquals(log, msg+"bools1", lhs.bools1, rhs.bools1);
		TestUtils.assertEquals(log, msg+"bytes1", lhs.bytes1, rhs.bytes1);
		TestUtils.assertEquals(log, msg+"chars1", lhs.chars1, rhs.chars1);
		TestUtils.assertEquals(log, msg+"shorts1", lhs.shorts1, rhs.shorts1);
		TestUtils.assertEquals(log, msg+"ints1", lhs.ints1, rhs.ints1);
		TestUtils.assertEquals(log, msg+"longs1", lhs.longs1, rhs.longs1);
		TestUtils.assertEquals(log, msg+"floats1", lhs.floats1, rhs.floats1);
		TestUtils.assertEquals(log, msg+"doubles1", lhs.doubles1, rhs.doubles1);
		TestUtils.assertEquals(log, msg+"str1", lhs.str1, rhs.str1);
		TestUtils.assertEquals(log, msg+"obj1", lhs.obj1, rhs.obj1);
		TestUtils.assertEquals(log, msg+"evo1", lhs.evo1, rhs.evo1);
		TestUtils.assertEquals(log, msg+"list1", lhs.list1, rhs.list1);
		TestUtils.assertEquals(log, msg+"set1", lhs.set1, rhs.set1);
		TestUtils.assertEquals(log, msg+"map1", lhs.map1, rhs.map1);
	
		if (negotiatedVersion >= 2) {
			TestUtils.assertEquals(log, msg+"bool2", lhs.bool2, rhs.bool2);
			TestUtils.assertEquals(log, msg+"byte2", lhs.byte2, rhs.byte2);
			TestUtils.assertEquals(log, msg+"char2", lhs.char2, rhs.char2);
			TestUtils.assertEquals(log, msg+"short2", lhs.short2, rhs.short2);
			TestUtils.assertEquals(log, msg+"int2", lhs.int2, rhs.int2);
			TestUtils.assertEquals(log, msg+"long2", lhs.long2, rhs.long2);
			TestUtils.assertEquals(log, msg+"float2", lhs.float2, rhs.float2);
			TestUtils.assertEquals(log, msg+"double2", lhs.double2, rhs.double2);
			TestUtils.assertEquals(log, msg+"bools2", lhs.bools2, rhs.bools2);
			TestUtils.assertEquals(log, msg+"bytes2", lhs.bytes2, rhs.bytes2);
			TestUtils.assertEquals(log, msg+"chars2", lhs.chars2, rhs.chars2);
			TestUtils.assertEquals(log, msg+"shorts2", lhs.shorts2, rhs.shorts2);
			TestUtils.assertEquals(log, msg+"ints2", lhs.ints2, rhs.ints2);
			TestUtils.assertEquals(log, msg+"longs2", lhs.longs2, rhs.longs2);
			TestUtils.assertEquals(log, msg+"floats2", lhs.floats2, rhs.floats2);
			TestUtils.assertEquals(log, msg+"doubles2", lhs.doubles2, rhs.doubles2);
			TestUtils.assertEquals(log, msg+"str2", lhs.str2, rhs.str2);
			TestUtils.assertEquals(log, msg+"obj2", lhs.obj2, rhs.obj2);
			TestUtils.assertEquals(log, msg+"evo2", lhs.evo2, rhs.evo2);
			TestUtils.assertEquals(log, msg+"list2", lhs.list2, rhs.list2);
			TestUtils.assertEquals(log, msg+"set2", lhs.set2, rhs.set2);
			TestUtils.assertEquals(log, msg+"map2", lhs.map2, rhs.map2);
		}
		
		if (negotiatedVersion >= 3) {
			TestUtils.assertEquals(log, msg+"bool3", lhs.bool3, rhs.bool3);
			TestUtils.assertEquals(log, msg+"byte3", lhs.byte3, rhs.byte3);
			TestUtils.assertEquals(log, msg+"char3", lhs.char3, rhs.char3);
			TestUtils.assertEquals(log, msg+"short3", lhs.short3, rhs.short3);
			TestUtils.assertEquals(log, msg+"int3", lhs.int3, rhs.int3);
			TestUtils.assertEquals(log, msg+"long3", lhs.long3, rhs.long3);
			TestUtils.assertEquals(log, msg+"float3", lhs.float3, rhs.float3);
			TestUtils.assertEquals(log, msg+"double3", lhs.double3, rhs.double3);
			TestUtils.assertEquals(log, msg+"bools3", lhs.bools3, rhs.bools3);
			TestUtils.assertEquals(log, msg+"bytes3", lhs.bytes3, rhs.bytes3);
			TestUtils.assertEquals(log, msg+"chars3", lhs.chars3, rhs.chars3);
			TestUtils.assertEquals(log, msg+"shorts3", lhs.shorts3, rhs.shorts3);
			TestUtils.assertEquals(log, msg+"ints3", lhs.ints3, rhs.ints3);
			TestUtils.assertEquals(log, msg+"longs3", lhs.longs3, rhs.longs3);
			TestUtils.assertEquals(log, msg+"floats3", lhs.floats3, rhs.floats3);
			TestUtils.assertEquals(log, msg+"doubles3", lhs.doubles3, rhs.doubles3);
			TestUtils.assertEquals(log, msg+"str3", lhs.str3, rhs.str3);
			TestUtils.assertEquals(log, msg+"obj3", lhs.obj3, rhs.obj3);
			TestUtils.assertEquals(log, msg+"evo3", lhs.evo3, rhs.evo3);
			TestUtils.assertEquals(log, msg+"list3", lhs.list3, rhs.list3);
			TestUtils.assertEquals(log, msg+"set3", lhs.set3, rhs.set3);
			TestUtils.assertEquals(log, msg+"map3", lhs.map3, rhs.map3);
		}
		
		
	}

}
