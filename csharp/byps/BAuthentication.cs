using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public interface BAuthentication
    {

        void authenticate(BClient client, BAsyncResult<Boolean> asyncResult);

        bool isReloginException(BClient client, Exception ex, int typeId);

        Object getSession();
    }
}
