package com.wilutions.byps.test.servlet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.ver.BSkeleton_EvolveIF;
import com.wilutions.byps.test.api.ver.BStub_EvolveIF;
import com.wilutions.byps.test.api.ver.Evolve;
import com.wilutions.byps.test.api.ver.EvolveIF;

public class MyEvolve extends BSkeleton_EvolveIF {
	
	private Evolve obj;
	private MySession sess;
	private EvolveIF client;

	public MyEvolve(MySession sess) {
		this.sess = sess;
	}

	@Override
	public void setEvolve(Evolve obj) throws BException, InterruptedException {
		this.obj = obj;
	}

	@Override
	public Evolve getEvolve() throws BException, InterruptedException {
		return obj;
	}

	@Override
	public EvolveIF getClient() throws BException, InterruptedException {
		if (client != null) return client;
		return (EvolveIF)sess.getClientR().getStub((int)BStub_EvolveIF.serialVersionUID);
	}
	
	@Override
	public void setClient(EvolveIF partner) throws BException, InterruptedException {
		client = partner;
	}

	@Override
	public void sendEvolveToClient() throws BException, InterruptedException {
		getClient().setEvolve(obj);
	}
}
