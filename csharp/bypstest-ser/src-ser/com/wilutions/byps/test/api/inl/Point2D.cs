//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
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
		
		internal Point2D(short @x, short @y) {
			this._x = @x;
			this._y = @y;
		}		
		
		#endregion
		
		#region Properties
		
		public short X
		{
			get
			{
				return _x;
			}
			set
			{
				this._x = value;
			}
		}
		
		
		public short Y
		{
			get
			{
				return _y;
			}
			set
			{
				this._y = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		private short _x;

		private short _y;

		#endregion
		
		
		public static readonly long serialVersionUID = 1835035436L;		
	} // end class
}  // end namespace
