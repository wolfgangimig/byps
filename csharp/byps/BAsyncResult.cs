using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public interface BAsyncResult<T>
    {
        void setAsyncResult(T obj, Exception e);
    }
}
