#ifndef BYPSHTTP_H_
#define BYPSHTTP_H_

#include "Byps.h"

// VS2012 memory leak in std::thread
// http://connect.microsoft.com/VisualStudio/feedback/details/757212/vs-2012-rc-std-thread-reports-memory-leak-even-on-stack

#include <Windows.h>
#include <Winhttp.h>
#include "HException.h"
#include "HWireClient.h"
#include "HServerR.h"
#include "HTransportFactoryClient.h"
#include "HThreadPool.h"

#endif