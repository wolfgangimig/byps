#ifndef BASYNCRESULT_HPP
#define BASYNCRESULT_HPP

#include "BAsyncResult.h"

namespace com { namespace wilutions { namespace byps {

//BINLINE BAsyncResultReceiveMethod::BAsyncResultReceiveMethod(PAsyncResult innerResult)
//        : innerResult(innerResult) {
//}
//
//BINLINE void BAsyncResultReceiveMethod::setAsyncResult(const BVariant& varMethod) {
//    if (varMethod.isException()) {
//        innerResult->setAsyncResult(BVariant(varMethod.getException()));
//    }
//    else {
//		PSerializable sobj;
//		varMethod.get(sobj);
//        PMethodResult methodResult = byps_ptr_cast<BMethodResult>(sobj);
//
//        innerResult->setAsyncResult(methodResult->result);
//    }
//}

}}}

#endif // BASYNCRESULT_HPP
