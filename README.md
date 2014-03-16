BYPS
====

Communication Layer for Distributed Software

BYPS (Binary Portable Serialization) connects Java, C#, C++ and JavaScript client programs via HTTP to Java EE servers using an RPC protocol. By means of an integrated push mechanism, a server can also call interfaces implemented on clients and clients can call interfaces among each other (over one or more servers). This is possible even if clients are connected to different servers. The underlying protocol either uses an optimized binary data serialization or JSON. Service interfaces and data structures are described in pure Java and some particular javadoc tags. In addition to primitive data types, the protocol supports lists, sets, maps and streams. A versioning mechanism allows to connect older clients to newer servers and vice versa.
