#include <QCoreApplication>


#include "Byps.hpp"
#include "Bypshttp.hpp"
#include "BLogger.hpp"

LOGGER_IMPL

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);
    
    return a.exec();
}

