package com.wilutions.byps.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.wilutions.byps.BProtocolJson;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestSerializePrimitiveTypes.class, 
	TestSerializeArrays1dim.class, 
	TestSerializeArrays4dim.class,
	TestSerializerList.class,
	TestSerializerMap.class,
	TestSerializerSet.class,
	TestSerializerClassHierarchy.class,
	TestSerializeReferences.class,
	TestSerializeEnum.class,
	TestSerializePrivateMembers.class,
	TestSerializeInlineInstances.class,
	TestSerializeStream.class,
	TestSerializeDifferentVersions.class,
	TestRemotePrimitiveTypes.class,
	TestRemoteArrays.class,
	TestRemoteMapTypes.class,
	TestRemoteEnums.class,
	TestRemoteSetTypes.class,
	TestRemoteStreams.class,
	TestRemoteServerR.class,
	TestRemoteDifferentVersions.class,
	})
public class AllTestsJSON {
	
	@BeforeClass
	public static void setProtocol() {
		TestUtils.protocol = BProtocolJson.BINARY_MODEL;
	}
	
	
}
