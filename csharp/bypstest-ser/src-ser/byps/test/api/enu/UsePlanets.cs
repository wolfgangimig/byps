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
		
		public UsePlanets(EnumPlanets @planet, EnumPlanets @planet2, EnumPlanets[] @arrayOfPlanets, List<EnumPlanets> @listOfPlanets, IDictionary<String,EnumPlanets> @mapOfPlanets) {
			this.planetValue = @planet;
			this.planet2Value = @planet2;
			this.arrayOfPlanetsValue = @arrayOfPlanets;
			this.listOfPlanetsValue = @listOfPlanets;
			this.mapOfPlanetsValue = @mapOfPlanets;
		}		
		
		public UsePlanets(UsePlanets rhs)
		{
			this.planetValue = rhs.planetValue;
			this.planet2Value = rhs.planet2Value;
			this.arrayOfPlanetsValue = rhs.arrayOfPlanetsValue;
			this.listOfPlanetsValue = rhs.listOfPlanetsValue;
			this.mapOfPlanetsValue = rhs.mapOfPlanetsValue;
		}		
		
		#endregion
		
		#region Properties
		
		public EnumPlanets Planet
		{
			get
			{
				return planetValue;
			}
			set
			{
				this.planetValue = value;
			}
		}
		
		
		public EnumPlanets Planet2
		{
			get
			{
				return planet2Value;
			}
			set
			{
				this.planet2Value = value;
			}
		}
		
		
		public EnumPlanets[] ArrayOfPlanets
		{
			get
			{
				return arrayOfPlanetsValue;
			}
			set
			{
				this.arrayOfPlanetsValue = value;
			}
		}
		
		
		public List<EnumPlanets> ListOfPlanets
		{
			get
			{
				return listOfPlanetsValue;
			}
			set
			{
				this.listOfPlanetsValue = value;
			}
		}
		
		
		public IDictionary<String,EnumPlanets> MapOfPlanets
		{
			get
			{
				return mapOfPlanetsValue;
			}
			set
			{
				this.mapOfPlanetsValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected EnumPlanets planetValue;

		protected EnumPlanets planet2Value;

		protected EnumPlanets[] arrayOfPlanetsValue;

		protected List<EnumPlanets> listOfPlanetsValue;

		protected IDictionary<String,EnumPlanets> mapOfPlanetsValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 10000L;		
	} // end class
}  // end namespace
