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
			bbuf.putFloat(obj._11);
			bbuf.putFloat(obj._12);
			bbuf.putFloat(obj._13);
			bbuf.putFloat(obj._21);
			bbuf.putFloat(obj._22);
			bbuf.putFloat(obj._23);
			bbuf.putFloat(obj._31);
			bbuf.putFloat(obj._32);
			bbuf.putFloat(obj._33);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : new Matrix2D());
			
			BBufferBin bbuf = bin.bbuf;
			obj._11 = bbuf.getFloat();
			obj._12 = bbuf.getFloat();
			obj._13 = bbuf.getFloat();
			obj._21 = bbuf.getFloat();
			obj._22 = bbuf.getFloat();
			obj._23 = bbuf.getFloat();
			obj._31 = bbuf.getFloat();
			obj._32 = bbuf.getFloat();
			obj._33 = bbuf.getFloat();
			
			return obj;
		}
		
	}
} // namespace
