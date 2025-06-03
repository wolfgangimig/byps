package byps.gen.ts;

import byps.gen.api.MemberInfo;
import byps.gen.api.TypeInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Stores constants for processing in later steps.
 */
public class Cache {

	private final GeneratedNames generatedNames;
	
	/**
	 * Cache of constant members by class type
	 */
	private final HashMap<TypeInfo, Collection<MemberInfo>> constantMembers = new HashMap<>();
	/**
	 * Cache of value members by class type
	 */
	private final HashMap<TypeInfo, Collection<MemberInfo>> valueMembers = new HashMap<>();
	/**
	 * List of classes that get overridden by constant objects.
	 */
	private final ArrayList<TypeInfo> constShadowedClasses = new ArrayList<>();
	/**
	 * List of class names of classes that get processed as stubs.
	 */
	private final ArrayList<String> stubClasses = new ArrayList<>();

	public Cache(
		GeneratedNames generatedNames
	) {
		this.generatedNames = generatedNames;
	}
	
	/**
	 * Registers value and constant members for the given class type.
	 *
	 * @param typeInfo
	 * @param valueMembers
	 * @param constantMembers
	 */
	public void addCachedMembers(
		TypeInfo typeInfo,
		Collection<MemberInfo> valueMembers,
		Collection<MemberInfo> constantMembers
	) {
		this.constantMembers.put(typeInfo, constantMembers);
		this.valueMembers.put(typeInfo, valueMembers);
	}
	
	/**
	 * Returns the constant members for the given class type
	 *
	 * @param typeInfo
	 * @return
	 */
	public Collection<MemberInfo> getConstantMembers(TypeInfo typeInfo) {
		return constantMembers.get(typeInfo);
	}
	
	/**
	 * Returns the value members for the given class type
	 *
	 * @param typeInfo
	 * @return
	 */
	public Collection<MemberInfo> getValueMembers(TypeInfo typeInfo) {
		return valueMembers.get(typeInfo);
	}
	
	/**
	 * Registers a shadowed class to the cache.
	 *
	 * @param typeInfo
	 */
	public void addShadowedClass(TypeInfo typeInfo) {
		this.constShadowedClasses.add(typeInfo);
	}
	
	/**
	 * Returns whether the given class type is shadowed
	 *
	 * @param typeInfo
	 * @return
	 */
	public boolean isShadowedClass(TypeInfo typeInfo) {
		return this.constShadowedClasses.contains(typeInfo);
	}
	
	/**
	 * Returns whether the class given by the package and name is shadowed.
	 *
	 * @param packageName
	 * @param name
	 * @return
	 */
	public boolean isShadowedClass(String packageName, String name) {
		return this.constShadowedClasses
			.stream()
			.anyMatch(typeInfo -> typeInfo.pack.equals(packageName) && typeInfo.name.equals(
				name));
	}
	
	/**
	 * Registers a class type as stub.
	 *
	 * @param typeInfo
	 */
	public void addStubClass(TypeInfo typeInfo) {
		stubClasses.add(typeInfo.qname);
	}
	
	/**
	 * Returns whether the given class type is a stub type.
	 * Checks the name of the given type, the full qualified name and the qualified name with a stub prefix.
	 *
	 * @param typeInfo
	 * @return
	 */
	@SuppressWarnings("RedundantIfStatement")
	public boolean isStubClass(TypeInfo typeInfo) {
		if (stubClasses.contains(typeInfo.qname)) {
			return true;
		}

		if (generatedNames.isStubName(typeInfo.name)) {
			return true;
		}

		if (stubClasses.contains(generatedNames.getStubName(typeInfo))) {
			return true;
		}

		return false;
	}

}
