#ifndef TESTUTILS_H_
#define TESTUTILS_H_

#include "Byps.h"
#include "testfw.h"
#include "Testser-api.h"

class TestUtils {
public:
	static com::wilutions::byps::test::api::prim::PPrimitiveTypes createObjectPrimitiveTypes();
	static void releasePrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes p);

	static int16_t x;
	static com::wilutions::byps::test::api::inl::Point2D createPoint2D();

	static void tassert(const char* file, int line, 
		const std::wstring& msg, 
		com::wilutions::byps::test::api::prim::PPrimitiveTypes expectedValue, 
		com::wilutions::byps::test::api::prim::PPrimitiveTypes readValue);

	static void tassert(const char* file, int line, 
						const std::wstring& msg, 
						const com::wilutions::byps::test::api::inl::Point2D& e1, 
						const com::wilutions::byps::test::api::inl::Point2D& r2);
};

#endif