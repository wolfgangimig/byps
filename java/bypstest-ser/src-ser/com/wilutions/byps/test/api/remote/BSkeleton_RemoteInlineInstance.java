package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteInlineInstance.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteInlineInstance extends BSkeleton implements RemoteInlineInstanceAsync {
	
	public final static long serialVersionUID = 1206670536L;
	
	@Override
	public void setActor(com.wilutions.byps.test.api.inl.Actor act) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActor(com.wilutions.byps.test.api.inl.Actor act, final BAsyncResult<Object> asyncResult) {
		try {
			setActor(act);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Actor getActor() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActor(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Actor ret = getActor();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, final BAsyncResult<Object> asyncResult) {
		try {
			setPoint2DArray1dim(pointArray);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Point2D[] getPoint2DArray1dim() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPoint2DArray1dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Point2D[] ret = getPoint2DArray1dim();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[][][][] pointArray) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[][][][] pointArray, final BAsyncResult<Object> asyncResult) {
		try {
			setPoint2DArray4dim(pointArray);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Point2D[][][][] getPoint2DArray4dim() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPoint2DArray4dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[][][][]> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Point2D[][][][] ret = getPoint2DArray4dim();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPoint2DList(java.util.List<com.wilutions.byps.test.api.inl.Point2D> pointList) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPoint2DList(java.util.List<com.wilutions.byps.test.api.inl.Point2D> pointList, final BAsyncResult<Object> asyncResult) {
		try {
			setPoint2DList(pointList);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<com.wilutions.byps.test.api.inl.Point2D> getPoint2DList() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPoint2DList(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
		try {
			java.util.List<com.wilutions.byps.test.api.inl.Point2D> ret = getPoint2DList();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPoint2DListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> pointListList) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPoint2DListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> pointListList, final BAsyncResult<Object> asyncResult) {
		try {
			setPoint2DListList(pointListList);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> getPoint2DListList() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPoint2DListList(final BAsyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) {
		try {
			java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> ret = getPoint2DListList();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPoint2DMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> pointMap) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPoint2DMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> pointMap, final BAsyncResult<Object> asyncResult) {
		try {
			setPoint2DMap(pointMap);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> getPoint2DMap() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPoint2DMap(final BAsyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
		try {
			java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> ret = getPoint2DMap();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
