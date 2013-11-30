/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BYPSHTTP_HPP_
#define BYPSHTTP_HPP_

#include "Bypshttp.h"
#include "HWireClient.hpp"
#include "HServerR.hpp"
#include "HTransportFactoryClient.hpp"
#include "HHttpClient.hpp"

#ifdef _MSC_VER
#include "platform/win/WinHttpClient.hpp"
#endif

#ifdef QT_NETWORK_LIB
#include "platform/qt/QTHttpClient.hpp"
#endif

#endif
