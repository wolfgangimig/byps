package com.wilutions.byps.http;

import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public interface HConfig {

  int getMyServerId();

  void init(ServletConfig servletConfig) throws ServletException;

  boolean isTestAdapterEnabled();

  Collection<Integer> getServerIds();

  String getServerUrl(Integer serverId);

}
