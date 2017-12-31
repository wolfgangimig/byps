//
//  bypslib.cpp
//  bypslib
//
//  Created by Wolfgang Imig on 30.12.17.
//  Copyright © 2017 Wolfgang Imig. All rights reserved.
//

#include "Bypshttp.hpp"

#include <iostream>
#include "bypslib.hpp"
#include "bypslibPriv.hpp"


void bypslib::HelloWorld(const char * s)
{
    bypslibPriv *theObj = new bypslibPriv;
    theObj->HelloWorldPriv(s);
    delete theObj;
};

void bypslibPriv::HelloWorldPriv(const char * s) 
{
    std::cout << s << std::endl;
};

