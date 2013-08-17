using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BAsyncResultReceiveMethod<T> : BAsyncResult<BMethodResult<T>>
    {
        private readonly BAsyncResult<T> innerResult;
	
	    public BAsyncResultReceiveMethod(BAsyncResult<T> outerResult) {
		    this.innerResult = outerResult;
	    }
	
	    public void setAsyncResult(BMethodResult<T> methodResult, Exception e)  {
            T result = methodResult != null ? methodResult._result : default(T);
            innerResult.setAsyncResult(result, e);
	    }
    }
}
