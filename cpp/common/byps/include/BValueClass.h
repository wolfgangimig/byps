#ifndef BVALUECLASS_H_
#define BVALUECLASS_H_

#include "Byps.h"
#include "BRegistry.h"
#include "BBinaryModel.h"

namespace byps {

class BValueClass : public BSerializable {

protected:
	int64_t changedMembers;
	POBJECT dbHelper;

	BValueClass() : changedMembers(0) {}

public:

	void setChangedMember(int64_t v) { 
		changedMembers |= v;
	}

	void setChangedMembers(int64_t v) { changedMembers = v; }
	int64_t getChangedMembers() { return changedMembers; }

	void setDBHelper(POBJECT p) { dbHelper = p; }
	POBJECT getDBHelper() { return dbHelper; }
	
	void serialize(BIO& ar, const BVERSION version);
};

}

#endif