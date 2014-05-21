/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BASYNCRESULT_H_
#define BASYNCRESULT_H_

#include "Byps.h"
#include "BVariant.h"

namespace byps {

  typedef function<void (const BVariant&)> BAsyncResultL;

  // ---------------------------------------------------------

  class BAsyncResult {
    //#ifdef _DEBUG
    //	char watchForMemLeak[1000*1000];
    //#endif
  public:
    virtual ~BAsyncResult() {}
    virtual void setAsyncResult(const BVariant& ) { delete this; }
  };



  template<typename _Type> class BAsyncResultT : public BAsyncResult {
  public:
    virtual ~BAsyncResultT() {
    }

    virtual void setAsyncResult(const BVariant& obj) {
      _Type val = _Type();
      if (obj.isException()) {
        BException ex = obj.getException();
        setAsyncResult(val, ex);
      }
      else {
        obj.get(val);
        setAsyncResult(val, BException());
      }
      // do not delete this, it is called in setAsyncResult(_Type val, BException ex)
    }

    virtual void setAsyncResult(_Type result, BException ex) = 0; 
  };





  template<typename _Type> class BSyncResultT : public BAsyncResultT<_Type> {
  public:
    BSyncResultT() 
      : hasResult(false) {
    }

    virtual void setAsyncResult(const BVariant& var) {
      _Type val = _Type();
      BException ex = var.getException();
      if (!ex) {
        var.get(val);
      }
      setAsyncResult(val, ex);
      // NOT delete this, BSyncResult is usually allocated on stack
    }

    virtual void setAsyncResult(_Type result, BException ex) {
      byps_unique_lock lock(this->mutex);
      hasResult = true;
      this->result = result;
      this->ex = ex;
      this->waitForResult.notify_one();
    }

    _Type getResult() {
      _Type r = _Type();
      BException rex;

      {
        byps_unique_lock lock(this->mutex);
        while (!hasResult) {
          this->waitForResult.wait(lock);
        }
        r = this->result;
        rex = this->ex;
      }

      if (rex) throw rex;
      return r;
    }

  private:
    byps_condition_variable waitForResult;
    byps_mutex mutex;
    bool hasResult;
    bool autoDelete;
    _Type result;
    BException ex;
  };


  template<typename _ReturnType, typename _ResultClass> class BAsyncResultReceiveMethodL : public BAsyncResult {
  public:
    BAsyncResultReceiveMethodL(function<void (_ReturnType, BException)> innerResult);
    virtual void setAsyncResult(const BVariant& methodResult);

  private:
    function<void (_ReturnType, BException)> innerResult;
  };

  template<typename _ReturnType, typename _ResultClass> BAsyncResultReceiveMethodL<_ReturnType, _ResultClass>::BAsyncResultReceiveMethodL(function<void (_ReturnType, BException )> innerResult)
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


}

#endif
