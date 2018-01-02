package byps.test;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.RemoteSetTypes;
import byps.test.api.set.SetTypes;

/**
 * Tests for interface functions with set types.
 * This test requires the webapp bypstest-srv to be started. 
 * 
 *
 */
public class TestRemoteSetTypes {
	
	BClient_Testser client;
	RemoteSetTypes remote;
	private Log log = LogFactory.getLog(TestRemoteSetTypes.class);

	@Before
	public void setUp() throws RemoteException {
		client = TestUtilsHttp.createClient();
		remote = client.getRemoteSetTypes();
	}
	
	@After
	public void tearDown() {
		if (client != null) {
			client.done();
		}
	}
	
	@Test
	public void testRemoteSetTypes() throws RemoteException {
		log.info("testRemoteSetTypes(");
		
		SetTypes obj = new SetTypes();
		obj.boolean1 = new HashSet<Boolean>(Arrays.asList(true, false));
		obj.byte1 = new HashSet<Byte>(Arrays.asList((byte)1,(byte)2,(byte)3));
		obj.char1 = new TreeSet<Character>(Arrays.asList('a', 'b'));
		obj.double1 = new HashSet<Double>(Arrays.asList(0.0, 0.1, 0.2));
		obj.float1 = new HashSet<Float>(Arrays.asList(1f, 2f, 3f, 4f));
		obj.int1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		obj.long1 = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L , 6L));
		obj.primitiveTypes1 = new HashSet<PrimitiveTypes>(Arrays.asList(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() }));
		obj.short1 = new HashSet<Short>(Arrays.asList((short)1));
		obj.string1 = new HashSet<String>(Arrays.asList("a", "b", "c"));
		obj.obj1 = new HashSet<Object>(Arrays.asList(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes() }));
		obj.date1 = new HashSet<Date>(Arrays.asList(new Date(0)));

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
		TestUtils.assertEquals(log,  "date1", obj.date1, remote.getDate1());
		
		log.info(")testRemoteSetTypes");
	}
}
