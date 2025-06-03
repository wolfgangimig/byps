package byps.gen.ts;

import byps.gen.api.CommentInfo;

import java.util.List;

/**
 * Utility enum for comment sorting and spacing.
 */
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
	
	/**
	 * @returns the @ annotation of the comment type.
	 */
	public String getKind() {
		return kind;
	}
	
	/**
	 * Check whether this comment type demands a blank line until the given comment type
	 *
	 * @param type - Lower priority order type to check to if a blank line is demanded.
	 * @return
	 */
	public boolean requiresSpaceUntil(CommentTypes type) {
		return CommentTypes.requiresSpaceBetween(this, type);
	}
	
	/**
	 * Return a member of this enum based from the given kind.
	 *
	 * @param kind - The @ annotation of a comment.
	 * @return The comment type from the given kind or {@link CommentTypes#OTHER} if no matching is found.
	 */
	public static CommentTypes typeOfKind(String kind) {
		for (CommentTypes type : CommentTypes.values()) {
			if (type.kind.equalsIgnoreCase(kind)) {
				return type;
			}
		}

		return CommentTypes.OTHER;
	}
	
	/**
	 * Returns the ordinal of the given kind based on {@link CommentTypes#typeOfKind(String)}
	 *
	 * @param kind - The @ annotation of a comment.
	 * @return
	 */
	private static int ordinalOfKind(String kind) {
		return typeOfKind(kind).ordinal();
	}
	
	/**
	 * Comparator for {@link CommentInfo} that sorts the comments based on {@link CommentInfo#kind}.
	 *
	 * @param commentA - The first comment to compare
	 * @param commentB - The comment to compare against
	 * @return
	 */
	private static int commentComparator(CommentInfo commentA, CommentInfo commentB) {
		return ordinalOfKind(commentA.kind) - ordinalOfKind(commentB.kind);
	}
	
	/**
	 * Sort a list of {@link CommentInfo} based on the {@link CommentInfo#kind}.
	 * The sort uses a stable algorithm so the comments may be presorted.
	 *
	 * @param comments - Unsorted or sorted list of comments.
	 */
	public static void sortComments(List<CommentInfo> comments) {
		comments.sort(CommentTypes :: commentComparator);
	}
	
	/**
	 * Determines whether the two given comment types demand a blank line between them.
	 *
	 * @param typeA
	 * @param typeB
	 * @return
	 */
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
