#ifndef PLATFORM_API_H_
#define PLATFORM_API_H_

////////////////////////////////////////////////////////////////////////
// shared_ptr

#ifndef BSHARED_PTR
#define BSHARED_PTR

#ifdef _MSC_VER

#include <memory>

#define byps_ptr std::shared_ptr
#define byps_ptr_cast std::dynamic_pointer_cast
#define byps_static_ptr_cast std::static_pointer_cast
#define byps_enable_shared_from_this std::enable_shared_from_this

#include <mutex>
#define byps_mutex std::mutex
#define byps_unique_lock std::unique_lock<std::mutex>

#include <condition_variable>
#define byps_condition_variable std::condition_variable

#include <atomic>
#define byps_atomic std::atomic

#define CPP11_LAMBDA

#define BFSTREAM_WCHAR

#include "msvc_x86_x64.h"

#ifdef _DEBUG
#define BDEBUG
#endif

#include <ctime>

inline struct tm* byps_localtime(struct tm* buf, const std::time_t* t) {
	localtime_s(buf, t);
	return buf;
}

#elif __GNUC__

//#if __cplusplus < 201103L

#include <memory>

#define byps_ptr std::shared_ptr
#define byps_ptr_cast std::dynamic_pointer_cast
#define byps_static_ptr_cast std::static_pointer_cast
#define byps_enable_shared_from_this std::enable_shared_from_this

#include <mutex>
#define byps_mutex std::mutex
#define byps_unique_lock std::unique_lock<std::mutex>

#include <condition_variable>
#define byps_condition_variable std::condition_variable

#include <atomic>
#define byps_atomic std::atomic

#include "gcc_x86_x64.h"

#include <ctime>

inline struct tm* byps_localtime(struct tm* buf, const std::time_t* t) {
    memcpy(buf, localtime(t), sizeof(t));
    return buf;
}

#define CPP11_LAMBDA

#else

#if __GNUC__
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wpointer-arith"
#endif

#include <boost/shared_ptr.hpp>

#if __GNUC__
#pragma GCC diagnostic pop
#endif

#define byps_ptr boost::shared_ptr
#define byps_ptr_cast boost::dynamic_pointer_cast
#define byps_static_ptr_cast boost::static_pointer_cast
#define byps_enable_shared_from_this boost::enable_shared_from_this

#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wmissing-field-initializers"
#include <boost/thread/shared_mutex.hpp>
#define byps_mutex boost::shared_mutex
#pragma GCC diagnostic pop

#endif


#include "any.h"


#endif /* BSHARED_PTR */


#endif
