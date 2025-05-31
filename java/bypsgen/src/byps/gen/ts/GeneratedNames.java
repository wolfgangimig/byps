package byps.gen.ts;

import byps.gen.api.RemoteInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;

/**
 * Utility class to manipulate names of types.
 */
public class GeneratedNames {

	private final ClassDB classDB;
	
	/**
	 * Prefix used by stub classes.
	 */
	public final String STUB_PREFIX = RemoteInfo.STUB_NAME_PREFIX;

	public GeneratedNames(ClassDB classDB) {
		this.classDB = classDB;
	}
	
	/**
	 * Returns the full qualified name of a class type
	 *
	 * @param typeInfo
	 * @return The type packages joined with a period with the typename or only the type name if no package is given.
	 */
	public String fullQualifiedName(TypeInfo typeInfo) {
		return fullQualifiedName(typeInfo.pack, typeInfo.name);
	}
	
	/**
	 * Returns the full qualified name based on the given package and name
	 *
	 * @param packageName - Nullable package name
	 * @param name - Non-null name of the type.
	 * @return The type packages joined with a period with the typename or only the type name if no package is given.
	 */
	public String fullQualifiedName(String packageName, String name) {
		if (packageName.isEmpty()) {
			return name;
		}

		return String.format("%s.%s", packageName, name);
	}
	
	/**
	 * Extract the name of a class type from the full qualified name.
	 *
	 * @param nameOrFQN - Class type name with or without package prefix.
	 * @return
	 */
	private String getNameFromFQN(String nameOrFQN) {
		var lastDot = nameOrFQN.lastIndexOf('.');
		if (lastDot >= 0) {
			return nameOrFQN.substring(lastDot + 1);
		}

		return nameOrFQN;
	}
	
	/**
	 * Returns the name of a class type with the stub prefix removed if it existed
	 *
	 * @param typeInfo - Class type to get the name of.
	 * @return
	 */
	public String getNonStubName(TypeInfo typeInfo) {
		return getNonStubName(typeInfo.name);
	}
	
	/**
	 * Returns the name of a class type with the stub prefix removed if it existed
	 *
	 * @param nameOrFQN - Name or full qualified name to extract the non stub name of.
	 * @return
	 */
	public String getNonStubName(String nameOrFQN) {
		String name = getNameFromFQN(nameOrFQN);

		if (name.startsWith(STUB_PREFIX)) {
			return name.substring(STUB_PREFIX.length());
		}

		return name;
	}
	
	/**
	 * Gets the remote variable name of a given type which is just the type name with a lowercase starting letter.
	 *
	 * @param typeInfo - Type info to get the variable name of.
	 * @return
	 */
	public String getRemoteVariableName(TypeInfo typeInfo) {
		return getRemoteVariableName(typeInfo.name);
	}
	
	/**
	 * Gets the remote variable name of a given type which is just the type name with a lowercase starting letter.
	 *
	 * @param name - Name of the type to transform into a variable name.
	 * @return
	 */
	public String getRemoteVariableName(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}
	
	/**
	 * Returns the stub full qualified name of a given class type.
	 *
	 * @param typeInfo - Type to get the name of.
	 * @return
	 */
	public String getStubName(TypeInfo typeInfo) {
		return getStubName(typeInfo.pack, typeInfo.name);
	}
	
	/**
	 * Returns the stub full qualified name of a given package and name.
	 *
	 * @param packageName - Nullable package name of the resulting full qualified name
	 * @param name - Non-null name of the resulting full qualified name
	 * @return
	 */
	public String getStubName(String packageName, String name) {
		if (isStubName(name)) {
			return fullQualifiedName(packageName, name);
		}
		return fullQualifiedName(packageName, String.format("%s%s", STUB_PREFIX, name));
	}
	
	/**
	 * Returns whether the given type is a stub type
	 *
	 * @param typeInfo
	 * @return
	 */
	public boolean isStubName(TypeInfo typeInfo) {
		return isStubName(typeInfo.name);
	}
	
	/**
	 * Returns whether the given name or full qualified name of a type is a stub name
	 *
	 * @param nameOrFQN
	 * @return
	 */
	public boolean isStubName(String nameOrFQN) {

		nameOrFQN =	getNameFromFQN(nameOrFQN);
		
		return nameOrFQN.startsWith(this.STUB_PREFIX);
	}
	
	/**
	 * Returns the api descriptor class name for the active class db
	 *
	 * @return
	 */
	public String getApiDescriptorClassName() {
		return "BApiDescriptor_" + classDB.getApiDescriptor().name;
	}
	
	/**
	 * Returns the client class name of the active class db
	 *
	 * @return
	 */
	public String getClientClassName() {
		return "BClient_" + classDB.getApiDescriptor().name;
	}
}
