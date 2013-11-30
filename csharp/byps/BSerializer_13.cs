/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_13 : BSerializer 
    {

	    public readonly static BSerializer instance = new BSerializer_13();

	    public BSerializer_13() 
 		    :base(BRegistry.TYPEID_MAP)
        {
	    }
	
	    public BSerializer_13(int typeId) 
            : base(typeId)
        {
	    }

        public override object read(object obj1, BInput bin1, long version)
        {
		    BInputBin bin = ((BInputBin)bin1);
		    int n0 = bin.bbuf.getLength();
            IDictionary<Object, Object> arr = new Dictionary<Object, Object>(n0);
		    bin.onObjectCreated(arr);

		    // read
		    for (int i = 0; i < n0; i++) {
                Object key = bin.readObj(false, null);
                Object value = bin.readObj(false, null);
                arr[key] = value;
		    }

		    return arr;
        }

        public override void write(object obj1, BOutput bout1, long version)
        {
            BOutputBin bout = (BOutputBin)bout1;
            IDictionary<Object, Object> map = (IDictionary<Object, Object>)obj1;
            int n0 = map.Count;
            bout.bbuf.putLength(n0);
            foreach (Object key in map.Keys)
            {
                bout.writeObj(key, false, null);
                bout.writeObj(map[key], false, null);
            }
        }

    }
}

