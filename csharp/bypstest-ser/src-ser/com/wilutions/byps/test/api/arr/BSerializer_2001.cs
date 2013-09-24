//
// Serializer for com.wilutions.byps.test.api.arr.ArrayTypes1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.arr
{
	
	public class BSerializer_2001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2001();
		
		public BSerializer_2001()
			: base(2001) {}
		
		public BSerializer_2001(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ArrayTypes1dim obj = (ArrayTypes1dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Boolean1, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			bout.writeObj(obj.Byte1, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			bout.writeObj(obj.Char1, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			bout.writeObj(obj.Double1, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			bout.writeObj(obj.Float1, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			bout.writeObj(obj.Int1, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.Long1, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			bout.writeObj(obj.PrimitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
			bout.writeObj(obj.Short1, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			bout.writeObj(obj.String1, true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ArrayTypes1dim obj = (ArrayTypes1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new ArrayTypes1dim()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Boolean1 = (bool[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			obj.Byte1 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			obj.Char1 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			obj.Double1 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			obj.Float1 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			obj.Int1 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj.Long1 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			obj.PrimitiveTypes1 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
			obj.Short1 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			obj.String1 = (String[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			
			return obj;
		}
		
	}
} // namespace
