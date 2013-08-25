#ifndef MAIN_H
#define MAIN_H

#include <QObject>
#include "Bypshttp.h"

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;

class Task : public QObject
{
    Q_OBJECT

public:
    Task(QObject *parent = 0) : QObject(parent) {}

public slots:
    void run();

signals:
    void finished();
};




#endif // MAIN_H
