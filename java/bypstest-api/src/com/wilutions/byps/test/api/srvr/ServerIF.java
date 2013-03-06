package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.wilutions.byps.BRemote;

public interface ServerIF extends BRemote {

	public int callClientIncrementInt(int v);
	
	public void setPartner(ClientIF client);
	
	public ClientIF getPartner();
	
	public List<InputStream> getStreamsFromClient();
	
	public void putStreamsOnClient(List<InputStream> streams);
	
	public void registerWithClientMap(int id);
	
	public ClientIF getClient(int id);
	
	public Set<Integer> getClientIds();
}
