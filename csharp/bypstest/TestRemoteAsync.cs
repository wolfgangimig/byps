/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api.remote;
using System.Threading.Tasks;
using System.Threading;

namespace bypstest
{
    [TestClass]
    public class TestRemoteAsync
    {
        Log log = LogFactory.getLog(typeof(TestRemoteAsync));
        byps.test.api.BClient_Testser client;
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
        public void TestAsyncThrowException()
        {
            log.info("TestAsyncThrowException(");
            EventWaitHandle waitHandle = new EventWaitHandle(false, EventResetMode.ManualReset);
            internalTestThrowException(waitHandle);
            waitHandle.WaitOne();
            log.info(")TestAsyncThrowException");
        }

        public async void internalTestThrowException(EventWaitHandle waitHandle)
        {

            try
            {
                await remote.ThrowExceptionAsync();
                TestUtils.fail(log, "Exception expected");
            }
            catch (Exception ex)
            {
                TestUtils.assertEquals(log, "Exception message wrong", true, ex.ToString().IndexOf("throwException") >= 0);
            }
            finally
            {
                waitHandle.Set();
            }
        }
 
         [TestMethod]
        public void TestAsyncTaskBased()
        {
            log.info("TestAsyncTaskBased(");
            internalTestTaskBased();
            log.info(")TestAsyncTaskBased");
        }

        public void internalTestTaskBased()
        {
            log.info("internalTestTaskBased(");
            int value = 556;
            EventWaitHandle waitHandle = new EventWaitHandle(false, EventResetMode.ManualReset);
            int[] refValueR = new int[1];

            internalTestAsyncTaskBased(waitHandle, value, refValueR);

            log.info("wait for result");
            waitHandle.WaitOne();
            log.info("got result");

            TestUtils.assertEquals(log, "get/setInt", value, refValueR[0]);
            log.info(")internalTestTaskBased");
        }

        public async void internalTestAsyncTaskBased(EventWaitHandle waitHandle, int value, int[] refValueR)
        {
            log.info("internalTestAsyncTaskBased(");

            log.info("await taskSetInt");
            await remote.SetIntAsync(value);
            log.info("await taskSetInt OK");

            log.info("await taskGetInt");
            refValueR[0] = await remote.GetIntAsync();
            log.info("valueR=" + refValueR[0]);

            TestUtils.assertEquals(log, "get/setInt", value, refValueR[0]);

            waitHandle.Set();
            
            log.info(")internalTestAsyncTaskBased");
        }

      }

}
