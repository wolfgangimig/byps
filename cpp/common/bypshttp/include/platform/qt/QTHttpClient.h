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

namespace com { namespace wilutions { namespace byps { namespace http {

PHttpClient HttpClient_create();

}}}}

#endif // QTHTTPCLIENT_H
