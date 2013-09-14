package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;

/**
 * 
 * @BClientRemote
 *
 */
public interface ClientIF extends BRemote {
	
	public int incrementInt(int a) throws RemoteException;

	public List<InputStream> getStreams(int ctrl) throws RemoteException;
	
	public void putStreams(List<InputStream> strm, int ctrl) throws RemoteException;
	
	public ChatStructure sendChat(ChatStructure cs) throws RemoteException;
}
