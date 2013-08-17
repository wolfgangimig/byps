//
// Serializer for com.wilutions.byps.test.api.inl.Point2D
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
{
	
	public class BSerializer_1835035436 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1835035436();
		
		public BSerializer_1835035436()
			: base(1835035436, true) {}
		
		public BSerializer_1835035436(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: x */ + 2			
			       /* pos=2: y */ + 2			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			Point2D obj = (Point2D)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj.X);
			bbuf.putShort(obj.Y);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			Point2D obj = (Point2D)(obj1 != null ? obj1 : new Point2D());
			
			BBufferBin bbuf = bin.bbuf;
			obj.X = bbuf.getShort();
			obj.Y = bbuf.getShort();
			
			return obj;
		}
		
	}
} // namespace
