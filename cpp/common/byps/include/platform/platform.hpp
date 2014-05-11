/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef PLATFORM_HPP
#define PLATFORM_HPP

#ifdef _MSC_VER

#include "msvc/msvc_x86_x64.h"

#endif

#ifdef QT_VERSION

#include "qt/QTThreadPool.hpp"

#endif

#include "any/BThreadPool.hpp"
#include "any/any.hpp"



#endif // PLATFORM_HPP
