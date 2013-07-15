#ifndef BASYNCRESULT_H_
#define BASYNCRESULT_H_

#include "Byps.h"
#include "BVariant.h"

namespace com { namespace wilutions { namespace byps {

typedef std::function<void (const BVariant&)> BAsyncResultL;

//template <typename _Type> 
//using BAsyncResultT = std::function<void (const _Type&, BException ex)> ;

template<typename _Type> class BSyncResultL {
public:
    BSyncResultL(bool autoDelete);
    void setAsyncResult(_Type, BException);
    _Type getResult();
private:
    byps_condition_variable waitForResult;
    byps_mutex mutex;
    bool hasResult;
	bool autoDelete;
    _Type result;
	BException ex;
};

template<typename _Type> BSyncResultL<_Type>::BSyncResultL(bool autoDelete)
    : hasResult(false), autoDelete(autoDelete) {
}

template<typename _Type> void BSyncResultL<_Type>::setAsyncResult(_Type result, BException ex) {
    byps_unique_lock lock(this->mutex);
    hasResult = true;
    this->result = result;
	this->ex  =ex;
    this->waitForResult.notify_one();
}

template<typename _Type> _Type BSyncResultL<_Type>::getResult() {
	_Type r = _Type();
	BException rex;
	{
		byps_unique_lock lock(this->mutex);
		this->waitForResult.wait(lock, [this](){ return hasResult; });
		if (ex) {
			rex = ex;
		}
		else {
			r = result;
		}
	}
	if (autoDelete)	delete this;
	if (rex) throw rex;
    return r;
}

// ---------------------------------------------------------

class BAsyncResult {
public:
    virtual ~BAsyncResult() {}
    virtual void setAsyncResult(const BVariant& ) { delete this; }
};

class BAsyncResult_BAsyncResultL : public BAsyncResult {
	BAsyncResultL innerResult;
public:
	BAsyncResult_BAsyncResultL(BAsyncResultL innerResult) 
		: innerResult(innerResult) {
	}
	virtual void setAsyncResult(const BVariant& obj) {
		innerResult(obj);
		delete this;
	}
};


template<typename _Type> class BAsyncResultT : public BAsyncResult {
public:
    virtual ~BAsyncResultT() {}
    virtual void setAsyncResult(const BVariant& obj);
    virtual void setAsyncResult(_Type result, BException ex) = 0; // ändere das in BException, um die Unsicherheit der Pointer-Übergabe zu vermeiden
};


template<typename _Type> class BAsyncResultT_BAsyncResultL : public BAsyncResultT<_Type> {
	std::function<void (const _Type&, BException ex)> innerResult;
public:
	BAsyncResultT_BAsyncResultL(std::function<void (const _Type&, BException ex)> innerResult) 
		: innerResult(innerResult) {
	}
	virtual void setAsyncResult(_Type result, BException ex) {
		innerResult(result, ex);
		delete this;
	}
};


template<typename _Type> class BSyncResult : public BAsyncResultT<_Type> {
public:
    BSyncResult(bool autoDelete);
    virtual void setAsyncResult(const BVariant&);
    virtual void setAsyncResult(_Type, BException) {}
    _Type getResult();
private:
    byps_condition_variable waitForResult;
    byps_mutex mutex;
    bool hasResult;
	bool autoDelete;
    BVariant result;
};

//class BAsyncResultReceiveMethod : public BAsyncResult {
//public:
//    BAsyncResultReceiveMethod(PAsyncResult innerResult);
//    virtual void setAsyncResult(const BVariant& methodResult);
//
//private:
//    PAsyncResult innerResult;
//};

template<typename _ReturnType, typename _ResultClass> class BAsyncResultReceiveMethodL : public BAsyncResult {
public:
    BAsyncResultReceiveMethodL(std::function<void (_ReturnType, BException)> innerResult);
    virtual void setAsyncResult(const BVariant& methodResult);

private:
    std::function<void (_ReturnType, BException)> innerResult;
};

//template<typename _Type> class BAsyncResultSerializableReceiveMethodL : public BAsyncResult {
//public:
//    BAsyncResultSerializableReceiveMethodL(std::function<void (byps_ptr<_Type>, BException)> innerResult);
//    virtual void setAsyncResult(const BVariant& methodResult);
//
//private:
//    std::function<void (byps_ptr<_Type>, BException)> innerResult;
//};

template<typename _ReturnType, typename _ResultClass> BAsyncResultReceiveMethodL<_ReturnType, _ResultClass>::BAsyncResultReceiveMethodL(std::function<void (_ReturnType, BException )> innerResult) 
	: innerResult(innerResult) {
}

template<typename _ReturnType, typename _ResultClass> void BAsyncResultReceiveMethodL<_ReturnType, _ResultClass>::setAsyncResult(const BVariant& varMethod) {
	_ReturnType v = _ReturnType();
    if (!varMethod.isException()) {
		PSerializable sobj;
		varMethod.get(sobj);
		_ResultClass* methodResult = dynamic_cast<_ResultClass* >(sobj.get());
		v = methodResult->result;
    }
	innerResult(v, varMethod.getException());
	delete this;
}

//template<typename _Type> BAsyncResultSerializableReceiveMethodL<_Type>::BAsyncResultSerializableReceiveMethodL(std::function<void (byps_ptr<_Type>, BException )> innerResult) 
//	: innerResult(innerResult) {
//}
//
//template<typename _Type> void BAsyncResultSerializableReceiveMethodL<_Type>::setAsyncResult(const BVariant& varMethod) {
//	byps_ptr<_Type> v = byps_ptr<_Type>();
//    if (!varMethod.isException()) {
//		PSerializable sobj;
//		varMethod.get(sobj);
//        BMethodResult<byps_ptr<_Type> >* methodResult = dynamic_cast<BMethodResult<byps_ptr<_Type> > >(sobj.get());
//
//		sobj.reset();
//		methodResult->result.get(sobj);
//		v = byps_ptr_cast<_Type>(sobj);
//    }
//	innerResult(v, varMethod.getException());
//}

template<typename _Type> BSyncResult<_Type>::BSyncResult(bool autoDelete)
    : hasResult(false), autoDelete(autoDelete) {
}

template<typename _Type> void BSyncResult<_Type>::setAsyncResult(const BVariant& result) {
    byps_unique_lock lock(this->mutex);
    hasResult = true;
    this->result = result;
    this->waitForResult.notify_one();
}

template<typename _Type> _Type BSyncResult<_Type>::getResult() {
	_Type r = _Type();
	BException rex;

	{
		byps_unique_lock lock(this->mutex);
		this->waitForResult.wait(lock, [this](){ return hasResult; });
		if (result.getType() == BTYPEID_EXCEPTION) {
			rex = result.getException();
		}
		else {
			result.get(r);
		}
	}
	if (autoDelete) delete this;
	if (rex) throw rex;
    return r;
}

template<typename _Type> void BAsyncResultT<_Type>::setAsyncResult(const BVariant& obj) {
    _Type val = _Type();
    if (obj.isException()) {
        BException ex = obj.getException();
        setAsyncResult(val, ex);
    }
    else {
        obj.get(val);
        setAsyncResult(val, BException());
    }
	delete this;
}

}}}

#endif
