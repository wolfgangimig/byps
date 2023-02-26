//
// Serializer for byps.test.api.inl.Actor
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	public class BSerializer_171948703 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_171948703();
		
		public BSerializer_171948703()
			: base(171948703) {}
		
		public BSerializer_171948703(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Actor obj = (Actor)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Position, false, byps.test.api.inl.BSerializer_135329019.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Shape, false, byps.test.api.BSerializer_184101377.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Actor obj = (Actor)(obj1 != null ? obj1 : bin.onObjectCreated(new Actor()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Position = (byps.test.api.inl.Matrix2D)bin.readObj(false, byps.test.api.inl.BSerializer_135329019.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Shape = (byps.test.api.inl.Point2D[])bin.readObj(false, byps.test.api.BSerializer_184101377.instance);
			
			return obj;
		}
		
	}
} // namespace
