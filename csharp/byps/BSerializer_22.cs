/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_22 : BSerializer
    {
	    public static BSerializer instance = new BSerializer_22();

	    public BSerializer_22() 
            : base(BRegistry.TYPEID_VALUECLASS)
        {
	    }

	    public BSerializer_22(int typeId) 
            : base(typeId)
        {
	    }

        public override void write(Object obj1, BOutput bout1, long version)
        {
		    BOutputBin bout = ((BOutputBin)bout1);
		    BValueClass obj = (BValueClass)obj1;
            bout.bbuf.putLong(obj.changedMembers);
	    }

        public override Object read(Object obj1, BInput bin1, long version)
        {
		    BInputBin bin = ((BInputBin)bin1);
		    long v = bin.bbuf.getLong();
            BValueClass obj = (BValueClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BValueClass()));
            obj.changedMembers = v;
		    return obj;
	    }


    }
}
