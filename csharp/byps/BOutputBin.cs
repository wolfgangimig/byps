using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BOutputBin : BOutput
    {
	    public readonly BBufferBin bbuf;

	    public BOutputBin(BTransport transport, BMessageHeader requestHeader)
		    : base(transport, transport.apiDesc.getRegistry(BBinaryModel.MEDIUM), requestHeader)
        {
            this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, null);
	    }

	    public BOutputBin(BTransport transport, int streamHeaderMagic, long negotiatedVersion, ByteOrder negotiatedByteOrder) 
		    : base (transport, transport.apiDesc.getRegistry(BBinaryModel.MEDIUM), streamHeaderMagic, negotiatedVersion, negotiatedByteOrder)
        {
            this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, null);
	    }
	
	    public override ByteBuffer toByteBuffer() {
            ByteBuffer buf = bbuf.getBuffer();
            if (buf.position() != 0) {
                buf.flip();
            }
		    return buf;
	    }

	    protected override void internalStore(Object obj)  {
		    bbuf.clear();
		    if (objMap != null) objMap.clear();
		    header.write(bbuf.getBuffer());
		    storeObj(obj);
	    }
	
	    protected abstract void storeObj(Object obj);
	
	    public abstract void writeObj(Object obj, bool isUnique, BSerializer ser);	

    }
}
