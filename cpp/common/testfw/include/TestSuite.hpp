#ifndef TESTSUITE_HPP_
#define TESTSUITE_HPP_

#include "TestSuite.h"

namespace com { namespace wilutions { namespace test {

TestSuite& TestSuite::add(TestCase* tc) {
	testCases.push_back(tc);
	return *this;
}

TestSuite::~TestSuite() {
	for (unsigned i = 0; i < testCases.size(); i++) {
		TestCase* tc = testCases[i];
		delete tc;
	}
}

void TestSuite::run() {
	for (unsigned i = 0; i < testCases.size(); i++) {
		testCases[i]->run();
	}
}

}}}

#endif