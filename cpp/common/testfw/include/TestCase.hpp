#ifndef TESTCASE_HPP_
#define TESTCASE_HPP_

#include "TestCase.h"
#include <functional>

namespace com { namespace wilutions { namespace test {

bool TestCase::failed;

TestCase::~TestCase() {
}

void TestCase::add(const std::string& className, const std::string& fnctName, std::function<void (void)> fnct) {
	TestFunction testFunction;
    testFunction.name = className + std::string(".") + fnctName;
	testFunction.lambda = fnct;
	testFunctions.push_back(testFunction);
}

void TestCase::beforeCase() {
}
void TestCase::afterCase() {
}
void TestCase::beforeFunction(const TestCase::TestFunction& tfunc) {
	std::cout << tfunc.name << "... ";
}

void TestCase::afterFunction(const TestCase::TestFunction& tfunc) {

}

void TestCase::run() {
	init();
	try {
		beforeCase();
		for (std::vector<TestFunction>::iterator it = testFunctions.begin(); it != testFunctions.end(); it++) {
			TestFunction tfunc = (*it);
			beforeFunction(tfunc);
			try {
				tfunc.lambda();
				onSuccess(tfunc);
			}
			catch (const AssertException& ex) {
				failed = true;
				onFailed(tfunc, ex);
			}
			catch (const std::exception& ex) {
				failed = true;
				onError(tfunc, ex);
			}
			catch (...) {
				failed = true;
                AssertException ex(__FILE__, __LINE__, L"Unknown exception type");
				onError(ex);
			}
			afterFunction(tfunc);
		}
		afterCase();
	}
	catch (const std::exception& ex) {
		onError(ex);
	}
	catch (...) {
        AssertException ex(__FILE__, __LINE__, L"Unknown exception type");
		onError(ex);
	}
}

void TestCase::init() {
}

bool TestCase::isFailed() {
	return failed;
}

void TestCase::onError(const std::exception& ex) {
	std::cout << "ERROR: " << ex.what() << std::endl;
}

void TestCase::onError(const TestCase::TestFunction& tfunc, const std::exception& ex) {
	std::cout << "ERROR: " << ex.what() << std::endl;
}

void TestCase::onFailed(const TestCase::TestFunction& tfunc, const AssertException& ex) {
	std::cout << "FAILED" << std::endl;
	std::wcout << ex;
}

void TestCase::onSuccess(const TestCase::TestFunction& tfunc) {
	std::cout << "OK" << std::endl;
}

}

#endif
