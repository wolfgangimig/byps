using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
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
			BioFruitService = new byps.test.api.inherit.BStub_BioFruitService(transport);
			BioLemonService = new byps.test.api.inherit.BStub_BioLemonService(transport);
			FruitService = new byps.test.api.inherit.BStub_FruitService(transport);
			LemonService = new byps.test.api.inherit.BStub_LemonService(transport);
			PlantService = new byps.test.api.inherit.BStub_PlantService(transport);
			RemoteArrayTypes1dim = new byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
			RemoteArrayTypes23 = new byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
			RemoteArrayTypes4dim = new byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
			RemoteConstants = new byps.test.api.remote.BStub_RemoteConstants(transport);
			RemoteEnums = new byps.test.api.remote.BStub_RemoteEnums(transport);
			RemoteInlineInstance = new byps.test.api.remote.BStub_RemoteInlineInstance(transport);
			RemoteListTypes = new byps.test.api.remote.BStub_RemoteListTypes(transport);
			RemoteMapTypes = new byps.test.api.remote.BStub_RemoteMapTypes(transport);
			RemotePrimitiveTypes = new byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
			RemoteReferences = new byps.test.api.remote.BStub_RemoteReferences(transport);
			RemoteServerCtrl = new byps.test.api.remote.BStub_RemoteServerCtrl(transport);
			RemoteSetTypes = new byps.test.api.remote.BStub_RemoteSetTypes(transport);
			RemoteStreams = new byps.test.api.remote.BStub_RemoteStreams(transport);
			RemoteWithAuthentication = new byps.test.api.remote.BStub_RemoteWithAuthentication(transport);
			ClientIF = new byps.test.api.srvr.BStub_ClientIF(transport);
			ServerIF = new byps.test.api.srvr.BStub_ServerIF(transport);
			EvolveIF = new byps.test.api.ver.BStub_EvolveIF(transport);
		}
		
		public BClient_Testser addRemote(byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(955752991, remoteSkeleton);
			return this;
		}
		
		protected BClient_Testser(BTransport transport) 
			: base(transport, null)
		{
			BioFruitService = new byps.test.api.inherit.BStub_BioFruitService(transport);
			BioLemonService = new byps.test.api.inherit.BStub_BioLemonService(transport);
			FruitService = new byps.test.api.inherit.BStub_FruitService(transport);
			LemonService = new byps.test.api.inherit.BStub_LemonService(transport);
			PlantService = new byps.test.api.inherit.BStub_PlantService(transport);
			RemoteArrayTypes1dim = new byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
			RemoteArrayTypes23 = new byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
			RemoteArrayTypes4dim = new byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
			RemoteConstants = new byps.test.api.remote.BStub_RemoteConstants(transport);
			RemoteEnums = new byps.test.api.remote.BStub_RemoteEnums(transport);
			RemoteInlineInstance = new byps.test.api.remote.BStub_RemoteInlineInstance(transport);
			RemoteListTypes = new byps.test.api.remote.BStub_RemoteListTypes(transport);
			RemoteMapTypes = new byps.test.api.remote.BStub_RemoteMapTypes(transport);
			RemotePrimitiveTypes = new byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
			RemoteReferences = new byps.test.api.remote.BStub_RemoteReferences(transport);
			RemoteServerCtrl = new byps.test.api.remote.BStub_RemoteServerCtrl(transport);
			RemoteSetTypes = new byps.test.api.remote.BStub_RemoteSetTypes(transport);
			RemoteStreams = new byps.test.api.remote.BStub_RemoteStreams(transport);
			RemoteWithAuthentication = new byps.test.api.remote.BStub_RemoteWithAuthentication(transport);
			ClientIF = new byps.test.api.srvr.BStub_ClientIF(transport);
			ServerIF = new byps.test.api.srvr.BStub_ServerIF(transport);
			EvolveIF = new byps.test.api.ver.BStub_EvolveIF(transport);
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 612235846) return BioFruitService;
			if (remoteId == 501819909) return BioLemonService;
			if (remoteId == 937293552) return FruitService;
			if (remoteId == 826877615) return LemonService;
			if (remoteId == 1733272281) return PlantService;
			if (remoteId == 1176140631) return RemoteArrayTypes1dim;
			if (remoteId == 964138163) return RemoteArrayTypes23;
			if (remoteId == 1176051258) return RemoteArrayTypes4dim;
			if (remoteId == 429088323) return RemoteConstants;
			if (remoteId == 1222673152) return RemoteEnums;
			if (remoteId == 355071648) return RemoteInlineInstance;
			if (remoteId == 1240892695) return RemoteListTypes;
			if (remoteId == 1277224527) return RemoteMapTypes;
			if (remoteId == 1391241180) return RemotePrimitiveTypes;
			if (remoteId == 1173792730) return RemoteReferences;
			if (remoteId == 2037577312) return RemoteServerCtrl;
			if (remoteId == 1781251319) return RemoteSetTypes;
			if (remoteId == 2123238175) return RemoteStreams;
			if (remoteId == 1532028880) return RemoteWithAuthentication;
			if (remoteId == 955752991) return ClientIF;
			if (remoteId == 1426448279) return ServerIF;
			if (remoteId == 564008001) return EvolveIF;
			return null;
		}
		
		public readonly byps.test.api.inherit.BioFruitServiceAuth BioFruitService;
		public readonly byps.test.api.inherit.BioLemonServiceAuth BioLemonService;
		public readonly byps.test.api.inherit.FruitServiceAuth FruitService;
		public readonly byps.test.api.inherit.LemonServiceAuth LemonService;
		public readonly byps.test.api.inherit.PlantServiceAuth PlantService;
		public readonly byps.test.api.remote.RemoteArrayTypes1dim RemoteArrayTypes1dim;
		public readonly byps.test.api.remote.RemoteArrayTypes23 RemoteArrayTypes23;
		public readonly byps.test.api.remote.RemoteArrayTypes4dim RemoteArrayTypes4dim;
		public readonly byps.test.api.remote.RemoteConstants RemoteConstants;
		public readonly byps.test.api.remote.RemoteEnums RemoteEnums;
		public readonly byps.test.api.remote.RemoteInlineInstance RemoteInlineInstance;
		public readonly byps.test.api.remote.RemoteListTypes RemoteListTypes;
		public readonly byps.test.api.remote.RemoteMapTypes RemoteMapTypes;
		public readonly byps.test.api.remote.RemotePrimitiveTypes RemotePrimitiveTypes;
		public readonly byps.test.api.remote.RemoteReferences RemoteReferences;
		public readonly byps.test.api.remote.RemoteServerCtrl RemoteServerCtrl;
		public readonly byps.test.api.remote.RemoteSetTypes RemoteSetTypes;
		public readonly byps.test.api.remote.RemoteStreams RemoteStreams;
		public readonly byps.test.api.remote.RemoteWithAuthenticationAuth RemoteWithAuthentication;
		public readonly byps.test.api.srvr.ClientIF ClientIF;
		public readonly byps.test.api.srvr.ServerIF ServerIF;
		public readonly byps.test.api.ver.EvolveIF EvolveIF;
		
	}
}
