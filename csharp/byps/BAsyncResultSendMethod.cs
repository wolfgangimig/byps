/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BAsyncResultSendMethod<T> : BAsyncResultIF<T>
    {
        private BAsyncResultIF<Object> innerResult;
	    BMethodResult<T> methodResult;

        public BAsyncResultSendMethod(BAsyncResultIF<Object> innerResult, BMethodResult<T> methodResult)
        {
		    this.innerResult = innerResult;
		    this.methodResult = methodResult;
	    }

	    public void setAsyncResult(T obj, Exception e) 
        {
		    methodResult.resultValue = obj;
		    innerResult.setAsyncResult(methodResult, e);
	    }
    }
}
