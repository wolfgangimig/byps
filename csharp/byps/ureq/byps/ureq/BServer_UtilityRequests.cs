using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BServer_UtilityRequests : BServer { 
	
		public static BServer_UtilityRequests createServer(BTransportFactory transportFactory) {
			return new BServer_UtilityRequests(transportFactory);
		}
		
		public static BServer_UtilityRequests createServerR(BTransport transport) {
			return new BServer_UtilityRequests(transport);
		}
		
		public BServer_UtilityRequests(BTransport transport) 
			: base(transport, null)
		{
		}
		
		public BServer_UtilityRequests(BTransportFactory transportFactory) 
			: base(
				transportFactory.createServerTransport(),
				transportFactory.createClientR(
					BClient_UtilityRequests.createClientR(
						transportFactory.createClientTransport()
					)
				)
			)
		{
		}
		
	}
}
