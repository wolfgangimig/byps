package byps;

import byps.BException;
import byps.BRemote;
import byps.BTargetId;

public interface BRemoteRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws BException;
}
