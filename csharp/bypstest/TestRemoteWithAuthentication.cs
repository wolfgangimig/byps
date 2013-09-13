using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using com.wilutions.byps.test.api.remote;
using com.wilutions.byps.test.api.prim;
using com.wilutions.byps.test.api.arr;
using com.wilutions.byps.test.api.inl;
using com.wilutions.byps.test.api.auth;

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

            // Re-login
            log.info("2 remote.Doit ... ");
            ret = remote.Doit(1);
            log.info("2 remote.Doit OK ");
            TestUtils.assertEquals(log, "ret", 2, ret);   

            log.info(")testAuthenticateRelogin");
        }




        private class MySessionResult : BAsyncResult<SessionInfo>
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
                innerResult.setAsyncResult(ex == null, ex);
            }

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

            public void authenticate(BClient client, BAsyncResult<bool> asyncResult)
            {
                log.info("authenticate(");

                MySessionResult sessResult = new MySessionResult(this, asyncResult);

                ((BClient_Testser)client).RemoteWithAuthentication.LoginAsync(userName, pwd, sessResult);

                log.info(")authenticate");
            }

            public bool isReloginException(BClient client, Exception ex, int typeId)
            {
                return client.transport.isReloginException(ex, typeId);
            }

            public Object getSession()
            {
                return sess;
            }

        }
    }
}
