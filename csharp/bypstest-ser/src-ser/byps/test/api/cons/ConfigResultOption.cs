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
	public class ConfigResultOption : BValueClass, BSerializable
	{
	
		#region Constructors
		
		public ConfigResultOption() {
		}		
		
		public ConfigResultOption(GroupingType @groupingType, String @string1) {
			this.groupingTypeValue = @groupingType;
			this.string1Value = @string1;
		}		
		
		public ConfigResultOption(ConfigResultOption rhs) : base(rhs)
		{
			this.groupingTypeValue = rhs.groupingTypeValue;
			this.string1Value = rhs.string1Value;
		}		
		
		#endregion
		
		#region Properties
		
		public GroupingType GroupingType
		{
			get
			{
				return groupingTypeValue;
			}
			set
			{
				this.groupingTypeValue = value;
			}
		}
		
		
		public String String1
		{
			get
			{
				return string1Value;
			}
			set
			{
				this.string1Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected GroupingType groupingTypeValue;

		protected String string1Value;

		#endregion
		
		
		public static readonly new long serialVersionUID = 1292137034L;		
	} // end class
}  // end namespace
