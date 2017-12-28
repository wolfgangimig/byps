/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

#define _CRTDBG_MAP_ALLOC
#include <stdlib.h>
#include <crtdbg.h>


#include "testfw.h"
#include "Byps.h"
#include "Bypshttp.h"
#include "TestBase.h"
#include "TestUtilHttp.h"
#include "TestUtils.h"
#include "BLogger.h"

using namespace com::wilutions::test;

void AllTests_run(void* app);

TestCase* TestRemoteServerR_create(void* app);
TestCase* TestRemoteStreams_create(void* app);
TestCase* TestRemotePrimitiveTypes_create(void* app);
TestCase* TestRemoteListTypes_create(void* app);
TestCase* TestRemoteArrays_create(void* app);
TestCase* TestRemoteArrays4Dim_create(void* app);
TestCase* TestRemoteMapTypes_create(void* app);
TestCase* TestRemoteSetTypes_create(void* app);
TestCase* TestRemoteInlineInstance_create(void* app);
TestCase* TestRemoteEnums_create(void* app);
TestCase* TestRemoteConstants_create(void* app);
TestCase* TestRemoteWithAuthentication_create(void* app);

//#define TEST_LARGE_STREAMS
