//
// Serializer for byps.test.api.inl.Matrix2D
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	public class BSerializer_135329019 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_135329019();
		
		public BSerializer_135329019()
			: base(135329019, true) {}
		
		public BSerializer_135329019(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Matrix2D obj = (Matrix2D)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._11);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._12);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._13);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._21);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._22);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._23);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._31);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._32);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj._33);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : new Matrix2D());
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj._11 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._12 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._13 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._21 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._22 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._23 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._31 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._32 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj._33 = bbuf.getFloat();
			
			return obj;
		}
		
	}
} // namespace
