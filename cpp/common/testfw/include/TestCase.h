#ifndef TESTCASE_H_
#define TESTCASE_H_

#include <vector>
#include <functional>

namespace com { namespace wilutions { namespace test {

#define ADD_TEST(fnct) \
	add(typeid(*this).name(), #fnct, [this]() { fnct(); })


class TestCase {
	
protected:

	struct TestFunction
	{
		std::string name;
		std::function<void (void)> lambda;
	};

	void add(const std::string& className, const std::string& fnctName, std::function<void (void)> fnct);

	virtual void beforeCase();
	virtual void afterCase();

	virtual void beforeFunction(const TestCase::TestFunction& tfunc);
	virtual void afterFunction(const TestCase::TestFunction& tfunc);

	virtual void onError(const std::exception& ex);
	virtual void onError(const TestCase::TestFunction& tfunc, const std::exception& ex);
	virtual void onFailed(const TestFunction& tfunc, const AssertException& ex);
	virtual void onSuccess(const TestFunction& tfunc);

public:

	virtual ~TestCase();
	virtual void run();
	virtual void init();
	static bool isFailed();

private:

	std::vector<TestFunction> testFunctions;
	static bool failed;
};


}}}

#endif