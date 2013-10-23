package byps.test.api.remote;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import byps.BRemote;
import byps.RemoteException;

public interface RemoteStreams extends BRemote {

	public InputStream getImage() throws RemoteException;
	
	public void setImage(InputStream istrm) throws RemoteException;
	
	public TreeMap<Integer, InputStream> getImages() throws RemoteException;
	
	public void setImages(Map<Integer, InputStream> istrms, int doNotReadStreamAtKey) throws RemoteException;
	
	public void throwLastException() throws RemoteException;
	
	public InputStream getTextStream() throws RemoteException;
}
