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
		
		public virtual BClient_Testser addRemote(byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) {
			if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
			serverR.server.addRemote(2049072174, remoteSkeleton);
			return this;
		}
		
		public virtual byps.test.api.inherit.BioFruitServiceAuth BioFruitService
		{
			get { return bioFruitServiceVal; }
		}
		public virtual byps.test.api.inherit.BioLemonServiceAuth BioLemonService
		{
			get { return bioLemonServiceVal; }
		}
		public virtual byps.test.api.inherit.FruitServiceAuth FruitService
		{
			get { return fruitServiceVal; }
		}
		public virtual byps.test.api.inherit.LemonServiceAuth LemonService
		{
			get { return lemonServiceVal; }
		}
		public virtual byps.test.api.inherit.PlantServiceAuth PlantService
		{
			get { return plantServiceVal; }
		}
		public virtual byps.test.api.remote.RemoteArrayTypes1dim RemoteArrayTypes1dim
		{
			get { return remoteArrayTypes1dimVal; }
		}
		public virtual byps.test.api.remote.RemoteArrayTypes23 RemoteArrayTypes23
		{
			get { return remoteArrayTypes23Val; }
		}
		public virtual byps.test.api.remote.RemoteArrayTypes4dim RemoteArrayTypes4dim
		{
			get { return remoteArrayTypes4dimVal; }
		}
		public virtual byps.test.api.remote.RemoteConstants RemoteConstants
		{
			get { return remoteConstantsVal; }
		}
		public virtual byps.test.api.remote.RemoteEnums RemoteEnums
		{
			get { return remoteEnumsVal; }
		}
		public virtual byps.test.api.remote.RemoteInlineInstance RemoteInlineInstance
		{
			get { return remoteInlineInstanceVal; }
		}
		public virtual byps.test.api.remote.RemoteListTypes RemoteListTypes
		{
			get { return remoteListTypesVal; }
		}
		public virtual byps.test.api.remote.RemoteMapTypes RemoteMapTypes
		{
			get { return remoteMapTypesVal; }
		}
		public virtual byps.test.api.remote.RemotePrimitiveTypes RemotePrimitiveTypes
		{
			get { return remotePrimitiveTypesVal; }
		}
		public virtual byps.test.api.remote.RemoteReferences RemoteReferences
		{
			get { return remoteReferencesVal; }
		}
		public virtual byps.test.api.remote.RemoteServerCtrl RemoteServerCtrl
		{
			get { return remoteServerCtrlVal; }
		}
		public virtual byps.test.api.remote.RemoteSetTypes RemoteSetTypes
		{
			get { return remoteSetTypesVal; }
		}
		public virtual byps.test.api.remote.RemoteStreams RemoteStreams
		{
			get { return remoteStreamsVal; }
		}
		public virtual byps.test.api.remote.RemoteWithAuthenticationAuth RemoteWithAuthentication
		{
			get { return remoteWithAuthenticationVal; }
		}
		public virtual byps.test.api.srvr.ClientIF ClientIF
		{
			get { return clientIFVal; }
		}
		public virtual byps.test.api.srvr.ServerIF ServerIF
		{
			get { return serverIFVal; }
		}
		public virtual byps.test.api.ver.EvolveIF EvolveIF
		{
			get { return evolveIFVal; }
		}
		
		public override BRemote getStub(int remoteId) {
			if (remoteId == 363642571) return bioFruitServiceVal;
			if (remoteId == 474058508) return bioLemonServiceVal;
			if (remoteId == 715959905) return fruitServiceVal;
			if (remoteId == 605543968) return lemonServiceVal;
			if (remoteId == 1954605928) return plantServiceVal;
			if (remoteId == 963816328) return remoteArrayTypes1dimVal;
			if (remoteId == 769717182) return remoteArrayTypes23Val;
			if (remoteId == 963726955) return remoteArrayTypes4dimVal;
			if (remoteId == 2045242510) return remoteConstantsVal;
			if (remoteId == 485761455) return remoteEnumsVal;
			if (remoteId == 567395951) return remoteInlineInstanceVal;
			if (remoteId == 1233438138) return remoteListTypesVal;
			if (remoteId == 664304990) return remoteMapTypesVal;
			if (remoteId == 1178916877) return remotePrimitiveTypesVal;
			if (remoteId == 568637225) return remoteReferencesVal;
			if (remoteId == 1652234479) return remoteServerCtrlVal;
			if (remoteId == 1900796440) return remoteSetTypesVal;
			if (remoteId == 1043578866) return remoteStreamsVal;
			if (remoteId == 1983670399) return remoteWithAuthenticationVal;
			if (remoteId == 2049072174) return clientIFVal;
			if (remoteId == 1775199834) return serverIFVal;
			if (remoteId == 15377840) return evolveIFVal;
			return null;
		}
		
		protected BClient_Testser(BTransportFactory transportFactory)
			: base(
				transportFactory.createClientTransport(), 
				transportFactory.createServerR(
					BServer_Testser.createServerR(transportFactory.createServerTransport())
				)
			)
		{
			initStubs(transportVal);
		}
		
		protected BClient_Testser(BTransport transport) 
			: base(transport, null)
		{
			initStubs(transportVal);
		}
		
		protected byps.test.api.inherit.BioFruitServiceAuth bioFruitServiceVal;
		protected byps.test.api.inherit.BioLemonServiceAuth bioLemonServiceVal;
		protected byps.test.api.inherit.FruitServiceAuth fruitServiceVal;
		protected byps.test.api.inherit.LemonServiceAuth lemonServiceVal;
		protected byps.test.api.inherit.PlantServiceAuth plantServiceVal;
		protected byps.test.api.remote.RemoteArrayTypes1dim remoteArrayTypes1dimVal;
		protected byps.test.api.remote.RemoteArrayTypes23 remoteArrayTypes23Val;
		protected byps.test.api.remote.RemoteArrayTypes4dim remoteArrayTypes4dimVal;
		protected byps.test.api.remote.RemoteConstants remoteConstantsVal;
		protected byps.test.api.remote.RemoteEnums remoteEnumsVal;
		protected byps.test.api.remote.RemoteInlineInstance remoteInlineInstanceVal;
		protected byps.test.api.remote.RemoteListTypes remoteListTypesVal;
		protected byps.test.api.remote.RemoteMapTypes remoteMapTypesVal;
		protected byps.test.api.remote.RemotePrimitiveTypes remotePrimitiveTypesVal;
		protected byps.test.api.remote.RemoteReferences remoteReferencesVal;
		protected byps.test.api.remote.RemoteServerCtrl remoteServerCtrlVal;
		protected byps.test.api.remote.RemoteSetTypes remoteSetTypesVal;
		protected byps.test.api.remote.RemoteStreams remoteStreamsVal;
		protected byps.test.api.remote.RemoteWithAuthenticationAuth remoteWithAuthenticationVal;
		protected byps.test.api.srvr.ClientIF clientIFVal;
		protected byps.test.api.srvr.ServerIF serverIFVal;
		protected byps.test.api.ver.EvolveIF evolveIFVal;
		
		private void initStubs(BTransport transport) {
			bioFruitServiceVal = new byps.test.api.inherit.BStub_BioFruitService(transport);
			bioLemonServiceVal = new byps.test.api.inherit.BStub_BioLemonService(transport);
			fruitServiceVal = new byps.test.api.inherit.BStub_FruitService(transport);
			lemonServiceVal = new byps.test.api.inherit.BStub_LemonService(transport);
			plantServiceVal = new byps.test.api.inherit.BStub_PlantService(transport);
			remoteArrayTypes1dimVal = new byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
			remoteArrayTypes23Val = new byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
			remoteArrayTypes4dimVal = new byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
			remoteConstantsVal = new byps.test.api.remote.BStub_RemoteConstants(transport);
			remoteEnumsVal = new byps.test.api.remote.BStub_RemoteEnums(transport);
			remoteInlineInstanceVal = new byps.test.api.remote.BStub_RemoteInlineInstance(transport);
			remoteListTypesVal = new byps.test.api.remote.BStub_RemoteListTypes(transport);
			remoteMapTypesVal = new byps.test.api.remote.BStub_RemoteMapTypes(transport);
			remotePrimitiveTypesVal = new byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
			remoteReferencesVal = new byps.test.api.remote.BStub_RemoteReferences(transport);
			remoteServerCtrlVal = new byps.test.api.remote.BStub_RemoteServerCtrl(transport);
			remoteSetTypesVal = new byps.test.api.remote.BStub_RemoteSetTypes(transport);
			remoteStreamsVal = new byps.test.api.remote.BStub_RemoteStreams(transport);
			remoteWithAuthenticationVal = new byps.test.api.remote.BStub_RemoteWithAuthentication(transport);
			clientIFVal = new byps.test.api.srvr.BStub_ClientIF(transport);
			serverIFVal = new byps.test.api.srvr.BStub_ServerIF(transport);
			evolveIFVal = new byps.test.api.ver.BStub_EvolveIF(transport);
		}
		
	}
}
