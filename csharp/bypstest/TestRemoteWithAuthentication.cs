/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using byps;
using byps.test.api;
using byps.test.api.remote;
using byps.test.api.prim;
using byps.test.api.arr;
using byps.test.api.inl;
using byps.test.api.auth;
using System.Threading;

namespace bypstest
{
    [TestClass]
    public class TestRemoteWithAuthentication
    {

        Log log = LogFactory.getLog(typeof(TestRemoteWithAuthentication));
        BClient_Testser client;
        RemoteWithAuthenticationAuth remote;

        [TestInitialize]
        public void setUp()
        {
            BClient_Testser client1 = TestUtilsHttp.createClient();
            client1.RemoteWithAuthentication.SetUseAuthentication(true);
            client1.done();

            client = TestUtilsHttp.createClient();
            remote = client.RemoteWithAuthentication;
        }

        [TestCleanup]
        public void tearDown()
        {
            if (client != null)
            {
                try
                {
                    remote.SetUseAuthentication(false);
                }
                catch (Exception) { }
                client.done();
            }
        }

        [TestMethod]
        public void testNoAuthObjectSupplied()
        {
            log.info("testNoAuthObjectSupplied(");

            SessionInfo sess = remote.Login("Fritz", "abc");
            log.info("sess=" + sess);

            log.info(")testNoAuthObjectSupplied");
        }

        [TestMethod]
        public void testAuthenticate()
        {
            log.info("testAuthenticate(");

            client.setAuthentication(new MyAuthentication("Fritz", "abc"));

            int ret = remote.Doit(1);
            TestUtils.assertEquals(log, "ret", 2, ret);

            log.info(")testAuthenticate");
        }

        [TestMethod]
        public void testAuthenticateFails()
        {
            log.info("testAuthenticateFails(");

            client.setAuthentication(new MyAuthentication("Unknownuser", ""));

            try
            {
                int ret = remote.Doit(1);
                TestUtils.fail(log, "Exception expected");
            }
            catch (BException e)
            {
                TestUtils.assertEquals(log, "Unexpected exception: " + e, e.ToString().IndexOf("Login failed") >= 0, true);
            }

            log.info(")testAuthenticateFails");
        }


        [TestMethod]
        public void testAuthenticateRelogin()
        {
            log.info("testAuthenticateRelogin(");

            client.setAuthentication(new MyAuthentication("Fritz", "abc"));

            log.info("1 remote.Doit ... ");
            int ret = remote.Doit(1);
            log.info("1 remote.Doit OK ");
            TestUtils.assertEquals(log, "ret", 2, ret);

            // Invalidate session
            log.info("remote.Expire ... ");
            remote.Expire();
            log.info("remote.Expire OK ");

            // Wait 1s, BTransport assumes that a session is at least 1s valid.
            Thread.Sleep(1000);

            // Re-login
            log.info("2 remote.Doit ... ");
            ret = remote.Doit(1);
            log.info("2 remote.Doit OK ");
            TestUtils.assertEquals(log, "ret", 2, ret);

            log.info(")testAuthenticateRelogin");
        }




        private class MySessionResult : BAsyncResultIF<SessionInfo>
        {
            private MyAuthentication auth;
            private BAsyncResult<bool> innerResult;

            internal MySessionResult(MyAuthentication auth, BAsyncResult<bool> innerResult)
            {
                this.auth = auth;
                this.innerResult = innerResult;
            }

            public void setAsyncResult(SessionInfo sess, Exception ex)
            {
                auth.sess = sess;
                innerResult(ex == null, ex);
            }

        }

        /**
         * Test with an authentication class that 
         * This must not cause an endless loop or a stack overflow.
         * @throws RemoteException
         */
        [TestMethod]
        public void testAuthenticateBlocksRecursion()
        {
            log.info("testAuthenticateBlocksRecursion(");

            client.setAuthentication(new MyAuthenticationCausesRecursion());

            try
            {
                remote.Doit(1);
            }
            catch (BException e)
            {
                TestUtils.assertEquals(log, "exception", BExceptionC.FORBIDDEN, e.Code);
            }

            log.info(")testAuthenticateBlocksRecursion");
        }

        /**
         * Test with an authentication class that performs too slow,
         * so that the application server session gets invalid during
         * authentication.
         * This must not cause an endless loop or a stack overflow. 
         * It results in a 403 error.
         * @throws RemoteException
         */
        [TestMethod]
        public void testAuthenticateTooSlow()
        {
            log.info("testAuthenticateTooSlow(");

            int waitMillis = (10 + 1) * 1000;
            MyAuthenticationTooSlow auth = new MyAuthenticationTooSlow("Fritz", "abc", waitMillis);
            client.setAuthentication(auth);

            try
            {
                remote.Doit(1);
                TestUtils.fail(log, "exception expected");
            }
            catch (BException e)
            {
                TestUtils.assertEquals(log, "exception", BExceptionC.FORBIDDEN, e.Code);
            }

            // Try again without sleeping -> authentication should work correctly
            auth.waitMillis = 0;
            remote.Doit(1);

            log.info(")testAuthenticateTooSlow");
        }

        private class MyAuthentication : BAuthentication
        {
            private Log log = LogFactory.getLog(typeof(MyAuthentication));
            private String userName;
            private String pwd;
            internal SessionInfo sess;

            public MyAuthentication(String userName, String pwd)
            {
                this.userName = userName;
                this.pwd = pwd;
            }

            public virtual void authenticate(BClient client, BAsyncResult<bool> asyncResult)
            {
                log.info("authenticate(");

                BAsyncResult<SessionInfo> sessResult = (sess, ex) =>
                {
                    this.sess = sess;
                    asyncResult(true, ex);
                };

                ((BClient_Testser)client).RemoteWithAuthentication.Login(userName, pwd, sessResult);

                log.info(")authenticate");
            }

            public bool isReloginException(BClient client, Exception ex, int typeId)
            {
                return client.getTransport().isReloginException(ex, typeId);
            }

            public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult)
            {
                asyncResult(sess, null);
            }

        }

        class MyAuthenticationCausesRecursion : BAuthentication
        {
            public void authenticate(BClient client, BAsyncResult<bool> asyncResult)
            {
                BAsyncResult<int> doitResult = (ret, ex) =>
                {
                    asyncResult(true, ex);
                };
                RemoteWithAuthenticationAuth remote = ((BClient_Testser)client).RemoteWithAuthentication;
                remote.Doit(1, doitResult); // Causes recursion
            }

            public bool isReloginException(BClient client, Exception ex, int typeId)
            {
                return client.getTransport().isReloginException(ex, typeId);
            }

            public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult)
            {
                asyncResult(null, null);
            }

        }

        private class MyAuthenticationTooSlow : MyAuthentication
        {
            public volatile int waitMillis;

            public MyAuthenticationTooSlow(String userName, String pwd, int waitMillis)
                : base(userName, pwd)
            {
                this.waitMillis = waitMillis;
            }

            public override void authenticate(BClient client, BAsyncResult<bool> asyncResult)
            {
                Thread.Sleep(waitMillis);
                base.authenticate(client, asyncResult);
            }
        }

    }


}
