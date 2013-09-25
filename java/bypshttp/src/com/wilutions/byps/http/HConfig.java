package com.wilutions.byps.http;

import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public interface HConfig {

  public int getMyServerId();

  public boolean isTestAdapterEnabled();

  public String getServerUrl(Integer serverId);

  public Collection<Integer> getServerIds();

  public void init(ServletConfig config) throws ServletException;

}