//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.enu
{
	
	public class UsePlanets : BSerializable
	{
	
		#region Constructors
		
		public UsePlanets() {
		}		
		
		internal UsePlanets(EnumPlanets @planet, EnumPlanets @planet2, EnumPlanets[] @arrayOfPlanets, List<EnumPlanets> @listOfPlanets, IDictionary<String,EnumPlanets> @mapOfPlanets) {
			this._planet = @planet;
			this._planet2 = @planet2;
			this._arrayOfPlanets = @arrayOfPlanets;
			this._listOfPlanets = @listOfPlanets;
			this._mapOfPlanets = @mapOfPlanets;
		}		
		
		#endregion
		
		#region Properties
		
		public EnumPlanets Planet
		{
			get
			{
				return _planet;
			}
			set
			{
				this._planet = value;
			}
		}
		
		
		public EnumPlanets Planet2
		{
			get
			{
				return _planet2;
			}
			set
			{
				this._planet2 = value;
			}
		}
		
		
		public EnumPlanets[] ArrayOfPlanets
		{
			get
			{
				return _arrayOfPlanets;
			}
			set
			{
				this._arrayOfPlanets = value;
			}
		}
		
		
		public List<EnumPlanets> ListOfPlanets
		{
			get
			{
				return _listOfPlanets;
			}
			set
			{
				this._listOfPlanets = value;
			}
		}
		
		
		public IDictionary<String,EnumPlanets> MapOfPlanets
		{
			get
			{
				return _mapOfPlanets;
			}
			set
			{
				this._mapOfPlanets = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected EnumPlanets _planet;

		protected EnumPlanets _planet2;

		protected EnumPlanets[] _arrayOfPlanets;

		protected List<EnumPlanets> _listOfPlanets;

		protected IDictionary<String,EnumPlanets> _mapOfPlanets;

		#endregion
		
		
		public static readonly long serialVersionUID = 10000L;		
	} // end class
}  // end namespace
