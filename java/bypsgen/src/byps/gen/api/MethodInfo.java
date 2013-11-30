package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.List;


public class MethodInfo extends ItemInfo {
	
	public final SerialInfo requestInfo;

	// memberInfo[0] ist return value
	// weitere memberInfo[.] sind Exceptions
	public final SerialInfo resultInfo;
	
	public final ArrayList<TypeInfo> exceptions;
	
	public RemoteInfo remoteInfo;
	
	public final long since;
	
	public final static String METHOD_REQUEST_NAME_PREFIX  = "BRequest_";
	public final static String METHOD_RESULT_NAME_PREFIX  = "BResult_";
	
	public MethodInfo(String name, List<CommentInfo> comments, SerialInfo requestInfo, SerialInfo resultInfo, ArrayList<TypeInfo> exceptions, long since) {
		super(name, comments);
		this.requestInfo = requestInfo;
		this.resultInfo = resultInfo;
		this.exceptions = exceptions != null ? exceptions : new ArrayList<TypeInfo>();
		this.since = since;
	}

	public String getQName() {
		return remoteInfo.qname + "." + name;
	}
}
