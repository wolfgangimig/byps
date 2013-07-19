#ifndef BVariant_HPP
#define BVariant_HPP

#include "BVariant.h"

namespace com { namespace wilutions { namespace byps {

BINLINE void BVariant::serialize(BIO& ar, const unsigned int) {
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



}}}

#endif // BINLINE BVariant::BVariant_HPP
