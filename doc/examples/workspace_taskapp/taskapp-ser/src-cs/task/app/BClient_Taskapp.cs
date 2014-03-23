using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BClient_Taskapp : BClient { 
	
		public static BClient_Taskapp createClient(BTransportFactory transportFactory) {
			return new BClient_Taskapp(transportFactory);
		}
		
		public static BClient_Taskapp createClientR(BTransport transport) {
			return new BClient_Taskapp(transport);
		}
		
		public virtual TaskService TaskService
		{
			get { return taskServiceVal; }
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 216769899) return taskServiceVal;
			return null;
		}
		
		protected BClient_Taskapp(BTransportFactory transportFactory)
			: base(
				transportFactory.createClientTransport(), 
				transportFactory.createServerR(
					BServer_Taskapp.createServerR(transportFactory.createServerTransport())
				)
			)
		{
			initStubs(transportVal);
		}
		
		protected BClient_Taskapp(BTransport transport) 
			: base(transport, null)
		{
			initStubs(transportVal);
		}
		
		protected TaskService taskServiceVal;
		
		private void initStubs(BTransport transport) {
			taskServiceVal = new BStub_TaskService(transport);
		}
		
	}
}
