/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BREGISTRY_H_
#define BREGISTRY_H_

#include "Byps.h"

namespace byps {

const BTYPEID BTYPEID_BOOL = 1;
const BTYPEID BTYPEID_INT8 = 2;
const BTYPEID BTYPEID_INT16 = 3;
const BTYPEID BTYPEID_WCHAR = 4;
const BTYPEID BTYPEID_INT32 = 5;
const BTYPEID BTYPEID_INT64 = 6;
const BTYPEID BTYPEID_FLOAT = 7;
const BTYPEID BTYPEID_DOUBLE = 8;

const BTYPEID BTYPEID_STRING = 10;
//const BTYPEID BTYPEID_WSTRING = 11;
const BTYPEID BTYPEID_LIST = 12;
const BTYPEID BTYPEID_MAP = 13;
const BTYPEID BTYPEID_SET = 14;
const BTYPEID BTYPEID_STREAM = 15;
const BTYPEID BTYPEID_STUB = 16;
const BTYPEID BTYPEID_VOID = 19;
const BTYPEID BTYPEID_EXCEPTION = 20;
const BTYPEID BTYPEID_OBJECT = 21;
const BTYPEID BTYPEID_HEADER = 30;
const BTYPEID BTYPEID_STRING_UTF16 = BTYPEID_STRING;

class BRegistry {
    unordered_map<BTYPEID, BSERIALIZER> mapSerializer;
    unordered_map<size_t, BTYPEID> mapTypeIds;
public:
    BRegistry();
    ~BRegistry();
    void registerClass(const type_info& tinfo, BSERIALIZER ser, BTYPEID typeId);
    BSERIALIZER getSerializer(const type_info& tinfo, BTYPEID& typeId);
    BSERIALIZER getSerializer(BTYPEID typeId);
};

}

#endif /* BREGISTRY_H_ */
