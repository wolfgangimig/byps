package byps.gen.db;

import byps.gen.api.GeneratorException;
import byps.gen.api.TypeInfo;

public interface ConstFieldReader {
	public long getSerialVersionUID(TypeInfo tinfo) throws GeneratorException;
	public Object getValue(TypeInfo tinfo, String fieldName) throws GeneratorException;
}
