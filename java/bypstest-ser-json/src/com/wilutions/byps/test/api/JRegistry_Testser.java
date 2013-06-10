package com.wilutions.byps.test.api;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class JRegistry_Testser extends BRegistry { 

	public JRegistry_Testser(BBinaryModel bmodel) {
		super(bmodel);
	}
	
	@Override
	public BSerializer getApiSerializer(int typeId) {
		// boolean[]
		if (typeId == 2058423690) return com.wilutions.byps.test.api.JSerializer_2058423690.instance;
		// boolean[][][][]
		if (typeId == 945713488) return com.wilutions.byps.test.api.JSerializer_945713488.instance;
		// byte[]
		if (typeId == 1374008726) return com.wilutions.byps.test.api.JSerializer_1374008726.instance;
		// byte[][][][]
		if (typeId == 1201775504) return com.wilutions.byps.test.api.JSerializer_1201775504.instance;
		// char[]
		if (typeId == 1361632968) return com.wilutions.byps.test.api.JSerializer_1361632968.instance;
		// char[][][][]
		if (typeId == 769021986) return com.wilutions.byps.test.api.JSerializer_769021986.instance;
		// com.wilutions.byps.test.api.arr.ArrayTypes1dim
		if (typeId == 2001) return com.wilutions.byps.test.api.arr.JSerializer_2001.instance;
		// com.wilutions.byps.test.api.arr.ArrayTypes4dim
		if (typeId == 2004) return com.wilutions.byps.test.api.arr.JSerializer_2004.instance;
		// com.wilutions.byps.test.api.enu.EnumPlanets[]
		if (typeId == 1092048313) return com.wilutions.byps.test.api.JSerializer_1092048313.instance;
		// com.wilutions.byps.test.api.enu.UsePlanets
		if (typeId == 10000) return com.wilutions.byps.test.api.enu.JSerializer_10000.instance;
		// com.wilutions.byps.test.api.inherit.Class1
		if (typeId == 6001) return com.wilutions.byps.test.api.inherit.JSerializer_6001.instance;
		// com.wilutions.byps.test.api.inherit.Class1Collections
		if (typeId == 6004) return com.wilutions.byps.test.api.inherit.JSerializer_6004.instance;
		// com.wilutions.byps.test.api.inherit.Class2
		if (typeId == 6002) return com.wilutions.byps.test.api.inherit.JSerializer_6002.instance;
		// com.wilutions.byps.test.api.inherit.Class3
		if (typeId == 6003) return com.wilutions.byps.test.api.inherit.JSerializer_6003.instance;
		// com.wilutions.byps.test.api.inl.Actor
		if (typeId == 171948703) return com.wilutions.byps.test.api.inl.JSerializer_171948703.instance;
		// com.wilutions.byps.test.api.inl.Actor[]
		if (typeId == 1784131613) return com.wilutions.byps.test.api.JSerializer_1784131613.instance;
		// com.wilutions.byps.test.api.inl.Actor[][][][]
		if (typeId == 193284349) return com.wilutions.byps.test.api.JSerializer_193284349.instance;
		// com.wilutions.byps.test.api.inl.Matrix2D
		if (typeId == 135329019) return com.wilutions.byps.test.api.inl.JSerializer_135329019.instance;
		// com.wilutions.byps.test.api.inl.Point2D
		if (typeId == 1835035436) return com.wilutions.byps.test.api.inl.JSerializer_1835035436.instance;
		// com.wilutions.byps.test.api.inl.Point2D[]
		if (typeId == 2049740106) return com.wilutions.byps.test.api.JSerializer_2049740106.instance;
		// com.wilutions.byps.test.api.list.ListListTypes
		if (typeId == 3002) return com.wilutions.byps.test.api.list.JSerializer_3002.instance;
		// com.wilutions.byps.test.api.list.ListTypes
		if (typeId == 3001) return com.wilutions.byps.test.api.list.JSerializer_3001.instance;
		// com.wilutions.byps.test.api.map.MapTypes
		if (typeId == 4001) return com.wilutions.byps.test.api.map.JSerializer_4001.instance;
		// com.wilutions.byps.test.api.prim.PrimitiveTypes
		if (typeId == 1000) return com.wilutions.byps.test.api.prim.JSerializer_1000.instance;
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[]
		if (typeId == 801243127) return com.wilutions.byps.test.api.JSerializer_801243127.instance;
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
		if (typeId == 1503107601) return com.wilutions.byps.test.api.JSerializer_1503107601.instance;
		// com.wilutions.byps.test.api.priv.PrivateMembers
		if (typeId == 8001) return com.wilutions.byps.test.api.priv.JSerializer_8001.instance;
		// com.wilutions.byps.test.api.refs.Node
		if (typeId == 9001) return com.wilutions.byps.test.api.refs.JSerializer_9001.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getBool
		if (typeId == 1645604187) return com.wilutions.byps.test.api.remote.JSerializer_1645604187.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getByte
		if (typeId == 1645613945) return com.wilutions.byps.test.api.remote.JSerializer_1645613945.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
		if (typeId == 1645626823) return com.wilutions.byps.test.api.remote.JSerializer_1645626823.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDouble
		if (typeId == 935089666) return com.wilutions.byps.test.api.remote.JSerializer_935089666.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getFloat
		if (typeId == 522273269) return com.wilutions.byps.test.api.remote.JSerializer_522273269.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
		if (typeId == 1609477282) return com.wilutions.byps.test.api.remote.JSerializer_1609477282.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getLong
		if (typeId == 1645902061) return com.wilutions.byps.test.api.remote.JSerializer_1645902061.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getObject
		if (typeId == 1237679472) return com.wilutions.byps.test.api.remote.JSerializer_1237679472.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
		if (typeId == 825201405) return com.wilutions.byps.test.api.remote.JSerializer_825201405.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getShort
		if (typeId == 510386133) return com.wilutions.byps.test.api.remote.JSerializer_510386133.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getString
		if (typeId == 1369061954) return com.wilutions.byps.test.api.remote.JSerializer_1369061954.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setBool
		if (typeId == 589253529) return com.wilutions.byps.test.api.remote.JSerializer_589253529.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setByte
		if (typeId == 589243771) return com.wilutions.byps.test.api.remote.JSerializer_589243771.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setChar
		if (typeId == 589230893) return com.wilutions.byps.test.api.remote.JSerializer_589230893.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setDouble
		if (typeId == 720472590) return com.wilutions.byps.test.api.remote.JSerializer_720472590.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setFloat
		if (typeId == 1083385729) return com.wilutions.byps.test.api.remote.JSerializer_1083385729.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
		if (typeId == 1265927470) return com.wilutions.byps.test.api.remote.JSerializer_1265927470.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
		if (typeId == 588955655) return com.wilutions.byps.test.api.remote.JSerializer_588955655.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setObject
		if (typeId == 1023062396) return com.wilutions.byps.test.api.remote.JSerializer_1023062396.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
		if (typeId == 1765354225) return com.wilutions.byps.test.api.remote.JSerializer_1765354225.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setShort
		if (typeId == 1071498593) return com.wilutions.byps.test.api.remote.JSerializer_1071498593.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setString
		if (typeId == 1154444878) return com.wilutions.byps.test.api.remote.JSerializer_1154444878.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
		if (typeId == 2032852344) return com.wilutions.byps.test.api.remote.JSerializer_2032852344.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getByte
		if (typeId == 2032862102) return com.wilutions.byps.test.api.remote.JSerializer_2032862102.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getChar
		if (typeId == 2032874980) return com.wilutions.byps.test.api.remote.JSerializer_2032874980.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getDouble
		if (typeId == 581586209) return com.wilutions.byps.test.api.remote.JSerializer_581586209.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getFloat
		if (typeId == 1402482290) return com.wilutions.byps.test.api.remote.JSerializer_1402482290.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getInt
		if (typeId == 1589603233) return com.wilutions.byps.test.api.remote.JSerializer_1589603233.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getLong
		if (typeId == 2033150218) return com.wilutions.byps.test.api.remote.JSerializer_2033150218.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
		if (typeId == 278996403) return com.wilutions.byps.test.api.remote.JSerializer_278996403.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
		if (typeId == 1650564320) return com.wilutions.byps.test.api.remote.JSerializer_1650564320.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getShort
		if (typeId == 1390595154) return com.wilutions.byps.test.api.remote.JSerializer_1390595154.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getString
		if (typeId == 147613921) return com.wilutions.byps.test.api.remote.JSerializer_147613921.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
		if (typeId == 202005372) return com.wilutions.byps.test.api.remote.JSerializer_202005372.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setByte
		if (typeId == 201995614) return com.wilutions.byps.test.api.remote.JSerializer_201995614.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
		if (typeId == 201982736) return com.wilutions.byps.test.api.remote.JSerializer_201982736.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
		if (typeId == 796203285) return com.wilutions.byps.test.api.remote.JSerializer_796203285.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setFloat
		if (typeId == 1963594750) return com.wilutions.byps.test.api.remote.JSerializer_1963594750.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setInt
		if (typeId == 1933153045) return com.wilutions.byps.test.api.remote.JSerializer_1933153045.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
		if (typeId == 201707498) return com.wilutions.byps.test.api.remote.JSerializer_201707498.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
		if (typeId == 493613479) return com.wilutions.byps.test.api.remote.JSerializer_493613479.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
		if (typeId == 710411500) return com.wilutions.byps.test.api.remote.JSerializer_710411500.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setShort
		if (typeId == 1951707614) return com.wilutions.byps.test.api.remote.JSerializer_1951707614.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setString
		if (typeId == 362230997) return com.wilutions.byps.test.api.remote.JSerializer_362230997.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_getPlanet
		if (typeId == 627010462) return com.wilutions.byps.test.api.remote.JSerializer_627010462.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_setPlanet
		if (typeId == 412393386) return com.wilutions.byps.test.api.remote.JSerializer_412393386.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
		if (typeId == 261822861) return com.wilutions.byps.test.api.remote.JSerializer_261822861.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray1dim
		if (typeId == 699915651) return com.wilutions.byps.test.api.remote.JSerializer_699915651.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray4dim
		if (typeId == 700005024) return com.wilutions.byps.test.api.remote.JSerializer_700005024.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorList
		if (typeId == 843952075) return com.wilutions.byps.test.api.remote.JSerializer_843952075.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorListList
		if (typeId == 248580343) return com.wilutions.byps.test.api.remote.JSerializer_248580343.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorMap
		if (typeId == 304319631) return com.wilutions.byps.test.api.remote.JSerializer_304319631.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorSet
		if (typeId == 304325525) return com.wilutions.byps.test.api.remote.JSerializer_304325525.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
		if (typeId == 299289599) return com.wilutions.byps.test.api.remote.JSerializer_299289599.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray1dim
		if (typeId == 240237169) return com.wilutions.byps.test.api.remote.JSerializer_240237169.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray4dim
		if (typeId == 240147796) return com.wilutions.byps.test.api.remote.JSerializer_240147796.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorList
		if (typeId == 1902022593) return com.wilutions.byps.test.api.remote.JSerializer_1902022593.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorListList
		if (typeId == 2080023171) return com.wilutions.byps.test.api.remote.JSerializer_2080023171.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorMap
		if (typeId == 215739803) return com.wilutions.byps.test.api.remote.JSerializer_215739803.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorSet
		if (typeId == 215745697) return com.wilutions.byps.test.api.remote.JSerializer_215745697.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getBoolean1
		if (typeId == 1794077576) return com.wilutions.byps.test.api.remote.JSerializer_1794077576.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte1
		if (typeId == 1319541530) return com.wilutions.byps.test.api.remote.JSerializer_1319541530.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte2
		if (typeId == 1319541531) return com.wilutions.byps.test.api.remote.JSerializer_1319541531.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getChar1
		if (typeId == 1319940748) return com.wilutions.byps.test.api.remote.JSerializer_1319940748.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getDouble1
		if (typeId == 1741299407) return com.wilutions.byps.test.api.remote.JSerializer_1741299407.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getFloat1
		if (typeId == 1941525372) return com.wilutions.byps.test.api.remote.JSerializer_1941525372.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt1
		if (typeId == 874047761) return com.wilutions.byps.test.api.remote.JSerializer_874047761.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt2
		if (typeId == 874047762) return com.wilutions.byps.test.api.remote.JSerializer_874047762.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt3
		if (typeId == 874047763) return com.wilutions.byps.test.api.remote.JSerializer_874047763.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt4
		if (typeId == 874047764) return com.wilutions.byps.test.api.remote.JSerializer_874047764.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getLong1
		if (typeId == 1328473126) return com.wilutions.byps.test.api.remote.JSerializer_1328473126.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getObj1
		if (typeId == 874214665) return com.wilutions.byps.test.api.remote.JSerializer_874214665.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
		if (typeId == 1940572240) return com.wilutions.byps.test.api.remote.JSerializer_1940572240.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getShort1
		if (typeId == 1573024156) return com.wilutions.byps.test.api.remote.JSerializer_1573024156.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getString1
		if (typeId == 1173060367) return com.wilutions.byps.test.api.remote.JSerializer_1173060367.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
		if (typeId == 1882657404) return com.wilutions.byps.test.api.remote.JSerializer_1882657404.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte1
		if (typeId == 758429070) return com.wilutions.byps.test.api.remote.JSerializer_758429070.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte2
		if (typeId == 758429071) return com.wilutions.byps.test.api.remote.JSerializer_758429071.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setChar1
		if (typeId == 758828288) return com.wilutions.byps.test.api.remote.JSerializer_758828288.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setDouble1
		if (typeId == 195505829) return com.wilutions.byps.test.api.remote.JSerializer_195505829.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
		if (typeId == 2138824848) return com.wilutions.byps.test.api.remote.JSerializer_2138824848.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt1
		if (typeId == 1360809955) return com.wilutions.byps.test.api.remote.JSerializer_1360809955.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt2
		if (typeId == 1360809954) return com.wilutions.byps.test.api.remote.JSerializer_1360809954.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt3
		if (typeId == 1360809953) return com.wilutions.byps.test.api.remote.JSerializer_1360809953.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt4
		if (typeId == 1360809952) return com.wilutions.byps.test.api.remote.JSerializer_1360809952.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setLong1
		if (typeId == 767360666) return com.wilutions.byps.test.api.remote.JSerializer_767360666.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setObj1
		if (typeId == 1360643051) return com.wilutions.byps.test.api.remote.JSerializer_1360643051.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setPrimitiveTypes1
		if (typeId == 1434361404) return com.wilutions.byps.test.api.remote.JSerializer_1434361404.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setShort1
		if (typeId == 1787641232) return com.wilutions.byps.test.api.remote.JSerializer_1787641232.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setString1
		if (typeId == 763744869) return com.wilutions.byps.test.api.remote.JSerializer_763744869.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getBoolean1
		if (typeId == 461626272) return com.wilutions.byps.test.api.remote.JSerializer_461626272.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte1
		if (typeId == 1348711374) return com.wilutions.byps.test.api.remote.JSerializer_1348711374.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte2
		if (typeId == 1348711373) return com.wilutions.byps.test.api.remote.JSerializer_1348711373.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
		if (typeId == 1348312156) return com.wilutions.byps.test.api.remote.JSerializer_1348312156.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getDouble1
		if (typeId == 1836864439) return com.wilutions.byps.test.api.remote.JSerializer_1836864439.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getFloat1
		if (typeId == 1241980524) return com.wilutions.byps.test.api.remote.JSerializer_1241980524.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt1
		if (typeId == 1013140231) return com.wilutions.byps.test.api.remote.JSerializer_1013140231.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt2
		if (typeId == 1013140230) return com.wilutions.byps.test.api.remote.JSerializer_1013140230.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
		if (typeId == 1339779778) return com.wilutions.byps.test.api.remote.JSerializer_1339779778.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getObj1
		if (typeId == 1012973327) return com.wilutions.byps.test.api.remote.JSerializer_1012973327.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getPrimitiveTypes1
		if (typeId == 77071512) return com.wilutions.byps.test.api.remote.JSerializer_77071512.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getShort1
		if (typeId == 1610481740) return com.wilutions.byps.test.api.remote.JSerializer_1610481740.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getString1
		if (typeId == 1268625399) return com.wilutions.byps.test.api.remote.JSerializer_1268625399.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
		if (typeId == 550206100) return com.wilutions.byps.test.api.remote.JSerializer_550206100.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte1
		if (typeId == 1909823834) return com.wilutions.byps.test.api.remote.JSerializer_1909823834.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
		if (typeId == 1909823833) return com.wilutions.byps.test.api.remote.JSerializer_1909823833.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setChar1
		if (typeId == 1909424616) return com.wilutions.byps.test.api.remote.JSerializer_1909424616.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setDouble1
		if (typeId == 99940797) return com.wilutions.byps.test.api.remote.JSerializer_99940797.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
		if (typeId == 1027363448) return com.wilutions.byps.test.api.remote.JSerializer_1027363448.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt1
		if (typeId == 1046969349) return com.wilutions.byps.test.api.remote.JSerializer_1046969349.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
		if (typeId == 1046969350) return com.wilutions.byps.test.api.remote.JSerializer_1046969350.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
		if (typeId == 1900892238) return com.wilutions.byps.test.api.remote.JSerializer_1900892238.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
		if (typeId == 1047136253) return com.wilutions.byps.test.api.remote.JSerializer_1047136253.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
		if (typeId == 842962140) return com.wilutions.byps.test.api.remote.JSerializer_842962140.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setShort1
		if (typeId == 1395864664) return com.wilutions.byps.test.api.remote.JSerializer_1395864664.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setString1
		if (typeId == 668179837) return com.wilutions.byps.test.api.remote.JSerializer_668179837.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
		if (typeId == 1073583639) return com.wilutions.byps.test.api.remote.JSerializer_1073583639.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getBool
		if (typeId == 2090997206) return com.wilutions.byps.test.api.remote.JSerializer_2090997206.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getByte
		if (typeId == 2091006964) return com.wilutions.byps.test.api.remote.JSerializer_2091006964.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getChar
		if (typeId == 2091019842) return com.wilutions.byps.test.api.remote.JSerializer_2091019842.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
		if (typeId == 538948675) return com.wilutions.byps.test.api.remote.JSerializer_538948675.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
		if (typeId == 400008432) return com.wilutions.byps.test.api.remote.JSerializer_400008432.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getInt
		if (typeId == 1318015101) return com.wilutions.byps.test.api.remote.JSerializer_1318015101.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
		if (typeId == 2091295080) return com.wilutions.byps.test.api.remote.JSerializer_2091295080.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getObject
		if (typeId == 236358869) return com.wilutions.byps.test.api.remote.JSerializer_236358869.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getPrimitiveTypes
		if (typeId == 1881962430) return com.wilutions.byps.test.api.remote.JSerializer_1881962430.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
		if (typeId == 411895568) return com.wilutions.byps.test.api.remote.JSerializer_411895568.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getString
		if (typeId == 104976387) return com.wilutions.byps.test.api.remote.JSerializer_104976387.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
		if (typeId == 1794219594) return com.wilutions.byps.test.api.remote.JSerializer_1794219594.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setBool
		if (typeId == 143860510) return com.wilutions.byps.test.api.remote.JSerializer_143860510.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setByte
		if (typeId == 143850752) return com.wilutions.byps.test.api.remote.JSerializer_143850752.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
		if (typeId == 143837874) return com.wilutions.byps.test.api.remote.JSerializer_143837874.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
		if (typeId == 753565751) return com.wilutions.byps.test.api.remote.JSerializer_753565751.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setFloat
		if (typeId == 161104028) return com.wilutions.byps.test.api.remote.JSerializer_161104028.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setInt
		if (typeId == 974465289) return com.wilutions.byps.test.api.remote.JSerializer_974465289.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setLong
		if (typeId == 143562636) return com.wilutions.byps.test.api.remote.JSerializer_143562636.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setObject
		if (typeId == 450975945) return com.wilutions.byps.test.api.remote.JSerializer_450975945.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setPrimitiveTypes
		if (typeId == 941809610) return com.wilutions.byps.test.api.remote.JSerializer_941809610.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
		if (typeId == 149216892) return com.wilutions.byps.test.api.remote.JSerializer_149216892.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setString
		if (typeId == 319593463) return com.wilutions.byps.test.api.remote.JSerializer_319593463.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
		if (typeId == 1856936054) return com.wilutions.byps.test.api.remote.JSerializer_1856936054.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_getNode
		if (typeId == 655936732) return com.wilutions.byps.test.api.remote.JSerializer_655936732.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_setNode
		if (typeId == 1404172848) return com.wilutions.byps.test.api.remote.JSerializer_1404172848.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getBoolean1
		if (typeId == 1690813926) return com.wilutions.byps.test.api.remote.JSerializer_1690813926.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte1
		if (typeId == 2125684552) return com.wilutions.byps.test.api.remote.JSerializer_2125684552.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
		if (typeId == 2125684551) return com.wilutions.byps.test.api.remote.JSerializer_2125684551.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
		if (typeId == 2125285334) return com.wilutions.byps.test.api.remote.JSerializer_2125285334.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getDouble1
		if (typeId == 1183778993) return com.wilutions.byps.test.api.remote.JSerializer_1183778993.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getFloat1
		if (typeId == 1369351514) return com.wilutions.byps.test.api.remote.JSerializer_1369351514.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt1
		if (typeId == 68372557) return com.wilutions.byps.test.api.remote.JSerializer_68372557.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt2
		if (typeId == 68372556) return com.wilutions.byps.test.api.remote.JSerializer_68372556.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getLong1
		if (typeId == 2116752956) return com.wilutions.byps.test.api.remote.JSerializer_2116752956.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getObj1
		if (typeId == 68205653) return com.wilutions.byps.test.api.remote.JSerializer_68205653.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getPrimitiveTypes1
		if (typeId == 1802821742) return com.wilutions.byps.test.api.remote.JSerializer_1802821742.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getShort1
		if (typeId == 1000850298) return com.wilutions.byps.test.api.remote.JSerializer_1000850298.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getString1
		if (typeId == 615539953) return com.wilutions.byps.test.api.remote.JSerializer_615539953.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
		if (typeId == 1779393754) return com.wilutions.byps.test.api.remote.JSerializer_1779393754.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
		if (typeId == 1608170284) return com.wilutions.byps.test.api.remote.JSerializer_1608170284.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
		if (typeId == 1608170285) return com.wilutions.byps.test.api.remote.JSerializer_1608170285.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
		if (typeId == 1608569502) return com.wilutions.byps.test.api.remote.JSerializer_1608569502.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
		if (typeId == 753026243) return com.wilutions.byps.test.api.remote.JSerializer_753026243.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setFloat1
		if (typeId == 1583968590) return com.wilutions.byps.test.api.remote.JSerializer_1583968590.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
		if (typeId == 1991737023) return com.wilutions.byps.test.api.remote.JSerializer_1991737023.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
		if (typeId == 1991737024) return com.wilutions.byps.test.api.remote.JSerializer_1991737024.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setLong1
		if (typeId == 1617101880) return com.wilutions.byps.test.api.remote.JSerializer_1617101880.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
		if (typeId == 1991903927) return com.wilutions.byps.test.api.remote.JSerializer_1991903927.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
		if (typeId == 1572111902) return com.wilutions.byps.test.api.remote.JSerializer_1572111902.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setShort1
		if (typeId == 1215467374) return com.wilutions.byps.test.api.remote.JSerializer_1215467374.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setString1
		if (typeId == 1321265283) return com.wilutions.byps.test.api.remote.JSerializer_1321265283.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImage
		if (typeId == 1902276204) return com.wilutions.byps.test.api.remote.JSerializer_1902276204.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImages
		if (typeId == 1158979935) return com.wilutions.byps.test.api.remote.JSerializer_1158979935.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getTextStream
		if (typeId == 1083407988) return com.wilutions.byps.test.api.remote.JSerializer_1083407988.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImage
		if (typeId == 1831578632) return com.wilutions.byps.test.api.remote.JSerializer_1831578632.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImages
		if (typeId == 944362859) return com.wilutions.byps.test.api.remote.JSerializer_944362859.instance;
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_throwLastException
		if (typeId == 2047657918) return com.wilutions.byps.test.api.remote.JSerializer_2047657918.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getBool
		if (typeId == 1716433773) return com.wilutions.byps.test.api.remote.JSerializer_1716433773.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getByte
		if (typeId == 1716424015) return com.wilutions.byps.test.api.remote.JSerializer_1716424015.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getChar
		if (typeId == 1716411137) return com.wilutions.byps.test.api.remote.JSerializer_1716411137.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getDouble
		if (typeId == 167983302) return com.wilutions.byps.test.api.remote.JSerializer_167983302.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getFloat
		if (typeId == 1666234925) return com.wilutions.byps.test.api.remote.JSerializer_1666234925.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getInt
		if (typeId == 193909466) return com.wilutions.byps.test.api.remote.JSerializer_193909466.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getLong
		if (typeId == 1716135899) return com.wilutions.byps.test.api.remote.JSerializer_1716135899.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getObject
		if (typeId == 134606504) return com.wilutions.byps.test.api.remote.JSerializer_134606504.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getPrimitiveTypes
		if (typeId == 251124165) return com.wilutions.byps.test.api.remote.JSerializer_251124165.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getShort
		if (typeId == 1654347789) return com.wilutions.byps.test.api.remote.JSerializer_1654347789.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getString
		if (typeId == 265988986) return com.wilutions.byps.test.api.remote.JSerializer_265988986.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setBool
		if (typeId == 343675807) return com.wilutions.byps.test.api.remote.JSerializer_343675807.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setByte
		if (typeId == 343685565) return com.wilutions.byps.test.api.remote.JSerializer_343685565.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setChar
		if (typeId == 343698443) return com.wilutions.byps.test.api.remote.JSerializer_343698443.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setDouble
		if (typeId == 382600378) return com.wilutions.byps.test.api.remote.JSerializer_382600378.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setFloat
		if (typeId == 2067619911) return com.wilutions.byps.test.api.remote.JSerializer_2067619911.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setInt
		if (typeId == 149640346) return com.wilutions.byps.test.api.remote.JSerializer_149640346.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setLong
		if (typeId == 343973681) return com.wilutions.byps.test.api.remote.JSerializer_343973681.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setObject
		if (typeId == 80010572) return com.wilutions.byps.test.api.remote.JSerializer_80010572.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setPrimitiveTypes
		if (typeId == 1191276985) return com.wilutions.byps.test.api.remote.JSerializer_1191276985.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setShort
		if (typeId == 2079507047) return com.wilutions.byps.test.api.remote.JSerializer_2079507047.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setString
		if (typeId == 51371910) return com.wilutions.byps.test.api.remote.JSerializer_51371910.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getBool
		if (typeId == 1329185616) return com.wilutions.byps.test.api.remote.JSerializer_1329185616.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getByte
		if (typeId == 1329175858) return com.wilutions.byps.test.api.remote.JSerializer_1329175858.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getChar
		if (typeId == 1329162980) return com.wilutions.byps.test.api.remote.JSerializer_1329162980.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getDouble
		if (typeId == 1684659177) return com.wilutions.byps.test.api.remote.JSerializer_1684659177.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getFloat
		if (typeId == 1748523350) return com.wilutions.byps.test.api.remote.JSerializer_1748523350.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getInt
		if (typeId == 1289796247) return com.wilutions.byps.test.api.remote.JSerializer_1289796247.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getLong
		if (typeId == 1328887742) return com.wilutions.byps.test.api.remote.JSerializer_1328887742.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getObject
		if (typeId == 1382069371) return com.wilutions.byps.test.api.remote.JSerializer_1382069371.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getPrimitiveTypes
		if (typeId == 2070325736) return com.wilutions.byps.test.api.remote.JSerializer_2070325736.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getShort
		if (typeId == 1760410486) return com.wilutions.byps.test.api.remote.JSerializer_1760410486.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getString
		if (typeId == 1250686889) return com.wilutions.byps.test.api.remote.JSerializer_1250686889.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setBool
		if (typeId == 730923964) return com.wilutions.byps.test.api.remote.JSerializer_730923964.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setByte
		if (typeId == 730933722) return com.wilutions.byps.test.api.remote.JSerializer_730933722.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setChar
		if (typeId == 730946600) return com.wilutions.byps.test.api.remote.JSerializer_730946600.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setDouble
		if (typeId == 1899276253) return com.wilutions.byps.test.api.remote.JSerializer_1899276253.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setFloat
		if (typeId == 1187410890) return com.wilutions.byps.test.api.remote.JSerializer_1187410890.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setInt
		if (typeId == 946246435) return com.wilutions.byps.test.api.remote.JSerializer_946246435.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setLong
		if (typeId == 731221838) return com.wilutions.byps.test.api.remote.JSerializer_731221838.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setObject
		if (typeId == 1596686447) return com.wilutions.byps.test.api.remote.JSerializer_1596686447.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setPrimitiveTypes
		if (typeId == 1284488740) return com.wilutions.byps.test.api.remote.JSerializer_1284488740.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setShort
		if (typeId == 1199298026) return com.wilutions.byps.test.api.remote.JSerializer_1199298026.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setString
		if (typeId == 1465303965) return com.wilutions.byps.test.api.remote.JSerializer_1465303965.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteEnums_getPlanet
		if (typeId == 839369882) return com.wilutions.byps.test.api.remote.JSerializer_839369882.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteEnums_setPlanet
		if (typeId == 1053986958) return com.wilutions.byps.test.api.remote.JSerializer_1053986958.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActor
		if (typeId == 882138795) return com.wilutions.byps.test.api.remote.JSerializer_882138795.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorArray1dim
		if (typeId == 1273992891) return com.wilutions.byps.test.api.remote.JSerializer_1273992891.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorArray4dim
		if (typeId == 1274082264) return com.wilutions.byps.test.api.remote.JSerializer_1274082264.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorList
		if (typeId == 8055917) return com.wilutions.byps.test.api.remote.JSerializer_8055917.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorListList
		if (typeId == 922798383) return com.wilutions.byps.test.api.remote.JSerializer_922798383.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorMap
		if (typeId == 1108119495) return com.wilutions.byps.test.api.remote.JSerializer_1108119495.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorSet
		if (typeId == 1108125389) return com.wilutions.byps.test.api.remote.JSerializer_1108125389.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActor
		if (typeId == 1443251255) return com.wilutions.byps.test.api.remote.JSerializer_1443251255.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray1dim
		if (typeId == 333840071) return com.wilutions.byps.test.api.remote.JSerializer_333840071.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray4dim
		if (typeId == 333929444) return com.wilutions.byps.test.api.remote.JSerializer_333929444.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorList
		if (typeId == 1540936711) return com.wilutions.byps.test.api.remote.JSerializer_1540936711.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorListList
		if (typeId == 1540726085) return com.wilutions.byps.test.api.remote.JSerializer_1540726085.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorMap
		if (typeId == 1019539667) return com.wilutions.byps.test.api.remote.JSerializer_1019539667.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorSet
		if (typeId == 1019545561) return com.wilutions.byps.test.api.remote.JSerializer_1019545561.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getBoolean1
		if (typeId == 378509760) return com.wilutions.byps.test.api.remote.JSerializer_378509760.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte1
		if (typeId == 495081042) return com.wilutions.byps.test.api.remote.JSerializer_495081042.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte2
		if (typeId == 495081043) return com.wilutions.byps.test.api.remote.JSerializer_495081043.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getChar1
		if (typeId == 495480260) return com.wilutions.byps.test.api.remote.JSerializer_495480260.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getDouble1
		if (typeId == 521121385) return com.wilutions.byps.test.api.remote.JSerializer_521121385.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getFloat1
		if (typeId == 1729996724) return com.wilutions.byps.test.api.remote.JSerializer_1729996724.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt1
		if (typeId == 431810265) return com.wilutions.byps.test.api.remote.JSerializer_431810265.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt2
		if (typeId == 431810266) return com.wilutions.byps.test.api.remote.JSerializer_431810266.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt3
		if (typeId == 431810267) return com.wilutions.byps.test.api.remote.JSerializer_431810267.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt4
		if (typeId == 431810268) return com.wilutions.byps.test.api.remote.JSerializer_431810268.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getLong1
		if (typeId == 504012638) return com.wilutions.byps.test.api.remote.JSerializer_504012638.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getObj1
		if (typeId == 431977169) return com.wilutions.byps.test.api.remote.JSerializer_431977169.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getPrimitiveTypes1
		if (typeId == 1298128264) return com.wilutions.byps.test.api.remote.JSerializer_1298128264.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getShort1
		if (typeId == 1361495508) return com.wilutions.byps.test.api.remote.JSerializer_1361495508.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getString1
		if (typeId == 1089360425) return com.wilutions.byps.test.api.remote.JSerializer_1089360425.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setBoolean1
		if (typeId == 467089588) return com.wilutions.byps.test.api.remote.JSerializer_467089588.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setByte1
		if (typeId == 66031418) return com.wilutions.byps.test.api.remote.JSerializer_66031418.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setByte2
		if (typeId == 66031417) return com.wilutions.byps.test.api.remote.JSerializer_66031417.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setChar1
		if (typeId == 65632200) return com.wilutions.byps.test.api.remote.JSerializer_65632200.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setDouble1
		if (typeId == 1837040675) return com.wilutions.byps.test.api.remote.JSerializer_1837040675.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setFloat1
		if (typeId == 1944613800) return com.wilutions.byps.test.api.remote.JSerializer_1944613800.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt1
		if (typeId == 1803047451) return com.wilutions.byps.test.api.remote.JSerializer_1803047451.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt2
		if (typeId == 1803047450) return com.wilutions.byps.test.api.remote.JSerializer_1803047450.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt3
		if (typeId == 1803047449) return com.wilutions.byps.test.api.remote.JSerializer_1803047449.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt4
		if (typeId == 1803047448) return com.wilutions.byps.test.api.remote.JSerializer_1803047448.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setLong1
		if (typeId == 57099822) return com.wilutions.byps.test.api.remote.JSerializer_57099822.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setObj1
		if (typeId == 1802880547) return com.wilutions.byps.test.api.remote.JSerializer_1802880547.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setPrimitiveTypes1
		if (typeId == 2076805380) return com.wilutions.byps.test.api.remote.JSerializer_2076805380.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setShort1
		if (typeId == 1576112584) return com.wilutions.byps.test.api.remote.JSerializer_1576112584.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setString1
		if (typeId == 1268801635) return com.wilutions.byps.test.api.remote.JSerializer_1268801635.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getBoolean1
		if (typeId == 1800794520) return com.wilutions.byps.test.api.remote.JSerializer_1800794520.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getByte1
		if (typeId == 1790948870) return com.wilutions.byps.test.api.remote.JSerializer_1790948870.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getByte2
		if (typeId == 1790948869) return com.wilutions.byps.test.api.remote.JSerializer_1790948869.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getChar1
		if (typeId == 1790549652) return com.wilutions.byps.test.api.remote.JSerializer_1790549652.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getDouble1
		if (typeId == 1625335791) return com.wilutions.byps.test.api.remote.JSerializer_1625335791.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getFloat1
		if (typeId == 417520036) return com.wilutions.byps.test.api.remote.JSerializer_417520036.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getInt1
		if (typeId == 773709361) return com.wilutions.byps.test.api.remote.JSerializer_773709361.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getInt2
		if (typeId == 773709362) return com.wilutions.byps.test.api.remote.JSerializer_773709362.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getLong1
		if (typeId == 1782017274) return com.wilutions.byps.test.api.remote.JSerializer_1782017274.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getObj1
		if (typeId == 773876265) return com.wilutions.byps.test.api.remote.JSerializer_773876265.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getPrimitiveTypes1
		if (typeId == 929079504) return com.wilutions.byps.test.api.remote.JSerializer_929079504.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getShort1
		if (typeId == 786021252) return com.wilutions.byps.test.api.remote.JSerializer_786021252.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getString1
		if (typeId == 1057096751) return com.wilutions.byps.test.api.remote.JSerializer_1057096751.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setBoolean1
		if (typeId == 1712214692) return com.wilutions.byps.test.api.remote.JSerializer_1712214692.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setByte1
		if (typeId == 1942905966) return com.wilutions.byps.test.api.remote.JSerializer_1942905966.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setByte2
		if (typeId == 1942905967) return com.wilutions.byps.test.api.remote.JSerializer_1942905967.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setChar1
		if (typeId == 1943305184) return com.wilutions.byps.test.api.remote.JSerializer_1943305184.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setDouble1
		if (typeId == 311469445) return com.wilutions.byps.test.api.remote.JSerializer_311469445.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setFloat1
		if (typeId == 202902960) return com.wilutions.byps.test.api.remote.JSerializer_202902960.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setInt1
		if (typeId == 1461148355) return com.wilutions.byps.test.api.remote.JSerializer_1461148355.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setInt2
		if (typeId == 1461148354) return com.wilutions.byps.test.api.remote.JSerializer_1461148354.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setLong1
		if (typeId == 1951837562) return com.wilutions.byps.test.api.remote.JSerializer_1951837562.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setObj1
		if (typeId == 1460981451) return com.wilutions.byps.test.api.remote.JSerializer_1460981451.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setPrimitiveTypes1
		if (typeId == 9045852) return com.wilutions.byps.test.api.remote.JSerializer_9045852.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setShort1
		if (typeId == 571404176) return com.wilutions.byps.test.api.remote.JSerializer_571404176.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setString1
		if (typeId == 879708485) return com.wilutions.byps.test.api.remote.JSerializer_879708485.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_add
		if (typeId == 249123151) return com.wilutions.byps.test.api.remote.JSerializer_249123151.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getBool
		if (typeId == 1271040754) return com.wilutions.byps.test.api.remote.JSerializer_1271040754.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getByte
		if (typeId == 1271030996) return com.wilutions.byps.test.api.remote.JSerializer_1271030996.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getChar
		if (typeId == 1271018118) return com.wilutions.byps.test.api.remote.JSerializer_1271018118.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getDouble
		if (typeId == 1642021643) return com.wilutions.byps.test.api.remote.JSerializer_1642021643.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getFloat
		if (typeId == 743953224) return com.wilutions.byps.test.api.remote.JSerializer_743953224.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getInt
		if (typeId == 97552715) return com.wilutions.byps.test.api.remote.JSerializer_97552715.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getLong
		if (typeId == 1270742880) return com.wilutions.byps.test.api.remote.JSerializer_1270742880.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getObject
		if (typeId == 1339431837) return com.wilutions.byps.test.api.remote.JSerializer_1339431837.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getPrimitiveTypes
		if (typeId == 1838927626) return com.wilutions.byps.test.api.remote.JSerializer_1838927626.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getShort
		if (typeId == 732066088) return com.wilutions.byps.test.api.remote.JSerializer_732066088.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getString
		if (typeId == 1208049355) return com.wilutions.byps.test.api.remote.JSerializer_1208049355.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_sendAllTypes
		if (typeId == 942211602) return com.wilutions.byps.test.api.remote.JSerializer_942211602.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setBool
		if (typeId == 789068826) return com.wilutions.byps.test.api.remote.JSerializer_789068826.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setByte
		if (typeId == 789078584) return com.wilutions.byps.test.api.remote.JSerializer_789078584.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setChar
		if (typeId == 789091462) return com.wilutions.byps.test.api.remote.JSerializer_789091462.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setDouble
		if (typeId == 1856638719) return com.wilutions.byps.test.api.remote.JSerializer_1856638719.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setFloat
		if (typeId == 1305065684) return com.wilutions.byps.test.api.remote.JSerializer_1305065684.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setInt
		if (typeId == 441102527) return com.wilutions.byps.test.api.remote.JSerializer_441102527.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setLong
		if (typeId == 789366700) return com.wilutions.byps.test.api.remote.JSerializer_789366700.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setObject
		if (typeId == 1554048913) return com.wilutions.byps.test.api.remote.JSerializer_1554048913.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setPrimitiveTypes
		if (typeId == 1515886850) return com.wilutions.byps.test.api.remote.JSerializer_1515886850.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setShort
		if (typeId == 1293178548) return com.wilutions.byps.test.api.remote.JSerializer_1293178548.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setString
		if (typeId == 1422666431) return com.wilutions.byps.test.api.remote.JSerializer_1422666431.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_voidFunctionVoid
		if (typeId == 1763813202) return com.wilutions.byps.test.api.remote.JSerializer_1763813202.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteReferences_getNode
		if (typeId == 1480397220) return com.wilutions.byps.test.api.remote.JSerializer_1480397220.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteReferences_setNode
		if (typeId == 579712360) return com.wilutions.byps.test.api.remote.JSerializer_579712360.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getBoolean1
		if (typeId == 571606866) return com.wilutions.byps.test.api.remote.JSerializer_571606866.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getByte1
		if (typeId == 1727045248) return com.wilutions.byps.test.api.remote.JSerializer_1727045248.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getByte2
		if (typeId == 1727045249) return com.wilutions.byps.test.api.remote.JSerializer_1727045249.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getChar1
		if (typeId == 1727444466) return com.wilutions.byps.test.api.remote.JSerializer_1727444466.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getDouble1
		if (typeId == 972250345) return com.wilutions.byps.test.api.remote.JSerializer_972250345.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getFloat1
		if (typeId == 2101155294) return com.wilutions.byps.test.api.remote.JSerializer_2101155294.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getInt1
		if (typeId == 1718477035) return com.wilutions.byps.test.api.remote.JSerializer_1718477035.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getInt2
		if (typeId == 1718477036) return com.wilutions.byps.test.api.remote.JSerializer_1718477036.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getLong1
		if (typeId == 1735976844) return com.wilutions.byps.test.api.remote.JSerializer_1735976844.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getObj1
		if (typeId == 1718643939) return com.wilutions.byps.test.api.remote.JSerializer_1718643939.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getPrimitiveTypes1
		if (typeId == 950813750) return com.wilutions.byps.test.api.remote.JSerializer_950813750.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getShort1
		if (typeId == 1825310786) return com.wilutions.byps.test.api.remote.JSerializer_1825310786.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getString1
		if (typeId == 404011305) return com.wilutions.byps.test.api.remote.JSerializer_404011305.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setBoolean1
		if (typeId == 483027038) return com.wilutions.byps.test.api.remote.JSerializer_483027038.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setByte1
		if (typeId == 1165932788) return com.wilutions.byps.test.api.remote.JSerializer_1165932788.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setByte2
		if (typeId == 1165932789) return com.wilutions.byps.test.api.remote.JSerializer_1165932789.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setChar1
		if (typeId == 1166332006) return com.wilutions.byps.test.api.remote.JSerializer_1166332006.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setDouble1
		if (typeId == 964554891) return com.wilutions.byps.test.api.remote.JSerializer_964554891.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setFloat1
		if (typeId == 1886538218) return com.wilutions.byps.test.api.remote.JSerializer_1886538218.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setInt1
		if (typeId == 516380681) return com.wilutions.byps.test.api.remote.JSerializer_516380681.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setInt2
		if (typeId == 516380680) return com.wilutions.byps.test.api.remote.JSerializer_516380680.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setLong1
		if (typeId == 1174864384) return com.wilutions.byps.test.api.remote.JSerializer_1174864384.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setObj1
		if (typeId == 516213777) return com.wilutions.byps.test.api.remote.JSerializer_516213777.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setPrimitiveTypes1
		if (typeId == 1870847402) return com.wilutions.byps.test.api.remote.JSerializer_1870847402.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setShort1
		if (typeId == 2039927862) return com.wilutions.byps.test.api.remote.JSerializer_2039927862.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setString1
		if (typeId == 1532793931) return com.wilutions.byps.test.api.remote.JSerializer_1532793931.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImage
		if (typeId == 115426612) return com.wilutions.byps.test.api.remote.JSerializer_115426612.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImages
		if (typeId == 716742439) return com.wilutions.byps.test.api.remote.JSerializer_716742439.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getTextStream
		if (typeId == 1795991492) return com.wilutions.byps.test.api.remote.JSerializer_1795991492.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImage
		if (typeId == 676539072) return com.wilutions.byps.test.api.remote.JSerializer_676539072.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImages
		if (typeId == 502125363) return com.wilutions.byps.test.api.remote.JSerializer_502125363.instance;
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_throwLastException
		if (typeId == 1243858054) return com.wilutions.byps.test.api.remote.JSerializer_1243858054.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim
		if (typeId == 1557084481) return com.wilutions.byps.test.api.remote.JSerializer_1557084481.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim
		if (typeId == 1557173854) return com.wilutions.byps.test.api.remote.JSerializer_1557173854.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteEnums
		if (typeId == 359349400) return com.wilutions.byps.test.api.remote.JSerializer_359349400.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance
		if (typeId == 1206670536) return com.wilutions.byps.test.api.remote.JSerializer_1206670536.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteListTypes
		if (typeId == 380156079) return com.wilutions.byps.test.api.remote.JSerializer_380156079.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes
		if (typeId == 80483097) return com.wilutions.byps.test.api.remote.JSerializer_80483097.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes
		if (typeId == 1341983932) return com.wilutions.byps.test.api.remote.JSerializer_1341983932.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteReferences
		if (typeId == 2086824050) return com.wilutions.byps.test.api.remote.JSerializer_2086824050.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes
		if (typeId == 1156008353) return com.wilutions.byps.test.api.remote.JSerializer_1156008353.instance;
		// com.wilutions.byps.test.api.remote.BStub_RemoteStreams
		if (typeId == 2028487863) return com.wilutions.byps.test.api.remote.JSerializer_2028487863.instance;
		// com.wilutions.byps.test.api.set.SetTypes
		if (typeId == 5001) return com.wilutions.byps.test.api.set.JSerializer_5001.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_getStreams
		if (typeId == 865920738) return com.wilutions.byps.test.api.srvr.JSerializer_865920738.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_incrementInt
		if (typeId == 1461829915) return com.wilutions.byps.test.api.srvr.JSerializer_1461829915.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_putStreams
		if (typeId == 242798857) return com.wilutions.byps.test.api.srvr.JSerializer_242798857.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
		if (typeId == 1352392091) return com.wilutions.byps.test.api.srvr.JSerializer_1352392091.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
		if (typeId == 1252575894) return com.wilutions.byps.test.api.srvr.JSerializer_1252575894.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientParallel
		if (typeId == 1340180893) return com.wilutions.byps.test.api.srvr.JSerializer_1340180893.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClient
		if (typeId == 2107407220) return com.wilutions.byps.test.api.srvr.JSerializer_2107407220.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClientIds
		if (typeId == 2063368540) return com.wilutions.byps.test.api.srvr.JSerializer_2063368540.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getPartner
		if (typeId == 748402113) return com.wilutions.byps.test.api.srvr.JSerializer_748402113.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
		if (typeId == 1415283169) return com.wilutions.byps.test.api.srvr.JSerializer_1415283169.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
		if (typeId == 1367013829) return com.wilutions.byps.test.api.srvr.JSerializer_1367013829.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
		if (typeId == 1921080901) return com.wilutions.byps.test.api.srvr.JSerializer_1921080901.instance;
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_setPartner
		if (typeId == 1188403123) return com.wilutions.byps.test.api.srvr.JSerializer_1188403123.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_getStreams
		if (typeId == 1897164468) return com.wilutions.byps.test.api.srvr.JSerializer_1897164468.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_incrementInt
		if (typeId == 1720916535) return com.wilutions.byps.test.api.srvr.JSerializer_1720916535.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_putStreams
		if (typeId == 1274042587) return com.wilutions.byps.test.api.srvr.JSerializer_1274042587.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_sendChat
		if (typeId == 1101039945) return com.wilutions.byps.test.api.srvr.JSerializer_1101039945.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_callClientIncrementInt
		if (typeId == 846649496) return com.wilutions.byps.test.api.srvr.JSerializer_846649496.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_callClientParallel
		if (typeId == 586866833) return com.wilutions.byps.test.api.srvr.JSerializer_586866833.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getClient
		if (typeId == 1309389154) return com.wilutions.byps.test.api.srvr.JSerializer_1309389154.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getClientIds
		if (typeId == 1119377910) return com.wilutions.byps.test.api.srvr.JSerializer_1119377910.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getPartner
		if (typeId == 282841617) return com.wilutions.byps.test.api.srvr.JSerializer_282841617.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getStreamsFromClient
		if (typeId == 2117724017) return com.wilutions.byps.test.api.srvr.JSerializer_2117724017.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_putStreamsOnClient
		if (typeId == 1000905741) return com.wilutions.byps.test.api.srvr.JSerializer_1000905741.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_registerWithClientMap
		if (typeId == 227959465) return com.wilutions.byps.test.api.srvr.JSerializer_227959465.instance;
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_setPartner
		if (typeId == 2075320443) return com.wilutions.byps.test.api.srvr.JSerializer_2075320443.instance;
		// com.wilutions.byps.test.api.srvr.BStub_ClientIF
		if (typeId == 1784257353) return com.wilutions.byps.test.api.srvr.JSerializer_1784257353.instance;
		// com.wilutions.byps.test.api.srvr.BStub_ServerIF
		if (typeId == 1313562065) return com.wilutions.byps.test.api.srvr.JSerializer_1313562065.instance;
		// com.wilutions.byps.test.api.srvr.ChatStructure
		if (typeId == 7007) return com.wilutions.byps.test.api.srvr.JSerializer_7007.instance;
		// com.wilutions.byps.test.api.strm.Stream1
		if (typeId == 1541129345) return com.wilutions.byps.test.api.strm.JSerializer_1541129345.instance;
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getClient
		if (typeId == 98720592) return com.wilutions.byps.test.api.ver.JSerializer_98720592.instance;
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getEvolve
		if (typeId == 32041374) return com.wilutions.byps.test.api.ver.JSerializer_32041374.instance;
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
		if (typeId == 1425170268) return com.wilutions.byps.test.api.ver.JSerializer_1425170268.instance;
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setClient
		if (typeId == 313337668) return com.wilutions.byps.test.api.ver.JSerializer_313337668.instance;
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
		if (typeId == 246658450) return com.wilutions.byps.test.api.ver.JSerializer_246658450.instance;
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_getClient
		if (typeId == 811360678) return com.wilutions.byps.test.api.ver.JSerializer_811360678.instance;
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_getEvolve
		if (typeId == 744681460) return com.wilutions.byps.test.api.ver.JSerializer_744681460.instance;
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_sendEvolveToClient
		if (typeId == 1931893518) return com.wilutions.byps.test.api.ver.JSerializer_1931893518.instance;
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_setClient
		if (typeId == 1025977754) return com.wilutions.byps.test.api.ver.JSerializer_1025977754.instance;
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_setEvolve
		if (typeId == 959298536) return com.wilutions.byps.test.api.ver.JSerializer_959298536.instance;
		// com.wilutions.byps.test.api.ver.BStub_EvolveIF
		if (typeId == 2078696281) return com.wilutions.byps.test.api.ver.JSerializer_2078696281.instance;
		// com.wilutions.byps.test.api.ver.Evolve
		if (typeId == 1391985860) return com.wilutions.byps.test.api.ver.JSerializer_1391985860.instance;
		// com.wilutions.byps.test.api.ver.Evolve2
		if (typeId == 573592593) return com.wilutions.byps.test.api.ver.JSerializer_573592593.instance;
		// double[]
		if (typeId == 1359468275) return com.wilutions.byps.test.api.JSerializer_1359468275.instance;
		// double[][][][]
		if (typeId == 2087445849) return com.wilutions.byps.test.api.JSerializer_2087445849.instance;
		// float[]
		if (typeId == 766441794) return com.wilutions.byps.test.api.JSerializer_766441794.instance;
		// float[][][][]
		if (typeId == 1516687588) return com.wilutions.byps.test.api.JSerializer_1516687588.instance;
		// int[]
		if (typeId == 100361105) return com.wilutions.byps.test.api.JSerializer_100361105.instance;
		// int[][][][]
		if (typeId == 39910537) return com.wilutions.byps.test.api.JSerializer_39910537.instance;
		// java.io.InputStream[]
		if (typeId == 1950626768) return com.wilutions.byps.test.api.JSerializer_1950626768.instance;
		// java.lang.Object[]
		if (typeId == 183594037) return com.wilutions.byps.test.api.JSerializer_183594037.instance;
		// java.lang.Object[][][][]
		if (typeId == 124584219) return com.wilutions.byps.test.api.JSerializer_124584219.instance;
		// java.lang.String[]
		if (typeId == 1888107655) return com.wilutions.byps.test.api.JSerializer_1888107655.instance;
		// java.lang.String[][][][]
		if (typeId == 588723219) return com.wilutions.byps.test.api.JSerializer_588723219.instance;
		// java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
		if (typeId == 1590740862) return com.wilutions.byps.test.api.JSerializer_1590740862.instance;
		// java.util.HashMap<java.lang.Double,java.lang.Byte>
		if (typeId == 1972793385) return com.wilutions.byps.test.api.JSerializer_1972793385.instance;
		// java.util.HashSet<java.lang.Byte>
		if (typeId == 31512998) return com.wilutions.byps.test.api.JSerializer_31512998.instance;
		// java.util.List<byte[]>
		if (typeId == 1174971318) return com.wilutions.byps.test.api.JSerializer_1174971318.instance;
		// java.util.List<com.wilutions.byps.test.api.inherit.Class1>
		if (typeId == 317887457) return com.wilutions.byps.test.api.JSerializer_317887457.instance;
		// java.util.List<com.wilutions.byps.test.api.inl.Actor>
		if (typeId == 494001343) return com.wilutions.byps.test.api.JSerializer_494001343.instance;
		// java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
		if (typeId == 1544333227) return com.wilutions.byps.test.api.JSerializer_1544333227.instance;
		// java.util.List<com.wilutions.byps.test.api.refs.Node>
		if (typeId == 202657921) return com.wilutions.byps.test.api.JSerializer_202657921.instance;
		// java.util.List<int[]>
		if (typeId == 1752158699) return com.wilutions.byps.test.api.JSerializer_1752158699.instance;
		// java.util.List<int[][][][]>
		if (typeId == 1088217157) return com.wilutions.byps.test.api.JSerializer_1088217157.instance;
		// java.util.List<java.io.InputStream>
		if (typeId == 1218831438) return com.wilutions.byps.test.api.JSerializer_1218831438.instance;
		// java.util.List<java.lang.Boolean>
		if (typeId == 1617670280) return com.wilutions.byps.test.api.JSerializer_1617670280.instance;
		// java.util.List<java.lang.Byte>
		if (typeId == 1059148284) return com.wilutions.byps.test.api.JSerializer_1059148284.instance;
		// java.util.List<java.lang.Character>
		if (typeId == 1661807911) return com.wilutions.byps.test.api.JSerializer_1661807911.instance;
		// java.util.List<java.lang.Double>
		if (typeId == 1555345627) return com.wilutions.byps.test.api.JSerializer_1555345627.instance;
		// java.util.List<java.lang.Float>
		if (typeId == 1628501332) return com.wilutions.byps.test.api.JSerializer_1628501332.instance;
		// java.util.List<java.lang.Integer>
		if (typeId == 181681714) return com.wilutions.byps.test.api.JSerializer_181681714.instance;
		// java.util.List<java.lang.Long>
		if (typeId == 1050216688) return com.wilutions.byps.test.api.JSerializer_1050216688.instance;
		// java.util.List<java.lang.Short>
		if (typeId == 1997002548) return com.wilutions.byps.test.api.JSerializer_1997002548.instance;
		// java.util.List<java.lang.String>
		if (typeId == 2123584667) return com.wilutions.byps.test.api.JSerializer_2123584667.instance;
		// java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>
		if (typeId == 1398598597) return com.wilutions.byps.test.api.JSerializer_1398598597.instance;
		// java.util.List<java.util.List<int[][][][]>>
		if (typeId == 1865834185) return com.wilutions.byps.test.api.JSerializer_1865834185.instance;
		// java.util.List<java.util.List<java.lang.Integer>>
		if (typeId == 1746702954) return com.wilutions.byps.test.api.JSerializer_1746702954.instance;
		// java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
		if (typeId == 1633500852) return com.wilutions.byps.test.api.JSerializer_1633500852.instance;
		// java.util.List<java.util.TreeSet<java.lang.Integer>>
		if (typeId == 724129228) return com.wilutions.byps.test.api.JSerializer_724129228.instance;
		// java.util.Map<java.lang.Byte,java.lang.Double>
		if (typeId == 1487265161) return com.wilutions.byps.test.api.JSerializer_1487265161.instance;
		// java.util.Map<java.lang.Character,java.lang.Float>
		if (typeId == 94341197) return com.wilutions.byps.test.api.JSerializer_94341197.instance;
		// java.util.Map<java.lang.Integer,byte[]>
		if (typeId == 1799280818) return com.wilutions.byps.test.api.JSerializer_1799280818.instance;
		// java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>
		if (typeId == 1930448581) return com.wilutions.byps.test.api.JSerializer_1930448581.instance;
		// java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
		if (typeId == 703065817) return com.wilutions.byps.test.api.JSerializer_703065817.instance;
		// java.util.Map<java.lang.Integer,int[]>
		if (typeId == 1633750383) return com.wilutions.byps.test.api.JSerializer_1633750383.instance;
		// java.util.Map<java.lang.Integer,java.io.InputStream>
		if (typeId == 779528402) return com.wilutions.byps.test.api.JSerializer_779528402.instance;
		// java.util.Map<java.lang.Integer,java.lang.Integer>
		if (typeId == 1347703734) return com.wilutions.byps.test.api.JSerializer_1347703734.instance;
		// java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
		if (typeId == 132175071) return com.wilutions.byps.test.api.JSerializer_132175071.instance;
		// java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>
		if (typeId == 49984088) return com.wilutions.byps.test.api.JSerializer_49984088.instance;
		// java.util.Map<java.lang.Long,java.lang.Short>
		if (typeId == 601099730) return com.wilutions.byps.test.api.JSerializer_601099730.instance;
		// java.util.Map<java.lang.Short,java.lang.Long>
		if (typeId == 1973996106) return com.wilutions.byps.test.api.JSerializer_1973996106.instance;
		// java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>
		if (typeId == 252873856) return com.wilutions.byps.test.api.JSerializer_252873856.instance;
		// java.util.Map<java.lang.String,com.wilutions.byps.test.api.inherit.Class1>
		if (typeId == 981592984) return com.wilutions.byps.test.api.JSerializer_981592984.instance;
		// java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>
		if (typeId == 1768677016) return com.wilutions.byps.test.api.JSerializer_1768677016.instance;
		// java.util.Map<java.lang.String,java.lang.Boolean>
		if (typeId == 1279823631) return com.wilutions.byps.test.api.JSerializer_1279823631.instance;
		// java.util.Map<java.lang.String,java.lang.Object>
		if (typeId == 1488550492) return com.wilutions.byps.test.api.JSerializer_1488550492.instance;
		// java.util.Map<java.lang.String,java.lang.String>
		if (typeId == 1710660846) return com.wilutions.byps.test.api.JSerializer_1710660846.instance;
		// java.util.Set<byte[]>
		if (typeId == 2052431866) return com.wilutions.byps.test.api.JSerializer_2052431866.instance;
		// java.util.Set<com.wilutions.byps.test.api.inherit.Class1>
		if (typeId == 2114305573) return com.wilutions.byps.test.api.JSerializer_2114305573.instance;
		// java.util.Set<com.wilutions.byps.test.api.inl.Actor>
		if (typeId == 797794691) return com.wilutions.byps.test.api.JSerializer_797794691.instance;
		// java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
		if (typeId == 1280571537) return com.wilutions.byps.test.api.JSerializer_1280571537.instance;
		// java.util.Set<int[]>
		if (typeId == 1406124761) return com.wilutions.byps.test.api.JSerializer_1406124761.instance;
		// java.util.Set<java.lang.Boolean>
		if (typeId == 1365696060) return com.wilutions.byps.test.api.JSerializer_1365696060.instance;
		// java.util.Set<java.lang.Double>
		if (typeId == 1320560671) return com.wilutions.byps.test.api.JSerializer_1320560671.instance;
		// java.util.Set<java.lang.Float>
		if (typeId == 1898022288) return com.wilutions.byps.test.api.JSerializer_1898022288.instance;
		// java.util.Set<java.lang.Integer>
		if (typeId == 1493282670) return com.wilutions.byps.test.api.JSerializer_1493282670.instance;
		// java.util.Set<java.lang.Long>
		if (typeId == 1457164460) return com.wilutions.byps.test.api.JSerializer_1457164460.instance;
		// java.util.Set<java.lang.Short>
		if (typeId == 2028443792) return com.wilutions.byps.test.api.JSerializer_2028443792.instance;
		// java.util.Set<java.lang.String>
		if (typeId == 1888799711) return com.wilutions.byps.test.api.JSerializer_1888799711.instance;
		// java.util.TreeMap<java.lang.Float,java.lang.Character>
		if (typeId == 8789515) return com.wilutions.byps.test.api.JSerializer_8789515.instance;
		// java.util.TreeMap<java.lang.Integer,java.io.InputStream>
		if (typeId == 476459792) return com.wilutions.byps.test.api.JSerializer_476459792.instance;
		// java.util.TreeSet<java.lang.Character>
		if (typeId == 936607009) return com.wilutions.byps.test.api.JSerializer_936607009.instance;
		// java.util.TreeSet<java.lang.Integer>
		if (typeId == 855786668) return com.wilutions.byps.test.api.JSerializer_855786668.instance;
		// long[]
		if (typeId == 1097129250) return com.wilutions.byps.test.api.JSerializer_1097129250.instance;
		// long[][][][]
		if (typeId == 846419204) return com.wilutions.byps.test.api.JSerializer_846419204.instance;
		// short[]
		if (typeId == 2067161310) return com.wilutions.byps.test.api.JSerializer_2067161310.instance;
		// short[][][][]
		if (typeId == 1859644668) return com.wilutions.byps.test.api.JSerializer_1859644668.instance;
		return null;
	};
}
