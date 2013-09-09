package com.wilutions.byps.gen.api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class RemoteInfo extends TypeInfo {
	
	public final static String STUB_NAME_PREFIX = "BStub_";
	public final static String SKELETON_NAME_PREFIX = "BSkeleton_";
  public final static String ASYNC_SUFFIX = "Async";
  public final static String AUTH_SUFFIX = "Auth";
	
	/**
	 * Class name of authentication parameter.
	 * Full qualified class name of the parameter in the interface method that represents the authenticated user.
	 * If this value is set, a second asynchronous interface is created without the parameter of this class.
	 * This parameter is supplied internally in the BStub from the BAuthentication interface.
	 */
	public final String authParamClassName;
	
	/**
	 * Base class for the asynchronous interface.
	 * If not set, this.qname is used.
	 */
	public final String authBase;
	
	/**
	 * Remote interface will be implemented on the client side.
	 * If false, a skeleton is not generated for JavaScript, C++ and C#.
	 */
	public final boolean isClientRemote;

	public RemoteInfo(String name, List<CommentInfo> comments, String qname, List<MethodInfo> methods,
	    String authParamClassName, String authBase, boolean isClientRemote) throws GeneratorException {
		super(name, qname, "", null, false, false, false);
		this.methods = methods;
		this.comments = comments;
		this.authParamClassName = authParamClassName;
		this.authBase = authBase;
		this.isClientRemote = isClientRemote;
	}

	public RemoteInfo() throws GeneratorException  {
		this(null, null, null, null, null, null, false);
	}
	
	@XmlElementWrapper(name = "methods") // hä? dafür gibt's XmlMethodInfo
    @XmlElement(name = "method") 
	public List<MethodInfo> methods;
	
	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public final List<CommentInfo> comments;
	
	public String getBaseClassQName() {
    if (name.endsWith(ASYNC_SUFFIX)) {
      return name.substring(0, name.length() - ASYNC_SUFFIX.length());
    }
    else if (name.endsWith(AUTH_SUFFIX)) {
      return authBase;
    }
	  return null;
	}
	
  public RemoteInfo getRemoteAsync() throws GeneratorException {
    RemoteInfo rinfo = new RemoteInfo(name + ASYNC_SUFFIX, comments, qname + ASYNC_SUFFIX, methods, null, null, isClientRemote);
    rinfo.typeId = this.typeId;
    return rinfo;
  }

  public RemoteInfo getRemoteAuth() throws GeneratorException {
    RemoteInfo rinfo = null;
    if (authParamClassName != null) {
      rinfo = new RemoteInfo(name + AUTH_SUFFIX, comments, qname + AUTH_SUFFIX, methods, authParamClassName, authBase, isClientRemote);
      rinfo.typeId = this.typeId;
    }
    return rinfo;
  }
}
