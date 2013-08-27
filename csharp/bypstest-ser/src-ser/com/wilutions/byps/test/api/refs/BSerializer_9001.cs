//
// Serializer for com.wilutions.byps.test.api.refs.Node
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.refs
{
	
	public class BSerializer_9001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_9001();
		
		public BSerializer_9001()
			: base(9001) {}
		
		public BSerializer_9001(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: next */ + 4			
			       /* pos=4: me */ + 4			
			       /* pos=8: mapOfNodes */ + 4			
			       /* pos=12: listOfNodes */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Node obj = (Node)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.ListOfNodes, false, com.wilutions.byps.test.api.BSerializer_202657921.instance);
			bout.writeObj(obj.MapOfNodes, false, com.wilutions.byps.test.api.BSerializer_1768677016.instance);
			bout.writeObj(obj.Me, false, null);
			bout.writeObj(obj.Next, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Node obj = (Node)(obj1 != null ? obj1 : bin.onObjectCreated(new Node()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.ListOfNodes = (IList<com.wilutions.byps.test.api.refs.Node>)bin.readObj(false, null);
			obj.MapOfNodes = (IDictionary<String,com.wilutions.byps.test.api.refs.Node>)bin.readObj(false, null);
			obj.Me = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
			obj.Next = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
