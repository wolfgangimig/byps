package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import com.wilutions.byps.gen.api.Generator;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.db.ClassDB;

public class GeneratorCpp implements Generator {
	
	public GeneratorCpp() {
	}
	
	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		
		pctxt = new PrintContext(classDB, props);
		printSerials(classDB.getSerials());
		pctxt.close();
	}
	
	protected void printSerials(Iterable<SerialInfo> serials) throws IOException {
		for (SerialInfo serial : serials) {
			printSerial(serial);
		}
	}
	
	protected void printSerial(SerialInfo serInfo) throws IOException {
		GenApiClass.generate(pctxt, serInfo);
		GenSerClass.generate(pctxt, serInfo);
	}
	
	private PrintContext pctxt;
}
