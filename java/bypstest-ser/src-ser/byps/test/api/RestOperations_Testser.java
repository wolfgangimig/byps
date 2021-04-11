﻿package byps.test.api;
// GENERATED code, do not modify
import java.util.*;
import byps.*;
import byps.rest.*;

public class RestOperations_Testser extends RestOperations {
	public static RestOperations instance() {
		return instance;
	}
	private static final RestOperations instance = new RestOperations_Testser();
	private RestOperations_Testser() {
		add("post", "/BioFruitService/certify", new Operation("BioFruitService_certify"));
		add("post", "/BioLemonService/useParing", new Operation("BioLemonService_useParing"));
		add("post", "/ClientIF/getStreams", new Operation("ClientIF_getStreams"));
		add("post", "/ClientIF/incrementInt", new Operation("ClientIF_incrementInt"));
		add("post", "/ClientIF/putStreams", new Operation("ClientIF_putStreams"));
		add("post", "/ClientIF/sendChat", new Operation("ClientIF_sendChat"));
		add("post", "/EvolveIF/getClient", new Operation("EvolveIF_getClient"));
		add("post", "/EvolveIF/getEvolve", new Operation("EvolveIF_getEvolve"));
		add("post", "/EvolveIF/sendEvolveToClient", new Operation("EvolveIF_sendEvolveToClient"));
		add("post", "/EvolveIF/setClient", new Operation("EvolveIF_setClient"));
		add("post", "/EvolveIF/setEvolve", new Operation("EvolveIF_setEvolve"));
		add("post", "/FruitService/squeeze", new Operation("FruitService_squeeze"));
		add("post", "/LemonService/pick", new Operation("LemonService_pick"));
		add("post", "/PlantService/grow", new Operation("PlantService_grow"));
		add("get", "/RemoteArrayTypes1dim/boolpath", new Operation("RemoteArrayTypes1dim_getBool"));
		add("post", "/RemoteArrayTypes1dim/getByte", new Operation("RemoteArrayTypes1dim_getByte"));
		add("post", "/RemoteArrayTypes1dim/getChar", new Operation("RemoteArrayTypes1dim_getChar"));
		add("post", "/RemoteArrayTypes1dim/getDate", new Operation("RemoteArrayTypes1dim_getDate"));
		add("post", "/RemoteArrayTypes1dim/getDouble", new Operation("RemoteArrayTypes1dim_getDouble"));
		add("post", "/RemoteArrayTypes1dim/getFloat", new Operation("RemoteArrayTypes1dim_getFloat"));
		add("post", "/RemoteArrayTypes1dim/getInt", new Operation("RemoteArrayTypes1dim_getInt"));
		add("post", "/RemoteArrayTypes1dim/getLong", new Operation("RemoteArrayTypes1dim_getLong"));
		add("post", "/RemoteArrayTypes1dim/getObject", new Operation("RemoteArrayTypes1dim_getObject"));
		add("post", "/RemoteArrayTypes1dim/getPrimitiveTypes", new Operation("RemoteArrayTypes1dim_getPrimitiveTypes"));
		add("post", "/RemoteArrayTypes1dim/getShort", new Operation("RemoteArrayTypes1dim_getShort"));
		add("post", "/RemoteArrayTypes1dim/getString", new Operation("RemoteArrayTypes1dim_getString"));
		add("post", "/RemoteArrayTypes1dim/setBool", new Operation("RemoteArrayTypes1dim_setBool"));
		add("post", "/RemoteArrayTypes1dim/setByte", new Operation("RemoteArrayTypes1dim_setByte"));
		add("post", "/RemoteArrayTypes1dim/setChar", new Operation("RemoteArrayTypes1dim_setChar"));
		add("post", "/RemoteArrayTypes1dim/setDate", new Operation("RemoteArrayTypes1dim_setDate"));
		add("post", "/RemoteArrayTypes1dim/setDouble", new Operation("RemoteArrayTypes1dim_setDouble"));
		add("post", "/RemoteArrayTypes1dim/setFloat", new Operation("RemoteArrayTypes1dim_setFloat"));
		add("post", "/RemoteArrayTypes1dim/setInt", new Operation("RemoteArrayTypes1dim_setInt"));
		add("post", "/RemoteArrayTypes1dim/setLong", new Operation("RemoteArrayTypes1dim_setLong"));
		add("post", "/RemoteArrayTypes1dim/setObject", new Operation("RemoteArrayTypes1dim_setObject"));
		add("post", "/RemoteArrayTypes1dim/setPrimitiveTypes", new Operation("RemoteArrayTypes1dim_setPrimitiveTypes"));
		add("post", "/RemoteArrayTypes1dim/setShort", new Operation("RemoteArrayTypes1dim_setShort"));
		add("post", "/RemoteArrayTypes1dim/setString", new Operation("RemoteArrayTypes1dim_setString"));
		add("post", "/RemoteArrayTypes23/sendArraysClass", new Operation("RemoteArrayTypes23_sendArraysClass"));
		add("post", "/RemoteArrayTypes23/sendArraysInline", new Operation("RemoteArrayTypes23_sendArraysInline"));
		add("post", "/RemoteArrayTypes23/sendArraysInt", new Operation("RemoteArrayTypes23_sendArraysInt"));
		add("post", "/RemoteArrayTypes23/sendArraysObject", new Operation("RemoteArrayTypes23_sendArraysObject"));
		add("post", "/RemoteArrayTypes23/sendArraysString", new Operation("RemoteArrayTypes23_sendArraysString"));
		add("post", "/RemoteArrayTypes4dim/getBool", new Operation("RemoteArrayTypes4dim_getBool"));
		add("post", "/RemoteArrayTypes4dim/getByte", new Operation("RemoteArrayTypes4dim_getByte"));
		add("post", "/RemoteArrayTypes4dim/getChar", new Operation("RemoteArrayTypes4dim_getChar"));
		add("post", "/RemoteArrayTypes4dim/getDate", new Operation("RemoteArrayTypes4dim_getDate"));
		add("post", "/RemoteArrayTypes4dim/getDouble", new Operation("RemoteArrayTypes4dim_getDouble"));
		add("post", "/RemoteArrayTypes4dim/getFloat", new Operation("RemoteArrayTypes4dim_getFloat"));
		add("post", "/RemoteArrayTypes4dim/getInt", new Operation("RemoteArrayTypes4dim_getInt"));
		add("post", "/RemoteArrayTypes4dim/getLong", new Operation("RemoteArrayTypes4dim_getLong"));
		add("post", "/RemoteArrayTypes4dim/getObject", new Operation("RemoteArrayTypes4dim_getObject"));
		add("post", "/RemoteArrayTypes4dim/getPrimitiveTypes", new Operation("RemoteArrayTypes4dim_getPrimitiveTypes"));
		add("post", "/RemoteArrayTypes4dim/getShort", new Operation("RemoteArrayTypes4dim_getShort"));
		add("post", "/RemoteArrayTypes4dim/getString", new Operation("RemoteArrayTypes4dim_getString"));
		add("post", "/RemoteArrayTypes4dim/setBool", new Operation("RemoteArrayTypes4dim_setBool"));
		add("post", "/RemoteArrayTypes4dim/setByte", new Operation("RemoteArrayTypes4dim_setByte"));
		add("post", "/RemoteArrayTypes4dim/setChar", new Operation("RemoteArrayTypes4dim_setChar"));
		add("post", "/RemoteArrayTypes4dim/setDate", new Operation("RemoteArrayTypes4dim_setDate"));
		add("post", "/RemoteArrayTypes4dim/setDouble", new Operation("RemoteArrayTypes4dim_setDouble"));
		add("post", "/RemoteArrayTypes4dim/setFloat", new Operation("RemoteArrayTypes4dim_setFloat"));
		add("post", "/RemoteArrayTypes4dim/setInt", new Operation("RemoteArrayTypes4dim_setInt"));
		add("post", "/RemoteArrayTypes4dim/setLong", new Operation("RemoteArrayTypes4dim_setLong"));
		add("post", "/RemoteArrayTypes4dim/setObject", new Operation("RemoteArrayTypes4dim_setObject"));
		add("post", "/RemoteArrayTypes4dim/setPrimitiveTypes", new Operation("RemoteArrayTypes4dim_setPrimitiveTypes"));
		add("post", "/RemoteArrayTypes4dim/setShort", new Operation("RemoteArrayTypes4dim_setShort"));
		add("post", "/RemoteArrayTypes4dim/setString", new Operation("RemoteArrayTypes4dim_setString"));
		add("post", "/RemoteConstants/compare_AllTypesC", new Operation("RemoteConstants_compare_AllTypesC"));
		add("post", "/RemoteConstants/compare_HebrewC", new Operation("RemoteConstants_compare_HebrewC"));
		add("post", "/RemoteEnums/getPlanet", new Operation("RemoteEnums_getPlanet"));
		add("post", "/RemoteEnums/setPlanet", new Operation("RemoteEnums_setPlanet"));
		add("post", "/RemoteInlineInstance/getActor", new Operation("RemoteInlineInstance_getActor"));
		add("post", "/RemoteInlineInstance/getPoint2DArray1dim", new Operation("RemoteInlineInstance_getPoint2DArray1dim"));
		add("post", "/RemoteInlineInstance/getPoint2DArray4dim", new Operation("RemoteInlineInstance_getPoint2DArray4dim"));
		add("post", "/RemoteInlineInstance/getPoint2DList", new Operation("RemoteInlineInstance_getPoint2DList"));
		add("post", "/RemoteInlineInstance/getPoint2DListList", new Operation("RemoteInlineInstance_getPoint2DListList"));
		add("post", "/RemoteInlineInstance/getPoint2DMap", new Operation("RemoteInlineInstance_getPoint2DMap"));
		add("post", "/RemoteInlineInstance/setActor", new Operation("RemoteInlineInstance_setActor"));
		add("post", "/RemoteInlineInstance/setPoint2DArray1dim", new Operation("RemoteInlineInstance_setPoint2DArray1dim"));
		add("post", "/RemoteInlineInstance/setPoint2DArray4dim", new Operation("RemoteInlineInstance_setPoint2DArray4dim"));
		add("post", "/RemoteInlineInstance/setPoint2DList", new Operation("RemoteInlineInstance_setPoint2DList"));
		add("post", "/RemoteInlineInstance/setPoint2DListList", new Operation("RemoteInlineInstance_setPoint2DListList"));
		add("post", "/RemoteInlineInstance/setPoint2DMap", new Operation("RemoteInlineInstance_setPoint2DMap"));
		add("post", "/RemoteListTypes/getBoolean1", new Operation("RemoteListTypes_getBoolean1"));
		add("post", "/RemoteListTypes/getByte1", new Operation("RemoteListTypes_getByte1"));
		add("post", "/RemoteListTypes/getByte2", new Operation("RemoteListTypes_getByte2"));
		add("post", "/RemoteListTypes/getChar1", new Operation("RemoteListTypes_getChar1"));
		add("post", "/RemoteListTypes/getDate1", new Operation("RemoteListTypes_getDate1"));
		add("post", "/RemoteListTypes/getDouble1", new Operation("RemoteListTypes_getDouble1"));
		add("post", "/RemoteListTypes/getFloat1", new Operation("RemoteListTypes_getFloat1"));
		add("post", "/RemoteListTypes/getInt1", new Operation("RemoteListTypes_getInt1"));
		add("post", "/RemoteListTypes/getInt2", new Operation("RemoteListTypes_getInt2"));
		add("post", "/RemoteListTypes/getInt3", new Operation("RemoteListTypes_getInt3"));
		add("post", "/RemoteListTypes/getInt4", new Operation("RemoteListTypes_getInt4"));
		add("post", "/RemoteListTypes/getLong1", new Operation("RemoteListTypes_getLong1"));
		add("post", "/RemoteListTypes/getObj1", new Operation("RemoteListTypes_getObj1"));
		add("post", "/RemoteListTypes/getPrimitiveTypes1", new Operation("RemoteListTypes_getPrimitiveTypes1"));
		add("post", "/RemoteListTypes/getShort1", new Operation("RemoteListTypes_getShort1"));
		add("post", "/RemoteListTypes/getString1", new Operation("RemoteListTypes_getString1"));
		add("post", "/RemoteListTypes/setBoolean1", new Operation("RemoteListTypes_setBoolean1"));
		add("post", "/RemoteListTypes/setByte1", new Operation("RemoteListTypes_setByte1"));
		add("post", "/RemoteListTypes/setByte2", new Operation("RemoteListTypes_setByte2"));
		add("post", "/RemoteListTypes/setChar1", new Operation("RemoteListTypes_setChar1"));
		add("post", "/RemoteListTypes/setDate1", new Operation("RemoteListTypes_setDate1"));
		add("post", "/RemoteListTypes/setDouble1", new Operation("RemoteListTypes_setDouble1"));
		add("post", "/RemoteListTypes/setFloat1", new Operation("RemoteListTypes_setFloat1"));
		add("post", "/RemoteListTypes/setInt1", new Operation("RemoteListTypes_setInt1"));
		add("post", "/RemoteListTypes/setInt2", new Operation("RemoteListTypes_setInt2"));
		add("post", "/RemoteListTypes/setInt3", new Operation("RemoteListTypes_setInt3"));
		add("post", "/RemoteListTypes/setInt4", new Operation("RemoteListTypes_setInt4"));
		add("post", "/RemoteListTypes/setLong1", new Operation("RemoteListTypes_setLong1"));
		add("post", "/RemoteListTypes/setObj1", new Operation("RemoteListTypes_setObj1"));
		add("post", "/RemoteListTypes/setPrimitiveTypes1", new Operation("RemoteListTypes_setPrimitiveTypes1"));
		add("post", "/RemoteListTypes/setShort1", new Operation("RemoteListTypes_setShort1"));
		add("post", "/RemoteListTypes/setString1", new Operation("RemoteListTypes_setString1"));
		add("post", "/RemoteMapTypes/getBoolean1", new Operation("RemoteMapTypes_getBoolean1"));
		add("post", "/RemoteMapTypes/getByte1", new Operation("RemoteMapTypes_getByte1"));
		add("post", "/RemoteMapTypes/getByte2", new Operation("RemoteMapTypes_getByte2"));
		add("post", "/RemoteMapTypes/getChar1", new Operation("RemoteMapTypes_getChar1"));
		add("post", "/RemoteMapTypes/getDate1", new Operation("RemoteMapTypes_getDate1"));
		add("post", "/RemoteMapTypes/getDouble1", new Operation("RemoteMapTypes_getDouble1"));
		add("post", "/RemoteMapTypes/getFloat1", new Operation("RemoteMapTypes_getFloat1"));
		add("post", "/RemoteMapTypes/getInt1", new Operation("RemoteMapTypes_getInt1"));
		add("post", "/RemoteMapTypes/getInt2", new Operation("RemoteMapTypes_getInt2"));
		add("post", "/RemoteMapTypes/getLong1", new Operation("RemoteMapTypes_getLong1"));
		add("post", "/RemoteMapTypes/getObj1", new Operation("RemoteMapTypes_getObj1"));
		add("post", "/RemoteMapTypes/getPrimitiveTypes1", new Operation("RemoteMapTypes_getPrimitiveTypes1"));
		add("post", "/RemoteMapTypes/getShort1", new Operation("RemoteMapTypes_getShort1"));
		add("post", "/RemoteMapTypes/getString1", new Operation("RemoteMapTypes_getString1"));
		add("post", "/RemoteMapTypes/setBoolean1", new Operation("RemoteMapTypes_setBoolean1"));
		add("post", "/RemoteMapTypes/setByte1", new Operation("RemoteMapTypes_setByte1"));
		add("post", "/RemoteMapTypes/setByte2", new Operation("RemoteMapTypes_setByte2"));
		add("post", "/RemoteMapTypes/setChar1", new Operation("RemoteMapTypes_setChar1"));
		add("post", "/RemoteMapTypes/setDate1", new Operation("RemoteMapTypes_setDate1"));
		add("post", "/RemoteMapTypes/setDouble1", new Operation("RemoteMapTypes_setDouble1"));
		add("post", "/RemoteMapTypes/setFloat1", new Operation("RemoteMapTypes_setFloat1"));
		add("post", "/RemoteMapTypes/setInt1", new Operation("RemoteMapTypes_setInt1"));
		add("post", "/RemoteMapTypes/setInt2", new Operation("RemoteMapTypes_setInt2"));
		add("post", "/RemoteMapTypes/setLong1", new Operation("RemoteMapTypes_setLong1"));
		add("post", "/RemoteMapTypes/setObj1", new Operation("RemoteMapTypes_setObj1"));
		add("post", "/RemoteMapTypes/setPrimitiveTypes1", new Operation("RemoteMapTypes_setPrimitiveTypes1"));
		add("post", "/RemoteMapTypes/setShort1", new Operation("RemoteMapTypes_setShort1"));
		add("post", "/RemoteMapTypes/setString1", new Operation("RemoteMapTypes_setString1"));
		add("post", "/RemotePrimitiveTypes/getBool", new Operation("RemotePrimitiveTypes_getBool"));
		add("post", "/RemotePrimitiveTypes/getByte", new Operation("RemotePrimitiveTypes_getByte"));
		add("post", "/RemotePrimitiveTypes/getChar", new Operation("RemotePrimitiveTypes_getChar"));
		add("post", "/RemotePrimitiveTypes/getDate", new Operation("RemotePrimitiveTypes_getDate"));
		add("post", "/RemotePrimitiveTypes/getDeferredValueFromServer", new Operation("RemotePrimitiveTypes_getDeferredValueFromServer"));
		add("post", "/RemotePrimitiveTypes/getDouble", new Operation("RemotePrimitiveTypes_getDouble"));
		add("post", "/RemotePrimitiveTypes/getFloat", new Operation("RemotePrimitiveTypes_getFloat"));
		add("post", "/RemotePrimitiveTypes/getInt", new Operation("RemotePrimitiveTypes_getInt"));
		add("post", "/RemotePrimitiveTypes/getLong", new Operation("RemotePrimitiveTypes_getLong"));
		add("post", "/RemotePrimitiveTypes/getObject", new Operation("RemotePrimitiveTypes_getObject"));
		add("post", "/RemotePrimitiveTypes/getPrimitiveTypes", new Operation("RemotePrimitiveTypes_getPrimitiveTypes"));
		add("post", "/RemotePrimitiveTypes/getShort", new Operation("RemotePrimitiveTypes_getShort"));
		add("post", "/RemotePrimitiveTypes/getString", new Operation("RemotePrimitiveTypes_getString"));
		add("post", "/RemotePrimitiveTypes/makeDate", new Operation("RemotePrimitiveTypes_makeDate"));
		add("post", "/RemotePrimitiveTypes/parseDate", new Operation("RemotePrimitiveTypes_parseDate"));
		add("get", "/RemotePrimitiveTypes/primitiveadd", new Operation("RemotePrimitiveTypes_add"));
		add("post", "/RemotePrimitiveTypes/sendAllTypes", new Operation("RemotePrimitiveTypes_sendAllTypes"));
		add("post", "/RemotePrimitiveTypes/setBool", new Operation("RemotePrimitiveTypes_setBool"));
		add("post", "/RemotePrimitiveTypes/setByte", new Operation("RemotePrimitiveTypes_setByte"));
		add("post", "/RemotePrimitiveTypes/setChar", new Operation("RemotePrimitiveTypes_setChar"));
		add("post", "/RemotePrimitiveTypes/setDate", new Operation("RemotePrimitiveTypes_setDate"));
		add("post", "/RemotePrimitiveTypes/setDouble", new Operation("RemotePrimitiveTypes_setDouble"));
		add("post", "/RemotePrimitiveTypes/setFloat", new Operation("RemotePrimitiveTypes_setFloat"));
		add("post", "/RemotePrimitiveTypes/setInt", new Operation("RemotePrimitiveTypes_setInt"));
		add("post", "/RemotePrimitiveTypes/setLong", new Operation("RemotePrimitiveTypes_setLong"));
		add("post", "/RemotePrimitiveTypes/setObject", new Operation("RemotePrimitiveTypes_setObject"));
		add("post", "/RemotePrimitiveTypes/setPrimitiveTypes", new Operation("RemotePrimitiveTypes_setPrimitiveTypes"));
		add("post", "/RemotePrimitiveTypes/setShort", new Operation("RemotePrimitiveTypes_setShort"));
		add("post", "/RemotePrimitiveTypes/setString", new Operation("RemotePrimitiveTypes_setString"));
		add("post", "/RemotePrimitiveTypes/throwException", new Operation("RemotePrimitiveTypes_throwException"));
		add("post", "/RemotePrimitiveTypes/voidFunctionVoid", new Operation("RemotePrimitiveTypes_voidFunctionVoid"));
		add("post", "/RemoteProcessingEx/getValueAfterProcessingExceptions", new Operation("RemoteProcessingEx_getValueAfterProcessingExceptions"));
		add("post", "/RemoteReferences/getNode", new Operation("RemoteReferences_getNode"));
		add("post", "/RemoteReferences/setNode", new Operation("RemoteReferences_setNode"));
		add("post", "/RemoteServerCtrl/getPublishedRemote", new Operation("RemoteServerCtrl_getPublishedRemote"));
		add("post", "/RemoteServerCtrl/publishRemote", new Operation("RemoteServerCtrl_publishRemote"));
		add("post", "/RemoteServerCtrl/removePublishedRemote", new Operation("RemoteServerCtrl_removePublishedRemote"));
		add("post", "/RemoteSetTypes/getBoolean1", new Operation("RemoteSetTypes_getBoolean1"));
		add("post", "/RemoteSetTypes/getByte1", new Operation("RemoteSetTypes_getByte1"));
		add("post", "/RemoteSetTypes/getByte2", new Operation("RemoteSetTypes_getByte2"));
		add("post", "/RemoteSetTypes/getChar1", new Operation("RemoteSetTypes_getChar1"));
		add("post", "/RemoteSetTypes/getDate1", new Operation("RemoteSetTypes_getDate1"));
		add("post", "/RemoteSetTypes/getDouble1", new Operation("RemoteSetTypes_getDouble1"));
		add("post", "/RemoteSetTypes/getFloat1", new Operation("RemoteSetTypes_getFloat1"));
		add("post", "/RemoteSetTypes/getInt1", new Operation("RemoteSetTypes_getInt1"));
		add("post", "/RemoteSetTypes/getInt2", new Operation("RemoteSetTypes_getInt2"));
		add("post", "/RemoteSetTypes/getLong1", new Operation("RemoteSetTypes_getLong1"));
		add("post", "/RemoteSetTypes/getObj1", new Operation("RemoteSetTypes_getObj1"));
		add("post", "/RemoteSetTypes/getPrimitiveTypes1", new Operation("RemoteSetTypes_getPrimitiveTypes1"));
		add("post", "/RemoteSetTypes/getShort1", new Operation("RemoteSetTypes_getShort1"));
		add("post", "/RemoteSetTypes/getString1", new Operation("RemoteSetTypes_getString1"));
		add("post", "/RemoteSetTypes/setBoolean1", new Operation("RemoteSetTypes_setBoolean1"));
		add("post", "/RemoteSetTypes/setByte1", new Operation("RemoteSetTypes_setByte1"));
		add("post", "/RemoteSetTypes/setByte2", new Operation("RemoteSetTypes_setByte2"));
		add("post", "/RemoteSetTypes/setChar1", new Operation("RemoteSetTypes_setChar1"));
		add("post", "/RemoteSetTypes/setDate1", new Operation("RemoteSetTypes_setDate1"));
		add("post", "/RemoteSetTypes/setDouble1", new Operation("RemoteSetTypes_setDouble1"));
		add("post", "/RemoteSetTypes/setFloat1", new Operation("RemoteSetTypes_setFloat1"));
		add("post", "/RemoteSetTypes/setInt1", new Operation("RemoteSetTypes_setInt1"));
		add("post", "/RemoteSetTypes/setInt2", new Operation("RemoteSetTypes_setInt2"));
		add("post", "/RemoteSetTypes/setLong1", new Operation("RemoteSetTypes_setLong1"));
		add("post", "/RemoteSetTypes/setObj1", new Operation("RemoteSetTypes_setObj1"));
		add("post", "/RemoteSetTypes/setPrimitiveTypes1", new Operation("RemoteSetTypes_setPrimitiveTypes1"));
		add("post", "/RemoteSetTypes/setShort1", new Operation("RemoteSetTypes_setShort1"));
		add("post", "/RemoteSetTypes/setString1", new Operation("RemoteSetTypes_setString1"));
		add("post", "/RemoteStreams/getImage", new Operation("RemoteStreams_getImage"));
		add("post", "/RemoteStreams/getImages", new Operation("RemoteStreams_getImages"));
		add("post", "/RemoteStreams/getSharedStream", new Operation("RemoteStreams_getSharedStream"));
		add("post", "/RemoteStreams/getStreamDeferedProperies", new Operation("RemoteStreams_getStreamDeferedProperies"));
		add("post", "/RemoteStreams/getStreamDoNotClone", new Operation("RemoteStreams_getStreamDoNotClone"));
		add("post", "/RemoteStreams/getTextStream", new Operation("RemoteStreams_getTextStream"));
		add("post", "/RemoteStreams/getVideoCheckSupportByteRange", new Operation("RemoteStreams_getVideoCheckSupportByteRange"));
		add("post", "/RemoteStreams/putSharedStream", new Operation("RemoteStreams_putSharedStream"));
		add("post", "/RemoteStreams/setImage", new Operation("RemoteStreams_setImage"));
		add("post", "/RemoteStreams/setImages", new Operation("RemoteStreams_setImages"));
		add("post", "/RemoteStreams/setStreamDoNotMaterialize", new Operation("RemoteStreams_setStreamDoNotMaterialize"));
		add("post", "/RemoteStreams/throwLastException", new Operation("RemoteStreams_throwLastException"));
		add("post", "/RemoteWithAuthentication/doit", new Operation("RemoteWithAuthentication_doit"));
		add("post", "/RemoteWithAuthentication/expire", new Operation("RemoteWithAuthentication_expire"));
		add("post", "/RemoteWithAuthentication/login", new Operation("RemoteWithAuthentication_login"));
		add("post", "/RemoteWithAuthentication/setReloginCount", new Operation("RemoteWithAuthentication_setReloginCount"));
		add("post", "/RemoteWithAuthentication/setUseAuthentication", new Operation("RemoteWithAuthentication_setUseAuthentication"));
		add("post", "/ServerIF/callClientIncrementInt", new Operation("ServerIF_callClientIncrementInt"));
		add("post", "/ServerIF/callClientParallel", new Operation("ServerIF_callClientParallel"));
		add("post", "/ServerIF/getClient", new Operation("ServerIF_getClient"));
		add("post", "/ServerIF/getClientIds", new Operation("ServerIF_getClientIds"));
		add("post", "/ServerIF/getPartner", new Operation("ServerIF_getPartner"));
		add("post", "/ServerIF/getStreamsFromClient", new Operation("ServerIF_getStreamsFromClient"));
		add("post", "/ServerIF/putStreamsOnClient", new Operation("ServerIF_putStreamsOnClient"));
		add("post", "/ServerIF/registerWithClientMap", new Operation("ServerIF_registerWithClientMap"));
		add("post", "/ServerIF/setPartner", new Operation("ServerIF_setPartner"));
	}
}
