//
// Serializer for byps.test.api.set.SetTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.set
{
	
	public class BSerializer_5001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_5001();
		
		public BSerializer_5001()
			: base(5001) {}
		
		public BSerializer_5001(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			SetTypes obj = (SetTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Boolean1, false, byps.test.api.BSerializer_1365696060.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Byte1, false, byps.test.api.BSerializer_31512998.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Byte2, false, byps.test.api.BSerializer_2052431866.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Char1, false, byps.test.api.BSerializer_936607009.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Date1, false, byps.test.api.BSerializer_1097919350.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Double1, false, byps.test.api.BSerializer_1320560671.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Float1, false, byps.test.api.BSerializer_1898022288.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Int1, false, byps.test.api.BSerializer_1493282670.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Int2, false, byps.test.api.BSerializer_1406124761.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Long1, false, byps.test.api.BSerializer_1457164460.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Obj1, false, byps.BSerializer_14.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.PrimitiveTypes1, false, byps.test.api.BSerializer_673917574.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Short1, false, byps.test.api.BSerializer_2028443792.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.String1, false, byps.test.api.BSerializer_1888799711.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			SetTypes obj = (SetTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new SetTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Boolean1 = (ISet<bool>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Byte1 = (HashSet<byte>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Byte2 = (ISet<byte[]>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Char1 = (HashSet<char>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Date1 = (ISet<DateTime>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Double1 = (ISet<double>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Float1 = (ISet<float>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Int1 = (ISet<int>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Int2 = (ISet<int[]>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Long1 = (ISet<long>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Obj1 = (ISet<Object>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.PrimitiveTypes1 = (ISet<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Short1 = (ISet<short>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.String1 = (ISet<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
