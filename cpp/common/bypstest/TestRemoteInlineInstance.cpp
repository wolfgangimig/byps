#include "AllTests.h"


using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::inl;
using namespace com::wilutions::byps::test::api::remote;

class TestRemoteInlineInstance : public TestBase {
	static BLogger log;

public:
	TestRemoteInlineInstance(void* app) : TestBase(app) {}

	PActor createActor() {
		PActor obj(new Actor());
		obj->shape = byps_ptr<BArray1<Point2D> >(new BArray1<Point2D>(3));
		for (size_t i = 0; i < obj->shape->length(); i++) {
			obj->shape->at(i) = TestUtils::createPoint2D();
		}
		obj->position._11 = 11;
		obj->position._12 = 12;
		obj->position._13 = 13;
		obj->position._21 = 21;
		obj->position._22 = 22;
		obj->position._23 = 23;
		obj->position._31 = 31;
		obj->position._32 = 32;
		obj->position._33 = 33;
		
		return obj;
	}

	void assertEquals(const std::wstring& msg, PActor value, PActor valueR) {
		assertEquals(msg + L".position", value->position, valueR->position);
		TASSERT(msg + L".shape.length", value->shape->length(), valueR->shape->length());
		for (size_t i = 0; i < value->shape->length(); i++) {
			assertEquals(msg + L".shape[i]", value->shape->at(i), valueR->shape->at(i));
		}
	}

	void assertEquals(const std::wstring& msg, const Point2D& value, const Point2D& valueR) {
		TASSERT(msg + L".x", value.x, valueR.x);
		TASSERT(msg + L".y", value.y, valueR.y);
	}

	void assertEquals(const std::wstring& msg, const Matrix2D& value, const Matrix2D& valueR) {
		TASSERT(msg + L"._xy", value._11, valueR._11);
		TASSERT(msg + L"._xy", value._12, valueR._12);
		TASSERT(msg + L"._xy", value._13, valueR._13);
		TASSERT(msg + L"._xy", value._21, valueR._21);
		TASSERT(msg + L"._xy", value._22, valueR._22);
		TASSERT(msg + L"._xy", value._23, valueR._23);
		TASSERT(msg + L"._xy", value._31, valueR._31);
		TASSERT(msg + L"._xy", value._32, valueR._32);
		TASSERT(msg + L"._xy", value._33, valueR._33);

	}

	void testRemoteInlineInstance() {

        PRemoteInlineInstance remote = client->remoteInlineInstance;

		PActor actor = createActor();
		remote->setActor(actor);
		
		assertEquals(L"actor", actor, remote->getActor());
	}

	void testRemoteInlineInstanceArray1dim() {

        PRemoteInlineInstance remote = client->remoteInlineInstance;

		byps_ptr<BArray1<Point2D> > arr(new BArray1<Point2D>(2));
		for (size_t i = 0; i < arr->length(); i++) {
			arr->at(i) = TestUtils::createPoint2D();
		}

		remote->setPoint2DArray1dim(arr);

		byps_ptr<BArray1<Point2D> > arrR = remote->getPoint2DArray1dim();
		
		TASSERT(L"arr.length", arr->length(), arrR->length());
		for (size_t i = 0; i < arr->length(); i++) {
			assertEquals(L"[i]", arr->at(i), arrR->at(i));
		}

	}

	void testRemoteInlineInstanceArray4Dim() {

        PRemoteInlineInstance remote = client->remoteInlineInstance;

		byps_ptr<BArray4<Point2D> > arr(new BArray4<Point2D>(2,3,1,1));
		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			arr->at(i3, i2, i1, i0) = TestUtils::createPoint2D();
		}}}}

		remote->setPoint2DArray4dim(arr);

		byps_ptr<BArray4<Point2D> > arrR = remote->getPoint2DArray4dim();
		
		TASSERT(L"arr.length3", arr->length3(), arrR->length3());
		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		TASSERT(L"arr.length2", arr->length2(), arrR->length2());
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		TASSERT(L"arr.length1", arr->length1(), arrR->length1());
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		TASSERT(L"arr.length0", arr->length0(), arrR->length0());
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			assertEquals(L"arr[i]", 
				arr->at(i3, i2, i1, i0), 
				arrR->at(i3, i2, i1, i0)
			);
		}
		}
		}
		}
	}

	void testRemoteInlineInstanceList() {
		PRemoteInlineInstance remote = client->remoteInlineInstance;
		byps_ptr<std::vector<Point2D> > vec(new std::vector<Point2D>());
		vec->push_back(TestUtils::createPoint2D());
		vec->push_back(TestUtils::createPoint2D());
		remote->setPoint2DList(vec);
		byps_ptr<std::vector<Point2D> > vecR = remote->getPoint2DList();
		TASSERT(L"vec.size", vec->size(), vecR->size());
		for (unsigned i = 0; i < vec->size(); i++) {
			assertEquals(L"[i]", vec->at(i), vecR->at(i));
		}
	}

	void testRemoteInlineInstanceListList() {
		PRemoteInlineInstance remote = client->remoteInlineInstance;
		byps_ptr<std::vector<Point2D> > vec(new std::vector<Point2D>());
		vec->push_back(TestUtils::createPoint2D());
		vec->push_back(TestUtils::createPoint2D());
		byps_ptr<std::vector<byps_ptr<std::vector<Point2D> > > > vecvec(new std::vector<byps_ptr<std::vector<Point2D> > >());
		vecvec->push_back(vec);

		remote->setPoint2DListList(vecvec);
		byps_ptr<std::vector<byps_ptr<std::vector<Point2D> > > > vecvecR = remote->getPoint2DListList();
		TASSERT(L"vecvec.size", vecvec->size(), vecvecR->size());
		for (unsigned i = 0; i < vecvec->size(); i++) {
			byps_ptr<std::vector<Point2D> > vec = vecvec->at(i);
			byps_ptr<std::vector<Point2D> > vecR = vecvecR->at(i);
			TASSERT(L"vec.size", vec->size(), vecR->size());
			for (unsigned i = 0; i < vec->size(); i++) {
				assertEquals(L"[i]", vec->at(i), vecR->at(i));
			}
		}
	}

	void testRemoteInlineInstanceMap() {
		PRemoteInlineInstance remote = client->remoteInlineInstance;
		byps_ptr<std::map<int32_t, Point2D> > map(new std::map<int32_t, Point2D>());
		(*map)[11] = TestUtils::createPoint2D();
		(*map)[12] = TestUtils::createPoint2D();
		remote->setPoint2DMap(map);
		byps_ptr<std::map<int32_t, Point2D> > mapR = remote->getPoint2DMap();
		TASSERT(L"map.size", map->size(), mapR->size());
		for (std::map<int32_t, Point2D>::iterator it = map->begin(); it != map->end(); it++) {
			int32_t key = (*it).first;
			Point2D value = (*it).second;
			Point2D valueR = (*mapR)[key];
			assertEquals(L"[i]", value, valueR);
		}
	}

	virtual void init() {
		ADD_TEST(testRemoteInlineInstance);
		ADD_TEST(testRemoteInlineInstanceArray1dim);
		ADD_TEST(testRemoteInlineInstanceArray4Dim);
		ADD_TEST(testRemoteInlineInstanceList);
		ADD_TEST(testRemoteInlineInstanceListList);
		ADD_TEST(testRemoteInlineInstanceMap);
	}
};

BLogger TestRemoteInlineInstance::log("TestRemoteInlineInstance");

TestCase* TestRemoteInlineInstance_create(void* app) {
	return new TestRemoteInlineInstance(app);
}