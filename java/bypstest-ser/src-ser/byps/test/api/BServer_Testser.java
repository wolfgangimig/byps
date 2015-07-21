package byps.test.api;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenServer DO NOT MODIFY.
 */

import byps.*;

@SuppressWarnings("all")
public class BServer_Testser extends BServer { 

	public static BServer_Testser createServer(BTransportFactory transportFactory) {
		return new BServer_Testser(transportFactory);
	}
	
	public static BServer_Testser createServerR(BTransport transport) {
		return new BServer_Testser(transport);
	}
	
	public BServer_Testser(BTransport transport) {
		super(transport, null);
	}
	
	public BServer_Testser(BTransportFactory transportFactory) {
		super(
			transportFactory.createServerTransport(),
			transportFactory.createClientR(
				BClient_Testser.createClientR(
					transportFactory.createClientTransport()
				)
			)
		);
	}
	
	public BServer_Testser addRemote(byps.test.api.comp.BSkeleton_IncompatibleChangeIF remoteSkeleton) {
		addRemote(88979576, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.inherit.BSkeleton_BioFruitService remoteSkeleton) {
		addRemote(363642571, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.inherit.BSkeleton_BioLemonService remoteSkeleton) {
		addRemote(474058508, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.inherit.BSkeleton_FruitService remoteSkeleton) {
		addRemote(715959905, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.inherit.BSkeleton_LemonService remoteSkeleton) {
		addRemote(605543968, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.inherit.BSkeleton_PlantService remoteSkeleton) {
		addRemote(1954605928, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim remoteSkeleton) {
		addRemote(963816328, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes23 remoteSkeleton) {
		addRemote(769717182, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim remoteSkeleton) {
		addRemote(963726955, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteConstants remoteSkeleton) {
		addRemote(2045242510, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteEnums remoteSkeleton) {
		addRemote(485761455, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteInlineInstance remoteSkeleton) {
		addRemote(567395951, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteListTypes remoteSkeleton) {
		addRemote(1233438138, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteMapTypes remoteSkeleton) {
		addRemote(664304990, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemotePrimitiveTypes remoteSkeleton) {
		addRemote(1178916877, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteReferences remoteSkeleton) {
		addRemote(568637225, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteServerCtrl remoteSkeleton) {
		addRemote(1652234479, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteSetTypes remoteSkeleton) {
		addRemote(1900796440, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteStreams remoteSkeleton) {
		addRemote(1043578866, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.remote.BSkeleton_RemoteWithAuthentication remoteSkeleton) {
		addRemote(1983670399, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) {
		addRemote(2049072174, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.srvr.BSkeleton_ServerIF remoteSkeleton) {
		addRemote(1775199834, remoteSkeleton);
		return this;
	}
	
	public BServer_Testser addRemote(byps.test.api.ver.BSkeleton_EvolveIF remoteSkeleton) {
		addRemote(15377840, remoteSkeleton);
		return this;
	}
	
}
