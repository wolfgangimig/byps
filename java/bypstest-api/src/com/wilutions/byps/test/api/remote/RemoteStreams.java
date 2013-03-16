package com.wilutions.byps.test.api.remote;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

public interface RemoteStreams extends BRemote {

	public InputStream getImage() throws BException, InterruptedException;
	
	public void setImage(InputStream istrm) throws BException, InterruptedException;
	
	public TreeMap<Integer, InputStream> getImages() throws BException, InterruptedException;
	
	public void setImages(Map<Integer, InputStream> istrms, int doNotReadStreamAtKey) throws BException, InterruptedException;
	
	public void throwLastException() throws BException, InterruptedException;
	
	public InputStream getTextStream() throws BException, InterruptedException;
}
