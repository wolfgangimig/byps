package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import byps.BProtocolJson;
import byps.http.HWireClient;


@RunWith(Suite.class)
@SuiteClasses({ 
  TestBAsyncContentStream.class,
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
	TestRemoteProcessingEx.class,
  TestSerializeInlineInstances.class,
	TestSerializeDifferentVersions.class,
	TestCompatibleApi.class,
	TestRemotePrimitiveTypes.class,
	TestRemoteArrays.class,
	TestRemoteMapTypes.class,
	TestRemoteEnums.class,
	TestRemoteSetTypes.class,
	TestRemoteStreams.class,
	TestRemoteServerR.class,
	TestRemoteDifferentVersions.class,
	TestRemoteWithAuthentication.class
	})
public class AllTestsJSON {
	
	@BeforeClass
	public static void setProtocol() {
		TestUtils.protocol = BProtocolJson.BINARY_MODEL;
	}
	
	
}
