// bypstest.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "AllTests.h"
#include <Windows.h>

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


	for (int i = 0; i < 1; i++) {
		AllTests_run();
		
	}


	return 0;
}

