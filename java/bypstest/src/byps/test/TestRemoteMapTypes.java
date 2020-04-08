package byps.test;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.map.MapTypes;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.RemoteMapTypes;

/**
 * Tests for interface functions with map types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 */
public class TestRemoteMapTypes {
	
	BClient_Testser client;
	RemoteMapTypes remote;
	private Logger log = LoggerFactory.getLogger(TestRemoteMapTypes.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemoteMapTypes();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testRemoteMapTypes() throws RemoteException {
		log.info("testRemoteMapTypes(");
		
		MapTypes obj = new MapTypes();
		obj.boolean1 = new MyMap<String,Boolean>().add("bool1", true).add("bool2", false);
		obj.byte1 = new HashMap<Double,Byte>(new MyMap<Double,Byte>().add(1.0, (byte)-1).add(2.0, (byte)-2));
		obj.char1 = new MyMap<Float, Character>().add(-1.0f, 'a').add(1.0e-1f, 'b');
		obj.double1 = new MyMap<Byte, Double>().add((byte)3, -1.0e12);
		obj.float1 = new MyMap<Character, Float>().add('A', 1.0f).add('¶', 2.0f).add('€', -1.2468e-3f);
		obj.int1 = new MyMap<Integer, Integer>().add(1,2).add(2, 3);
		obj.long1 = new MyMap<Short, Long>().add((short)99, 33L).add((short)-99, -33L);
		obj.primitiveTypes1 = new MyMap<Integer, PrimitiveTypes>().add(1, TestUtils.createObjectPrimitiveTypes()).add(2, TestUtils.createObjectPrimitiveTypes());
		obj.short1 = new MyMap<Long, Short>().add(-55L, (short)1234).add(0x5555555555555555L, (short)5555);
		obj.string1 = new MyMap<String, String>().add("A", "a").add("B","b");
		obj.date1 = new MyMap<String, Date>().add("1",  new Date(1)).add("2", new Date(2)).add("null", null);

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
		remote.setDate1(obj.date1);
		TestUtils.assertEquals(log,  "date1",  obj.date1, remote.getDate1());
		
		log.info(")testRemoteMapTypes");
	}
}
