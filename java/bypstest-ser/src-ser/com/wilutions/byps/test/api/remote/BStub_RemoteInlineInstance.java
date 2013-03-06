package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemoteInlineInstance extends BStub implements RemoteInlineInstance, java.io.Serializable {
	
	public final static long serialVersionUID = 1206670536L;
	
	public BStub_RemoteInlineInstance(final BTransport transport) {
		super(transport);		
	}
	
	public void setActor(com.wilutions.byps.test.api.inl.Actor act) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActor(act, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActor(com.wilutions.byps.test.api.inl.Actor act, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActor req = new BRequest_RemoteInlineInstance_setActor();		
		req.act = act;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public com.wilutions.byps.test.api.inl.Actor getActor() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Actor>();		
		async_getActor(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActor(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) {
		BRequest_RemoteInlineInstance_getActor req = new BRequest_RemoteInlineInstance_getActor();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorArray1dim(com.wilutions.byps.test.api.inl.Actor[] actorArray) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorArray1dim(actorArray, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorArray1dim(com.wilutions.byps.test.api.inl.Actor[] actorArray, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorArray1dim req = new BRequest_RemoteInlineInstance_setActorArray1dim();		
		req.actorArray = actorArray;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public com.wilutions.byps.test.api.inl.Actor[] getActorArray1dim() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.inl.Actor[]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Actor[]>();		
		async_getActorArray1dim(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorArray1dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[]> asyncResult) {
		BRequest_RemoteInlineInstance_getActorArray1dim req = new BRequest_RemoteInlineInstance_getActorArray1dim();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor[]> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor[]>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorArray4dim(com.wilutions.byps.test.api.inl.Actor[][][][] actorArray) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorArray4dim(actorArray, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorArray4dim(com.wilutions.byps.test.api.inl.Actor[][][][] actorArray, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorArray4dim req = new BRequest_RemoteInlineInstance_setActorArray4dim();		
		req.actorArray = actorArray;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public com.wilutions.byps.test.api.inl.Actor[][][][] getActorArray4dim() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.inl.Actor[][][][]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Actor[][][][]>();		
		async_getActorArray4dim(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorArray4dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[][][][]> asyncResult) {
		BRequest_RemoteInlineInstance_getActorArray4dim req = new BRequest_RemoteInlineInstance_getActorArray4dim();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor[][][][]> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Actor[][][][]>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorList(java.util.List<com.wilutions.byps.test.api.inl.Actor> actorList) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorList(actorList, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorList(java.util.List<com.wilutions.byps.test.api.inl.Actor> actorList, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorList req = new BRequest_RemoteInlineInstance_setActorList();		
		req.actorList = actorList;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.List<com.wilutions.byps.test.api.inl.Actor> getActorList() throws BException, InterruptedException {
		final BSyncResult<java.util.List<com.wilutions.byps.test.api.inl.Actor>> asyncResult = new BSyncResult<java.util.List<com.wilutions.byps.test.api.inl.Actor>>();		
		async_getActorList(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorList(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		BRequest_RemoteInlineInstance_getActorList req = new BRequest_RemoteInlineInstance_getActorList();		
		BAsyncResultReceiveMethod<java.util.List<com.wilutions.byps.test.api.inl.Actor>> outerResult = new BAsyncResultReceiveMethod<java.util.List<com.wilutions.byps.test.api.inl.Actor>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> actorListList) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorListList(actorListList, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> actorListList, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorListList req = new BRequest_RemoteInlineInstance_setActorListList();		
		req.actorListList = actorListList;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> getActorListList() throws BException, InterruptedException {
		final BSyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>> asyncResult = new BSyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>>();		
		async_getActorListList(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorListList(final BAsyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>> asyncResult) {
		BRequest_RemoteInlineInstance_getActorListList req = new BRequest_RemoteInlineInstance_getActorListList();		
		BAsyncResultReceiveMethod<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorSet(java.util.Set<com.wilutions.byps.test.api.inl.Actor> actorSet) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorSet(actorSet, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorSet(java.util.Set<com.wilutions.byps.test.api.inl.Actor> actorSet, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorSet req = new BRequest_RemoteInlineInstance_setActorSet();		
		req.actorSet = actorSet;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<com.wilutions.byps.test.api.inl.Actor> getActorSet() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<com.wilutions.byps.test.api.inl.Actor>> asyncResult = new BSyncResult<java.util.Set<com.wilutions.byps.test.api.inl.Actor>>();		
		async_getActorSet(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorSet(final BAsyncResult<java.util.Set<com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		BRequest_RemoteInlineInstance_getActorSet req = new BRequest_RemoteInlineInstance_getActorSet();		
		BAsyncResultReceiveMethod<java.util.Set<com.wilutions.byps.test.api.inl.Actor>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<com.wilutions.byps.test.api.inl.Actor>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setActorMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> actorMap) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setActorMap(actorMap, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setActorMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> actorMap, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteInlineInstance_setActorMap req = new BRequest_RemoteInlineInstance_setActorMap();		
		req.actorMap = actorMap;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> getActorMap() throws BException, InterruptedException {
		final BSyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>> asyncResult = new BSyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>>();		
		async_getActorMap(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getActorMap(final BAsyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		BRequest_RemoteInlineInstance_getActorMap req = new BRequest_RemoteInlineInstance_getActorMap();		
		BAsyncResultReceiveMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>> outerResult = new BAsyncResultReceiveMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
