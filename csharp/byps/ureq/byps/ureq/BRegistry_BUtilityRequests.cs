using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BRegistry_BUtilityRequests : BRegistry { 
	
		public BRegistry_BUtilityRequests()
			: base(BBinaryModel.MEDIUM) {}
		
		private static BRegisteredSerializer[] serializers = new BRegisteredSerializer[] {
			new BRegisteredSerializer(60626368, "byps.ureq.BSerializer_60626368", byps.ureq.BSerializer_60626368.instance),
			new BRegisteredSerializer(174367442, "byps.ureq.BSerializer_174367442", byps.ureq.BSerializer_174367442.instance),
			new BRegisteredSerializer(421787891, "byps.ureq.BSerializer_421787891", byps.ureq.BSerializer_421787891.instance),
			new BRegisteredSerializer(1710660846, "byps.ureq.BSerializer_1710660846", byps.ureq.BSerializer_1710660846.instance),
			new BRegisteredSerializer(1828952285, "byps.ureq.BSerializer_1828952285", byps.ureq.BSerializer_1828952285.instance),
			new BRegisteredSerializer(1845498599, "byps.ureq.BSerializer_1845498599", byps.ureq.BSerializer_1845498599.instance),
			new BRegisteredSerializer(2048473051, "byps.ureq.BSerializer_2048473051", byps.ureq.BSerializer_2048473051.instance),
		};
		protected override BRegisteredSerializer[] getSortedSerializers() {
			return serializers;
		}
	}
}
