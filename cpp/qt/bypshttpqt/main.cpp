#include <QCoreApplication>


#include "Byps.hpp"
#include "BypsHttp.hpp"
#include "BLogger.hpp"

LOGGER_IMPL

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);
    
    return a.exec();
}

