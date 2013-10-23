using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.remote;
using byps.test.api.prim;
using byps.test.api.srvr;
using System.IO;
using System.Threading;
using System.Collections.Generic;

namespace bypstest
{
    [TestClass]
    public class TestRemotePrimitiveTypes
    {
        Log log = LogFactory.getLog(typeof(TestRemotePrimitiveTypes));
        BClient_Testser client;
        RemotePrimitiveTypes remote;

        [TestInitialize]
        public void setUp()
        {
            client = TestUtilsHttp.createClient();
            remote = client.RemotePrimitiveTypes;
        }

        [TestCleanup]
        public void tearDown()
        {
            client.done();
        }

        [TestMethod]
        public void TestPrimitiveTypes()
        {
            log.info("TestPrimitiveTypes(");
            try
            {
                remote.SetBool(true);
                Assert.AreEqual(true, remote.GetBool());
                remote.SetBool(false);
                TestUtils.assertEquals(log, "bool", false, remote.GetBool());
                remote.SetByte((byte)11);
                TestUtils.assertEquals(log, "byte", (byte)11, remote.GetByte());
                remote.SetChar('€');
                TestUtils.assertEquals(log, "char", '€', remote.GetChar());
                remote.SetShort((short)1234);
                TestUtils.assertEquals(log, "short", (short)1234, remote.GetShort());
                remote.SetInt(5678);
                TestUtils.assertEquals(log, "int", 5678, remote.GetInt());
                remote.SetLong(890L);
                TestUtils.assertEquals(log, "long", 890L, remote.GetLong());
                remote.SetFloat(1.2f);
                TestUtils.assertEquals(log, "float", 1.2f, remote.GetFloat());
                remote.SetDouble(1.8);
                TestUtils.assertEquals(log, "double", 1.8, remote.GetDouble());

                remote.SetString("ABC");
                String str = remote.GetString();
                TestUtils.assertEquals(log, "String", "ABC", str);

                PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
                remote.SetObject(pt);
                TestUtils.assertEquals(log, "Object", pt, remote.GetObject());

                pt = TestUtils.createObjectPrimitiveTypes();
                remote.SetPrimitiveTypes(pt);
                TestUtils.assertEquals(log, "PrimitiveTypes", pt, remote.GetPrimitiveTypes());
            }
            catch (BException e)
            {
                Assert.Fail(e.ToString());
            }

            log.info(")TestPrimitiveTypes");
        }

        [TestMethod]
        public void testRemotePrimitiveTypesSendAll()
        {
            log.info("testRemotePrimitiveTypesSendAll(");

            PrimitiveTypes pt = TestUtils.createObjectPrimitiveTypes();
            PrimitiveTypes pt2 = TestUtils.createObjectPrimitiveTypes();
            remote.SendAllTypes(true, 'Q', (short)34, 56, 45, 7.4f, 9.8, "23", pt, pt2);

            TestUtils.assertEquals(log, "bool", true, remote.GetBool());
            TestUtils.assertEquals(log, "char", 'Q', remote.GetChar());
            TestUtils.assertEquals(log, "short", (short)34, remote.GetShort());
            TestUtils.assertEquals(log, "int", 56, remote.GetInt());
            TestUtils.assertEquals(log, "long", 45L, remote.GetLong());
            TestUtils.assertEquals(log, "float", 7.4f, remote.GetFloat());
            TestUtils.assertEquals(log, "double", 9.8, remote.GetDouble());
            TestUtils.assertEquals(log, "String", "23", remote.GetString());
            TestUtils.assertEquals(log, "Object", pt2, remote.GetObject());
            TestUtils.assertEquals(log, "PrimtitiveTypes", pt, remote.GetPrimitiveTypes());

            log.info(")testRemotePrimitiveTypesSendAll");
        }

        [TestMethod]
        public void testRemotePrimitiveTypesAsync()
        {
            log.info("testRemotePrimitiveTypesAsync(");

            BSyncResult<Object> result = new BSyncResult<Object>();
            remote.SetInt(1122, (ignored, ex) =>
                {
                    if (ex != null) TestUtils.fail(log, ex.ToString());
                    remote.GetInt((valueR, ex2) =>
                        {
                            if (ex != null) TestUtils.fail(log, ex2.ToString());
                            TestUtils.assertEquals(log, "GetInt", 1122, valueR);
                        });
                });

            log.info(")testRemotePrimitiveTypesAsync");
        }

        /**
         * Tests asynchronous invocation with null as asyncResult parameter.
         * A null can be passed, if the result is not of interest.
         * @throws InterruptedException
         */
        [TestMethod]
        public void testRemotePrimitiveTypesAsyncNull()
        {
            log.info("testRemotePrimitiveTypesAsyncNull(");

            remote.SetInt(1122, null);
            Thread.Sleep(1000);

            log.info(")testRemotePrimitiveTypesAsyncNull");
        }

        [TestMethod]
        public void testPrimitiveTypesInt()
        {
            log.info("testPrimitiveTypesInt(");

            int[] arr = new int[] { 0, 1, 0xFF, 0x100, 0x10000, 0x1000000, 0x7FFFFFFF, -1, -2147483648 };
            for (int i = 1; i < arr.Length; i++)
            {
                remote.SetInt(arr[i]);
                int valueR = remote.GetInt();
                TestUtils.assertEquals(log, "Wrong int", arr[i], valueR);
            }
            log.info(")testPrimitiveTypesInt");
        }

        [TestMethod]
        public void testSerializeLong() 
        {
            log.info("testSerializeLong(");
            List<long> ints = new List<long>();
    
            ints.Add((long) 0);
            ints.Add((long) 1);
            ints.Add((long) 2);
 
            ulong a = 0;
            for (int i = 0; i < 63-7; i+=7) 
            {
                ints.Add((long)(((ulong)0x7E << i) | a));
                ints.Add((long)(((ulong)0x7F << i) | a));
                ints.Add((long)(((ulong)0x80 << i) | a));
                ints.Add((long)(((ulong)0x81 << i) | a));
              a <<= 7;
              a |= 0x5D;
            }

            for (int i = 0; i < ints.Count; i++) {
              internalTestLong(ints[i]);
              internalTestLong(-ints[i]);
            }
    
            internalTestLong(long.MaxValue);
            internalTestLong(long.MinValue);

            log.info(")testSerializeLong");
        }
  
        private void internalTestLong(long v) 
        {
            // Serialize/deserialize here
            BBufferBin bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, null);
            bbuf.putLong(v);
            byte[] data = bbuf.getBuffer().array();
            BBufferBin bbuf2 = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, ByteBuffer.wrap(data, 0, bbuf.position()));
            long r = bbuf2.getLong();
            TestUtils.assertEquals(log, "longVal", v, r);

            // Send to server, receive from server
            remote.SetLong(v);
            r = remote.GetLong();
            TestUtils.assertEquals(log, "Wrong long", v, r);
        }

    }

}
