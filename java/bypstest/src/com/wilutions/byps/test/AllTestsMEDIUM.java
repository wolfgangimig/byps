package com.wilutions.byps.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.wilutions.byps.BBinaryModel;


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
	TestSerializeException.class,
	TestSerializeDifferentVersions.class,
	TestRemotePrimitiveTypes.class,
	TestRemoteArrays.class,
	TestRemoteMapTypes.class,
	TestRemoteException.class,
	TestRemoteEnums.class,
	TestRemoteSetTypes.class,
	TestRemoteStreams.class,
	TestRemoteServerR.class,
	TestRemoteDifferentVersions.class,
	})
public class AllTestsMEDIUM {
	
	@BeforeClass
	public static void setBinaryModel() {
		TestUtils.bmodel = BBinaryModel.MEDIUM;
	}
	
}
