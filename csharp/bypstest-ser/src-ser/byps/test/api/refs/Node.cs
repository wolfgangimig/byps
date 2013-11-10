//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.refs
{
	
	public class Node : BSerializable
	{
	
		#region Constructors
		
		public Node() {
		}		
		
		internal Node(Node @next, Node @me, IDictionary<String,Node> @mapOfNodes, IList<Node> @listOfNodes) {
			this.nextValue = @next;
			this.meValue = @me;
			this.mapOfNodesValue = @mapOfNodes;
			this.listOfNodesValue = @listOfNodes;
		}		
		
		#endregion
		
		#region Properties
		
		public Node Next
		{
			get
			{
				return nextValue;
			}
			set
			{
				this.nextValue = value;
			}
		}
		
		
		public Node Me
		{
			get
			{
				return meValue;
			}
			set
			{
				this.meValue = value;
			}
		}
		
		
		public IDictionary<String,Node> MapOfNodes
		{
			get
			{
				return mapOfNodesValue;
			}
			set
			{
				this.mapOfNodesValue = value;
			}
		}
		
		
		public IList<Node> ListOfNodes
		{
			get
			{
				return listOfNodesValue;
			}
			set
			{
				this.listOfNodesValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected Node nextValue;

		protected Node meValue;

		protected IDictionary<String,Node> mapOfNodesValue;

		protected IList<Node> listOfNodesValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 9001L;		
	} // end class
}  // end namespace
