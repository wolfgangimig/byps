#include "AllTests.h"


using namespace byps;
using namespace com::wilutions::test;

using namespace byps::test::api;
using namespace byps::test::api::prim;
using namespace byps::test::api::list;
using namespace byps::test::api::remote;

template <typename _Type> byps_ptr<std::vector< _Type > > toVector(_Type a, _Type b, _Type c, _Type d) {
	byps_ptr<std::vector<_Type> > vec(new std::vector<_Type>());
	vec->push_back(a);
	vec->push_back(b);
	vec->push_back(c);
	vec->push_back(d);
	return vec;
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

class TestRemoteListTypes : public TestBase {
public:
	TestRemoteListTypes(void* app) : TestBase(app) {}

	void testPrimitiveTypes() {

        PRemoteListTypes remote = client->remoteListTypes;

		PListTypes obj(new ListTypes());
		obj->boolean1 = toVector(true, false, false, true);
		obj->byte1 = toVector(byte1, byte2, byte3, byte4);
		obj->short1 = toVector(short1, short2, short3, short4);
		obj->int1 = toVector(111,222,333,444);
        obj->long1 = toVector((int64_t)1111LL, (int64_t)2222LL, (int64_t)3333LL, (int64_t)4444LL);
		obj->char1 = toVector(L'A', L'b', L'€', L'¶');
		obj->double1 = toVector(1.1,1.2,1.3,1.4);
		obj->float1 = toVector(11.1f, 22.2f, 33.3f, 44.4f);
		obj->string1 = toVector(string1, string2, string3, string4);
		obj->primitiveTypes1 = toVector(
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes(),
			TestUtils::createObjectPrimitiveTypes());
		obj->obj1 = toVector(
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()),
			byps_static_ptr_cast<BSerializable>(TestUtils::createObjectPrimitiveTypes()));

		remote->setBoolean1(obj->boolean1);
		TASSERT(L"boolean1", obj->boolean1, remote->getBoolean1());
		remote->setByte1(obj->byte1);
		TASSERT(L"byte1", obj->byte1, remote->getByte1());
		remote->setChar1(obj->char1);
		TASSERT(L"char1", obj->char1, remote->getChar1());
		remote->setDouble1(obj->double1);
		TASSERT(L"double1", obj->double1, remote->getDouble1());
		remote->setFloat1(obj->float1);
		TASSERT(L"float1", obj->float1, remote->getFloat1());
		remote->setInt1(obj->int1);
		TASSERT(L"int1", obj->int1, remote->getInt1());
		remote->setLong1(obj->long1);
		TASSERT(L"long1", obj->long1, remote->getLong1());

		remote->setShort1(obj->short1);
		TASSERT(L"short1", obj->short1, remote->getShort1());
		remote->setString1(obj->string1);
		TASSERT(L"string1", obj->string1, remote->getString1());

		{
			remote->setPrimitiveTypes1(obj->primitiveTypes1);
			byps_ptr< std::vector< PPrimitiveTypes > > vec = remote->getPrimitiveTypes1();
			TASSERT(L"primitiveTypes1.size", obj->primitiveTypes1->size(), vec->size());
			for (unsigned i = 0; i < obj->primitiveTypes1->size(); i++) {
				PPrimitiveTypes e = byps_ptr_cast<PrimitiveTypes>((*obj->primitiveTypes1)[i]);
				PPrimitiveTypes r = byps_ptr_cast<PrimitiveTypes>((*vec)[i]);
				TestUtils::tassert(__FILE__, __LINE__, L"primitiveTypes1[i]", e, r);
			}			

			for (auto it = vec->begin(); it != vec->end(); it++) {
				TestUtils::releasePrimitiveTypes(*it);
			}
		}

		{
			remote->setObj1(obj->obj1);
			byps_ptr< std::vector< PSerializable > > vec = remote->getObj1();
			TASSERT(L"obj1.size", obj->obj1->size(), vec->size());
			for (unsigned i = 0; i < obj->obj1->size(); i++) {
				PPrimitiveTypes e = byps_ptr_cast<PrimitiveTypes>((*obj->obj1)[i]);
				PPrimitiveTypes r = byps_ptr_cast<PrimitiveTypes>((*vec)[i]);
				TestUtils::tassert(__FILE__, __LINE__, L"obj[i]", e, r);
			}			

			for (auto it = vec->begin(); it != vec->end(); it++) {
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


	void testRemoteListListInteger() {
		
		PRemoteListTypes remote = client->remoteListTypes;

		auto obj =  byps_ptr< std::vector< byps_ptr< std::vector< int32_t > > > >(new  std::vector< byps_ptr< std::vector< int32_t > > >());

		for (int i = 0; i < 3; i++) {
			byps_ptr< std::vector< int32_t > > itemList(new std::vector< int32_t >());
			for (int j = 0; j < i+1; j++) {
				itemList->push_back(j);
			}
			obj->push_back(itemList);
		}
		
		remote->setInt3(obj);

		auto objR = remote->getInt3();
		
		TASSERT(L"obj.size", obj->size(), objR->size());
		for (unsigned i = 0; i < obj->size(); i++) {
			auto vec = (*obj)[i];
			auto vecR = (*objR)[i];
			TASSERT(L"vec.size", vec->size(), vecR->size());
			for (unsigned j = 0; j < vec->size(); j++) {
				TASSERT(L"vec[i]", (*vec)[i], (*vecR)[i]);
			}
		}
		
	}

	void testRemoteListMapSetListInteger() {
		
		PRemoteListTypes remote = client->remoteListTypes;

		byps_ptr< std::vector< byps_ptr< std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > > > > > obj(
			new std::vector< byps_ptr< std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > > > > ());

		for (int i = 0; i < 2; i++) {

			byps_ptr< std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > > > map(
				new std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > >());

			for (int j = 0; j < 3; j++) {

				byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > list3(
					new std::vector< byps_ptr< std::set< int32_t > > >());

				for (int k = 0; k < 4; k++) {
					byps_ptr< std::set< int32_t > > set(
						new std::set< int32_t >());

					for (int n = 0; n < 5; n++) {
						int32_t pt = (i+1) * (j+1) * (k+1) * (n+1);
						set->insert(std::set< int32_t >::value_type(pt));
					}

					list3->push_back(set);
				}
				
				(*map)[j] = list3;
			}

			obj->push_back(map);
		}

		remote->setInt4(obj);

		auto objR = remote->getInt4();
		
		TASSERT(L"obj.size", obj->size(), objR->size());
		for (unsigned i = 0; i < obj->size(); i++) {
			auto map = (*obj)[i];
			auto mapR = (*objR)[i];
			TASSERT(L"map.size", map->size(), mapR->size());
			for (auto it = map->begin(); it != map->end(); it++) {
				auto itR = mapR->find((*it).first);
				TASSERT(L"map value found", true, (itR != mapR->end()));

				auto list = (*it).second;
				auto listR = (*itR).second;
				TASSERT(L"list.size", list->size(), listR->size());
				for (unsigned i = 0; i < list->size(); i++) {

					auto set = (*list)[i];
					auto setR = (*listR)[i];
					TASSERT(L"set.size", set->size(), setR->size());
					for (auto st = set->begin(); st != set->end(); st++) {
						auto stR = setR->find(*st);
						TASSERT(L"set value found", true, stR != setR->end());
					}
					for (auto stR = set->begin(); stR != set->end(); stR++) {
						auto st = set->find(*stR);
						TASSERT(L"set value found", true, st != set->end());
					}
				}

			}
			for (auto itR = mapR->begin(); itR != mapR->end(); itR++) {
				auto it = map->find((*itR).first);
				TASSERT(L"map value found", true, (it != map->end()));
			}
		}
		
		
	}


	virtual void init() {
		ADD_TEST(testPrimitiveTypes);
		ADD_TEST(testRemoteListListInteger);
		ADD_TEST(testRemoteListMapSetListInteger);
	}
};

TestCase* TestRemoteListTypes_create(void* app) {
	return new TestRemoteListTypes(app);
}
