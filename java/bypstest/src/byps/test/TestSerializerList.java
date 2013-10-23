package byps.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BException;
import byps.BExceptionC;
import byps.BInput;
import byps.BOutput;
import byps.BTransport;
import byps.test.api.list.ListListTypes;
import byps.test.api.list.ListTypes;
import byps.test.api.prim.PrimitiveTypes;

/**
 * This class provides tests to check the 
 * serialization of List<> types.
 */
public class TestSerializerList {

	private Log log = LogFactory.getLog(TestSerializerList.class);
	BTransport transport = TestUtils.createTransport();
	
	/**
	 * Test with null values for all lists.
	 * @throws BException
	 */
	@Test
	public void testListNull() throws BException {
		log.info("testListNull(");
		BOutput bout = transport.getOutput();
		
		ListTypes obj = new ListTypes();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ListTypes objR = (ListTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testListNull");
	}
	
	/**
	 * Test with null values for all lists.
	 * @throws BException
	 */
	@Test
	public void testListEmpty() throws BException {
		log.info("testListEmpty(");
		BOutput bout = transport.getOutput();
		
		ListTypes obj = new ListTypes();
		obj.boolean1 = new ArrayList<Boolean>();
		obj.byte1 = new ArrayList<Byte>();
		obj.char1 = new ArrayList<Character>();
		obj.double1 = new ArrayList<Double>();
		obj.float1 = new ArrayList<Float>();
		obj.int1 = new ArrayList<Integer>();
		obj.long1 = new ArrayList<Long>();
		obj.primitiveTypes1 = new ArrayList<PrimitiveTypes>();
		obj.short1 = new ArrayList<Short>();
		obj.string1 = new ArrayList<String>();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ListTypes objR = (ListTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testListEmpty");
	}
	
	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testListNotNull() throws BException {
		log.info("testListNotNull(");
		BOutput bout = transport.getOutput();
		
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

		bout.store(obj);
				
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ListTypes objR = (ListTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testListNotNull");
	}

	@Test
	public void testListBoolean() throws BException {
		log.info("testListBoolean(");
		internalTestListBoolean(new Boolean[] {true, false, true, false, true });
		internalTestListBoolean(new Boolean[] {});
		internalTestListBoolean(new Boolean[] {true});
		internalTestListBoolean(new Boolean[] {false});
		log.info(")testListBoolean");
	}

	protected void internalTestListBoolean(Boolean[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.boolean1 = new ArrayList<Boolean>(Arrays.asList(arr));
		internalTestList(obj);
	}

	
	@Test
	public void testListByte() throws BException {
		log.info("testListByte(");
		internalTestListByte(new Byte[] {1,2,3,4,5});
		internalTestListByte(new Byte[] {1,2,3,4,5,6});
		internalTestListByte(new Byte[] {});
		internalTestListByte(new Byte[] {1});
		internalTestListByte(new Byte[] {0});
		log.info(")testListByte");
	}

	protected void internalTestListByte(Byte[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.byte1 = new ArrayList<Byte>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListByteArray() throws BException {
		log.info("testListByteArray(");
		
		List<byte[]> lst = new ArrayList<byte[]>();
		lst.add(new byte[] {});
		lst.add(new byte[] {1});
		lst.add(new byte[] {2,3});
		lst.add(new byte[] {4,5,6});
		lst.add(new byte[] {7,8,9,10});
		internalTestListByteArray(lst);
		
		lst = new ArrayList<byte[]>();
		lst.add(new byte[0]);
		internalTestListByteArray(lst);
		
		lst = new ArrayList<byte[]>();
		lst.add(null);
		internalTestListByteArray(lst);
		
		log.info(")testListByteArray");
	}

	protected void internalTestListByteArray(List<byte[]> lst) throws BException {
		ListTypes obj = new ListTypes();
		obj.byte2 = lst;
		internalTestList(obj);
	}

	@Test
	public void testListChar() throws BException {
		log.info("testListChar(");
		internalTestListCharacter(new Character[] {'a', '¶', '€' });
		internalTestListCharacter(new Character[] {});
		internalTestListCharacter(new Character[] {'a'});
		internalTestListCharacter(new Character[] {'¶'});
		internalTestListCharacter(new Character[] {'€'});
		log.info(")testListCharacter");
	}

	protected void internalTestListCharacter(Character[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.char1 = new ArrayList<Character>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListShort() throws BException {
		log.info("testListShort(");
		internalTestListShort(new Short[] {1, -1, 123, -123, (short)0xCDCD });
		internalTestListShort(new Short[] {});
		internalTestListShort(new Short[] {1});
		internalTestListShort(new Short[] {0});
		log.info(")testListShort");
	}

	protected void internalTestListShort(Short[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.short1 = new ArrayList<Short>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListInteger() throws BException {
		log.info("testListInteger(");
		internalTestListInteger(new Integer[] {1, -1, 123, -123, (Integer)0xCDCDCDCD });
		internalTestListInteger(new Integer[] {});
		internalTestListInteger(new Integer[] {1});
		internalTestListInteger(new Integer[] {0});
		log.info(")testListInteger");
	}

	protected void internalTestListInteger(Integer[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.int1 = new ArrayList<Integer>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListIntArray() throws BException {
		log.info("testListIntArray(");
		
		List<int[]> lst = new ArrayList<int[]>();
		lst.add(new int[] {});
		lst.add(new int[] {1});
		lst.add(new int[] {2,3});
		lst.add(new int[] {4,5,6});
		lst.add(new int[] {7,8,9,10});
		internalTestListIntArray(lst);
		
		lst = new ArrayList<int[]>();
		lst.add(new int[0]);
		internalTestListIntArray(lst);
		
		lst = new ArrayList<int[]>();
		lst.add(null);
		internalTestListIntArray(lst);
		
		log.info(")testListIntArray");
	}

	protected void internalTestListIntArray(List<int[]> lst) throws BException {
		ListTypes obj = new ListTypes();
		obj.int2 = lst;
		internalTestList(obj);
	}

	
	@Test
	public void testListLong() throws BException {
		log.info("testListLong(");
		internalTestListLong(new Long[] {1L, -1L, 123L, -123L, 0xCDCDCDCDCDCDCDCDL });
		internalTestListLong(new Long[] {});
		internalTestListLong(new Long[] {1L});
		internalTestListLong(new Long[] {0L});
		log.info(")testListLong");
	}

	protected void internalTestListLong(Long[] arr) throws BException {
		ListTypes obj = new ListTypes();
		internalTestList(obj);
	}
	
	@Test
	public void testListFloat() throws BException {
		log.info("testListFloat(");
		internalTestListFloat(new Float[] {1f, -1f, 123f, -123f, 4e5f });
		internalTestListFloat(new Float[] {});
		internalTestListFloat(new Float[] {1f});
		internalTestListFloat(new Float[] {0f});
		log.info(")testListFloat");
	}

	protected void internalTestListFloat(Float[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.float1 = new ArrayList<Float>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListDouble() throws BException {
		log.info("testListDouble(");
		internalTestListDouble(new Double[] {1.0, -1.0, 123.0, -123.0, 1.4e-6 });
		internalTestListDouble(new Double[] {});
		internalTestListDouble(new Double[] {1.0});
		internalTestListDouble(new Double[] {0.0});
		log.info(")testListFloat");
	}

	protected void internalTestListDouble(Double[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.double1 = new ArrayList<Double>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListString() throws BException {
		log.info("testListString(");
		internalTestListString(new String[] {"a", "bc", "def", "€", "€a", "a€", "a€b", "¶", "¶a", "a¶", "a¶b" });
		internalTestListString(new String[] {});
		internalTestListString(new String[] {"a"});
		internalTestListString(new String[] {"¶"});
		internalTestListString(new String[] {"€"});
		log.info(")testListString");
	}

	protected void internalTestListString(String[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.string1 = new ArrayList<String>(Arrays.asList(arr));
		internalTestList(obj);
	}
	
	
	@Test
	public void testListPimitiveTypes() throws BException {
		log.info("testListPimitiveTypes(");
		internalTestListPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() });
		internalTestListPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes()});
		internalTestListPimitiveTypes(new PrimitiveTypes[] {});
		internalTestListPimitiveTypes(new PrimitiveTypes[] {null});

		PrimitiveTypes[] arr = new PrimitiveTypes[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = TestUtils.createObjectPrimitiveTypes();
		}
		internalTestListPimitiveTypes(arr);
		
		log.info(")testListPimitiveTypes");
	}

	protected void internalTestListPimitiveTypes(PrimitiveTypes[] arr) throws BException {
		ListTypes obj = new ListTypes();
		obj.primitiveTypes1 = new ArrayList<PrimitiveTypes>(Arrays.asList(arr));
		internalTestList(obj);
	}

	@Test
	public void testListListInteger() throws BException {
		log.info("testListListInteger(");
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> itemList = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				itemList.add(j);
			}
		}
		internalTestListListInteger(list);
		
		list.clear();
		list.add(null);
		internalTestListListInteger(list);

		list.add(new ArrayList<Integer>());
		internalTestListListInteger(list);
		
		log.info(")testListListInteger");
	}

	protected void internalTestListListInteger(List<List<Integer>> list) throws BException {
		ListListTypes obj = new ListListTypes();
		internalTestList(obj);
	}
	
	/**
	 * Test complex for collection: List<Map<Integer,Set<List<PrimitiveTypes>>>>
	 * This test fails, if the generated class PrimitiveTypes is used, since it does not have an equals method.
	 * @throws BException
	 */
	@Test
	public void testListMapSetListInteger() throws BException {
		log.info("testListMapSetListInteger(");
		
		List<Map<Integer,List<TreeSet<Integer>>>> list = new ArrayList<Map<Integer,List<TreeSet<Integer>>>>();
		for (int i = 0; i < 2; i++) {
			Map<Integer,List<TreeSet<Integer>>> map = new HashMap<Integer,List<TreeSet<Integer>>>();
			for (int j = 0; j < 3; j++) {
				List<TreeSet<Integer>> arr = new ArrayList<TreeSet<Integer>>();
				for (int k = 0; k < 4; k++) {
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int n = 0; n < 5; n++) {
						Integer pt = (n+1) * (k+1) * (j+1) * (i+1);
						set.add(pt);
					}
					arr.add(set);
				}
				map.put(j, arr);
			}
			list.add(map);
		}
		internalTestListMapSetListInteger(list);
		
		log.info(")testListMapSetListInteger");
	}

	protected void internalTestListMapSetListInteger(List<Map<Integer,List<TreeSet<Integer>>>> list) throws BException {
		ListListTypes obj = new ListListTypes();
		obj.int3 = list;
		internalTestList(obj);
	}
	
	/**
	 * Null-values for primitive types (Boolean, Integer, ...) are replaced by default values (false, 0, ...)
	 * @throws BException
	 */
	@Test
	public void testListOfNullValues() throws BException {
		BOutput bout = transport.getOutput();
		
		ListTypes obj = new ListTypes();
		obj.boolean1 = new ArrayList<Boolean>();
		obj.byte1 = new ArrayList<Byte>();
		obj.char1 = new ArrayList<Character>();
		obj.double1 = new ArrayList<Double>();
		obj.float1 = new ArrayList<Float>();
		obj.int1 = new ArrayList<Integer>();
		obj.long1 = new ArrayList<Long>();
		obj.primitiveTypes1 = new ArrayList<PrimitiveTypes>();
		obj.short1 = new ArrayList<Short>();
		obj.string1 = new ArrayList<String>();
		obj.boolean1.add(null);
		obj.byte1.add(null);
		obj.char1.add(null);
		obj.double1.add(null);
		obj.float1.add(null);
		obj.int1.add(null);
		obj.long1.add(null);
		obj.primitiveTypes1.add(null);
		obj.short1.add(null);
		obj.string1.add(null);

		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ListTypes objR = (ListTypes)bin.load();
		
		ListTypes objE = new ListTypes();
		objE.boolean1 = new ArrayList<Boolean>();
		objE.byte1 = new ArrayList<Byte>();
		objE.char1 = new ArrayList<Character>();
		objE.double1 = new ArrayList<Double>();
		objE.float1 = new ArrayList<Float>();
		objE.int1 = new ArrayList<Integer>();
		objE.long1 = new ArrayList<Long>();
		objE.primitiveTypes1 = new ArrayList<PrimitiveTypes>();
		objE.short1 = new ArrayList<Short>();
		objE.string1 = new ArrayList<String>();
		objE.boolean1.add(false);
		objE.byte1.add((byte)0);
		objE.char1.add((char)0);
		objE.double1.add(0.0);
		objE.float1.add(0.0f);
		objE.int1.add(0);
		objE.long1.add(0L);
		objE.primitiveTypes1.add(null);
		objE.short1.add((short)0);
		objE.string1.add("");
		
		TestUtils.assertEquals(log, "", objE, objR);
	}

	/**
	 * A List<Object> can contain only BSerializable objects.
	 * @throws BException 
	 */
	@Test
	public void testListOfObject() throws BException {
		log.info("testListOfObject(");
		
		try {
			ListTypes obj = new ListTypes();
			obj.obj1 = new ArrayList<Object>();
			obj.obj1.add("string must fail");
			internalTestList(obj);
			Assert.fail("Exception expected for List<Object> containing Strings");
		}
		catch (BException e) {
			Assert.assertTrue(e.toString().startsWith("[BYPS:" + BExceptionC.CORRUPT));
		}
		
		ListTypes obj = new ListTypes();
		obj.obj1 = new ArrayList<Object>();
		obj.obj1.add(TestUtils.createObjectPrimitiveTypes());
		internalTestList(obj);

		log.info(")testListOfObject");
	}
	
	protected void internalTestList(Object obj) throws BException {
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		Object objR = bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

}
