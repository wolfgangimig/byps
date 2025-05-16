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

public class CommentPrinter {

	private final PrintContext printContext;
	private final CodePrinter codePrinter;
	private final List<CommentInfo> comments;

	public static Consumer<Boolean> printMethod(
		CodePrinter codePrinter,
		MethodInfo methodInfo,
		RemoteInfo remoteInfo
	) {
		CommentPrinter printer = new CommentPrinter(codePrinter, methodInfo.comments);

		return (async) -> printer.printMethod(methodInfo, remoteInfo, async);
	}

	public static void print(CodePrinter codePrinter, Collection<CommentInfo> commentInfos) {
		new CommentPrinter(codePrinter, commentInfos).print();
	}

	public CommentPrinter(CodePrinter codePrinter, Collection<CommentInfo> commentInfos) {
		this.printContext = DependencyContainer.get(PrintContext.class);
		this.codePrinter = codePrinter;
		if (commentInfos == null) {
			this.comments = new ArrayList<>();
		} else {
			this.comments = new ArrayList<>(commentInfos);
		}
	}

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

	public void print() {
		this.internalPrint(null, null);
	}

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

	private void printComment(CommentInfo commentInfo) {
		CodePrinter printer = this.codePrinter.print(" * ").print(commentInfo.kind).print(" ");
		this.printCommentText(printer, commentInfo);
	}

	private void printRemark(CommentInfo commentInfo) {
		CodePrinter printer = this.codePrinter.print(" * ");
		this.printCommentText(printer, commentInfo);
	}

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
