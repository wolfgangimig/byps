/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMETHODRESULT_H_
#define BMETHODRESULT_H_

#include "Byps.h"

namespace byps {

template<typename _Type> class BMethodResult : public BSerializable {
public:
	_Type result;

    BMethodResult() {
		result = _Type();
	}

    void serialize(BIO& ar, const unsigned int ) {
		ar & result;
	}
};

/*
template<typename __T> class BAsyncResultSendMethod : BAsyncResult<__T> {
private:
    PAsyncResult_PSerializable innerResult;
    BMethodResult<__T> methodResult;

public:
    BAsyncResultSendMethod(PAsyncResult_PSerializable innerResult, BMethodResult<__T> methodResult) {
        this.innerResult = innerResult;
        this.methodResult = methodResult;
    }

    void setAsyncResult(T obj, Throwable e) {
        methodResult.result = obj;
        innerResult.setAsyncResult(methodResult, e);
    }

}
*/

}

#endif
