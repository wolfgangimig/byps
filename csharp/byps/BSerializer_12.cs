/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_12 : BSerializer
    {
	    public static readonly BSerializer instance = new BSerializer_12();
	
	    public BSerializer_12()
		    : base(BRegistry.TYPEID_LIST)
        {
	    }

	    protected BSerializer_12(int typeId) 
            : base(typeId)
        {
	    }

        public override Object read(Object obj1, BInput bin1, long version)
        {
            BInputBin bin = ((BInputBin)bin1);
            BBufferBin bbuf = bin.bbuf;
            int n = bbuf.getLength();
            List<Object> arr = new List<Object>();
            for (int i = 0; i < n; i++)
            {
                Object obj = (Object)bin.readObj(false, null);
                arr.Add(obj);
            }
            return arr;
        }

        public override void write(Object obj1, BOutput bout1, long version)
        {
            BOutputBin bout = ((BOutputBin)bout1);
            BBufferBin bbuf = bout.bbuf;
            ICollection<Object> arr = (ICollection<Object>)obj1;
            int n = arr.Count;
            bout.bbuf.putLength(n);
            foreach (Object obj in arr)
            {
                bout.writeObj(obj, false, null);
            }
        }

    }
}
