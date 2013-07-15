#ifndef BVariant_HPP
#define BVariant_HPP

#include "BVariant.h"

namespace com { namespace wilutions { namespace byps {

BINLINE void BVariant::serialize(BIO& ar, const unsigned int) {
    switch(type) {
	case BTYPEID_VOID: break;
    case BTYPEID_BOOL: ar & boolVal; break;
    case BTYPEID_WCHAR: ar & charVal; break;
    case BTYPEID_INT8: ar & byteVal; break;
    case BTYPEID_INT16: ar & shortVal; break;
    case BTYPEID_INT32: ar & intVal; break;
    case BTYPEID_INT64: ar & longVal; break;
    case BTYPEID_FLOAT: ar & floatVal; break;
    case BTYPEID_DOUBLE: ar & doubleVal; break;
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
