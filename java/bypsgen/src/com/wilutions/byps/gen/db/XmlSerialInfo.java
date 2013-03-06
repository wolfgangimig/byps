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
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;

public class XmlSerialInfo implements XmlInfo {
	
    @XmlElement(name = "typeName") 
	public String typeName;
	
    @XmlElement(name = "typeId") 
	public int typeId;
	
	@XmlElementWrapper(name = "members") 
    @XmlElement(name = "member") 
	public List<XmlMemberInfo> members;
	
	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public List<CommentInfo> comments;
	
	public String baseFullName;
	public boolean isInline;
	public boolean isEnum;
	public boolean isFinal;
	
	public static XmlSerialInfo fromValue(ClassDB classDB, SerialInfo v) {
		XmlSerialInfo x = new XmlSerialInfo();

		x.typeName = v.toXmlTypeName();
		x.typeId = v.typeId;
		
		x.members = new ArrayList<XmlMemberInfo>(v.members.size());
		for (MemberInfo m : v.members) {
			XmlMemberInfo xm = XmlMemberInfo.fromValue(classDB, m);
			x.members.add(xm); 
		}
		
		x.comments = v.comments;
		x.baseFullName = v.baseInfo != null ? v.baseInfo.toString() : "";
		x.isInline = v.isInline;
		x.isEnum = v.isEnum;
		x.isFinal = v.isFinal;
		
		return x;
	}
	
	public SerialInfo toValue(XmlClassDB xmlClassDB, ClassDB classDB) throws GeneratorException {
		log.debug("toValue(" + typeName);
		
		TypeInfo t = TypeInfo.fromXmlFullName(typeName);
		log.debug("typeInfo=" + t);
		
		SerialInfo serInfo = classDB.createSerialInfo(t.name, comments, t.qname, "", 
				t.dims,
				t.typeArgs, 
				null, 
				this.isEnum, 
				this.isFinal,
				this.isInline);
		
		classDB.add(serInfo);
		xmlClassDB.pushUpdate(this);
		
		serInfo.typeId = this.typeId;

		log.debug(")toValue=" + serInfo);
		return serInfo;
	}

	public void updateAfterRead(ClassDB classDB) throws GeneratorException {
		log.debug("updateAfterRead(" + typeName);
		
		String fullName = TypeInfo.getInfoTypeName(typeName);
		SerialInfo serInfo = classDB.getSerInfo(fullName);
		log.debug("serInfo=" + serInfo);

		if (serInfo != null) {
		
			log.debug("baseFullName=" + baseFullName);
			if (baseFullName != null && baseFullName.length() != 0) {
				serInfo.baseInfo = classDB.getSerInfo(baseFullName);
				if (serInfo.baseInfo == null) {
					log.warn("Class " + fullName + ": missing definition of base class " + baseFullName);
				}
			}
			
			TypeInfo t = TypeInfo.fromXmlFullName(typeName);
			ArrayList<TypeInfo> typeArgs = new ArrayList<TypeInfo>(t.typeArgs.size());
			for (int i = 0; i < t.typeArgs.size(); i++) {
				TypeInfo typeArgP = t.typeArgs.get(i);
				String argQName = typeArgP.toString();
				TypeInfo typeArg = classDB.getTypeInfo(argQName);
				if (typeArg == null) {
					log.warn("Class " + fullName + ": missing definition of type argument class " + argQName);
					typeArg = t.typeArgs.get(i);
				}
				typeArgs.add(typeArg);
			}
			serInfo.typeArgs = typeArgs;

			ArrayList<MemberInfo> memberInfos = new ArrayList<MemberInfo>();
			for (XmlMemberInfo x : members) {
				MemberInfo m = x.toValue(classDB); 
				memberInfos.add(m); 
			}
			serInfo.members = memberInfos;
			
		}
		else {
			log.error("Missing class definition of " + typeName);
		}

		log.debug(")updateAfterRead");
	}

    @XmlTransient
	private Log log = LogFactory.getLog(XmlSerialInfo.class);
}
