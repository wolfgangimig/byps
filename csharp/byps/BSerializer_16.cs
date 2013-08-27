using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BSerializer_16 : BSerializer
    {
	    public BSerializer_16(int typeId) 
            : base(typeId)
        {
	    }

        public override void write(Object obj, BOutput bout1, long version)
        {
		    BOutputBin bout = ((BOutputBin)bout1);
		    BRemote remote = (BRemote)obj;
		    BTargetId targetId = remote.BRemote_getTargetId();
		    targetId.write(bout.bbuf.getBuffer());
	    }

        public override Object read(Object obj, BInput bin1, long version)
        {
		    BInputBin bin = ((BInputBin)bin1);
		    BRemote remote = null;
		    BTargetId targetId = BTargetId.read(bin.bbuf.getBuffer());
		    BRemoteRegistry rreg = bin.transport.remoteRegistry;
		    if (rreg != null) {
			    remote = rreg.getRemote(bin.header.targetId, targetId, typeId);
		    }
		    else {
			    BTransport transport = new BTransport(bin.transport, targetId);
			    remote = internalCreate(transport);
		    }
		    return remote;
	    }

	    protected virtual BRemote internalCreate(BTransport transport) {
		    return null; // must be implemented by subclass
	    }

    }
}
