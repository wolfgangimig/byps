package byps.gen.api;



public class ParamInfo {

	public final String name;

	public final TypeInfo type;

	public ParamInfo(String name, TypeInfo type) {
		this.name = name;
		this.type = type;
	}
	
	public ParamInfo() {
		this(null,null);
	}

	public MemberInfo toMemberInfo() {
		MemberInfo minfo = new MemberInfo(name, null, type, true, false, false, false, false, false, false, 0, null);
		return minfo;
	}

}
