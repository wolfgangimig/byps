using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BClient_UtilityRequests : BClient { 
	
		public static BClient_UtilityRequests createClient(BTransportFactory transportFactory) {
			return new BClient_UtilityRequests(transportFactory);
		}
		
		public static BClient_UtilityRequests createClientR(BTransport transport) {
			return new BClient_UtilityRequests(transport);
		}
		
		public virtual UtilityRequests UtilityRequests
		{
			get { return utilityRequestsVal; }
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 363558736) return utilityRequestsVal;
			return null;
		}
		
		protected BClient_UtilityRequests(BTransportFactory transportFactory)
			: base(
				transportFactory.createClientTransport(), 
				transportFactory.createServerR(
					BServer_UtilityRequests.createServerR(transportFactory.createServerTransport())
				)
			)
		{
			initStubs(transportVal);
		}
		
		protected BClient_UtilityRequests(BTransport transport) 
			: base(transport, null)
		{
			initStubs(transportVal);
		}
		
		protected UtilityRequests utilityRequestsVal;
		
		private void initStubs(BTransport transport) {
			utilityRequestsVal = new BStub_UtilityRequests(transport);
		}
		
	}
}
