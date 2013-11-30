/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BYPSHTTP_H_
#define BYPSHTTP_H_

#include "Byps.h"

namespace byps { namespace http {

class HHttpClient;
typedef byps_ptr<HHttpClient> PHttpClient;

}}


// VS2012 memory leak in std::thread
// http://connect.microsoft.com/VisualStudio/feedback/details/757212/vs-2012-rc-std-thread-reports-memory-leak-even-on-stack


#include "HWireClient.h"
#include "HServerR.h"
#include "HTransportFactoryClient.h"
#include "HHttpClient.h"

#ifdef QT_NETWORK_LIB

#include "platform/qt/QTHttpClient.h"

#elif _MSC_VER

#include "platform/win/WinHttpClient.h"

#endif

#endif
