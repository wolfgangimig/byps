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
    main.h
