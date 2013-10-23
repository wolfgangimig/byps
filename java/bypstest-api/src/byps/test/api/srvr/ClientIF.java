package byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;

import byps.BRemote;
import byps.RemoteException;

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
