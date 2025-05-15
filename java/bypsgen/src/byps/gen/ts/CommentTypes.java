package byps.gen.ts;

import byps.gen.api.CommentInfo;

import java.util.List;

public enum CommentTypes {

	REMARKS("@remarks", true, false), SUMMARY("@summary", true, true), ASYNC(
		"@async",
		false,
		false
	), PARAMETERS("@param", false, false), SEE(
		"@see",
		false,
		false
	), RETURN("@return", false, false), THROWS("@throws", false, false), SINCE(
		"@since",
		true,
		true
	), DEPRECATED("@deprecated", true, true), AUTHOR("@author", false, false), OTHER(
		"",
		false,
		true
	),
	;

	private final String kind;
	private final boolean spaceAbove;
	private final boolean spaceBelow;

	CommentTypes(String kind, boolean spaceBelow, boolean spaceAbove) {
		this.kind = kind;
		this.spaceAbove = spaceAbove;
		this.spaceBelow = spaceBelow;
	}

	public String getKind() {
		return kind;
	}

	public boolean requiresSpaceUntil(CommentTypes type) {
		return CommentTypes.requiresSpaceBetween(this, type);
	}

	public static CommentTypes typeOfKind(String kind) {
		for (CommentTypes type : CommentTypes.values()) {
			if (type.kind.equalsIgnoreCase(kind)) {
				return type;
			}
		}

		return CommentTypes.OTHER;
	}

	private static int ordinalOfKind(String kind) {
		return typeOfKind(kind).ordinal();
	}

	private static int commentComparator(CommentInfo commentA, CommentInfo commentB) {
		return ordinalOfKind(commentA.kind) - ordinalOfKind(commentB.kind);
	}

	public static void sortComments(List<CommentInfo> comments) {
		comments.sort(CommentTypes :: commentComparator);
	}

	public static boolean requiresSpaceBetween(CommentTypes typeA, CommentTypes typeB) {
		int start = typeA.ordinal();
		int end = typeB.ordinal();

		if (end <= start) {
			return false;
		}

		for (int i = start; i <= end; i++) {
			if (i >= CommentTypes.values().length) {
				return false;
			}
			CommentTypes type = CommentTypes.values()[i];
			if (i != start && type.spaceAbove) {
				return true;
			}
			if (i != end && type.spaceBelow) {
				return true;
			}
		}

		return false;
	}

}
