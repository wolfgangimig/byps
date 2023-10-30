package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */


public class ParamInfo {

	public final String name;

	public final TypeInfo type;
	
	public final boolean isSecret;

	public ParamInfo(String name, TypeInfo type, boolean isSecret) {
		this.name = name;
		this.type = type;
		this.isSecret = isSecret;
	}
	
	public ParamInfo() {
		this(null,null, false);
	}

	public MemberInfo toMemberInfo() {
		MemberInfo minfo = new MemberInfo(name, null, type, true, false, false, false, false, false, false, isSecret, 0, null);
		return minfo;
	}

}
