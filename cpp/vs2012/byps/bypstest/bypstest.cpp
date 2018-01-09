// bypstest.cpp : Defines the entry point for the console application.
//

// does not help to log the source code file/line where a memory leak is detected.
#define _CRTDBG_MAP_ALLOC
#include <stdlib.h>
#include <crtdbg.h>


#include "stdafx.h"
#include "AllTests.h"
#include <Windows.h>

int _tmain(int argc, _TCHAR* argv[])
{


	_CrtSetDbgFlag ( _CRTDBG_ALLOC_MEM_DF 
		| _CRTDBG_LEAK_CHECK_DF
	//| _CRTDBG_CHECK_ALWAYS_DF 
	//| _CRTDBG_DELAY_FREE_MEM_DF
	);
	//_CrtSetBreakAlloc(3511);

	//try {
	//	PClient client = TestUtilHttp::createClient();
	//	client->done();
	//	client.reset();
	//}
	//catch (const BException& ex) {
	//	std::wcout << ex.toString();
	//}


	for (int i = 0; i < 1; i++) {
		AllTests_run(NULL);
		
	}


	return 0;
}

