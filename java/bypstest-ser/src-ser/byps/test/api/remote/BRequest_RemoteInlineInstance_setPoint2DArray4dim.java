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
public final class BRequest_RemoteInlineInstance_setPoint2DArray4dim extends BMethodRequest implements Serializable {

	public byps.test.api.inl.Point2D[][][][] pointArray;
	
	public final static long serialVersionUID = 1355245240L;
	
	public int getRemoteId() { return 567395951; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync __byps__remoteT = (RemoteInlineInstanceAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setPoint2DArray4dim(pointArray, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteInlineInstance.setPoint2DArray4dim(");
		s.append(pointArray);
		s.append(")]");
		return s.toString();
	}
	
}
