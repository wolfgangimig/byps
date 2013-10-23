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
		
		internal ListListTypes(IList<IList<int>> @int2, IList<IDictionary<int,IList<HashSet<int>>>> @int3, IList<IList<int[,,,]>> @int24) {
			this._int2 = @int2;
			this._int3 = @int3;
			this._int24 = @int24;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<IList<int>> Int2
		{
			get
			{
				return _int2;
			}
			set
			{
				this._int2 = value;
			}
		}
		
		
		public IList<IDictionary<int,IList<HashSet<int>>>> Int3
		{
			get
			{
				return _int3;
			}
			set
			{
				this._int3 = value;
			}
		}
		
		
		public IList<IList<int[,,,]>> Int24
		{
			get
			{
				return _int24;
			}
			set
			{
				this._int24 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected IList<IList<int>> _int2;

		protected IList<IDictionary<int,IList<HashSet<int>>>> _int3;

		protected IList<IList<int[,,,]>> _int24;

		#endregion
		
		
		public static readonly long serialVersionUID = 3002L;		
	} // end class
}  // end namespace
