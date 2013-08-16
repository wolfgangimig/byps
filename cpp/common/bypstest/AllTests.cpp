#include "AllTests.h"

#include "testfw.hpp"
#include "BLogger.hpp"
#include "Byps.hpp"
#include "Bypshttp.hpp"

#include "Testser-api.h"



LOGGER_IMPL

using namespace com::wilutions::byps;

void AllTests_run(void *app) {
    BLogger::init("d:\\temp\\log\\cppclient.log", BLogLevel::Debug, false);

	TestSuite suite;
//	suite.add(TestRemoteServerR_create(app));
//	suite.add(TestRemoteStreams_create(app));
//	suite.add(TestRemoteConstants_create(app));
//	suite.add(TestRemoteEnums_create(app));
//	suite.add(TestRemoteInlineInstance_create(app));
//	suite.add(TestRemoteArrays_create(app));
    suite.add(TestRemotePrimitiveTypes_create(app));
//	suite.add(TestRemoteSetTypes_create(app));
//	suite.add(TestRemoteMapTypes_create(app));
//	suite.add(TestRemoteArrays4Dim_create(app));
//	suite.add(TestRemoteListTypes_create(app));

	suite.run();

	BLogger::done();

}
