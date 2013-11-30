/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef QTHTTPCLIENT_H
#define QTHTTPCLIENT_H


#include <QCoreApplication>
#include <QNetworkAccessManager>
#include <QUrl>
#include <QNetworkRequest>
#include <QIODevice>
#include <QtNetwork>
#include <QThread>

#include "Byps.h"
#include "Bypshttp.h"

namespace byps { namespace http {

PHttpClient HttpClient_create(void* app);

}}

#endif // QTHTTPCLIENT_H
