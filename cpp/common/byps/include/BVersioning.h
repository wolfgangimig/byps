/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BVERSIONING_H_
#define BVERSIONING_H_

#include "Byps.h"

namespace byps {

class BVersioning {
public:
	template<typename _C> static BVERSION stringToLong(const std::basic_string<_C>& sver) {
		int64_t ver = 0;
		if (sver.size() != 0) {
			std::vector<int> arr;
			size_t p = 0;
			while(p < sver.size()) {
				size_t e = sver.find((_C)'.', p);
				if (e == std::basic_string<_C>::npos) e = sver.size();
				std::basic_string<_C> s = sver.substr(p, e - p);
				int n = 0;
				if (s.size() != 0) {
					std::basic_stringstream<_C> ss;
					ss << s;
					ss >> n;
				}
				arr.push_back(n);
				p = e+1;
			}
			for (size_t i = 0; i < arr.size(); i++) {
				ver *= 10000;
				if (i == arr.size()-1) ver *= 100;
				ver += arr[i];
			}
		}
		return ver;
	}

	template<typename _C> static std::basic_string<_C> longToString(BVERSION nver) {
		std::vector<int> arr;
		for (int i = 0; i < 4; i++) {
			int ndigits = (i == 0) ? 1000000 : 10000;
			int pver = (int)(nver % ndigits);
			arr.push_back(pver);
			nver /= ndigits;
		}
		std::basic_stringstream<_C> wss;
		if (arr.size()) {
			for (int i = (int)arr.size()-1; i >= 0; i--) {
				wss << arr[(unsigned)i];
				if (i != 0) wss << ((_C)('.'));
			}
		}
		return wss.str();
	}


};

}

#endif