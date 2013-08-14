#include "testfw.h"
#include "Byps.h"
#include "Bypshttp.h"
#include "TestBase.h"
#include "TestUtilHttp.h"
#include "TestUtils.h"
#include "BLogger.h"

using namespace com::wilutions::test;

void AllTests_run();

TestCase* TestRemoteServerR_create();
TestCase* TestRemoteStreams_create();
TestCase* TestRemotePrimitiveTypes_create();
TestCase* TestRemoteListTypes_create();
TestCase* TestRemoteArrays_create();
TestCase* TestRemoteArrays4Dim_create();
TestCase* TestRemoteMapTypes_create();
TestCase* TestRemoteSetTypes_create();
TestCase* TestRemoteInlineInstance_create();
TestCase* TestRemoteEnums_create();
TestCase* TestRemoteConstants_create();

//#define TEST_LARGE_STREAMS
