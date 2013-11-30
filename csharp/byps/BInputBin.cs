/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BInputBin : BInput
    {
	    public readonly BBufferBin bbuf;

	    public BInputBin(BTransport transport, BMessageHeader responseHeader, ByteBuffer buf, BRegistry registry) 
		    : base(transport, responseHeader, registry)
        {
		    this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, buf);
	    }

	    public override Object load() {
            if (header.messageId == 0)
            {
                header.read(bbuf.getBuffer());
            }

		    if (header.error != 0) {
			    Exception ex = (Exception)readObj(false, null);
			    if (ex is BException) throw (BException)ex;
			    throw new BException(header.error, ex.ToString(), ex);
		    }
		    return readObj(false, null);
	    }
	
	    protected abstract Object loadObj(BSerializer ser);
	
	    public abstract Object readObj(bool isUnique, BSerializer ser);

   }
}
