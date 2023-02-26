//
// Serializer for byps.test.api.BResult_1823330785
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_114088296 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_114088296();
		
		public BSerializer_114088296()
			: base(114088296) {}
		
		public BSerializer_114088296(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1823330785 obj = (BResult_1823330785)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1823330785.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1823330785 obj = (BResult_1823330785)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1823330785()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (IList<IList<byps.test.api.inl.Point2D>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
