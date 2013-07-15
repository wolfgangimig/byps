#include "AllTests.h"


using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::enu;
using namespace com::wilutions::byps::test::api::remote;



class TestRemoteEnums : public TestBase {
	static BLogger log;
public:

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

TestCase* TestRemoteEnums_create() {
	return new TestRemoteEnums();
}
