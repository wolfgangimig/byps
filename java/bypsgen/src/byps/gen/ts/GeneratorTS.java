package byps.gen.ts;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.SerialInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of the typescript type definition generation.
 */
public class GeneratorTS implements Generator {

	private final Logger log = LoggerFactory.getLogger(GeneratorTS.class);

	public GeneratorTS() {
	}

	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		log.debug("build(");

		DependencyContainer.registerClass(PrintContext.class);
		DependencyContainer.registerClass(Cache.class);
		DependencyContainer.registerClass(GeneratedNames.class);
		DependencyContainer.registerClass(GenerationFilters.class);
		DependencyContainer.addInstance(props);
		DependencyContainer.addInstance(classDB);

		PrintContext printContext = DependencyContainer.get(PrintContext.class);
		GenerationFilters generationFilters = DependencyContainer.get(GenerationFilters.class);

		if (!printContext.destFile.delete()) {
			throw new IOException("Couldn't delete destFile");
		}

		CodePrinter codePrinter = printContext.getPrinter();

		printContext.printDoNotModify(codePrinter);
		printContext.printByps(codePrinter);

		HashMap<String, ArrayList<SerialInfo>> map = new HashMap<>();

		for (SerialInfo serial : classDB.getSerials()) {
			if (serial.pack.isEmpty() || serial.pack.startsWith("java")) {
				continue;
			}

			if (!generationFilters.isPrintAllowed(
				printContext.classDB
					.getRegistry()
					.getMinTypeIdUser(), serial
			)) {
				continue;
			}

			map.computeIfAbsent(serial.pack, (ignored) -> new ArrayList<>()).add(serial);
		}

		// Always add the package of the ApiDescriptor whose functions will be generated in
		// the respective printNamespace.
		map.computeIfAbsent(classDB.getApiDescriptor().basePackage, (ignored) -> new ArrayList<>());

		for (Map.Entry<String, ArrayList<SerialInfo>> entry : map.entrySet()) {
			String packageName = entry.getKey();
			ArrayList<SerialInfo> serials = entry.getValue();
			printContext.printNamespace(codePrinter, packageName, serials);
		}

		codePrinter.close();

		log.debug(")build");
	}

}
