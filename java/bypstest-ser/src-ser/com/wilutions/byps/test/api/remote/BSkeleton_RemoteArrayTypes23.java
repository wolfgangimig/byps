package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteArrayTypes23.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteArrayTypes23 extends BSkeleton implements RemoteArrayTypes23Async {
	
	public final static long serialVersionUID = 2081058997L;
	
	@Override
	public int[] sendArraysInt(int[][] arr2, int[][][] arr3, int[][][][] arr4) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendArraysInt(int[][] arr2, int[][][] arr3, int[][][][] arr4, final BAsyncResult<int[]> asyncResult) {
		try {
			int[] ret = sendArraysInt(arr2, arr3, arr4);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.lang.String[] sendArraysString(java.lang.String[][] arr2, java.lang.String[][][] arr3, java.lang.String[][][][] arr4) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendArraysString(java.lang.String[][] arr2, java.lang.String[][][] arr3, java.lang.String[][][][] arr4, final BAsyncResult<java.lang.String[]> asyncResult) {
		try {
			java.lang.String[] ret = sendArraysString(arr2, arr3, arr4);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.prim.PrimitiveTypes[] sendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[][] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[][][] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][] arr4) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[][] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[][][] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][] arr4, final BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
		try {
			com.wilutions.byps.test.api.prim.PrimitiveTypes[] ret = sendArraysClass(arr2, arr3, arr4);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.lang.Object[] sendArraysObject(java.lang.Object[][] arr2, java.lang.Object[][][] arr3, java.lang.Object[][][][] arr4) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendArraysObject(java.lang.Object[][] arr2, java.lang.Object[][][] arr3, java.lang.Object[][][][] arr4, final BAsyncResult<java.lang.Object[]> asyncResult) {
		try {
			java.lang.Object[] ret = sendArraysObject(arr2, arr3, arr4);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Point2D[] sendArraysInline(com.wilutions.byps.test.api.inl.Point2D[][] arr2, com.wilutions.byps.test.api.inl.Point2D[][][] arr3, com.wilutions.byps.test.api.inl.Point2D[][][][] arr4) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendArraysInline(com.wilutions.byps.test.api.inl.Point2D[][] arr2, com.wilutions.byps.test.api.inl.Point2D[][][] arr3, com.wilutions.byps.test.api.inl.Point2D[][][][] arr4, final BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Point2D[] ret = sendArraysInline(arr2, arr3, arr4);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
