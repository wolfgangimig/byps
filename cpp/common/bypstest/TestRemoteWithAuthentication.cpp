/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#include "AllTests.h"
#include <stdio.h>
#include <thread>
#include "AllTests.h"

using namespace byps;
using namespace com::wilutions::test;

using namespace byps::test::api;
using namespace byps::test::api::remote;
using namespace byps::test::api::auth;

class MyAuthentication : public BAuthentication {

  static BLogger log;
  std::wstring userName;
  std::wstring pwd;
  PSessionInfo sess;

public:
  MyAuthentication(std::wstring userName, std::wstring pwd) {
    this->userName = userName;
    this->pwd = pwd;
  }

  virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) {
    l_info << L"authenticate(";

    PClient_Testser myclient = byps_ptr_cast<BClient_Testser>(client);

    function<void (PSessionInfo, BException)> outerResult = [this, asyncResult](PSessionInfo sess, BException ex) {
      l_info << L"authenticate sess=" << (sess != NULL)  << L", exception=" << ex.toString();
      this->sess = sess;
      asyncResult(false, ex);
    };

    myclient->getRemoteWithAuthentication()->login(userName, pwd, outerResult);
    l_info << L")authenticate";
  }

  virtual bool isReloginException(PClient client, BException ex, int typeId) {
    return client->getTransport()->isReloginException(ex, typeId);
  }

  virtual void getSession(PClient , BTYPEID , std::function<void (PSerializable, BException)> asyncResult) {
    asyncResult(sess, BException());
  }

};

BLogger MyAuthentication::log(typeid(MyAuthentication).name());

class MyAuthenticationTooSlow : public MyAuthentication
{
public:
  int waitMillis;

  MyAuthenticationTooSlow(std::wstring userName, std::wstring pwd, int waitMillis) 
    : MyAuthentication(userName, pwd) {
      this->waitMillis = waitMillis;
  }

  virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) {
    std::this_thread::sleep_for(std::chrono::milliseconds(waitMillis));
    MyAuthentication::authenticate(client, asyncResult);
  }
};

class MyAuthenticationCausesRecursion : public BAuthentication {
public:

  virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) {

    PClient_Testser myclient = byps_ptr_cast<BClient_Testser>(client);

    function<void (int, BException)> outerResult = [this, asyncResult](int, BException ex) {
      asyncResult(false, ex);
    };

    PRemoteWithAuthenticationAuth remote = myclient->getRemoteWithAuthentication();
    remote->doit(1, outerResult);
  }

  virtual bool isReloginException(PClient client, BException ex, int typeId) {
    return client->getTransport()->isReloginException(ex, typeId);
  }

  virtual void getSession(PClient , BTYPEID , std::function<void (PSerializable, BException)> asyncResult) {
    asyncResult(PSessionInfo(), BException());
  }

};

class TestRemoteWithAuthentication : public TestBase {
  static BLogger log;

public:
  TestRemoteWithAuthentication(void* app) : TestBase(app) {}

  virtual void beforeCase() {
    PClient_Testser client1 = TestUtilHttp::createClient(app);
    client1->getRemoteWithAuthentication()->setUseAuthentication(true);
    client1->done();

    TestBase::beforeCase();
  }

  virtual void afterCase() {
    if (client)
    {
      try
      {
        client->getRemoteWithAuthentication()->setUseAuthentication(false);
      }
      catch (const BException&) { }
    }

    TestBase::afterCase();
  }

  virtual void afterFunction(const TestFunction& f) {
    if (client)
    {
      try
      {
        client->getRemoteWithAuthentication()->expire();
      }
      catch (const BException&) { }
    }

    TestBase::afterFunction(f);
  }

  void testNoAuthObjectSupplied() {
    l_info << L"testNoAuthObjectSupplied(";

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    PSessionInfo sess = remote->login(L"Fritz", L"abc");
    l_info << L"sess avail=" << (sess != NULL);

    l_info << L")testNoAuthObjectSupplied";
  }

  void testAuthentication() {
    l_info << L"testAuthentication(";

    client->setAuthentication(PAuthentication(new MyAuthentication(L"Fritz", L"abc")));

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    // This method call will fail internally the first time with a BExceptionC.AUTHENTICATION_REQUIRED.
    // Then, BTranpsport invokes MyAuthentication.authenticate and retries the method call.
    int ret = remote->doit(1);
    TASSERT(L"ret", 2, ret);

    l_info << L")testAuthentication";
  }

  void testAuthenticationFails() {
    l_info << L"testAuthenticationFails(";

    client->setAuthentication(PAuthentication(new MyAuthentication(L"Unknownuser", L"")));

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    try {
      remote->doit(1);
      TFAIL(L"Exception expected");
    }
    catch (const BException& ex) {
      if (ex.toString().find(L"Login failed") == std::wstring::npos) {
        TFAIL(L"Unexpected exception " + ex.toString());
      }
    }

    l_info << L")testAuthenticationFails";
  }

  void testAuthenticationRelogin() {
    l_info << L"testAuthenticationRelogin(";

    client->setAuthentication(PAuthentication(new MyAuthentication(L"Fritz", L"abc")));

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    l_info << L"1 remote.Doit ... ";
    int ret = remote->doit(1);
    l_info << L"1 remote.Doit OK ";
    TASSERT(L"ret", 2, ret);

    // Invalidate session
    l_info << L"remote.Expire ... ";
    remote->expire();
    l_info << L"remote.Expire OK ";

    // Wait 1s, BTransport assumes that a session is at least 1s valid.
    std::chrono::milliseconds ms( 1000 );
    std::this_thread::sleep_for( ms );

    // Re-login
    l_info << L"2 remote.Doit ... ";
    ret = remote->doit(1);
    l_info << L"2 remote.Doit OK ";
    TASSERT(L"ret", 2, ret);   

    l_info << L")testAuthenticationRelogin";
  }

  void testAuthenticateBlocksRecursion() {
    l_info << L"testAuthenticateBlocksRecursion(";

    client->setAuthentication(PAuthentication(new MyAuthenticationCausesRecursion()));

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    try {
      l_info << L"1 remote.Doit ... ";
      remote->doit(1);
      
    }
    catch (BException& ex) {
      TASSERT(L"exception code", BExceptionC::FORBIDDEN, ex.getCode());
    }
    
    l_info << L")testAuthenticateBlocksRecursion";
  }

  void testAuthenticateTooSlow() {
    l_info << L"testAuthenticateTooSlow(";

    int waitMillis = 11 * 1000;
    MyAuthenticationTooSlow* auth = new MyAuthenticationTooSlow(L"Fritz", L"abc", waitMillis);
    client->setAuthentication(PAuthentication(auth));

    PRemoteWithAuthenticationAuth remote = client->getRemoteWithAuthentication();

    try {
      l_info << L"1 remote.Doit ... ";
      remote->doit(1);
      TFAIL(L"exception expected");
    }
    catch (BException& ex) {
      TASSERT(L"exception code", BExceptionC::FORBIDDEN, ex.getCode());
    }

    auth->waitMillis = 0;
    remote->doit(1);
    
    l_info << L")testAuthenticateTooSlow";
  }

  virtual void init() {
    ADD_TEST(testAuthenticateBlocksRecursion);
    ADD_TEST(testAuthenticateTooSlow);
    ADD_TEST(testNoAuthObjectSupplied);
    ADD_TEST(testAuthentication);
    ADD_TEST(testAuthenticationFails);
    ADD_TEST(testAuthenticationRelogin);
  }
};

BLogger TestRemoteWithAuthentication::log(typeid(TestRemoteWithAuthentication).name());

TestCase* TestRemoteWithAuthentication_create(void* app) {
  return new TestRemoteWithAuthentication(app);
}
