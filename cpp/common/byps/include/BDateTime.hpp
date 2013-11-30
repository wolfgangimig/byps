/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BDATETIME_HPP_
#define BDATETIME_HPP_

#include "BDateTime.h"

namespace byps {

BINLINE BDateTime::BDateTime() {
	year = 1970;
	month = 01;
	day = 01;
	hour = minute = second = millisecond = _reserved = 0;
}

BINLINE BDateTime::BDateTime(const BDateTime& rhs) {
	year = rhs.year;
	month = rhs.month;
	day = rhs.day;
	hour = rhs.hour;
	minute = rhs.minute;
	second = rhs.second;
	millisecond = rhs.millisecond;
	_reserved = rhs._reserved;
}

BINLINE BDateTime::BDateTime(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond) {
	this->year = year;
	this->month = month;
	this->day = day;
	this->hour = hour;
	this->minute = minute;
	this->second = second;
	this->millisecond = millisecond;
	this->_reserved = 0;
}

BINLINE BDateTime BDateTime::fromString(const std::wstring& iso) {
	if (iso.length()) {
		std::wstringstream wss;
		for (std::wstring::const_iterator it = iso.begin(); it != iso.end(); it++) {
			wchar_t c = (*it);
			if (c >= L'0' && c <= L'9') {
				wss << c;
			}
			else {
				wss << L' ';
			}
		}
	
		BDateTime ret;
		wss >> ret.year 
			>> ret.month
			>> ret.day
			>> ret.hour
			>> ret.minute
			>> ret.second
			>> ret.millisecond;

		return ret;

	}
	else {
		// Java Date value initialized with 0.
		return BDateTime(1970, 01, 01, 00, 00, 00, 000);
	}
}

BINLINE bool BDateTime:: operator == (const BDateTime rhs) const { 
	return diff(rhs) == 0;
}

BINLINE bool BDateTime:: operator != (const BDateTime rhs) const {
	return diff(rhs) != 0;
}

BINLINE int16_t BDateTime::diff(const BDateTime& rhs) const {
	int16_t d = year - rhs.year;
	if (d == 0) {
		d = month - rhs.month;
		if (d == 0) {
			d = day - rhs.day;
			if (d == 0) {
				d = hour - rhs.hour;
				if (d == 0) {
					d = minute - rhs.minute;
					if (d == 0) {
						d = second - rhs.second;
						if (d == 0) {
							d = millisecond - rhs.millisecond;
						}
					}
				}
			}
		}
	}
	return d;
}

BINLINE bool BDateTime:: operator < (const BDateTime rhs) const { 
	return diff(rhs) < 0;
}

BINLINE bool BDateTime:: operator > (const BDateTime rhs) const {
	return diff(rhs) > 0;
}


//BINLINE std::time_t BDateTime::mktime_utc(const struct tm& tm) {
//	static long localToUtcDiffSecondsInWinter = 0;
//
//	// _get_timezone(&tz); // Windows: always returns 28800, other platforms: maybe we can use extern int _timezone;
//	if (localToUtcDiffSecondsInWinter == 0) {
//
//		// Compute timezone offset at 1970-01-01 12:00:00
//		// Of course, this is a winter time. And it is not in the range when the 
//		// time is switched.
//
//		time_t now = 12 * 3600;
//
//		struct tm gm; 
//		gmtime_s(&gm, &now);
//		time_t gmt = mktime(&gm);
//
//		struct tm loc;
//		localtime_s(&loc, &now);
//		time_t local = mktime(&loc);
//
//		localToUtcDiffSecondsInWinter = (long) difftime(local, gmt);
//	}
//
//	struct tm tm1 = tm;
//	std::time_t localT = mktime(&tm1);
//	std::time_t utcT = localT + localToUtcDiffSecondsInWinter;
//	if (tm1.tm_isdst) utcT += localToUtcDiffSecondsInWinter;
//	return utcT;
//}


BINLINE BDateTime BDateTime::fromStruct(const struct tm& tm) {
	return BDateTime(tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec, 0);
}

BINLINE void BDateTime::toStruct(struct tm& tm) const {
	tm.tm_year = year - 1900;
	tm.tm_mon = month - 1;
	tm.tm_mday = day;
	tm.tm_hour = hour;
	tm.tm_min = minute;
	tm.tm_sec = second;
}


BINLINE std::wstring BDateTime::toString() const {
	std::wstringstream wss;
	wss << (*this);
	return wss.str();
}


}

#endif