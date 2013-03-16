package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

public interface ClientIF extends BRemote {
	
	public int incrementInt(int a) throws BException, InterruptedException;

	public List<InputStream> getStreams(int ctrl) throws BException, InterruptedException;
	
	public void putStreams(List<InputStream> strm, int ctrl) throws BException, InterruptedException;
	
	public ChatStructure sendChat(ChatStructure cs) throws BException, InterruptedException;
}
