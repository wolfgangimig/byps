package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	 * Remote interface will be implemented on the client side.
	 * If false, a skeleton is not generated for JavaScript, C++ and C#.
	 */
	public final boolean isClientRemote;
	
	/**
	 * This remote extends the interfaces baseQNames.
	 */
	public final List<String> baseQNames = new ArrayList<String>();
	
	public final long since;

	public RemoteInfo(
	    String name, 
	    Collection<CommentInfo> comments, 
	    String qname, 
	    List<String> baseQNames,
	    List<MethodInfo> methods,
	    String authParamClassName, 
	    boolean isClientRemote,
	    long since) {
		super(name, qname, "", null, false, false, false);
		this.methods = methods;
		this.comments = comments;
		this.authParamClassName = authParamClassName;
		this.isClientRemote = isClientRemote;
		if (baseQNames != null) this.baseQNames.addAll(baseQNames);
		this.since = since;
	}

	public RemoteInfo() {
		this(null, null, null, null, null, null, false, 0L);
	}
	
	public List<MethodInfo> methods;
	
	public final Collection<CommentInfo> comments;
	
  public RemoteInfo getRemoteAsync() {
    RemoteInfo rinfo = new RemoteInfo(
        name + ASYNC_SUFFIX, 
        comments, 
        qname + ASYNC_SUFFIX, 
        baseQNames,
        methods, 
        null, 
        isClientRemote,
        since);
    rinfo.typeId = this.typeId;
    return rinfo;
  }

  public RemoteInfo getRemoteAuth() {
    RemoteInfo rinfo = null;
    if (authParamClassName != null) {
      rinfo = makeRemoteAuth();
    }
    return rinfo;
  }
  
  public RemoteInfo makeRemoteAuth() {
    RemoteInfo rinfo = new RemoteInfo(
        name + AUTH_SUFFIX, 
        comments, 
        qname + AUTH_SUFFIX, 
        baseQNames,
        methods, 
        authParamClassName, 
        isClientRemote,
        since);
    rinfo.typeId = this.typeId;
    return rinfo;
  }
  
  public RemoteInfo getRemoteNoAuth() {
    RemoteInfo rinfo = new RemoteInfo(name, 
        comments, 
        qname, 
        baseQNames, 
        methods, 
        null, 
        isClientRemote, 
        since);
    rinfo.typeId = this.typeId;
    return rinfo;
  }

  public RemoteInfo getRemoteInfoAuthOrAsync() {
    RemoteInfo rinfoImpl = getRemoteAuth();
    if (rinfoImpl == null) rinfoImpl = getRemoteAsync();
    return rinfoImpl;
  }


}
