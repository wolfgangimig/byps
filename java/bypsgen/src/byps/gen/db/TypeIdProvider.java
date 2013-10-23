package byps.gen.db;

import byps.gen.api.GeneratorException;
import byps.gen.api.TypeInfo;

public interface TypeIdProvider {
	public long getTypeIdForClass(TypeInfo tinfo) throws GeneratorException;
}
