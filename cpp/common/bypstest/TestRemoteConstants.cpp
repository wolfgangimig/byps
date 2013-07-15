#include "AllTests.h"


using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::cons;
using namespace com::wilutions::byps::test::api::remote;



class TestRemoteConstants : public TestBase {
	static BLogger log;
public:

	void testCompareConstants() {
		PRemoteConstants remote = client->remoteConstants;

		remote->compare_HebrewC(HebrewC::ALEPH, HebrewC::BETH);


		remote->compare_AllTypesC(
			AllTypesC::bool1s,
			AllTypesC::bool2s,
			AllTypesC::char1s,
			AllTypesC::stringNull,
			AllTypesC::char2s,
			AllTypesC::short1s,
			AllTypesC::int1s,
			AllTypesC::long1s,
			AllTypesC::float1s,
			AllTypesC::double1s,
			AllTypesC::string1s,
			AllTypesC::ALL,
			AllTypesC::arrInt,
			AllTypesC::arrInt4,
			AllTypesC::arrStrings,
			AllTypesC::arrStrings4,
			AllTypesC::arrALL);

 	}


	virtual void init() {
		ADD_TEST(testCompareConstants);
	}
};

BLogger TestRemoteConstants::log("TestRemoteConstants");

TestCase* TestRemoteConstants_create() {
	return new TestRemoteConstants();
}
