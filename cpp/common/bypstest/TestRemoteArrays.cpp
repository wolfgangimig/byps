/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

#include "AllTests.h"

// only used for testing serialization performance in testRemoteArrayTypes1dimPerformance
#include "Testser-impl.h"

#include <string.h>


using namespace byps;
using namespace com::wilutions::test;

using namespace byps::test::api;
using namespace byps::test::api::prim;
using namespace byps::test::api::remote;
using namespace byps::test::api::inl;

using namespace std;
using namespace std::chrono;

template <typename _T> void assertArray(byps_ptr<BArray1<_T> > arr, byps_ptr<BArray1<_T> > arrR) {
	TASSERT(L"arr.length", arr->length(), arrR->length());
	for (unsigned i = 0; i < arr->length(); i++) {
		TASSERT(L"arr[i]", arr->at(i), arrR->at(i));
	}
}

template <typename _T> void assertArrayObject(byps_ptr<BArray1<_T> > arr, byps_ptr<BArray1<_T> > arrR) {
	TASSERT(L"arr.length", arr->length(), arrR->length());
	for (unsigned i = 0; i < arr->length(); i++) {
		TestUtils::tassert(__FILE__, __LINE__, L"arr[i]", 
			byps_ptr_cast<PrimitiveTypes>(arr->at(i)),
			byps_ptr_cast<PrimitiveTypes>(arrR->at(i))
		);
	}
}

void assertArrayPoint2D(byps_ptr<BArray1<Point2D> > arr, byps_ptr<BArray1<Point2D> > arrR) {
	TASSERT(L"arr.length", arr->length(), arrR->length());
	for (unsigned i = 0; i < arr->length(); i++) {
		TestUtils::tassert(__FILE__, __LINE__, L"arr[i]", 
			(arr->at(i)),
			(arrR->at(i))
		);
	}
}

class TestRemoteArrays : public TestBase {
	static BLogger log;
public:
	TestRemoteArrays(void* app) : TestBase(app) {}

	void internalTestRemoteArrayPrimitiveTypes() {

        PRemoteArrayTypes1dim remote = client->getRemoteArrayTypes1dim();

		std::vector<PPrimitiveTypes> vec;
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());

	    byps_ptr<BArray1<PPrimitiveTypes> > arr(new BArray1<PPrimitiveTypes>(vec));
	
		remote->setPrimitiveTypes(arr);
		byps_ptr<BArray1<PPrimitiveTypes> > arrR = remote->getPrimitiveTypes();

		TASSERT(L"arr.length", arr->length(), arrR->length());
		for (unsigned i = 0; i < arr->length(); i++) {
			TestUtils::tassert(__FILE__, __LINE__, L"arr[i]", 
				arr->at(i), 
				arrR->at(i)
			);
		}

		for (size_t i = 0; i < arr->length(); i++) {
			TestUtils::releasePrimitiveTypes(arr->at(i));
		}
		for (size_t i = 0; i < arrR->length(); i++) {
			TestUtils::releasePrimitiveTypes(arrR->at(i));
		}
	}

	void internalTestRemoteArrayObject() {

        PRemoteArrayTypes1dim remote = client->getRemoteArrayTypes1dim();

		std::vector<PSerializable> vec;
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());
		vec.push_back(TestUtils::createObjectPrimitiveTypes());

	    byps_ptr<BArray1<PSerializable> > arr(new BArray1<PSerializable>(vec));
	
		remote->setObject(arr);
		byps_ptr<BArray1<PSerializable> > arrR = remote->getObject();

		TASSERT(L"arr.length", arr->length(), arrR->length());
		for (unsigned i = 0; i < arr->length(); i++) {
			TestUtils::tassert(__FILE__, __LINE__, L"arr[i]", 
				byps_static_ptr_cast<PrimitiveTypes>(arr->at(i)), 
				byps_static_ptr_cast<PrimitiveTypes>(arrR->at(i))
			);
		}

		for (size_t i = 0; i < arr->length(); i++) {
			TestUtils::releasePrimitiveTypes(byps_static_ptr_cast<PrimitiveTypes>(arr->at(i)));
		}
		for (size_t i = 0; i < arrR->length(); i++) {
			TestUtils::releasePrimitiveTypes(byps_static_ptr_cast<PrimitiveTypes>(arrR->at(i)));
		}
	}

	void internalTestRemoteArrayTypes1dimString() {
        PRemoteArrayTypes1dim remote = client->getRemoteArrayTypes1dim();

	    byps_ptr<BArray1<std::wstring> > arr(new BArray1<std::wstring>(3));
		arr->at(0) = L"ABC";
		arr->at(1) = L"€€€";
		arr->at(2) = L"¶\0\r\n%";

		remote->setString(arr);
		byps_ptr<BArray1<std::wstring> > arrR = remote->getString();
		assertArray(arr, arrR);
	}

	void internalTestRemoteArrayTypes1dimDate() {
        PRemoteArrayTypes1dim remote = client->getRemoteArrayTypes1dim();

	    byps_ptr<BArray1<BDateTime> > arr(new BArray1<BDateTime>(3));
		arr->at(0) = BDateTime(1600, 01, 01, 00, 00, 00, 000);
		arr->at(1) = BDateTime();
		arr->at(2) = BDateTime(1900, 01, 01, 00, 00, 00, 000);

		remote->setDate(arr);
		byps_ptr<BArray1<BDateTime> > arrR = remote->getDate();
		assertArray(arr, arrR);
	}

	void testRemoteArrayTypes1dim() {
        PRemoteArrayTypes1dim remote = client->getRemoteArrayTypes1dim();
		
		l_info << L"bool...";
		{
			bool elms[] = {true, false, true};
			byps_ptr<BArray1<bool> > arr(new BArray1<bool>(elms, elms + 3));
			remote->setBool(arr);
			byps_ptr<BArray1<bool> > arrR = remote->getBool();
			assertArray(arr, arrR);
		}

		l_info << L"byte...";
		{
			int8_t elms[] = { '1', '2', '3', '4', '5' };
			PBytes arr = BBytes::create(sizeof(elms));
			memcpy(arr->data, elms, sizeof(elms));
			remote->setByte(arr);

			PBytes arrR = remote->getByte();
			TASSERT(L"arr.length", arr->length, arrR->length);
			
			TASSERT(L"arr[i]", 0, memcmp(arr->data, arrR->data, arr->length));
		}

		l_info << L"wchar...";
		{
			wchar_t elms[] = { L'1', L'€', L'+', L'\0', L'¶' };
			byps_ptr<BArray1<wchar_t> > arr(new BArray1<wchar_t>(elms, elms + 5));
			remote->setChar(arr);
			byps_ptr<BArray1<wchar_t> > arrR = remote->getChar();
			assertArray(arr, arrR);
		}

		l_info << L"short...";
		{
			int16_t elms[] = { 1,2,3,4,5,6,7 };
			byps_ptr<BArray1<int16_t> > arr(new BArray1<int16_t>(elms, elms+7));
			remote->setShort(arr);
			byps_ptr<BArray1<int16_t> > arrR = remote->getShort();
			assertArray(arr, arrR);
		}

		l_info << L"int...";
		{
			int32_t elms[] = {  1,2,3,4 };
			byps_ptr<BArray1<int32_t> > arr(new BArray1<int32_t>(elms, elms+4));
			remote->setInt(arr);
			byps_ptr<BArray1<int32_t> > arrR = remote->getInt();
			assertArray(arr, arrR);
		}

		l_info << L"float...";
		{
			float elms[] = { 1.1f, 1.2f, 1.4f };
			std::vector<float> vec(elms, elms + 3);
			byps_ptr<BArray1<float> > arr(new BArray1<float>(vec));
			remote->setFloat(arr);
			byps_ptr<BArray1<float> > arrR = remote->getFloat();
			assertArray(arr, arrR);
		}

		l_info << L"double...";
		{
			const double elms[] = { 1.1, 1.2, 1.4 };
			byps_ptr<BArray1<double> > arr(new BArray1<double>(elms, elms+3));
			remote->setDouble(arr);
			byps_ptr<BArray1<double> > arrR = remote->getDouble();
			assertArray(arr, arrR);
		}

		internalTestRemoteArrayTypes1dimString();
		internalTestRemoteArrayTypes1dimDate();
		internalTestRemoteArrayPrimitiveTypes();
		internalTestRemoteArrayObject();
	}

	std::wstring createString(size_t v) { 
		std::wstringstream wss; wss << v; 
		return wss.str();
	}

	void testRemoteArrayTypes23() {
		PRemoteArrayTypes23 remote = client->getRemoteArrayTypes23();

		if (true)
		{
			byps_ptr<BArray1<int32_t> > arr1(new BArray1<int32_t>(3));
			byps_ptr<BArray2<int32_t> > arr2(new BArray2<int32_t>(7,6));
			byps_ptr<BArray3<int32_t> > arr3(new BArray3<int32_t>(7,5,3));
			byps_ptr<BArray4<int32_t> > arr4(new BArray4<int32_t>(3,4,6,7));

			for (size_t i2 = 0; i2 < arr2->length1(); i2++) 
				for (size_t i1 = 0; i1 < arr2->length0(); i1++)
					arr2->at(i2,i1) = (int32_t)(i2+i1);
			for (size_t i3 = 0; i3 < arr3->length2(); i3++) 
				for (size_t i2 = 0; i2 < arr3->length1(); i2++) 
					for (size_t i1 = 0; i1 < arr3->length0(); i1++)
						arr3->at(i3,i2,i1) = (int32_t)(i3+i2+i1);
			for (size_t i4 = 0; i4 < arr4->length3(); i4++) 
				for (size_t i3 = 0; i3 < arr4->length2(); i3++) 
					for (size_t i2 = 0; i2 < arr4->length1(); i2++) 
						for (size_t i1 = 0; i1 < arr4->length0(); i1++)
							arr4->at(i4,i3,i2,i1) = (int32_t)(i4+i3+i2+i1);
			
			arr1->at(0) = arr2->at(1,1);
			arr1->at(1) = arr3->at(1,1,1);
			arr1->at(2) = arr4->at(1,1,1,1);

			PArrayInt arrR = remote->sendArraysInt(arr2, arr3, arr4);
			assertArray(arr1, arrR);
		}

		if (true)
		{
			byps_ptr<BArray1<std::wstring> > arr1(new BArray1<std::wstring>(3));
			byps_ptr<BArray2<std::wstring> > arr2(new BArray2<std::wstring>(7,6));
			byps_ptr<BArray3<std::wstring> > arr3(new BArray3<std::wstring>(7,5,3));
			byps_ptr<BArray4<std::wstring> > arr4(new BArray4<std::wstring>(3,4,6,7));

			for (size_t i2 = 0; i2 < arr2->length1(); i2++) 
				for (size_t i1 = 0; i1 < arr2->length0(); i1++)
					arr2->at(i2,i1) = createString(i2+i1);
			for (size_t i3 = 0; i3 < arr3->length2(); i3++) 
				for (size_t i2 = 0; i2 < arr3->length1(); i2++) 
					for (size_t i1 = 0; i1 < arr3->length0(); i1++)
						arr3->at(i3,i2,i1) = createString(i3+i2+i1);
			for (size_t i4 = 0; i4 < arr4->length3(); i4++) 
				for (size_t i3 = 0; i3 < arr4->length2(); i3++) 
					for (size_t i2 = 0; i2 < arr4->length1(); i2++) 
						for (size_t i1 = 0; i1 < arr4->length0(); i1++)
							arr4->at(i4,i3,i2,i1) = createString(i4+i3+i2+i1);
			
			arr1->at(0) = arr2->at(1,1);
			arr1->at(1) = arr3->at(1,1,1);
			arr1->at(2) = arr4->at(1,1,1,1);

			PArrayString arrR = remote->sendArraysString(arr2, arr3, arr4);
			assertArray(arr1, arrR);
		}

		if (true)
		{
			byps_ptr<BArray1<PPrimitiveTypes> > arr1(new BArray1<PPrimitiveTypes>(3));
			byps_ptr<BArray2<PPrimitiveTypes> > arr2(new BArray2<PPrimitiveTypes>(7,6));
			byps_ptr<BArray3<PPrimitiveTypes> > arr3(new BArray3<PPrimitiveTypes>(7,5,3));
			byps_ptr<BArray4<PPrimitiveTypes> > arr4(new BArray4<PPrimitiveTypes>(3,4,6,7));

			for (size_t i2 = 0; i2 < arr2->length1(); i2++) 
				for (size_t i1 = 0; i1 < arr2->length0(); i1++)
					arr2->at(i2,i1) = TestUtils::createObjectPrimitiveTypes();
			for (size_t i3 = 0; i3 < arr3->length2(); i3++) 
				for (size_t i2 = 0; i2 < arr3->length1(); i2++) 
					for (size_t i1 = 0; i1 < arr3->length0(); i1++)
						arr3->at(i3,i2,i1) = TestUtils::createObjectPrimitiveTypes();
			for (size_t i4 = 0; i4 < arr4->length3(); i4++) 
				for (size_t i3 = 0; i3 < arr4->length2(); i3++) 
					for (size_t i2 = 0; i2 < arr4->length1(); i2++) 
						for (size_t i1 = 0; i1 < arr4->length0(); i1++)
							arr4->at(i4,i3,i2,i1) = TestUtils::createObjectPrimitiveTypes();
			
			arr1->at(0) = arr2->at(1,1);
			arr1->at(1) = arr3->at(1,1,1);
			arr1->at(2) = arr4->at(1,1,1,1);

			byps_ptr<BArray1<PPrimitiveTypes> > arrR = remote->sendArraysClass(arr2, arr3, arr4);
			assertArrayObject(arr1, arrR);
		}

		if (true)
		{
			byps_ptr<BArray1<PSerializable> > arr1(new BArray1<PSerializable>(3));
			byps_ptr<BArray2<PSerializable> > arr2(new BArray2<PSerializable>(7,6));
			byps_ptr<BArray3<PSerializable> > arr3(new BArray3<PSerializable>(7,5,3));
			byps_ptr<BArray4<PSerializable> > arr4(new BArray4<PSerializable>(3,4,6,7));

			for (size_t i2 = 0; i2 < arr2->length1(); i2++) 
				for (size_t i1 = 0; i1 < arr2->length0(); i1++)
					arr2->at(i2,i1) = TestUtils::createObjectPrimitiveTypes();
			for (size_t i3 = 0; i3 < arr3->length2(); i3++) 
				for (size_t i2 = 0; i2 < arr3->length1(); i2++) 
					for (size_t i1 = 0; i1 < arr3->length0(); i1++)
						arr3->at(i3,i2,i1) = TestUtils::createObjectPrimitiveTypes();
			for (size_t i4 = 0; i4 < arr4->length3(); i4++) 
				for (size_t i3 = 0; i3 < arr4->length2(); i3++) 
					for (size_t i2 = 0; i2 < arr4->length1(); i2++) 
						for (size_t i1 = 0; i1 < arr4->length0(); i1++)
							arr4->at(i4,i3,i2,i1) = TestUtils::createObjectPrimitiveTypes();
			
			arr1->at(0) = arr2->at(1,1);
			arr1->at(1) = arr3->at(1,1,1);
			arr1->at(2) = arr4->at(1,1,1,1);

			byps_ptr<BArray1<PSerializable> > arrR = remote->sendArraysObject(arr2, arr3, arr4);
			assertArrayObject(arr1, arrR);
		}

		if (true)
		{
			byps_ptr<BArray1<Point2D> > arr1(new BArray1<Point2D>(3));
			byps_ptr<BArray2<Point2D> > arr2(new BArray2<Point2D>(7,6));
			byps_ptr<BArray3<Point2D> > arr3(new BArray3<Point2D>(7,5,3));
			byps_ptr<BArray4<Point2D> > arr4(new BArray4<Point2D>(3,4,6,7));

			for (size_t i2 = 0; i2 < arr2->length1(); i2++) 
				for (size_t i1 = 0; i1 < arr2->length0(); i1++)
					arr2->at(i2,i1) = TestUtils::createPoint2D();
			for (size_t i3 = 0; i3 < arr3->length2(); i3++) 
				for (size_t i2 = 0; i2 < arr3->length1(); i2++) 
					for (size_t i1 = 0; i1 < arr3->length0(); i1++)
						arr3->at(i3,i2,i1) = TestUtils::createPoint2D();
			for (size_t i4 = 0; i4 < arr4->length3(); i4++) 
				for (size_t i3 = 0; i3 < arr4->length2(); i3++) 
					for (size_t i2 = 0; i2 < arr4->length1(); i2++) 
						for (size_t i1 = 0; i1 < arr4->length0(); i1++)
							arr4->at(i4,i3,i2,i1) = TestUtils::createPoint2D();
			
			arr1->at(0) = arr2->at(1,1);
			arr1->at(1) = arr3->at(1,1,1);
			arr1->at(2) = arr4->at(1,1,1,1);

			byps_ptr<BArray1<Point2D> > arrR = remote->sendArraysInline(arr2, arr3, arr4);
			assertArrayPoint2D(arr1, arrR);
		}

	}

	/**
	 * Execute this test outside of Visual Studio.
	 * It runs much slower if started from Visual Studio.
	 */
	void testRemoteArrayTypes1dimPerformance()  {
		int loopCount = 100;
		int flags = 0;
		internalTestPerformance(flags, loopCount, 10);
		//internalTestPerformance(flags, loopCount, 100);
		//internalTestPerformance(flags, loopCount, 1000);

		//internalTestPerformanceSerialize(loopCount, 1000);
	}

	void internalTestPerformanceSerialize(int loopCount, int objCount) {

		byps_ptr<BArray1<PPrimitiveTypes> > primitiveTypes1(new BArray1<PPrimitiveTypes>(objCount));
		for (unsigned i = 0; i < primitiveTypes1->length(); i++) {
			primitiveTypes1->at(i) = TestUtils::createObjectPrimitiveTypes();
		}

		time_point<system_clock> t1, t2, t3, t4;

		//t1 = system_clock::now();

		//BTYPEID typeId = 0;
		//size_t n = 0;
		//BRegistry* reg = client->transport->apiDesc->registry.get();
		//for (int j = 0; j < loopCount; j++) {
		//	POutput outp = client->transport->getOutput();
		//	for (int i = 0; i < objCount; i++) {
		//		PSerializable ptr(primitiveTypes1->at(i));

		//		BSERIALIZER ser = NULL;
		//		if (typeId == 0) {
		//			const std::type_info& tinfo = typeid(*ptr.get());
		//			ser = client->transport->apiDesc->registry->getSerializer(tinfo, typeId);
		//		}
		//		else {
		//			ser = reg->getSerializer(typeId);
		//		}

		//		POBJECT obj = ptr;
		//		ser(*outp, obj, NULL);
		//	}
		//	n += outp->toMessage()->buf->length;
		//}

		//l_info << L"n=" << n;

		//t2 = system_clock::now();

		t1 = system_clock::now();

		size_t n = 0;

		for (int i = 0; i < loopCount; i++) {
			POutput outp = client->getTransport()->getOutput();
			PSerializable req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(primitiveTypes1));
			outp->store(req);

			PMessage msg = outp->toMessage();

			PInput inp = client->getTransport()->getInput(msg->header, msg->buf);
			PSerializable resp = inp->load();

			n += resp->BSerializable_getTypeId();
		}

		t2 = system_clock::now();

		l_info <<
				L", #objs=" << objCount << 
				L", #loops=" << loopCount <<
				L", ms=" << duration_cast<milliseconds>(t2 - t1).count();

	}

	void internalTestPerformance(int flags, int loopCount, int objCount) {

		PClient_Testser client = TestUtilHttp::createClient(app);
		
		byps_ptr<BArray1<PPrimitiveTypes> > primitiveTypes1(new BArray1<PPrimitiveTypes>(objCount));
		for (unsigned i = 0; i < primitiveTypes1->length(); i++) {
			primitiveTypes1->at(i) = TestUtils::createObjectPrimitiveTypes();
		}


		time_point<system_clock> t1, t2, t3, t4;

		t1 = system_clock::now();
		for (int i = 0; i < loopCount; i++) {
			client->getRemoteArrayTypes1dim()->setPrimitiveTypes(primitiveTypes1);
		}
		t2 = system_clock::now();

		t3 = system_clock::now();
		for (int i = 0; i < loopCount; i++) {
			client->getRemoteArrayTypes1dim()->getPrimitiveTypes();
		}
		t4 = system_clock::now();

		client->done();
        client.reset();

		l_info <<
				L"gzip=" << flags << 
				L", #objs=" << objCount << 
				L", #loops=" << loopCount <<
				L", call-ms=" << duration_cast<milliseconds>(t2 - t1).count() + duration_cast<milliseconds>(t4 - t3).count() << 
				L"/" << duration_cast<milliseconds>(t2 - t1).count() << 
				L"/" << duration_cast<milliseconds>(t4 - t3).count();
		
	}

	virtual void init() {
		ADD_TEST(testRemoteArrayTypes23);
		ADD_TEST(testRemoteArrayTypes1dim);
        ADD_TEST(testRemoteArrayTypes1dimPerformance);
	}
};

BLogger TestRemoteArrays::log("TestRemoteArrays");

TestCase* TestRemoteArrays_create(void* app) {
	return new TestRemoteArrays(app);
}
