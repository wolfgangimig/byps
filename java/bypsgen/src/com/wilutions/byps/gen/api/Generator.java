package com.wilutions.byps.gen.api;

import java.io.IOException;

import com.wilutions.byps.gen.db.ClassDB;



public interface Generator {
	
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException ;

}
