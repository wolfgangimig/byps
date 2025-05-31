package byps.gen.ts;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BApiDescriptor;
import byps.BVersioning;
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.db.ClassDB;
import byps.gen.js.JSConstValuePrinter;
import byps.gen.js.PrintHelper;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.PrintContextBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main printing class for typescript types.
 */
public class PrintContext extends PrintContextBase {

	private final Logger log = LoggerFactory.getLogger(PrintContext.class);
	public final File destFile;
	private final Cache cache;
	private final GeneratedNames generatedNames;
	private final GenerationFilters generationFilters;

	public PrintContext(
		ClassDB classDB,
		PropertiesTS props,
		Cache cache,
		GeneratedNames generatedNames,
		GenerationFilters generationFilters
	) {
		super(classDB, props);

		this.cache = cache;
		this.generatedNames = generatedNames;
		this.generationFilters = generationFilters;

		destFile = props.getMandatoryPropertyFile(PropertiesTS.DEST_FILE);

		File destDir = destFile.getParentFile();
		//noinspection ResultOfMethodCallIgnored
		destDir.mkdir();

		log.info("Output file for generated JavaScript code: {}", destFile);

		prepareCache();
	}
	
	/**
	 * Writes all required data to the cache for later processing.
	 */
	private void prepareCache() {
		for (SerialInfo serialInfo : classDB.getSerials()) {
			ArrayList<MemberInfo> valueMembers = new ArrayList<>();
			ArrayList<MemberInfo> constantMembers = new ArrayList<>();
			PrintHelper.collectAllMembers(serialInfo, valueMembers, constantMembers);

			cache.addCachedMembers(serialInfo, valueMembers, constantMembers);

			if (serialInfo.isStubType()) {
				cache.addStubClass(serialInfo);
			}

			if (this.isSuppressConstantClassesAndObjects()) {
				continue;
			}

			if (constantMembers.isEmpty()) {
				continue;
			}

			if (!valueMembers.isEmpty()) {
				continue;
			}

			// Enums are shadowed as enums
			// which doesn't change the type definition causing them to
			// effectively not be shadowed.
			if (serialInfo.isEnum) {
				continue;
			}

			cache.addShadowedClass(serialInfo);
		}
	}

	/**
	 * Do not generate classes with constants. The API provides functions to obtain constants as
	 * normal class members.
	 *
	 * @return
	 * @throws GeneratorException
	 */
	public boolean isSuppressConstantClassesAndObjects() throws GeneratorException {
		return props.getOptionalPropertyBoolean(PropertiesTS.SUPPRESS_CONST_CLASSES, false);
	}
	
	/**
	 * Returns a new code printer for the destination file.
	 *
	 * @return
	 * @throws IOException
	 */
	CodePrinter getPrinter() throws IOException {
		FileOutputStream fos = new FileOutputStream(destFile, true);
		return new CodePrinter(fos, false);
	}
	
	/**
	 * Prints the do not modify header for the file.
	 *
	 * @param pr
	 */
	public void printDoNotModify(CodePrinter pr) {
		// JSDoc will reference non-existing variables. I.e. IXServicePortIF instead of BStub_IXServicePortIF.
		pr.println("// noinspection JSValidateJSDoc");
		pr.println("/*");
		pr.println(" * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.");
		pr.println(" */");
		pr.println();

	}
	
	/**
	 * Print utility types used later in the generation.
	 *
	 * @param pr
	 */
	public void printBasics(CodePrinter pr) {

		pr.println(
			"export type BypsAsyncResult<T> = (result: T | null, error: Error | null | undefined) => void");
		pr.println("export type BSet = `${number}.` | number");

		pr.println();

	}
	
	/**
	 * Print an entire namespace with all it's serial infos
	 *
	 * @param codePrinter - Printer to print to
	 * @param namespace - The namespace to print
	 * @param serialInfos - The serial infos of the namespace
	 */
	public void printNamespace(
		CodePrinter codePrinter,
		String namespace,
		ArrayList<SerialInfo> serialInfos
	) {

		codePrinter.println(String.format("declare namespace %s {", namespace));

		codePrinter.beginBlock();

		if (classDB.getApiDescriptor().basePackage.equalsIgnoreCase(namespace)) {
			this.printClient(codePrinter);
			this.printAPIDescriptor(codePrinter);
		}

		Iterator<SerialInfo> iterator = serialInfos.iterator();

		if (iterator.hasNext()) {
			printClassAndOrConstant(codePrinter, iterator.next());

			iterator.forEachRemaining((serialInfo -> {
				codePrinter.println();
				printClassAndOrConstant(codePrinter, serialInfo);
			}));
		}

		codePrinter.endBlock();
		codePrinter.println("}");
		codePrinter.println();

	}
	
	/**
	 * Print the API descriptor constant.
	 *
	 * @param codePrinter - Code printer to print to
	 */
	private void printAPIDescriptor(CodePrinter codePrinter) {

		BApiDescriptor descriptor = this.classDB.getApiDescriptor();

		codePrinter.println(String.format(
			"export const %s: {",
			this.generatedNames.getApiDescriptorClassName()
		));
		codePrinter.beginBlock();

		codePrinter.println("/**");
		codePrinter
			.print(" * API serialisation version: ")
			.print(BVersioning.longToString(descriptor.version))
			.println();
		codePrinter.println(" */");
		codePrinter.println(String.format(
			"VERSION: \"%s\",",
			BVersioning.longToString(descriptor.version)
		));
		codePrinter.println();
		codePrinter.println("/**");
		codePrinter.println(" * Internal used API Descriptor.");
		codePrinter.println("*/");
		codePrinter.println("instance(): byps.BApiDescriptor");

		codePrinter.endBlock();
		codePrinter.println("}");

	}
	
	/**
	 * Print the byps client class.
	 *
	 * @param codePrinter - Code printer to print to
	 */
	private void printClient(CodePrinter codePrinter) {
		codePrinter.println(String.format(
			"export function createClient_%s(transportFactory: byps.BTransportFactory): %s",
			this.classDB.getApiDescriptor().name,
			this.apiPack + "." + this.generatedNames.getClientClassName()
		));

		codePrinter.println();

		codePrinter.println(String.format(
			"export class %s extends byps.BClient {",
			this.generatedNames.getClientClassName()
		));
		codePrinter.beginBlock();
		ArrayList<MemberInfo> infos = new ArrayList<>();
		for (RemoteInfo remoteInfo : classDB.getRemotes()) {
			String varName = generatedNames.getRemoteVariableName(remoteInfo);
			MemberInfo memberInfo = new MemberInfo(
				varName,
				remoteInfo.comments,
				remoteInfo,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				remoteInfo.since,
				""
			);
			infos.add(memberInfo);
		}
		printClassMembers(codePrinter, infos);
		codePrinter.println();
		codePrinter.println("constructor(");
		codePrinter.beginBlock();
		codePrinter.println("transportFactory: byps.BTransportFactory");
		codePrinter.endBlock();
		codePrinter.println(")");
		codePrinter.endBlock();
		codePrinter.println("}");
	}
	
	/**
	 * Print the value and constant members of a class type
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type to print
	 */
	private void printClassAndOrConstant(CodePrinter codePrinter, SerialInfo serialInfo) {

		Collection<MemberInfo> constantMembers = this.cache.getConstantMembers(serialInfo);
		Collection<MemberInfo> valueMembers = this.cache.getValueMembers(serialInfo);

		// When no constants have to be printed, just print the class as usual.
		if (this.isSuppressConstantClassesAndObjects() || constantMembers.isEmpty()) {
			this.printClass(codePrinter, serialInfo, valueMembers, constantMembers);
			return;
		}

		// When no value members exist the class is shadowed by the constant object.
		// In that case the class needs not be printed.
		if (!valueMembers.isEmpty()) {
			this.printClass(codePrinter, serialInfo, valueMembers, constantMembers);
		}

		this.printConstant(codePrinter, serialInfo, valueMembers, constantMembers);
	}
	
	/**
	 * Print the constant members of a class type
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type to print constants of
	 * @param valueMembers - Value members to check for the suffix
	 * @param constantMembers - Constant members to print
	 */
	private void printConstant(
		CodePrinter codePrinter,
		SerialInfo serialInfo,
		Collection<MemberInfo> valueMembers,
		Collection<MemberInfo> constantMembers
	) {
		if (serialInfo.isEnum) {
			this.printConstantEnum(codePrinter, serialInfo);
			return;
		}

		String constantName = serialInfo.name;
		if (!valueMembers.isEmpty()) {
			constantName += "C";
		}

		String constantFullQualifiedName = serialInfo.pack + "." + constantName;

		CommentPrinter.print(codePrinter, serialInfo.comments);
		codePrinter.println(String.format(
			"export const %s: %s_Type;",
			constantName,
			constantFullQualifiedName
		));

		codePrinter.println(String.format(String.format("export class %s_Type {", constantName)));
		codePrinter.beginBlock();

		JSConstValuePrinter printer = new JSConstValuePrinter(this);


		for (MemberInfo memberInfo : constantMembers) {
			String value = memberInfo.value;
			if (value == null) {
				continue;
			}

			if (value.startsWith("\"")) {
				value = value.substring(1, value.length() - 1);
			}

			CommentPrinter.print(codePrinter, memberInfo.comments);

			if (memberInfo.type.isPrimitiveType()) {
				// Enhance primitive type hinting by explicitly stating the primitive value as type.
				codePrinter.println(String.format(
					"public %s: %s;",
					memberInfo.name,
					printer.printConstValue(memberInfo.type, value)
				));
			} else {
				codePrinter.println(String.format(
					"public %s: %s;",
					memberInfo.name,
					JSType.build(memberInfo.type)
				));
			}
		}

		codePrinter.endBlock();
		codePrinter.println("}");
	}
	
	/**
	 * Print constant as enum
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type to print
	 */
	private void printConstantEnum(CodePrinter codePrinter, SerialInfo serialInfo) {
		codePrinter.println(String.format("export enum %s {", serialInfo.name));
		codePrinter.beginBlock();

		ArrayList<MemberInfo> membersByOrdinal = new ArrayList<>(serialInfo.members);
		membersByOrdinal.sort(Comparator.comparingInt(m -> Integer.parseInt(m.value)));

		Iterator<MemberInfo> iterator = membersByOrdinal.iterator();

		while (iterator.hasNext()) {
			MemberInfo memberInfo = iterator.next();

			CommentPrinter.print(codePrinter, memberInfo.comments);
			CodePrinter expandedPrinter = codePrinter
				.print(memberInfo.name)
				.print(" = ")
				.print(memberInfo.value);
			if (iterator.hasNext()) {
				expandedPrinter.print(",");
			}
			expandedPrinter.println();

		}

		codePrinter.endBlock();
		codePrinter.println("}");
		codePrinter.println();
	}
	
	/**
	 * Print an entire class with all members
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type to print
	 * @param valueMembers - Value members to print
	 * @param constantMembers - Constant members to print
	 */
	private void printClass(
		CodePrinter codePrinter,
		SerialInfo serialInfo,
		Collection<MemberInfo> valueMembers,
		Collection<MemberInfo> constantMembers
	) {
		CommentPrinter.print(codePrinter, serialInfo.comments);
		if (serialInfo.isStubType()) {
			printStubClass(codePrinter, serialInfo);
			return;
		}

		codePrinter.println(String.format("export class %s {", serialInfo.name));

		codePrinter.beginBlock();

		Collection<MemberInfo> constantsToPrint = this.generationFilters.uniqueConstants(constantMembers);

		if (!constantsToPrint.isEmpty()) {
			codePrinter.println();
			this.printClassMembers(codePrinter, constantsToPrint);
		}

		codePrinter.println();
		printClassAPI(codePrinter, serialInfo, valueMembers, constantMembers);

		codePrinter.endBlock();

		codePrinter.println("}");

	}
	
	/**
	 * Print all members of a class type
	 *
	 * @param codePrinter - Code printer to print to
	 * @param members - The members to print
	 */
	private void printClassMembers(CodePrinter codePrinter, Collection<MemberInfo> members) {
		boolean first = true;
		for (MemberInfo member : members) {
			if (!first && member.comments != null && !member.comments.isEmpty()) {
				codePrinter.println();
			}
			first = false;

			CommentPrinter.print(codePrinter, member.comments);
			codePrinter.println(String.format(
				"public %s: %s;",
				member.name,
				JSType.build(member.type)
			));
		}
	}
	
	/**
	 * Wrapper for all the printing of the api for an API class
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type to print
	 * @param valueMembers - Value members of the class
	 * @param constantMembers - Constant members of the class
	 */
	private void printClassAPI(
		CodePrinter codePrinter,
		SerialInfo serialInfo,
		Collection<MemberInfo> valueMembers,
		Collection<MemberInfo> constantMembers
	) {

		valueMembers.removeIf(PrintHelper :: isIgnoreMember);

		if (!serialInfo.isInline) {
			codePrinter.println(String.format("public _typeId: %s;", serialInfo.typeId));
		}

		Set<MemberInfo> newClassMembers = valueMembers
			.stream()
			.filter(memberInfo -> constantMembers
				.stream()
				.noneMatch(constantInfo -> constantInfo.name.equals(memberInfo.name)))
			.collect(Collectors.toSet());

		if (!serialInfo.isInline && !newClassMembers.isEmpty()) {
			codePrinter.println();
		}

		this.printClassMembers(codePrinter, newClassMembers);

		if (!serialInfo.isInline || !newClassMembers.isEmpty()) {
			codePrinter.println();
		}

		if (newClassMembers.isEmpty()) {
			codePrinter.println("constructor()");
			return;
		}

		codePrinter.println("constructor(");
		codePrinter.beginBlock();

		Iterator<MemberInfo> iterator = valueMembers.iterator();

		while (iterator.hasNext()) {
			MemberInfo memberInfo = iterator.next();
			CodePrinter printer = codePrinter.print(String.format(
				"%s: %s = %s",
				memberInfo.name,
				JSType.build(memberInfo.type),
				memberInfo.value
			));
			if (iterator.hasNext()) {
				printer.print(",");
			}
			printer.println();
		}

		codePrinter.endBlock();
		codePrinter.println(")");
	}
	
	/**
	 * Returns the remote info of a given serial info
	 *
	 * @param info - The serial info to look up
	 * @return
	 */
	private RemoteInfo findRemoteOf(SerialInfo info) {

		String compareAgainst = info.name;
		if (compareAgainst.startsWith(generatedNames.STUB_PREFIX)) {
			compareAgainst = compareAgainst.substring(generatedNames.STUB_PREFIX.length());
		}

		for (RemoteInfo remoteInfo : classDB.getRemotes()) {
			if (!remoteInfo.pack.equals(info.pack)) {
				continue;
			}

			if (remoteInfo.name.equals(compareAgainst)) {
				return remoteInfo;
			}
		}

		return null;
	}
	
	/**
	 * Wrapper function for all that is inside stub classes.
	 *
	 * @param codePrinter - Code printer to print to
	 * @param serialInfo - Class type of the stub class
	 */
	private void printStubClass(CodePrinter codePrinter, SerialInfo serialInfo) {
		codePrinter.println(String.format("export class %s {", serialInfo.name));
		codePrinter.beginBlock();

		RemoteInfo remote = findRemoteOf(serialInfo);

		assert remote != null;

		HashMap<String, RemoteInfo> remotes = new HashMap<>();
		collectAllRemotesForStubOrSkeleton(remote, remotes);

		boolean first = true;

		for (RemoteInfo remoteInfo : remotes.values()) {
			for (MethodInfo methodInfo : remoteInfo.methods) {
				if (!first) {
					codePrinter.println();
				}
				first = false;
				printDeclaredMethod(codePrinter, remoteInfo, methodInfo);
			}
		}

		codePrinter.endBlock();
		codePrinter.println("}");
	}
	
	/**
	 * Print parameters and documentation for a method
	 *
	 * @param codePrinter - Code printer to print to
	 * @param remoteInfo - Remote info of the method to remove session parameters
	 * @param methodInfo - Method info to acquire parameters.
	 */
	private void printDeclaredMethod(
		CodePrinter codePrinter,
		RemoteInfo remoteInfo,
		MethodInfo methodInfo
	) {

		Consumer<Boolean> printer = CommentPrinter.printMethod(
			codePrinter,
			methodInfo,
			remoteInfo
		);

		String returnType = JSType.build(methodInfo.resultInfo.members.get(0).type);

		ArrayList<String> parameters = new ArrayList<>();

		for (MemberInfo parameter : methodInfo.requestInfo.members) {
			if (isSessionParam(remoteInfo, parameter)) {
				continue;
			}

			String parameterType = JSType.build(parameter.type);

			parameters.add(String.format("%s: %s", parameter.name, parameterType));
		}

		printer.accept(false);

		codePrinter.println(String.format(
			"%s(%s): Promise<%s>",
			methodInfo.name,
			String.join(", ", parameters),
			returnType
		));

		printer.accept(true);
		parameters.add(String.format("__byps__asyncResult: BypsAsyncResult<%s>", returnType));

		codePrinter.println(String.format(
			"%s(%s): void",
			methodInfo.name,
			String.join(", ", parameters)
		));
	}
}
