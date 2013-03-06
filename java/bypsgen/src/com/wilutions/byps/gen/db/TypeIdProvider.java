package com.wilutions.byps.gen.db;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.TypeInfo;

public interface TypeIdProvider {
	public long getTypeIdForClass(TypeInfo tinfo) throws GeneratorException;
}
