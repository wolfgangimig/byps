package byps.gen.ts;

import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility functions for filtering data that needs not be processed.
 */
public class GenerationFilters {

	public GenerationFilters() {}
	
	/**
	 * Returns whether the given serial info should be printed.
	 *
	 * @param minTypeIdUser - Minimum type id that should be printed to avoid library class types.
	 * @param serialInfo - Info to check.
	 * @return
	 */
	@SuppressWarnings("RedundantIfStatement")
	public boolean isPrintAllowed(int minTypeIdUser, SerialInfo serialInfo) {

		if (serialInfo.isCollectionType()) {
			// No API class for List<>...
			return false;
		}
		if (serialInfo.isArrayType()) {
			// No API class for int[]...
			return false;
		}
		if (serialInfo.typeId < minTypeIdUser){
			// No API class for RemoteException ...
			return false;
		}
		if (serialInfo.isResultClass() || serialInfo.isRequestClass()) {
			// JSON API does not need a class for results or requests
			return false;
		}
		return true;
	}
	
	/**
	 * Removes transient and duplicate constants from processing.
	 *
	 * @param constants - Constants of a class
	 * @return
	 */
	public Collection<MemberInfo> uniqueConstants(Collection<MemberInfo> constants) {
		Collection<MemberInfo> constantsToPrint = new ArrayList<>();
		Set<String> addedNames = new HashSet<>();

		for (MemberInfo memberInfo : constants) {
			if (memberInfo.isTransient) {
				continue;
			}

			if (addedNames.contains(memberInfo.name)) {
				continue;
			}

			addedNames.add(memberInfo.name);
			constantsToPrint.add(memberInfo);
		}

		return constantsToPrint;
	}

}
