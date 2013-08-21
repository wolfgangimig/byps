#include "AllTests.h"
#include <map>

using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::prim;
using namespace com::wilutions::byps::test::api::remote;
using namespace com::wilutions::byps::test::api::map;

using namespace std;

template <typename _Key, typename _Value> byps_ptr<std::map<_Key, _Value > > toMap(
	_Key k1, _Value v1,
	_Key k2, _Value v2,
	_Key k3, _Value v3
	) {
	byps_ptr<std::map<_Key, _Value> > m(new std::map<_Key, _Value>());
	(*m)[k1] = v1;
	(*m)[k2] = v2;
	(*m)[k3] = v3;
	return m;
}

template <typename _Key, typename _Value> void assertMap(byps_ptr<std::map<_Key, _Value> > arr, byps_ptr<std::map<_Key, _Value> > arrR) {
	TASSERT(L"map.size", arr->size(), arrR->size());
	for (auto it = arr->begin(), jt = arrR->begin(); it != arr->end(); it++, jt++) {
		TASSERT(L"map[i].key", (*it).first, (*jt).first);
		TASSERT(L"map[i].value", (*it).second, (*jt).second);
	}
}


class TestRemoteMapTypes : public TestBase {
	static BLogger log;
public:
	TestRemoteMapTypes(void* app) : TestBase(app) {}

	void testRemoteMapTypes() {

        PRemoteMapTypes remote = client->remoteMapTypes;

		PMapTypes obj(new MapTypes());
		obj->boolean1 = toMap(wstring(L"bool1"), true, wstring(L"bool2"), false, wstring(L"bool3"), true);
		obj->byte1 = toMap(1.0, (int8_t)-1, 2.0, (int8_t)-2, 3.0, (int8_t)-3);
		obj->char1 = toMap(-1.0f, L'a', 1.0e-1f, L'b', 2.0f, L'@');
		obj->double1 = toMap((int8_t)11, 11.12, (int8_t)22, 22.24, (int8_t)33, 33.36);
		obj->float1 = toMap(L'A', 1.0f, L'¶', 2.0f, L'€', -1.2468e-3f);
		obj->int1 = toMap(11,111,22,222,33,333);
        obj->long1 = toMap((int16_t)99, (int64_t)33LL, (int16_t)-99, -(int64_t)33LL, (int16_t)77, (int64_t)777LL);
		obj->primitiveTypes1 = toMap(
			1, TestUtils::createObjectPrimitiveTypes(), 
			2, TestUtils::createObjectPrimitiveTypes(),
			7, TestUtils::createObjectPrimitiveTypes()
			);
        obj->short1 = toMap((int64_t)-55LL, (int16_t)1234, (int64_t)0x5555555555555555LL, (int16_t)5555, (int64_t)0LL, (int16_t)0);
		obj->string1 = toMap(wstring(L"A"), wstring(L"a"), wstring(L"B"), wstring(L"b"), wstring(L"€"), wstring(L"€€€"));
		obj->obj1 = toMap(
			std::wstring(L"11"), byps_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()), 
			std::wstring(L"21"), byps_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			std::wstring(L"71"), byps_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes())
			);

		
		remote->setBoolean1(obj->boolean1);
		assertMap(obj->boolean1, remote->getBoolean1());
		remote->setByte1(obj->byte1);
		assertMap(obj->byte1, remote->getByte1());
		remote->setChar1(obj->char1);
		assertMap(obj->char1, remote->getChar1());
		remote->setDouble1(obj->double1);
		assertMap(obj->double1, remote->getDouble1());
		remote->setFloat1(obj->float1);
		assertMap(obj->float1, remote->getFloat1());
		remote->setInt1(obj->int1);
		assertMap(obj->int1, remote->getInt1());
		remote->setLong1(obj->long1);
		assertMap(obj->long1, remote->getLong1());
		remote->setShort1(obj->short1);
		assertMap(obj->short1, remote->getShort1());
		remote->setString1(obj->string1);
		assertMap(obj->string1, remote->getString1());

		{
			remote->setPrimitiveTypes1(obj->primitiveTypes1);
			auto arr = obj->primitiveTypes1;
			auto arrR = remote->getPrimitiveTypes1();
			TASSERT(L"map.size", arr->size(), arrR->size());
			for (auto it = arr->begin(), jt = arrR->begin(); it != arr->end(); it++, jt++) {
				TASSERT(L"map[i].key", (*it).first, (*jt).first);
				TestUtils::tassert(__FILE__, __LINE__, L"map[i].value", (*it).second, (*jt).second);
			}
			for (auto it = arr->begin(); it != arr->end(); it++) {
				TestUtils::releasePrimitiveTypes((*it).second);
			}
			for (auto it = arrR->begin(); it != arrR->end(); it++) {
				TestUtils::releasePrimitiveTypes((*it).second);
			}
		}

		{
			remote->setObj1(obj->obj1);
			auto arr = obj->obj1;
			auto arrR = remote->getObj1();
			TASSERT(L"map.size", arr->size(), arrR->size());
			for (auto it = arr->begin(), jt = arrR->begin(); it != arr->end(); it++, jt++) {
				TASSERT(L"map[i].key", (*it).first, (*jt).first);
				TestUtils::tassert(__FILE__, __LINE__, L"map[i].value", 
					byps_ptr_cast<PrimitiveTypes>((*it).second),
					byps_ptr_cast<PrimitiveTypes>((*jt).second));
			}
			for (auto it = arr->begin(); it != arr->end(); it++) {
				TestUtils::releasePrimitiveTypes(
					byps_ptr_cast<PrimitiveTypes>((*it).second));
			}
			for (auto it = arrR->begin(); it != arrR->end(); it++) {
				TestUtils::releasePrimitiveTypes(
					byps_ptr_cast<PrimitiveTypes>((*it).second));
			}
		}

	}

	virtual void init() {
		ADD_TEST(testRemoteMapTypes);
	}
};

BLogger TestRemoteMapTypes::log("TestRemoteMapTypes");

TestCase* TestRemoteMapTypes_create(void* app) {
	return new TestRemoteMapTypes(app);
}
