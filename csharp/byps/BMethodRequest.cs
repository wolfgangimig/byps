using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public interface BMethodRequest
    {
        int getRemoteId();
	
    	void execute(BRemote target, BAsyncResult<Object> asyncResult);

    }
}
