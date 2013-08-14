#include "AllTests.h"

#include "testfw.hpp"
#include "BLogger.hpp"
#include "Byps.hpp"
#include "Bypshttp.hpp"

#include "Testser-api.h"



LOGGER_IMPL

using namespace com::wilutions::byps;

void AllTests_run() {
    BLogger::init("d:\\temp\\log\\cppclient.log", BLogLevel::Debug, false);

	TestSuite suite;
	suite.add(TestRemoteServerR_create());
	suite.add(TestRemoteStreams_create());
	suite.add(TestRemoteConstants_create());
	suite.add(TestRemoteEnums_create());
	suite.add(TestRemoteInlineInstance_create());
	suite.add(TestRemoteArrays_create());
	suite.add(TestRemotePrimitiveTypes_create());
	suite.add(TestRemoteSetTypes_create());
	suite.add(TestRemoteMapTypes_create());
	suite.add(TestRemoteArrays4Dim_create());
	suite.add(TestRemoteListTypes_create());

	suite.run();

	BLogger::done();

}
