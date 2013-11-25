//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class Evolve2 : BSerializable
	{
	
		#region Constructors
		
		public Evolve2() {
		}		
		
		public Evolve2(int @n1) {
			this.n1Value = @n1;
		}		
		
		public Evolve2(Evolve2 rhs)
		{
			this.n1Value = rhs.n1Value;
		}		
		
		#endregion
		
		#region Properties
		
		public int N1
		{
			get
			{
				return n1Value;
			}
			set
			{
				this.n1Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int n1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 573592593L;		
	} // end class
}  // end namespace
