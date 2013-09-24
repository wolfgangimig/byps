//
// Serializer for com.wilutions.byps.test.api.arr.ArrayTypes4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.arr
{
	
	public class BSerializer_2004 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2004();
		
		public BSerializer_2004()
			: base(2004) {}
		
		public BSerializer_2004(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ArrayTypes4dim obj = (ArrayTypes4dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Boolean4, false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
			bout.writeObj(obj.Byte4, false, com.wilutions.byps.test.api.BSerializer_1201775504.instance);
			bout.writeObj(obj.Char4, false, com.wilutions.byps.test.api.BSerializer_769021986.instance);
			bout.writeObj(obj.Double4, false, com.wilutions.byps.test.api.BSerializer_2087445849.instance);
			bout.writeObj(obj.Float4, false, com.wilutions.byps.test.api.BSerializer_1516687588.instance);
			bout.writeObj(obj.Int4, false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			bout.writeObj(obj.Long4, false, com.wilutions.byps.test.api.BSerializer_846419204.instance);
			bout.writeObj(obj.PrimitiveTypes4, false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
			bout.writeObj(obj.Short4, false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
			bout.writeObj(obj.String4, true, com.wilutions.byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ArrayTypes4dim obj = (ArrayTypes4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new ArrayTypes4dim()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Boolean4 = (bool[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
			obj.Byte4 = (byte[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1201775504.instance);
			obj.Char4 = (char[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_769021986.instance);
			obj.Double4 = (double[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2087445849.instance);
			obj.Float4 = (float[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1516687588.instance);
			obj.Int4 = (int[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			obj.Long4 = (long[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_846419204.instance);
			obj.PrimitiveTypes4 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
			obj.Short4 = (short[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
			obj.String4 = (String[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
