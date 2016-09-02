package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes23_sendArraysInt extends BMethodRequest implements Serializable {

	public int[][] arr2;
	public int[][][] arr3;
	public int[][][][] arr4;
	
	public final static long serialVersionUID = 1828268517L;
	
	public int getRemoteId() { return 769717182; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async __byps__remoteT = (RemoteArrayTypes23Async)__byps__remote;			
			BAsyncResultSendMethod<int[]> __byps__outerResult = new BAsyncResultSendMethod<int[]>(__byps__asyncResult, new byps.test.api.BResult_100361105());			
			__byps__remoteT.sendArraysInt(arr2, arr3, arr4, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteArrayTypes23.sendArraysInt(");
		s.append(arr2 != null ? java.util.Arrays.toString(arr2) : "null");
		s.append(",").append(arr3 != null ? java.util.Arrays.toString(arr3) : "null");
		s.append(",").append(arr4 != null ? java.util.Arrays.toString(arr4) : "null");
		s.append(")]");
		return s.toString();
	}
	
}
