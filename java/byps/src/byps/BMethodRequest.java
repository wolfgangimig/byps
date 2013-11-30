package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import byps.BAsyncResult;
import byps.BRemote;



public abstract class BMethodRequest {
	
	public abstract int getRemoteId();
	
	public void setSession(Object sess) {}
	
	/**
	 * 
	 * @param target Target interface. 
	 * @param asyncResult a BAsyncResult of BMethodResult
	 * @throws Throwable
	 */
	public abstract void execute(BRemote target, BAsyncResult<Object> asyncResult) throws Throwable;
}
