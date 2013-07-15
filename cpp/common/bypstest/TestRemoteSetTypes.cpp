#include "AllTests.h"


using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::prim;
using namespace com::wilutions::byps::test::api::set;
using namespace com::wilutions::byps::test::api::remote;


template <typename _Type> byps_ptr<std::set< _Type > > toSet(_Type a, _Type b, _Type c, _Type d) {
    byps_ptr<std::set<_Type> > set(new std::set< _Type >());
    set->insert(typename std::set< _Type > ::value_type(a));
    set->insert(typename std::set< _Type > ::value_type(b));
    set->insert(typename std::set< _Type > ::value_type(c));
    set->insert(typename std::set< _Type > ::value_type(d));
    return set;
}

template<typename _Set> bool findObject(_Set set, int32_t intVal) {
	for (auto it = set->begin(); it != set->end(); it++) {
		PPrimitiveTypes p = byps_ptr_cast<PrimitiveTypes>(*it);
		if (p->intVal == intVal) return true;
	}
	return false;
}

template<typename _Set> void assertSet(const wchar_t* sz, _Set arr, _Set arrR) {
	TASSERT(std::wstring(sz) + L".size", arr->size(), arrR->size());
	for (auto it = arr->begin(), jt = arrR->begin(); it != arr->end(); it++, jt++) {
		TASSERT(std::wstring(sz) + L"[i]", (*it), (*jt));
	}
}

template<typename _Set> void assertSetObj(const wchar_t* sz, _Set arr, _Set arrR) {
	TASSERT(std::wstring(sz) + L".size", arr->size(), arrR->size());

	bool found = false;
	for (auto it = arr->begin(); it != arr->end() && !found; it++) {
		PPrimitiveTypes p = byps_ptr_cast<PrimitiveTypes>(*it);
		found = findObject(arrR, p->intVal);
	}
	TASSERT(std::wstring(sz) + L" sent obj not found", true, found);

	found = false;
	for (auto it = arrR->begin(); it != arrR->end() && !found; it++) {
		PPrimitiveTypes p = byps_ptr_cast<PrimitiveTypes>(*it);
		found = findObject(arr, p->intVal);
	}
	TASSERT(std::wstring(sz) + L" received obj obsolete", true, found);

}

const int8_t byte1 = 1;
const int8_t byte2 = 2;
const int8_t byte3 = 3;
const int8_t byte4 = 4;

const int16_t short1 = 11;
const int16_t short2 = 21;
const int16_t short3 = 31;
const int16_t short4 = 41;

const std::wstring string1 = L"11";
const std::wstring string2 = L"21";
const std::wstring string3 = L"31";
const std::wstring string4 = L"41";

class TestRemoteSetTypes : public TestBase {
public:


	void testPrimitiveTypes() {

        PRemoteSetTypes remote = client->remoteSetTypes;

		PSetTypes obj(new SetTypes());
		obj->boolean1 = toSet(true, false, false, true);
		obj->byte1 = toSet(byte1, byte2, byte3, byte4);
		obj->short1 = toSet(short1, short2, short3, short4);
		obj->int1 = toSet(111,222,333,444);
		obj->long1 = toSet(1111LL, 2222LL, 3333LL, 4444LL);
		obj->char1 = toSet(L'A', L'b', L'€', L'¶');
		obj->double1 = toSet(1.1,1.2,1.3,1.4);
		obj->float1 = toSet(11.1f, 22.2f, 33.3f, 44.4f);
		obj->string1 = toSet(string1, string2, string3, string4);
		obj->primitiveTypes1 = toSet(
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes());
		obj->obj1 = toSet(
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()));

		remote->setBoolean1(obj->boolean1);
		assertSet(L"boolean1", obj->boolean1, remote->getBoolean1());
		remote->setByte1(obj->byte1);
		assertSet(L"byte1", obj->byte1, remote->getByte1());
		remote->setChar1(obj->char1);
		assertSet(L"char1", obj->char1, remote->getChar1());
		remote->setDouble1(obj->double1);
		assertSet(L"double1", obj->double1, remote->getDouble1());
		remote->setFloat1(obj->float1);
		assertSet(L"float1", obj->float1, remote->getFloat1());
		remote->setInt1(obj->int1);
		assertSet(L"int1", obj->int1, remote->getInt1());
		remote->setLong1(obj->long1);
		assertSet(L"long1", obj->long1, remote->getLong1());

		remote->setShort1(obj->short1);
		assertSet(L"short1", obj->short1, remote->getShort1());
		remote->setString1(obj->string1);
		assertSet(L"string1", obj->string1, remote->getString1());

		{
			remote->setPrimitiveTypes1(obj->primitiveTypes1);
			byps_ptr< std::set< PPrimitiveTypes > > arrR = remote->getPrimitiveTypes1();
			
			assertSetObj(L"primitiveTypes1", obj->primitiveTypes1, arrR);

			for (auto it = arrR->begin(); it != arrR->end(); it++) {
				TestUtils::releasePrimitiveTypes(*it);
			}
		}

		{
			remote->setObj1(obj->obj1);
			byps_ptr< std::set< PSerializable > > arrR = remote->getObj1();
			
			assertSetObj(L"primitiveTypes1", obj->obj1, arrR);

			for (auto it = arrR->begin(); it != arrR->end(); it++) {
				TestUtils::releasePrimitiveTypes(byps_static_ptr_cast<PrimitiveTypes>(*it));
			}
		}

		for (auto it = obj->primitiveTypes1->begin(); it != obj->primitiveTypes1->end(); it++) {
			TestUtils::releasePrimitiveTypes(*it);
		}
		for (auto it = obj->obj1->begin(); it != obj->obj1->end(); it++) {
			TestUtils::releasePrimitiveTypes(byps_static_ptr_cast<PrimitiveTypes>(*it));
		}
	}



	virtual void init() {
		ADD_TEST(testPrimitiveTypes);
	}
};

TestCase* TestRemoteSetTypes_create() {
	return new TestRemoteSetTypes();
}
