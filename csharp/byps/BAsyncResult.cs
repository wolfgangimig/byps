/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public delegate void BAsyncResult<T>(T obj, Exception e);

    public interface BAsyncResultIF<T>
    {
        void setAsyncResult(T obj, Exception e);
    }

    public class BAsyncResultCallDelegate<T> : BAsyncResultIF<T>
    {
        private BAsyncResult<T> fnct;

        public BAsyncResultCallDelegate(BAsyncResult<T> fnct)
        {
            this.fnct = fnct;
        }

        public void setAsyncResult(T obj, Exception e)
        {
            this.fnct(obj, e);
        }
    }
    public class BAsyncResultHelper
    {
        public static BAsyncResult<T> ToDelegate<T>(BAsyncResultIF<T> asyncResult)
        {
            return (T obj, Exception e) =>
            {
                asyncResult.setAsyncResult(obj, e);
            };
        }

        public static BAsyncResultIF<T> FromDelegate<T>(BAsyncResult<T> asyncResult)
        {
            return new BAsyncResultCallDelegate<T>(asyncResult);
        }
    }



    
}
