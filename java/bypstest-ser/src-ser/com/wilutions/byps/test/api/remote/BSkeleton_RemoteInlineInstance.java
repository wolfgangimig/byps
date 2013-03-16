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
	public void setActorArray1dim(com.wilutions.byps.test.api.inl.Actor[] actorArray) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorArray1dim(com.wilutions.byps.test.api.inl.Actor[] actorArray, final BAsyncResult<Object> asyncResult) {
		try {
			setActorArray1dim(actorArray);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Actor[] getActorArray1dim() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorArray1dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[]> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Actor[] ret = getActorArray1dim();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setActorArray4dim(com.wilutions.byps.test.api.inl.Actor[][][][] actorArray) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorArray4dim(com.wilutions.byps.test.api.inl.Actor[][][][] actorArray, final BAsyncResult<Object> asyncResult) {
		try {
			setActorArray4dim(actorArray);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.inl.Actor[][][][] getActorArray4dim() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorArray4dim(final BAsyncResult<com.wilutions.byps.test.api.inl.Actor[][][][]> asyncResult) {
		try {
			com.wilutions.byps.test.api.inl.Actor[][][][] ret = getActorArray4dim();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setActorList(java.util.List<com.wilutions.byps.test.api.inl.Actor> actorList) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorList(java.util.List<com.wilutions.byps.test.api.inl.Actor> actorList, final BAsyncResult<Object> asyncResult) {
		try {
			setActorList(actorList);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<com.wilutions.byps.test.api.inl.Actor> getActorList() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorList(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		try {
			java.util.List<com.wilutions.byps.test.api.inl.Actor> ret = getActorList();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setActorListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> actorListList) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorListList(java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> actorListList, final BAsyncResult<Object> asyncResult) {
		try {
			setActorListList(actorListList);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> getActorListList() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorListList(final BAsyncResult<java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>> asyncResult) {
		try {
			java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> ret = getActorListList();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setActorSet(java.util.Set<com.wilutions.byps.test.api.inl.Actor> actorSet) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorSet(java.util.Set<com.wilutions.byps.test.api.inl.Actor> actorSet, final BAsyncResult<Object> asyncResult) {
		try {
			setActorSet(actorSet);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.Set<com.wilutions.byps.test.api.inl.Actor> getActorSet() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorSet(final BAsyncResult<java.util.Set<com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		try {
			java.util.Set<com.wilutions.byps.test.api.inl.Actor> ret = getActorSet();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setActorMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> actorMap) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setActorMap(java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> actorMap, final BAsyncResult<Object> asyncResult) {
		try {
			setActorMap(actorMap);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> getActorMap() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getActorMap(final BAsyncResult<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>> asyncResult) {
		try {
			java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> ret = getActorMap();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
