package com.wilutions.byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_EvolveIF extends BStub implements EvolveIF, java.io.Serializable {
	
	public final static long serialVersionUID = 2078696281L;
	
	public BStub_EvolveIF(final BTransport transport) {
		super(transport);		
	}
	
	public void setEvolve(Evolve obj) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setEvolve(obj, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setEvolve(Evolve obj, final BAsyncResult<Object> asyncResult) {
		BRequest_EvolveIF_setEvolve req = new BRequest_EvolveIF_setEvolve();		
		req.obj = obj;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public Evolve getEvolve() throws BException, InterruptedException {
		final BSyncResult<Evolve> asyncResult = new BSyncResult<Evolve>();		
		async_getEvolve(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getEvolve(final BAsyncResult<Evolve> asyncResult) {
		BRequest_EvolveIF_getEvolve req = new BRequest_EvolveIF_getEvolve();		
		BAsyncResultReceiveMethod<Evolve> outerResult = new BAsyncResultReceiveMethod<Evolve>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setClient(EvolveIF partner) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setClient(partner, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setClient(EvolveIF partner, final BAsyncResult<Object> asyncResult) {
		BRequest_EvolveIF_setClient req = new BRequest_EvolveIF_setClient();		
		req.partner = partner;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public EvolveIF getClient() throws BException, InterruptedException {
		final BSyncResult<EvolveIF> asyncResult = new BSyncResult<EvolveIF>();		
		async_getClient(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getClient(final BAsyncResult<EvolveIF> asyncResult) {
		BRequest_EvolveIF_getClient req = new BRequest_EvolveIF_getClient();		
		BAsyncResultReceiveMethod<EvolveIF> outerResult = new BAsyncResultReceiveMethod<EvolveIF>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void sendEvolveToClient() throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_sendEvolveToClient(asyncResult);
		asyncResult.getResult();		
	}
	public void async_sendEvolveToClient(final BAsyncResult<Object> asyncResult) {
		BRequest_EvolveIF_sendEvolveToClient req = new BRequest_EvolveIF_sendEvolveToClient();		
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
