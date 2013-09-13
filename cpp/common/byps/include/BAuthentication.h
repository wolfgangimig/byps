#ifndef BAUTHENTICATION_H
#define BAUTHENTICATION_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

using namespace ::std;

class BAuthentication 
{
public:
	virtual ~BAuthentication() {};
	virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) = 0;
	virtual bool isReloginException(PClient client, BException ex, BTYPEID typeId) = 0;
	virtual PSerializable getSession() = 0;
};


}}}


#endif