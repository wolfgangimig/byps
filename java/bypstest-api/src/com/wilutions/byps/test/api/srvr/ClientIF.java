package com.wilutions.byps.test.api.srvr;

import java.io.InputStream;
import java.util.List;

import com.wilutions.byps.BRemote;

public interface ClientIF extends BRemote {
	
	public int incrementInt(int a);

	public List<InputStream> getStreams(int ctrl);
	
	public void putStreams(List<InputStream> strm, int ctrl);
	
	public ChatStructure sendChat(ChatStructure cs);
}
