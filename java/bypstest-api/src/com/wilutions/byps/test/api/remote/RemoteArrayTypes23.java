package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.inl.Point2D;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteArrayTypes23 extends BRemote {
	
	int[] sendArraysInt(int[][] arr2, int[][][] arr3, int[][][][] arr4)throws BException, InterruptedException;
	String[] sendArraysString(String[][] arr2, String[][][] arr3, String[][][][] arr4)throws BException, InterruptedException;
	PrimitiveTypes[] sendArraysClass(PrimitiveTypes[][] arr2, PrimitiveTypes[][][] arr3, PrimitiveTypes[][][][] arr4)throws BException, InterruptedException;
	Object[] sendArraysObject(Object[][] arr2, Object[][][] arr3, Object[][][][] arr4)throws BException, InterruptedException;
	Point2D[] sendArraysInline(Point2D[][] arr2, Point2D[][][] arr3, Point2D[][][][] arr4)throws BException, InterruptedException;
	

}
