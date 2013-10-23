package byps.gen.db;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BVersioning;
import byps.gen.api.CommentInfo;
import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.TypeInfo;

public class XmlMemberInfo {

	public String name;
	public List<CommentInfo> comments;
	public String typeName;
	public boolean isTransient;
	public boolean isStatic;
	public boolean isFinal;
	public MemberAccess access;
	public String since;
	public String value;
	
	@XmlTransient
	private MemberInfo v; 

	public static XmlMemberInfo fromValue(ClassDB classDB, MemberInfo v) {
		XmlMemberInfo x = new XmlMemberInfo();
		x.name = v.name;
		x.comments = v.comments;
		x.typeName = v.type.toXmlTypeName();
		x.isTransient = v.isTransient;
		x.isStatic = v.isStatic;
		x.isFinal = v.isFinal;
		x.access = v.access;
		x.since = BVersioning.longToString(v.since);
		
		if (v.value != null) {
			// Since this stupid javax.xml.stuff is not able to write a "\0", encode all values with base64
			try { 
				byte[] bvalue = v.value.getBytes("UTF-8");
				x.value = javax.xml.bind.DatatypeConverter.printBase64Binary(bvalue);
			} catch (UnsupportedEncodingException never) {}
		}
		
		return x;
	}
	
	public MemberInfo toValue(ClassDB classDB) {
		log.debug("toValue(" + typeName);
		
		String qname = TypeInfo.getInfoTypeName(typeName);
		TypeInfo typeInfo = classDB.getTypeInfo(qname);
		
		if (value != null) {
			byte[] bvalue = javax.xml.bind.DatatypeConverter.parseBase64Binary(value);
			try { value = new String(bvalue, "UTF-8"); } catch (UnsupportedEncodingException never) {}
		}
		
		v = new MemberInfo(name, comments, typeInfo, 
				access == MemberAccess.PUBLIC,
				access == MemberAccess.PROTECTED,
				access == MemberAccess.PACKAGE,
				access == MemberAccess.PRIVATE,
				isFinal, isStatic, isTransient,
				BVersioning.stringToLong(since), 
				value);
		
		log.debug(")toValue=" + v);
		return v;
	}

    @XmlTransient
	private Log log = LogFactory.getLog(XmlMemberInfo.class);
}
