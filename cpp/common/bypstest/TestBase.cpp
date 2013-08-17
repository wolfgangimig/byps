
#include "TestBase.h"

using namespace com::wilutions::byps;

BLogger TestBase::log("TestBase");

TestBase::TestBase(void* app) 
	: app(app) {
}
TestBase::~TestBase() {
}

void TestBase::beforeCase() {
	client = TestUtilHttp::createClient(app);
}
void TestBase::afterCase() {
	client->done();
#ifdef _DEBUG
	assert(client.use_count() == 1);
	PTransport transport = client->transport;
	client.reset();
	long rc = transport.use_count();
	assert(rc == 1);
#endif
	
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