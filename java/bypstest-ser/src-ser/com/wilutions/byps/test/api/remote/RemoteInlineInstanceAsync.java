package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface RemoteInlineInstanceAsync extends RemoteInlineInstance {

	public void async_setActor(com.wilutions.byps.test.api.inl.Actor act, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActor(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) ;
	
	public void async_setActorArray1dim(com.wilutions.byps.test.api.inl.Actor[] actorArray, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorArray1dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[]> asyncResult) ;
	
	public void async_setActorArray4dim(com.wilutions.byps.test.api.inl.Actor[][][][] actorArray, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorArray4dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[][][][]> asyncResult) ;
	
	public void async_setActorList(java.util.List<com.wilutions.byps.test.api.inl.Actor> actorList, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorList(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.inl.Actor>> asyncResult) ;
	
	public void async_setActorListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> actorListList, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorListList(final BAsyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>> asyncResult) ;
	
	public void async_setActorSet(java.util.Set<com.wilutions.byps.test.api.inl.Actor> actorSet, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorSet(final BAsyncResult<java.util.Set<com.wilutions.byps.test.api.inl.Actor>> asyncResult) ;
	
	public void async_setActorMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> actorMap, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getActorMap(final BAsyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>> asyncResult) ;
	
	
}
