#ifndef TESTSUITE_H_
#define TESTSUITE_H_

#include <vector>
#include <functional>

namespace com { namespace wilutions { namespace test {

class TestCase;

class TestSuite {
public:
	virtual ~TestSuite();
	TestSuite& add(TestCase* tc);
	virtual void run();
private:
	std::vector<TestCase*> testCases;
	
};

}}}

#endif