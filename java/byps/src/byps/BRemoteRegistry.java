package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import byps.BException;
import byps.BRemote;
import byps.BTargetId;

public interface BRemoteRegistry {
	public BRemote getRemote(BTargetId clientId, int remoteId) throws BException;
}
