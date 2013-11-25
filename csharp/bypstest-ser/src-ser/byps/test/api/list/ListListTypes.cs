//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.list
{
	
	public class ListListTypes : BSerializable
	{
	
		#region Constructors
		
		public ListListTypes() {
		}		
		
		public ListListTypes(IList<IList<int>> @int2, IList<IDictionary<int,IList<HashSet<int>>>> @int3, IList<IList<int[,,,]>> @int24) {
			this.int2Value = @int2;
			this.int3Value = @int3;
			this.int24Value = @int24;
		}		
		
		public ListListTypes(ListListTypes rhs)
		{
			this.int2Value = rhs.int2Value;
			this.int3Value = rhs.int3Value;
			this.int24Value = rhs.int24Value;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<IList<int>> Int2
		{
			get
			{
				return int2Value;
			}
			set
			{
				this.int2Value = value;
			}
		}
		
		
		public IList<IDictionary<int,IList<HashSet<int>>>> Int3
		{
			get
			{
				return int3Value;
			}
			set
			{
				this.int3Value = value;
			}
		}
		
		
		public IList<IList<int[,,,]>> Int24
		{
			get
			{
				return int24Value;
			}
			set
			{
				this.int24Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected IList<IList<int>> int2Value;

		protected IList<IDictionary<int,IList<HashSet<int>>>> int3Value;

		protected IList<IList<int[,,,]>> int24Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 3002L;		
	} // end class
}  // end namespace
