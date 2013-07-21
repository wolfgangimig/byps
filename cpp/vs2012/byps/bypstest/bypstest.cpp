// bypstest.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "AllTests.h"
#include "testfw.hpp"
#include "BLogger.hpp"

LOGGER_IMPL;

#include <stdarg.h>
#include <exception>
#include <iostream>
#include <memory>
#include <fstream>

#include "Testser-api.h"
#include "Byps.hpp"
#include "Bypshttp.hpp"
#include "testfw.h"
#include "AllTests.h"
#include "BLogger.h"

#include "platform/win/WinHttpClient.hpp"




using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::srvr;
using namespace com::wilutions::byps::test::api::inl;
using namespace com::wilutions::byps::test::api::prim;

class MyRunnable : public BRunnable {
public:
	virtual void run() {
	}
};

int _tmain(int argc, _TCHAR* argv[])
{

	_CrtSetDbgFlag ( _CRTDBG_ALLOC_MEM_DF 
		| _CRTDBG_LEAK_CHECK_DF
	//	//| _CRTDBG_CHECK_ALWAYS_DF 
	//	//| _CRTDBG_DELAY_FREE_MEM_DF
	);
	//_CrtSetBreakAlloc(18334);

	//try {
	//	PClient client = TestUtilHttp::createClient();
	//	client->done();
	//	client.reset();
	//}
	//catch (const BException& ex) {
	//	std::wcout << ex.toString();
	//}

	BLogger::init(L"d:\\temp\\log\\cppclient.log", BLogLevel::Debug, false);

	BLogger log("main");
	log.debug() << L"eine logausgabe" << 14;
	for (int i = 0; i < 1; i++) {

		TestSuite suite;
		suite.add(TestRemoteConstants_create());
		suite.add(TestRemoteEnums_create());
		suite.add(TestRemoteInlineInstance_create());
		suite.add(TestRemoteServerR_create());
		suite.add(TestRemoteArrays_create());
		suite.add(TestRemotePrimitiveTypes_create());
		suite.add(TestRemoteSetTypes_create());
		suite.add(TestRemoteMapTypes_create());
		suite.add(TestRemoteArrays4Dim_create());
		suite.add(TestRemoteListTypes_create());
		suite.add(TestRemoteStreams_create());

		suite.run();
	}

	//test2();b


	BLogger::done();

	Sleep(3000);

	return 0;
}

