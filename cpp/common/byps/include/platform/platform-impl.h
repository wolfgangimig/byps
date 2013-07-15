#ifndef PLATFORM_IMPL_H_
#define PLATFORM_IMPL_H_

#ifdef _MSC_VER

// Two or more members have the same name. 
// This warning is printed for BRemote_getTargetId.
#pragma warning( disable : 4250 ) 

// Decorated name length exceeded, name was truncated.
#pragma warning( disable : 4503 ) 


#elif __GNUC__

#pragma GCC diagnostic ignored "-Wunused-parameter"

#endif

#endif
