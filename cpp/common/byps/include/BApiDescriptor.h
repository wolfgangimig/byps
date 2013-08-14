#ifndef BAPIDESCRIPTOR_H_
#define BAPIDESCRIPTOR_H_

#include "Byps.h"
#include "BRegistry.h"
#include "BBinaryModel.h"

namespace com { namespace wilutions { namespace byps {

class BApiDescriptor {
public:
    const std::string name;
    const std::string pack;
    const int32_t version;
    const bool uniqueObjects;
    
    BApiDescriptor(const std::string& name, const std::string& package,
			int32_t version, bool uniqueObjects)
    :  name(name), pack(package), version(version), uniqueObjects(uniqueObjects) {
		
	}

	BApiDescriptor* addRegistry(PRegistry reg) {
		this->registry = reg;
		return this;
	}

	std::string getProtocolIds() {
		return std::string("S");
	}

	PRegistry getRegistry(BBinaryModel ) {
		return registry;
	}

protected:
	PRegistry registry;

};

}}}

#endif /* BAPIDESCRIPTOR_H_ */
