//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	/// <summary>
	/// Example for an inline class.
	/// </summary>
	/// <remarks>
	/// Final classes cannot be evolved or derived.
	/// Objects of final classes are serialized without
	/// the overhead of type and reference information.
	/// This optimization is especially useful in the case of
	/// large arrays of small objects being serialized.
	/// </remarks>
	public class Point2D : BSerializable
	{
	
		#region Constructors
		
		public Point2D() {
		}		
		
		public Point2D(short @x, short @y) {
			this.xValue = @x;
			this.yValue = @y;
		}		
		
		public Point2D(Point2D rhs)
		{
			this.xValue = rhs.xValue;
			this.yValue = rhs.yValue;
		}		
		
		#endregion
		
		#region Properties
		
		public short X
		{
			get
			{
				return xValue;
			}
			set
			{
				this.xValue = value;
			}
		}
		
		
		public short Y
		{
			get
			{
				return yValue;
			}
			set
			{
				this.yValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		private short xValue;

		private short yValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1835035436L;		
	} // end class
}  // end namespace
