package byps.gen.ts;

import byps.BRegistry;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;

import java.util.Optional;

public class JSType {

	private final TypeInfo typeInfo;
	private final Cache cache;
	private final GeneratedNames generatedNames;

	public static String build(TypeInfo typeInfo) {
		return new JSType(typeInfo).buildType();
	}

	private JSType(TypeInfo typeInfo) {
		this.cache = DependencyContainer.get(Cache.class);
		this.generatedNames = DependencyContainer.get(GeneratedNames.class);
		this.typeInfo = typeInfo;
	}

	private Optional<String> buildPrimitiveType() {
		if (!typeInfo.isPrimitiveType()) {
			return Optional.empty();
		}

		String stringType;
		switch (typeInfo.typeId) {
			case BRegistry.TYPEID_BOOL:
				stringType = "boolean";
				break;
			case BRegistry.TYPEID_WCHAR:
			case BRegistry.TYPEID_STRING:
				stringType = "string";
				break;
			case BRegistry.TYPEID_INT8:
			case BRegistry.TYPEID_INT16:
			case BRegistry.TYPEID_INT32:
			case BRegistry.TYPEID_FLOAT:
			case BRegistry.TYPEID_DOUBLE:
				stringType = "number";
				break;
			case BRegistry.TYPEID_INT64:
				stringType = "BSet";
				break;
			default:
				stringType = null;
		}

		return Optional.ofNullable(stringType);
	}

	private Optional<String> buildArrayType() {
		if (!typeInfo.isArrayType()) {
			return Optional.empty();
		}

		if (this.typeInfo.isPrimitiveType()) {
			ClassDB db = new ClassDB(null);
			TypeInfo nonArrayType = db.getTypeInfo(this.generatedNames.fullQualifiedName(this.typeInfo));
			String nonArrayJSType = JSType.build(nonArrayType);

			return Optional.of(String.format("Array<%s>", nonArrayJSType));
		} else {
			return Optional.of(String.format(
				"Array<%s>",
				this.generatedNames.fullQualifiedName(this.typeInfo)
			));
		}
	}

	private Optional<String> buildListType() {
		if (!typeInfo.isListType() && !typeInfo.isSetType()) {
			return Optional.empty();
		}

		if (typeInfo.typeArgs.isEmpty()) {
			return Optional.of("unknown[]");
		}

		String baseType = JSType.build(typeInfo.typeArgs.get(0));

		return Optional.of(String.format("Array<%s>", baseType));
	}

	private Optional<String> buildMapType() {
		if (!typeInfo.isMapType()) {
			return Optional.empty();
		}

		if (typeInfo.typeArgs.isEmpty()) {
			return Optional.of("Record<unknown, unknown>");
		}

		TypeInfo keyTypeInfo = typeInfo.typeArgs.get(0);

		String keyType = JSType.build(keyTypeInfo);
		String format = keyTypeInfo.isPrimitiveType() ? "Record<%s, %s>" : "Map<%s, %s>";

		if (typeInfo.typeArgs.size() == 1) {
			return Optional.of(String.format(format, keyType, "unknown"));
		}

		String valueType = JSType.build(typeInfo.typeArgs.get(1));

		return Optional.of(String.format(format, keyType, valueType));
	}

	private Optional<String> buildVoidType() {
		if (!typeInfo.isVoidType()) {
			return Optional.empty();
		}

		return Optional.of("void");
	}

	private Optional<String> buildDateType() {

		if (!this.typeInfo.isDateType()) {
			return Optional.empty();
		}

		return Optional.of("Date");
	}

	private Optional<String> buildObjectType() {
		if (this.typeInfo.isAnyType()) {
			return Optional.of("any");
		}

		if (this.typeInfo.isExceptionType()) {
			return Optional.of("Error");
		}

		if (typeInfo.pack.isEmpty() || typeInfo.name.isEmpty()) {
			return Optional.empty();
		}

		String name = typeInfo.pack + "." + typeInfo.name;

		if (!generatedNames.isStubName(typeInfo) && cache.isStubClass(typeInfo)) {
			return Optional.of(generatedNames.getStubName(typeInfo));
		}

		if (cache.isShadowedClass(typeInfo.pack, typeInfo.name)) {
			return Optional.of("typeof " + name);
		}

		return Optional.of(name);
	}

	private boolean isUnsupportedType() {
		return this.typeInfo.isStreamType();
	}

	public String buildType() {
		if (this.isUnsupportedType()) {
			return "unknown";
		}

		return Optional
			.<String>empty()
			.or(this :: buildArrayType)
			.or(this :: buildPrimitiveType)
			.or(this :: buildMapType)
			.or(this :: buildListType)
			.or(this :: buildVoidType)
			.or(this :: buildDateType)
			.or(this :: buildObjectType)
			.orElse("unknown");
	}

}
