using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BClient_BUtilityRequests : BClient { 
	
		public static BClient_BUtilityRequests createClient(BTransportFactory transportFactory) {
			return new BClient_BUtilityRequests(transportFactory);
		}
		
		public static BClient_BUtilityRequests createClientR(BTransport transport) {
			return new BClient_BUtilityRequests(transport);
		}
		
		public virtual BUtilityRequests BUtilityRequests
		{
			get { return bUtilityRequestsVal; }
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 174367442) return bUtilityRequestsVal;
			return null;
		}
		
		protected BClient_BUtilityRequests(BTransportFactory transportFactory)
			: base(
				transportFactory.createClientTransport(), 
				transportFactory.createServerR(
					BServer_BUtilityRequests.createServerR(transportFactory.createServerTransport())
				)
			)
		{
			initStubs(transportVal);
		}
		
		protected BClient_BUtilityRequests(BTransport transport) 
			: base(transport, null)
		{
			initStubs(transportVal);
		}
		
		protected BUtilityRequests bUtilityRequestsVal;
		
		private void initStubs(BTransport transport) {
			bUtilityRequestsVal = new BStub_BUtilityRequests(transport);
		}
		
	}
}
