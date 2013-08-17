//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class Class1Collections : BSerializable
	{
	
		#region Constructors
		
		public Class1Collections() {
		}		
		
		internal Class1Collections(IList<Class1> @list1, IDictionary<String,Class1> @map1, ISet<Class1> @set1) {
			this._list1 = @list1;
			this._map1 = @map1;
			this._set1 = @set1;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<Class1> List1
		{
			get
			{
				return _list1;
			}
			set
			{
				this._list1 = value;
			}
		}
		
		
		public IDictionary<String,Class1> Map1
		{
			get
			{
				return _map1;
			}
			set
			{
				this._map1 = value;
			}
		}
		
		
		public ISet<Class1> Set1
		{
			get
			{
				return _set1;
			}
			set
			{
				this._set1 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected IList<Class1> _list1;

		protected IDictionary<String,Class1> _map1;

		protected ISet<Class1> _set1;

		#endregion
		
		
		public static readonly long serialVersionUID = 6004L;		
	} // end class
}  // end namespace
