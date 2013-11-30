/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_14 : BSerializer_12
    {
	    public readonly static new BSerializer instance = new BSerializer_14();

	    public BSerializer_14() 
            :base(BRegistry.TYPEID_SET)
        {
	    }

	    public BSerializer_14(int typeId) 
            :base(typeId)
        {
	    }

        public override Object read(Object obj1, BInput bin1, long version)
        {
            BInputBin bin = ((BInputBin)bin1);
            BBufferBin bbuf = bin.bbuf;
            int n = bbuf.getLength();
            HashSet<Object> arr = new HashSet<Object>();
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
            HashSet<Object> arr = (HashSet<Object>)obj1;
            int n = arr.Count;
            bout.bbuf.putLength(n);
            foreach (Object obj in arr)
            {
                bout.writeObj(obj, false, null);
            }
        }


    }
}
