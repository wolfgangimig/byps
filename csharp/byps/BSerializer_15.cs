/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_15 : BSerializer
    {

	    public readonly static BSerializer instance = new BSerializer_15();

        public BSerializer_15()
            : base(BRegistry.TYPEID_STREAM)
        {
        }

        public override void write(Object obj, BOutput bout1, long version)
        {
		    BOutputBin bout = ((BOutputBin)bout1);
		    Stream strm = (Stream)obj;
		    BStreamRequest streamRequest = bout.createStreamRequest(strm);
		    bout.bbuf.putLong(streamRequest.streamId);
	    }

        public override Object read(Object obj, BInput bin1, long version)
        {
            BInputBin bin = ((BInputBin)bin1);
            long streamId = bin.bbuf.getLong();
            try
            {
                Stream strm = bin.transport.getWire().getStream(bin.header.messageId, streamId);
                return strm;
            }
            catch (IOException e)
            {
                throw new BException(BExceptionC.IOERROR, e.ToString());
            }
	    }

    }
}
