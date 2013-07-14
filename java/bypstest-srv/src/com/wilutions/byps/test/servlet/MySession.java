package com.wilutions.byps.test.servlet;

import java.io.File;

import javax.servlet.http.HttpSession;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BNegotiate;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.BServerRegistry;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BTransportFactory;
import com.wilutions.byps.http.HSession;
import com.wilutions.byps.http.HTransportFactoryServer;
import com.wilutions.byps.test.api.BApiDescriptor_Testser;
import com.wilutions.byps.test.api.BServer_Testser;
import com.wilutions.byps.test.api.JRegistry_Testser;

public class MySession extends HSession {
	
	private final BServer_Testser server;
	private final MyRemoteStreams myRemoteStreams = new MyRemoteStreams();
	private final MyRemoteServerCtrl myRemoteServerCtrl = new MyRemoteServerCtrl();
	
	/**
	 * Application version.
	 * This value is changed in TestRemoteNegotiateVersion via testAdapter
	 * in order to simulate older and newer application versions.
	 */
	public static volatile int appVersion = BApiDescriptor_Testser.instance.version;

	public MySession(HttpSession hsess, File tempDir, BServerRegistry serverRegistry) {
		super(hsess, tempDir, serverRegistry);
		
		// Define an API descriptor with an application version from static member appVersion.
		BApiDescriptor myDesc = new BApiDescriptor(
				BApiDescriptor_Testser.instance.name,
				BApiDescriptor_Testser.instance.basePackage,
				BApiDescriptor_Testser.instance.bmodel,
				appVersion,
				BApiDescriptor_Testser.instance.uniqueObjects,
				BApiDescriptor_Testser.instance.getProtocols(),
				BApiDescriptor_Testser.instance.getRegistry()
				);
		
		BRegistry registryJSON = new JRegistry_Testser(BBinaryModel.JSON);
		myDesc.addProtocol(BNegotiate.JSON, registryJSON);

		BTransportFactory transportFactory = new HTransportFactoryServer(
				myDesc, getWireServer(), getWireClientR(), serverRegistry);
		
		server = BServer_Testser.createServer(transportFactory);
		
		server.addRemote(new MyRemoteArrayTypes1dim());
		server.addRemote(new MyRemoteSetTypes()); 
		server.addRemote(new MyRemotePrimitiveTypes());
		server.addRemote(new MyRemoteEnums());
		server.addRemote(new MyRemoteListTypes());
		server.addRemote(new MyRemoteArrayTypes4dim());
		server.addRemote(new MyRemoteMapTypes());
		server.addRemote(new MyServerIF(this));
		server.addRemote(myRemoteStreams);
		server.addRemote(new MyEvolve(this));
		server.addRemote(new MyRemoteInlineInstance());
		server.addRemote(new MyRemoteArrayTypes23());
		server.addRemote(new MyRemoteConstants());

		myRemoteServerCtrl.setServerRegistry(serverRegistry); 
		server.addRemote(myRemoteServerCtrl);
	}
	
	@Override
	public void done() {
		myRemoteStreams.done();
		super.done();
	}

	@Override
	public BServer getServer() {
		return server;
	}

}

