package com.wilutions.byps.test;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BBuffer;
import com.wilutions.byps.BBufferJson;
import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BProtocolJson;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.arr.ArrayTypes1dim;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * arrays, e.g. int[], String[], PrimitiveTypes[]...
 */
public class TestSerializeArrays1dim {

	private Log log = LogFactory.getLog(TestSerializeArrays1dim.class);
	BTransport transport = TestUtils.createTransport();
	
	/**
	 * Test with null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testArrayTypes1dimNull() throws BException {
		log.info("testArrayTypes1dimNull(");
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testArrayTypes1dimNull");
	}
	
	/**
	 * Test with null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testArrayTypes1dimEmpty() throws BException {
		log.info("testArrayTypes1dimEmpty(");
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.boolean1 = new boolean[0];
		obj.byte1 = new byte[0];
		obj.char1 = new char[0];
		obj.double1 = new double[0];
		obj.float1 = new float[0];
		obj.int1 = new int[0];
		obj.long1 = new long[0];
		obj.primitiveTypes1 = new PrimitiveTypes[0];
		obj.short1 = new short[0];
		obj.string1 = new String[0];
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testArrayTypes1dimEmpty");
	}
	
	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testArrayTypes1dimNotNull() throws BException {
		log.info("testArrayTypes1dimNotNull(");
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.boolean1 = new boolean[] {true};
		obj.byte1 = "hello".getBytes();
		obj.char1 = "ulla".toCharArray();
		obj.double1 = new double[0];
		obj.float1 = new float[] {1,2,3,4};
		obj.int1 = new int[] {1,2,3,4,5};
		obj.long1 = new long[] {1,2,3,4,5,6};
		obj.primitiveTypes1 = new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() };
		obj.short1 = new short[] {1,2,3,4,5,6,7};
		obj.string1 = new String[] {"a", "b", "c"};
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		
		TestUtils.assertEquals(log, "", obj, objR);
		log.info(")testArrayTypes1dimNotNull");
	}

	@Test
	public void testArrayTypes1dimBoolean() throws BException {
		log.info("testArrayTypes1dimBoolean(");
		internalTestArrayTypes1dimBoolean(new boolean[] {true, false, true, false, true });
		internalTestArrayTypes1dimBoolean(new boolean[] {});
		internalTestArrayTypes1dimBoolean(new boolean[] {true});
		internalTestArrayTypes1dimBoolean(new boolean[] {false});
		log.info(")testArrayTypes1dimBoolean");
	}

	protected void internalTestArrayTypes1dimBoolean(boolean[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.boolean1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	
	@Test
	public void testJsonByteArrayBase64() throws BException {
		log.info("testByteArrayBase64(");
		if (TestUtils.protocol == BProtocolJson.BINARY_MODEL) {

			internalTestSerializeByteArrayBase64(new byte[] {1});
			internalTestSerializeByteArrayBase64(new byte[] {1,2});
			internalTestSerializeByteArrayBase64(new byte[] {1,2,3});
			internalTestSerializeByteArrayBase64(new byte[] {1,2,3,4});
			internalTestSerializeByteArrayBase64(new byte[] {1,2,3,4,5});
			internalTestSerializeByteArrayBase64(new byte[] {1,2,3,4,5,6,7});
			internalTestSerializeByteArrayBase64(new byte[] {0,26,52,62,63});
			internalTestSerializeByteArrayBase64(new byte[] {1,27,53});
			internalTestSerializeByteArrayBase64(new byte[] {25,51});

			internalTestSerializeByteArrayBase64(null);
			
			internalTestSerializeByteArrayBase64(new byte[0]);

			byte[] all = new byte[256];
			for (int i = 0; i < 256; i++) all[i] = (byte)i;
			internalTestSerializeByteArrayBase64(all);
		}
		log.info(")testByteArrayBase64");
	}
	
	private void internalTestSerializeByteArrayBase64(byte[] v) throws BException {
		log.info("internalTestSerializeByteArrayBase64(" + v);
		ByteBuffer buf = ByteBuffer.allocate(1000);
		BBufferJson bbuf = (BBufferJson)BBuffer.create(BBinaryModel.JSON, buf);
		bbuf.putArrayByte(v);
		bbuf.flip();
		
		if (v != null) {
			String expectedText = "\"" + javax.xml.bind.DatatypeConverter.printBase64Binary(v) + "\"";
			log.info("expectedText=\r\n" + expectedText);
			String textR = TestUtils.bufferToString(buf);
			log.info("readText=\r\n" + textR);
			TestUtils.assertEquals(log, "base64", expectedText, textR);
		}
		
		TestUtils.printBuffer(log, buf);
		byte[] vR = bbuf.getArrayByte();
		TestUtils.assertEquals(log, "byte[]", v, vR);
		log.info(")internalTestSerializeByteArrayBase64");
	}

	@Test
	public void testArrayTypes1dimChar() throws BException {
		log.info("testArrayTypes1dimChar(");
		internalTestArrayTypes1dimChar(new char[] {'a', '¶', '€' });
		internalTestArrayTypes1dimChar(new char[] {});
		internalTestArrayTypes1dimChar(new char[] {'a'});
		internalTestArrayTypes1dimChar(new char[] {'¶'});
		internalTestArrayTypes1dimChar(new char[] {'€'});
		log.info(")testArrayTypes1dimChar");
	}

	protected void internalTestArrayTypes1dimChar(char[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.char1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testArrayTypes1dimShort() throws BException {
		log.info("testArrayTypes1dimShort(");
		internalTestArrayTypes1dimShort(new short[] {1, -1, 123, -123, (short)0xCDCD });
		internalTestArrayTypes1dimShort(new short[] {});
		internalTestArrayTypes1dimShort(new short[] {1});
		internalTestArrayTypes1dimShort(new short[] {0});
		log.info(")testArrayTypes1dimShort");
	}

	protected void internalTestArrayTypes1dimShort(short[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.short1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testArrayTypes1dimInt() throws BException {
		log.info("testArrayTypes1dimInt(");
		internalTestArrayTypes1dimInt(new int[] {1, -1, 123, -123, (int)0xCDCDCDCD });
		internalTestArrayTypes1dimInt(new int[] {});
		internalTestArrayTypes1dimInt(new int[] {1});
		internalTestArrayTypes1dimInt(new int[] {0});
		log.info(")testArrayTypes1dimInt");
	}

	protected void internalTestArrayTypes1dimInt(int[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.int1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testArrayTypes1dimLong() throws BException {
		log.info("testArrayTypes1dimLong(");
		internalTestArrayTypes1dimLong(new long[] {1, -1, 123, -123, 0xCDCDCDCDCDCDCDCDL });
		internalTestArrayTypes1dimLong(new long[] {});
		internalTestArrayTypes1dimLong(new long[] {1});
		internalTestArrayTypes1dimLong(new long[] {0});
		log.info(")testArrayTypes1dimLong");
	}

	protected void internalTestArrayTypes1dimLong(long[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.long1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}
	
	@Test
	public void testArrayTypes1dimFloat() throws BException {
		log.info("testArrayTypes1dimFloat(");
		internalTestArrayTypes1dimFloat(new float[] {1, -1, 123, -123, 4e5f });
		internalTestArrayTypes1dimFloat(new float[] {});
		internalTestArrayTypes1dimFloat(new float[] {1});
		internalTestArrayTypes1dimFloat(new float[] {0});
		log.info(")testArrayTypes1dimFloat");
	}

	protected void internalTestArrayTypes1dimFloat(float[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.float1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testArrayTypes1dimDouble() throws BException {
		log.info("testArrayTypes1dimDouble(");
		internalTestArrayTypes1dimDouble(new double[] {1, -1, 123, -123, 1.4e-6 });
		internalTestArrayTypes1dimDouble(new double[] {});
		internalTestArrayTypes1dimDouble(new double[] {1});
		internalTestArrayTypes1dimDouble(new double[] {0});
		log.info(")testArrayTypes1dimFloat");
	}

	protected void internalTestArrayTypes1dimDouble(double[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.double1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

	@Test
	public void testArrayTypes1dimString() throws BException {
		log.info("testArrayTypes1dimString(");
		internalTestArrayTypes1dimString(new String[] {"a", "bc", "def", "€", "€a", "a€", "a€b", "¶", "¶a", "a¶", "a¶b" });
		internalTestArrayTypes1dimString(new String[] {});
		internalTestArrayTypes1dimString(new String[] {"a"});
		internalTestArrayTypes1dimString(new String[] {"¶"});
		internalTestArrayTypes1dimString(new String[] {"€"});
		log.info(")testArrayTypes1dimString");
	}

	protected void internalTestArrayTypes1dimString(String[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.string1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}
	
	
	@Test
	public void testArrayTypes1dimPimitiveTypes() throws BException {
		log.info("testArrayTypes1dimPimitiveTypes(");
		internalTestArrayTypes1dimPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() });
		internalTestArrayTypes1dimPimitiveTypes(new PrimitiveTypes[] { TestUtils.createObjectPrimitiveTypes()});
		internalTestArrayTypes1dimPimitiveTypes(new PrimitiveTypes[] {});
		internalTestArrayTypes1dimPimitiveTypes(new PrimitiveTypes[] {null});
		log.info(")testArrayTypes1dimPimitiveTypes");
	}

	protected void internalTestArrayTypes1dimPimitiveTypes(PrimitiveTypes[] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes1dim obj = new ArrayTypes1dim();
		obj.primitiveTypes1 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		ArrayTypes1dim objR = (ArrayTypes1dim)bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	}

}
