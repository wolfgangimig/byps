package com.wilutions.byps.gen.db;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.TypeInfo;

public interface ConstFieldReader {
	public long getSerialVersionUID(TypeInfo tinfo) throws GeneratorException;
	public Object getValue(TypeInfo tinfo, String fieldName) throws GeneratorException;
}
