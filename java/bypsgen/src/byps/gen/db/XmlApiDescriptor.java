package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BApiDescriptor;
import byps.BVersioning;

public class XmlApiDescriptor {
	public String name;
	public String apiPack;
	public String version;
	public String bmodel;
	public boolean uniqueObjects;
	
	public static final XmlApiDescriptor fromValue(BApiDescriptor apiDesc) {
		XmlApiDescriptor x = new XmlApiDescriptor();
		x.name = apiDesc.name;
		x.apiPack = apiDesc.basePackage;
		x.version = BVersioning.longToString(apiDesc.version);
		x.uniqueObjects = apiDesc.uniqueObjects;
		return x;
	}
	
	public BApiDescriptor toValue() {
		return new BApiDescriptor(name, apiPack, BVersioning.stringToLong(version), uniqueObjects);
	}
}
