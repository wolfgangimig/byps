//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	public class Actor : BSerializable
	{
	
		#region Constructors
		
		public Actor() {
		}		
		
		internal Actor(Point2D[] @shape, Matrix2D @position) {
			this.shapeValue = @shape;
			this.positionValue = @position;
		}		
		
		#endregion
		
		#region Properties
		
		public Point2D[] Shape
		{
			get
			{
				return shapeValue;
			}
			set
			{
				this.shapeValue = value;
			}
		}
		
		
		public Matrix2D Position
		{
			get
			{
				return positionValue;
			}
			set
			{
				this.positionValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected Point2D[] shapeValue;

		protected Matrix2D positionValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 171948703L;		
	} // end class
}  // end namespace
