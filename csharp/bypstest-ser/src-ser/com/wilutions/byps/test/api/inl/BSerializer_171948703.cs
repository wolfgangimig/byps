//
// Serializer for com.wilutions.byps.test.api.inl.Actor
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
{
	
	public class BSerializer_171948703 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_171948703();
		
		public BSerializer_171948703()
			: base(171948703) {}
		
		public BSerializer_171948703(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: shape */ + 4			
			       /* pos=4: position */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Actor obj = (Actor)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Position, false, com.wilutions.byps.test.api.inl.BSerializer_135329019.instance);
			bout.writeObj(obj.Shape, false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Actor obj = (Actor)(obj1 != null ? obj1 : bin.onObjectCreated(new Actor()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Position = (com.wilutions.byps.test.api.inl.Matrix2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_135329019.instance);
			obj.Shape = (com.wilutions.byps.test.api.inl.Point2D[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
			
			return obj;
		}
		
	}
} // namespace
