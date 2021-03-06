/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef TESTBASE_H_
#define TESTBASE_H_

#include "Byps.h"
#include "Testser-api.h"
#include "testfw.h"
#include "TestUtilHttp.h"
#include "BLogger.h"
#include "AssertException.h"

class TestBase : public com::wilutions::test::TestCase {
	static byps::BLogger log;
protected:
	void* app;
public:
	TestBase(void* app);
	virtual ~TestBase();
	virtual void beforeCase();
	virtual void afterCase();
	virtual void onError(const std::exception& ex);
	virtual void onError(const TestFunction& tfunc, const std::exception& ex);
	virtual void onFailed(const TestFunction& tfunc, const com::wilutions::test::AssertException& ex);
	virtual void beforeFunction(const TestFunction& tfunc);
	virtual void onSuccess(const TestFunction& tfunc);
	
protected:
	static byps::test::api::PClient_Testser client;
};

#endif
