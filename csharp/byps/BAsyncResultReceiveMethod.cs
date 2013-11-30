/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BAsyncResultReceiveMethod<T> : BAsyncResultIF<BMethodResult<T>>
    {
        private readonly BAsyncResultIF<T> innerResult;
        private readonly BAsyncResult<T> fnct;

        public BAsyncResultReceiveMethod(BAsyncResultIF<T> outerResult)
        {
            this.innerResult = outerResult;
        }

        public BAsyncResultReceiveMethod(BAsyncResult<T> fnct)
        {
            this.fnct = fnct;
        }

        public void setAsyncResult(BMethodResult<T> methodResult, Exception e)
        {
            T result = methodResult != null ? methodResult.resultValue : default(T);
            if (innerResult != null)
            {
                innerResult.setAsyncResult(result, e);
            }
            else
            {
                fnct(result, e);
            }
        }
    }
}
