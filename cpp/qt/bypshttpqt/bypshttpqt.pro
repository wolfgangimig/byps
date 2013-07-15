#-------------------------------------------------
#
# Project created by QtCreator 2013-07-15T22:35:01
#
#-------------------------------------------------

QT       += core
QT       += network
QT       -= gui

INCLUDEPATH += ../../common/byps/include
INCLUDEPATH += ../../common/bypshttpqt/include

QMAKE_CXXFLAGS += -std=c++11

TARGET = bypshttpqt
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app


SOURCES += main.cpp

HEADERS += \
    ../../common/bypshttpqt/include/HWireClientI.h \
    ../../common/bypshttpqt/include/HWireClient.hpp \
    ../../common/bypshttpqt/include/HWireClient.h \
    ../../common/bypshttpqt/include/BypsHttp.hpp \
    ../../common/bypshttpqt/include/BypsHttp.h
