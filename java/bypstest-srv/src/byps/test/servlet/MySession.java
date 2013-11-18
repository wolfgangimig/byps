package byps.test.servlet;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BServer;
import byps.BServerRegistry;
import byps.BTransportFactory;
import byps.http.HSession;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BRegistry_Testser;
import byps.test.api.BServer_Testser;
import byps.test.api.JRegistry_Testser;

public class MySession extends HSession {
	
	private final BServer_Testser server;
	private final MyRemoteStreams myRemoteStreams = new MyRemoteStreams();
	private final MyRemoteServerCtrl myRemoteServerCtrl = new MyRemoteServerCtrl();
	
	/**
	 * Application version.
	 * This value is changed in TestRemoteNegotiateVersion via testAdapter
	 * in order to simulate older and newer application versions.
	 */
	public static volatile long appVersion = BApiDescriptor_Testser.instance().version;
	
	/**
	 * All tests run without authentication except TestRemoteWithAuthentication.
	 */
	public static volatile boolean useAuthentication = false;

	public MySession(HttpSession hsess, String remoteUser, File tempDir, BServerRegistry stubRegistry) {
		super(hsess, remoteUser, tempDir, stubRegistry);
		
		if (log.isDebugEnabled()) log.debug("MySession(");
		
		if (log.isDebugEnabled()) log.debug("useAuthentication=" + useAuthentication);
		if (!useAuthentication) {
		  setSessionAuthenticated();
		}
		
		// Define an API descriptor with an application version from static member appVersion.
		// This block is only useful for the test suite. A real implementation would use
		// BApiDescriptor_Testser.instance and add the JRegistry_Testser.
		BApiDescriptor myDesc = new BApiDescriptor(
				BApiDescriptor_Testser.instance().name,
				BApiDescriptor_Testser.instance().basePackage,
				appVersion,
				BApiDescriptor_Testser.instance().uniqueObjects
				);
		
		myDesc.addRegistry(new JRegistry_Testser());
		myDesc.addRegistry(new BRegistry_Testser());

		BTransportFactory transportFactory = getTransportFactory(myDesc);
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
		server.addRemote(new MyRemoteWithAuthentication(this));

		myRemoteServerCtrl.setServerRegistry(stubRegistry); 
		server.addRemote(myRemoteServerCtrl);
		
    if (log.isDebugEnabled()) log.debug(")MySession");
	}
	
	@Override
	public void done() {
	  if (log.isDebugEnabled()) log.debug("done(");
		myRemoteStreams.done();
		super.done();
		if (log.isDebugEnabled()) log.debug(")done");
	}

	@Override
	public BServer getServer() {
		return server;
	}

	private final Log log = LogFactory.getLog(MySession.class);
}

