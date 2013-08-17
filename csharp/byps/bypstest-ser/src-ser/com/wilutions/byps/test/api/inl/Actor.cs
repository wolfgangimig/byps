//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
{
	
	public class Actor : BSerializable
	{
	
		#region Constructors
		
		public Actor() {
		}		
		
		internal Actor(Point2D[] @shape, Matrix2D @position) {
			this._shape = @shape;
			this._position = @position;
		}		
		
		#endregion
		
		#region Properties
		
		public Point2D[] Shape
		{
			get
			{
				return _shape;
			}
			set
			{
				this._shape = value;
			}
		}
		
		
		public Matrix2D Position
		{
			get
			{
				return _position;
			}
			set
			{
				this._position = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected Point2D[] _shape;

		protected Matrix2D _position;

		#endregion
		
		
		public static readonly long serialVersionUID = 171948703L;		
	} // end class
}  // end namespace
