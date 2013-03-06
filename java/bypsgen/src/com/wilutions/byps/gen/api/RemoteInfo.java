package com.wilutions.byps.gen.api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class RemoteInfo extends TypeInfo {
	
	public final static String STUB_NAME_PREFIX = "BStub_";
	public final static String SKELETON_NAME_PREFIX = "BSkeleton_";

	public RemoteInfo(String name, List<CommentInfo> comments, String qname, List<MethodInfo> methods) throws GeneratorException {
		super(name, qname, "", null, false, false, false);
		this.methods = methods;
		this.comments = comments;
	}

	public RemoteInfo() throws GeneratorException  {
		this(null, null, null, null);
	}
	
	@XmlElementWrapper(name = "methods") // hä? dafür gibt's XmlMethodInfo
    @XmlElement(name = "method") 
	public List<MethodInfo> methods;
	
	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public final List<CommentInfo> comments;
}
