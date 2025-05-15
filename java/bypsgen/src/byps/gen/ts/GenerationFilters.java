package byps.gen.ts;

import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GenerationFilters {

	public GenerationFilters() {}

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
