package byps.test.api.remote;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.inl.Point2D;
import byps.test.api.prim.PrimitiveTypes;

public interface RemoteArrayTypes23 extends BRemote {
	
	int[] sendArraysInt(int[][] arr2, int[][][] arr3, int[][][][] arr4)throws RemoteException;
	String[] sendArraysString(String[][] arr2, String[][][] arr3, String[][][][] arr4)throws RemoteException;
	PrimitiveTypes[] sendArraysClass(PrimitiveTypes[][] arr2, PrimitiveTypes[][][] arr3, PrimitiveTypes[][][][] arr4)throws RemoteException;
	Object[] sendArraysObject(Object[][] arr2, Object[][][] arr3, Object[][][][] arr4)throws RemoteException;
	Point2D[] sendArraysInline(Point2D[][] arr2, Point2D[][][] arr3, Point2D[][][][] arr4)throws RemoteException;
	

}
