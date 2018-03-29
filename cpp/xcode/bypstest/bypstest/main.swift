//
//  main.swift
//  bypstest
//
//  Created by Wolfgang Imig on 01.01.18.
//  Copyright © 2018 Wolfgang Imig. All rights reserved.
//


import Foundation

let fact = SwiftHttpClientFactory();
let factPtr = UnsafeMutableRawPointer(Unmanaged.passUnretained(fact).toOpaque());

func bridge(_ obj : SwiftHttpClientFactory) -> UnsafeMutableRawPointer {
    return UnsafeMutableRawPointer(Unmanaged.passUnretained(obj).toOpaque())
}

func bridge(_ ptr : UnsafeMutableRawPointer) -> SwiftHttpClientFactory? {
    return Unmanaged.fromOpaque(ptr).takeUnretainedValue()
}

byps_http_setFactory2(bridge(fact), {(observer) -> UnsafeMutableRawPointer? in
    // Extract pointer to `self` from void pointer:
    let me = bridge(observer!);
    // Call instance method:
    let httpClient = me!.create();
    let httpClientPtr = UnsafeMutableRawPointer(Unmanaged.passUnretained(httpClient).toOpaque());
    return httpClientPtr;
});

var c_factory = C_SwiftHttpClientFactory();
c_factory.pthis = bridge(fact);
c_factory.create = {(observer) -> UnsafeMutableRawPointer? in
    // Extract pointer to `self` from void pointer:
    let me = bridge(observer!);
    // Call instance method:
    let httpClient = me!.create();
    let httpClientPtr = UnsafeMutableRawPointer(Unmanaged.passUnretained(httpClient).toOpaque());
    return httpClientPtr;
};
byps_http_setFactory(c_factory);

doit(factPtr);

print("Hello, World!")

