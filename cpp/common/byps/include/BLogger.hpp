#ifndef BLOGGER_HPP_
#define BLOGGER_HPP_

#include "BLogger.h"
#include <thread>
#include <iostream>
#include <iomanip>
#include <ctime>

namespace com { namespace wilutions { namespace byps {

BINLINE void BLogFile::println(BLogLevel msglevel, const std::wstring& msg) {
	
	if (level > msglevel) return;

	
	std::time_t t = std::time(nullptr);
    struct tm now;
    byps_localtime(&now, &t);

    strm << std::setfill(L'0')
         << std::setw(4) << 1900 + now.tm_year << L"-"
         << std::setw(2) << now.tm_mon+1 << L"-"
         << std::setw(2) << now.tm_mday << L" "
         << std::setw(2) << now.tm_hour << L":"
         << std::setw(2) << now.tm_min << L":"
         << std::setw(2) << now.tm_sec << L" ";

	strm << std::this_thread::get_id() << L" ";

	switch (msglevel) {
	case Nothing: break;
	case Debug: strm << L"DEBUG"; break;
	case Info: strm << L"INFO"; break;
	case Warn: strm << L"WARN"; break;
	case Error: strm << L"ERROR"; break;
	}
	strm << L" ";

	strm << msg;

	strm << std::endl;
}

BINLINE BLogFile::BLogFile() : level(BLogLevel::Nothing) {
}

#ifdef BFSTREAM_WCHAR
BINLINE void BLogFile::open(const std::wstring& fname, BLogLevel level, bool append) {
    std::ios_base::openmode om = std::ios_base::out;
    if (append) om |= std::ios_base::app;
    strm.open(fname, om);
    this->level = level;
}
#endif

BINLINE void BLogFile::open(const std::string& fname, BLogLevel level, bool append) {
    std::ios_base::openmode om = std::ios_base::out;
    if (append) om |= std::ios_base::app;
    strm.open(fname, om);
    this->level = level;
}

BINLINE void BLogFile::close() {
	strm.close();
}

#ifdef BFSTREAM_WCHAR
BINLINE void BLogger::init(const std::wstring& fname, BLogLevel level, bool append) {
    logFile.open(fname, level, append);
}
#endif

BINLINE void BLogger::init(const std::string& fname, BLogLevel level, bool append) {
    logFile.open(fname, level, append);
}

BINLINE void BLogger::done() {
	logFile.close();
}

BINLINE BLogStream BLogger::debug(int line) const {
	return BLogStream(BLogLevel::Debug, className, line);
}

BINLINE BLogStream BLogger::info(int line) const {
	return BLogStream(BLogLevel::Info, className, line);
}

BINLINE BLogStream BLogger::warn(int line) const {
	return BLogStream(BLogLevel::Warn, className, line);
}

BINLINE BLogStream BLogger::error(int line) const {
	return BLogStream(BLogLevel::Error, className, line);
}

BINLINE bool BLogger::isDebugEnabled() const {
	return logFile.level <= BLogLevel::Debug;
}

BINLINE bool BLogger::isInfoEnabled() const {
	return logFile.level <= BLogLevel::Info;
}

BINLINE bool BLogger::isWarnEnabled() const {
	return logFile.level <= BLogLevel::Warn;
}

BINLINE bool BLogger::isErrorEnabled() const {
	return logFile.level <= BLogLevel::Error;
}

BINLINE BLogStream::BLogStream(BLogLevel level, const char* className, int line) : print(true), level(level) {
	(*this) << className;
	if (line) {
		ss  << L":" << line;
	}
	ss << L" ";
}

BINLINE BLogStream::BLogStream(const BLogStream& rhs) : print(true), level(rhs.level) {
	ss << rhs.ss.str();
}

BINLINE BLogStream::~BLogStream() {
	if (!print) return;
	BLogger::logFile.println(level, ss.str());
}

BINLINE std::basic_ostream<wchar_t>& BLogStream::operator << (const char* msg) {
	return ss << msg;
}

BINLINE std::basic_ostream<wchar_t>& BLogStream::operator << (const std::wstring& msg) {
	return ss << msg;
}

BINLINE std::basic_ostream<wchar_t>& BLogStream::operator << (const std::string& msg) {
	return ss << msg;
}

BINLINE BLogger::BLogger(const char* className) : className(className) {
}

BINLINE std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& ss, const char* msg) {
	const char* p = msg;
	while (*p) {
		ss << (wchar_t)(*p);
		p++;
	}
	return ss;
}

BINLINE std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& ss, const std::string& msg) {
	return ss << msg.c_str();
}

BINLINE std::basic_ostream<wchar_t>& operator << (std::basic_ostream<wchar_t>& ss, const std::exception& ex) {
	std::string msg = ex.what();
	return ss << msg;
}

}}}

#endif
