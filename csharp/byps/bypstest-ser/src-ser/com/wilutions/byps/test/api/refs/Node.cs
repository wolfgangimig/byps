//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.refs
{
	
	public class Node : BSerializable
	{
	
		#region Constructors
		
		public Node() {
		}		
		
		internal Node(Node @next, Node @me, IDictionary<String,Node> @mapOfNodes, IList<Node> @listOfNodes) {
			this._next = @next;
			this._me = @me;
			this._mapOfNodes = @mapOfNodes;
			this._listOfNodes = @listOfNodes;
		}		
		
		#endregion
		
		#region Properties
		
		public Node Next
		{
			get
			{
				return _next;
			}
			set
			{
				this._next = value;
			}
		}
		
		
		public Node Me
		{
			get
			{
				return _me;
			}
			set
			{
				this._me = value;
			}
		}
		
		
		public IDictionary<String,Node> MapOfNodes
		{
			get
			{
				return _mapOfNodes;
			}
			set
			{
				this._mapOfNodes = value;
			}
		}
		
		
		public IList<Node> ListOfNodes
		{
			get
			{
				return _listOfNodes;
			}
			set
			{
				this._listOfNodes = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected Node _next;

		protected Node _me;

		protected IDictionary<String,Node> _mapOfNodes;

		protected IList<Node> _listOfNodes;

		#endregion
		
		
		public static readonly long serialVersionUID = 9001L;		
	} // end class
}  // end namespace
