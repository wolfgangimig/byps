package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.ParamInfo;
import byps.gen.api.TypeInfo;

public class XmlParamInfo {
	
	public String name;
	public String typeName;
	public boolean isSecret;

	public static XmlParamInfo fromValue(ClassDB classDB, ParamInfo m) {
		XmlParamInfo x = new XmlParamInfo();
		x.name = m.name;
		x.typeName = m.type.toXmlTypeName();
		x.isSecret = m.isSecret;
		return x;
	}

	public ParamInfo toValue(XmlClassDB xmlClassDB, ClassDB classDB) {
		String name = this.name;
		TypeInfo typeInfo = TypeInfo.fromXmlFullName(this.typeName);
		ParamInfo v = new ParamInfo(name, typeInfo, isSecret);
		return v;
	}

}
