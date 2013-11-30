package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BVersioning;
import byps.gen.api.CommentInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;

public class XmlRemoteInfo implements XmlInfo {
	
  @XmlElement(name = "typeName") 
	String typeName;
	
  @XmlElement(name = "typeId") 
	public int typeId;
    
  @XmlElement(name = "authParamClassName") 
  String authParamClassName; 

  @XmlElement(name = "isClientRemote")
  boolean isClientRemote;
	
	@XmlElementWrapper(name = "methods") 
  @XmlElement(name = "method") 
	public List<XmlMethodInfo> methods;
	
	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public List<CommentInfo> comments;

  public List<String> baseQNames;
  
  public String since;
	
	public static XmlRemoteInfo fromValue(ClassDB classDB, RemoteInfo v) {
		XmlRemoteInfo x = new XmlRemoteInfo();

		x.typeName = v.toXmlTypeName();
		x.typeId = v.typeId;
		x.authParamClassName = v.authParamClassName;
		x.isClientRemote = v.isClientRemote;
		x.baseQNames = v.baseQNames;
		x.since = BVersioning.longToString(v.since);
		
		x.methods = new ArrayList<XmlMethodInfo>(v.methods.size());
		for (MethodInfo m : v.methods) {
			XmlMethodInfo xm = XmlMethodInfo.fromValue(classDB, m);
			x.methods.add(xm); 
		}
		
		x.comments = v.comments;
		
		return x;
	}
	
	public RemoteInfo toValue(XmlClassDB xmlClassDB, ClassDB classDB) throws GeneratorException {
		log.debug("toValue(" + typeName);
		
		TypeInfo t = TypeInfo.fromXmlFullName(typeName);
		log.debug("typeInfo=" + t);

		RemoteInfo remoteInfo = classDB.createRemoteInfo(t.name, 
		    comments, t.qname, baseQNames, 
		    null, authParamClassName, isClientRemote,
		    BVersioning.stringToLong(since));
		xmlClassDB.pushUpdate(this);
		
		remoteInfo.typeId = this.typeId;
		
		SerialInfo serInfo = classDB.createStubForRemote(remoteInfo);
		serInfo.typeId = this.typeId;
		
		log.debug(")toValue=" + remoteInfo);
		return remoteInfo;
	}
	

	@Override
	public void updateAfterRead(ClassDB classDB) throws GeneratorException {
		log.debug("updateAfterRead(");
		
		String fullName = TypeInfo.getInfoTypeName(typeName);
		RemoteInfo remoteInfo = classDB.getRemoteInfo(fullName);
		log.debug("remoteInfo=" + remoteInfo);

		ArrayList<MethodInfo> methodInfos = new ArrayList<MethodInfo>();
		for (XmlMethodInfo x : methods) {
			MethodInfo m = x.toValue(classDB); 
			methodInfos.add(m); 
			
			classDB.updateMethodInfoAfterRead(m);
		}
		
		remoteInfo.methods = methodInfos;

		log.debug(")updateAfterRead");
	}

    @XmlTransient
	private Log log = LogFactory.getLog(XmlRemoteInfo.class);

}
