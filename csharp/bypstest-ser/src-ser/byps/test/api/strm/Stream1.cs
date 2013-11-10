//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.strm
{
	
	public class Stream1 : BSerializable
	{
	
		#region Constructors
		
		public Stream1() {
		}		
		
		internal Stream1(System.IO.Stream @is1, String @contentType, System.IO.Stream[] @arrStream, IList<System.IO.Stream> @listStream, IDictionary<int,System.IO.Stream> @mapStream) {
			this.is1Value = @is1;
			this.contentTypeValue = @contentType;
			this.arrStreamValue = @arrStream;
			this.listStreamValue = @listStream;
			this.mapStreamValue = @mapStream;
		}		
		
		#endregion
		
		#region Properties
		
		public System.IO.Stream Is1
		{
			get
			{
				return is1Value;
			}
			set
			{
				this.is1Value = value;
			}
		}
		
		
		public String ContentType
		{
			get
			{
				return contentTypeValue;
			}
			set
			{
				this.contentTypeValue = value;
			}
		}
		
		
		public System.IO.Stream[] ArrStream
		{
			get
			{
				return arrStreamValue;
			}
			set
			{
				this.arrStreamValue = value;
			}
		}
		
		
		public IList<System.IO.Stream> ListStream
		{
			get
			{
				return listStreamValue;
			}
			set
			{
				this.listStreamValue = value;
			}
		}
		
		
		public IDictionary<int,System.IO.Stream> MapStream
		{
			get
			{
				return mapStreamValue;
			}
			set
			{
				this.mapStreamValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected System.IO.Stream is1Value;

		protected String contentTypeValue;

		protected System.IO.Stream[] arrStreamValue;

		protected IList<System.IO.Stream> listStreamValue;

		protected IDictionary<int,System.IO.Stream> mapStreamValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1541129345L;		
	} // end class
}  // end namespace
