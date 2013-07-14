package com.wilutions.byps;

import java.util.ArrayList;

public interface BServerRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws BException;
	public BClient getForwardClientIfForeignTargetId(BTargetId targetId) throws BException;
	public ArrayList<BClient> getForwardClientsToOtherServers() throws BException;
}
