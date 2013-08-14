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
