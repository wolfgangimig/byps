package byps.gen.ts;

import byps.gen.api.CommentInfo;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Utility class to print comments for any type info.
 */
public class CommentPrinter {

	private final PrintContext printContext;
	private final CodePrinter codePrinter;
	private final List<CommentInfo> comments;
	
	/**
	 * Creates a {@link CommentPrinter} to print comments for a method that also checks the remote info for any missing,
	 * or nonexistent parameters.
	 *
	 * @param codePrinter - The {@link CodePrinter} to use for printing the comment.
	 * @param methodInfo - Method to print the comments of and compare parameters against.
	 * @param remoteInfo - Remote info to check for session parameters.
	 * @return A function taking a boolean argument which, if true adds the async byps parameter as documentation.
	 */
	public static Consumer<Boolean> printMethod(
		CodePrinter codePrinter,
		MethodInfo methodInfo,
		RemoteInfo remoteInfo
	) {
		CommentPrinter printer = new CommentPrinter(codePrinter, methodInfo.comments);

		return (async) -> printer.printMethod(methodInfo, remoteInfo, async);
	}
	
	/**
	 * Creates a simple {@link CommentPrinter} printer that prints a collection of comment infos
	 *
	 * @param codePrinter - The {@link CodePrinter} to use for printing the comment.
	 * @param commentInfos - List of {@link CommentInfo} objects to print.
	 */
	public static void print(CodePrinter codePrinter, Collection<CommentInfo> commentInfos) {
		new CommentPrinter(codePrinter, commentInfos).print();
	}
	
	/**
	 * Constructor used by the static methods to instantiate an object of the comment printer.
	 *
	 * @param codePrinter
	 * @param commentInfos
	 */
	private CommentPrinter(CodePrinter codePrinter, Collection<CommentInfo> commentInfos) {
		this.printContext = DependencyContainer.get(PrintContext.class);
		this.codePrinter = codePrinter;
		if (commentInfos == null) {
			this.comments = new ArrayList<>();
		} else {
			this.comments = new ArrayList<>(commentInfos);
		}
	}
	
	/**
	 * Prints the comments of the given method optionally adding the async parameter.
	 * Also adds all missing parameters as comments.
	 *
	 * @param methodInfo - Method info to derive missing parameters from.
	 * @param remoteInfo - Remote info to check for session parameters.
	 * @param async - Whether to add the async parameter.
	 */
	public void printMethod(MethodInfo methodInfo, RemoteInfo remoteInfo, boolean async) {
		if (async) {
			this.comments.add(new CommentInfo(
				CommentTypes.PARAMETERS.getKind(),
				"__byps__asyncResult Callback for the return value when using promises is not desired."
			));
		}

		// Add documentation for all parameters that weren't documented to avoid warnings.
		for (MemberInfo memberInfo : methodInfo.requestInfo.members) {
			if (this.comments
				.stream()
				.filter(commentInfo -> commentInfo.kind.equals(CommentTypes.PARAMETERS.getKind()))
				.anyMatch(comment -> comment.text.trim().startsWith(memberInfo.name))) {
				continue;
			}

			this.comments.add(new CommentInfo(
				CommentTypes.PARAMETERS.getKind(),
				memberInfo.name
			));
		}

		this.internalPrint(methodInfo, remoteInfo);
	}
	
	/**
	 * Prints the comments of this comment printer.
	 * Use {@link CommentPrinter#printMethod(MethodInfo, RemoteInfo, boolean) to print method infos.
	 * This will error for methods.
	 */
	public void print() {
		this.internalPrint(null, null);
	}
	
	/**
	 * Wrapper to print multiline comments.
	 *
	 * @param currentLine - Code printer of the line with all prefixes already filled.
	 * @param commentInfo - Comment into to print the text of
	 */
	private void printCommentText(CodePrinter currentLine, CommentInfo commentInfo) {
		if (commentInfo.text.trim().isEmpty()) {
			currentLine.println();
			return;
		}

		String[] parts = commentInfo.text.split("\\r?\\n");
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			CodePrinter printer = currentLine;
			if (i != 0) {
				printer = this.codePrinter.print(" *");
			}
			printer.println(part);
		}
	}
	
	/**
	 * Print any non-special comment.
	 *
	 * @param commentInfo - Comment to print.
	 */
	private void printComment(CommentInfo commentInfo) {
		CodePrinter printer = this.codePrinter.print(" * ").print(commentInfo.kind).print(" ");
		this.printCommentText(printer, commentInfo);
	}
	
	/**
	 * Print the remark of a comment which does not need the comment kind prefix.
	 *
	 * @param commentInfo - Comment to print
	 */
	private void printRemark(CommentInfo commentInfo) {
		CodePrinter printer = this.codePrinter.print(" * ");
		this.printCommentText(printer, commentInfo);
	}
	
	/**
	 * Print the parameter comment if it exists on the method info and is not a session parameter.
	 *
	 * @param commentInfo - Comment to print
	 * @param methodInfo - Methodinfo to check parameters against.
	 * @param remoteInfo - Remote info the check if a parameter is a session parameter.
	 */
	private void printParameter(
		CommentInfo commentInfo,
		MethodInfo methodInfo,
		RemoteInfo remoteInfo
	) {
		String text = commentInfo.text.trim();
		String parameterName = text;
		int spaceIndex = text.indexOf(' ');
		if (spaceIndex >= 0) {
			parameterName = text.substring(0, spaceIndex);
		}

		if (!parameterName.equalsIgnoreCase("__byps__asyncResult")) {
			MemberInfo parameter = null;

			// Query parameter from name in @param comment.
			for (MemberInfo memberInfo : methodInfo.requestInfo.members) {
				if (memberInfo.name.equals(parameterName)) {
					parameter = memberInfo;
					break;
				}
			}

			if (parameter == null) {
				return;
			}

			if (printContext.isSessionParam(remoteInfo, parameter)) {
				return;
			}
		}

		CodePrinter printer = this.codePrinter.print(" * ").print(commentInfo.kind).print(" ");
		this.printCommentText(printer, commentInfo);
	}
	
	/**
	 * Wrapper around the different printers for comments and also inserts blank lines where necessary.
	 *
	 * @param methodInfo - Method info to check parameters of
	 * @param remoteInfo - Remote info to check for session parameters.
	 */
	private void internalPrint(MethodInfo methodInfo, RemoteInfo remoteInfo) {
		var comments = this.comments;

		if (comments.isEmpty()) {
			return;
		}

		CommentTypes.sortComments(comments);

		this.codePrinter.println("/**");
		CommentTypes lastType = null;
		for (CommentInfo info : comments) {
			CommentTypes type = CommentTypes.typeOfKind(info.kind);
			if (lastType != null && lastType.requiresSpaceUntil(type)) {
				this.codePrinter.println(" *");
			}
			lastType = type;
			// Don't print author comments to prevent targeting of specific developers.
			if (type == CommentTypes.AUTHOR) {
				continue;
			}

			if (type == CommentTypes.REMARKS) {
				printRemark(info);
				continue;
			}

			if (type == CommentTypes.PARAMETERS) {
				// Parameters can only be in comments of methods.
				if (methodInfo == null || remoteInfo == null) {
					continue;
				}
				printParameter(info, methodInfo, remoteInfo);
				continue;
			}

			printComment(info);
		}
		this.codePrinter.println(" */");
	}
}
