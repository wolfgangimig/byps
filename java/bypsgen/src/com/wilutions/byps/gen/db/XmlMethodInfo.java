package com.wilutions.byps.gen.db;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;

public class XmlMethodInfo implements XmlInfo {

	public String name;
	public String remoteName;

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
		
		String resultFullName = TypeInfo.getInfoTypeName(this.resultTypeName);
		SerialInfo resultInfo = classDB.getSerInfo(resultFullName);
		
		ArrayList<TypeInfo> exceptions = new ArrayList<TypeInfo>();
		methodInfo = new MethodInfo(name, comments, requestInfo, resultInfo, exceptions);

		if (exceptionTypeNames != null) {
			for (String exName : exceptionTypeNames) {
				SerialInfo exInfo = classDB.getSerInfo(exName);
				if (exInfo == null) {
					throw new GeneratorException("Class " + methodInfo + ": Missing exception type=" + exName);
				}
				exceptions.add(exInfo);
			}
		}
		
		if (requestInfo != null) {
			requestInfo.methodInfo = methodInfo;
		}
		else {
			log.error("Method " + name + ": missing class definition of " + requestFullName);
		}
		
		if (resultInfo != null) {
			resultInfo.methodInfo = methodInfo;
		}
		else {
			log.error("Method " + name + ": missing class definition of " + resultFullName);
		}

		String fullName =  TypeInfo.getInfoTypeName(remoteName);
		methodInfo.remoteInfo = classDB.getRemoteInfo(fullName);
		if (methodInfo.remoteInfo == null) {
			throw new GeneratorException("Missing remote class name for method " + methodInfo);
		}

		return methodInfo;
	}

	private Log log = LogFactory.getLog(XmlMethodInfo.class);

	@Override
	public void updateAfterRead(ClassDB classDB) throws GeneratorException {
	}
}	

