using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api.remote;
using System.Threading.Tasks;
using System.Threading;

namespace bypstest
{
    [TestClass]
    public class TestRemoteAsync
    {
        Log log = LogFactory.getLog(typeof(TestRemoteAsync));
        com.wilutions.byps.test.api.BClient_Testser client;
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

            log.info("start taskSetInt");
            Task<Object> taskSetInt = Task<Object>.Factory.FromAsync(remote.BeginSetInt, remote.EndSetInt, value, null);
            log.info("await taskSetInt");
            await taskSetInt;
            log.info("await taskSetInt OK");

            log.info("start taskGetInt");
            Task<int> taskGetInt = Task<int>.Factory.FromAsync(remote.BeginGetInt, remote.EndGetInt, null);
            log.info("await taskGetInt");
            refValueR[0] = await taskGetInt;
            log.info("valueR=" + refValueR[0]);

            int abc = await Task<int>.Factory.FromAsync(remote.BeginGetInt, remote.EndGetInt, null);
            int abc2 = await ExampleMethod();

            waitHandle.Set();
            
            log.info(")internalTestAsyncTaskBased");
        }

        public async Task<int> ExampleMethod()
        {
           int abc = await Task<int>.Factory.FromAsync(remote.BeginGetInt, remote.EndGetInt, null);
            return abc;
        }

        [TestMethod]
        public void TestAsyncProgrammingModel()
        {

            log.info("TestAsyncProgrammingModel(");
            internalTestAsyncPrimitiveTypesAPR();
            log.info(")TestAsyncProgrammingModel");
        }

        public void internalTestAsyncPrimitiveTypesAPR()
        {
            log.info("internalTestAsyncPrimitiveTypesAPR(");
            int value = 556;
            EventWaitHandle waitHandle = new EventWaitHandle(false, EventResetMode.ManualReset);
            int valueR = 0;

            remote.BeginSetInt(
                value,
                delegate(IAsyncResult asyncResult)
                {
                    log.info("delegate BeginSetInt(state=" + asyncResult.AsyncState);

                    remote.BeginGetInt(
                        delegate(IAsyncResult getIntResult)
                        {
                            log.info("delegate BeginGetInt(state=" + getIntResult.AsyncState);

                            valueR = remote.EndGetInt(getIntResult);
                            log.info("valueR=" + valueR);

                            waitHandle.Set();

                            log.info(")delegate BeginGetInt");
                        },
                        "getintstate"
                        );

                    log.info(")delegate BeginSetInt");
                }, 
                "setintstate"
            );

            waitHandle.WaitOne();

            TestUtils.assertEquals(log, "get/setInt", value, valueR);

        }

     }

}
