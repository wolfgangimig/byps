/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace byps
{
    public class BSyncResult<T> : BAsyncResultIF<T>
    {
	    protected T result;
	    protected Exception ex;
	    private bool done;
	
	    public BSyncResult() {
	    }
	
	    public void setAsyncResult(T result, Exception ex) {
            lock(this)
            {
                this.result = result;
                this.ex = ex;
			    this.done = true;
			    Monitor.PulseAll(this);
		    }
	    }
	
	    public T GetResult() {
		    return GetResult(int.MaxValue);
	    }
	
	    public T GetResult(int timeoutMillis) {
            lock (this)
            {
			    long t1 = DateTime.Now.Ticks / 10000;
			    while (!done) 
                {
				    Monitor.Wait(this, timeoutMillis);
				    long dt = (DateTime.Now.Ticks / 10000) - t1;
				    if (dt >= timeoutMillis) {
					    ex = new BException(BExceptionC.TIMEOUT, "Timeout while waiting for result.");
					    break;
				    }
			    }
			    if (ex != null) {
				    if (ex is BException) throw (BException)ex;
				    throw new BException(BExceptionC.REMOTE_ERROR, "", ex);
			    }
			    return result;
		    }
	    }
	
    }
}
