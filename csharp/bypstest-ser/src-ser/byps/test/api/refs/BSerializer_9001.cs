//
// Serializer for byps.test.api.refs.Node
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.refs
{
	
	public class BSerializer_9001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_9001();
		
		public BSerializer_9001()
			: base(9001) {}
		
		public BSerializer_9001(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Node obj = (Node)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.ListOfNodes, false, byps.test.api.BSerializer_1442786648.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.MapOfNodes, false, byps.test.api.BSerializer_2011881553.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Me, false, null);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Next, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Node obj = (Node)(obj1 != null ? obj1 : bin.onObjectCreated(new Node()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.ListOfNodes = (IList<byps.test.api.refs.Node>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.MapOfNodes = (IDictionary<String,byps.test.api.refs.Node>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Me = (byps.test.api.refs.Node)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Next = (byps.test.api.refs.Node)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
