/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BAUTHENTICATION_H
#define BAUTHENTICATION_H

#include "Byps.h"

namespace byps {

using namespace ::std;

class BAuthentication 
{
public:
	virtual ~BAuthentication() {};
	virtual bool isReloginException(PClient client, BException ex, BTYPEID typeId) = 0;

#ifdef CPP11_LAMBDA
	virtual void authenticate(PClient client, function<void (bool, BException)> asyncResult) = 0;
	virtual void getSession(PClient client, BTYPEID typeId, function<void (PSerializable, BException)> asyncResult) = 0;

	virtual void authenticate(PClient client, PAsyncResult asyncResult) {
		authenticate(client, [asyncResult](bool ignored, BException ex) {
			if (ex) {
				asyncResult->setAsyncResult(BVariant(ex));
			}
			else {
				asyncResult->setAsyncResult(BVariant(ignored));
			}
		});
	}

	virtual void getSession(PClient client, BTYPEID typeId, PAsyncResult asyncResult) {
		getSession(client, typeId, [asyncResult](PSerializable session, BException ex) {
			if (ex) {
				asyncResult->setAsyncResult(BVariant(ex));
			}
			else {
				asyncResult->setAsyncResult(BVariant(session));
			}
		});
	}

#else
	virtual void authenticate(PClient client, PAsyncResult asyncResult) = 0;
	virtual void getSession(PClient client, BTYPEID typeId, PAsyncResult asyncResult) = 0;
#endif

};


}


#endif