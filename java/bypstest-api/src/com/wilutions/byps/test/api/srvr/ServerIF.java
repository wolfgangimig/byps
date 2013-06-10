package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

public interface ServerIF extends BRemote {

	public int callClientIncrementInt(int v) throws BException, InterruptedException;
	
	public void setPartner(ClientIF client) throws BException, InterruptedException;
	
	public ClientIF getPartner() throws BException, InterruptedException;
	
	public List<InputStream> getStreamsFromClient() throws BException, InterruptedException;
	
	public void putStreamsOnClient(List<InputStream> streams) throws BException, InterruptedException;
	
	public void registerWithClientMap(int id) throws BException, InterruptedException;
	
	public ClientIF getClient(int id) throws BException, InterruptedException;
	
	public Set<Integer> getClientIds() throws BException, InterruptedException;

	public int callClientParallel(int v) throws BException, InterruptedException;
	
}
