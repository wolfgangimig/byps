
#include "TestBase.h"
#include <thread>

using namespace com::wilutions::byps;

BLogger TestBase::log("TestBase");

TestBase::TestBase(void* app) 
	: app(app) {
    log.debug() << L"ctor()";
}
TestBase::~TestBase() {
    log.debug() << L"dtor()";
}

void TestBase::beforeCase() {
    log.debug() << L"beforeCase(";
	client = TestUtilHttp::createClient(app);
    long rc = client->transport.use_count();
    assert(rc >= 1);
    log.debug() << L")beforeCase";
}
void TestBase::afterCase() {
    log.debug() << L"afterCase(";

    long rc = client->transport.use_count();
    assert(rc >= 1);

	client->done();

    assert(client.use_count() == 1);
    PTransport transport = client->transport;
    client.reset();
    rc = transport.use_count();
    assert(rc == 1);
    transport.reset();

    log.debug() << L")afterCase";
}

void TestBase::onError(const std::exception& ex) {
	const char* p = ex.what();
	std::wstringstream ws;
	ws << p;
	l_error << ws.str();
	TestCase::onError(ex);
}

void TestBase::onError(const TestFunction& tfunc, const std::exception& ex) {
	l_error << tfunc.name << L" error: " << ex;
	TestCase::onError(ex);
}

void TestBase::onFailed(const TestFunction& tfunc, const com::wilutions::test::AssertException& ex) {
	l_error << tfunc.name << L" failed: " << ex;
	TestCase::onFailed(tfunc, ex);
}

void TestBase::beforeFunction(const TestCase::TestFunction& tfunc) {
	TestCase::beforeFunction(tfunc);
	l_info << tfunc.name << "... ";
}

void TestBase::onSuccess(const TestCase::TestFunction& tfunc) {
	TestCase::onSuccess(tfunc);
	l_info << "OK";
}
