package byps.test;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BException;
import byps.BInput;
import byps.BOutput;
import byps.BTransport;
import byps.test.api.map.MapTypes;
import byps.test.api.prim.PrimitiveTypes;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * List<> types.
 */
public class TestSerializerMap {

	private Log log = LogFactory.getLog(TestSerializerMap.class);
	BTransport transport = TestUtils.createTransport();
	
	/**
	 * Test with null values for all lists.
	 * @throws BException
	 */
	@Test
	public void testMapNull() throws BException {
		log.info("testListNull(");
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testListNull");
	}
	
	@Test
	public void testMapEmpty() throws BException {
		log.info("testMapEmpty(");
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.boolean1 = new MyMap<String,Boolean>();
		obj.byte1 = new HashMap<Double,Byte>(new MyMap<Double,Byte>());
		obj.char1 = new MyMap<Float, Character>();
		obj.double1 = new MyMap<Byte, Double>();
		obj.float1 = new MyMap<Character, Float>();
		obj.int1 = new MyMap<Integer, Integer>();
		obj.long1 = new MyMap<Short, Long>();
		obj.primitiveTypes1 = new MyMap<Integer, PrimitiveTypes>();
		obj.short1 = new MyMap<Long, Short>();
		obj.string1 = new MyMap<String, String>();

		bout.store(obj);
				
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testMapEmpty");
	}

	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testMapNotNull() throws BException {
		log.info("testListNotNull(");
		BOutput bout = transport.getOutput();
		
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

		bout.store(obj);
				
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testListNotNull");
	}

	@Test
	public void testMapBoolean() throws BException {
		log.info("testListBoolean(");
		internalTestMapBoolean(new MyMap<String,Boolean>().add("aa", true).add("¶a", false).add("€a", true).add("\ta", false));
		internalTestMapBoolean(new MyMap<String,Boolean>().add("'", true).add("\"", false).add("", true));
		log.info(")testListBoolean");
	}

	protected void internalTestMapBoolean(Map<String,Boolean> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.boolean1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	
	@Test
	public void testMapByte() throws BException {
		log.info("testListByte(");
		internalTestMapByte(new MyMap<Double,Byte>().add(1.2, (byte)'a').add(-1.2e88, (byte)'b'));
		log.info(")testListByte");
	}

	protected void internalTestMapByte(MyMap<Double,Byte> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.byte1 = new HashMap<Double,Byte>(map);
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapChar() throws BException {
		log.info("testListChar(");
		internalTestMapCharacter(new MyMap<Float, Character>().add(0.1f, 'a').add(0.2f, '¶').add(0.4f, '€'));
		internalTestMapCharacter(new MyMap<Float, Character>().add(-0.1f, '\"').add(1.02f, '\"'));
		log.info(")testListCharacter");
	}

	protected void internalTestMapCharacter(MyMap<Float, Character> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.char1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		
		TestUtils.assertEquals(log, "Map type", java.util.TreeMap.class, objR.char1.getClass());
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapShort() throws BException {
		log.info("testListShort(");
		internalTestMapShort(new MyMap<Long, Short>().add(1L, (short)0xFFFF).add(2L, (short)0x7FFF));
		internalTestMapShort(new MyMap<Long, Short>().add(0x1234567812345678L, (short)0));
		log.info(")testListShort");
	}

	protected void internalTestMapShort(Map<Long, Short> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.short1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapInteger() throws BException {
		log.info("testListInteger(");
		internalTestMapInteger(new MyMap<Integer,Integer>().add(1, -1).add(-1, 1).add(0, 1));
		internalTestMapInteger(new MyMap<Integer,Integer>().add(0xCDCDCDCD, 0x55555555));
		log.info(")testListInteger");
	}

	protected void internalTestMapInteger(Map<Integer,Integer> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.int1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapLong() throws BException {
		log.info("testListLong(");
		internalTestMapLong(new MyMap<Short,Long>().add((short)1, 0x1122334455667788L).add((short)-1, 1L).add((short)1, 0x8000000000000000L));
		log.info(")testListLong");
	}

	protected void internalTestMapLong(Map<Short,Long> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.long1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}
	
	@Test
	public void testMapFloat() throws BException {
		log.info("testListFloat(");
		internalTestMapFloat(new MyMap<Character,Float>().add('a', 1.2f).add('¶', 2.3f).add('€', 3.4f));
		internalTestMapFloat(new MyMap<Character,Float>().add('\n', 1.2f).add('\"', 2.3f).add('\'', 3.4f));
		log.info(")testListFloat");
	}

	protected void internalTestMapFloat(Map<Character, Float> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.float1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapDouble() throws BException {
		log.info("testListDouble(");
		internalTestMapDouble(new MyMap<Byte, Double>().add((byte)1, 1.2e3).add((byte)-1, -2.3e4));
		log.info(")testListFloat");
	}

	protected void internalTestMapDouble(Map<Byte, Double> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.double1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testMapString() throws BException {
		log.info("testListString(");
		internalTestMapString(new MyMap<String, String>().add("a", "bc").add("def", "€").add("€a", "a€").add("a€b", "¶").add("¶a", "a¶"));
		internalTestMapString(new MyMap<String, String>().add("", "empty").add("\r", "\\r").add("\t", "\\t"));
		log.info(")testListString");
	}

	protected void internalTestMapString(Map<String, String> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.string1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}
	
	
	@Test
	public void testMapPimitiveTypes() throws BException {
		log.info("testListPimitiveTypes(");
		internalTestMapPimitiveTypes(
				new MyMap<Integer, PrimitiveTypes>()
				.add(1, TestUtils.createObjectPrimitiveTypes())
				.add(2, TestUtils.createObjectPrimitiveTypes())
				.add(3, TestUtils.createObjectPrimitiveTypes()));
		log.info(")testListPimitiveTypes");
	}

	protected void internalTestMapPimitiveTypes(Map<Integer, PrimitiveTypes> map) throws BException {
		BOutput bout = transport.getOutput();
		
		MapTypes obj = new MapTypes();
		obj.primitiveTypes1 = map;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		MapTypes objR = (MapTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

}
