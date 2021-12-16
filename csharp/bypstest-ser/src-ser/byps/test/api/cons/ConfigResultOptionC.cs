//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	/// <summary>
	/// Zum Prüfen von BYPS-57.
	/// </summary>
	public class ConfigResultOptionC : BValueClass, BSerializable
	{
	
		#region Constructors
		
		public ConfigResultOptionC() {
		}		
		
		public ConfigResultOptionC(ConfigResultOptionC rhs) : base(rhs)
		{
		}		
		
		#endregion
		
		#region Properties
		
		#endregion
		
		#region Fields
		
		public readonly static ConfigResultOption DEFAULT_1 = new ConfigResultOption(GroupingType.BY_KEY, "");

		public readonly static ConfigResultOption DEFAULT_2 = new ConfigResultOption(GroupingType.BY_KEY, "default2");

		public readonly static ConfigResultOption DEFAULT_3 = new ConfigResultOption(GroupingType.LEGACY, "default3");

		#endregion
		
		
		public static readonly new long serialVersionUID = 114832566L;		
	} // end class
}  // end namespace
