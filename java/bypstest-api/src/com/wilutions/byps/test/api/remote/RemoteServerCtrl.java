package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

public interface RemoteServerCtrl extends BRemote {

	public void publishRemote(String name, BRemote remote, boolean fowardToOtherServers) throws BException, InterruptedException;
	
	public BRemote getPublishedRemote(String name) throws BException, InterruptedException;
	
	public void removePublishedRemote(String name) throws BException, InterruptedException;
}