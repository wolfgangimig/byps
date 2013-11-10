//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class Class1Collections : BSerializable
	{
	
		#region Constructors
		
		public Class1Collections() {
		}		
		
		internal Class1Collections(IList<Class1> @list1, IDictionary<String,Class1> @map1, ISet<Class1> @set1) {
			this.list1Value = @list1;
			this.map1Value = @map1;
			this.set1Value = @set1;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<Class1> List1
		{
			get
			{
				return list1Value;
			}
			set
			{
				this.list1Value = value;
			}
		}
		
		
		public IDictionary<String,Class1> Map1
		{
			get
			{
				return map1Value;
			}
			set
			{
				this.map1Value = value;
			}
		}
		
		
		public ISet<Class1> Set1
		{
			get
			{
				return set1Value;
			}
			set
			{
				this.set1Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected IList<Class1> list1Value;

		protected IDictionary<String,Class1> map1Value;

		protected ISet<Class1> set1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 6004L;		
	} // end class
}  // end namespace
