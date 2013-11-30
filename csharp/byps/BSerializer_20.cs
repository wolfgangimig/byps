/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_20 : BSerializer
    {
	    public static BSerializer instance = new BSerializer_20();

	    public BSerializer_20() 
            : base(BRegistry.TYPEID_EXCEPTION)
        {
	    }

	    public BSerializer_20(int typeId) 
            : base(typeId)
        {
	    }

        public override void write(Object obj, BOutput bout1, long version)
        {
		    BOutputBin bout = ((BOutputBin)bout1);
		    BException e = (BException)obj;
		    bout.bbuf.putInt(e.Code);
		    bout.bbuf.putString(e.Message);
		    bout.bbuf.putString(e.Details);
	    }

        public override Object read(Object obj, BInput bin1, long version)
        {
		    BInputBin bin = ((BInputBin)bin1);
		    int code = bin.bbuf.getInt();
		    String msg = bin.bbuf.getString();
		    String details = bin.bbuf.getString();
		    BException e = new BException(code, msg, details);
		    return e;
	    }


    }
}
