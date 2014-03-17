/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BDATETIME_H_
#define BDATETIME_H_


#include "Byps.h"
#include <ctime>

namespace byps {

/**
 * Date class.
 * This class does not use the time_t type because there is no function in time.h available
 * that converts a struct tm in UTC into a time_t value. 
 */
class BDateTime {
public:

	int16_t year, month, day, hour, minute, second, millisecond, _reserved;

	BDateTime();
	BDateTime(const BDateTime& rhs);
	BDateTime(int16_t year, int16_t month, int16_t day, int16_t hour, int16_t minute, int16_t second, int16_t millisecond);

	static BDateTime fromStruct(const struct tm& tm);
	void toStruct(struct tm& tm) const;

	std::wstring toString() const;
	static BDateTime fromString(const std::wstring& iso);

	bool operator == (const BDateTime rhs) const;
	bool operator != (const BDateTime rhs) const;
	bool operator < (const BDateTime rhs) const;
	bool operator > (const BDateTime rhs) const;

	template <typename _CHAR> 
    friend std::basic_ostream<_CHAR>& operator << (std::basic_ostream<_CHAR>& os, const BDateTime& dt) {
		_CHAR prevFill = os.fill(L'0');
		os 	<< setw(4) << dt.year << (_CHAR)'-'
			<< setw(2) << dt.month << (_CHAR)'-'
			<< setw(2) << dt.day << (_CHAR)'T'
			<< setw(2) << dt.hour << (_CHAR)':'
			<< setw(2) << dt.minute << (_CHAR)':'
			<< setw(2) << dt.second << (_CHAR)'.'
			<< setw(3) << dt.millisecond << (_CHAR)'Z';
		os.fill(prevFill);
		return os;
	}

private:
	int16_t diff(const BDateTime& rhs) const;

};

}

#endif