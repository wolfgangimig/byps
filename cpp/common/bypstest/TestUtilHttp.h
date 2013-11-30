/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef TESTUTILHTTP_H_
#define TESTUTILHTTP_H_

#include "Byps.h"
#include "Bypshttp.h"
#include "testfw.h"
#include "Testser-api.h"

class TestUtilHttp {
public:
	static byps::test::api::PClient_Testser createClient(void* app);

	static byps_ptr<std::vector<byps::PContentStream> > makeTestStreams();

	
	static void tassert(const char* file, int line, const std::wstring& msg, 
			  byps::PContentStream strm,
			  byps::PContentStream strmR);

};


#endif