using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BAsyncResultSendMethod<T> : BAsyncResult<T>
    {
        private BAsyncResult<Object> innerResult;
	    BMethodResult<T> methodResult;

	    public BAsyncResultSendMethod(BAsyncResult<Object> innerResult, BMethodResult<T> methodResult) {
		    this.innerResult = innerResult;
		    this.methodResult = methodResult;
	    }

	    public void setAsyncResult(T obj, Exception e) {
		    methodResult._result = obj;
		    innerResult.setAsyncResult(methodResult, e);
	    }
    }
}
