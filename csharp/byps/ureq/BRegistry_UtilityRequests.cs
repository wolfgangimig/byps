using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BRegistry_UtilityRequests : BRegistry { 
	
		public BRegistry_UtilityRequests()
			: base(BBinaryModel.MEDIUM) {}
		
		private static BRegisteredSerializer[] serializers = new BRegisteredSerializer[] {
			new BRegisteredSerializer(363558736, "byps.ureq.BSerializer_363558736", byps.ureq.BSerializer_363558736.instance),
			new BRegisteredSerializer(648161469, "byps.ureq.BSerializer_648161469", byps.ureq.BSerializer_648161469.instance),
			new BRegisteredSerializer(1845498599, "byps.ureq.BSerializer_1845498599", byps.ureq.BSerializer_1845498599.instance),
		};
		protected override BRegisteredSerializer[] getSortedSerializers() {
			return serializers;
		}
	}
}
