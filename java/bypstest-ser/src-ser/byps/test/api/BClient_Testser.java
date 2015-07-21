package byps.test.api;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenClient DO NOT MODIFY.
 */

import byps.*;

public class BClient_Testser extends BClient { 

	public static BClient_Testser createClient(BTransportFactory transportFactory) {
		return new BClient_Testser(transportFactory);
	}
	
	public static BClient_Testser createClientR(BTransport transport) {
		return new BClient_Testser(transport);
	}
	
	public BClient_Testser addRemote(byps.test.api.comp.BSkeleton_IncompatibleChangeIF remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(88979576, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.inherit.BSkeleton_BioFruitService remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(363642571, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.inherit.BSkeleton_BioLemonService remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(474058508, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.inherit.BSkeleton_FruitService remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(715959905, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.inherit.BSkeleton_LemonService remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(605543968, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.inherit.BSkeleton_PlantService remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1954605928, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(963816328, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes23 remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(769717182, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(963726955, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteConstants remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(2045242510, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteEnums remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(485761455, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteInlineInstance remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(567395951, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteListTypes remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1233438138, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteMapTypes remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(664304990, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemotePrimitiveTypes remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1178916877, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteReferences remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(568637225, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteServerCtrl remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1652234479, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteSetTypes remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1900796440, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteStreams remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1043578866, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteWithAuthentication remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1983670399, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(2049072174, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.srvr.BSkeleton_ServerIF remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(1775199834, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(byps.test.api.ver.BSkeleton_EvolveIF remoteSkeleton) throws BException {
		if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, "No reverse connections.");
		serverR.server.addRemote(15377840, remoteSkeleton);
		return this;
	}
	
	public byps.test.api.comp.IncompatibleChangeIFAsync getIncompatibleChangeIF() {
		return incompatibleChangeIF;
	}
	public byps.test.api.inherit.BioFruitServiceAuth getBioFruitService() {
		return bioFruitService;
	}
	public byps.test.api.inherit.BioLemonServiceAuth getBioLemonService() {
		return bioLemonService;
	}
	public byps.test.api.inherit.FruitServiceAuth getFruitService() {
		return fruitService;
	}
	public byps.test.api.inherit.LemonServiceAuth getLemonService() {
		return lemonService;
	}
	public byps.test.api.inherit.PlantServiceAuth getPlantService() {
		return plantService;
	}
	public byps.test.api.remote.RemoteArrayTypes1dimAsync getRemoteArrayTypes1dim() {
		return remoteArrayTypes1dim;
	}
	public byps.test.api.remote.RemoteArrayTypes23Async getRemoteArrayTypes23() {
		return remoteArrayTypes23;
	}
	public byps.test.api.remote.RemoteArrayTypes4dimAsync getRemoteArrayTypes4dim() {
		return remoteArrayTypes4dim;
	}
	public byps.test.api.remote.RemoteConstantsAsync getRemoteConstants() {
		return remoteConstants;
	}
	public byps.test.api.remote.RemoteEnumsAsync getRemoteEnums() {
		return remoteEnums;
	}
	public byps.test.api.remote.RemoteInlineInstanceAsync getRemoteInlineInstance() {
		return remoteInlineInstance;
	}
	public byps.test.api.remote.RemoteListTypesAsync getRemoteListTypes() {
		return remoteListTypes;
	}
	public byps.test.api.remote.RemoteMapTypesAsync getRemoteMapTypes() {
		return remoteMapTypes;
	}
	public byps.test.api.remote.RemotePrimitiveTypesAsync getRemotePrimitiveTypes() {
		return remotePrimitiveTypes;
	}
	public byps.test.api.remote.RemoteReferencesAsync getRemoteReferences() {
		return remoteReferences;
	}
	public byps.test.api.remote.RemoteServerCtrlAsync getRemoteServerCtrl() {
		return remoteServerCtrl;
	}
	public byps.test.api.remote.RemoteSetTypesAsync getRemoteSetTypes() {
		return remoteSetTypes;
	}
	public byps.test.api.remote.RemoteStreamsAsync getRemoteStreams() {
		return remoteStreams;
	}
	public byps.test.api.remote.RemoteWithAuthenticationAuth getRemoteWithAuthentication() {
		return remoteWithAuthentication;
	}
	public byps.test.api.srvr.ClientIFAsync getClientIF() {
		return clientIF;
	}
	public byps.test.api.srvr.ServerIFAsync getServerIF() {
		return serverIF;
	}
	public byps.test.api.ver.EvolveIFAsync getEvolveIF() {
		return evolveIF;
	}
	
	@Override
	public BRemote getStub(int remoteId) {
		if (remoteId == 88979576) return incompatibleChangeIF;
		if (remoteId == 363642571) return bioFruitService;
		if (remoteId == 474058508) return bioLemonService;
		if (remoteId == 715959905) return fruitService;
		if (remoteId == 605543968) return lemonService;
		if (remoteId == 1954605928) return plantService;
		if (remoteId == 963816328) return remoteArrayTypes1dim;
		if (remoteId == 769717182) return remoteArrayTypes23;
		if (remoteId == 963726955) return remoteArrayTypes4dim;
		if (remoteId == 2045242510) return remoteConstants;
		if (remoteId == 485761455) return remoteEnums;
		if (remoteId == 567395951) return remoteInlineInstance;
		if (remoteId == 1233438138) return remoteListTypes;
		if (remoteId == 664304990) return remoteMapTypes;
		if (remoteId == 1178916877) return remotePrimitiveTypes;
		if (remoteId == 568637225) return remoteReferences;
		if (remoteId == 1652234479) return remoteServerCtrl;
		if (remoteId == 1900796440) return remoteSetTypes;
		if (remoteId == 1043578866) return remoteStreams;
		if (remoteId == 1983670399) return remoteWithAuthentication;
		if (remoteId == 2049072174) return clientIF;
		if (remoteId == 1775199834) return serverIF;
		if (remoteId == 15377840) return evolveIF;
		return null;
	}
	
	protected BClient_Testser(BTransportFactory transportFactory) {
		super(
			transportFactory.createClientTransport(), 
			transportFactory.createServerR(
				BServer_Testser.createServerR(transportFactory.createServerTransport())
			)
		);
		initStubs(transport);
	}
	
	protected BClient_Testser(BTransport transport) {
		super(transport, null);
		initStubs(transport);
	}
	
	protected byps.test.api.comp.IncompatibleChangeIFAsync incompatibleChangeIF;
	protected byps.test.api.inherit.BioFruitServiceAuth bioFruitService;
	protected byps.test.api.inherit.BioLemonServiceAuth bioLemonService;
	protected byps.test.api.inherit.FruitServiceAuth fruitService;
	protected byps.test.api.inherit.LemonServiceAuth lemonService;
	protected byps.test.api.inherit.PlantServiceAuth plantService;
	protected byps.test.api.remote.RemoteArrayTypes1dimAsync remoteArrayTypes1dim;
	protected byps.test.api.remote.RemoteArrayTypes23Async remoteArrayTypes23;
	protected byps.test.api.remote.RemoteArrayTypes4dimAsync remoteArrayTypes4dim;
	protected byps.test.api.remote.RemoteConstantsAsync remoteConstants;
	protected byps.test.api.remote.RemoteEnumsAsync remoteEnums;
	protected byps.test.api.remote.RemoteInlineInstanceAsync remoteInlineInstance;
	protected byps.test.api.remote.RemoteListTypesAsync remoteListTypes;
	protected byps.test.api.remote.RemoteMapTypesAsync remoteMapTypes;
	protected byps.test.api.remote.RemotePrimitiveTypesAsync remotePrimitiveTypes;
	protected byps.test.api.remote.RemoteReferencesAsync remoteReferences;
	protected byps.test.api.remote.RemoteServerCtrlAsync remoteServerCtrl;
	protected byps.test.api.remote.RemoteSetTypesAsync remoteSetTypes;
	protected byps.test.api.remote.RemoteStreamsAsync remoteStreams;
	protected byps.test.api.remote.RemoteWithAuthenticationAuth remoteWithAuthentication;
	protected byps.test.api.srvr.ClientIFAsync clientIF;
	protected byps.test.api.srvr.ServerIFAsync serverIF;
	protected byps.test.api.ver.EvolveIFAsync evolveIF;
	
	private void initStubs(BTransport transport) {
		incompatibleChangeIF = new byps.test.api.comp.BStub_IncompatibleChangeIF(transport);
		bioFruitService = new byps.test.api.inherit.BStub_BioFruitService(transport);
		bioLemonService = new byps.test.api.inherit.BStub_BioLemonService(transport);
		fruitService = new byps.test.api.inherit.BStub_FruitService(transport);
		lemonService = new byps.test.api.inherit.BStub_LemonService(transport);
		plantService = new byps.test.api.inherit.BStub_PlantService(transport);
		remoteArrayTypes1dim = new byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
		remoteArrayTypes23 = new byps.test.api.remote.BStub_RemoteArrayTypes23(transport);
		remoteArrayTypes4dim = new byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
		remoteConstants = new byps.test.api.remote.BStub_RemoteConstants(transport);
		remoteEnums = new byps.test.api.remote.BStub_RemoteEnums(transport);
		remoteInlineInstance = new byps.test.api.remote.BStub_RemoteInlineInstance(transport);
		remoteListTypes = new byps.test.api.remote.BStub_RemoteListTypes(transport);
		remoteMapTypes = new byps.test.api.remote.BStub_RemoteMapTypes(transport);
		remotePrimitiveTypes = new byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
		remoteReferences = new byps.test.api.remote.BStub_RemoteReferences(transport);
		remoteServerCtrl = new byps.test.api.remote.BStub_RemoteServerCtrl(transport);
		remoteSetTypes = new byps.test.api.remote.BStub_RemoteSetTypes(transport);
		remoteStreams = new byps.test.api.remote.BStub_RemoteStreams(transport);
		remoteWithAuthentication = new byps.test.api.remote.BStub_RemoteWithAuthentication(transport);
		clientIF = new byps.test.api.srvr.BStub_ClientIF(transport);
		serverIF = new byps.test.api.srvr.BStub_ServerIF(transport);
		evolveIF = new byps.test.api.ver.BStub_EvolveIF(transport);
	}
	
}
