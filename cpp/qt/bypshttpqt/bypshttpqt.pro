#-------------------------------------------------
#
# Project created by QtCreator 2013-07-15T22:35:01
#
#-------------------------------------------------

QT       += core
QT       += network
QT       -= gui

INCLUDEPATH += ../../common/byps/include
INCLUDEPATH += ../../common/bypshttp/include

QMAKE_CXXFLAGS += -std=c++11

TARGET = bypshttpqt
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app


SOURCES += main.cpp

HEADERS += \
    ../../common/bypshttp/include/HWireClientI.h \
    ../../common/bypshttp/include/HWireClient.hpp \
    ../../common/bypshttp/include/HWireClient.h \
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
    ../../common/byps/include/platform/qt/QTThreadPool.hpp \
    ../../common/byps/include/platform/qt/QTThreadPool.h
