using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BServer_BUtilityRequests : BServer { 
	
		public static BServer_BUtilityRequests createServer(BTransportFactory transportFactory) {
			return new BServer_BUtilityRequests(transportFactory);
		}
		
		public static BServer_BUtilityRequests createServerR(BTransport transport) {
			return new BServer_BUtilityRequests(transport);
		}
		
		public BServer_BUtilityRequests(BTransport transport) 
			: base(transport, null)
		{
		}
		
		public BServer_BUtilityRequests(BTransportFactory transportFactory) 
			: base(
				transportFactory.createServerTransport(),
				transportFactory.createClientR(
					BClient_BUtilityRequests.createClientR(
						transportFactory.createClientTransport()
					)
				)
			)
		{
		}
		
	}
}
