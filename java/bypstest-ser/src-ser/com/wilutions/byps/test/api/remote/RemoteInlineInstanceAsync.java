package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface RemoteInlineInstanceAsync extends RemoteInlineInstance, BRemote {

	public void async_setActor(com.wilutions.byps.test.api.inl.Actor act, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActor(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) ;
	
	public void async_setPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPoint2DArray1dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) ;
	
	public void async_setPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[][][][] pointArray, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPoint2DArray4dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[][][][]> asyncResult) ;
	
	public void async_setPoint2DList(java.util.List<com.wilutions.byps.test.api.inl.Point2D> pointList, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPoint2DList(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
	
	public void async_setPoint2DListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> pointListList, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPoint2DListList(final BAsyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) ;
	
	public void async_setPoint2DMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> pointMap, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPoint2DMap(final BAsyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
	
	
}
