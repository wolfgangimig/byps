package byps.gen.db;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import byps.BVersioning;
import byps.gen.api.CommentInfo;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.MethodInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;

public class XmlMethodInfo implements XmlInfo {

	public String name;
	public String remoteName;
	public String since;

	public String requestTypeName;
	public String resultTypeName;

	@XmlElementWrapper(name = "exceptionTypeNames") 
    @XmlElement(name = "exceptionTypeName") 
	public List<String> exceptionTypeNames;

	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public List<CommentInfo> comments;

	@XmlTransient
	MethodInfo methodInfo;
	
	public static XmlMethodInfo fromValue(ClassDB classDB, MethodInfo m) {
		XmlMethodInfo x = new XmlMethodInfo();
		x.name = m.name;
		x.requestTypeName = m.requestInfo.toXmlTypeName();
		x.resultTypeName = m.resultInfo.toXmlTypeName();
		x.remoteName = m.remoteInfo.toXmlTypeName();
		x.comments = m.comments;
		x.since = BVersioning.longToString(m.since);
		
		x.exceptionTypeNames = new ArrayList<String>();
		for (TypeInfo einfo : m.exceptions) {
			x.exceptionTypeNames.add(einfo.toString());
		}
		
		return x;
	}

	// Wird aufgerufen, nachdem alle SerialInfos und RemoteInfos gelesen sind. 
	public MethodInfo toValue(ClassDB classDB) throws GeneratorException{
		String requestFullName = TypeInfo.getInfoTypeName(this.requestTypeName);
		SerialInfo requestInfo = classDB.getSerInfo(requestFullName);
		if (requestInfo == null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = requestTypeName;
			errInfo.msg = "Missing class definition";
			throw new GeneratorException(errInfo);
		}
		
		String resultFullName = TypeInfo.getInfoTypeName(this.resultTypeName);
		SerialInfo resultInfo = classDB.getSerInfo(resultFullName);
		if (resultInfo == null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = resultTypeName;
			errInfo.msg = "Missing class definition";
			throw new GeneratorException(errInfo);
		}
		
		ArrayList<TypeInfo> exceptions = new ArrayList<TypeInfo>();
		methodInfo = new MethodInfo(name, 
		    comments, 
		    requestInfo, 
		    resultInfo, 
		    exceptions,
		    BVersioning.stringToLong(since));
		
		requestInfo.methodInfo = methodInfo;
		resultInfo.methodInfo = methodInfo;
		
		if (exceptionTypeNames != null) {
			for (String exName : exceptionTypeNames) {
				SerialInfo exInfo = classDB.getSerInfo(exName);
				if (exInfo == null) {
					ErrorInfo errInfo = new ErrorInfo();
					errInfo.className = requestInfo.toString();
					errInfo.methodName = methodInfo.name;
					errInfo.msg = "Missing exception type=" + exName;
					throw new GeneratorException(errInfo);
				}
				exceptions.add(exInfo);
			}
		}
		
		String fullName =  TypeInfo.getInfoTypeName(remoteName);
		methodInfo.remoteInfo = classDB.getRemoteInfo(fullName);
		if (methodInfo.remoteInfo == null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = fullName;
			errInfo.methodName = methodInfo.name;
			errInfo.msg = "Missing remote class name for method " + methodInfo;
			throw new GeneratorException(errInfo);
		}

		return methodInfo;
	}

	@Override
	public void updateAfterRead(ClassDB classDB) throws GeneratorException {
	}
}	

