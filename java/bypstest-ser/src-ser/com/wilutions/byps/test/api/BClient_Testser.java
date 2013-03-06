package com.wilutions.byps.test.api;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BClient_Testser extends BClient { 

	public static BClient_Testser createClient(BTransportFactory transportFactory) {
		return new BClient_Testser(transportFactory);
	}
	
	public static BClient_Testser createClientR(BTransport transport) {
		return new BClient_Testser(transport);
	}
	
	protected BClient_Testser(BTransportFactory transportFactory) {
		super(
			transportFactory.createClientTransport(), 
			transportFactory.createServerR(
				BServer_Testser.createServerR(transportFactory.createServerTransport())
			)
		);
		remoteArrayTypes1dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
		remoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
		remoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(transport);
		remoteException = new com.wilutions.byps.test.api.remote.BStub_RemoteException(transport);
		remoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(transport);
		remoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(transport);
		remoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(transport);
		remotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
		remoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(transport);
		remoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(transport);
		remoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(transport);
		clientIF = new com.wilutions.byps.test.api.srvr.BStub_ClientIF(transport);
		serverIF = new com.wilutions.byps.test.api.srvr.BStub_ServerIF(transport);
		evolveIF = new com.wilutions.byps.test.api.ver.BStub_EvolveIF(transport);
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim remoteSkeleton) {
		serverR.server.addRemote(1557084481, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim remoteSkeleton) {
		serverR.server.addRemote(1557173854, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteEnums remoteSkeleton) {
		serverR.server.addRemote(359349400, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteException remoteSkeleton) {
		serverR.server.addRemote(1959416539, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteInlineInstance remoteSkeleton) {
		serverR.server.addRemote(1206670536, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteListTypes remoteSkeleton) {
		serverR.server.addRemote(380156079, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteMapTypes remoteSkeleton) {
		serverR.server.addRemote(80483097, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemotePrimitiveTypes remoteSkeleton) {
		serverR.server.addRemote(1341983932, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteReferences remoteSkeleton) {
		serverR.server.addRemote(2086824050, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteSetTypes remoteSkeleton) {
		serverR.server.addRemote(1156008353, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.remote.BSkeleton_RemoteStreams remoteSkeleton) {
		serverR.server.addRemote(2028487863, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF remoteSkeleton) {
		serverR.server.addRemote(1784257353, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.srvr.BSkeleton_ServerIF remoteSkeleton) {
		serverR.server.addRemote(1313562065, remoteSkeleton);
		return this;
	}
	
	public BClient_Testser addRemote(com.wilutions.byps.test.api.ver.BSkeleton_EvolveIF remoteSkeleton) {
		serverR.server.addRemote(2078696281, remoteSkeleton);
		return this;
	}
	
	protected BClient_Testser(BTransport transport) {
		super(transport, null);
		remoteArrayTypes1dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim(transport);
		remoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(transport);
		remoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(transport);
		remoteException = new com.wilutions.byps.test.api.remote.BStub_RemoteException(transport);
		remoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(transport);
		remoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(transport);
		remoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(transport);
		remotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(transport);
		remoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(transport);
		remoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(transport);
		remoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(transport);
		clientIF = new com.wilutions.byps.test.api.srvr.BStub_ClientIF(transport);
		serverIF = new com.wilutions.byps.test.api.srvr.BStub_ServerIF(transport);
		evolveIF = new com.wilutions.byps.test.api.ver.BStub_EvolveIF(transport);
	}
	
	@Override
	public BRemote getStub(int remoteId) {
		if (remoteId == 1557084481) return remoteArrayTypes1dim;
		if (remoteId == 1557173854) return remoteArrayTypes4dim;
		if (remoteId == 359349400) return remoteEnums;
		if (remoteId == 1959416539) return remoteException;
		if (remoteId == 1206670536) return remoteInlineInstance;
		if (remoteId == 380156079) return remoteListTypes;
		if (remoteId == 80483097) return remoteMapTypes;
		if (remoteId == 1341983932) return remotePrimitiveTypes;
		if (remoteId == 2086824050) return remoteReferences;
		if (remoteId == 1156008353) return remoteSetTypes;
		if (remoteId == 2028487863) return remoteStreams;
		if (remoteId == 1784257353) return clientIF;
		if (remoteId == 1313562065) return serverIF;
		if (remoteId == 2078696281) return evolveIF;
		return null;
	}
	
	public final com.wilutions.byps.test.api.remote.RemoteArrayTypes1dim remoteArrayTypes1dim;
	public final com.wilutions.byps.test.api.remote.RemoteArrayTypes4dim remoteArrayTypes4dim;
	public final com.wilutions.byps.test.api.remote.RemoteEnums remoteEnums;
	public final com.wilutions.byps.test.api.remote.RemoteException remoteException;
	public final com.wilutions.byps.test.api.remote.RemoteInlineInstance remoteInlineInstance;
	public final com.wilutions.byps.test.api.remote.RemoteListTypes remoteListTypes;
	public final com.wilutions.byps.test.api.remote.RemoteMapTypes remoteMapTypes;
	public final com.wilutions.byps.test.api.remote.RemotePrimitiveTypes remotePrimitiveTypes;
	public final com.wilutions.byps.test.api.remote.RemoteReferences remoteReferences;
	public final com.wilutions.byps.test.api.remote.RemoteSetTypes remoteSetTypes;
	public final com.wilutions.byps.test.api.remote.RemoteStreams remoteStreams;
	public final com.wilutions.byps.test.api.srvr.ClientIF clientIF;
	public final com.wilutions.byps.test.api.srvr.ServerIF serverIF;
	public final com.wilutions.byps.test.api.ver.EvolveIF evolveIF;
	
}
