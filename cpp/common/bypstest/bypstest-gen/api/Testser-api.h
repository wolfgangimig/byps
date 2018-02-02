#ifndef __Testser_api_H__
#define __Testser_api_H__

#include "Byps.h"

//--------------------------------------------------------
// Forward Definitions for Namespace byps
//--------------------------------------------------------

namespace byps {

	// byps.BValueClass
	class BValueClass; 
	typedef byps_ptr< BValueClass > PBValueClass; 
	
	// java.lang.Object
	class BSerializable; 
	typedef byps_ptr< BSerializable > PSerializable; 
	
	// java.io.InputStream[]
	typedef ::byps::BArray1< PContentStream >  BArrayInputStream;
	typedef byps_ptr< BArrayInputStream > PArrayInputStream;
	
	// java.lang.Object[]
	typedef ::byps::BArray1< PSerializable >  BArrayObject;
	typedef byps_ptr< BArrayObject > PArrayObject;
	
	// java.lang.Object[][]
	typedef ::byps::BArray2< PSerializable >  BArray2Object;
	typedef byps_ptr< BArray2Object > PArray2Object;
	
	// java.lang.Object[][][]
	typedef ::byps::BArray3< PSerializable >  BArray3Object;
	typedef byps_ptr< BArray3Object > PArray3Object;
	
	// java.lang.Object[][][][]
	typedef ::byps::BArray4< PSerializable >  BArray4Object;
	typedef byps_ptr< BArray4Object > PArray4Object;
	
	// java.lang.String[]
	typedef ::byps::BArray1< ::std::wstring >  BArrayString;
	typedef byps_ptr< BArrayString > PArrayString;
	
	// java.lang.String[][]
	typedef ::byps::BArray2< ::std::wstring >  BArray2String;
	typedef byps_ptr< BArray2String > PArray2String;
	
	// java.lang.String[][][]
	typedef ::byps::BArray3< ::std::wstring >  BArray3String;
	typedef byps_ptr< BArray3String > PArray3String;
	
	// java.lang.String[][][][]
	typedef ::byps::BArray4< ::std::wstring >  BArray4String;
	typedef byps_ptr< BArray4String > PArray4String;
	
	// java.util.Date[]
	typedef ::byps::BArray1< BDateTime >  BArrayDate;
	typedef byps_ptr< BArrayDate > PArrayDate;
	
	// java.util.Date[][][][]
	typedef ::byps::BArray4< BDateTime >  BArray4Date;
	typedef byps_ptr< BArray4Date > PArray4Date;
	
	// java.util.HashMap<java.lang.Double,java.lang.Byte>
	typedef ::std::map< double , int8_t > BMapDoubleByte;
	typedef byps_ptr< BMapDoubleByte > PMapDoubleByte;
	
	// java.util.HashSet<java.lang.Byte>
	typedef ::std::set< int8_t > BSetByte;
	typedef byps_ptr< BSetByte > PSetByte;
	
	// java.util.List<java.io.InputStream>
	typedef ::std::vector< PContentStream > BVectorInputStream;
	typedef byps_ptr< BVectorInputStream > PVectorInputStream;
	
	// java.util.List<java.lang.Boolean>
	typedef ::std::vector< bool > BVectorBoolean;
	typedef byps_ptr< BVectorBoolean > PVectorBoolean;
	
	// java.util.List<java.lang.Byte>
	typedef ::std::vector< int8_t > BVectorByte;
	typedef byps_ptr< BVectorByte > PVectorByte;
	
	// java.util.List<java.lang.Character>
	typedef ::std::vector< wchar_t > BVectorCharacter;
	typedef byps_ptr< BVectorCharacter > PVectorCharacter;
	
	// java.util.List<java.lang.Double>
	typedef ::std::vector< double > BVectorDouble;
	typedef byps_ptr< BVectorDouble > PVectorDouble;
	
	// java.util.List<java.lang.Float>
	typedef ::std::vector< float > BVectorFloat;
	typedef byps_ptr< BVectorFloat > PVectorFloat;
	
	// java.util.List<java.lang.Integer>
	typedef ::std::vector< int32_t > BVectorInteger;
	typedef byps_ptr< BVectorInteger > PVectorInteger;
	
	// java.util.List<java.lang.Long>
	typedef ::std::vector< int64_t > BVectorLong;
	typedef byps_ptr< BVectorLong > PVectorLong;
	
	// java.util.List<java.lang.Object>
	typedef ::std::vector< PSerializable > BVectorObject;
	typedef byps_ptr< BVectorObject > PVectorObject;
	
	// java.util.List<java.lang.Short>
	typedef ::std::vector< int16_t > BVectorShort;
	typedef byps_ptr< BVectorShort > PVectorShort;
	
	// java.util.List<java.lang.String>
	typedef ::std::vector< ::std::wstring > BVectorString;
	typedef byps_ptr< BVectorString > PVectorString;
	
	// java.util.List<java.util.Date>
	typedef ::std::vector< BDateTime > BVectorDate;
	typedef byps_ptr< BVectorDate > PVectorDate;
	
	// java.util.Map<java.lang.Byte,java.lang.Double>
	typedef ::std::map< int8_t , double > BMapByteDouble;
	typedef byps_ptr< BMapByteDouble > PMapByteDouble;
	
	// java.util.Map<java.lang.Character,java.lang.Float>
	typedef ::std::map< wchar_t , float > BMapCharacterFloat;
	typedef byps_ptr< BMapCharacterFloat > PMapCharacterFloat;
	
	// java.util.Map<java.lang.Integer,java.io.InputStream>
	typedef ::std::map< int32_t , PContentStream > BMapIntegerInputStream;
	typedef byps_ptr< BMapIntegerInputStream > PMapIntegerInputStream;
	
	// java.util.Map<java.lang.Integer,java.lang.Integer>
	typedef ::std::map< int32_t , int32_t > BMapIntegerInteger;
	typedef byps_ptr< BMapIntegerInteger > PMapIntegerInteger;
	
	// java.util.Map<java.lang.Long,java.lang.Short>
	typedef ::std::map< int64_t , int16_t > BMapLongShort;
	typedef byps_ptr< BMapLongShort > PMapLongShort;
	
	// java.util.Map<java.lang.Short,java.lang.Long>
	typedef ::std::map< int16_t , int64_t > BMapShortLong;
	typedef byps_ptr< BMapShortLong > PMapShortLong;
	
	// java.util.Map<java.lang.String,java.lang.Boolean>
	typedef ::std::map< ::std::wstring , bool > BMapStringBoolean;
	typedef byps_ptr< BMapStringBoolean > PMapStringBoolean;
	
	// java.util.Map<java.lang.String,java.lang.Object>
	typedef ::std::map< ::std::wstring , PSerializable > BMapStringObject;
	typedef byps_ptr< BMapStringObject > PMapStringObject;
	
	// java.util.Map<java.lang.String,java.lang.String>
	typedef ::std::map< ::std::wstring , ::std::wstring > BMapStringString;
	typedef byps_ptr< BMapStringString > PMapStringString;
	
	// java.util.Map<java.lang.String,java.util.Date>
	typedef ::std::map< ::std::wstring , BDateTime > BMapStringDate;
	typedef byps_ptr< BMapStringDate > PMapStringDate;
	
	// java.util.Set<java.lang.Boolean>
	typedef ::std::set< bool > BSetBoolean;
	typedef byps_ptr< BSetBoolean > PSetBoolean;
	
	// java.util.Set<java.lang.Double>
	typedef ::std::set< double > BSetDouble;
	typedef byps_ptr< BSetDouble > PSetDouble;
	
	// java.util.Set<java.lang.Float>
	typedef ::std::set< float > BSetFloat;
	typedef byps_ptr< BSetFloat > PSetFloat;
	
	// java.util.Set<java.lang.Integer>
	typedef ::std::set< int32_t > BSetInteger;
	typedef byps_ptr< BSetInteger > PSetInteger;
	
	// java.util.Set<java.lang.Long>
	typedef ::std::set< int64_t > BSetLong;
	typedef byps_ptr< BSetLong > PSetLong;
	
	// java.util.Set<java.lang.Short>
	typedef ::std::set< int16_t > BSetShort;
	typedef byps_ptr< BSetShort > PSetShort;
	
	// java.util.Set<java.lang.String>
	typedef ::std::set< ::std::wstring > BSetString;
	typedef byps_ptr< BSetString > PSetString;
	
	// java.util.Set<java.util.Date>
	typedef ::std::set< BDateTime > BSetDate;
	typedef byps_ptr< BSetDate > PSetDate;
	
	// java.util.TreeMap<java.lang.Float,java.lang.Character>
	typedef ::std::map< float , wchar_t > BMapFloatCharacter;
	typedef byps_ptr< BMapFloatCharacter > PMapFloatCharacter;
	
	// java.util.TreeMap<java.lang.Integer,java.io.InputStream>
	typedef ::std::map< int32_t , PContentStream > BMapIntegerInputStream;
	typedef byps_ptr< BMapIntegerInputStream > PMapIntegerInputStream;
	
	// java.util.TreeSet<java.lang.Character>
	typedef ::std::set< wchar_t > BSetCharacter;
	typedef byps_ptr< BSetCharacter > PSetCharacter;
	
	// java.util.TreeSet<java.lang.Integer>
	typedef ::std::set< int32_t > BSetInteger;
	typedef byps_ptr< BSetInteger > PSetInteger;
	
	
	//--------------------------------------------------------
	// Forward Definitions for Namespace byps::test::api
	//--------------------------------------------------------
	
	namespace test {
	
		namespace api {
		
			// boolean[]
			typedef ::byps::BArray1< bool >  BArrayBoolean;
			typedef byps_ptr< BArrayBoolean > PArrayBoolean;
			
			// boolean[][][][]
			typedef ::byps::BArray4< bool >  BArray4Boolean;
			typedef byps_ptr< BArray4Boolean > PArray4Boolean;
			
			// byte[][][][]
			typedef ::byps::BArray4< int8_t >  BArray4Byte;
			typedef byps_ptr< BArray4Byte > PArray4Byte;
			
			// char[]
			typedef ::byps::BArray1< wchar_t >  BArrayChar;
			typedef byps_ptr< BArrayChar > PArrayChar;
			
			// char[][][][]
			typedef ::byps::BArray4< wchar_t >  BArray4Char;
			typedef byps_ptr< BArray4Char > PArray4Char;
			
			// double[]
			typedef ::byps::BArray1< double >  BArrayDouble;
			typedef byps_ptr< BArrayDouble > PArrayDouble;
			
			// double[][][][]
			typedef ::byps::BArray4< double >  BArray4Double;
			typedef byps_ptr< BArray4Double > PArray4Double;
			
			// float[]
			typedef ::byps::BArray1< float >  BArrayFloat;
			typedef byps_ptr< BArrayFloat > PArrayFloat;
			
			// float[][][][]
			typedef ::byps::BArray4< float >  BArray4Float;
			typedef byps_ptr< BArray4Float > PArray4Float;
			
			// int[]
			typedef ::byps::BArray1< int32_t >  BArrayInt;
			typedef byps_ptr< BArrayInt > PArrayInt;
			
			// int[][]
			typedef ::byps::BArray2< int32_t >  BArray2Int;
			typedef byps_ptr< BArray2Int > PArray2Int;
			
			// int[][][]
			typedef ::byps::BArray3< int32_t >  BArray3Int;
			typedef byps_ptr< BArray3Int > PArray3Int;
			
			// int[][][][]
			typedef ::byps::BArray4< int32_t >  BArray4Int;
			typedef byps_ptr< BArray4Int > PArray4Int;
			
			// long[]
			typedef ::byps::BArray1< int64_t >  BArrayLong;
			typedef byps_ptr< BArrayLong > PArrayLong;
			
			// long[][][][]
			typedef ::byps::BArray4< int64_t >  BArray4Long;
			typedef byps_ptr< BArray4Long > PArray4Long;
			
			// short[]
			typedef ::byps::BArray1< int16_t >  BArrayShort;
			typedef byps_ptr< BArrayShort > PArrayShort;
			
			// short[][][][]
			typedef ::byps::BArray4< int16_t >  BArray4Short;
			typedef byps_ptr< BArray4Short > PArray4Short;
			
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::arr
			//--------------------------------------------------------
			
			namespace arr {
			
				// byps.test.api.arr.ArrayTypes1dim
				class ArrayTypes1dim; 
				typedef byps_ptr< ArrayTypes1dim > PArrayTypes1dim; 
				
				// byps.test.api.arr.ArrayTypes4dim
				class ArrayTypes4dim; 
				typedef byps_ptr< ArrayTypes4dim > PArrayTypes4dim; 
				
			} // byps::test::api::arr
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::auth
			//--------------------------------------------------------
			
			namespace auth {
			
				// byps.test.api.auth.SessionInfo
				class SessionInfo; 
				typedef byps_ptr< SessionInfo > PSessionInfo; 
				
			} // byps::test::api::auth
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::cons
			//--------------------------------------------------------
			
			namespace cons {
			
				// byps.test.api.cons.AllTypesC
				class AllTypesC; 
				typedef byps_ptr< AllTypesC > PAllTypesC; 
				
				// byps.test.api.cons.AllTypesZ
				class AllTypesZ; 
				typedef byps_ptr< AllTypesZ > PAllTypesZ; 
				
				// byps.test.api.cons.HebrewC
				class HebrewC; 
				typedef byps_ptr< HebrewC > PHebrewC; 
				
				// byps.test.api.cons.HebrewZ
				class HebrewZ; 
				typedef byps_ptr< HebrewZ > PHebrewZ; 
				
				// byps.test.api.cons.AllTypesZ[][]
				typedef ::byps::BArray2< byps::test::api::cons::PAllTypesZ >  BArray2AllTypesZ;
				typedef byps_ptr< BArray2AllTypesZ > PArray2AllTypesZ;
				
				// byps.test.api.cons.HebrewZ[]
				typedef ::byps::BArray1< byps::test::api::cons::PHebrewZ >  BArrayHebrewZ;
				typedef byps_ptr< BArrayHebrewZ > PArrayHebrewZ;
				
			} // byps::test::api::cons
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::enu
			//--------------------------------------------------------
			
			namespace enu {
			
				// byps.test.api.enu.EnumPlanets
				enum EnumPlanets : int32_t; 
				
				// byps.test.api.enu.UsePlanets
				class UsePlanets; 
				typedef byps_ptr< UsePlanets > PUsePlanets; 
				
				// byps.test.api.enu.EnumPlanets[]
				typedef ::byps::BArray1< byps::test::api::enu::EnumPlanets >  BArrayEnumPlanets;
				typedef byps_ptr< BArrayEnumPlanets > PArrayEnumPlanets;
				
				// java.util.ArrayList<byps.test.api.enu.EnumPlanets>
				typedef ::std::vector< byps::test::api::enu::EnumPlanets > BVectorEnumPlanets;
				typedef byps_ptr< BVectorEnumPlanets > PVectorEnumPlanets;
				
				// java.util.Map<java.lang.String,byps.test.api.enu.EnumPlanets>
				typedef ::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets > BMapStringEnumPlanets;
				typedef byps_ptr< BMapStringEnumPlanets > PMapStringEnumPlanets;
				
			} // byps::test::api::enu
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::inherit
			//--------------------------------------------------------
			
			namespace inherit {
			
				// byps.test.api.inherit.BStub_BioFruitService
				class BStub_BioFruitService; 
				typedef byps_ptr< BStub_BioFruitService > PStub_BioFruitService; 
				
				// byps.test.api.inherit.BStub_BioLemonService
				class BStub_BioLemonService; 
				typedef byps_ptr< BStub_BioLemonService > PStub_BioLemonService; 
				
				// byps.test.api.inherit.BStub_FruitService
				class BStub_FruitService; 
				typedef byps_ptr< BStub_FruitService > PStub_FruitService; 
				
				// byps.test.api.inherit.BStub_LemonService
				class BStub_LemonService; 
				typedef byps_ptr< BStub_LemonService > PStub_LemonService; 
				
				// byps.test.api.inherit.BStub_PlantService
				class BStub_PlantService; 
				typedef byps_ptr< BStub_PlantService > PStub_PlantService; 
				
				// byps.test.api.inherit.Class1
				class Class1; 
				typedef byps_ptr< Class1 > PClass1; 
				
				// byps.test.api.inherit.Class1Collections
				class Class1Collections; 
				typedef byps_ptr< Class1Collections > PClass1Collections; 
				
				// byps.test.api.inherit.Class2
				class Class2; 
				typedef byps_ptr< Class2 > PClass2; 
				
				// byps.test.api.inherit.Class3
				class Class3; 
				typedef byps_ptr< Class3 > PClass3; 
				
				// byps.test.api.inherit.BioFruitService
				class BioFruitService; 
				typedef byps_ptr< BioFruitService > PBioFruitService; 
				
				// byps.test.api.inherit.BioLemonService
				class BioLemonService; 
				typedef byps_ptr< BioLemonService > PBioLemonService; 
				
				// byps.test.api.inherit.FruitService
				class FruitService; 
				typedef byps_ptr< FruitService > PFruitService; 
				
				// byps.test.api.inherit.LemonService
				class LemonService; 
				typedef byps_ptr< LemonService > PLemonService; 
				
				// byps.test.api.inherit.PlantService
				class PlantService; 
				typedef byps_ptr< PlantService > PPlantService; 
				
				// byps.test.api.inherit.BioFruitServiceAuth
				class BioFruitServiceAuth; 
				typedef byps_ptr< BioFruitServiceAuth > PBioFruitServiceAuth; 
				
				// byps.test.api.inherit.BioLemonServiceAuth
				class BioLemonServiceAuth; 
				typedef byps_ptr< BioLemonServiceAuth > PBioLemonServiceAuth; 
				
				// byps.test.api.inherit.FruitServiceAuth
				class FruitServiceAuth; 
				typedef byps_ptr< FruitServiceAuth > PFruitServiceAuth; 
				
				// byps.test.api.inherit.LemonServiceAuth
				class LemonServiceAuth; 
				typedef byps_ptr< LemonServiceAuth > PLemonServiceAuth; 
				
				// byps.test.api.inherit.PlantServiceAuth
				class PlantServiceAuth; 
				typedef byps_ptr< PlantServiceAuth > PPlantServiceAuth; 
				
				// java.util.List<byps.test.api.inherit.Class1>
				typedef ::std::vector< byps::test::api::inherit::PClass1 > BVectorClass1;
				typedef byps_ptr< BVectorClass1 > PVectorClass1;
				
				// java.util.Map<java.lang.String,byps.test.api.inherit.Class1>
				typedef ::std::map< ::std::wstring , byps::test::api::inherit::PClass1 > BMapStringClass1;
				typedef byps_ptr< BMapStringClass1 > PMapStringClass1;
				
			} // byps::test::api::inherit
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::inl
			//--------------------------------------------------------
			
			namespace inl {
			
				// byps.test.api.inl.Actor
				class Actor; 
				typedef byps_ptr< Actor > PActor; 
				
				// byps.test.api.inl.Matrix2D
				class Matrix2D; 
				
				// byps.test.api.inl.Point2D
				class Point2D; 
				
				// byps.test.api.inl.Point2D[]
				typedef ::byps::BArray1< byps::test::api::inl::Point2D >  BArrayPoint2D;
				typedef byps_ptr< BArrayPoint2D > PArrayPoint2D;
				
				// byps.test.api.inl.Point2D[][]
				typedef ::byps::BArray2< byps::test::api::inl::Point2D >  BArray2Point2D;
				typedef byps_ptr< BArray2Point2D > PArray2Point2D;
				
				// byps.test.api.inl.Point2D[][][]
				typedef ::byps::BArray3< byps::test::api::inl::Point2D >  BArray3Point2D;
				typedef byps_ptr< BArray3Point2D > PArray3Point2D;
				
				// byps.test.api.inl.Point2D[][][][]
				typedef ::byps::BArray4< byps::test::api::inl::Point2D >  BArray4Point2D;
				typedef byps_ptr< BArray4Point2D > PArray4Point2D;
				
				// java.util.List<byps.test.api.inl.Point2D>
				typedef ::std::vector< byps::test::api::inl::Point2D > BVectorPoint2D;
				typedef byps_ptr< BVectorPoint2D > PVectorPoint2D;
				
				// java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
				typedef ::std::map< int32_t , byps::test::api::inl::Point2D > BMapIntegerPoint2D;
				typedef byps_ptr< BMapIntegerPoint2D > PMapIntegerPoint2D;
				
			} // byps::test::api::inl
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::list
			//--------------------------------------------------------
			
			namespace list {
			
				// byps.test.api.list.ListListTypes
				class ListListTypes; 
				typedef byps_ptr< ListListTypes > PListListTypes; 
				
				// byps.test.api.list.ListTypes
				class ListTypes; 
				typedef byps_ptr< ListTypes > PListTypes; 
				
			} // byps::test::api::list
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::map
			//--------------------------------------------------------
			
			namespace map {
			
				// byps.test.api.map.MapTypes
				class MapTypes; 
				typedef byps_ptr< MapTypes > PMapTypes; 
				
			} // byps::test::api::map
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::prim
			//--------------------------------------------------------
			
			namespace prim {
			
				// byps.test.api.prim.PrimitiveTypes
				class PrimitiveTypes; 
				typedef byps_ptr< PrimitiveTypes > PPrimitiveTypes; 
				
				// byps.test.api.prim.PrimitiveTypes[]
				typedef ::byps::BArray1< byps::test::api::prim::PPrimitiveTypes >  BArrayPrimitiveTypes;
				typedef byps_ptr< BArrayPrimitiveTypes > PArrayPrimitiveTypes;
				
				// byps.test.api.prim.PrimitiveTypes[][]
				typedef ::byps::BArray2< byps::test::api::prim::PPrimitiveTypes >  BArray2PrimitiveTypes;
				typedef byps_ptr< BArray2PrimitiveTypes > PArray2PrimitiveTypes;
				
				// byps.test.api.prim.PrimitiveTypes[][][]
				typedef ::byps::BArray3< byps::test::api::prim::PPrimitiveTypes >  BArray3PrimitiveTypes;
				typedef byps_ptr< BArray3PrimitiveTypes > PArray3PrimitiveTypes;
				
				// byps.test.api.prim.PrimitiveTypes[][][][]
				typedef ::byps::BArray4< byps::test::api::prim::PPrimitiveTypes >  BArray4PrimitiveTypes;
				typedef byps_ptr< BArray4PrimitiveTypes > PArray4PrimitiveTypes;
				
				// java.util.List<byps.test.api.prim.PrimitiveTypes>
				typedef ::std::vector< byps::test::api::prim::PPrimitiveTypes > BVectorPrimitiveTypes;
				typedef byps_ptr< BVectorPrimitiveTypes > PVectorPrimitiveTypes;
				
				// java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
				typedef ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > BMapIntegerPrimitiveTypes;
				typedef byps_ptr< BMapIntegerPrimitiveTypes > PMapIntegerPrimitiveTypes;
				
			} // byps::test::api::prim
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::priv
			//--------------------------------------------------------
			
			namespace priv {
			
				// byps.test.api.priv.PrivateMembers
				class PrivateMembers; 
				typedef byps_ptr< PrivateMembers > PPrivateMembers; 
				
			} // byps::test::api::priv
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::refs
			//--------------------------------------------------------
			
			namespace refs {
			
				// byps.test.api.refs.Node
				class Node; 
				typedef byps_ptr< Node > PNode; 
				
				// java.util.List<byps.test.api.refs.Node>
				typedef ::std::vector< byps::test::api::refs::PNode > BVectorNode;
				typedef byps_ptr< BVectorNode > PVectorNode;
				
				// java.util.Map<java.lang.String,byps.test.api.refs.Node>
				typedef ::std::map< ::std::wstring , byps::test::api::refs::PNode > BMapStringNode;
				typedef byps_ptr< BMapStringNode > PMapStringNode;
				
			} // byps::test::api::refs
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::remote
			//--------------------------------------------------------
			
			namespace remote {
			
				// byps.test.api.remote.BStub_RemoteArrayTypes1dim
				class BStub_RemoteArrayTypes1dim; 
				typedef byps_ptr< BStub_RemoteArrayTypes1dim > PStub_RemoteArrayTypes1dim; 
				
				// byps.test.api.remote.BStub_RemoteArrayTypes23
				class BStub_RemoteArrayTypes23; 
				typedef byps_ptr< BStub_RemoteArrayTypes23 > PStub_RemoteArrayTypes23; 
				
				// byps.test.api.remote.BStub_RemoteArrayTypes4dim
				class BStub_RemoteArrayTypes4dim; 
				typedef byps_ptr< BStub_RemoteArrayTypes4dim > PStub_RemoteArrayTypes4dim; 
				
				// byps.test.api.remote.BStub_RemoteConstants
				class BStub_RemoteConstants; 
				typedef byps_ptr< BStub_RemoteConstants > PStub_RemoteConstants; 
				
				// byps.test.api.remote.BStub_RemoteEnums
				class BStub_RemoteEnums; 
				typedef byps_ptr< BStub_RemoteEnums > PStub_RemoteEnums; 
				
				// byps.test.api.remote.BStub_RemoteInlineInstance
				class BStub_RemoteInlineInstance; 
				typedef byps_ptr< BStub_RemoteInlineInstance > PStub_RemoteInlineInstance; 
				
				// byps.test.api.remote.BStub_RemoteListTypes
				class BStub_RemoteListTypes; 
				typedef byps_ptr< BStub_RemoteListTypes > PStub_RemoteListTypes; 
				
				// byps.test.api.remote.BStub_RemoteMapTypes
				class BStub_RemoteMapTypes; 
				typedef byps_ptr< BStub_RemoteMapTypes > PStub_RemoteMapTypes; 
				
				// byps.test.api.remote.BStub_RemotePrimitiveTypes
				class BStub_RemotePrimitiveTypes; 
				typedef byps_ptr< BStub_RemotePrimitiveTypes > PStub_RemotePrimitiveTypes; 
				
				// byps.test.api.remote.BStub_RemoteReferences
				class BStub_RemoteReferences; 
				typedef byps_ptr< BStub_RemoteReferences > PStub_RemoteReferences; 
				
				// byps.test.api.remote.BStub_RemoteServerCtrl
				class BStub_RemoteServerCtrl; 
				typedef byps_ptr< BStub_RemoteServerCtrl > PStub_RemoteServerCtrl; 
				
				// byps.test.api.remote.BStub_RemoteSetTypes
				class BStub_RemoteSetTypes; 
				typedef byps_ptr< BStub_RemoteSetTypes > PStub_RemoteSetTypes; 
				
				// byps.test.api.remote.BStub_RemoteStreams
				class BStub_RemoteStreams; 
				typedef byps_ptr< BStub_RemoteStreams > PStub_RemoteStreams; 
				
				// byps.test.api.remote.BStub_RemoteWithAuthentication
				class BStub_RemoteWithAuthentication; 
				typedef byps_ptr< BStub_RemoteWithAuthentication > PStub_RemoteWithAuthentication; 
				
				// byps.test.api.remote.RemoteArrayTypes1dim
				class RemoteArrayTypes1dim; 
				typedef byps_ptr< RemoteArrayTypes1dim > PRemoteArrayTypes1dim; 
				
				// byps.test.api.remote.RemoteArrayTypes23
				class RemoteArrayTypes23; 
				typedef byps_ptr< RemoteArrayTypes23 > PRemoteArrayTypes23; 
				
				// byps.test.api.remote.RemoteArrayTypes4dim
				class RemoteArrayTypes4dim; 
				typedef byps_ptr< RemoteArrayTypes4dim > PRemoteArrayTypes4dim; 
				
				// byps.test.api.remote.RemoteConstants
				class RemoteConstants; 
				typedef byps_ptr< RemoteConstants > PRemoteConstants; 
				
				// byps.test.api.remote.RemoteEnums
				class RemoteEnums; 
				typedef byps_ptr< RemoteEnums > PRemoteEnums; 
				
				// byps.test.api.remote.RemoteInlineInstance
				class RemoteInlineInstance; 
				typedef byps_ptr< RemoteInlineInstance > PRemoteInlineInstance; 
				
				// byps.test.api.remote.RemoteListTypes
				class RemoteListTypes; 
				typedef byps_ptr< RemoteListTypes > PRemoteListTypes; 
				
				// byps.test.api.remote.RemoteMapTypes
				class RemoteMapTypes; 
				typedef byps_ptr< RemoteMapTypes > PRemoteMapTypes; 
				
				// byps.test.api.remote.RemotePrimitiveTypes
				class RemotePrimitiveTypes; 
				typedef byps_ptr< RemotePrimitiveTypes > PRemotePrimitiveTypes; 
				
				// byps.test.api.remote.RemoteReferences
				class RemoteReferences; 
				typedef byps_ptr< RemoteReferences > PRemoteReferences; 
				
				// byps.test.api.remote.RemoteServerCtrl
				class RemoteServerCtrl; 
				typedef byps_ptr< RemoteServerCtrl > PRemoteServerCtrl; 
				
				// byps.test.api.remote.RemoteSetTypes
				class RemoteSetTypes; 
				typedef byps_ptr< RemoteSetTypes > PRemoteSetTypes; 
				
				// byps.test.api.remote.RemoteStreams
				class RemoteStreams; 
				typedef byps_ptr< RemoteStreams > PRemoteStreams; 
				
				// byps.test.api.remote.RemoteWithAuthentication
				class RemoteWithAuthentication; 
				typedef byps_ptr< RemoteWithAuthentication > PRemoteWithAuthentication; 
				
				// byps.test.api.remote.RemoteWithAuthenticationAuth
				class RemoteWithAuthenticationAuth; 
				typedef byps_ptr< RemoteWithAuthenticationAuth > PRemoteWithAuthenticationAuth; 
				
			} // byps::test::api::remote
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::set
			//--------------------------------------------------------
			
			namespace set {
			
				// byps.test.api.set.SetTypes
				class SetTypes; 
				typedef byps_ptr< SetTypes > PSetTypes; 
				
			} // byps::test::api::set
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::srvr
			//--------------------------------------------------------
			
			namespace srvr {
			
				// byps.test.api.srvr.BStub_ClientIF
				class BStub_ClientIF; 
				typedef byps_ptr< BStub_ClientIF > PStub_ClientIF; 
				
				// byps.test.api.srvr.BStub_ServerIF
				class BStub_ServerIF; 
				typedef byps_ptr< BStub_ServerIF > PStub_ServerIF; 
				
				// byps.test.api.srvr.ChatStructure
				class ChatStructure; 
				typedef byps_ptr< ChatStructure > PChatStructure; 
				
				// byps.test.api.srvr.ClientIF
				class ClientIF; 
				typedef byps_ptr< ClientIF > PClientIF; 
				
				// byps.test.api.srvr.ServerIF
				class ServerIF; 
				typedef byps_ptr< ServerIF > PServerIF; 
				
			} // byps::test::api::srvr
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::strm
			//--------------------------------------------------------
			
			namespace strm {
			
				// byps.test.api.strm.Stream1
				class Stream1; 
				typedef byps_ptr< Stream1 > PStream1; 
				
			} // byps::test::api::strm
			
			//--------------------------------------------------------
			// Forward Definitions for Namespace byps::test::api::ver
			//--------------------------------------------------------
			
			namespace ver {
			
				// byps.test.api.ver.BStub_EvolveIF
				class BStub_EvolveIF; 
				typedef byps_ptr< BStub_EvolveIF > PStub_EvolveIF; 
				
				// byps.test.api.ver.Evolve
				class Evolve; 
				typedef byps_ptr< Evolve > PEvolve; 
				
				// byps.test.api.ver.Evolve2
				class Evolve2; 
				typedef byps_ptr< Evolve2 > PEvolve2; 
				
				// byps.test.api.ver.EvolveIF
				class EvolveIF; 
				typedef byps_ptr< EvolveIF > PEvolveIF; 
				
			} // byps::test::api::ver
		} // byps::test::api
	} // byps::test
} // byps

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Matrix2D
// typeId=135329019

namespace byps { namespace test { namespace api { namespace inl { 

using namespace ::byps;

class Matrix2D : public BSerializable {
	public: float _11;
	public: float _12;
	public: float _13;
	public: float _21;
	public: float _22;
	public: float _23;
	public: float _31;
	public: float _32;
	public: float _33;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Matrix2D();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Matrix2D(float _11, float _12, float _13, float _21, float _22, float _23, float _31, float _32, float _33);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Point2D
// typeId=1835035436

namespace byps { namespace test { namespace api { namespace inl { 

using namespace ::byps;

/// <summary>
/// Example for an inline class.
/// </summary>
/// <remarks>
/// Final classes cannot be evolved or derived.
/// Objects of final classes are serialized without
/// the overhead of type and reference information.
/// This optimization is especially useful in the case of
/// large arrays of small objects being serialized.
/// </remarks>
class Point2D : public BSerializable {
	public: int16_t x;
	public: int16_t y;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Point2D();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Point2D(int16_t x, int16_t y);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// EnumPlanets
// typeId=1375035164

namespace byps { namespace test { namespace api { namespace enu { 


using namespace ::byps;

/// <summary>
/// Sample enum.
/// </summary>
enum EnumPlanets : int32_t  {
	/// <summary>
	/// ... is the closest planet to the Sun ...
	/// </summary>
	Mercury = 0,
	Venus = 1,
	Earth = 2,
	
};

void operator & (BIO& ar, EnumPlanets& e);

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// ArrayTypes1dim
// typeId=2001

namespace byps { namespace test { namespace api { namespace arr { 

using namespace ::byps;

class ArrayTypes1dim : public BSerializable {
	public: PArrayBoolean boolean1;
	public: PBytes byte1;
	public: PArrayChar char1;
	public: PArrayShort short1;
	public: PArrayInt int1;
	public: PArrayLong long1;
	public: PArrayFloat float1;
	public: PArrayDouble double1;
	public: PArrayString string1;
	public: PArrayDate date1;
	public: byps::test::api::prim::PArrayPrimitiveTypes primitiveTypes1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: ArrayTypes1dim();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: ArrayTypes1dim(const PArrayBoolean& boolean1, const PBytes& byte1, const PArrayChar& char1, const PArrayShort& short1, const PArrayInt& int1, const PArrayLong& long1, const PArrayFloat& float1, const PArrayDouble& double1, const PArrayString& string1, const PArrayDate& date1, const byps::test::api::prim::PArrayPrimitiveTypes& primitiveTypes1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// ArrayTypes4dim
// typeId=2004

namespace byps { namespace test { namespace api { namespace arr { 

using namespace ::byps;

class ArrayTypes4dim : public BSerializable {
	public: PArray4Boolean boolean4;
	public: PArray4Byte byte4;
	public: PArray4Char char4;
	public: PArray4Short short4;
	public: PArray4Int int4;
	public: PArray4Long long4;
	public: PArray4Float float4;
	public: PArray4Double double4;
	public: PArray4String string4;
	public: byps::test::api::prim::PArray4PrimitiveTypes primitiveTypes4;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: ArrayTypes4dim();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: ArrayTypes4dim(const PArray4Boolean& boolean4, const PArray4Byte& byte4, const PArray4Char& char4, const PArray4Short& short4, const PArray4Int& int4, const PArray4Long& long4, const PArray4Float& float4, const PArray4Double& double4, const PArray4String& string4, const byps::test::api::prim::PArray4PrimitiveTypes& primitiveTypes4);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// SessionInfo
// typeId=65775978

namespace byps { namespace test { namespace api { namespace auth { 

using namespace ::byps;

/// <summary>
/// Example for a session class.
/// </summary>
class SessionInfo : public BSerializable {
	public: ::std::wstring sessionID;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: SessionInfo();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: SessionInfo(const ::std::wstring& sessionID);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// AllTypesC
// typeId=930294276

namespace byps { namespace test { namespace api { namespace cons { 

using namespace ::byps;

class AllTypesC : public BSerializable {
	public: const static bool bool1s = true;
	public: const static bool bool2s = false;
	public: const static int8_t byte1s = (int8_t)1;
	public: const static wchar_t char1s = L'\u00bf';
	public: const static ::std::wstring stringNull;
	/// <summary>
	/// This constant holds the currency symbol for Euro.
	/// </summary>
	/// <remarks>
	/// It is defined "final static" and thus cannot be changed.
	/// </remarks>
	public: const static wchar_t char2s = L'\u20ac';
	public: const static int16_t short1s = (int16_t)3;
	public: const static int32_t int1s = 4;
	public: const static int64_t long1s = 6148914691236517205LL;
	public: const static float float1s;
	public: const static double double1s;
	public: const static ::std::wstring string1s;
	/// <summary>
	/// This defines a complex constant.
	/// </summary>
	/// <remarks>
	/// It is an instance of the class AllTypesZ.
	/// The field value cannot be changed, but it's contents could.
	/// </remarks>
	public: const static PAllTypesZ ALL;
	public: const static PArrayInt arrInt;
	public: const static PArray4Int arrInt4;
	public: const static PArrayString arrStrings;
	public: const static PArray4String arrStrings4;
	public: const static PArray2AllTypesZ arrALL;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: AllTypesC();
	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// AllTypesZ
// typeId=142458

namespace byps { namespace test { namespace api { namespace cons { 

using namespace ::byps;

class AllTypesZ : public BSerializable {
	private: bool bool1;
	private: int8_t byte1;
	private: wchar_t char1;
	private: int16_t short1;
	private: int32_t int1;
	private: int64_t long1;
	private: float float1;
	private: double double1;
	private: ::std::wstring string1;
	private: PHebrewZ hebrew1;
	private: PBytes byte2;
	private: PArrayInt int2;
	private: PArrayString string2;
	private: PArrayHebrewZ hebrew2;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: AllTypesZ();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: AllTypesZ(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, const ::std::wstring& string1, const PHebrewZ& hebrew1, const PBytes& byte2, const PArrayInt& int2, const PArrayString& string2, const PArrayHebrewZ& hebrew2);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: bool getBool1() { return bool1; }
	public: void setBool1(bool v);
	public: int8_t getByte1() { return byte1; }
	public: void setByte1(int8_t v);
	public: wchar_t getChar1() { return char1; }
	public: void setChar1(wchar_t v);
	public: int16_t getShort1() { return short1; }
	public: void setShort1(int16_t v);
	public: int32_t getInt1() { return int1; }
	public: void setInt1(int32_t v);
	public: int64_t getLong1() { return long1; }
	public: void setLong1(int64_t v);
	public: float getFloat1() { return float1; }
	public: void setFloat1(float v);
	public: double getDouble1() { return double1; }
	public: void setDouble1(double v);
	public: ::std::wstring getString1() { return string1; }
	public: void setString1(::std::wstring v);
	public: PHebrewZ getHebrew1() { return hebrew1; }
	public: void setHebrew1(PHebrewZ v);
	public: PBytes getByte2() { return byte2; }
	public: void setByte2(PBytes v);
	public: PArrayInt getInt2() { return int2; }
	public: void setInt2(PArrayInt v);
	public: PArrayString getString2() { return string2; }
	public: void setString2(PArrayString v);
	public: PArrayHebrewZ getHebrew2() { return hebrew2; }
	public: void setHebrew2(PArrayHebrewZ v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// HebrewC
// typeId=1770673942

namespace byps { namespace test { namespace api { namespace cons { 

using namespace ::byps;

class HebrewC : public BSerializable {
	protected: const static ::std::wstring aleph;
	protected: const static ::std::wstring beth;
	public: const static PHebrewZ ALEPH;
	public: const static PHebrewZ BETH;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: HebrewC();
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: static ::std::wstring getAleph() { return aleph; }
	public: static ::std::wstring getBeth() { return beth; }
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// HebrewZ
// typeId=1518668429

namespace byps { namespace test { namespace api { namespace cons { 

using namespace ::byps;

class HebrewZ : public BSerializable {
	private: ::std::wstring core;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: HebrewZ();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: HebrewZ(const ::std::wstring& core);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: ::std::wstring getCore() { return core; }
	public: void setCore(::std::wstring v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// UsePlanets
// typeId=10000

namespace byps { namespace test { namespace api { namespace enu { 

using namespace ::byps;

class UsePlanets : public BSerializable {
	public: EnumPlanets planet;
	private: EnumPlanets planet2;
	public: PArrayEnumPlanets arrayOfPlanets;
	public: PVectorEnumPlanets listOfPlanets;
	public: PMapStringEnumPlanets mapOfPlanets;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: UsePlanets();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: UsePlanets(EnumPlanets planet, EnumPlanets planet2, const PArrayEnumPlanets& arrayOfPlanets, const PVectorEnumPlanets& listOfPlanets, const PMapStringEnumPlanets& mapOfPlanets);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: EnumPlanets getPlanet2() { return planet2; }
	public: void setPlanet2(EnumPlanets v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Class1
// typeId=6001

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

/// <summary>
/// Base class for ...
/// </summary>
class Class1 : public BSerializable {
	public: int32_t int1;
	public: PClass1 nextClass1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Class1();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Class1(int32_t int1, const PClass1& nextClass1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Class1Collections
// typeId=6004

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class Class1Collections : public BSerializable {
	public: PVectorClass1 list1;
	public: PMapStringClass1 map1;
	public: byps_ptr< ::std::set< PClass1 > > set1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Class1Collections();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Class1Collections(const PVectorClass1& list1, const PMapStringClass1& map1, const byps_ptr< ::std::set< PClass1 > >& set1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Class2
// typeId=6002

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class Class2 : public Class1 {
	public: int32_t int2;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Class2();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Class2(int32_t int2);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Class3
// typeId=6003

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class Class3 : public Class2 {
	public: int32_t int3;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Class3();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Class3(int32_t int3);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Actor
// typeId=171948703

namespace byps { namespace test { namespace api { namespace inl { 

using namespace ::byps;

class Actor : public BSerializable {
	public: PArrayPoint2D shape;
	public: Matrix2D position;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Actor();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Actor(const PArrayPoint2D& shape, const Matrix2D& position);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// ListListTypes
// typeId=3002

namespace byps { namespace test { namespace api { namespace list { 

using namespace ::byps;

class ListListTypes : public BSerializable {
	public: byps_ptr< ::std::vector< byps::PVectorInteger > > int2;
	public: byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > int3;
	public: byps_ptr< ::std::vector< byps_ptr< ::std::vector< PArray4Int > > > > int24;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: ListListTypes();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: ListListTypes(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int2, const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int3, const byps_ptr< ::std::vector< byps_ptr< ::std::vector< PArray4Int > > > >& int24);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// ListTypes
// typeId=3001

namespace byps { namespace test { namespace api { namespace list { 

using namespace ::byps;

class ListTypes : public BSerializable {
	public: byps::PVectorBoolean boolean1;
	public: byps::PVectorByte byte1;
	public: byps::PVectorCharacter char1;
	public: byps::PVectorShort short1;
	public: byps::PVectorInteger int1;
	public: byps::PVectorLong long1;
	public: byps::PVectorFloat float1;
	public: byps::PVectorDouble double1;
	public: byps::PVectorString string1;
	public: byps::PVectorDate date1;
	public: byps::test::api::prim::PVectorPrimitiveTypes primitiveTypes1;
	public: byps_ptr< ::std::vector< PBytes > > byte2;
	public: byps_ptr< ::std::vector< PArrayInt > > int2;
	public: byps_ptr< ::std::vector< PArray4Int > > int4;
	public: byps::PVectorObject obj1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: ListTypes();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: ListTypes(const byps::PVectorBoolean& boolean1, const byps::PVectorByte& byte1, const byps::PVectorCharacter& char1, const byps::PVectorShort& short1, const byps::PVectorInteger& int1, const byps::PVectorLong& long1, const byps::PVectorFloat& float1, const byps::PVectorDouble& double1, const byps::PVectorString& string1, const byps::PVectorDate& date1, const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1, const byps_ptr< ::std::vector< PBytes > >& byte2, const byps_ptr< ::std::vector< PArrayInt > >& int2, const byps_ptr< ::std::vector< PArray4Int > >& int4, const byps::PVectorObject& obj1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// MapTypes
// typeId=4001

namespace byps { namespace test { namespace api { namespace map { 

using namespace ::byps;

class MapTypes : public BSerializable {
	public: byps::PMapStringBoolean boolean1;
	public: byps::PMapDoubleByte byte1;
	public: byps::PMapFloatCharacter char1;
	public: byps::PMapLongShort short1;
	public: byps::PMapIntegerInteger int1;
	public: byps::PMapShortLong long1;
	public: byps::PMapCharacterFloat float1;
	public: byps::PMapByteDouble double1;
	public: byps::PMapStringString string1;
	public: byps::test::api::prim::PMapIntegerPrimitiveTypes primitiveTypes1;
	public: byps_ptr< ::std::map< int32_t , PBytes > > byte2;
	public: byps_ptr< ::std::map< int32_t , PArrayInt > > int2;
	public: byps::PMapStringObject obj1;
	public: byps::PMapStringDate date1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: MapTypes();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: MapTypes(const byps::PMapStringBoolean& boolean1, const byps::PMapDoubleByte& byte1, const byps::PMapFloatCharacter& char1, const byps::PMapLongShort& short1, const byps::PMapIntegerInteger& int1, const byps::PMapShortLong& long1, const byps::PMapCharacterFloat& float1, const byps::PMapByteDouble& double1, const byps::PMapStringString& string1, const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1, const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2, const byps::PMapStringObject& obj1, const byps::PMapStringDate& date1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// PrimitiveTypes
// typeId=1000

namespace byps { namespace test { namespace api { namespace prim { 

using namespace ::byps;

/// <summary>
/// Example class with primitive types like boolean, int, String.
/// </summary>
class PrimitiveTypes : public BSerializable {
	/// <summary>
	/// Boolean value.
	/// </summary>
	/// <remarks>
	/// Serialized as one byte with value 1 for true and value 0 for false.
	/// </remarks>
	public: bool boolVal;
	/// <summary>
	/// One byte.
	/// </summary>
	public: int8_t byteVal;
	/// <summary>
	/// One wide (2 byte) character.
	/// </summary>
	/// <remarks>
	/// Serialized as short integer in binary serialization and as string when serializing in JSON format.
	/// </remarks>
	public: wchar_t charVal;
	public: int16_t shortVal;
	public: int32_t intVal;
	public: int64_t longVal;
	public: float floatVal;
	public: double doubleVal;
	public: ::std::wstring stringVal;
	public: BDateTime dateVal;
	/// <summary>
	/// This element can refer a an arbitrary type that implements Serializable.
	/// </summary>
	/// <remarks>
	/// It cannot hold an array, List, ArrayList, etc.
	/// </remarks>
	public: PSerializable objVal;
	public: PSerializable objVal2;
	/// <summary>
	/// In CSharp, value is a keyword in property setter functions.
	/// </summary>
	/// <remarks>
	/// But it must not be a problem to name a member by value.
	/// </remarks>
	public: bool value;
	public: PSerializable temp; // transient
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: PrimitiveTypes();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: PrimitiveTypes(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const BDateTime& dateVal, const PSerializable& objVal, const PSerializable& objVal2, bool value, const PSerializable& temp);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// PrivateMembers
// typeId=8001

namespace byps { namespace test { namespace api { namespace priv { 

using namespace ::byps;

/// <summary>
/// Example class with private and protected members
/// </summary>
class PrivateMembers : public BSerializable {
	private: bool boolVal;
	private: int8_t byteVal;
	private: wchar_t charVal;
	private: int16_t shortVal;
	private: int32_t intVal;
	private: int64_t longVal;
	private: float floatVal;
	private: double doubleVal;
	private: ::std::wstring stringVal;
	private: byps::test::api::prim::PPrimitiveTypes primitiveTypes;
	private: PArrayBoolean arrBool;
	private: PArrayInt arrInt;
	private: PArrayString arrString;
	private: byps::test::api::prim::PArrayPrimitiveTypes arrPrimitiveTypes;
	private: byps::PVectorBoolean listBool;
	private: byps::PVectorInteger listInt;
	private: byps::PVectorString listString;
	private: byps::test::api::prim::PVectorPrimitiveTypes listPrimitiveTypes;
	private: byps_ptr< ::std::map< int32_t , byps::PVectorString > > mapIntListString;
	protected: int32_t protInt;
	protected: int32_t pprotInt;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: PrivateMembers();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: PrivateMembers(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const byps::test::api::prim::PPrimitiveTypes& primitiveTypes, const PArrayBoolean& arrBool, const PArrayInt& arrInt, const PArrayString& arrString, const byps::test::api::prim::PArrayPrimitiveTypes& arrPrimitiveTypes, const byps::PVectorBoolean& listBool, const byps::PVectorInteger& listInt, const byps::PVectorString& listString, const byps::test::api::prim::PVectorPrimitiveTypes& listPrimitiveTypes, const byps_ptr< ::std::map< int32_t , byps::PVectorString > >& mapIntListString, int32_t protInt, int32_t pprotInt);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: bool getBoolVal() { return boolVal; }
	public: void setBoolVal(bool v);
	public: int8_t getByteVal() { return byteVal; }
	public: void setByteVal(int8_t v);
	public: wchar_t getCharVal() { return charVal; }
	public: void setCharVal(wchar_t v);
	public: int16_t getShortVal() { return shortVal; }
	public: void setShortVal(int16_t v);
	public: int32_t getIntVal() { return intVal; }
	public: void setIntVal(int32_t v);
	public: int64_t getLongVal() { return longVal; }
	public: void setLongVal(int64_t v);
	public: float getFloatVal() { return floatVal; }
	public: void setFloatVal(float v);
	public: double getDoubleVal() { return doubleVal; }
	public: void setDoubleVal(double v);
	public: ::std::wstring getStringVal() { return stringVal; }
	public: void setStringVal(::std::wstring v);
	public: byps::test::api::prim::PPrimitiveTypes getPrimitiveTypes() { return primitiveTypes; }
	public: void setPrimitiveTypes(byps::test::api::prim::PPrimitiveTypes v);
	public: PArrayBoolean getArrBool() { return arrBool; }
	public: void setArrBool(PArrayBoolean v);
	public: PArrayInt getArrInt() { return arrInt; }
	public: void setArrInt(PArrayInt v);
	public: PArrayString getArrString() { return arrString; }
	public: void setArrString(PArrayString v);
	public: byps::test::api::prim::PArrayPrimitiveTypes getArrPrimitiveTypes() { return arrPrimitiveTypes; }
	public: void setArrPrimitiveTypes(byps::test::api::prim::PArrayPrimitiveTypes v);
	public: byps::PVectorBoolean getListBool() { return listBool; }
	public: void setListBool(byps::PVectorBoolean v);
	public: byps::PVectorInteger getListInt() { return listInt; }
	public: void setListInt(byps::PVectorInteger v);
	public: byps::PVectorString getListString() { return listString; }
	public: void setListString(byps::PVectorString v);
	public: byps::test::api::prim::PVectorPrimitiveTypes getListPrimitiveTypes() { return listPrimitiveTypes; }
	public: void setListPrimitiveTypes(byps::test::api::prim::PVectorPrimitiveTypes v);
	public: byps_ptr< ::std::map< int32_t , byps::PVectorString > > getMapIntListString() { return mapIntListString; }
	public: void setMapIntListString(byps_ptr< ::std::map< int32_t , byps::PVectorString > > v);
	public: int32_t getProtInt() { return protInt; }
	public: void setProtInt(int32_t v);
	public: int32_t getPprotInt() { return pprotInt; }
	public: void setPprotInt(int32_t v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Node
// typeId=9001

namespace byps { namespace test { namespace api { namespace refs { 

using namespace ::byps;

class Node : public BSerializable {
	public: PNode next;
	public: PNode me;
	public: PMapStringNode mapOfNodes;
	public: PVectorNode listOfNodes;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Node();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Node(const PNode& next, const PNode& me, const PMapStringNode& mapOfNodes, const PVectorNode& listOfNodes);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// SetTypes
// typeId=5001

namespace byps { namespace test { namespace api { namespace set { 

using namespace ::byps;

class SetTypes : public BSerializable {
	public: byps::PSetBoolean boolean1;
	public: byps::PSetByte byte1;
	public: byps::PSetCharacter char1;
	public: byps::PSetShort short1;
	public: byps::PSetInteger int1;
	public: byps::PSetLong long1;
	public: byps::PSetFloat float1;
	public: byps::PSetDouble double1;
	public: byps::PSetString string1;
	public: byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1;
	public: byps_ptr< ::std::set< PBytes > > byte2;
	public: byps_ptr< ::std::set< PArrayInt > > int2;
	public: byps_ptr< ::std::set< PSerializable > > obj1;
	public: byps::PSetDate date1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: SetTypes();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: SetTypes(const byps::PSetBoolean& boolean1, const byps::PSetByte& byte1, const byps::PSetCharacter& char1, const byps::PSetShort& short1, const byps::PSetInteger& int1, const byps::PSetLong& long1, const byps::PSetFloat& float1, const byps::PSetDouble& double1, const byps::PSetString& string1, const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::set< PBytes > >& byte2, const byps_ptr< ::std::set< PArrayInt > >& int2, const byps_ptr< ::std::set< PSerializable > >& obj1, const byps::PSetDate& date1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// ChatStructure
// typeId=7007

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class ChatStructure : public BSerializable {
	public: ::std::wstring msg;
	public: double sentAt;
	public: double receivedAt;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: ChatStructure();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: ChatStructure(const ::std::wstring& msg, double sentAt, double receivedAt);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Stream1
// typeId=1541129345

namespace byps { namespace test { namespace api { namespace strm { 

using namespace ::byps;

class Stream1 : public BSerializable {
	public: PContentStream is1;
	private: ::std::wstring contentType;
	private: byps::PArrayInputStream arrStream;
	private: byps::PVectorInputStream listStream;
	public: byps::PMapIntegerInputStream mapStream;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Stream1();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Stream1(const PContentStream& is1, const ::std::wstring& contentType, const byps::PArrayInputStream& arrStream, const byps::PVectorInputStream& listStream, const byps::PMapIntegerInputStream& mapStream);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: ::std::wstring getContentType() { return contentType; }
	public: void setContentType(::std::wstring v);
	public: byps::PArrayInputStream getArrStream() { return arrStream; }
	public: void setArrStream(byps::PArrayInputStream v);
	public: byps::PVectorInputStream getListStream() { return listStream; }
	public: void setListStream(byps::PVectorInputStream v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Evolve
// typeId=1391985860

namespace byps { namespace test { namespace api { namespace ver { 

using namespace ::byps;

/// <summary>
/// Example class with elements that belong to different versions.
/// </summary>
class Evolve : public BSerializable {
	public: bool bool1;
	public: int8_t byte1;
	public: wchar_t char1;
	public: int16_t short1;
	public: int32_t int1;
	public: int64_t long1;
	public: float float1;
	public: double double1;
	public: PArrayBoolean bools1;
	public: PBytes bytes1;
	public: PArrayChar chars1;
	public: PArrayShort shorts1;
	public: PArrayInt ints1;
	public: PArrayLong longs1;
	public: PArrayFloat floats1;
	public: PArrayDouble doubles1;
	public: ::std::wstring str1;
	public: PSerializable obj1;
	public: PEvolve2 evo1;
	public: byps::PVectorInteger list1;
	public: byps::PSetInteger set1;
	public: byps::PMapIntegerInteger map1;
	public: bool bool2;
	public: int8_t byte2;
	public: wchar_t char2;
	public: int16_t short2;
	public: int32_t int2;
	public: int64_t long2;
	public: float float2;
	public: double double2;
	public: PArrayBoolean bools2;
	public: PBytes bytes2;
	public: PArrayChar chars2;
	public: PArrayShort shorts2;
	public: PArrayInt ints2;
	public: PArrayLong longs2;
	public: PArrayFloat floats2;
	public: PArrayDouble doubles2;
	public: ::std::wstring str2;
	public: PSerializable obj2;
	public: PEvolve2 evo2;
	public: byps::PVectorInteger list2;
	public: byps::PSetInteger set2;
	public: byps::PMapIntegerInteger map2;
	public: bool bool3;
	public: int8_t byte3;
	public: wchar_t char3;
	public: int16_t short3;
	public: int32_t int3;
	public: int64_t long3;
	public: float float3;
	public: double double3;
	public: PArrayBoolean bools3;
	public: PBytes bytes3;
	public: PArrayChar chars3;
	public: PArrayShort shorts3;
	public: PArrayInt ints3;
	public: PArrayLong longs3;
	public: PArrayFloat floats3;
	public: PArrayDouble doubles3;
	public: ::std::wstring str3;
	public: PSerializable obj3;
	public: PEvolve2 evo3;
	public: byps::PVectorInteger list3;
	public: byps::PSetInteger set3;
	public: byps::PMapIntegerInteger map3;
	public: int32_t since793;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Evolve();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Evolve(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, const PArrayBoolean& bools1, const PBytes& bytes1, const PArrayChar& chars1, const PArrayShort& shorts1, const PArrayInt& ints1, const PArrayLong& longs1, const PArrayFloat& floats1, const PArrayDouble& doubles1, const ::std::wstring& str1, const PSerializable& obj1, const PEvolve2& evo1, const byps::PVectorInteger& list1, const byps::PSetInteger& set1, const byps::PMapIntegerInteger& map1, bool bool2, int8_t byte2, wchar_t char2, int16_t short2, int32_t int2, int64_t long2, float float2, double double2, const PArrayBoolean& bools2, const PBytes& bytes2, const PArrayChar& chars2, const PArrayShort& shorts2, const PArrayInt& ints2, const PArrayLong& longs2, const PArrayFloat& floats2, const PArrayDouble& doubles2, const ::std::wstring& str2, const PSerializable& obj2, const PEvolve2& evo2, const byps::PVectorInteger& list2, const byps::PSetInteger& set2, const byps::PMapIntegerInteger& map2, bool bool3, int8_t byte3, wchar_t char3, int16_t short3, int32_t int3, int64_t long3, float float3, double double3, const PArrayBoolean& bools3, const PBytes& bytes3, const PArrayChar& chars3, const PArrayShort& shorts3, const PArrayInt& ints3, const PArrayLong& longs3, const PArrayFloat& floats3, const PArrayDouble& doubles3, const ::std::wstring& str3, const PSerializable& obj3, const PEvolve2& evo3, const byps::PVectorInteger& list3, const byps::PSetInteger& set3, const byps::PMapIntegerInteger& map3, int32_t since793);	
	public: virtual BTYPEID BSerializable_getTypeId();
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

// checkpoint byps.gen.cpp.GenApiClass:652
//-------------------------------------------------
// Evolve2
// typeId=573592593

namespace byps { namespace test { namespace api { namespace ver { 

using namespace ::byps;

class Evolve2 : public BSerializable {
	protected: int32_t n1;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Evolve2();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Evolve2(int32_t n1);	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: int32_t getN1() { return n1; }
	public: void setN1(int32_t v);
	// checkpoint byps.gen.cpp.GenApiClass:870
	public: void serialize(BIO& ar, const BVERSION version);
};

}}}}

//-------------------------------------------------
// PlantService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class PlantService : public virtual BRemote {
	
	public: virtual ::std::wstring grow()  = 0;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// PlantServiceAuth

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class PlantServiceAuth : public virtual BRemote {
	
	public: virtual ::std::wstring grow()  = 0;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_PlantService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BStub_PlantService;
typedef byps_ptr<BStub_PlantService> PStub_PlantService;

class BStub_PlantService : public BStub, public virtual PlantServiceAuth {
	
	public: BStub_PlantService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual ::std::wstring grow() ;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// FruitService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class FruitService : public virtual BRemote, 
	public virtual PlantService {
	
	public: virtual ::std::wstring squeeze()  = 0;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// FruitServiceAuth

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class FruitServiceAuth : public virtual BRemote, 
	public virtual PlantServiceAuth {
	
	public: virtual ::std::wstring squeeze()  = 0;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_FruitService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BStub_FruitService;
typedef byps_ptr<BStub_FruitService> PStub_FruitService;

class BStub_FruitService : public BStub, public virtual FruitServiceAuth {
	
	public: BStub_FruitService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual ::std::wstring grow() ;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual ::std::wstring squeeze() ;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// BioFruitService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BioFruitService : public virtual BRemote, 
	public virtual FruitService {
	
	public: virtual bool certify(const ::std::wstring& param)  = 0;
	public: virtual void certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// BioFruitServiceAuth

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BioFruitServiceAuth : public virtual BRemote, 
	public virtual FruitServiceAuth {
	
	public: virtual bool certify(const ::std::wstring& param)  = 0;
	public: virtual void certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_BioFruitService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BStub_BioFruitService;
typedef byps_ptr<BStub_BioFruitService> PStub_BioFruitService;

class BStub_BioFruitService : public BStub, public virtual BioFruitServiceAuth {
	
	public: BStub_BioFruitService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual bool certify(const ::std::wstring& param) ;
	public: virtual void certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual ::std::wstring squeeze() ;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual ::std::wstring grow() ;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// LemonService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class LemonService : public virtual BRemote, 
	public virtual FruitService {
	
	public: virtual ::std::wstring pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  = 0;
	public: virtual void pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// LemonServiceAuth

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class LemonServiceAuth : public virtual BRemote, 
	public virtual FruitServiceAuth {
	
	public: virtual ::std::wstring pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  = 0;
	public: virtual void pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_LemonService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BStub_LemonService;
typedef byps_ptr<BStub_LemonService> PStub_LemonService;

class BStub_LemonService : public BStub, public virtual LemonServiceAuth {
	
	public: BStub_LemonService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual ::std::wstring squeeze() ;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual ::std::wstring grow() ;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual ::std::wstring pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree) ;
	public: virtual void pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// BioLemonService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BioLemonService : public virtual BRemote, 
	public virtual BioFruitService, 
	public virtual LemonService {
	
	public: virtual int32_t useParing()  = 0;
	public: virtual void useParing(::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// BioLemonServiceAuth

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BioLemonServiceAuth : public virtual BRemote, 
	public virtual BioFruitServiceAuth, 
	public virtual LemonServiceAuth {
	
	public: virtual int32_t useParing()  = 0;
	public: virtual void useParing(::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_BioLemonService

namespace byps { namespace test { namespace api { namespace inherit { 

using namespace ::byps;

class BStub_BioLemonService;
typedef byps_ptr<BStub_BioLemonService> PStub_BioLemonService;

class BStub_BioLemonService : public BStub, public virtual BioLemonServiceAuth {
	
	public: BStub_BioLemonService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual ::std::wstring squeeze() ;
	public: virtual void squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual ::std::wstring grow() ;
	public: virtual void grow(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual int32_t useParing() ;
	public: virtual void useParing(::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual ::std::wstring pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree) ;
	public: virtual void pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual bool certify(const ::std::wstring& param) ;
	public: virtual void certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteArrayTypes1dim

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

/// <summary>
/// Interface with functions using 1-dimensional arrays.
/// </summary>
class RemoteArrayTypes1dim : public virtual BRemote {
	
	public: virtual void setBool(const PArrayBoolean& v)  = 0;
	public: virtual void setBool(const PArrayBoolean& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte(const PBytes& v)  = 0;
	public: virtual void setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar(const PArrayChar& v)  = 0;
	public: virtual void setChar(const PArrayChar& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort(const PArrayShort& v)  = 0;
	public: virtual void setShort(const PArrayShort& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt(const PArrayInt& v)  = 0;
	public: virtual void setInt(const PArrayInt& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong(const PArrayLong& v)  = 0;
	public: virtual void setLong(const PArrayLong& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat(const PArrayFloat& v)  = 0;
	public: virtual void setFloat(const PArrayFloat& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble(const PArrayDouble& v)  = 0;
	public: virtual void setDouble(const PArrayDouble& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString(const PArrayString& v)  = 0;
	public: virtual void setString(const PArrayString& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v)  = 0;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObject(const byps::PArrayObject& v)  = 0;
	public: virtual void setObject(const byps::PArrayObject& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate(const PArrayDate& v)  = 0;
	public: virtual void setDate(const PArrayDate& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayBoolean getBool()  = 0;
	public: virtual void getBool(::std::function< void (PArrayBoolean, BException ex) > asyncResult)  = 0;
	
	public: virtual PBytes getByte()  = 0;
	public: virtual void getByte(::std::function< void (PBytes, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayChar getChar()  = 0;
	public: virtual void getChar(::std::function< void (PArrayChar, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayShort getShort()  = 0;
	public: virtual void getShort(::std::function< void (PArrayShort, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayInt getInt()  = 0;
	public: virtual void getInt(::std::function< void (PArrayInt, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayLong getLong()  = 0;
	public: virtual void getLong(::std::function< void (PArrayLong, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayFloat getFloat()  = 0;
	public: virtual void getFloat(::std::function< void (PArrayFloat, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayDouble getDouble()  = 0;
	public: virtual void getDouble(::std::function< void (PArrayDouble, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayString getString()  = 0;
	public: virtual void getString(::std::function< void (PArrayString, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PArrayPrimitiveTypes getPrimitiveTypes()  = 0;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PArrayObject getObject()  = 0;
	public: virtual void getObject(::std::function< void (byps::PArrayObject, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayDate getDate()  = 0;
	public: virtual void getDate(::std::function< void (PArrayDate, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteArrayTypes1dim

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteArrayTypes1dim;
typedef byps_ptr<BStub_RemoteArrayTypes1dim> PStub_RemoteArrayTypes1dim;

class BStub_RemoteArrayTypes1dim : public BStub, public virtual RemoteArrayTypes1dim {
	
	public: BStub_RemoteArrayTypes1dim(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void setBool(const PArrayBoolean& v) ;
	public: virtual void setBool(const PArrayBoolean& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setByte(const PBytes& v) ;
	public: virtual void setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setChar(const PArrayChar& v) ;
	public: virtual void setChar(const PArrayChar& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setShort(const PArrayShort& v) ;
	public: virtual void setShort(const PArrayShort& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setInt(const PArrayInt& v) ;
	public: virtual void setInt(const PArrayInt& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setLong(const PArrayLong& v) ;
	public: virtual void setLong(const PArrayLong& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setFloat(const PArrayFloat& v) ;
	public: virtual void setFloat(const PArrayFloat& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDouble(const PArrayDouble& v) ;
	public: virtual void setDouble(const PArrayDouble& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setString(const PArrayString& v) ;
	public: virtual void setString(const PArrayString& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setObject(const byps::PArrayObject& v) ;
	public: virtual void setObject(const byps::PArrayObject& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDate(const PArrayDate& v) ;
	public: virtual void setDate(const PArrayDate& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PArrayBoolean getBool() ;
	public: virtual void getBool(::std::function< void (PArrayBoolean, BException ex) > asyncResult) ;
	public: virtual PBytes getByte() ;
	public: virtual void getByte(::std::function< void (PBytes, BException ex) > asyncResult) ;
	public: virtual PArrayChar getChar() ;
	public: virtual void getChar(::std::function< void (PArrayChar, BException ex) > asyncResult) ;
	public: virtual PArrayShort getShort() ;
	public: virtual void getShort(::std::function< void (PArrayShort, BException ex) > asyncResult) ;
	public: virtual PArrayInt getInt() ;
	public: virtual void getInt(::std::function< void (PArrayInt, BException ex) > asyncResult) ;
	public: virtual PArrayLong getLong() ;
	public: virtual void getLong(::std::function< void (PArrayLong, BException ex) > asyncResult) ;
	public: virtual PArrayFloat getFloat() ;
	public: virtual void getFloat(::std::function< void (PArrayFloat, BException ex) > asyncResult) ;
	public: virtual PArrayDouble getDouble() ;
	public: virtual void getDouble(::std::function< void (PArrayDouble, BException ex) > asyncResult) ;
	public: virtual PArrayString getString() ;
	public: virtual void getString(::std::function< void (PArrayString, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PArrayPrimitiveTypes getPrimitiveTypes() ;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual byps::PArrayObject getObject() ;
	public: virtual void getObject(::std::function< void (byps::PArrayObject, BException ex) > asyncResult) ;
	public: virtual PArrayDate getDate() ;
	public: virtual void getDate(::std::function< void (PArrayDate, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteArrayTypes23

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteArrayTypes23 : public virtual BRemote {
	
	public: virtual PArrayInt sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4)  = 0;
	public: virtual void sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4, ::std::function< void (PArrayInt, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayString sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4)  = 0;
	public: virtual void sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4, ::std::function< void (PArrayString, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PArrayPrimitiveTypes sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4)  = 0;
	public: virtual void sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4, ::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PArrayObject sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4)  = 0;
	public: virtual void sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4, ::std::function< void (byps::PArrayObject, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PArrayPoint2D sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4)  = 0;
	public: virtual void sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4, ::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteArrayTypes23

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteArrayTypes23;
typedef byps_ptr<BStub_RemoteArrayTypes23> PStub_RemoteArrayTypes23;

class BStub_RemoteArrayTypes23 : public BStub, public virtual RemoteArrayTypes23 {
	
	public: BStub_RemoteArrayTypes23(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual PArrayInt sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4) ;
	public: virtual void sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4, ::std::function< void (PArrayInt, BException ex) > asyncResult) ;
	public: virtual PArrayString sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4) ;
	public: virtual void sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4, ::std::function< void (PArrayString, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PArrayPrimitiveTypes sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4) ;
	public: virtual void sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4, ::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual byps::PArrayObject sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4) ;
	public: virtual void sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4, ::std::function< void (byps::PArrayObject, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PArrayPoint2D sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4) ;
	public: virtual void sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4, ::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteArrayTypes4dim

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

/// <summary>
/// Interface with functions using 4-dimensional arrays.
/// </summary>
class RemoteArrayTypes4dim : public virtual BRemote {
	
	public: virtual void setBool(const PArray4Boolean& v)  = 0;
	public: virtual void setBool(const PArray4Boolean& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte(const PArray4Byte& v)  = 0;
	public: virtual void setByte(const PArray4Byte& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar(const PArray4Char& v)  = 0;
	public: virtual void setChar(const PArray4Char& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort(const PArray4Short& v)  = 0;
	public: virtual void setShort(const PArray4Short& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt(const PArray4Int& v)  = 0;
	public: virtual void setInt(const PArray4Int& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong(const PArray4Long& v)  = 0;
	public: virtual void setLong(const PArray4Long& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat(const PArray4Float& v)  = 0;
	public: virtual void setFloat(const PArray4Float& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble(const PArray4Double& v)  = 0;
	public: virtual void setDouble(const PArray4Double& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString(const PArray4String& v)  = 0;
	public: virtual void setString(const PArray4String& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v)  = 0;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObject(const byps::PArray4Object& v)  = 0;
	public: virtual void setObject(const byps::PArray4Object& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate(const PArray4Date& v)  = 0;
	public: virtual void setDate(const PArray4Date& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Boolean getBool()  = 0;
	public: virtual void getBool(::std::function< void (PArray4Boolean, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Byte getByte()  = 0;
	public: virtual void getByte(::std::function< void (PArray4Byte, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Char getChar()  = 0;
	public: virtual void getChar(::std::function< void (PArray4Char, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Short getShort()  = 0;
	public: virtual void getShort(::std::function< void (PArray4Short, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Int getInt()  = 0;
	public: virtual void getInt(::std::function< void (PArray4Int, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Long getLong()  = 0;
	public: virtual void getLong(::std::function< void (PArray4Long, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Float getFloat()  = 0;
	public: virtual void getFloat(::std::function< void (PArray4Float, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Double getDouble()  = 0;
	public: virtual void getDouble(::std::function< void (PArray4Double, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4String getString()  = 0;
	public: virtual void getString(::std::function< void (PArray4String, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PArray4PrimitiveTypes getPrimitiveTypes()  = 0;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArray4PrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PArray4Object getObject()  = 0;
	public: virtual void getObject(::std::function< void (byps::PArray4Object, BException ex) > asyncResult)  = 0;
	
	public: virtual PArray4Date getDate()  = 0;
	public: virtual void getDate(::std::function< void (PArray4Date, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteArrayTypes4dim

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteArrayTypes4dim;
typedef byps_ptr<BStub_RemoteArrayTypes4dim> PStub_RemoteArrayTypes4dim;

class BStub_RemoteArrayTypes4dim : public BStub, public virtual RemoteArrayTypes4dim {
	
	public: BStub_RemoteArrayTypes4dim(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void setBool(const PArray4Boolean& v) ;
	public: virtual void setBool(const PArray4Boolean& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setByte(const PArray4Byte& v) ;
	public: virtual void setByte(const PArray4Byte& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setChar(const PArray4Char& v) ;
	public: virtual void setChar(const PArray4Char& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setShort(const PArray4Short& v) ;
	public: virtual void setShort(const PArray4Short& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setInt(const PArray4Int& v) ;
	public: virtual void setInt(const PArray4Int& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setLong(const PArray4Long& v) ;
	public: virtual void setLong(const PArray4Long& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setFloat(const PArray4Float& v) ;
	public: virtual void setFloat(const PArray4Float& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDouble(const PArray4Double& v) ;
	public: virtual void setDouble(const PArray4Double& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setString(const PArray4String& v) ;
	public: virtual void setString(const PArray4String& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setObject(const byps::PArray4Object& v) ;
	public: virtual void setObject(const byps::PArray4Object& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDate(const PArray4Date& v) ;
	public: virtual void setDate(const PArray4Date& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PArray4Boolean getBool() ;
	public: virtual void getBool(::std::function< void (PArray4Boolean, BException ex) > asyncResult) ;
	public: virtual PArray4Byte getByte() ;
	public: virtual void getByte(::std::function< void (PArray4Byte, BException ex) > asyncResult) ;
	public: virtual PArray4Char getChar() ;
	public: virtual void getChar(::std::function< void (PArray4Char, BException ex) > asyncResult) ;
	public: virtual PArray4Short getShort() ;
	public: virtual void getShort(::std::function< void (PArray4Short, BException ex) > asyncResult) ;
	public: virtual PArray4Int getInt() ;
	public: virtual void getInt(::std::function< void (PArray4Int, BException ex) > asyncResult) ;
	public: virtual PArray4Long getLong() ;
	public: virtual void getLong(::std::function< void (PArray4Long, BException ex) > asyncResult) ;
	public: virtual PArray4Float getFloat() ;
	public: virtual void getFloat(::std::function< void (PArray4Float, BException ex) > asyncResult) ;
	public: virtual PArray4Double getDouble() ;
	public: virtual void getDouble(::std::function< void (PArray4Double, BException ex) > asyncResult) ;
	public: virtual PArray4String getString() ;
	public: virtual void getString(::std::function< void (PArray4String, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PArray4PrimitiveTypes getPrimitiveTypes() ;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArray4PrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual byps::PArray4Object getObject() ;
	public: virtual void getObject(::std::function< void (byps::PArray4Object, BException ex) > asyncResult) ;
	public: virtual PArray4Date getDate() ;
	public: virtual void getDate(::std::function< void (PArray4Date, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteConstants

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

/// <summary>
/// Interface functions to verify constant definitions.
/// </summary>
class RemoteConstants : public virtual BRemote {
	
	public: virtual void compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH)  = 0;
	public: virtual void compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual bool compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll)  = 0;
	public: virtual void compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteConstants

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteConstants;
typedef byps_ptr<BStub_RemoteConstants> PStub_RemoteConstants;

class BStub_RemoteConstants : public BStub, public virtual RemoteConstants {
	
	public: BStub_RemoteConstants(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH) ;
	public: virtual void compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual bool compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll) ;
	public: virtual void compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteEnums

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteEnums : public virtual BRemote {
	
	public: virtual byps::test::api::enu::EnumPlanets getPlanet()  = 0;
	public: virtual void getPlanet(::std::function< void (byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPlanet(byps::test::api::enu::EnumPlanets planet)  = 0;
	public: virtual void setPlanet(byps::test::api::enu::EnumPlanets planet, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteEnums

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteEnums;
typedef byps_ptr<BStub_RemoteEnums> PStub_RemoteEnums;

class BStub_RemoteEnums : public BStub, public virtual RemoteEnums {
	
	public: BStub_RemoteEnums(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual byps::test::api::enu::EnumPlanets getPlanet() ;
	public: virtual void getPlanet(::std::function< void (byps::test::api::enu::EnumPlanets, BException ex) > asyncResult) ;
	public: virtual void setPlanet(byps::test::api::enu::EnumPlanets planet) ;
	public: virtual void setPlanet(byps::test::api::enu::EnumPlanets planet, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteInlineInstance

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteInlineInstance : public virtual BRemote {
	
	public: virtual void setActor(const byps::test::api::inl::PActor& act)  = 0;
	public: virtual void setActor(const byps::test::api::inl::PActor& act, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PActor getActor()  = 0;
	public: virtual void getActor(::std::function< void (byps::test::api::inl::PActor, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray)  = 0;
	public: virtual void setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PArrayPoint2D getPoint2DArray1dim()  = 0;
	public: virtual void getPoint2DArray1dim(::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray)  = 0;
	public: virtual void setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PArray4Point2D getPoint2DArray4dim()  = 0;
	public: virtual void getPoint2DArray4dim(::std::function< void (byps::test::api::inl::PArray4Point2D, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList)  = 0;
	public: virtual void setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PVectorPoint2D getPoint2DList()  = 0;
	public: virtual void getPoint2DList(::std::function< void (byps::test::api::inl::PVectorPoint2D, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList)  = 0;
	public: virtual void setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > getPoint2DListList()  = 0;
	public: virtual void getPoint2DListList(::std::function< void (byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap)  = 0;
	public: virtual void setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::inl::PMapIntegerPoint2D getPoint2DMap()  = 0;
	public: virtual void getPoint2DMap(::std::function< void (byps::test::api::inl::PMapIntegerPoint2D, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteInlineInstance

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteInlineInstance;
typedef byps_ptr<BStub_RemoteInlineInstance> PStub_RemoteInlineInstance;

class BStub_RemoteInlineInstance : public BStub, public virtual RemoteInlineInstance {
	
	public: BStub_RemoteInlineInstance(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void setActor(const byps::test::api::inl::PActor& act) ;
	public: virtual void setActor(const byps::test::api::inl::PActor& act, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PActor getActor() ;
	public: virtual void getActor(::std::function< void (byps::test::api::inl::PActor, BException ex) > asyncResult) ;
	public: virtual void setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray) ;
	public: virtual void setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PArrayPoint2D getPoint2DArray1dim() ;
	public: virtual void getPoint2DArray1dim(::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult) ;
	public: virtual void setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray) ;
	public: virtual void setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PArray4Point2D getPoint2DArray4dim() ;
	public: virtual void getPoint2DArray4dim(::std::function< void (byps::test::api::inl::PArray4Point2D, BException ex) > asyncResult) ;
	public: virtual void setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList) ;
	public: virtual void setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PVectorPoint2D getPoint2DList() ;
	public: virtual void getPoint2DList(::std::function< void (byps::test::api::inl::PVectorPoint2D, BException ex) > asyncResult) ;
	public: virtual void setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList) ;
	public: virtual void setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > getPoint2DListList() ;
	public: virtual void getPoint2DListList(::std::function< void (byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >, BException ex) > asyncResult) ;
	public: virtual void setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap) ;
	public: virtual void setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::inl::PMapIntegerPoint2D getPoint2DMap() ;
	public: virtual void getPoint2DMap(::std::function< void (byps::test::api::inl::PMapIntegerPoint2D, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteListTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteListTypes : public virtual BRemote {
	
	public: virtual byps::PVectorBoolean getBoolean1()  = 0;
	public: virtual void getBoolean1(::std::function< void (byps::PVectorBoolean, BException ex) > asyncResult)  = 0;
	
	public: virtual void setBoolean1(const byps::PVectorBoolean& boolean1)  = 0;
	public: virtual void setBoolean1(const byps::PVectorBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorByte getByte1()  = 0;
	public: virtual void getByte1(::std::function< void (byps::PVectorByte, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte1(const byps::PVectorByte& byte1)  = 0;
	public: virtual void setByte1(const byps::PVectorByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorCharacter getChar1()  = 0;
	public: virtual void getChar1(::std::function< void (byps::PVectorCharacter, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar1(const byps::PVectorCharacter& char1)  = 0;
	public: virtual void setChar1(const byps::PVectorCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorShort getShort1()  = 0;
	public: virtual void getShort1(::std::function< void (byps::PVectorShort, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort1(const byps::PVectorShort& short1)  = 0;
	public: virtual void setShort1(const byps::PVectorShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorInteger getInt1()  = 0;
	public: virtual void getInt1(::std::function< void (byps::PVectorInteger, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt1(const byps::PVectorInteger& int1)  = 0;
	public: virtual void setInt1(const byps::PVectorInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorLong getLong1()  = 0;
	public: virtual void getLong1(::std::function< void (byps::PVectorLong, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong1(const byps::PVectorLong& long1)  = 0;
	public: virtual void setLong1(const byps::PVectorLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorFloat getFloat1()  = 0;
	public: virtual void getFloat1(::std::function< void (byps::PVectorFloat, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat1(const byps::PVectorFloat& float1)  = 0;
	public: virtual void setFloat1(const byps::PVectorFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorDouble getDouble1()  = 0;
	public: virtual void getDouble1(::std::function< void (byps::PVectorDouble, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble1(const byps::PVectorDouble& double1)  = 0;
	public: virtual void setDouble1(const byps::PVectorDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorString getString1()  = 0;
	public: virtual void getString1(::std::function< void (byps::PVectorString, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString1(const byps::PVectorString& string1)  = 0;
	public: virtual void setString1(const byps::PVectorString& string1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PVectorPrimitiveTypes getPrimitiveTypes1()  = 0;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PVectorPrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1)  = 0;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< PBytes > > getByte2()  = 0;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::vector< PBytes > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2)  = 0;
	public: virtual void setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< PArrayInt > > getInt2()  = 0;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::vector< PArrayInt > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2)  = 0;
	public: virtual void setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorObject getObj1()  = 0;
	public: virtual void getObj1(::std::function< void (byps::PVectorObject, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObj1(const byps::PVectorObject& obj1)  = 0;
	public: virtual void setObj1(const byps::PVectorObject& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate1(const byps::PVectorDate& obj1)  = 0;
	public: virtual void setDate1(const byps::PVectorDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorDate getDate1()  = 0;
	public: virtual void getDate1(::std::function< void (byps::PVectorDate, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< byps::PVectorInteger > > getInt3()  = 0;
	public: virtual void getInt3(::std::function< void (byps_ptr< ::std::vector< byps::PVectorInteger > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3)  = 0;
	public: virtual void setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > getInt4()  = 0;
	public: virtual void getInt4(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4)  = 0;
	public: virtual void setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteListTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteListTypes;
typedef byps_ptr<BStub_RemoteListTypes> PStub_RemoteListTypes;

class BStub_RemoteListTypes : public BStub, public virtual RemoteListTypes {
	
	public: BStub_RemoteListTypes(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual byps::PVectorBoolean getBoolean1() ;
	public: virtual void getBoolean1(::std::function< void (byps::PVectorBoolean, BException ex) > asyncResult) ;
	public: virtual void setBoolean1(const byps::PVectorBoolean& boolean1) ;
	public: virtual void setBoolean1(const byps::PVectorBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorByte getByte1() ;
	public: virtual void getByte1(::std::function< void (byps::PVectorByte, BException ex) > asyncResult) ;
	public: virtual void setByte1(const byps::PVectorByte& byte1) ;
	public: virtual void setByte1(const byps::PVectorByte& byte1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorCharacter getChar1() ;
	public: virtual void getChar1(::std::function< void (byps::PVectorCharacter, BException ex) > asyncResult) ;
	public: virtual void setChar1(const byps::PVectorCharacter& char1) ;
	public: virtual void setChar1(const byps::PVectorCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorShort getShort1() ;
	public: virtual void getShort1(::std::function< void (byps::PVectorShort, BException ex) > asyncResult) ;
	public: virtual void setShort1(const byps::PVectorShort& short1) ;
	public: virtual void setShort1(const byps::PVectorShort& short1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorInteger getInt1() ;
	public: virtual void getInt1(::std::function< void (byps::PVectorInteger, BException ex) > asyncResult) ;
	public: virtual void setInt1(const byps::PVectorInteger& int1) ;
	public: virtual void setInt1(const byps::PVectorInteger& int1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorLong getLong1() ;
	public: virtual void getLong1(::std::function< void (byps::PVectorLong, BException ex) > asyncResult) ;
	public: virtual void setLong1(const byps::PVectorLong& long1) ;
	public: virtual void setLong1(const byps::PVectorLong& long1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorFloat getFloat1() ;
	public: virtual void getFloat1(::std::function< void (byps::PVectorFloat, BException ex) > asyncResult) ;
	public: virtual void setFloat1(const byps::PVectorFloat& float1) ;
	public: virtual void setFloat1(const byps::PVectorFloat& float1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorDouble getDouble1() ;
	public: virtual void getDouble1(::std::function< void (byps::PVectorDouble, BException ex) > asyncResult) ;
	public: virtual void setDouble1(const byps::PVectorDouble& double1) ;
	public: virtual void setDouble1(const byps::PVectorDouble& double1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorString getString1() ;
	public: virtual void getString1(::std::function< void (byps::PVectorString, BException ex) > asyncResult) ;
	public: virtual void setString1(const byps::PVectorString& string1) ;
	public: virtual void setString1(const byps::PVectorString& string1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PVectorPrimitiveTypes getPrimitiveTypes1() ;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PVectorPrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1) ;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::vector< PBytes > > getByte2() ;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::vector< PBytes > >, BException ex) > asyncResult) ;
	public: virtual void setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2) ;
	public: virtual void setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::vector< PArrayInt > > getInt2() ;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::vector< PArrayInt > >, BException ex) > asyncResult) ;
	public: virtual void setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2) ;
	public: virtual void setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorObject getObj1() ;
	public: virtual void getObj1(::std::function< void (byps::PVectorObject, BException ex) > asyncResult) ;
	public: virtual void setObj1(const byps::PVectorObject& obj1) ;
	public: virtual void setObj1(const byps::PVectorObject& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDate1(const byps::PVectorDate& obj1) ;
	public: virtual void setDate1(const byps::PVectorDate& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PVectorDate getDate1() ;
	public: virtual void getDate1(::std::function< void (byps::PVectorDate, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::vector< byps::PVectorInteger > > getInt3() ;
	public: virtual void getInt3(::std::function< void (byps_ptr< ::std::vector< byps::PVectorInteger > >, BException ex) > asyncResult) ;
	public: virtual void setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3) ;
	public: virtual void setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > getInt4() ;
	public: virtual void getInt4(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >, BException ex) > asyncResult) ;
	public: virtual void setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4) ;
	public: virtual void setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteMapTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteMapTypes : public virtual BRemote {
	
	public: virtual byps::PMapStringBoolean getBoolean1()  = 0;
	public: virtual void getBoolean1(::std::function< void (byps::PMapStringBoolean, BException ex) > asyncResult)  = 0;
	
	public: virtual void setBoolean1(const byps::PMapStringBoolean& boolean1)  = 0;
	public: virtual void setBoolean1(const byps::PMapStringBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapDoubleByte getByte1()  = 0;
	public: virtual void getByte1(::std::function< void (byps::PMapDoubleByte, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte1(const byps::PMapDoubleByte& byte1)  = 0;
	public: virtual void setByte1(const byps::PMapDoubleByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapFloatCharacter getChar1()  = 0;
	public: virtual void getChar1(::std::function< void (byps::PMapFloatCharacter, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar1(const byps::PMapFloatCharacter& char1)  = 0;
	public: virtual void setChar1(const byps::PMapFloatCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapLongShort getShort1()  = 0;
	public: virtual void getShort1(::std::function< void (byps::PMapLongShort, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort1(const byps::PMapLongShort& short1)  = 0;
	public: virtual void setShort1(const byps::PMapLongShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapIntegerInteger getInt1()  = 0;
	public: virtual void getInt1(::std::function< void (byps::PMapIntegerInteger, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt1(const byps::PMapIntegerInteger& int1)  = 0;
	public: virtual void setInt1(const byps::PMapIntegerInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapShortLong getLong1()  = 0;
	public: virtual void getLong1(::std::function< void (byps::PMapShortLong, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong1(const byps::PMapShortLong& long1)  = 0;
	public: virtual void setLong1(const byps::PMapShortLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapCharacterFloat getFloat1()  = 0;
	public: virtual void getFloat1(::std::function< void (byps::PMapCharacterFloat, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat1(const byps::PMapCharacterFloat& float1)  = 0;
	public: virtual void setFloat1(const byps::PMapCharacterFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapByteDouble getDouble1()  = 0;
	public: virtual void getDouble1(::std::function< void (byps::PMapByteDouble, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble1(const byps::PMapByteDouble& double1)  = 0;
	public: virtual void setDouble1(const byps::PMapByteDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapStringString getString1()  = 0;
	public: virtual void getString1(::std::function< void (byps::PMapStringString, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString1(const byps::PMapStringString& string1)  = 0;
	public: virtual void setString1(const byps::PMapStringString& string1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PMapIntegerPrimitiveTypes getPrimitiveTypes1()  = 0;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PMapIntegerPrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1)  = 0;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::map< int32_t , PBytes > > getByte2()  = 0;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2)  = 0;
	public: virtual void setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::map< int32_t , PArrayInt > > getInt2()  = 0;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::map< int32_t , PArrayInt > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2)  = 0;
	public: virtual void setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapStringObject getObj1()  = 0;
	public: virtual void getObj1(::std::function< void (byps::PMapStringObject, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObj1(const byps::PMapStringObject& obj1)  = 0;
	public: virtual void setObj1(const byps::PMapStringObject& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapStringDate getDate1()  = 0;
	public: virtual void getDate1(::std::function< void (byps::PMapStringDate, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate1(const byps::PMapStringDate& obj1)  = 0;
	public: virtual void setDate1(const byps::PMapStringDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteMapTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteMapTypes;
typedef byps_ptr<BStub_RemoteMapTypes> PStub_RemoteMapTypes;

class BStub_RemoteMapTypes : public BStub, public virtual RemoteMapTypes {
	
	public: BStub_RemoteMapTypes(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual byps::PMapStringBoolean getBoolean1() ;
	public: virtual void getBoolean1(::std::function< void (byps::PMapStringBoolean, BException ex) > asyncResult) ;
	public: virtual void setBoolean1(const byps::PMapStringBoolean& boolean1) ;
	public: virtual void setBoolean1(const byps::PMapStringBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapDoubleByte getByte1() ;
	public: virtual void getByte1(::std::function< void (byps::PMapDoubleByte, BException ex) > asyncResult) ;
	public: virtual void setByte1(const byps::PMapDoubleByte& byte1) ;
	public: virtual void setByte1(const byps::PMapDoubleByte& byte1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapFloatCharacter getChar1() ;
	public: virtual void getChar1(::std::function< void (byps::PMapFloatCharacter, BException ex) > asyncResult) ;
	public: virtual void setChar1(const byps::PMapFloatCharacter& char1) ;
	public: virtual void setChar1(const byps::PMapFloatCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapLongShort getShort1() ;
	public: virtual void getShort1(::std::function< void (byps::PMapLongShort, BException ex) > asyncResult) ;
	public: virtual void setShort1(const byps::PMapLongShort& short1) ;
	public: virtual void setShort1(const byps::PMapLongShort& short1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapIntegerInteger getInt1() ;
	public: virtual void getInt1(::std::function< void (byps::PMapIntegerInteger, BException ex) > asyncResult) ;
	public: virtual void setInt1(const byps::PMapIntegerInteger& int1) ;
	public: virtual void setInt1(const byps::PMapIntegerInteger& int1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapShortLong getLong1() ;
	public: virtual void getLong1(::std::function< void (byps::PMapShortLong, BException ex) > asyncResult) ;
	public: virtual void setLong1(const byps::PMapShortLong& long1) ;
	public: virtual void setLong1(const byps::PMapShortLong& long1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapCharacterFloat getFloat1() ;
	public: virtual void getFloat1(::std::function< void (byps::PMapCharacterFloat, BException ex) > asyncResult) ;
	public: virtual void setFloat1(const byps::PMapCharacterFloat& float1) ;
	public: virtual void setFloat1(const byps::PMapCharacterFloat& float1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapByteDouble getDouble1() ;
	public: virtual void getDouble1(::std::function< void (byps::PMapByteDouble, BException ex) > asyncResult) ;
	public: virtual void setDouble1(const byps::PMapByteDouble& double1) ;
	public: virtual void setDouble1(const byps::PMapByteDouble& double1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapStringString getString1() ;
	public: virtual void getString1(::std::function< void (byps::PMapStringString, BException ex) > asyncResult) ;
	public: virtual void setString1(const byps::PMapStringString& string1) ;
	public: virtual void setString1(const byps::PMapStringString& string1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PMapIntegerPrimitiveTypes getPrimitiveTypes1() ;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PMapIntegerPrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1) ;
	public: virtual void setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::map< int32_t , PBytes > > getByte2() ;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult) ;
	public: virtual void setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2) ;
	public: virtual void setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::map< int32_t , PArrayInt > > getInt2() ;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::map< int32_t , PArrayInt > >, BException ex) > asyncResult) ;
	public: virtual void setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2) ;
	public: virtual void setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapStringObject getObj1() ;
	public: virtual void getObj1(::std::function< void (byps::PMapStringObject, BException ex) > asyncResult) ;
	public: virtual void setObj1(const byps::PMapStringObject& obj1) ;
	public: virtual void setObj1(const byps::PMapStringObject& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapStringDate getDate1() ;
	public: virtual void getDate1(::std::function< void (byps::PMapStringDate, BException ex) > asyncResult) ;
	public: virtual void setDate1(const byps::PMapStringDate& obj1) ;
	public: virtual void setDate1(const byps::PMapStringDate& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemotePrimitiveTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemotePrimitiveTypes : public virtual BRemote {
	
	public: virtual void voidFunctionVoid()  = 0;
	public: virtual void voidFunctionVoid(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setBool(bool v)  = 0;
	public: virtual void setBool(bool v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte(int8_t v)  = 0;
	public: virtual void setByte(int8_t v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar(wchar_t v)  = 0;
	public: virtual void setChar(wchar_t v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort(int16_t v)  = 0;
	public: virtual void setShort(int16_t v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt(int32_t v)  = 0;
	public: virtual void setInt(int32_t v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong(int64_t v)  = 0;
	public: virtual void setLong(int64_t v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat(float v)  = 0;
	public: virtual void setFloat(float v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble(double v)  = 0;
	public: virtual void setDouble(double v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString(const ::std::wstring& v)  = 0;
	public: virtual void setString(const ::std::wstring& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v)  = 0;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObject(const PSerializable& v)  = 0;
	public: virtual void setObject(const PSerializable& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate(const BDateTime& v)  = 0;
	public: virtual void setDate(const BDateTime& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual bool getBool()  = 0;
	public: virtual void getBool(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual int8_t getByte()  = 0;
	public: virtual void getByte(::std::function< void (int8_t, BException ex) > asyncResult)  = 0;
	
	public: virtual wchar_t getChar()  = 0;
	public: virtual void getChar(::std::function< void (wchar_t, BException ex) > asyncResult)  = 0;
	
	public: virtual int16_t getShort()  = 0;
	public: virtual void getShort(::std::function< void (int16_t, BException ex) > asyncResult)  = 0;
	
	public: virtual int32_t getInt()  = 0;
	public: virtual void getInt(::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	public: virtual int64_t getLong()  = 0;
	public: virtual void getLong(::std::function< void (int64_t, BException ex) > asyncResult)  = 0;
	
	public: virtual float getFloat()  = 0;
	public: virtual void getFloat(::std::function< void (float, BException ex) > asyncResult)  = 0;
	
	public: virtual double getDouble()  = 0;
	public: virtual void getDouble(::std::function< void (double, BException ex) > asyncResult)  = 0;
	
	public: virtual ::std::wstring getString()  = 0;
	public: virtual void getString(::std::function< void (::std::wstring, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::test::api::prim::PPrimitiveTypes getPrimitiveTypes()  = 0;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  = 0;
	
	public: virtual PSerializable getObject()  = 0;
	public: virtual void getObject(::std::function< void (PSerializable, BException ex) > asyncResult)  = 0;
	
	public: virtual BDateTime getDate()  = 0;
	public: virtual void getDate(::std::function< void (BDateTime, BException ex) > asyncResult)  = 0;
	
	public: virtual void sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o)  = 0;
	public: virtual void sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual int32_t add(int32_t a, int32_t b)  = 0;
	public: virtual void add(int32_t a, int32_t b, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	public: virtual BDateTime makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond)  = 0;
	public: virtual void makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond, ::std::function< void (BDateTime, BException ex) > asyncResult)  = 0;
	
	public: virtual PArrayInt parseDate(const BDateTime& date)  = 0;
	public: virtual void parseDate(const BDateTime& date, ::std::function< void (PArrayInt, BException ex) > asyncResult)  = 0;
	
	public: virtual void throwException()  = 0;
	public: virtual void throwException(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemotePrimitiveTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemotePrimitiveTypes;
typedef byps_ptr<BStub_RemotePrimitiveTypes> PStub_RemotePrimitiveTypes;

class BStub_RemotePrimitiveTypes : public BStub, public virtual RemotePrimitiveTypes {
	
	public: BStub_RemotePrimitiveTypes(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void voidFunctionVoid() ;
	public: virtual void voidFunctionVoid(::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setBool(bool v) ;
	public: virtual void setBool(bool v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setByte(int8_t v) ;
	public: virtual void setByte(int8_t v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setChar(wchar_t v) ;
	public: virtual void setChar(wchar_t v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setShort(int16_t v) ;
	public: virtual void setShort(int16_t v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setInt(int32_t v) ;
	public: virtual void setInt(int32_t v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setLong(int64_t v) ;
	public: virtual void setLong(int64_t v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setFloat(float v) ;
	public: virtual void setFloat(float v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDouble(double v) ;
	public: virtual void setDouble(double v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setString(const ::std::wstring& v) ;
	public: virtual void setString(const ::std::wstring& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v) ;
	public: virtual void setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setObject(const PSerializable& v) ;
	public: virtual void setObject(const PSerializable& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDate(const BDateTime& v) ;
	public: virtual void setDate(const BDateTime& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual bool getBool() ;
	public: virtual void getBool(::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual int8_t getByte() ;
	public: virtual void getByte(::std::function< void (int8_t, BException ex) > asyncResult) ;
	public: virtual wchar_t getChar() ;
	public: virtual void getChar(::std::function< void (wchar_t, BException ex) > asyncResult) ;
	public: virtual int16_t getShort() ;
	public: virtual void getShort(::std::function< void (int16_t, BException ex) > asyncResult) ;
	public: virtual int32_t getInt() ;
	public: virtual void getInt(::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual int64_t getLong() ;
	public: virtual void getLong(::std::function< void (int64_t, BException ex) > asyncResult) ;
	public: virtual float getFloat() ;
	public: virtual void getFloat(::std::function< void (float, BException ex) > asyncResult) ;
	public: virtual double getDouble() ;
	public: virtual void getDouble(::std::function< void (double, BException ex) > asyncResult) ;
	public: virtual ::std::wstring getString() ;
	public: virtual void getString(::std::function< void (::std::wstring, BException ex) > asyncResult) ;
	public: virtual byps::test::api::prim::PPrimitiveTypes getPrimitiveTypes() ;
	public: virtual void getPrimitiveTypes(::std::function< void (byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult) ;
	public: virtual PSerializable getObject() ;
	public: virtual void getObject(::std::function< void (PSerializable, BException ex) > asyncResult) ;
	public: virtual BDateTime getDate() ;
	public: virtual void getDate(::std::function< void (BDateTime, BException ex) > asyncResult) ;
	public: virtual void sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o) ;
	public: virtual void sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual int32_t add(int32_t a, int32_t b) ;
	public: virtual void add(int32_t a, int32_t b, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual BDateTime makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond) ;
	public: virtual void makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond, ::std::function< void (BDateTime, BException ex) > asyncResult) ;
	public: virtual PArrayInt parseDate(const BDateTime& date) ;
	public: virtual void parseDate(const BDateTime& date, ::std::function< void (PArrayInt, BException ex) > asyncResult) ;
	public: virtual void throwException() ;
	public: virtual void throwException(::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteReferences

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteReferences : public virtual BRemote {
	
	public: virtual byps::test::api::refs::PNode getNode()  = 0;
	public: virtual void getNode(::std::function< void (byps::test::api::refs::PNode, BException ex) > asyncResult)  = 0;
	
	public: virtual void setNode(const byps::test::api::refs::PNode& v)  = 0;
	public: virtual void setNode(const byps::test::api::refs::PNode& v, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteReferences

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteReferences;
typedef byps_ptr<BStub_RemoteReferences> PStub_RemoteReferences;

class BStub_RemoteReferences : public BStub, public virtual RemoteReferences {
	
	public: BStub_RemoteReferences(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual byps::test::api::refs::PNode getNode() ;
	public: virtual void getNode(::std::function< void (byps::test::api::refs::PNode, BException ex) > asyncResult) ;
	public: virtual void setNode(const byps::test::api::refs::PNode& v) ;
	public: virtual void setNode(const byps::test::api::refs::PNode& v, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteServerCtrl

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteServerCtrl : public virtual BRemote {
	
	public: virtual void publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers)  = 0;
	public: virtual void publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PRemote getPublishedRemote(const ::std::wstring& name)  = 0;
	public: virtual void getPublishedRemote(const ::std::wstring& name, ::std::function< void (PRemote, BException ex) > asyncResult)  = 0;
	
	public: virtual void removePublishedRemote(const ::std::wstring& name)  = 0;
	public: virtual void removePublishedRemote(const ::std::wstring& name, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteServerCtrl

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteServerCtrl;
typedef byps_ptr<BStub_RemoteServerCtrl> PStub_RemoteServerCtrl;

class BStub_RemoteServerCtrl : public BStub, public virtual RemoteServerCtrl {
	
	public: BStub_RemoteServerCtrl(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers) ;
	public: virtual void publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PRemote getPublishedRemote(const ::std::wstring& name) ;
	public: virtual void getPublishedRemote(const ::std::wstring& name, ::std::function< void (PRemote, BException ex) > asyncResult) ;
	public: virtual void removePublishedRemote(const ::std::wstring& name) ;
	public: virtual void removePublishedRemote(const ::std::wstring& name, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteSetTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteSetTypes : public virtual BRemote {
	
	public: virtual byps::PSetBoolean getBoolean1()  = 0;
	public: virtual void getBoolean1(::std::function< void (byps::PSetBoolean, BException ex) > asyncResult)  = 0;
	
	public: virtual void setBoolean1(const byps::PSetBoolean& boolean1)  = 0;
	public: virtual void setBoolean1(const byps::PSetBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetByte getByte1()  = 0;
	public: virtual void getByte1(::std::function< void (byps::PSetByte, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte1(const byps::PSetByte& byte1)  = 0;
	public: virtual void setByte1(const byps::PSetByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetCharacter getChar1()  = 0;
	public: virtual void getChar1(::std::function< void (byps::PSetCharacter, BException ex) > asyncResult)  = 0;
	
	public: virtual void setChar1(const byps::PSetCharacter& char1)  = 0;
	public: virtual void setChar1(const byps::PSetCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetShort getShort1()  = 0;
	public: virtual void getShort1(::std::function< void (byps::PSetShort, BException ex) > asyncResult)  = 0;
	
	public: virtual void setShort1(const byps::PSetShort& short1)  = 0;
	public: virtual void setShort1(const byps::PSetShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetInteger getInt1()  = 0;
	public: virtual void getInt1(::std::function< void (byps::PSetInteger, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt1(const byps::PSetInteger& int1)  = 0;
	public: virtual void setInt1(const byps::PSetInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetLong getLong1()  = 0;
	public: virtual void getLong1(::std::function< void (byps::PSetLong, BException ex) > asyncResult)  = 0;
	
	public: virtual void setLong1(const byps::PSetLong& long1)  = 0;
	public: virtual void setLong1(const byps::PSetLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetFloat getFloat1()  = 0;
	public: virtual void getFloat1(::std::function< void (byps::PSetFloat, BException ex) > asyncResult)  = 0;
	
	public: virtual void setFloat1(const byps::PSetFloat& float1)  = 0;
	public: virtual void setFloat1(const byps::PSetFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetDouble getDouble1()  = 0;
	public: virtual void getDouble1(::std::function< void (byps::PSetDouble, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDouble1(const byps::PSetDouble& double1)  = 0;
	public: virtual void setDouble1(const byps::PSetDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetString getString1()  = 0;
	public: virtual void getString1(::std::function< void (byps::PSetString, BException ex) > asyncResult)  = 0;
	
	public: virtual void setString1(const byps::PSetString& string1)  = 0;
	public: virtual void setString1(const byps::PSetString& string1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > getPrimitiveTypes1()  = 0;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  = 0;
	public: virtual void setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::set< PBytes > > getByte2()  = 0;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::set< PBytes > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setByte2(const byps_ptr< ::std::set< PBytes > >& byte2)  = 0;
	public: virtual void setByte2(const byps_ptr< ::std::set< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::set< PArrayInt > > getInt2()  = 0;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::set< PArrayInt > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2)  = 0;
	public: virtual void setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::set< PSerializable > > getObj1()  = 0;
	public: virtual void getObj1(::std::function< void (byps_ptr< ::std::set< PSerializable > >, BException ex) > asyncResult)  = 0;
	
	public: virtual void setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1)  = 0;
	public: virtual void setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void setDate1(const byps::PSetDate& obj1)  = 0;
	public: virtual void setDate1(const byps::PSetDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetDate getDate1()  = 0;
	public: virtual void getDate1(::std::function< void (byps::PSetDate, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteSetTypes

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteSetTypes;
typedef byps_ptr<BStub_RemoteSetTypes> PStub_RemoteSetTypes;

class BStub_RemoteSetTypes : public BStub, public virtual RemoteSetTypes {
	
	public: BStub_RemoteSetTypes(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual byps::PSetBoolean getBoolean1() ;
	public: virtual void getBoolean1(::std::function< void (byps::PSetBoolean, BException ex) > asyncResult) ;
	public: virtual void setBoolean1(const byps::PSetBoolean& boolean1) ;
	public: virtual void setBoolean1(const byps::PSetBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetByte getByte1() ;
	public: virtual void getByte1(::std::function< void (byps::PSetByte, BException ex) > asyncResult) ;
	public: virtual void setByte1(const byps::PSetByte& byte1) ;
	public: virtual void setByte1(const byps::PSetByte& byte1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetCharacter getChar1() ;
	public: virtual void getChar1(::std::function< void (byps::PSetCharacter, BException ex) > asyncResult) ;
	public: virtual void setChar1(const byps::PSetCharacter& char1) ;
	public: virtual void setChar1(const byps::PSetCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetShort getShort1() ;
	public: virtual void getShort1(::std::function< void (byps::PSetShort, BException ex) > asyncResult) ;
	public: virtual void setShort1(const byps::PSetShort& short1) ;
	public: virtual void setShort1(const byps::PSetShort& short1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetInteger getInt1() ;
	public: virtual void getInt1(::std::function< void (byps::PSetInteger, BException ex) > asyncResult) ;
	public: virtual void setInt1(const byps::PSetInteger& int1) ;
	public: virtual void setInt1(const byps::PSetInteger& int1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetLong getLong1() ;
	public: virtual void getLong1(::std::function< void (byps::PSetLong, BException ex) > asyncResult) ;
	public: virtual void setLong1(const byps::PSetLong& long1) ;
	public: virtual void setLong1(const byps::PSetLong& long1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetFloat getFloat1() ;
	public: virtual void getFloat1(::std::function< void (byps::PSetFloat, BException ex) > asyncResult) ;
	public: virtual void setFloat1(const byps::PSetFloat& float1) ;
	public: virtual void setFloat1(const byps::PSetFloat& float1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetDouble getDouble1() ;
	public: virtual void getDouble1(::std::function< void (byps::PSetDouble, BException ex) > asyncResult) ;
	public: virtual void setDouble1(const byps::PSetDouble& double1) ;
	public: virtual void setDouble1(const byps::PSetDouble& double1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetString getString1() ;
	public: virtual void getString1(::std::function< void (byps::PSetString, BException ex) > asyncResult) ;
	public: virtual void setString1(const byps::PSetString& string1) ;
	public: virtual void setString1(const byps::PSetString& string1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > getPrimitiveTypes1() ;
	public: virtual void getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult) ;
	public: virtual void setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1) ;
	public: virtual void setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::set< PBytes > > getByte2() ;
	public: virtual void getByte2(::std::function< void (byps_ptr< ::std::set< PBytes > >, BException ex) > asyncResult) ;
	public: virtual void setByte2(const byps_ptr< ::std::set< PBytes > >& byte2) ;
	public: virtual void setByte2(const byps_ptr< ::std::set< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::set< PArrayInt > > getInt2() ;
	public: virtual void getInt2(::std::function< void (byps_ptr< ::std::set< PArrayInt > >, BException ex) > asyncResult) ;
	public: virtual void setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2) ;
	public: virtual void setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps_ptr< ::std::set< PSerializable > > getObj1() ;
	public: virtual void getObj1(::std::function< void (byps_ptr< ::std::set< PSerializable > >, BException ex) > asyncResult) ;
	public: virtual void setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1) ;
	public: virtual void setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setDate1(const byps::PSetDate& obj1) ;
	public: virtual void setDate1(const byps::PSetDate& obj1, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PSetDate getDate1() ;
	public: virtual void getDate1(::std::function< void (byps::PSetDate, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteStreams

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class RemoteStreams : public virtual BRemote {
	
	public: virtual PContentStream getImage()  = 0;
	public: virtual void getImage(::std::function< void (PContentStream, BException ex) > asyncResult)  = 0;
	
	public: virtual void setImage(const PContentStream& istrm)  = 0;
	public: virtual void setImage(const PContentStream& istrm, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PMapIntegerInputStream getImages()  = 0;
	public: virtual void getImages(::std::function< void (byps::PMapIntegerInputStream, BException ex) > asyncResult)  = 0;
	
	public: virtual void setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey)  = 0;
	public: virtual void setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void throwLastException()  = 0;
	public: virtual void throwLastException(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PContentStream getTextStream()  = 0;
	public: virtual void getTextStream(::std::function< void (PContentStream, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Return a large video stream to be able to test that byte ranges are correctly handled.
	/// </summary>
	/// <remarks>
	/// This functionality is currently only tested in the JSON API by TestVideoCheckSupportByteRange.html.
	/// </remarks>
	public: virtual PContentStream getVideoCheckSupportByteRange()  = 0;
	public: virtual void getVideoCheckSupportByteRange(::std::function< void (PContentStream, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Return stream without properties.
	/// </summary>
	/// <remarks>
	/// The properties must be made explicitly available on the client-side by calling
	/// BContentStream.ensureProperties()
	/// </remarks>
	public: virtual PContentStream getStreamDeferedProperies()  = 0;
	public: virtual void getStreamDeferedProperies(::std::function< void (PContentStream, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Stores a stream reference but does not create an internal copy (does not materialize)
	/// </summary>
	public: virtual void setStreamDoNotMaterialize(const PContentStream& stream)  = 0;
	public: virtual void setStreamDoNotMaterialize(const PContentStream& stream, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Return stream, do not call BContentStream.cloneStream().
	/// </summary>
	public: virtual PContentStream getStreamDoNotClone()  = 0;
	public: virtual void getStreamDoNotClone(::std::function< void (PContentStream, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteStreams

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteStreams;
typedef byps_ptr<BStub_RemoteStreams> PStub_RemoteStreams;

class BStub_RemoteStreams : public BStub, public virtual RemoteStreams {
	
	public: BStub_RemoteStreams(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual PContentStream getImage() ;
	public: virtual void getImage(::std::function< void (PContentStream, BException ex) > asyncResult) ;
	public: virtual void setImage(const PContentStream& istrm) ;
	public: virtual void setImage(const PContentStream& istrm, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::PMapIntegerInputStream getImages() ;
	public: virtual void getImages(::std::function< void (byps::PMapIntegerInputStream, BException ex) > asyncResult) ;
	public: virtual void setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey) ;
	public: virtual void setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void throwLastException() ;
	public: virtual void throwLastException(::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PContentStream getTextStream() ;
	public: virtual void getTextStream(::std::function< void (PContentStream, BException ex) > asyncResult) ;
	public: virtual PContentStream getVideoCheckSupportByteRange() ;
	public: virtual void getVideoCheckSupportByteRange(::std::function< void (PContentStream, BException ex) > asyncResult) ;
	public: virtual PContentStream getStreamDeferedProperies() ;
	public: virtual void getStreamDeferedProperies(::std::function< void (PContentStream, BException ex) > asyncResult) ;
	public: virtual void setStreamDoNotMaterialize(const PContentStream& stream) ;
	public: virtual void setStreamDoNotMaterialize(const PContentStream& stream, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PContentStream getStreamDoNotClone() ;
	public: virtual void getStreamDoNotClone(::std::function< void (PContentStream, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// RemoteWithAuthentication

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

/// <summary>
/// This interface is an example for using the authentication mechanism.
/// </summary>
class RemoteWithAuthentication : public virtual BRemote {
	
	/// <summary>
	/// Set authentication flag in MySession.
	/// </summary>
	public: virtual void setUseAuthentication(bool useAuth)  = 0;
	public: virtual void setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Login.
	/// </summary>
	/// <remarks>
	/// Only user "Fritz" is allowed to login.
	/// </remarks>
	public: virtual byps::test::api::auth::PSessionInfo login(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& userName, const ::std::wstring& userPwd)  = 0;
	public: virtual void login(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (byps::test::api::auth::PSessionInfo, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Do something.
	/// </summary>
	public: virtual int32_t doit(const byps::test::api::auth::PSessionInfo& sess, int32_t value)  = 0;
	public: virtual void doit(const byps::test::api::auth::PSessionInfo& sess, int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Logout
	/// </summary>
	public: virtual void expire(const byps::test::api::auth::PSessionInfo& sess)  = 0;
	public: virtual void expire(const byps::test::api::auth::PSessionInfo& sess, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Set the number of login calls nessesary to login the user.
	/// </summary>
	/// <remarks>
	/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
	/// </remarks>
	public: virtual void setReloginCount(int32_t count)  = 0;
	public: virtual void setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}

//-------------------------------------------------
// RemoteWithAuthenticationAuth

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

/// <summary>
/// This interface is an example for using the authentication mechanism.
/// </summary>
class RemoteWithAuthenticationAuth : public virtual BRemote {
	
	/// <summary>
	/// Set authentication flag in MySession.
	/// </summary>
	public: virtual void setUseAuthentication(bool useAuth)  = 0;
	public: virtual void setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Login.
	/// </summary>
	/// <remarks>
	/// Only user "Fritz" is allowed to login.
	/// </remarks>
	public: virtual byps::test::api::auth::PSessionInfo login(const ::std::wstring& userName, const ::std::wstring& userPwd)  = 0;
	public: virtual void login(const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (byps::test::api::auth::PSessionInfo, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Do something.
	/// </summary>
	public: virtual int32_t doit(int32_t value)  = 0;
	public: virtual void doit(int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Logout
	/// </summary>
	public: virtual void expire()  = 0;
	public: virtual void expire(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	/// <summary>
	/// Set the number of login calls nessesary to login the user.
	/// </summary>
	/// <remarks>
	/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
	/// </remarks>
	public: virtual void setReloginCount(int32_t count)  = 0;
	public: virtual void setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_RemoteWithAuthentication

namespace byps { namespace test { namespace api { namespace remote { 

using namespace ::byps;

class BStub_RemoteWithAuthentication;
typedef byps_ptr<BStub_RemoteWithAuthentication> PStub_RemoteWithAuthentication;

class BStub_RemoteWithAuthentication : public BStub, public virtual RemoteWithAuthenticationAuth {
	
	public: BStub_RemoteWithAuthentication(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void setUseAuthentication(bool useAuth) ;
	public: virtual void setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual byps::test::api::auth::PSessionInfo login(const ::std::wstring& userName, const ::std::wstring& userPwd) ;
	public: virtual void login(const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (byps::test::api::auth::PSessionInfo, BException ex) > asyncResult) ;
	public: virtual int32_t doit(int32_t value) ;
	public: virtual void doit(int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual void expire() ;
	public: virtual void expire(::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void setReloginCount(int32_t count) ;
	public: virtual void setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// ClientIF

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class ClientIF : public virtual BRemote {
	
	public: virtual int32_t incrementInt(int32_t a)  = 0;
	public: virtual void incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorInputStream getStreams(int32_t ctrl)  = 0;
	public: virtual void getStreams(int32_t ctrl, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult)  = 0;
	
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl)  = 0;
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PChatStructure sendChat(const PChatStructure& cs)  = 0;
	public: virtual void sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Skeleton class BSkeleton_ClientIF
// Your interface implementation class has to be derived from this skeleton.
// Either provide an asynchronous or a synchronous function in your subclass.

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class BSkeleton_ClientIF;
typedef byps_ptr<BSkeleton_ClientIF> PSkeleton_ClientIF;

class BSkeleton_ClientIF : public BSkeleton, public virtual ClientIF {
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual int32_t incrementInt(int32_t a) ;
	public: virtual void incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	
	public: virtual byps::PVectorInputStream getStreams(int32_t ctrl) ;
	public: virtual void getStreams(int32_t ctrl, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult) ;
	
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl) ;
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult) ;
	
	public: virtual PChatStructure sendChat(const PChatStructure& cs) ;
	public: virtual void sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult) ;
	
	
};
}}}}

//-------------------------------------------------
// Stub class BStub_ClientIF

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class BStub_ClientIF;
typedef byps_ptr<BStub_ClientIF> PStub_ClientIF;

class BStub_ClientIF : public BStub, public virtual ClientIF {
	
	public: BStub_ClientIF(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual int32_t incrementInt(int32_t a) ;
	public: virtual void incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual byps::PVectorInputStream getStreams(int32_t ctrl) ;
	public: virtual void getStreams(int32_t ctrl, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult) ;
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl) ;
	public: virtual void putStreams(const byps::PVectorInputStream& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PChatStructure sendChat(const PChatStructure& cs) ;
	public: virtual void sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// ServerIF

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class ServerIF : public virtual BRemote {
	
	public: virtual int32_t callClientIncrementInt(int32_t v)  = 0;
	public: virtual void callClientIncrementInt(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	public: virtual void setPartner(const PClientIF& client)  = 0;
	public: virtual void setPartner(const PClientIF& client, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PClientIF getPartner()  = 0;
	public: virtual void getPartner(::std::function< void (PClientIF, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PVectorInputStream getStreamsFromClient(bool materializeOnServer)  = 0;
	public: virtual void getStreamsFromClient(bool materializeOnServer, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult)  = 0;
	
	public: virtual void putStreamsOnClient(const byps::PVectorInputStream& streams)  = 0;
	public: virtual void putStreamsOnClient(const byps::PVectorInputStream& streams, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void registerWithClientMap(int32_t id)  = 0;
	public: virtual void registerWithClientMap(int32_t id, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PClientIF getClient(int32_t id)  = 0;
	public: virtual void getClient(int32_t id, ::std::function< void (PClientIF, BException ex) > asyncResult)  = 0;
	
	public: virtual byps::PSetInteger getClientIds()  = 0;
	public: virtual void getClientIds(::std::function< void (byps::PSetInteger, BException ex) > asyncResult)  = 0;
	
	public: virtual int32_t callClientParallel(int32_t v)  = 0;
	public: virtual void callClientParallel(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_ServerIF

namespace byps { namespace test { namespace api { namespace srvr { 

using namespace ::byps;

class BStub_ServerIF;
typedef byps_ptr<BStub_ServerIF> PStub_ServerIF;

class BStub_ServerIF : public BStub, public virtual ServerIF {
	
	public: BStub_ServerIF(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual int32_t callClientIncrementInt(int32_t v) ;
	public: virtual void callClientIncrementInt(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	public: virtual void setPartner(const PClientIF& client) ;
	public: virtual void setPartner(const PClientIF& client, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PClientIF getPartner() ;
	public: virtual void getPartner(::std::function< void (PClientIF, BException ex) > asyncResult) ;
	public: virtual byps::PVectorInputStream getStreamsFromClient(bool materializeOnServer) ;
	public: virtual void getStreamsFromClient(bool materializeOnServer, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult) ;
	public: virtual void putStreamsOnClient(const byps::PVectorInputStream& streams) ;
	public: virtual void putStreamsOnClient(const byps::PVectorInputStream& streams, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual void registerWithClientMap(int32_t id) ;
	public: virtual void registerWithClientMap(int32_t id, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PClientIF getClient(int32_t id) ;
	public: virtual void getClient(int32_t id, ::std::function< void (PClientIF, BException ex) > asyncResult) ;
	public: virtual byps::PSetInteger getClientIds() ;
	public: virtual void getClientIds(::std::function< void (byps::PSetInteger, BException ex) > asyncResult) ;
	public: virtual int32_t callClientParallel(int32_t v) ;
	public: virtual void callClientParallel(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
// EvolveIF

namespace byps { namespace test { namespace api { namespace ver { 

using namespace ::byps;

class EvolveIF : public virtual BRemote {
	
	public: virtual void setEvolve(const PEvolve& obj)  = 0;
	public: virtual void setEvolve(const PEvolve& obj, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PEvolve getEvolve()  = 0;
	public: virtual void getEvolve(::std::function< void (PEvolve, BException ex) > asyncResult)  = 0;
	
	public: virtual void setClient(const PEvolveIF& partner)  = 0;
	public: virtual void setClient(const PEvolveIF& partner, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual PEvolveIF getClient()  = 0;
	public: virtual void getClient(::std::function< void (PEvolveIF, BException ex) > asyncResult)  = 0;
	
	public: virtual void sendEvolveToClient()  = 0;
	public: virtual void sendEvolveToClient(::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	
};

}}}}
//-------------------------------------------------
// Stub class BStub_EvolveIF

namespace byps { namespace test { namespace api { namespace ver { 

using namespace ::byps;

class BStub_EvolveIF;
typedef byps_ptr<BStub_EvolveIF> PStub_EvolveIF;

class BStub_EvolveIF : public BStub, public virtual EvolveIF {
	
	public: BStub_EvolveIF(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId();
	public: virtual void setEvolve(const PEvolve& obj) ;
	public: virtual void setEvolve(const PEvolve& obj, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PEvolve getEvolve() ;
	public: virtual void getEvolve(::std::function< void (PEvolve, BException ex) > asyncResult) ;
	public: virtual void setClient(const PEvolveIF& partner) ;
	public: virtual void setClient(const PEvolveIF& partner, ::std::function< void (bool, BException ex) > asyncResult) ;
	public: virtual PEvolveIF getClient() ;
	public: virtual void getClient(::std::function< void (PEvolveIF, BException ex) > asyncResult) ;
	public: virtual void sendEvolveToClient() ;
	public: virtual void sendEvolveToClient(::std::function< void (bool, BException ex) > asyncResult) ;
	
};
}}}}


//-------------------------------------------------
namespace byps { namespace test { namespace api { 

class BRegistry_Testser : public BRegistry { 
public:
	BRegistry_Testser();
	virtual ~BRegistry_Testser() {}
};

}}}

namespace byps { namespace test { namespace api { 
using namespace ::byps;

class BApiDescriptor_Testser { 
	/**
	 * API serialisation version: 793.0.0.0
	 */
	public: const static int64_t VERSION = 79300000000000000LL;
	public: static PApiDescriptor instance();
};

}}}

namespace byps { namespace test { namespace api { 

using namespace ::byps;

class BClient_Testser;
typedef byps_ptr<BClient_Testser> PClient_Testser;

class BClient_Testser : public BClient { 

	public: static PClient_Testser createClient(PTransportFactory transportFactory);
	
	public: static PClient_Testser createClientR(PTransport transport);
	
	public: void addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton);
	
	protected: BClient_Testser(PTransportFactory transportFactory); 
	
	protected: BClient_Testser(PTransport transport); 
	
	public: virtual ~BClient_Testser() {}
	
	virtual byps::test::api::inherit::PBioFruitServiceAuth getBioFruitService();	
	virtual byps::test::api::inherit::PBioLemonServiceAuth getBioLemonService();	
	virtual byps::test::api::inherit::PFruitServiceAuth getFruitService();	
	virtual byps::test::api::inherit::PLemonServiceAuth getLemonService();	
	virtual byps::test::api::inherit::PPlantServiceAuth getPlantService();	
	virtual byps::test::api::remote::PRemoteArrayTypes1dim getRemoteArrayTypes1dim();	
	virtual byps::test::api::remote::PRemoteArrayTypes23 getRemoteArrayTypes23();	
	virtual byps::test::api::remote::PRemoteArrayTypes4dim getRemoteArrayTypes4dim();	
	virtual byps::test::api::remote::PRemoteConstants getRemoteConstants();	
	virtual byps::test::api::remote::PRemoteEnums getRemoteEnums();	
	virtual byps::test::api::remote::PRemoteInlineInstance getRemoteInlineInstance();	
	virtual byps::test::api::remote::PRemoteListTypes getRemoteListTypes();	
	virtual byps::test::api::remote::PRemoteMapTypes getRemoteMapTypes();	
	virtual byps::test::api::remote::PRemotePrimitiveTypes getRemotePrimitiveTypes();	
	virtual byps::test::api::remote::PRemoteReferences getRemoteReferences();	
	virtual byps::test::api::remote::PRemoteServerCtrl getRemoteServerCtrl();	
	virtual byps::test::api::remote::PRemoteSetTypes getRemoteSetTypes();	
	virtual byps::test::api::remote::PRemoteStreams getRemoteStreams();	
	virtual byps::test::api::remote::PRemoteWithAuthenticationAuth getRemoteWithAuthentication();	
	virtual byps::test::api::srvr::PClientIF getClientIF();	
	virtual byps::test::api::srvr::PServerIF getServerIF();	
	virtual byps::test::api::ver::PEvolveIF getEvolveIF();	
	
	public: virtual PRemote getStub(int remoteId);
	
	protected: byps::test::api::inherit::PBioFruitServiceAuth bioFruitService;
	protected: byps::test::api::inherit::PBioLemonServiceAuth bioLemonService;
	protected: byps::test::api::inherit::PFruitServiceAuth fruitService;
	protected: byps::test::api::inherit::PLemonServiceAuth lemonService;
	protected: byps::test::api::inherit::PPlantServiceAuth plantService;
	protected: byps::test::api::remote::PRemoteArrayTypes1dim remoteArrayTypes1dim;
	protected: byps::test::api::remote::PRemoteArrayTypes23 remoteArrayTypes23;
	protected: byps::test::api::remote::PRemoteArrayTypes4dim remoteArrayTypes4dim;
	protected: byps::test::api::remote::PRemoteConstants remoteConstants;
	protected: byps::test::api::remote::PRemoteEnums remoteEnums;
	protected: byps::test::api::remote::PRemoteInlineInstance remoteInlineInstance;
	protected: byps::test::api::remote::PRemoteListTypes remoteListTypes;
	protected: byps::test::api::remote::PRemoteMapTypes remoteMapTypes;
	protected: byps::test::api::remote::PRemotePrimitiveTypes remotePrimitiveTypes;
	protected: byps::test::api::remote::PRemoteReferences remoteReferences;
	protected: byps::test::api::remote::PRemoteServerCtrl remoteServerCtrl;
	protected: byps::test::api::remote::PRemoteSetTypes remoteSetTypes;
	protected: byps::test::api::remote::PRemoteStreams remoteStreams;
	protected: byps::test::api::remote::PRemoteWithAuthenticationAuth remoteWithAuthentication;
	protected: byps::test::api::srvr::PClientIF clientIF;
	protected: byps::test::api::srvr::PServerIF serverIF;
	protected: byps::test::api::ver::PEvolveIF evolveIF;
	
	private: void initStubs(PTransport transport);
	
};

}}}

namespace byps { namespace test { namespace api { 

using namespace ::byps;

class BServer_Testser;
typedef byps_ptr<BServer_Testser> PServer_Testser;

class BServer_Testser : public BServer { 

	public: static PServer_Testser createServer(PTransportFactory transportFactory);
	
	public: static PServer_Testser createServerR(PTransport transport);
	
	public: void addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton);
	
	protected: BServer_Testser(PTransportFactory transportFactory); 
	
	protected: BServer_Testser(PTransport transport); 
	
};

}}}


#endif
