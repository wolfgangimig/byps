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
			this._is1 = @is1;
			this._contentType = @contentType;
			this._arrStream = @arrStream;
			this._listStream = @listStream;
			this._mapStream = @mapStream;
		}		
		
		#endregion
		
		#region Properties
		
		public System.IO.Stream Is1
		{
			get
			{
				return _is1;
			}
			set
			{
				this._is1 = value;
			}
		}
		
		
		public String ContentType
		{
			get
			{
				return _contentType;
			}
			set
			{
				this._contentType = value;
			}
		}
		
		
		public System.IO.Stream[] ArrStream
		{
			get
			{
				return _arrStream;
			}
			set
			{
				this._arrStream = value;
			}
		}
		
		
		public IList<System.IO.Stream> ListStream
		{
			get
			{
				return _listStream;
			}
			set
			{
				this._listStream = value;
			}
		}
		
		
		public IDictionary<int,System.IO.Stream> MapStream
		{
			get
			{
				return _mapStream;
			}
			set
			{
				this._mapStream = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected System.IO.Stream _is1;

		protected String _contentType;

		protected System.IO.Stream[] _arrStream;

		protected IList<System.IO.Stream> _listStream;

		protected IDictionary<int,System.IO.Stream> _mapStream;

		#endregion
		
		
		public static readonly long serialVersionUID = 1541129345L;		
	} // end class
}  // end namespace
