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
    const BBinaryModel bmodel;
    const int32_t version;
    const bool uniqueObjects;
    const PRegistry registry;

    BApiDescriptor(const std::string& name, const std::string& package,
            const BBinaryModel& bmodel, 
			int32_t version, bool uniqueObjects, PRegistry registry)
    :  name(name), pack(package), bmodel(bmodel), version(version), uniqueObjects(uniqueObjects), registry(registry) {
		
	}

};

}}}

#endif /* BAPIDESCRIPTOR_H_ */
