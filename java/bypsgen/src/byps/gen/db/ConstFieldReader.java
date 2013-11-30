package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.GeneratorException;
import byps.gen.api.TypeInfo;

public interface ConstFieldReader {
	public long getSerialVersionUID(TypeInfo tinfo) throws GeneratorException;
	public Object getValue(TypeInfo tinfo, String fieldName) throws GeneratorException;
}
