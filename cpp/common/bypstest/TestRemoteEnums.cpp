/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#include "AllTests.h"


using namespace byps;
using namespace com::wilutions::test;

using namespace byps::test::api;
using namespace byps::test::api::enu;
using namespace byps::test::api::remote;



class TestRemoteEnums : public TestBase {
	static BLogger log;
public:
	TestRemoteEnums(void* app) : TestBase(app) {}

	void testRemoteEnums() {
        PRemoteEnums remote = client->remoteEnums;
        remote->setPlanet(EnumPlanets::Earth);
        EnumPlanets v = remote->getPlanet();
        TASSERT(L"enum", EnumPlanets::Earth, v);
    }


	virtual void init() {
        ADD_TEST(testRemoteEnums);
    }
};

BLogger TestRemoteEnums::log("TestRemoteEnums");

TestCase* TestRemoteEnums_create(void* app) {
	return new TestRemoteEnums(app);
}
