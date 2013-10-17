﻿package com.wilutions.byps.test.api.inherit;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:164
public class BStub_BioLemonService extends BStub implements BioLemonServiceAuth, java.io.Serializable {
	
	// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 1992245333L;
	
	public BStub_BioLemonService(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:357
	public java.lang.String grow() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		grow(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:401
	public void grow(final BAsyncResult<String> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:113
		BRequest_PlantService_grow req = new BRequest_PlantService_grow();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:357
	public java.lang.String pick(java.lang.String fromTree) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		pick(fromTree, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:401
	public void pick(java.lang.String fromTree, final BAsyncResult<String> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:113
		BRequest_LemonService_pick req = new BRequest_LemonService_pick();		
		req.fromTree = fromTree;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:357
	public int useParing() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:46
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		useParing(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:401
	public void useParing(final BAsyncResult<Integer> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:113
		BRequest_BioLemonService_useParing req = new BRequest_BioLemonService_useParing();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:357
	public boolean certify(java.lang.String param) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:46
		final BSyncResult<Boolean> asyncResult = new BSyncResult<Boolean>();		
		certify(param, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:401
	public void certify(java.lang.String param, final BAsyncResult<Boolean> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:113
		BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();		
		req.param = param;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:357
	public java.lang.String squeeze() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:46
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		squeeze(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:401
	public void squeeze(final BAsyncResult<String> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:113
		BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();		
		transport.sendMethod(req, asyncResult);
	}
	
	
}