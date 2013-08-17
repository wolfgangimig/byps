//
// Serializer for com.wilutions.byps.test.api.inl.Matrix2D
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
{
	
	public class BSerializer_135329019 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_135329019();
		
		public BSerializer_135329019()
			: base(135329019, true) {}
		
		public BSerializer_135329019(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: _11 */ + 4			
			       /* pos=4: _12 */ + 4			
			       /* pos=8: _13 */ + 4			
			       /* pos=12: _21 */ + 4			
			       /* pos=16: _22 */ + 4			
			       /* pos=20: _23 */ + 4			
			       /* pos=24: _31 */ + 4			
			       /* pos=28: _32 */ + 4			
			       /* pos=32: _33 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
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
		
		public override Object read(Object obj1, BInput bin1, int version)
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
