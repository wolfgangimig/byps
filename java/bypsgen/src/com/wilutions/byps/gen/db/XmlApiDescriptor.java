package com.wilutions.byps.gen.db;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BBinaryModel;

public class XmlApiDescriptor {
	public String name;
	public String apiPack;
	public int version;
	public String bmodel;
	public boolean uniqueObjects;
	
	public static final XmlApiDescriptor fromValue(BApiDescriptor apiDesc) {
		XmlApiDescriptor x = new XmlApiDescriptor();
		x.name = apiDesc.name;
		x.apiPack = apiDesc.basePackage;
		x.version = apiDesc.version;
		x.bmodel = apiDesc.bmodel.toString();
		x.uniqueObjects = apiDesc.uniqueObjects;
		return x;
	}
	
	public BApiDescriptor toValue() {
		return new BApiDescriptor(name, apiPack, BBinaryModel.fromString(bmodel), version, uniqueObjects, "", null);
	}
}
