#include "AllTests.h"

using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::prim;
using namespace com::wilutions::byps::test::api::remote;


class TestRemotePrimitiveTypes : public TestBase {
public:
	TestRemotePrimitiveTypes(void* app) : TestBase(app) {}

	void testPrimitiveTypesReferenceToOtherObject() {	
        PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;

		PPrimitiveTypes obj1(new PrimitiveTypes());
		obj1->intVal = 123;
		obj1->objVal = obj1->objVal2 = PPrimitiveTypes(new PrimitiveTypes());
		
		remote->setPrimitiveTypes(obj1);
		PPrimitiveTypes objR = remote->getPrimitiveTypes();
		
		TestUtils::tassert(__FILE__, __LINE__, L"PrimitiveTypes", obj1, objR);
		TASSERT( L"this.objVal != this.objVal2", (intptr_t)objR->objVal.get(), (intptr_t)objR->objVal2.get());

		TestUtils::releasePrimitiveTypes(obj1);
		TestUtils::releasePrimitiveTypes(objR);
	}

	void testSerializeInt() {	
        PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;

		PPrimitiveTypes obj1(new PrimitiveTypes());

		int arr[] = { 0, 1, 0xFF, 0x100, 0x10000, 0x1000000, 0x7FFFFFFF, -1, 0x80000000}; 
		for (int i = 0; i < sizeof(arr)/sizeof(int); i++) {
			obj1->intVal = arr[i];
		
			remote->setPrimitiveTypes(obj1);
			PPrimitiveTypes objR = remote->getPrimitiveTypes();
		
			TestUtils::tassert(__FILE__, __LINE__, L"PrimitiveTypes", obj1, objR);
			TASSERT( L"Wrong int", obj1->intVal, objR->intVal);
		}
	}

	void testSerializeLong() {	
        PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;

		PPrimitiveTypes obj1(new PrimitiveTypes());

		int64_t arr[] = { 0, 1, 0xFF, 0x7FFFFFFFFFFFFFFFLL, -1, 0x8000000000000000LL}; 
		for (int i = 0; i < sizeof(arr)/sizeof(int64_t); i++) {
			obj1->longVal = arr[i];
		
			remote->setPrimitiveTypes(obj1);
			PPrimitiveTypes objR = remote->getPrimitiveTypes();
		
			TestUtils::tassert(__FILE__, __LINE__, L"PrimitiveTypes", obj1, objR);
			TASSERT( L"Wrong long", obj1->longVal, objR->longVal);
		}

        for (int i = 0; i < 64; i += 8) {
            int64_t value = 1 << i;
            remote->setLong(value);
            int64_t valueR = remote->getLong();
            TASSERT( L"Wrong long", value, valueR);
        }

	}


	void testRemotePrimitiveTypes() {

        PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;
		remote->setBool(true);
		TASSERT(L"bool", true, remote->getBool());
		remote->setBool(false);
		TASSERT(L"bool", false, remote->getBool());
		remote->setByte(11);
		TASSERT(L"byte", (int8_t)11, remote->getByte());
		remote->setChar(L'€');
		TASSERT(L"char", L'€', remote->getChar());
		remote->setShort(1234);
		TASSERT(L"short", (int16_t)1234, remote->getShort());
		remote->setInt(5678);
		TASSERT(L"int", 5678, remote->getInt());
		remote->setLong(890L);
		TASSERT(L"long", (int64_t)890, remote->getLong());
		remote->setFloat(1.2f);
		TASSERT(L"float", 1.2f, remote->getFloat());
		remote->setDouble(1.8);
		TASSERT(L"double", 1.8, remote->getDouble());
		remote->setString(L"ABC€€€DEF€€€GHI€€€JKL€€€MNO€€€PQR€€€STU€€€VWX€€€YZ1€€€");
		TASSERT(L"string", std::wstring(L"ABC€€€DEF€€€GHI€€€JKL€€€MNO€€€PQR€€€STU€€€VWX€€€YZ1€€€"), remote->getString());

		PPrimitiveTypes pt = TestUtils::createObjectPrimitiveTypes();
		remote->setPrimitiveTypes(pt);
		PPrimitiveTypes ptR = byps_static_ptr_cast<PrimitiveTypes>(remote->getPrimitiveTypes());
		TestUtils::tassert(__FILE__, __LINE__, L"PrimitiveTypes", pt, ptR);
		TestUtils::releasePrimitiveTypes(pt);
		TestUtils::releasePrimitiveTypes(ptR);


	}

	void testRemotePrimitvieTypesSendAsObjectType() {
		PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;
		PPrimitiveTypes pt = TestUtils::createObjectPrimitiveTypes();
		remote->setObject(pt);
		PPrimitiveTypes ptR = byps_static_ptr_cast<PrimitiveTypes>(remote->getObject());
		TestUtils::tassert(__FILE__, __LINE__, L"Object", pt, ptR);
		TestUtils::releasePrimitiveTypes(pt);
		TestUtils::releasePrimitiveTypes(ptR);
	}

	void testRemotePrimitiveTypesSendAll() {
		PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;

		PPrimitiveTypes pt = TestUtils::createObjectPrimitiveTypes();
		PPrimitiveTypes pt2  =TestUtils::createObjectPrimitiveTypes();
		remote->sendAllTypes(true, L'Q', (short)34, 56, 45, 7.4f, 9.8, L"23", pt, pt2);
		
		TASSERT(L"bool", true, remote->getBool());
		TASSERT(L"char", L'Q', remote->getChar());
		TASSERT(L"short", (int16_t)34, remote->getShort());
		TASSERT(L"int", 56, remote->getInt());
        TASSERT(L"long", (int64_t)45LL, remote->getLong());
		TASSERT(L"float", 7.4f, remote->getFloat());
		TASSERT(L"double", 9.8, remote->getDouble());
		TASSERT(L"String", std::wstring(L"23"), remote->getString());
		TestUtils::tassert(__FILE__, __LINE__, L"PrimtitiveTypes", pt, remote->getPrimitiveTypes());
		TestUtils::tassert(__FILE__, __LINE__, L"Object", pt2, byps_ptr_cast<PrimitiveTypes>(remote->getObject()));

	}

	void testPrimitiveTypesReferenceToSelf()  {	
		PRemotePrimitiveTypes remote = client->remotePrimitiveTypes;

		PPrimitiveTypes obj1(new PrimitiveTypes());
		obj1->intVal = 123;
		obj1->objVal = obj1->objVal2 = obj1;
		
		remote->setPrimitiveTypes(obj1);
		PPrimitiveTypes objR = remote->getPrimitiveTypes();
		
		TASSERT(L"this != this.objVal", true, objR == objR->objVal);
		TASSERT(L"this != this.objVal2", true, objR == objR->objVal2);
		
		TestUtils::releasePrimitiveTypes(obj1);
		TestUtils::releasePrimitiveTypes(objR);
	}


	virtual void init() {
		ADD_TEST(testSerializeInt);
		ADD_TEST(testSerializeLong);
		ADD_TEST(testRemotePrimitiveTypes);
		ADD_TEST(testPrimitiveTypesReferenceToOtherObject);
		ADD_TEST(testRemotePrimitvieTypesSendAsObjectType);
		ADD_TEST(testRemotePrimitiveTypesSendAll);
		ADD_TEST(testPrimitiveTypesReferenceToSelf);
		
	}
};

TestCase* TestRemotePrimitiveTypes_create(void* app) {
	return new TestRemotePrimitiveTypes(app);
}
