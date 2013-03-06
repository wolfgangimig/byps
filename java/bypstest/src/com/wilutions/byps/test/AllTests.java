package com.wilutions.byps.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestSerializePrimitiveTypes.class, 
	TestSerializeArrays1dim.class, TestSerializeArrays4dim.class })
public class AllTests {

}
