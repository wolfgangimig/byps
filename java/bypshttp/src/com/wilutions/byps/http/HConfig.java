package com.wilutions.byps.http;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;

public class HConfig {
	
	private final HashMap<String,String> configMap = new HashMap<String,String>();
	
	private int myServerId;
	private ArrayList<Integer> serverIds;
	private HashMap<Integer, String> serverUrls;
	private boolean testAdapterEnabled;
	
	public HConfig() {
	}
	
	public int getMyServerId() {
    	return myServerId;
	}
	
	public boolean isTestAdapterEnabled() {
    	return testAdapterEnabled;
	}
	
	public String getServerUrl(Integer serverId) {
		return serverUrls.get(serverId);
	}
	
	public ArrayList<Integer> getServerIds() {
		return serverIds;
	}
	
	public String getValue(String key, String defaultValue) {
		String ret = configMap.get(key);
		return ret != null && ret.length() != 0 ? ret : defaultValue;
	}
	
	public int getValue(String key, int defaultValue) {
		String ret = configMap.get(key);
		return ret != null && ret.length() != 0 ? Integer.parseInt(ret) : defaultValue;
	}
	
	public boolean getValue(String key, boolean defaultValue) {
		String ret = configMap.get(key);
		return ret != null && ret.length() != 0 ? Boolean.parseBoolean(ret) : defaultValue;
	}
	
	public void init(ServletConfig config) {
		
		// Read configuration options from web.xml
		{
	    	Enumeration<String> en = config.getInitParameterNames();
	    	while(en.hasMoreElements()) {
	    		String key = en.nextElement();
	    		configMap.put(key, config.getInitParameter(key));
	    	}
		}
    	
    	// Configuration from context.xml
		{
	    	Context initCtx;
			try {
				initCtx = new InitialContext();
			   	Context envCtx = (Context) initCtx.lookup("java:comp/env");
			   	
			   	NamingEnumeration<NameClassPair> list = envCtx.list("");
			   	while (list.hasMore()) {
			   	    NameClassPair nc = list.next();
			   	    configMap.put(nc.getName(), envCtx.lookup(nc.getName()).toString());
			   	}
			   	
			} catch (NamingException e) {
				throw new IllegalStateException(e);
			}
		}

		// myServerId
		{
	    	String serverIdStr = configMap.get("bypshttp.serverId");
	    	try {
	    		myServerId = Integer.parseInt(serverIdStr != null ? serverIdStr : "1");
	    	}
	    	catch (NumberFormatException e) {
	    		throw new IllegalStateException("Invalid serverId in configuration, serverId=" + serverIdStr, e);
	    	}
		}
		
		// Server IDs
		{
			serverIds = new ArrayList<Integer>();
			String key = "bypshttp.serverIds";
			String str = configMap.get(key);
			if (str != null) {
				String[] ids = str.split(",");
				for (int i = 0; i < ids.length; i++) {
			    	try {
						serverIds.add(Integer.parseInt(ids[i]));
			    	}
			    	catch (NumberFormatException e) {
			    		throw new IllegalStateException("Invalid serverIds in configuration, serverIds=" + str, e);
			    	}
				}
			}
		}
		
		// Server URLs
		{
			serverUrls = new HashMap<Integer, String>(serverIds.size());
			if (serverUrls != null) {
				for (Integer serverId : serverIds) {
					String key = "bypshttp.server." + serverId + ".url";
					String url = configMap.get(key);
					if (url == null || url.length() == 0) {
						throw new IllegalStateException("Missing url for serverId=" + serverId + " in configuration."); 
					}
					serverUrls.put(serverId, url);
				}
			}
		}
		
		// Test adapter enabled
		{
		   	String testAdapterEnabledStr = configMap.get("testAdapterEnabled");
	    	testAdapterEnabled = testAdapterEnabledStr != null && Boolean.parseBoolean(testAdapterEnabledStr);
		}
		
		
	}


}
