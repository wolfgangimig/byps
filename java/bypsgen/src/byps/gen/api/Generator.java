package byps.gen.api;

import java.io.IOException;

import byps.gen.db.ClassDB;



public interface Generator {
	
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException ;

}
