/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef TESTFW_H_
#define TESTFW_H_

#ifdef TESTFW_HEADER_ONLY
#define TINLINE inline
#else
#define TINLINE
#endif

namespace com { namespace wilutions { namespace test {

class AssertException;
class TestCase;
class TestSuite;

}}}

#include <assert.h>
#include "AssertException.h"
#include "TestCase.h"
#include "TestSuite.h"
#include "TestAssert.h"

#endif
