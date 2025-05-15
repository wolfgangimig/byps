package byps.gen.ts;

import byps.gen.api.MemberInfo;
import byps.gen.api.TypeInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Cache {

	private final GeneratedNames generatedNames;

	private final HashMap<TypeInfo, Collection<MemberInfo>> constantMembers = new HashMap<>();
	private final HashMap<TypeInfo, Collection<MemberInfo>> valueMembers = new HashMap<>();
	private final ArrayList<TypeInfo> constShadowedClasses = new ArrayList<>();
	private final ArrayList<String> stubClasses = new ArrayList<>();

	public Cache(
		GeneratedNames generatedNames
	) {
		this.generatedNames = generatedNames;
	}

	public void addCachedMembers(
		TypeInfo typeInfo,
		Collection<MemberInfo> valueMembers,
		Collection<MemberInfo> constantMembers
	) {
		this.constantMembers.put(typeInfo, constantMembers);
		this.valueMembers.put(typeInfo, valueMembers);
	}

	public Collection<MemberInfo> getConstantMembers(TypeInfo typeInfo) {
		return constantMembers.get(typeInfo);
	}

	public Collection<MemberInfo> getValueMembers(TypeInfo typeInfo) {
		return valueMembers.get(typeInfo);
	}

	public void addShadowedClass(TypeInfo typeInfo) {
		this.constShadowedClasses.add(typeInfo);
	}

	public boolean isShadowedClass(TypeInfo typeInfo) {
		return this.constShadowedClasses.contains(typeInfo);
	}

	public boolean isShadowedClass(String packageName, String name) {
		return this.constShadowedClasses
			.stream()
			.anyMatch(typeInfo -> typeInfo.pack.equals(packageName) && typeInfo.name.equals(
				name));
	}

	public void addStubClass(TypeInfo typeInfo) {
		stubClasses.add(typeInfo.qname);
	}

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
