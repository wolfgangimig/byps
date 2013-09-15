
#include "TestUtils.h"
#include "testfw.h"

using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::prim;
using namespace com::wilutions::byps::test::api::remote;
using namespace com::wilutions::byps::test::api::inl;

PPrimitiveTypes internalCreateObjectPrimitiveTypes() {

    static int createCount = 1;

    PPrimitiveTypes p(new PrimitiveTypes());
    p->boolVal = (createCount & 1) != 0;
    p->intVal = ++createCount * (p->boolVal ? -1 : 1);
    p->byteVal = (int8_t)(createCount & 0xF);
    p->shortVal = (int16_t)(createCount + 100);
    p->longVal = createCount + 100000;
    p->floatVal = ((float)createCount) * 1000;
    p->doubleVal = (double)createCount * 10000;

	std::wstringstream ss;
    ss << p->intVal;
    p->stringVal = ss.str();

    return p;
}


PPrimitiveTypes TestUtils::createObjectPrimitiveTypes() {
    PPrimitiveTypes p = internalCreateObjectPrimitiveTypes();
    return p;
}

void TestUtils::releasePrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes p) {
	p->objVal.reset();
	p->objVal2.reset();
}

int16_t TestUtils::x;

Point2D TestUtils::createPoint2D() {
	Point2D pt;
	pt.x = x++;
	pt.y = x*x;
	return pt;
}

#define TASSERT_MEMBER(name) ::tassert(file, line, msg + std::wstring(L".") + BToStdWString(#name), e->name, r->name)

void TestUtils::tassert(const char* file, int line, 
						const std::wstring& msg, 
						PPrimitiveTypes e, 
						PPrimitiveTypes r) 
{

	if ((e != NULL) ^ (r != NULL)) {
		throw AssertException(file, line, msg + L" wrong reference");
	}
	if (e == NULL) return;

	TASSERT_MEMBER(boolVal);
	TASSERT_MEMBER(byteVal);
	TASSERT_MEMBER(charVal);
	TASSERT_MEMBER(shortVal);
	TASSERT_MEMBER(intVal);
	TASSERT_MEMBER(longVal);
	TASSERT_MEMBER(floatVal);
	TASSERT_MEMBER(doubleVal);
	TASSERT_MEMBER(stringVal);

	tassert(file, line, msg + L".objVal",
		byps_static_ptr_cast<PrimitiveTypes>(e->objVal), 
		byps_static_ptr_cast<PrimitiveTypes>(r->objVal));

}

void TestUtils::tassert(const char* file, int line, 
						const std::wstring& msg, 
						const Point2D& e1, 
						const Point2D& r1)  {
	const Point2D* e = &e1;
	const Point2D* r = &r1;
	TASSERT_MEMBER(x);
	TASSERT_MEMBER(y);


}
