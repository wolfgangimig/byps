package com.wilutions.byps.test.api.ver;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

/**
 */
public interface EvolveIF extends BRemote {

	public void setEvolve(Evolve obj) throws BException, InterruptedException;
	
	public Evolve getEvolve() throws BException, InterruptedException;
	
	public void setClient(EvolveIF partner) throws BException, InterruptedException;
	
	public EvolveIF getClient() throws BException, InterruptedException;
	
	public void sendEvolveToClient() throws BException, InterruptedException;
}
