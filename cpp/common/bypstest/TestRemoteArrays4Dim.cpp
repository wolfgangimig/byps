#include "AllTests.h"


using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::prim;
using namespace com::wilutions::byps::test::api::remote;



template <typename _T> void assertArray(byps_ptr<BArray4<_T> > arr, byps_ptr<BArray4<_T> > arrR) {
	TASSERT(L"arr.length3", arr->length3(), arrR->length3());
	for (size_t i3 = 0; i3 < arr->length3(); i3++) {
	TASSERT(L"arr.length2", arr->length2(), arrR->length2());
	for (size_t i2 = 0; i2 < arr->length2(); i2++) {
	TASSERT(L"arr.length1", arr->length1(), arrR->length1());
	for (size_t i1 = 0; i1 < arr->length1(); i1++) {
	TASSERT(L"arr.length0", arr->length0(), arrR->length0());
	for (size_t i0 = 0; i0 < arr->length0(); i0++) {
		TASSERT(L"arr[i]", 
			arr->at(i3, i2, i1, i0), 
			arrR->at(i3, i2, i1, i0)
		);
	}
	}
	}
	}
}

class TestRemoteArrays4Dim : public TestBase {
	static BLogger log;
public:

	void testRemoteArray4DimPrimitiveTypes() {

        PRemoteArrayTypes4dim remote = client->remoteArrayTypes4dim;

		byps_ptr<BArray4<PPrimitiveTypes> > arr(new BArray4<PPrimitiveTypes>(3,4,5,6));

		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			arr->at(i3, i2, i1, i0) = TestUtils::createObjectPrimitiveTypes();
		}}}}

		remote->setPrimitiveTypes(arr);
		byps_ptr<BArray4<PPrimitiveTypes> > arrR = remote->getPrimitiveTypes();

		TASSERT(L"arr.length3", arr->length3(), arrR->length3());
		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		TASSERT(L"arr.length2", arr->length2(), arrR->length2());
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		TASSERT(L"arr.length1", arr->length1(), arrR->length1());
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		TASSERT(L"arr.length0", arr->length0(), arrR->length0());
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			TestUtils::tassert(__FILE__, __LINE__, L"arr[i]", 
				arr->at(i3, i2, i1, i0), 
				arrR->at(i3, i2, i1, i0)
			);
		}}}}


		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			TestUtils::releasePrimitiveTypes( arr->at(i3, i2, i1, i0) );
			TestUtils::releasePrimitiveTypes( arrR->at(i3, i2, i1, i0) );
		}}}}

	}

	void testRemoteArrayTypes4DimString() {
        PRemoteArrayTypes4dim remote = client->remoteArrayTypes4dim;

	    byps_ptr<BArray4<std::wstring> > arr(new BArray4<std::wstring>(5,1,5,1));

		for (size_t i3 = 0; i3 < arr->length3(); i3++) {
		for (size_t i2 = 0; i2 < arr->length2(); i2++) {
		for (size_t i1 = 0; i1 < arr->length1(); i1++) {
		for (size_t i0 = 0; i0 < arr->length0(); i0++) {
			std::wstringstream wss; 
			wss << i3 << i2 << i1 << i0;
			arr->at(i3, i2, i1, i0) = wss.str();
		}}}}

		remote->setString(arr);
		byps_ptr<BArray4<std::wstring> > arrR = remote->getString();

		assertArray(arr, arrR);
	}


	virtual void init() {
		ADD_TEST(testRemoteArray4DimPrimitiveTypes);
		ADD_TEST(testRemoteArrayTypes4DimString);
	}
};

BLogger TestRemoteArrays4Dim::log("TestRemoteArrays4Dim");

TestCase* TestRemoteArrays4Dim_create() {
	return new TestRemoteArrays4Dim();
}