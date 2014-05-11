/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using byps;
using byps.test.api;
using byps.test.api.prim;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Reflection;
using byps.test.api.inl;

namespace bypstest
{
    public class TestUtils
    {
        public static BBinaryModel bmodel = BBinaryModel.MEDIUM;

        public static bool TEST_LARGE_STREAMS = false;

        public static BTransport createTransport()
        {

            BRegistry registryBin = new BRegistry_Testser();

            BWire wire = new MyWire();

            BApiDescriptor apiDesc = new BApiDescriptor("TestSerialize",
                    "com.wilutions.byps.test.api",
                    0,
                    false);


            BProtocol proto = new BProtocolS(apiDesc, 1, 0, ByteOrder.LITTLE_ENDIAN);

            BTransport transport = new BTransport(apiDesc, wire, null);
            transport.setProtocol(proto);

            return transport;
        }

        private class MyWire : BWire
        {
            private Dictionary<long, Dictionary<long, ByteBuffer>> mapStreams = new Dictionary<long, Dictionary<long, ByteBuffer>>();

            public MyWire()
                : base(BWireFlags.DEFAULT)
            {
            }

            public override void putStreams(List<BContentStream> streams, BAsyncResultIF<BMessage> asyncResult)
            {
                if (streams == null) return;

                foreach (BContentStream stream in streams)
                {
				    ByteBuffer buf;
				    try {
                        buf = bufferFromStream(stream, false);
                        Dictionary<long, ByteBuffer> map = null;
                        if (mapStreams.TryGetValue(stream.TargetId.getMessageId(), out map)) 
                        {
                            map = new Dictionary<long, ByteBuffer>();
                            mapStreams[stream.TargetId.getMessageId()] = map;
					    }
                        map[stream.TargetId.getStreamId()] = buf;
				    } catch (IOException e) {
					    asyncResult.setAsyncResult(null, e);
					    break;
				    }
			    }
            }

            public override BContentStream getStream(BTargetId targetId)
            {
                Dictionary<long, ByteBuffer> map = null;
                if (!mapStreams.TryGetValue(targetId.getMessageId(), out map)) throw new IOException("Stream not found.");
                ByteBuffer buf = null;
                if (!map.TryGetValue(targetId.getStreamId(), out buf)) throw new IOException("Stream not found.");
                return new BContentStreamWrapper(new MemoryStream(buf.array(), buf.position(), buf.remaining()));
            }
        }


        private static int createCount = 1000;
        public static PrimitiveTypes createObjectPrimitiveTypes()
        {
            PrimitiveTypes p = internalCreateObjectPrimitiveTypes(true);
            return p;
        }

        private static PrimitiveTypes internalCreateObjectPrimitiveTypes(bool inclObjVal)
        {
            PrimitiveTypes p = new PrimitiveTypes();
            p.BoolVal = (createCount & 1) != 0;
            p.IntVal = ++createCount * (p.BoolVal ? -1 : 1);
            p.ByteVal = (byte)createCount;
            p.ShortVal = (short)((createCount * 31) * (p.BoolVal ? -1 : 1));
            p.LongVal = createCount * 129 * (p.BoolVal ? -1 : 1);
            p.FloatVal = ((float)createCount) * 3 * (p.BoolVal ? -1 : 1);
            p.DoubleVal = (double)createCount * 7 * (p.BoolVal ? -1 : 1);
            p.StringVal = Convert.ToString(p.IntVal);
            if (inclObjVal)
            {
                p.ObjVal = internalCreateObjectPrimitiveTypes(false);
            }
            p.ObjVal2 = p;
            return p;
        }

        public static void fail(Log log, String msg)
        {
            throw new AssertFailedException(msg);
        }

        public static void assertEquals(Log log, String msg, Object a, Object b)
        {
            internalAssertEquals(log, msg, a, b, new HashSet<Object>());
        }

        public static void internalAssertEquals(Log log, String msg, Object a, Object b, ISet<Object> alreadyCheckedObjs)
        {
            if (a != null)
            {
                if (alreadyCheckedObjs.Contains(a)) return;
                alreadyCheckedObjs.Add(a);
            }

            try
            {
                if (a != b)
                {
                    if (a == null && b != null)
                    {
                        throw new AssertFailedException(msg + " a is null");
                    }
                    if (a != null && b == null)
                    {
                        throw new AssertFailedException(msg + " b is null");
                    }

                    if (a is bool[])
                    {
                        bool[] x = (bool[])a;
                        bool[] y = (bool[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + " a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is byte[])
                    {
                        byte[] x = (byte[])a;
                        byte[] y = (byte[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + " a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is char[])
                    {
                        char[] x = (char[])a;
                        char[] y = (char[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + " a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is short[])
                    {
                        short[] x = (short[])a;
                        short[] y = (short[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + " a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is int[])
                    {
                        int[] x = (int[])a;
                        int[] y = (int[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is long[])
                    {
                        long[] x = (long[])a;
                        long[] y = (long[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is float[])
                    {
                        float[] x = (float[])a;
                        float[] y = (float[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is double[])
                    {
                        double[] x = (double[])a;
                        double[] y = (double[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is String[])
                    {
                        String[] x = (String[])a;
                        String[] y = (String[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is Object[])
                    {
                        Object[] x = (Object[])a;
                        Object[] y = (Object[])b;
                        if (x.Length != y.Length)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Length; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is Object[,,,])
                    {
                        Object[,,,] x = (Object[,,,])a;
                        Object[,,,] y = (Object[,,,])b;
                        if (x.GetLength(0) != y.GetLength(0)) throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        if (x.GetLength(1) != y.GetLength(1)) throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        if (x.GetLength(2) != y.GetLength(2)) throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        if (x.GetLength(3) != y.GetLength(3)) throw new AssertFailedException(msg + "a[].Length != b[].Length");

                        for (int i3 = 0; i3 < x.GetLength(0); i3++)
                            for (int i2 = 0; i2 < x.GetLength(0); i2++)
                                for (int i1 = 0; i1 < x.GetLength(0); i1++)
                                    for (int i0 = 0; i0 < x.GetLength(0); i0++)
                                    {
                                       internalAssertEquals(log, msg + "[" + i3 + "," + i2 + "," + i1 + "," + i0 + "]", 
                                           x[i3,i2,i1,i0], y[i3,i2,i1,i0], alreadyCheckedObjs);
                                    }
                    }
                    else if (a is IList<Object>)
                    {
                        IList<Object> x = (IList<Object>)a;
                        IList<Object> y = (IList<Object>)b;
                        if (x.Count != y.Count)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }
                        for (int i = 0; i < x.Count; i++)
                        {
                            internalAssertEquals(log, msg + "[" + i + "]", x[i], y[i], alreadyCheckedObjs);
                        }
                    }
                    else if (a is ISet<Object>)
                    {
                        ISet<Object> x = (ISet<Object>)a;
                        ISet<Object> y = (ISet<Object>)b;
                        if (x.Count != y.Count)
                        {
                            throw new AssertFailedException(msg + "a[].Length != b[].Length");
                        }

                        foreach (Object v in x)
                        {
                            if (y.Contains(v)) continue;

                            if (v.GetType() == typeof(PrimitiveTypes))
                            {
                                bool found = false;
                                foreach (Object w in y)
                                {
                                    found = comparePrimitiveTypes((PrimitiveTypes)v, (PrimitiveTypes)w);
                                    if (found) break;
                                }
                                Assert.IsTrue(found, msg + "[" + v + "] is missing");
                                continue;
                            }

                            Assert.IsTrue(y.Contains(v), msg + "[" + v + "] is missing");
                        }
                    }
                    else if (a is IDictionary<Object, Object>)
                    {
                        IDictionary<Object, Object> x = (IDictionary<Object, Object>)a;
                        IDictionary<Object, Object> y = (IDictionary<Object, Object>)b;
                        if (x.Count != y.Count)
                        {
                            throw new AssertFailedException(msg + " a[].Length != b[].Length");
                        }
                        foreach (Object k in x.Keys)
                        {
                            internalAssertEquals(log, msg + "[" + k + "]", x[k], y[k], alreadyCheckedObjs);
                        }
                    }
                    else if (a is Stream)
                    {
                        // geht nicht, stream a wurde in BWire.putStream geschlossen
                    }
                    else if (a is ByteBuffer)
                    {
                        ByteBuffer x = (ByteBuffer)a;
                        ByteBuffer y = (ByteBuffer)b;
                        Assert.AreEqual(x.remaining(), y.remaining(), "ByteBuffer.remaining");
                        byte[] p = x.array();
                        byte[] q = y.array();
                        for (int i = 0; i < x.remaining(); i++)
                        {
                            Assert.AreEqual(p[x.position() + i], q[y.position() + i], "ByteBuffer.get(" + i + ")");
                        }
                    }
                    else
                    {

                        Type classA = a.GetType();
                        Type classB = b.GetType();

                        if (classA.Name.StartsWith("MyMap"))
                        {
                            classA = classA.BaseType;
                        }

                        Assert.AreEqual(classA, classB);

                        try
                        {
                            Type clazz = classA;
                            if (clazz == typeof(bool) ||
                                clazz == typeof(byte) ||
                                clazz == typeof(char) ||
                                clazz == typeof(short) ||
                                clazz == typeof(int) ||
                                clazz == typeof(long) ||
                                clazz == typeof(float) ||
                                clazz == typeof(double) ||
                                clazz == typeof(String))
                            {
                                Assert.AreEqual(a, b, msg);
                            }
                            else if (clazz == typeof(PrimitiveTypes))
                            {
                                Assert.IsTrue(
                                    comparePrimitiveTypes((PrimitiveTypes)a, (PrimitiveTypes)b),
                                    "Different objects");
                            }
                            else
                            {
                                foreach (FieldInfo f in clazz.GetFields(System.Reflection.BindingFlags.DeclaredOnly))
                                {
                                    internalAssertEquals(log, msg + "." + f.Name,
                                        f.GetValue(a), f.GetValue(b), alreadyCheckedObjs);
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            throw new AssertFailedException(e.ToString());
                        }
                    }
                }

                String astr = a != null ? a.ToString() : null;
                String bstr = b != null ? b.ToString() : null;
                if (astr != null && astr.Length > 100) astr = astr.Substring(0, 100);
                if (bstr != null && bstr.Length > 100) bstr = bstr.Substring(0, 100);

                if (log != null) log.info("assertEquals: " + msg + ", a=" + astr + ", b=" + bstr + ", true");
            }
            catch (AssertFailedException e)
            {
                log.error("assertEquals: " + msg + ", a=" + a + ", b=" + b + ", false", e);
                throw e;
            }
        }

        public static bool comparePrimitiveTypes(PrimitiveTypes lhs, PrimitiveTypes rhs)
        {
            if (lhs == rhs)
                return true;
            if (rhs == null)
                return false;
            if (lhs.BoolVal != rhs.BoolVal)
                return false;
            if (lhs.ByteVal != rhs.ByteVal)
                return false;
            if (lhs.CharVal != rhs.CharVal)
                return false;
            if (lhs.DoubleVal != rhs.DoubleVal)
                return false;
            if (lhs.FloatVal != rhs.FloatVal)
                return false;
            if (lhs.IntVal != rhs.IntVal)
                return false;
            if (lhs.LongVal != rhs.LongVal)
                return false;
            if (lhs.ShortVal != rhs.ShortVal)
                return false;
            if (!(lhs.StringVal != null ? lhs.StringVal : "").Equals(rhs.StringVal != null ? rhs.StringVal : ""))
                return false;
            return true;
        }


        public class MyContentStream : BContentStream {
		    private long pos, nbOfBytes;
		    private int v = 1;
		
		    public MyContentStream(long nbOfBytes) {
			    this.nbOfBytes = nbOfBytes;
		    }

		    public override String ContentType {
                get {
			       return "application/byps-" + (nbOfBytes % 3L);
                }
		    }
		
		    public override long ContentLength { 
                get {
                    return nbOfBytes;
                }
		    }

            public override bool CanRead
            {
                get { return true; }
            }

            public override bool CanSeek
            {
                get { return false; }
            }

            public override bool CanWrite
            {
                get { return false; }
            }

            public override void Flush()
            {
            }

            public override long Length
            {
                get { throw new NotImplementedException(); }
            }

            public override long Position
            {
                get
                {
                    throw new NotImplementedException();
                }
                set
                {
                    throw new NotImplementedException();
                }
            }

            public override int Read(byte[] buffer, int offset, int count)
            {
                if (nbOfBytes == pos)
                {
                    return 0;
                }
                else
                {
                    int i = 0;
                    for (; i < count && i + pos < nbOfBytes; i++)
                    {
                        buffer[i + offset] = (byte)(v++ & 0xFF);
                    }
                    pos += i;
                    return i;
                }
                
            }

            public override long Seek(long offset, SeekOrigin origin)
            {
                throw new NotImplementedException();
            }

            public override void SetLength(long value)
            {
                throw new NotImplementedException();
            }

            public override void Write(byte[] buffer, int offset, int count)
            {
                throw new NotImplementedException();
            }
        }

	    public static void assertEquals(Log log, String msg, Stream estrm, Stream rstrm) {
		    if (estrm is BContentStream) {
			    BContentStream ecs = (BContentStream)estrm;
			    if (rstrm is BContentStream) {
				    BContentStream rcs = (BContentStream)rstrm;
				    assertEquals(log, msg + ".contentType", ecs.ContentType, rcs.ContentType);
				    assertEquals(log, msg + ".contentLength", ecs.ContentLength, rcs.ContentLength);
			    }
		    }

            byte[] ebuf = new byte[10 * 1000];
		    byte[] rbuf = new byte[10 * 1000];
            int n = 0, p = 0;
            do
            {
                n = estrm.Read(ebuf, 0, ebuf.Length);

                if (n == 0)
                {
                    int n2 = rstrm.Read(rbuf, 0, rbuf.Length);
                    TestUtils.assertEquals(log, msg + ". stream byte, p=" + p, n, n2);
                    break;
                }
                else
                {
                    int n2 = 0;
                    while (n2 < n)
                    {
                        int n3 = rstrm.Read(rbuf, n2, n - n2);
                        Assert.IsTrue(n3 > 0);
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

	    }

	    public static void checkTempDirEmpty(BClient client) 
        {
		    log.info("check temp dir is empty");
		    String[] tempFiles = client.getTransport().getWire().getTestAdapter().getServerTempFiles();
		    TestUtils.assertEquals(log, "temp files", new String[0], tempFiles);
	    }


        private static Log log = LogFactory.getLog(typeof(TestUtils));

        private static short x;
        public static Point2D createPoint2D()
        {
            Point2D pt = new Point2D();
            pt.X = x++;
            pt.Y = (short)(x * x);
            return pt;
        }
    }
}
