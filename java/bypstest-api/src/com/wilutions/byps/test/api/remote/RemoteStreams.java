package com.wilutions.byps.test.api.remote;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.BRemote;

public interface RemoteStreams extends BRemote {

	public InputStream getImage();
	
	public void setImage(InputStream istrm);
	
	public TreeMap<Integer, InputStream> getImages();
	
	public void setImages(Map<Integer, InputStream> istrms, int doNotReadStreamAtKey);
	
	public void throwLastException();
	
	public InputStream getTextStream();
}
