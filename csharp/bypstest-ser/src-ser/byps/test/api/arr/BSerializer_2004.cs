//
// Serializer for byps.test.api.arr.ArrayTypes4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.arr
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
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Boolean4, false, byps.test.api.BSerializer_945713488.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Byte4, false, byps.test.api.BSerializer_1201775504.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Char4, false, byps.test.api.BSerializer_769021986.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Double4, false, byps.test.api.BSerializer_2087445849.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Float4, false, byps.test.api.BSerializer_1516687588.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Int4, false, byps.test.api.BSerializer_39910537.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Long4, false, byps.test.api.BSerializer_846419204.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.PrimitiveTypes4, false, byps.test.api.BSerializer_758319514.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Short4, false, byps.test.api.BSerializer_1859644668.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.String4, true, byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ArrayTypes4dim obj = (ArrayTypes4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new ArrayTypes4dim()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Boolean4 = (bool[,,,])bin.readObj(false, byps.test.api.BSerializer_945713488.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Byte4 = (byte[,,,])bin.readObj(false, byps.test.api.BSerializer_1201775504.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Char4 = (char[,,,])bin.readObj(false, byps.test.api.BSerializer_769021986.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Double4 = (double[,,,])bin.readObj(false, byps.test.api.BSerializer_2087445849.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Float4 = (float[,,,])bin.readObj(false, byps.test.api.BSerializer_1516687588.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Int4 = (int[,,,])bin.readObj(false, byps.test.api.BSerializer_39910537.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Long4 = (long[,,,])bin.readObj(false, byps.test.api.BSerializer_846419204.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.PrimitiveTypes4 = (byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Short4 = (short[,,,])bin.readObj(false, byps.test.api.BSerializer_1859644668.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.String4 = (String[,,,])bin.readObj(false, byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
