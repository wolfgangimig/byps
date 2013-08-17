//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class Evolve2 : BSerializable
	{
	
		#region Constructors
		
		public Evolve2() {
		}		
		
		internal Evolve2(int @n1) {
			this._n1 = @n1;
		}		
		
		#endregion
		
		#region Properties
		
		public int N1
		{
			get
			{
				return _n1;
			}
			set
			{
				this._n1 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int _n1;

		#endregion
		
		
		public static readonly long serialVersionUID = 573592593L;		
	} // end class
}  // end namespace
