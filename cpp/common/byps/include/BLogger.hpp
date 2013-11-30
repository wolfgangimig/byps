/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BLOGGER_HPP_
#define BLOGGER_HPP_

#include <thread>
#include <iostream>
#include <iomanip>
#include <ctime>
#include "BLogger.h"

namespace byps {

BINLINE void BLogFile::println(BLogLevel msglevel, const wstring& msg) {
	
	if (level > msglevel) return;
	
	time_t t = time(nullptr);
    struct tm now;
    byps_localtime(&now, &t);

	std::wstringstream wss;

    wss << setfill(L'0')
            << setw(4) << 1900 + now.tm_year << L"-"
            << setw(2) << now.tm_mon+1 << L"-"
            << setw(2) << now.tm_mday << L" "
            << setw(2) << now.tm_hour << L":"
            << setw(2) << now.tm_min << L":"
            << setw(2) << now.tm_sec << L" ";

    wss << std::hex << this_thread::get_id() << L" " << std::dec;

    switch (msglevel) {
    case Nothing: break;
    case Debug: wss << L"DEBUG"; break;
    case Info: wss << L"INFO"; break;
    case Warn: wss << L"WARN"; break;
    case Error: wss << L"ERROR"; break;
    }
    wss << L" ";

    wss << msg;

    {
        byps_unique_lock lock(mutex);
		strm << wss.str() << endl;
        //strm.flush();
    }
}

BINLINE BLogFile::BLogFile() : level(BLogLevel::Nothing) {
}

#ifdef BFSTREAM_WCHAR
BINLINE void BLogFile::open(const wstring& fname, BLogLevel level, bool append) {
    ios_base::openmode om = ios_base::out;
    if (append) om |= ios_base::app;
    strm.open(fname, om);
    this->level = level;
}
#endif

BINLINE void BLogFile::open(const string& fname, BLogLevel level, bool append) {
    ios_base::openmode om = ios_base::out;
    if (append) om |= ios_base::app;
    strm.open(fname, om);
    this->level = level;
}

BINLINE void BLogFile::close() {
	strm.close();
}

#ifdef BFSTREAM_WCHAR
BINLINE void BLogger::init(const wstring& fname, BLogLevel level, bool append) {
    logFile.open(fname, level, append);
}
#endif

BINLINE void BLogger::init(const string& fname, BLogLevel level, bool append) {
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

BINLINE basic_ostream<wchar_t>& BLogStream::operator << (const char* msg) {
	return ss << msg;
}

BINLINE basic_ostream<wchar_t>& BLogStream::operator << (const wstring& msg) {
	return ss << msg;
}

BINLINE basic_ostream<wchar_t>& BLogStream::operator << (const string& msg) {
	return ss << msg;
}

BINLINE BLogger::BLogger(const char* className) : className(className) {
}

BINLINE basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& ss, const char* msg) {
	const char* p = msg;
	while (*p) {
		ss << (wchar_t)(*p);
		p++;
	}
	return ss;
}

BINLINE basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& ss, const string& msg) {
	return ss << msg.c_str();
}

BINLINE basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& ss, const exception& ex) {
	string msg = ex.what();
	return ss << msg;
}

}

#endif
