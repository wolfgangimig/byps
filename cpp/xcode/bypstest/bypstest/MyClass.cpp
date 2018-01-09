//
//  MyClass.cpp
//  bypstest
//
//  Created by Wolfgang Imig on 01.01.18.
//  Copyright © 2018 Wolfgang Imig. All rights reserved.
//

#include "MyClass.hpp"
#include "AllTests.h"

extern "C" {
    void doit(void* app) {
        printf("doit\n");
        AllTests_run(app);
    }

}

