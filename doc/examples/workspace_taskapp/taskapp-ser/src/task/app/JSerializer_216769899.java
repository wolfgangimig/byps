package task.app;

/*
 * Serializer for task.app.BStub_TaskService
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class JSerializer_216769899 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_216769899();
	
	public JSerializer_216769899() {
		super(216769899);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_TaskService(transport);
	}
	
}