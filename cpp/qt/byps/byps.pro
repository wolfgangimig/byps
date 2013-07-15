#-------------------------------------------------
#
# Project created by QtCreator 2013-07-15T22:22:19
#
#-------------------------------------------------

QT       += core

QT       -= gui

INCLUDEPATH += ../../common/byps/include
INCLUDEPATH += d:/boost_1_50_0

QMAKE_CXXFLAGS += -std=c++11

TARGET = byps
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app


SOURCES += main.cpp

HEADERS += \
    ../../common/byps/include/Byps-impl.h \
    ../../common/byps/include/Byps.hpp \
    ../../common/byps/include/Byps.h \
    ../../common/byps/include/BWire.hpp \
    ../../common/byps/include/BWire.h \
    ../../common/byps/include/BVariant.hpp \
    ../../common/byps/include/BVariant.h \
    ../../common/byps/include/BUtils.hpp \
    ../../common/byps/include/BUtils.h \
    ../../common/byps/include/BTransportFactory.h \
    ../../common/byps/include/BTransport.hpp \
    ../../common/byps/include/BTransport.h \
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
    ../../common/byps/include/platform/platform-impl.h \
    ../../common/byps/include/platform/platform-api.h \
    ../../common/byps/include/platform/msvc_x86_x64.h \
    ../../common/byps/include/platform/gcc_x86_x64.h \
    ../../common/byps/include/platform/any.h
