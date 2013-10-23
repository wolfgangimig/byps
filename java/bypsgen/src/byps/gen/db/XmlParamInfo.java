package byps.gen.db;

import byps.gen.api.ParamInfo;
import byps.gen.api.TypeInfo;

public class XmlParamInfo {
	
	public String name;
	public String typeName;

	public static XmlParamInfo fromValue(ClassDB classDB, ParamInfo m) {
		XmlParamInfo x = new XmlParamInfo();
		x.name = m.name;
		x.typeName = m.type.toXmlTypeName();
		return x;
	}

	public ParamInfo toValue(XmlClassDB xmlClassDB, ClassDB classDB) {
		String name = this.name;
		TypeInfo typeInfo = TypeInfo.fromXmlFullName(this.typeName);
		ParamInfo v = new ParamInfo(name, typeInfo);
		return v;
	}

}
