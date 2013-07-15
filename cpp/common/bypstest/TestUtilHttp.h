#ifndef TESTUTILHTTP_H_
#define TESTUTILHTTP_H_

#include "Byps.h"
#include "Bypshttp.h"
#include "testfw.h"
#include "Testser-api.h"

class TestUtilHttp {
public:
	static com::wilutions::byps::test::api::PClient_Testser createClient();

	static byps_ptr<std::vector<com::wilutions::byps::PContentStream> > makeTestStreams();

	
	static void tassert(const char* file, int line, const std::wstring& msg, 
			  com::wilutions::byps::PContentStream strm,
			  com::wilutions::byps::PContentStream strmR);

};


#endif