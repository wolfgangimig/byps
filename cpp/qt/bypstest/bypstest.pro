#-------------------------------------------------
#
# Project created by QtCreator 2013-07-21T11:57:43
#
#-------------------------------------------------

QT       += core
QT       += network
QT       -= gui

QMAKE_CXXFLAGS += -std=c++11

TARGET = bypstest
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app

INCLUDEPATH += ../../common/byps/include
INCLUDEPATH += ../../common/bypshttp/include
INCLUDEPATH += ../../common/testfw/include
INCLUDEPATH += ../../common/bypstest/
INCLUDEPATH += ../../common/bypstest/bypstest-gen/api
INCLUDEPATH += ../../common/bypstest/bypstest-gen/impl

SOURCES += main.cpp \
    ../../common/bypstest/TestUtils.cpp \
    ../../common/bypstest/TestUtilHttp.cpp \
    ../../common/bypstest/TestRemoteStreams.cpp \
    ../../common/bypstest/TestRemoteSetTypes.cpp \
    ../../common/bypstest/TestRemoteServerR.cpp \
    ../../common/bypstest/TestRemotePrimitiveTypes.cpp \
    ../../common/bypstest/TestRemoteMapTypes.cpp \
    ../../common/bypstest/TestRemoteListTypes.cpp \
    ../../common/bypstest/TestRemoteInlineInstance.cpp \
    ../../common/bypstest/TestRemoteEnums.cpp \
    ../../common/bypstest/TestRemoteConstants.cpp \
    ../../common/bypstest/TestRemoteArrays4Dim.cpp \
    ../../common/bypstest/TestRemoteArrays.cpp \
    ../../common/bypstest/TestBase.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-017.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-016.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-015.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-014.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-013.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-012.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-011.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-010.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-009.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-008.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-007.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-006.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-005.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-004.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-003.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-002.cpp \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl-001.cpp \
    ../../common/bypstest/AllTests.cpp

HEADERS += \
    ../../common/bypstest/TestUtils.h \
    ../../common/bypstest/TestUtilHttp.h \
    ../../common/bypstest/TestBase.h \
    ../../common/bypstest/AllTests.h \
    ../../common/bypstest/bypstest-gen/api/Testser-api.h \
    ../../common/bypstest/bypstest-gen/impl/Testser-impl.h \
    ../../common/bypshttp/include/HWireClientI.h \
    ../../common/bypshttp/include/HWireClient.hpp \
    ../../common/bypshttp/include/HWireClient.h \
    ../../common/bypshttp/include/HTransportFactoryClient.hpp \
    ../../common/bypshttp/include/HTransportFactoryClient.h \
    ../../common/bypshttp/include/HServerR.hpp \
    ../../common/bypshttp/include/HServerR.h \
    ../../common/bypshttp/include/HHttpClient.hpp \
    ../../common/bypshttp/include/HHttpClient.h \
    ../../common/bypshttp/include/Bypshttp.hpp \
    ../../common/bypshttp/include/Bypshttp.h \
    ../../common/bypshttp/include/platform/qt/QTHttpClient.hpp \
    ../../common/bypshttp/include/platform/qt/QTHttpClient.h \
    ../../common/bypshttp/include/platform/qt/QTHttpClientI.h \
    main.h \
    ../../common/byps/include/Byps.hpp \
    ../../common/byps/include/Byps.h \
    ../../common/byps/include/Byps-impl.h \
    ../../common/byps/include/BWire.hpp \
    ../../common/byps/include/BWire.h \
    ../../common/byps/include/BVariant.hpp \
    ../../common/byps/include/BVariant.h \
    ../../common/byps/include/BUtils.hpp \
    ../../common/byps/include/BUtils.h \
    ../../common/byps/include/BTransportFactory.h \
    ../../common/byps/include/BTransport.hpp \
    ../../common/byps/include/BTransport.h \
    ../../common/byps/include/BThreadPool.hpp \
    ../../common/byps/include/BThreadPool.h \
    ../../common/byps/include/BTestAdapter.h \
    ../../common/byps/include/BTargetId.hpp \
    ../../common/byps/include/BTargetId.h \
    ../../common/byps/include/BSynchronized.h \
    ../../common/byps/include/BStub.hpp \
    ../../common/byps/include/BStub.h \
    ../../common/byps/include/BStreamRequest.hpp \
    ../../common/byps/include/BStreamRequest.h \
    ../../common/byps/include/BSkeleton.hpp \
    ../../common/byps/include/BSkeleton.h \
    ../../common/byps/include/BServer.hpp \
    ../../common/byps/include/BServer.h \
    ../../common/byps/include/BSerializer.hpp \
    ../../common/byps/include/BSerializer.h \
    ../../common/byps/include/BSerializable.hpp \
    ../../common/byps/include/BSerializable.h \
    ../../common/byps/include/BRemote.h \
    ../../common/byps/include/BRegistry.hpp \
    ../../common/byps/include/BRegistry.h \
    ../../common/byps/include/BProtocol.hpp \
    ../../common/byps/include/BProtocol.h \
    ../../common/byps/include/BOutput.hpp \
    ../../common/byps/include/BOutput.h \
    ../../common/byps/include/BNegotiate.hpp \
    ../../common/byps/include/BNegotiate.h \
    ../../common/byps/include/BMethodResult.hpp \
    ../../common/byps/include/BMethodResult.h \
    ../../common/byps/include/BMethodRequest.hpp \
    ../../common/byps/include/BMethodRequest.h \
    ../../common/byps/include/BMessageHeader.hpp \
    ../../common/byps/include/BMessageHeader.h \
    ../../common/byps/include/BMessage.hpp \
    ../../common/byps/include/BMessage.h \
    ../../common/byps/include/BLogger.hpp \
    ../../common/byps/include/BLogger.h \
    ../../common/byps/include/BIO.hpp \
    ../../common/byps/include/BIO.h \
    ../../common/byps/include/BInput.hpp \
    ../../common/byps/include/BInput.h \
    ../../common/byps/include/BException.hpp \
    ../../common/byps/include/BException.h \
    ../../common/byps/include/BContentStream.hpp \
    ../../common/byps/include/BContentStream.h \
    ../../common/byps/include/BClient.hpp \
    ../../common/byps/include/BClient.h \
    ../../common/byps/include/BBytes.hpp \
    ../../common/byps/include/BBytes.h \
    ../../common/byps/include/BByteOrder.h \
    ../../common/byps/include/BBuffer.hpp \
    ../../common/byps/include/BBuffer.h \
    ../../common/byps/include/BBinaryModel.h \
    ../../common/byps/include/BAsyncResult.hpp \
    ../../common/byps/include/BAsyncResult.h \
    ../../common/byps/include/BArray.hpp \
    ../../common/byps/include/BArray.h \
    ../../common/byps/include/BApiDescriptor.h \
    ../../common/byps/include/platform/platform.hpp \
    ../../common/byps/include/platform/platform-impl.h \
    ../../common/byps/include/platform/platform-api.h \
    ../../common/byps/include/platform/qt/QTThreadPool.hpp \
    ../../common/byps/include/platform/qt/QTThreadPool.h \
    ../../common/testfw/include/TestSuite.hpp \
    ../../common/testfw/include/TestSuite.h \
    ../../common/testfw/include/testfw.hpp \
    ../../common/testfw/include/testfw.h \
    ../../common/testfw/include/TestCase.hpp \
    ../../common/testfw/include/TestCase.h \
    ../../common/testfw/include/TestAssert.h \
    ../../common/testfw/include/AssertException.hpp \
    ../../common/testfw/include/AssertException.h
