package com.wilutions.byps.test.api.ver;

/**
 * 
 * @BRemote
 *
 */
public interface EvolveIF {

	public void setEvolve(Evolve obj);
	
	public Evolve getEvolve();
	
	public void setClient(EvolveIF partner);
	
	public EvolveIF getClient();
	
	public void sendEvolveToClient();
}
