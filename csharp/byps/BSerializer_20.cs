using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
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
	
	    public override void write(Object obj, BOutput bout1, int version) {
		    BOutputBin bout = ((BOutputBin)bout1);
		    BException e = (BException)obj;
		    bout.bbuf.putInt(e.Code);
		    bout.bbuf.putString(e.Message);
		    bout.bbuf.putString(e.Details);
	    }

	    public override Object read(Object obj, BInput bin1, int version) {
		    BInputBin bin = ((BInputBin)bin1);
		    int code = bin.bbuf.getInt();
		    String msg = bin.bbuf.getString();
		    String details = bin.bbuf.getString();
		    BException e = new BException(code, msg, details);
		    return e;
	    }


    }
}
