package com.wilutions.byps.test;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.set.SetTypes;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * List<> types.
 */
public class TestSerializerSet {

	private Log log = LogFactory.getLog(TestSerializerSet.class);
	BTransport transport = TestUtils.createTransport();
	
	/**
	 * Test with null values for all lists.
	 * @throws BException
	 */
	@Test
	public void testSetNull() throws BException {
		log.info("testSetNull(");
		BOutput bout = transport.getOutput();
		
		SetTypes obj = new SetTypes();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		SetTypes objR = (SetTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testSetNull");
	}
	
	/**
	 * Test with null values for all lists.
	 * @throws BException
	 */
	@Test
	public void testSetEmpty() throws BException {
		log.info("testSetEmpty(");
		BOutput bout = transport.getOutput();
		
		SetTypes obj = new SetTypes();
		obj.boolean1 = new HashSet<Boolean>();
		obj.byte1 = new HashSet<Byte>();
		obj.char1 = new TreeSet<Character>();
		obj.double1 = new HashSet<Double>();
		obj.float1 = new HashSet<Float>();
		obj.int1 = new HashSet<Integer>();
		obj.long1 = new HashSet<Long>();
		obj.primitiveTypes1 = new HashSet<PrimitiveTypes>();
		obj.short1 = new HashSet<Short>();
		obj.string1 = new HashSet<String>();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		SetTypes objR = (SetTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testSetEmpty");
	}
	
	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * This test fails, if the generated class PrimitiveTypes is used, since it does not have an equals method.
	 * 
	 * @throws BException
	 */
	@Test
	public void testSetNotNull() throws BException {
		log.info("testSetNotNull(");
		BOutput bout = transport.getOutput();
		
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

		bout.store(obj);
				
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		SetTypes objR = (SetTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		
		log.info(")testSetNotNull");
	}

	@Test
	public void testSetBoolean() throws BException {
		log.info("testSetBoolean(");
		internaltestSetBoolean(new Boolean[] {true, false, true, false, true });
		internaltestSetBoolean(new Boolean[] {});
		internaltestSetBoolean(new Boolean[] {true});
		internaltestSetBoolean(new Boolean[] {false});
		log.info(")testSetBoolean");
	}

	protected void internaltestSetBoolean(Boolean[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.boolean1 = new HashSet<Boolean>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	protected void internaltestSet(Object obj) throws BException {
		BOutput bout = transport.getOutput();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		SetTypes objR = (SetTypes)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	
	@Test
	public void testSetByte() throws BException {
		log.info("testSetByte(");
		internaltestSetByte(new Byte[] {1,2,3,4,5});
		internaltestSetByte(new Byte[] {1,2,3,4,5,6});
		internaltestSetByte(new Byte[] {});
		internaltestSetByte(new Byte[] {1});
		internaltestSetByte(new Byte[] {0});
		log.info(")testSetByte");
	}

	protected void internaltestSetByte(Byte[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.byte1 = new HashSet<Byte>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetChar() throws BException {
		log.info("testSetChar(");
		internaltestSetCharacter(new Character[] {'a', '¶', '€' });
		internaltestSetCharacter(new Character[] {});
		internaltestSetCharacter(new Character[] {'a'});
		internaltestSetCharacter(new Character[] {'¶'});
		internaltestSetCharacter(new Character[] {'€'});
		log.info(")testSetCharacter");
	}

	protected void internaltestSetCharacter(Character[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.char1 = new TreeSet<Character>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetShort() throws BException {
		log.info("testSetShort(");
		internaltestSetShort(new Short[] {1, -1, 123, -123, (short)0xCDCD });
		internaltestSetShort(new Short[] {});
		internaltestSetShort(new Short[] {1});
		internaltestSetShort(new Short[] {0});
		log.info(")testSetShort");
	}

	protected void internaltestSetShort(Short[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.short1 = new HashSet<Short>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetInteger() throws BException {
		log.info("testSetInteger(");
		internaltestSetInteger(new Integer[] {1, -1, 123, -123, (Integer)0xCDCDCDCD });
		internaltestSetInteger(new Integer[] {});
		internaltestSetInteger(new Integer[] {1});
		internaltestSetInteger(new Integer[] {0});
		log.info(")testSetInteger");
	}

	protected void internaltestSetInteger(Integer[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.int1 = new HashSet<Integer>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetLong() throws BException {
		log.info("testSetLong(");
		internaltestSetLong(new Long[] {1L, -1L, 123L, -123L, 0xCDCDCDCDCDCDCDCDL });
		internaltestSetLong(new Long[] {});
		internaltestSetLong(new Long[] {1L});
		internaltestSetLong(new Long[] {0L});
		log.info(")testSetLong");
	}

	protected void internaltestSetLong(Long[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.long1 = new HashSet<Long>(Arrays.asList(arr));
		internaltestSet(obj);
	}
	
	@Test
	public void testSetFloat() throws BException {
		log.info("testSetFloat(");
		internaltestSetFloat(new Float[] {1f, -1f, 123f, -123f, 4e5f });
		internaltestSetFloat(new Float[] {});
		internaltestSetFloat(new Float[] {1f});
		internaltestSetFloat(new Float[] {0f});
		log.info(")testSetFloat");
	}

	protected void internaltestSetFloat(Float[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.float1 = new HashSet<Float>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetDouble() throws BException {
		log.info("testSetDouble(");
		internaltestSetDouble(new Double[] {1.0, -1.0, 123.0, -123.0, 1.4e-6 });
		internaltestSetDouble(new Double[] {});
		internaltestSetDouble(new Double[] {1.0});
		internaltestSetDouble(new Double[] {0.0});
		log.info(")testSetFloat");
	}

	protected void internaltestSetDouble(Double[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.double1 = new HashSet<Double>(Arrays.asList(arr));
		internaltestSet(obj);
	}

	@Test
	public void testSetString() throws BException {
		log.info("testSetString(");
		internaltestSetString(new String[] {"a", "bc", "def", "€", "€a", "a€", "a€b", "¶", "¶a", "a¶", "a¶b" });
		internaltestSetString(new String[] {});
		internaltestSetString(new String[] {"a"});
		internaltestSetString(new String[] {"¶"});
		internaltestSetString(new String[] {"€"});
		log.info(")testSetString");
	}

	protected void internaltestSetString(String[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.string1 = new HashSet<String>(Arrays.asList(arr));
		internaltestSet(obj);
	}
	
	
	/**
	 * Test set of class PrimitiveTypes.
	 * This test fails, if the generated class PrimitiveTypes is used, since it does not have an equals method.
	 * @throws BException
	 */
	@Test
	public void testSetPimitiveTypes() throws BException {
		log.info("testSetPimitiveTypes(");
		internaltestSetPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() });
		internaltestSetPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes()});
		internaltestSetPimitiveTypes(new PrimitiveTypes[] {});
		internaltestSetPimitiveTypes(new PrimitiveTypes[] {null});
		log.info(")testSetPimitiveTypes");
	}

	
	/**
	 * A List<Object> can contain only BSerializable objects.
	 * @throws BException 
	 */
	@Test
	public void testSetOfObject() throws BException {
		log.info("testSetOfObject(");
		
		try {
			SetTypes obj = new SetTypes();
			obj.obj1 = new HashSet<Object>();
			obj.obj1.add("string must fail");
			internaltestSet(obj);
			Assert.fail("Exception expected for List<Object> containing Strings");
		}
		catch (BException e) {
			Assert.assertTrue(e.toString().startsWith("[BYPS:" + BExceptionC.CORRUPT));
		}
		
		SetTypes obj = new SetTypes();
		obj.obj1 = new HashSet<Object>();
		obj.obj1.add(TestUtils.createObjectPrimitiveTypes());
		internaltestSet(obj);

		log.info(")testSetOfObject");
	}

	protected void internaltestSetPimitiveTypes(PrimitiveTypes[] arr) throws BException {
		SetTypes obj = new SetTypes();
		obj.primitiveTypes1 = new HashSet<PrimitiveTypes>(Arrays.asList(arr));
		internaltestSet(obj);
	}

}
