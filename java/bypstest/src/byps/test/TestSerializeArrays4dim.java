package byps.test;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BException;
import byps.BInput;
import byps.BOutput;
import byps.BTransport;
import byps.test.api.arr.ArrayTypes4dim;
import byps.test.api.prim.PrimitiveTypes;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * 4-dimensional arrays.
 */
public class TestSerializeArrays4dim {
	
	private Log log = LogFactory.getLog(TestSerializeArrays4dim.class);
	BTransport transport = TestUtils.createTransport();
	
	/**
	 * Test with null values for all 4-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testArrayTypes4dimNull() throws BException {
		log.info("testArrayTypes4dimNull(");
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj", obj, objR);
		log.info(")testArrayTypes4dimNull");
	}
	
	@Test
	public void testArrayTypes4dimEmpty() throws BException {
		log.info("testArrayTypes4dimEmpty(");
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();

		obj.boolean4 = new boolean[0][0][0][0];
		obj.byte4 = new byte[0][0][0][0];
		obj.char4 = new char[0][0][0][0];
		obj.double4 = new double[0][0][0][0];
		obj.float4 = new float[0][0][0][0];
		obj.int4 = new int[0][0][0][0];
		obj.long4 = new long[0][0][0][0];
		obj.primitiveTypes4 = new PrimitiveTypes[0][0][0][0];
		obj.short4 = new short[0][0][0][0];
		obj.string4 = new String[0][0][0][0];

		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj", obj, objR);
		log.info(")testArrayTypes4dimEmpty");
	}

	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	@Test
	public void testArrayTypes4dimNotNull() throws BException {
		log.info("testArrayTypes4dimNotNull(");
		BOutput bout = transport.getOutput();
		
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
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		
		TestUtils.assertEquals(log, "obj", obj, objR);
		log.info(")testArrayTypes4dimNotNull");
	}

	@Test
	public void testArrayTypes4dimBoolean() throws BException {
		log.info("testArrayTypes4dimBoolean(");
		internalTestArrayTypes4dimBoolean(
				new boolean[][][][] {{{
								{false, false, false, false },
								{false, false, false, true },
								{false, false, true, false },
								{false, false, true, true },
							},{
								{false, true, false, false },
								{false, true, false, true },
								{false, true, true, false },
								{false, true, true, true },
						},},{{
								{true, false, false, false },
								{true, false, false, true },
								{true, false, true, false },
								{true, false, true, true },
							},{
								{true, true, false, false },
								{true, true, false, true },
								{true, true, true, false },
								{true, true, true, true },
						},}});
		
		internalTestArrayTypes4dimBoolean(new boolean[0][0][0][0]);
		internalTestArrayTypes4dimBoolean(new boolean[][][][] {{{{true}}}});
		internalTestArrayTypes4dimBoolean(new boolean[][][][] {{{{false}}}});
		log.info(")testArrayTypes4dimBoolean");
	}

	protected void internalTestArrayTypes4dimBoolean(boolean[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.boolean4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.boolean4", obj.boolean4, objR.boolean4);
	}

	@Test
	public void testArrayTypes4dimByte() throws BException {
		log.info("testArrayTypes4dimByte(");
		internalTestArrayTypes4dimByte(
				new byte[][][][] {{{
								{111, 111, 111, 111 },
								{111, 111, 111, 0 },
								{111, 111, 0, 111 },
								{111, 111, 0, 0 },
							},{
								{111, 0, 111, 111 },
								{111, 0, 111, 0 },
								{111, 0, 0, 111 },
								{111, 0, 0, 0 },
						},},{{
								{0, 111, 111, 111 },
								{0, 111, 111, 0 },
								{0, 111, 0, 111 },
								{0, 111, 0, 0 },
							},{
								{0, 0, 111, 111 },
								{0, 0, 111, 0 },
								{0, 0, 0, 111 },
								{0, 0, 0, 0 },
						},}});
		
		internalTestArrayTypes4dimByte(new byte[0][0][0][0]);
		internalTestArrayTypes4dimByte(new byte[][][][] {{{{0}}}});
		internalTestArrayTypes4dimByte(new byte[][][][] {{{{111}}}});
		log.info(")testArrayTypes4dimByte");
	}

	protected void internalTestArrayTypes4dimByte(byte[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.byte4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.byte4", obj.byte4, objR.byte4);
	}

	@Test
	public void testArrayTypes4dimChar() throws BException {
		log.info("testArrayTypes4dimChar(");
		internalTestArrayTypes4dimChar(
				new char[][][][] {{{
								{'a', 'a', 'a', 'a' },
								{'a', 'a', 'a', 'b' },
								{'a', 'a', 'b', 'a' },
								{'a', 'a', 'b', 'b' },
							},{
								{'a', 'b', 'a', 'a' },
								{'a', 'b', 'a', 'b' },
								{'a', 'b', 'b', 'a' },
								{'a', 'b', 'b', 'b' },
						},},{{
								{'b', 'a', 'a', 'a' },
								{'b', 'a', 'a', 'b' },
								{'b', 'a', 'b', 'a' },
								{'b', 'a', 'b', 'b' },
							},{
								{'b', 'b', 'a', 'a' },
								{'b', 'b', 'a', 'b' },
								{'b', 'b', 'b', 'a' },
								{'b', 'b', 'b', 'b' },
						},}});
		
		internalTestArrayTypes4dimChar(new char[0][0][0][0]);
		internalTestArrayTypes4dimChar(new char[][][][] {{{{0}}}});
		internalTestArrayTypes4dimChar(new char[][][][] {{{{111}}}});
		log.info(")testArrayTypes4dimChar");
	}

	protected void internalTestArrayTypes4dimChar(char[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.char4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.char4", obj.char4, objR.char4);
	}

	@Test
	public void testArrayTypes4dimShort() throws BException {
		log.info("testArrayTypes4dimShort(");
		internalTestArrayTypes4dimShort(
				new short[][][][] {{{
								{-1, -1, -1, -1 },
								{-1, -1, -1, +1 },
								{-1, -1, +1, -1 },
								{-1, -1, +1, +1 },
							},{
								{-1, +1, -1, -1 },
								{-1, +1, -1, +1 },
								{-1, +1, +1, -1 },
								{-1, +1, +1, +1 },
						},},{{
								{+1, -1, -1, -1 },
								{+1, -1, -1, +1 },
								{+1, -1, +1, -1 },
								{+1, -1, +1, +1 },
							},{
								{+1, +1, -1, -1 },
								{+1, +1, -1, +1 },
								{+1, +1, +1, -1 },
								{+1, +1, +1, +1 },
						},}});
		
		internalTestArrayTypes4dimShort(new short[0][0][0][0]);
		internalTestArrayTypes4dimShort(new short[][][][] {{{{0}}}});
		internalTestArrayTypes4dimShort(new short[][][][] {{{{111}}}});
		log.info(")testArrayTypes4dimShort");
	}

	protected void internalTestArrayTypes4dimShort(short[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.short4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.short4", obj.short4, objR.short4);
	}

	@Test
	public void testArrayTypes4dimInt() throws BException {
		log.info("testArrayTypes4dimInt(");
		internalTestArrayTypes4dimInt(
				new int[][][][] {{{
								{-1, -1, -1, -1 },
								{-1, -1, -1, +1 },
								{-1, -1, +1, -1 },
								{-1, -1, +1, +1 },
							},{
								{-1, +1, -1, -1 },
								{-1, +1, -1, +1 },
								{-1, +1, +1, -1 },
								{-1, +1, +1, +1 },
						},},{{
								{+1, -1, -1, -1 },
								{+1, -1, -1, +1 },
								{+1, -1, +1, -1 },
								{+1, -1, +1, +1 },
							},{
								{+1, +1, -1, -1 },
								{+1, +1, -1, +1 },
								{+1, +1, +1, -1 },
								{+1, +1, +1, +1 },
						},}});
		
		internalTestArrayTypes4dimInt(new int[0][0][0][0]);
		internalTestArrayTypes4dimInt(new int[][][][] {{{{0}}}});
		internalTestArrayTypes4dimInt(new int[][][][] {{{{111}}}});
		log.info(")testArrayTypes4dimInt");
	}

	protected void internalTestArrayTypes4dimInt(int[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.int4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.int4", obj.int4, objR.int4);
	}
	
	
	@Test
	public void testArrayTypes4dimLong() throws BException {
		log.info("testArrayTypes4dimLong(");
		internalTestArrayTypes4dimLong(
				new long[][][][] {{{
								{-1, -1, -1, -1 },
								{-1, -1, -1, +1 },
								{-1, -1, +1, -1 },
								{-1, -1, +1, +1 },
							},{
								{-1, +1, -1, -1 },
								{-1, +1, -1, +1 },
								{-1, +1, +1, -1 },
								{-1, +1, +1, +1 },
						},},{{
								{+1, -1, -1, -1 },
								{+1, -1, -1, +1 },
								{+1, -1, +1, -1 },
								{+1, -1, +1, +1 },
							},{
								{+1, +1, -1, -1 },
								{+1, +1, -1, +1 },
								{+1, +1, +1, -1 },
								{+1, +1, +1, +1 },
						},}});
		
		internalTestArrayTypes4dimLong(new long[0][0][0][0]);
		internalTestArrayTypes4dimLong(new long[][][][] {{{{0}}}});
		internalTestArrayTypes4dimLong(new long[][][][] {{{{111}}}});
		log.info(")testArrayTypes4dimLong");
	}

	protected void internalTestArrayTypes4dimLong(long[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.long4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.long4", obj.long4, objR.long4);
	}

	@Test
	public void testArrayTypes4dimString() throws BException {
		log.info("testArrayTypes4dimString(");
		internalTestArrayTypes4dimString(
				new String[][][][] {{{
								{"-1", "-1", "-1", "-1" },
								{"-1", "-1", "-1", "+1" },
								{"-1", "-1", "+1", "-1" },
								{"-1", "-1", "+1", "+1" },
							},{
								{"-1", "+1", "-1", "-1" },
								{"-1", "+1", "-1", "+1" },
								{"-1", "+1", "+1", "-1" },
								{"-1", "+1", "+1", "+1" },
						},},{{
								{"+1", "-1", "-1", "-1" },
								{"+1", "-1", "-1", "+1" },
								{"+1", "-1", "+1", "-1" },
								{"+1", "-1", "+1", "+1" },
							},{
								{"+1", "+1", "-1", "-1" },
								{"+1", "+1", "-1", "+1" },
								{"+1", "+1", "+1", "-1" },
								{"+1", "+1", "+1", "+1" },
						},}});
		
		internalTestArrayTypes4dimString(new String[0][0][0][0]);
		internalTestArrayTypes4dimString(new String[][][][] {{{{""}}}});
		internalTestArrayTypes4dimString(new String[][][][] {{{{"1"}}}});
		log.info(")testArrayTypes4dimString");
	}

	protected void internalTestArrayTypes4dimString(String[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.string4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.String4", obj.string4, objR.string4);
	}

	@Test
	public void testArrayTypes4dimPrimitiveTypes() throws BException {
		log.info("testArrayTypes4dimPrimitiveTypes(");
		internalTestArrayTypes4dimPrimitiveTypes(
				new PrimitiveTypes[][][][] {{{
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
							},{
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
						},},{{
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
							},{
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
								{TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() },
						},}});
		
		internalTestArrayTypes4dimPrimitiveTypes(new PrimitiveTypes[0][0][0][0]);
		internalTestArrayTypes4dimPrimitiveTypes(new PrimitiveTypes[][][][] {{{{null}}}});
		internalTestArrayTypes4dimPrimitiveTypes(new PrimitiveTypes[][][][] {{{{TestUtils.createObjectPrimitiveTypes()}}}});
		log.info(")testArrayTypes4dimPrimitiveTypes");
	}

	protected void internalTestArrayTypes4dimPrimitiveTypes(PrimitiveTypes[][][][] arr) throws BException {
		BOutput bout = transport.getOutput();
		
		ArrayTypes4dim obj = new ArrayTypes4dim();
		obj.primitiveTypes4 = arr;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null,  buf);
		ArrayTypes4dim objR = (ArrayTypes4dim)bin.load();
		TestUtils.assertEquals(log, "obj.PrimitiveTypes4", obj.primitiveTypes4, objR.primitiveTypes4);
	}


}
