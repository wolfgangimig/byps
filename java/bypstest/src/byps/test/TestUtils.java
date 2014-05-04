package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BAsyncResult;
import byps.BBinaryModel;
import byps.BBuffer;
import byps.BClient;
import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BProtocol;
import byps.BProtocolJson;
import byps.BProtocolS;
import byps.BTargetId;
import byps.BTransport;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BRegistry_Testser;
import byps.test.api.JRegistry_Testser;
import byps.test.api.inl.Actor;
import byps.test.api.inl.Matrix2D;
import byps.test.api.inl.Point2D;
import byps.test.api.prim.PrimitiveTypes;

public class TestUtils {

	private static Log log = LogFactory.getLog(TestUtils.class);
	//public static BBinaryModel protocol = BProtocolS.BINARY_MODEL;
	public static BBinaryModel protocol = BProtocolJson.BINARY_MODEL;
	public static boolean TEST_LARGE_STREAMS = true;
	
	public static BTransport createTransport() {
		return createTransport(BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, 0);
	}
	
	public static BTransport createTransport(int flags, int bypsVersion, long version) {
				
		BWire wire = new MyWire(flags);
		
		BApiDescriptor apiDesc = new BApiDescriptor("TestSerialize",
				BApiDescriptor_Testser.instance().basePackage, 
				version, 
				BApiDescriptor_Testser.instance().uniqueObjects);
		
		if (protocol == BProtocolJson.BINARY_MODEL) { 
			apiDesc.addRegistry(new JRegistry_Testser());
		}
		else {
			apiDesc.addRegistry(new BRegistry_Testser());
		}
		
		BProtocol proto = null;
		if (protocol == BProtocolJson.BINARY_MODEL) {
			proto = new BProtocolJson(apiDesc);
		}
		else {
			proto = new BProtocolS(apiDesc, bypsVersion, version, ByteOrder.LITTLE_ENDIAN);
		}
		
		BTransport transport = new BTransport(apiDesc, wire, null);
		transport.setProtocol(proto);
	
		return transport;
	}
	
	private static class MyWire extends BWire {
		private HashMap<Long, HashMap<Long, ByteBuffer> > mapStreams = new HashMap<Long, HashMap<Long, ByteBuffer>>();
		
		
		
		public MyWire(int flags) {
			super(flags);
		}
		
		@Override
		public void putStreams(List<BContentStream> streamRequests, BAsyncResult<BMessage> asyncResult) {
			if (streamRequests == null) return;
			
			for (BContentStream streamRequest : streamRequests) {
				ByteBuffer buf;
				try {
					buf = bufferFromStream(streamRequest);
					HashMap<Long, ByteBuffer> map = mapStreams.get(streamRequest.getTargetId().getMessageId());
					if (map == null) {
						map = new HashMap<Long, ByteBuffer>();
						mapStreams.put(streamRequest.getTargetId().getMessageId(), map);
					}
					map.put(streamRequest.getTargetId().getMessageId(), buf);
				} catch (IOException e) {
					asyncResult.setAsyncResult(null, e);
					break;
				}
			}
		}

		@Override
		public BContentStream getStream(BTargetId targetId)
				throws IOException {
			HashMap<Long, ByteBuffer> map = mapStreams.get(targetId.getMessageId());
			if (map == null) throw new IOException("Stream not found.");
			ByteBuffer buf = map.get(targetId.getStreamId());
			if (buf == null) throw new IOException("Stream not found.");
			return new BContentStreamWrapper(
					new ByteArrayInputStream(buf.array(), buf.position(), buf.remaining()),
					"application/octet-stream",
					buf.remaining());
		}
	}

	public static String bufferToString(ByteBuffer buf) {
		try {
			boolean isString = true;
			byte[] arr = buf.array();
			for (int i = 0; i < buf.remaining(); i++) {
				byte c = arr[i];
				if (c <= 127 || ((c & 0xC0) == 0x80) || ((c & 0xE0) == 0xC0)) continue;
				isString = false;
				break;
			}
			if (isString) {
				return new String(buf.array(), 0, buf.remaining(), "UTF-8");
			}
			else {
				StringBuilder sbuf = new StringBuilder();
				sbuf.append("byte[] bytes = new byte[] {");
				for (int i = 0; i < buf.remaining(); i++) {
					if (i != 0) sbuf.append(", ");
					if ((i % 10) == 0) sbuf.append("\r\n");
					sbuf.append("(byte)0x");
					int c = arr[i] & 0xFF;
					String s = Integer.toHexString(c);
					if (s.length() < 2) sbuf.append("0");
					sbuf.append(s);
				}
				sbuf.append("};");
				return sbuf.toString();
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static void printBuffer(Log log, BBuffer buf) {
		log.info("buffer: \r\n" + buf.toDetailString());
	}
	
	public static void printBuffer(Log log, ByteBuffer buf) {
		BBuffer bbuf = BBuffer.create(BBinaryModel.MEDIUM, buf);
		printBuffer(log, bbuf);
	}
	
	public static void assertEquals(Log log, String msg, Object a, Object b) {
		internalAssertEquals(log, msg, a, b, new HashSet<Object>());
	}
	
  public static void assertEqualDates(Log log, String msg, Date a, Date b) {
    if (a == null) a = new Date(0);
    internalAssertEquals(log, msg, a, b, new HashSet<Object>());
  }

	public static void assertTrue(Log log, String msg, boolean val) {
		if (!val) {
			log.error(msg);
			throw new AssertionError(msg);
		}
	}
	
	public static void fail(Log log, String msg) {
		log.error(msg);
		throw new AssertionError(msg);
	}
	
	@SuppressWarnings("rawtypes")
	public static void internalAssertEquals(Log log, String msg, Object a, Object b, Set<Object> alreadyCheckedObjs) {
		if (a != null) {
			if (alreadyCheckedObjs.contains(a)) return;
			alreadyCheckedObjs.add(a);
		}
		
		if (b instanceof Date) {
		  if (a == null) {
		    a = new Date(0);
		  }
		}
		
		try {
			if (a != b) {
				if (a == null && b != null) {
					if (!(b instanceof String)) {
						throw new AssertionError(msg + " a is null <> b is {" + b + "}");
					}
				}
				else if (a != null && b == null) {
					if (!(a instanceof String)) {
						throw new AssertionError(msg + " a is {" + a + "} <> b is null");
					}
				}
				else if (a instanceof boolean[]) {
					boolean[] x = (boolean[])a;
					boolean[] y = (boolean[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof byte[]) {
					byte[] x = (byte[])a;
					byte[] y = (byte[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof char[]) {
					char[] x = (char[])a;
					char[] y = (char[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof short[]) {
					short[] x = (short[])a;
					short[] y = (short[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof int[]) {
					int[] x = (int[])a;
					int[] y = (int[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof long[]) {
					long[] x = (long[])a;
					long[] y = (long[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof float[]) {
					float[] x = (float[])a;
					float[] y = (float[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof double[]) {
					double[] x = (double[])a;
					double[] y = (double[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof String[]) {
					String[] x = (String[])a;
					String[] y = (String[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof Object[]) {
					Object[] x = (Object[])a;
					Object[] y = (Object[])b;
					if (x.length != y.length) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.length; i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
					}
				}
				else if (a instanceof List) {
					List x = (List)a;
					List y = (List)b;
					if (x.size() != y.size()) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					for (int i = 0; i < x.size(); i++) {
						internalAssertEquals(log, msg + "[" + i + "]", x.get(i), y.get(i), alreadyCheckedObjs);
					}
				}
				else if (a instanceof Set) {
					Set x = (Set)a;
					Set y = (Set)b;
					if (x.size() != y.size()) {
						throw new AssertionError(msg + "a[].length != b[].length");
					}
					
					for (Iterator i = x.iterator(); i.hasNext(); ) {
						Object v = i.next();
						if (y.contains(v)) continue;
						
						if (v.getClass() == PrimitiveTypes.class) { 
							boolean found = false;
							for (Iterator j = y.iterator(); j.hasNext(); ) {
								found = compare((PrimitiveTypes)v, (PrimitiveTypes)j.next());
								if (found) break;
							}
							Assert.assertTrue(msg + "[" + v + "] is missing", found);
							continue;
						}

						if (v.getClass() == Actor.class) { 
							boolean found = false;
							for (Iterator j = y.iterator(); j.hasNext(); ) {
								found = compare((Actor)v, (Actor)j.next());
								if (found) break;
							}
							Assert.assertTrue(msg + "[" + v + "] is missing", found);
							continue;
						}
						
						Assert.assertTrue(msg + "[" + v + "] is missing", y.contains(v));
					}
				}
				else if (a instanceof Map) {
					Map x = (Map)a;
					Map y = (Map)b;
					if (x.size() != y.size()) {
						throw new AssertionError(msg + " a[].length != b[].length");
					}
					for (Iterator i = x.keySet().iterator(); i.hasNext(); ) {
						Object k = i.next();
						internalAssertEquals(log, msg + "[" + k + "]", x.get(k), y.get(k), alreadyCheckedObjs);
					}
				}
				else if (a instanceof InputStream) {
					// geht nicht, stream a wurde in BWire.putStream geschlossen
				}
				else if (a instanceof ByteBuffer) {
					ByteBuffer x = (ByteBuffer)a;
					ByteBuffer y = (ByteBuffer)b;
					Assert.assertEquals("ByteBuffer.remaining", x.remaining(), y.remaining());
					for (int i = 0; i < x.remaining(); i++) {
						Assert.assertEquals("ByteBuffer.get(" +i + ")", x.get(), y.get());
					}
				}
				else {
					
					Class<?> classA = a.getClass();
					Class<?> classB = b.getClass();
					if (classA != classB) {
						throw new AssertionError("different class");
					}

					try {
						Class<?> clazz = classA;
						if (clazz == Boolean.class ||
							clazz == Byte.class ||
							clazz == Character.class ||
							clazz == Short.class ||
							clazz == Integer.class ||
							clazz == Long.class ||
							clazz == Float.class ||
							clazz == Double.class ||
							clazz == Date.class ||
							clazz == String.class) {
							Assert.assertEquals(msg, a, b);
						}
						else if (clazz == Date.class){
						  assertEqualDates(log, msg, (Date)a, (Date)b);
						}
						else if (clazz == PrimitiveTypes.class) {
							if (!compare((PrimitiveTypes)a, (PrimitiveTypes)b)) {
								throw new AssertionError("different objects");
							}
						}
						else if (clazz == Actor.class) {
							if (!compare((Actor)a, (Actor)b)) {
								throw new AssertionError("different objects");
							}
						}
						else {
							for (Field f : clazz.getDeclaredFields()) {
								f.setAccessible(true);
								internalAssertEquals(log, msg + "." + f.getName(), f.get(a), f.get(b), alreadyCheckedObjs);
							}
						}
					}
					catch (IllegalAccessException e) {
						throw new AssertionError(e);
					}
				}
			}
			
			String astr = a != null ? a.toString() : null;
			String bstr = b != null ? b.toString() : null;
			if (astr != null && astr.length() > 100) astr = astr.substring(0, 100);
			if (bstr != null && bstr.length() > 100) bstr = bstr.substring(0, 100);
			
			if (log != null) log.info("assertEquals: " + msg + ", a=" + astr + ", b=" + bstr + ", true");
		}
		catch (AssertionError e) {
			log.error("assertEquals: " + msg + ", a=" + a + ", b=" + b + ", false", e);
			throw e;
		}
	}
	
	private static int createCount = 1000;
	public static PrimitiveTypes createObjectPrimitiveTypes() {
		PrimitiveTypes p = new PrimitiveTypes();
		p.intVal = ++createCount;
		p.boolVal = (createCount & 1) != 0;
		p.byteVal = (byte)createCount;
		p.shortVal = (short)(createCount * 31);
		p.longVal = createCount * 129;
		p.floatVal = ((float)createCount) / 0.3f;
		p.doubleVal = (double)createCount / 7;
		p.stringVal = Integer.toString(p.intVal);
		return p;
	}

	private static boolean compare(PrimitiveTypes lhs, PrimitiveTypes rhs) {
		if (lhs == rhs)
			return true;
		if (rhs == null)
			return false;
		if (lhs.boolVal != rhs.boolVal)
			return false;
		if (lhs.byteVal != rhs.byteVal)
			return false;
		if (lhs.charVal != rhs.charVal)
			return false;
		if (Double.doubleToLongBits(lhs.doubleVal) != Double
				.doubleToLongBits(rhs.doubleVal))
			return false;
		if (Float.floatToIntBits(lhs.floatVal) != Float
				.floatToIntBits(rhs.floatVal))
			return false;
		if (lhs.intVal != rhs.intVal)
			return false;
		if (lhs.longVal != rhs.longVal)
			return false;
		if (lhs.shortVal != rhs.shortVal)
			return false;
		if (!(lhs.stringVal != null ? lhs.stringVal : "").equals(rhs.stringVal != null ? rhs.stringVal : ""))
			return false;
		return true;
	}

	private static boolean compare(Point2D lhs, Point2D rhs) {
		if (lhs == rhs)
			return true;
		if (rhs == null)
			return false;
		if (lhs.getClass() != rhs.getClass())
			return false;
		Point2D other = (Point2D) rhs;
		if (lhs.x != other.x)
			return false;
		if (rhs.y != other.y)
			return false;
		return true;
	}	
	
	private static boolean compare(Matrix2D lhs, Matrix2D rhs) {
		if (lhs == rhs)
			return true;
		if (rhs == null)
			return false;
		if (lhs.getClass() != rhs.getClass())
			return false;
		Matrix2D other = (Matrix2D) rhs;
		if (Float.floatToIntBits(lhs._11) != Float.floatToIntBits(other._11))
			return false;
		if (Float.floatToIntBits(lhs._12) != Float.floatToIntBits(other._12))
			return false;
		if (Float.floatToIntBits(lhs._13) != Float.floatToIntBits(other._13))
			return false;
		if (Float.floatToIntBits(lhs._21) != Float.floatToIntBits(other._21))
			return false;
		if (Float.floatToIntBits(lhs._22) != Float.floatToIntBits(other._22))
			return false;
		if (Float.floatToIntBits(lhs._23) != Float.floatToIntBits(other._23))
			return false;
		if (Float.floatToIntBits(lhs._31) != Float.floatToIntBits(other._31))
			return false;
		if (Float.floatToIntBits(lhs._32) != Float.floatToIntBits(other._32))
			return false;
		if (Float.floatToIntBits(lhs._33) != Float.floatToIntBits(other._33))
			return false;
		return true;
	}	

	private static boolean compare(Actor lhs, Actor rhs) {
		if (lhs == rhs)
			return true;
		if (rhs == null)
			return false;
		if (lhs.getClass() != rhs.getClass())
			return false;
		Actor other = (Actor) rhs;
		if (lhs.position == null) {
			if (other.position != null)
				return false;
		} else if (!compare(lhs.position, other.position))
			return false;
		if (lhs.shape == null && other.shape != null) return false; 
		if (lhs.shape != null && other.shape == null) return false; 
		if (lhs.shape == null && other.shape == null) return true;
		if (lhs.shape.length != other.shape.length) return false;
		for (int i = 0; i < lhs.shape.length; i++) {
			if (!compare(lhs.shape[i], rhs.shape[i])) return false;
		}
		return true;
	}	

	public static File createTestFile(long nbOfBytes) throws IOException {
		log.info("createTestFile(" + nbOfBytes);
		File file = File.createTempFile("bypstest", "tmp");
		FileOutputStream fos = new FileOutputStream(file);
		try {
			byte[] buf = new byte[(int)Math.min(1000 * 1000, nbOfBytes)];
			for (int i = 0; i < buf.length; i++) {
				buf[i] = (byte)(i+1);
			}
			long sum = 0;
			while (sum < nbOfBytes) {
				int n = Math.min(buf.length, (int)(nbOfBytes-sum));
				fos.write(buf, 0, n);
				sum += n;
			}
		}
		finally {
			fos.close();
		}
		log.info(")createTestFile=" + file);
		return file;
	}

	public static ArrayList<InputStream> openTestFiles(ArrayList<File> files) throws FileNotFoundException {
		ArrayList<InputStream> arr = new ArrayList<InputStream>(files.size());
		for (int i = 0; i < files.size(); i++) {
			arr.add(new FileInputStream(files.get(i)));
		}
		return arr;
	}
	
	public static class MyContentStream extends BContentStream {
		private long pos;
		private final long nbOfBytes;
		private final boolean chunked;
		
		public MyContentStream(long nbOfBytes, boolean chunked) {
			this.nbOfBytes = nbOfBytes;
			this.chunked = chunked;
			
			super.fileName = "file-" + nbOfBytes + ".txt";
			super.attachment = nbOfBytes > 10000;
			
			super.contentType = "application/byps-" + nbOfBytes;
			super.contentLength  =chunked ? -1L : nbOfBytes;
		}

		@Override
		public int read() throws IOException {
			if (nbOfBytes == pos) {
				return -1;
			}
			else {
				int ret = (int)(pos++ & 0xFF);
				if ((ret % 5) == 0) ret = 0; 
				return ret;
			}
		}
	}

	public static void assertEquals(Log log, String msg, InputStream estrm, InputStream rstrm) throws IOException {
		if (estrm instanceof BContentStream) {
			BContentStream ecs = (BContentStream)estrm;
			if (rstrm instanceof BContentStream) {
				BContentStream rcs = (BContentStream)rstrm;
				assertEquals(log, msg + ".contentType", ecs.getContentType(), rcs.getContentType());
				assertEquals(log, msg + ".contentDisposition", ecs.getContentDisposition(), rcs.getContentDisposition());
				if (ecs.getContentLength() != -1) {
					assertEquals(log, msg + ".contentLength", ecs.getContentLength(), rcs.getContentLength());
				}
			}
		}
		
        byte[] ebuf = new byte[10 * 1000];
	    byte[] rbuf = new byte[10 * 1000];
        int n = 0, p = 0;
        do
        {
            n = estrm.read(ebuf, 0, ebuf.length);

            if (n < 0)
            {
                int n2 = rstrm.read(rbuf, 0, rbuf.length);
                TestUtils.assertEquals(log, msg + ". expected end of stream, p=" + p, n, n2);
                break;
            }
            else
            {
                int n2 = 0;
                while (n2 < n)
                {
                    int n3 = rstrm.read(rbuf, n2, n - n2);
                    TestUtils.assertTrue(log, msg + ". Unexpected end of stream", n3 > 0);
                    n2 += n3;
                }

                for (int i = 0; i < n; i++)
                {
                    byte e = ebuf[i];
                    byte r = rbuf[i];
                    if (e != r)
                    {
                        TestUtils.assertEquals(log, msg + ". stream byte, p=" + p, e, r);
                    }
                    p++;
                }
            }
        } while (n != 0);

		for (int i = 0; i < 3; i++) {
			int r = rstrm.read();
			TestUtils.assertEquals(log, "stream end", -1, r);
		}
	}

	public static void checkTempDirEmpty(BClient client) throws RemoteException {
		log.info("check temp dir is empty");
		String[] tempFiles = client.getTransport().getWire().getTestAdapter().getServerTempFiles();
		TestUtils.assertEquals(log, "temp files", new String[0], tempFiles);
	}

	private static short x;
	public static Point2D createPoint2D() {
		Point2D pt = new Point2D();
		pt.x = x++;
		pt.y = (short)(x*x);
		return pt;
	}

}


/*
 * Test gegen Crockfords code.
 * Ist mir aber zu Aufwendig.
 * 
 * 	public static void checkValidJsonString(Log log, ByteBuffer buf) {
		if (TestUtils.bmodel == BBinaryModel.JSON) {
			buf.position(0);
			try {
				StringBuilder sbuf = new StringBuilder();
				sbuf.append("{\"text\":");
				sbuf.append(new String(buf.array(), buf.position(), buf.limit(), "UTF-8"));
				sbuf.append("}");
				internalCheckJsonObject(log, sbuf.toString());
			}
			catch (UnsupportedEncodingException e) { Assert.fail(); }
		}
	}

	public static void checkValidJsonObject(Log log, ByteBuffer buf) {
		if (TestUtils.bmodel == BBinaryModel.JSON) {
			buf.position(0);
			try {
				String istr = new String(buf.array(), buf.position(), buf.limit(), "UTF-8");
				internalCheckJsonObject(log, istr);
			}
			catch (UnsupportedEncodingException e) { Assert.fail(); }
		}
	}

	public static void checkValidJsonArray(Log log, ByteBuffer buf) {
		if (TestUtils.bmodel == BBinaryModel.JSON) {
			buf.position(0);
			try {
				String istr = new String(buf.array(), buf.position(), buf.limit(), "UTF-8");
				internalCheckJsonArray(log, istr);
			}
			catch (UnsupportedEncodingException e) { Assert.fail(); }
		}
	}


	@SuppressWarnings("rawtypes")
	protected static void internalCheckJsonObject(Log log, String istr) {
		try {
			
			// Let istr parse from Crockford
			log.info("JSONObject(" + istr.substring(0, Math.min(100, istr.length())));
			JSONObject js = new JSONObject(istr);
			String jstr = js.toString();
			log.info(")JSONObject=" + jstr.substring(0, Math.min(100, jstr.length())));
			
			BBufferJson bbuf = new BBufferJson(ByteBuffer.wrap(istr.getBytes("UTF-8")));
			BJsonObject my = bbuf.parseJsonObject();
			
			Set<String> jsKeys = new HashSet<String>();
			for (Iterator i = js.keys(); i.hasNext(); ) jsKeys.add((String)i.next());
			
			TestUtils.assertEquals(log, "json object keys", my.keys(), jsKeys);
			for (String k : my.keys()) {
				Object myElm = my.get(k);
				Object jsElm = js.get(k);
				// das ist mir doch zu Aufwendig ...
			}
			
			TestUtils.assertEquals(log, "JSON", istr, jstr);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}

	protected static void internalCheckJsonArray(Log log, String istr) {
		try {
			log.info("JSONArray(" + istr.substring(0, Math.min(100, istr.length())));
			JSONArray js = new JSONArray(istr);
			String jstr = js.toString();
			log.info(")JSONArray=" + jstr.substring(0, Math.min(100, jstr.length())));
			TestUtils.assertEquals(log, "JSON", istr, jstr);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}


*/