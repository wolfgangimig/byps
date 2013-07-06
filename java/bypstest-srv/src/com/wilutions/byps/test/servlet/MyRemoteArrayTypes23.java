package com.wilutions.byps.test.servlet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.inl.Point2D;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes23;

public class MyRemoteArrayTypes23 extends BSkeleton_RemoteArrayTypes23 {


	@Override
	public int[] sendArraysInt(int[][] arr2, int[][][] arr3, int[][][][] arr4)
			throws BException, InterruptedException {
		int[] arr1 = new int[3];
		arr1[0] = arr2[1][1];
		arr1[1] = arr3[1][1][1];
		arr1[2] = arr4[1][1][1][1];

		return arr1;
	}

	@Override
	public String[] sendArraysString(String[][] arr2, String[][][] arr3,
			String[][][][] arr4) throws BException, InterruptedException {
		String[] arr1 = new String[3];
		arr1[0] = arr2[1][1];
		arr1[1] = arr3[1][1][1];
		arr1[2] = arr4[1][1][1][1];

		return arr1;
	}

	@Override
	public PrimitiveTypes[] sendArraysClass(PrimitiveTypes[][] arr2,
			PrimitiveTypes[][][] arr3, PrimitiveTypes[][][][] arr4)
			throws BException, InterruptedException {
		PrimitiveTypes[] arr1 = new PrimitiveTypes[3];
		arr1[0] = arr2[1][1];
		arr1[1] = arr3[1][1][1];
		arr1[2] = arr4[1][1][1][1];

		return arr1;
	}

	@Override
	public Object[] sendArraysObject(Object[][] arr2, Object[][][] arr3,
			Object[][][][] arr4) throws BException, InterruptedException {
		Object[] arr1 = new Object[3];
		arr1[0] = arr2[1][1];
		arr1[1] = arr3[1][1][1];
		arr1[2] = arr4[1][1][1][1];

		return arr1;
	}

	@Override
	public Point2D[] sendArraysInline(Point2D[][] arr2, Point2D[][][] arr3,
			Point2D[][][][] arr4) throws BException, InterruptedException {
		Point2D[] arr1 = new Point2D[3];
		arr1[0] = arr2[1][1];
		arr1[1] = arr3[1][1][1];
		arr1[2] = arr4[1][1][1][1];

		return arr1;
	}

}
