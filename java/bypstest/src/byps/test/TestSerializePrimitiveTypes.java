package byps.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.BBinaryModel;
import byps.BBuffer;
import byps.BBufferBin;
import byps.BBufferJson;
import byps.BException;
import byps.BInput;
import byps.BOutput;
import byps.BProtocolJson;
import byps.BTransport;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.list.ListTypes;
import byps.test.api.prim.PrimitiveTypes;

/**
 * This class provides tests to check the 
 * serialization and deserialization of 
 * primitive types (int, double, string,...).
 * 
 *
 */
public class TestSerializePrimitiveTypes {
	
	BTransport transport = TestUtils.createTransport();
	private Log log = LogFactory.getLog(TestSerializePrimitiveTypes.class);
	
	
	/**
	 * BBufferBin/BBufferJson re-allocate an internal ByteBuffer, 
	 * if the buffer supplied in the constructor is too small.
	 * The bytes written so far have to be copied into the new Buffer.  
	 * @throws BException 
	 */
	@Test
	public void testBufferRealloc() throws BException {
		log.info("testBufferRealloc(");
		internalTestBufferRealloc(ByteOrder.BIG_ENDIAN);
		internalTestBufferRealloc(ByteOrder.LITTLE_ENDIAN);
		log.info(")testBufferRealloc");
	}
	
	public void internalTestBufferRealloc(ByteOrder border) throws BException {
		ByteBuffer buf = ByteBuffer.allocate(17);
		buf.order(border);
		BBuffer bbuf = BBuffer.create(TestUtils.protocol, buf);
		int count = 3;
		
		for (int i = 0; i < count; i++) {
			bbuf.putDouble(i);
		}
		bbuf.flip();
		
		TestUtils.printBuffer(log, bbuf);
		
		if (TestUtils.protocol == BProtocolJson.BINARY_MODEL) {
			BBufferJson jbuf = (BBufferJson)bbuf;
			for (int i = 0; i < count; i++) {
				if (i != 0) jbuf.nextExpectedJsonChar(',', true);
				double d = bbuf.getDouble();
				TestUtils.assertEquals(log, "double[" + i + "]", (double)i, d);
			}
		} 
		else {
			for (int i = 0; i < count; i++) {
				double d = bbuf.getDouble();
				TestUtils.assertEquals(log, "double[" + i + "]", (double)i, d);
			}
		}
	}
	
	/**
	 * € UTF-8: 11100010:10000010:10101100 E2 82 AC
	 * € UTF-16: 0x20AC
	 */
	@Test
	public void testSerializeStingUTF8() {
		log.info("testSerializeStringUTF8(");

		internalTestSerializeStringUTF8("¶"); // 2 bytes
		
		internalTestSerializeStringUTF8(createLargeString());

		
		internalTestSerializeStringUTF8("\" double quote");
		internalTestSerializeStringUTF8("' single quote");
		internalTestSerializeStringUTF8("abc");
		internalTestSerializeStringUTF8("a");
		internalTestSerializeStringUTF8("\tabc");
		internalTestSerializeStringUTF8("abc\tabc");
		internalTestSerializeStringUTF8("abc\t");
		internalTestSerializeStringUTF8("\"");
		internalTestSerializeStringUTF8("\'");
		internalTestSerializeStringUTF8("\t");
		internalTestSerializeStringUTF8("\r");
		internalTestSerializeStringUTF8("\n");
		internalTestSerializeStringUTF8("\\");
		internalTestSerializeStringUTF8("\t\r\n");
		
		internalTestSerializeStringUTF8("c:\\Program Files\\WILUTIONS\\");
		internalTestSerializeStringUTF8("c:\\Program Files\\\\WILUTIONS\\");
		internalTestSerializeStringUTF8("c:\tProgram Files\\WILUTIONS\n");
		internalTestSerializeStringUTF8("c:'Program Files'WILUTIONS\"\"");
		
		internalTestSerializeStringUTF8("¶"); // 2 bytes
		internalTestSerializeStringUTF8("€"); // 3 bytes
		internalTestSerializeStringUTF8("€€");
		internalTestSerializeStringUTF8("a€");
		internalTestSerializeStringUTF8("€a");
		internalTestSerializeStringUTF8("a€a");
		internalTestSerializeStringUTF8("");
		
		internalTestSerializeStringUTF8(null); // null-strings are serialized as empty strings

		internalTestSerializeStringUTF8("\u20ac\u05D0\u05D1");
		internalTestSerializeStringUTF8("\u0000");


		log.info(")testSerializeStringUTF8");
	}
	
	public void internalTestSerializeStringUTF8(String text) {
		log.info("internalTestSerializeStringUTF8(" + ((text != null) ? text.substring(0, Math.min(100, text.length())) : text));
		ByteBuffer buf = ByteBuffer.allocate(1);
		BBuffer bbuf = BBuffer.create(BBinaryModel.MEDIUM, buf);
		bbuf.putString(text);
		bbuf.flip();
		if (text == null || text.length() <= 100) {
			TestUtils.printBuffer(log, bbuf);
		}
		String textE = text != null ? text : ""; // strings must not be null
		String textR = bbuf.getString();
		TestUtils.assertEquals(log, "UTF-8 string", textE,textR);
		
		
		log.info(")internalTestSerializeStringUTF8");
	}

	
	private String createLargeString() {
		int len = 1000 * 1000;
		StringBuilder sbuf = new StringBuilder(len); 
		for (int i = 0; i < len; i++) {
			sbuf.append((char)('A' + (i %26)));
		}
		return sbuf.toString();
	}
	
	@Test
	public void testPrimitiveTypes() throws BException {
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.boolVal = true;
		obj.byteVal = 12;
		obj.charVal = 'D';
		obj.shortVal = 123;
		obj.intVal = -345;
		obj.longVal = 789;
		obj.floatVal = -1.23f;
		obj.doubleVal = 3.45e-7;
		obj.stringVal = "abc\"€€\'def";
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "primitiveTypes", obj, objR);
	}

	@Test
	public void testPrimitiveTypesBool() throws BException {
		log.info("testPrimitiveTypesBool(");
		internalTestBool(true);
		internalTestBool(false);
		log.info(")testPrimitiveTypesBool");
	}

	private void internalTestBool(boolean v) throws BException {
		log.info("internalTestPrimitiveTypesBool(" + v);
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.boolVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "boolVal", obj.boolVal, objR.boolVal);
		log.info(")internalTestPrimitiveTypesBool");
	}
	
	@Test
	public void testPrimitiveTypesByte() throws BException {	
		log.info("testPrimitiveTypesByte(");
		for (int i = 0; i < 256; i++) {
			internalTestByte((byte)i);
		}
		log.info(")testPrimitiveTypesByte");
	}

	private void internalTestByte(byte v) throws BException {
		log.info("internalTestPrimitiveTypesByte(" + v);
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.byteVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "byteVal", obj.byteVal, objR.byteVal);
		log.info(")internalTestPrimitiveTypesByte");
	}

	@Test
	public void testPrimitiveTypesChar() throws BException {	
		log.info("testPrimitiveTypesChar(");
		String chars = "a\t\r\n¶€";
		for (int i = 0; i < chars.length(); i++) {
			char ch = chars.charAt(i);
			internalTestChar2(ch);
			internalTestChar(ch);
		}
		log.info(")testPrimitiveTypesChar");
	}

	private void internalTestChar(char v) throws BException {
		log.info("internalTestChar(" + v);
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.charVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "charVal", obj.charVal, objR.charVal);
		log.info(")internalTestChar");
	}

	private void internalTestChar2(char v) throws BException {
		log.info("internalTestChar2(" + v);
		ByteBuffer buf = ByteBuffer.allocate(1000);
		BBuffer bbuf = BBuffer.create(BBinaryModel.MEDIUM, buf);
		bbuf.putChar(v);
		bbuf.flip();
		char vR = bbuf.getChar();
		Assert.assertEquals(v, vR);
		log.info(")internalTestChar");
	}

	@Test
	public void testPrimitiveTypesShort() throws BException {
		log.info("testPrimitiveTypesShort(");
		for (int i = 1; i < 0xFFFF; i *= 2) {
			internalTestShort((short)i);
		}
		log.info(")testPrimitiveTypesShort");
	}

	private void internalTestShort(short v) throws BException {
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.shortVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "shortVal", obj.shortVal, objR.shortVal);
	}

	
  @Test
  public void testPrimitiveTypesInt() throws RemoteException {
    
    ArrayList<Integer> ints = new ArrayList<Integer>();
    
    ints.add(0);
    ints.add(1);
    ints.add(2);
 
    int a = 0;
    for (int i = 0; i < 31-7; i+=7) {
      ints.add((0x7E << i) | a);
      ints.add((0x7F << i) | a);
      ints.add((0x80 << i) | a);
      ints.add((0x81 << i) | a);
      a <<= 7;
      a |= 0x5D;
    }

    for (int i = 0; i < ints.size(); i++) {
      internalTestInt(ints.get(i));
      internalTestInt(-ints.get(i));
    }
    
    internalTestInt(Integer.MAX_VALUE);
    internalTestInt(Integer.MIN_VALUE);
  }
  
  private void internalTestInt(int v) throws BException {
    BBuffer bbuf = BBufferBin.create(TestUtils.protocol, null);
    bbuf.putInt(v);
    bbuf.flip();
    int r = bbuf.getInt();
    TestUtils.assertEquals(log, "intVal", v, r);
  }

  @Test
  public void testPrimitiveTypesLong() throws RemoteException {
    
    ArrayList<Long> ints = new ArrayList<Long>();
    
    ints.add((long) 0);
    ints.add((long) 1);
    ints.add((long) 2);
 
    int a = 0;
    for (int i = 0; i < 63-7; i+=7) {
      ints.add((long) ((0x7E << i) | a));
      ints.add((long) ((0x7F << i) | a));
      ints.add((long) ((0x80 << i) | a));
      ints.add((long) ((0x81 << i) | a));
      a <<= 7;
      a |= 0x5D;
    }

    for (int i = 0; i < ints.size(); i++) {
      internalTestLong(ints.get(i));
      internalTestLong(-ints.get(i));
    }
    
    internalTestLong(Long.MAX_VALUE);
    internalTestLong(Long.MIN_VALUE);
  }
  
  private void internalTestLong(long v) throws BException {
    BBuffer bbuf = BBufferBin.create(TestUtils.protocol, null);
    bbuf.putLong(v);
    bbuf.flip();
    long r = bbuf.getLong();
    TestUtils.assertEquals(log, "longVal", v, r);
  }

	@Test
	public void testPrimitiveTypesFloat() throws BException {	
		log.info("testPrimitiveTypesFloat(");
		float[] vals = new float[] {0.0f, 1.0f, 1.2f, 0.2e2f, -1.0f, -1.2f, -0.2e2f, 1.0e-2f};
		for (int i = 0; i < vals.length; i++) {
			internalTestFloat(vals[i]);
		}
		log.info(")testPrimitiveTypesFloat");
	}

	private void internalTestFloat(float v) throws BException {
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.floatVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "floatVal", obj.floatVal, objR.floatVal);
	}

	@Test
	public void testPrimitiveTypesDouble() throws BException {	
		log.info("testPrimitiveTypesDouble(");
		double[] vals = new double[] {0.0, 1.0, 1.2, 0.2e2, -1.0, -1.2, -0.2e2, 1.0e-2 };
		for (int i = 0; i < vals.length; i++) {
			internalTestDouble(vals[i]);
		}
		log.info(")testPrimitiveTypesDouble");
	}

	private void internalTestDouble(double v) throws BException {
		BOutput bout = transport.getOutput();
		
		PrimitiveTypes obj = new PrimitiveTypes();
		obj.doubleVal = v;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "doubleVal", obj.doubleVal, objR.doubleVal);
	}
	
	@Test
	public void testPrimitiveTypesReferenceToOtherObject() throws BException {	
		log.info("testPrimitiveTypesReferenceToOtherObject(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = new PrimitiveTypes();
		((PrimitiveTypes)obj1.objVal).intVal = 456;
		
		PrimitiveTypes objR = internalTestPrimitiveTypes(obj1);
		TestUtils.assertTrue(log, "this.objVal != this.objVal2", objR.objVal == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToOtherObject");
	}
	
	@Test
	public void testPrimitiveTypesReferenceToSelf() throws BException {	
		log.info("testPrimitiveTypesReferenceToSelf(");

		PrimitiveTypes obj1 = new PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = obj1;
		
		PrimitiveTypes objR = internalTestPrimitiveTypes(obj1);
		TestUtils.assertTrue(log, "this != this.objVal", objR == objR.objVal);
		TestUtils.assertTrue(log, "this != this.objVal2", objR == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToSelf");
	}

  @Test
  public void testPrimitiveTypesDate() throws BException, ParseException {
    log.info("testPrimitiveTypesDate(");
    
    internalTestDate("1970-01-01 00:00:00,000");
    internalTestDate("1970-01-01 00:00:00,999");
    internalTestDate("1970-01-01 00:00:59,999");
    internalTestDate("1970-01-01 11:59:59,999");
    internalTestDate("1970-01-01 12:00:00,000");
    internalTestDate("1970-01-01 23:59:59,999");
    internalTestDate("1970-01-31 00:00:00,000");
    internalTestDate("1970-12-31 00:00:00,000");
    internalTestDate("1900-01-01 00:00:00,000");
    internalTestDate("3000-01-01 00:00:00,000");
    internalTestDate("1582-01-01 00:00:00,000"); // Gregorian calendar starts at 1582
    internalTestDate(null);

    log.info(")testPrimitiveTypesDate");
  }

  protected void internalTestDate(String sdate) throws BException, ParseException {
    
    PrimitiveTypes obj1 = new PrimitiveTypes();
    
    if (sdate != null) {
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS"); 
      fmt.setTimeZone(TimeZone.getTimeZone("UTC"));
      obj1.dateVal = fmt.parse(sdate);
    }
    
    PrimitiveTypes objR = internalTestPrimitiveTypes(obj1);
    TestUtils.assertEquals(log, "dateVal", obj1.dateVal, objR.dateVal);
  }

	
	@Test
	public void testSerializeDouble() throws BException {
		log.info("testSerializeDouble(");
		internalTestSerializeDouble(Double.NaN); 
		internalTestSerializeDouble(Double.NEGATIVE_INFINITY); 
		internalTestSerializeDouble(Double.POSITIVE_INFINITY); 
		internalTestSerializeDouble(0.0); 
		internalTestSerializeDouble(1.0);
		internalTestSerializeDouble(-1.0);
		internalTestSerializeDouble(1.0e7);
		internalTestSerializeDouble(1.0e-7);
		internalTestSerializeDouble(2.0E5);
		log.info(")testSerializeDouble");
	}
	
	private void internalTestSerializeDouble(double v) throws BException {
		log.info("internalTestSerializeDouble(" + v);
		ByteBuffer buf = ByteBuffer.allocate(1000);
		BBuffer bbuf = BBuffer.create(BBinaryModel.MEDIUM, buf);
		bbuf.putDouble(v);
		bbuf.flip();
		TestUtils.printBuffer(log, buf);
		double vR = bbuf.getDouble();
		TestUtils.assertEquals(log, "double", v, vR);
		log.info(")internalTestSerializeDouble");
	}
	
	@Test
	public void testSerializeFloat() throws BException {
		log.info("testSerializeFloat(");
		internalTestSerializeFloat(Float.NaN); 
		internalTestSerializeFloat(Float.NEGATIVE_INFINITY); 
		internalTestSerializeFloat(Float.POSITIVE_INFINITY); 
		internalTestSerializeFloat(0.0f); 
		internalTestSerializeFloat(1.0f);
		internalTestSerializeFloat(-1.0f);
		internalTestSerializeFloat(1.0e7f);
		internalTestSerializeFloat(1.0e-7f);
		internalTestSerializeFloat(2.0E5f);
		log.info(")testSerializeFloat");
	}
	
	private void internalTestSerializeFloat(float v) throws BException {
		log.info("internalTestSerializeFloat(" + v);
		ByteBuffer buf = ByteBuffer.allocate(1000);
		BBuffer bbuf = BBuffer.create(BBinaryModel.MEDIUM, buf);
		bbuf.putFloat(v);
		bbuf.flip();
		TestUtils.printBuffer(log, buf);
		float vR = bbuf.getFloat();
		TestUtils.assertEquals(log, "float", v, vR);
		log.info(")internalTestSerializeFloat");
	}
	
	private PrimitiveTypes internalTestPrimitiveTypes(PrimitiveTypes obj) throws BException {
		log.info("internalTestPrimitiveTypes(");
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		PrimitiveTypes objR = (PrimitiveTypes)bin.load();
		TestUtils.assertEquals(log, "obj", obj, objR);
		
		log.info(")internalTestPrimitiveTypes");
		return objR;
	}


	
	/**
	 * This function measures the binary and JSON serialisation with and without data compression.
	 * It runs about 5min. 
	 * 
07:16:24,564 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=0, #objs=     1, #loops=100000, ser-ms=   577/   296/   281, #kb-per-message=0,15, #kb-total=15100,00
07:16:27,435 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=1, #objs=     1, #loops=100000, ser-ms=  2871/  2028/   843, #kb-per-message=0,10, #kb-total=9600,00
07:16:30,055 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=0, #objs=     1, #loops=100000, ser-ms=  2620/  1123/  1497, #kb-per-message=0,43, #kb-total=43000,00
07:16:35,391 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=1, #objs=     1, #loops=100000, ser-ms=  5336/  3042/  2294, #kb-per-message=0,25, #kb-total=25100,00
07:16:35,391 main   INFO  (TestSerializePrimitiveTypes.java:473) - 
07:16:35,859 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=0, #objs=    10, #loops=100000, ser-ms=   468/   234/   234, #kb-per-message=0,57, #kb-total=57400,00
07:16:41,927 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=1, #objs=    10, #loops=100000, ser-ms=  6068/  4711/  1357, #kb-per-message=0,33, #kb-total=33100,00
07:16:49,228 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=0, #objs=    10, #loops=100000, ser-ms=  7301/  2902/  4399, #kb-per-message=2,04, #kb-total=204400,00
07:17:02,769 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=1, #objs=    10, #loops=100000, ser-ms= 13541/  7503/  6038, #kb-per-message=0,49, #kb-total=49400,00
07:17:02,769 main   INFO  (TestSerializePrimitiveTypes.java:473) - 
07:17:06,809 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=0, #objs=   100, #loops=100000, ser-ms=  4040/  2028/  2012, #kb-per-message=4,80, #kb-total=480400,00
07:17:42,580 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=ME, gzip=1, #objs=   100, #loops=100000, ser-ms= 35771/ 30077/  5694, #kb-per-message=2,09, #kb-total=209300,00
07:18:49,738 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=0, #objs=   100, #loops=100000, ser-ms= 67158/ 26286/ 40872, #kb-per-message=18,28, #kb-total=1828000,00
07:20:40,420 main   INFO  (TestSerializePrimitiveTypes.java:549) - bmodel=JS, gzip=1, #objs=   100, #loops=100000, ser-ms=110682/ 61948/ 48734, #kb-per-message=2,64, #kb-total=263600,00
	 * @throws IOException 
	 */
	//@Test
	public void testPerformancePrimitiveTypes() throws IOException {
		log.info("testPerformancePrimitiveTypes(");
		BBinaryModel protocol = TestUtils.protocol;
		try {
			//int maxLoop = 10000;
			//for (int loopCount = 10000; loopCount <= maxLoop; loopCount *= 10) {
				for (int objCount = 1; objCount <= 100; objCount *= 10) {
					for (int mod = 0; mod < 2; mod++) {
						for (int gzip = 0; gzip < 2; gzip++) {
							BBinaryModel bmodel = mod == 0 ? BBinaryModel.MEDIUM : BBinaryModel.JSON;
							int loopCount = 100 * 1000;
							int flags = gzip != 0 ? BWire.FLAG_GZIP : BWire.FLAG_DEFAULT;
							internaltestPerformancePrimitiveTypes(protocol, objCount, loopCount, flags);
						}
					}
					log.info("");
				}
			//}
			
		}
		finally {
			TestUtils.protocol = protocol;
		}
		
		log.info(")testPerformancePrimitiveTypes");
	}
	
	public void internaltestPerformancePrimitiveTypes(BBinaryModel protocol, int objCount, int loopCount, int flags) throws IOException {
		
		TestUtils.protocol = protocol;
		
		BTransport transport = TestUtils.createTransport(flags, 0);
		
		BOutput bout = transport.getOutput();
		long bytesCount = 0;
		ByteBuffer buf = null;
		
		ListTypes obj = new ListTypes();
		obj.primitiveTypes1 = new ArrayList<PrimitiveTypes>();
		for (int i = 0; i < objCount; i++) {
			PrimitiveTypes item = TestUtils.createObjectPrimitiveTypes();
			obj.primitiveTypes1.add(item);
		}

		long t1 = System.currentTimeMillis();
		ByteArrayOutputStream os = null;
		for (int i = 0; i < loopCount; i++) {
			bout.store(obj);
			buf = bout.toByteBuffer();
			os = new ByteArrayOutputStream();
			transport.wire.bufferToStream(buf, os);
		}
		long t2 = System.currentTimeMillis();
		bytesCount = (long)loopCount * buf.remaining();
		
		//TestUtils.printBuffer(log, buf);
	
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < loopCount; i++) {
			ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
			buf = BWire.bufferFromStream(is);
			BInput bin = transport.getInput(null, buf);
			Object objR = bin.load();
			if (i == 0) {
				TestUtils.assertEquals(null, "obj", obj, objR);
			}
			
			buf.flip();
		}
		long t4 = System.currentTimeMillis();
		
		log.info("bmodel=" + protocol.toString().substring(0,2) +
				", gzip=" + ((flags & BWire.FLAG_GZIP) != 0) + 
				", #objs=" + String.format("%6d", objCount) + 
				", #loops=" + String.format("%6d", loopCount) + 
				", ser-ms=" + String.format("%6d", (t2-t1) + (t4-t3)) + 
				"/" + String.format("%6d", (t2-t1)) + 
				"/" + String.format("%6d", (t4-t3)) +
				", #kb-per-message=" + String.format("%4.2f", (double)os.size()/1000) + 
				", #kb-total=" + String.format("%4.2f", (double)bytesCount/1000));
				
	}


}
