package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.List;

public class MemberInfo extends ItemInfo implements Comparable<MemberInfo> {

	public final TypeInfo type;
	public final boolean isTransient;
	public final boolean isStatic;
	public final boolean isFinal;
	public final MemberAccess access;
	public final long since;
	
	/**
	 * Constant value.
	 * If this refers to a constant, it contains the constants value.
	 */
	public final String value;

	public MemberInfo(String name, List<CommentInfo> comments, TypeInfo type, 
			boolean isPublic, boolean isProtected, boolean isPackage, boolean isPrivate, 
			boolean isFinal, boolean isStatic, boolean isTransient, long since, String value) {
		super(name, comments);
		this.type = type;
		this.access = makeAccess(isPublic, isProtected, isPackage, isPrivate);
		this.isFinal = isFinal;
		this.isStatic = isStatic;
		this.isTransient = isTransient;
		this.since = since;
		this.value = value;
	}

	public MemberInfo(String name, TypeInfo type) {
		this(name, null, type, true, false, false, false, false, false, false, 0, null);
	}
	
	public MemberInfo() {
		this(null, null, null, false, false, false, false, false, false, false, 0, null);
	}
	
	private static MemberAccess makeAccess(boolean isPublic, boolean isProtected, boolean isPackage, boolean isPrivate) {
		MemberAccess a = MemberAccess.PUBLIC;
		if (isProtected) a = MemberAccess.PROTECTED;
		else if (isPackage) a = MemberAccess.PACKAGE;
		else if (isPrivate) a = MemberAccess.PRIVATE;
		return a;
	}

	@Override
	public int compareTo(MemberInfo rhs) {
		if (this.type.isPointerType() && !rhs.type.isPointerType()) return +1;
		if (!this.type.isPointerType() && rhs.type.isPointerType()) return -1;
		
		if (this.since < rhs.since) return -1;
		if (this.since > rhs.since) return +1; 
		
		return this.name.compareTo(rhs.name);
	}
	
	@Override
	public String toString() {
		return "[" + this.name + ", type=" + this.type + "]";
	}
}
