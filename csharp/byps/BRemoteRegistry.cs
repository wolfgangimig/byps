using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public interface BRemoteRegistry
    {
        BRemote getRemote(BTargetId serverId, BTargetId clientId, int remoteId);
    }
}
