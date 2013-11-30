/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef PLATFORM_API_H_
#define PLATFORM_API_H_

#ifdef _MSC_VER

#include "msvc/msvc_x86_x64.h"

#elif __GNUC__

#include "gcc/gcc_x86_x64.h"

#endif

#ifdef QT_VERSION

#include "qt/QTThreadPool.h"

#endif

#include "any/any.h"


#endif
