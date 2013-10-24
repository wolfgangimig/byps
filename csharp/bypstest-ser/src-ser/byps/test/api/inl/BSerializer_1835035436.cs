//
// Serializer for byps.test.api.inl.Point2D
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	public class BSerializer_1835035436 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1835035436();
		
		public BSerializer_1835035436()
			: base(1835035436, true) {}
		
		public BSerializer_1835035436(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Point2D obj = (Point2D)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj.X);
			bbuf.putShort(obj.Y);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
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
