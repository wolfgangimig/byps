package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import byps.gen.db.ClassDB;



public interface Generator {
	
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException ;

}
