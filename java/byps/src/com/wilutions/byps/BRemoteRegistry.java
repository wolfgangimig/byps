package com.wilutions.byps;

public interface BRemoteRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws BException;
}
