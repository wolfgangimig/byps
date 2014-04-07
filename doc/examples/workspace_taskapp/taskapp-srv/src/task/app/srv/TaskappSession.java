package task.app.srv;

import java.io.File;

import javax.servlet.http.HttpSession;

import task.app.BApiDescriptor_Taskapp;
import task.app.BServer_Taskapp;
import task.app.JRegistry_Taskapp;
import byps.BApiDescriptor;
import byps.BServer;
import byps.BServerRegistry;
import byps.BTransportFactory;
import byps.http.HSession;

public class TaskappSession extends HSession {
	
	private final BServer_Taskapp bserver;

	// Append the JSON serializer registry to the API descriptor
	public final static BApiDescriptor apiDesc = 
			BApiDescriptor_Taskapp.instance()
				.addRegistry(new JRegistry_Taskapp());
	
	public TaskappSession(HttpSession hsess, String remoteUser, File tempDir,
			BServerRegistry stubRegistry) {
		super(hsess, remoteUser, tempDir, stubRegistry);
		
		// Create the BServer object
		BTransportFactory transportFactory = getTransportFactory(apiDesc);
		bserver = BServer_Taskapp.createServer(transportFactory);
		
		// Add the interfaces you want to implement
		bserver.addRemote(new TaskServiceImpl(remoteUser));

		// Mark session valid
		setSessionAuthenticated();
	}

	@Override
	public BServer getServer() {
		return bserver;
	}

}
