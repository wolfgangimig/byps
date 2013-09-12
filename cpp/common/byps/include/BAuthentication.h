#ifndef BAUTHENTICATION_H
#define BAUTHENTICATION_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

using namespace ::std;

class BAuthentication 
{
public:
	virtual ~BAuthentication() = 0;
	virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) = 0;
	virtual bool isReloginException(PClient client, const std::exception& ex, BTYPEID typeId) = 0;
	virtual PSerializable getSession() = 0;
};


}}}


#endif