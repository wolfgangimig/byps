using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BMethodRequest
    {
        public abstract int getRemoteId();

        public abstract void execute(BRemote target, BAsyncResultIF<Object> asyncResult);

        public virtual void setSession(object sess)
        {
        }
    }
}
