/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BVariant_HPP
#define BVariant_HPP

#include "BVariant.h"

namespace byps {

BINLINE void BVariant::clear() {
	u.longVal = 0;
}

BINLINE void BVariant::serialize(BIO& ar, BVERSION) {
    switch(type) {
	case BTYPEID_VOID: break;
    case BTYPEID_BOOL: ar & u.boolVal; break;
    case BTYPEID_WCHAR: ar & u.charVal; break;
    case BTYPEID_INT8: ar & u.byteVal; break;
    case BTYPEID_INT16: ar & u.shortVal; break;
    case BTYPEID_INT32: ar & u.intVal; break;
    case BTYPEID_INT64: ar & u.longVal; break;
    case BTYPEID_FLOAT: ar & u.floatVal; break;
    case BTYPEID_DOUBLE: ar & u.doubleVal; break;
    case BTYPEID_STRING: ar & strVal; break;
    default:
        if (ar.is_loading) {
            PSerializable obj;
            ar & obj;
            sobjVal = obj;
            type = BTYPEID_OBJECT;
        }
        else {
            PSerializable obj = byps_static_ptr_cast<BSerializable>(sobjVal);
            ar & obj;
        }
        break;
    }
}

BINLINE std::wstring BVariant::toString() const {
    std::wstringstream wss;
    switch(type) {
    case BTYPEID_VOID:
        wss << L"(void)";
        break;
    case BTYPEID_BOOL:
        wss << (u.boolVal ? L"true" : L"false");
        break;
    case BTYPEID_WCHAR:
        wss << u.charVal;
        break;
    case BTYPEID_INT8:
        wss << (int)u.byteVal;
        break;
    case BTYPEID_INT16:
        wss << u.shortVal;
        break;
    case BTYPEID_INT32:
        wss << u.intVal;
        break;
    case BTYPEID_INT64:
        wss << u.longVal;
        break;
    case BTYPEID_FLOAT:
        wss << u.floatVal;
        break;
    case BTYPEID_DOUBLE:
        wss << u.doubleVal;
        break;
    case BTYPEID_STRING:
        wss << strVal;
        break;
    case BTYPEID_OBJECT:
        wss << (sobjVal ? (void*)sobjVal.get() : (void*)objVal.get());
        break;
    case BTYPEID_EXCEPTION:
        wss << exVal.toString();
        break;
    default:
        wss << L"(invalid type " << type << L")";
        break;
    }
    return wss.str();
}

}

#endif // BINLINE BVariant::BVariant_HPP
