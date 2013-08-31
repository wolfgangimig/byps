using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BClient_Testser : BClient { 
	
		public static BClient_Testser createClient(BTransportFactory transportFactory) {
			return new BClient_Testser(transportFactory);
		}
		
		public static BClient_Testser createClientR(BTransport transport) {
			return new BClient_Testser(transport);
		}
		
		protected BClient_Testser(BTransportFactory transportFactory)
			: base(
				transportFactory.createClientTransport(), 
				transportFactory.createServerR(
					BServer_Testser.createServerR(transportFactory.createServerTransport())
				)
			)
		{
			RemoteArrayTypes1dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
			RemoteArrayTypes23 = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
			RemoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
			RemoteConstants = new com.wilutions.byps.test.api.remote.BStub_RemoteConstants(transport);
			RemoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(transport);
			RemoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(transport);
			RemoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(transport);
			RemoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(transport);
			RemotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
			RemoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(transport);
			RemoteServerCtrl = new com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl(transport);
			RemoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(transport);
			RemoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(transport);
			ClientIF = new com.wilutions.byps.test.api.srvr.BStub_ClientIF(transport);
			ServerIF = new com.wilutions.byps.test.api.srvr.BStub_ServerIF(transport);
			EvolveIF = new com.wilutions.byps.test.api.ver.BStub_EvolveIF(transport);
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1557084481, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes23 remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(2081058997, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1557173854, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteConstants remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(431648293, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteEnums remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(359349400, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteInlineInstance remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1206670536, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteListTypes remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(380156079, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteMapTypes remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(80483097, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemotePrimitiveTypes remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1341983932, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteReferences remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(2086824050, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteServerCtrl remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1124545992, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteSetTypes remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1156008353, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteStreams remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(2028487863, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1784257353, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.srvr.BSkeleton_ServerIF remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(1313562065, remoteSkeleton);
			return this;
		}
		
		public BClient_Testser addRemote(com.wilutions.byps.test.api.ver.BSkeleton_EvolveIF remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionO.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(2078696281, remoteSkeleton);
			return this;
		}
		
		protected BClient_Testser(BTransport transport) 
			: base(transport, null)
		{
			RemoteArrayTypes1dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
			RemoteArrayTypes23 = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
			RemoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
			RemoteConstants = new com.wilutions.byps.test.api.remote.BStub_RemoteConstants(transport);
			RemoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(transport);
			RemoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(transport);
			RemoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(transport);
			RemoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(transport);
			RemotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
			RemoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(transport);
			RemoteServerCtrl = new com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl(transport);
			RemoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(transport);
			RemoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(transport);
			ClientIF = new com.wilutions.byps.test.api.srvr.BStub_ClientIF(transport);
			ServerIF = new com.wilutions.byps.test.api.srvr.BStub_ServerIF(transport);
			EvolveIF = new com.wilutions.byps.test.api.ver.BStub_EvolveIF(transport);
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 1557084481) return RemoteArrayTypes1dim;
			if (remoteId == 2081058997) return RemoteArrayTypes23;
			if (remoteId == 1557173854) return RemoteArrayTypes4dim;
			if (remoteId == 431648293) return RemoteConstants;
			if (remoteId == 359349400) return RemoteEnums;
			if (remoteId == 1206670536) return RemoteInlineInstance;
			if (remoteId == 380156079) return RemoteListTypes;
			if (remoteId == 80483097) return RemoteMapTypes;
			if (remoteId == 1341983932) return RemotePrimitiveTypes;
			if (remoteId == 2086824050) return RemoteReferences;
			if (remoteId == 1124545992) return RemoteServerCtrl;
			if (remoteId == 1156008353) return RemoteSetTypes;
			if (remoteId == 2028487863) return RemoteStreams;
			if (remoteId == 1784257353) return ClientIF;
			if (remoteId == 1313562065) return ServerIF;
			if (remoteId == 2078696281) return EvolveIF;
			return null;
		}
		
		public readonly com.wilutions.byps.test.api.remote.RemoteArrayTypes1dim RemoteArrayTypes1dim;
		public readonly com.wilutions.byps.test.api.remote.RemoteArrayTypes23 RemoteArrayTypes23;
		public readonly com.wilutions.byps.test.api.remote.RemoteArrayTypes4dim RemoteArrayTypes4dim;
		public readonly com.wilutions.byps.test.api.remote.RemoteConstants RemoteConstants;
		public readonly com.wilutions.byps.test.api.remote.RemoteEnums RemoteEnums;
		public readonly com.wilutions.byps.test.api.remote.RemoteInlineInstance RemoteInlineInstance;
		public readonly com.wilutions.byps.test.api.remote.RemoteListTypes RemoteListTypes;
		public readonly com.wilutions.byps.test.api.remote.RemoteMapTypes RemoteMapTypes;
		public readonly com.wilutions.byps.test.api.remote.RemotePrimitiveTypes RemotePrimitiveTypes;
		public readonly com.wilutions.byps.test.api.remote.RemoteReferences RemoteReferences;
		public readonly com.wilutions.byps.test.api.remote.RemoteServerCtrl RemoteServerCtrl;
		public readonly com.wilutions.byps.test.api.remote.RemoteSetTypes RemoteSetTypes;
		public readonly com.wilutions.byps.test.api.remote.RemoteStreams RemoteStreams;
		public readonly com.wilutions.byps.test.api.srvr.ClientIF ClientIF;
		public readonly com.wilutions.byps.test.api.srvr.ServerIF ServerIF;
		public readonly com.wilutions.byps.test.api.ver.EvolveIF EvolveIF;
		
	}
}
