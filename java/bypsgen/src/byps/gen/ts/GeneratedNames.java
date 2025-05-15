package byps.gen.ts;

import byps.gen.api.RemoteInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;

public class GeneratedNames {

	private final ClassDB classDB;

	public final String STUB_PREFIX = RemoteInfo.STUB_NAME_PREFIX;

	public GeneratedNames(ClassDB classDB) {
		this.classDB = classDB;
	}

	public String fullQualifiedName(TypeInfo typeInfo) {
		return fullQualifiedName(typeInfo.pack, typeInfo.name);
	}

	public String fullQualifiedName(String packageName, String name) {
		if (packageName.isEmpty()) {
			return name;
		}

		return String.format("%s.%s", packageName, name);
	}

	private String getNameFromFQN(String nameOrFQN) {
		var lastDot = nameOrFQN.lastIndexOf('.');
		if (lastDot >= 0) {
			return nameOrFQN.substring(lastDot + 1);
		}

		return nameOrFQN;
	}

	public String getNonStubName(TypeInfo typeInfo) {
		return getNonStubName(typeInfo.name);
	}

	public String getNonStubName(String nameOrFQN) {
		String name = getNameFromFQN(nameOrFQN);

		if (name.startsWith(STUB_PREFIX)) {
			return name.substring(STUB_PREFIX.length());
		}

		return name;
	}

	public String getStubName(TypeInfo typeInfo) {
		return getStubName(typeInfo.pack, typeInfo.name);
	}

	public String getStubName(String packageName, String name) {
		return String.format("%s.%s%s", packageName, STUB_PREFIX, name);
	}

	public boolean isStubName(TypeInfo typeInfo) {
		return isStubName(typeInfo.name);
	}

	public boolean isStubName(String nameOrFQN) {

		return nameOrFQN.startsWith(this.STUB_PREFIX);
	}

	public String getApiDescriptorClassName() {
		return "BApiDescriptor_" + classDB.getApiDescriptor().name;
	}

	public String getClientClassName() {
		return "BClient_" + classDB.getApiDescriptor().name;
	}
}
