/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BLOGGER_H_
#define BLOGGER_H_

#include "Byps.h"
#include <fstream>

namespace byps {

using namespace std;

enum BLogLevel {
	Nothing, Debug, Info, Warn, Error
};

class BLogFile {
public:
	BLogFile();

#ifdef BFSTREAM_WCHAR
	void open(const wstring& fname, BLogLevel level, bool append);
#endif

    void open(const string& fname, BLogLevel level, bool append);

	void close();
	void println(BLogLevel msglevel, const wstring& msg);

	BLogLevel level;

private:
	wfstream strm;
    byps_mutex mutex;
};

class BLogStream {
public:
	BLogStream(BLogLevel level, const char* className, int line);
	BLogStream(const BLogStream& rhs);
	~BLogStream();
	basic_ostream<wchar_t>& operator << (const wstring& msg);
	basic_ostream<wchar_t>& operator << (const char* msg);
	basic_ostream<wchar_t>& operator << (const string& msg);
private:
	bool print;
	BLogLevel level;
	wstringstream ss;
};

class BLogger {
public:
	BLogger(const char* className);

    bool isDebugEnabled() const;
    bool isInfoEnabled() const;
    bool isWarnEnabled() const;
    bool isErrorEnabled() const;

    BLogStream debug(int line = 0) const;
    BLogStream info(int line = 0) const;
    BLogStream warn(int line = 0) const;
    BLogStream error(int line = 0) const;

#ifdef BFSTREAM_WCHAR
    static void init(const wstring& fname, BLogLevel level, bool append = false);
#endif
    static void init(const string& fname, BLogLevel level, bool append = false);
    static void done();

	static BLogFile logFile;
	const char* className;
};

#define LOGGER_IMPL \
	namespace byps {\
		BLogFile BLogger::logFile;\
	}

basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& , const char* msg);
basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& , const string& msg);
basic_ostream<wchar_t>& operator << (basic_ostream<wchar_t>& ss, const exception& ex);

}

#ifndef l_debug
#define l_debug if (log.isDebugEnabled()) log.debug(__LINE__)
#endif
#ifndef l_info
#define l_info if (log.isInfoEnabled()) log.info(__LINE__)
#endif
#ifndef l_warn
#define l_warn if (log.isWarnEnabled()) log.warn(__LINE__)
#endif
#ifndef l_error
#define l_error if (log.isErrorEnabled()) log.error(__LINE__)
#endif

#endif
