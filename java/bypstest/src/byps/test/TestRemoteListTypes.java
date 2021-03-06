package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.list.ListListTypes;
import byps.test.api.list.ListTypes;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.RemoteListTypes;

/**
 * Tests for interface functions with list types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteListTypes {
	
	BClient_Testser client;
	RemoteListTypes remote;
	private Logger log = LoggerFactory.getLogger(TestRemoteListTypes.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemoteListTypes();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testRemoteListTypes() throws RemoteException {
		log.info("testRemoteListTypes(");
		
		ListTypes obj = new ListTypes();
		obj.boolean1 = new ArrayList<Boolean>(Arrays.asList(true, false));
		obj.byte1 = new ArrayList<Byte>(Arrays.asList((byte)1,(byte)2,(byte)3));
		obj.char1 = new ArrayList<Character>(Arrays.asList('a', 'b'));
		obj.double1 = new ArrayList<Double>(Arrays.asList(0.0, 0.1, 0.2));
		obj.float1 = new ArrayList<Float>(Arrays.asList(1f, 2f, 3f, 4f));
		obj.int1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		obj.long1 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L , 6L));
		obj.primitiveTypes1 = new ArrayList<PrimitiveTypes>(Arrays.asList(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() }));
		obj.short1 = new ArrayList<Short>(Arrays.asList((short)1));
		obj.string1 = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		obj.obj1 = new ArrayList<Object>();
		obj.obj1.add(TestUtils.createObjectPrimitiveTypes());
		obj.date1 = Arrays.asList(new Date(0), null, new Date(System.currentTimeMillis()), null);
		
		remote.setBoolean1(obj.boolean1);
		TestUtils.assertEquals(log, "boolean1", obj.boolean1, remote.getBoolean1());
		remote.setByte1(obj.byte1);
		TestUtils.assertEquals(log, "byte1", obj.byte1, remote.getByte1());
		remote.setChar1(obj.char1);
		TestUtils.assertEquals(log, "char1", obj.char1, remote.getChar1());
		remote.setDouble1(obj.double1);
		TestUtils.assertEquals(log, "double1", obj.double1, remote.getDouble1());
		remote.setFloat1(obj.float1);
		TestUtils.assertEquals(log, "float1", obj.float1, remote.getFloat1());
		remote.setInt1(obj.int1);
		TestUtils.assertEquals(log, "int1", obj.int1, remote.getInt1());
		remote.setLong1(obj.long1);
		TestUtils.assertEquals(log, "long1", obj.long1, remote.getLong1());
		remote.setPrimitiveTypes1(obj.primitiveTypes1);
		TestUtils.assertEquals(log, "primitiveTypes1", obj.primitiveTypes1, remote.getPrimitiveTypes1());
		remote.setShort1(obj.short1);
		TestUtils.assertEquals(log, "short1", obj.short1, remote.getShort1());
		remote.setString1(obj.string1);
		TestUtils.assertEquals(log, "string1", obj.string1, remote.getString1());
		remote.setObj1(obj.obj1);
		TestUtils.assertEquals(log, "obj1", obj.obj1, remote.getObj1());
		remote.setDate1(obj.date1);
		TestUtils.assertEquals(log,  "date1",  obj.date1, remote.getDate1());
		
		log.info(")testRemoteListTypes");
	}
	
	@Test
	public void testRemoteListMapSetListInteger() throws RemoteException {
		log.info("testRemoteListMapSetListInteger(");
		
		ListListTypes obj = new ListListTypes();
		List<Map<Integer,List<TreeSet<Integer>>>> list = new ArrayList<Map<Integer,List<TreeSet<Integer>>>>();
		for (int i = 0; i < 2; i++) {
			Map<Integer,List<TreeSet<Integer>>> map = new TreeMap<Integer,List<TreeSet<Integer>>>();
			for (int j = 0; j < 3; j++) {
				List<TreeSet<Integer>> list3 = new ArrayList<TreeSet<Integer>>();
				for (int k = 0; k < 4; k++) {
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int n = 0; n < 5; n++) {
						Integer pt = (i+1) * (j+1) * (k+1) * (n+1);
						set.add(pt);
					}
					list3.add(set);
				}
				map.put(j, list3);
			}
			list.add(map);
		}
		obj.int3 = list;
		
		remote.setInt4(obj.int3);
		TestUtils.assertEquals(log, "int4", obj.int3, remote.getInt4());
		
		log.info(")testRemoteListMapSetListInteger");
	}

	@Test
	public void testRemoteListListInteger() throws RemoteException {
		log.info("testRemoteListListInteger(");
		
		ListListTypes obj = new ListListTypes();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> itemList = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				itemList.add(j);
			}
			list.add(itemList);
		}
		obj.int2 = list;
		
		remote.setInt3(obj.int2);
		TestUtils.assertEquals(log, "int3", obj.int2, remote.getInt3());
		
		log.info(")testRemoteListListInteger");
	}

}
