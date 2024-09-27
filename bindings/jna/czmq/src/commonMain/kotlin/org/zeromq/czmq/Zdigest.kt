/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Pointer

class Zdigest {

//    static {
//        Map<String, Boolean> libraries = new LinkedHashMap<>()
//        libraries.put("zmq", false)
//        libraries.put("uuid", true)
//        libraries.put("systemd", true)
//        libraries.put("lz4", true)
//        libraries.put("curl", true)
//        libraries.put("nss", true)
//        libraries.put("microhttpd", true)
//        libraries.put("czmq", false)
//        libraries.put("czmqjni", false)
//        ZmqNativeLoader.loadLibraries(libraries)
//    }

    private interface NativeLib : Library {
        fun zdigest_new(): Pointer
        fun destroy(self: Pointer)
        fun zdigest_update(self: Pointer, buffer: ByteArray, length: Pointer): Unit
        fun zdigest_data(self: Pointer): ByteArray
        fun zdigest_size(self: Pointer): Pointer
        fun zdigest_string(self: Pointer): String
        fun zdigest_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zdigest_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Constructor - creates new digest object, which you use to build up a
     * digest by repeatedly calling zdigest_update() on chunks of data.
     */
    constructor() {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zdigest_new()
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Destroy a digest object
     */
//    @Override
//    public void close () {
//        nativeLib.zdigest_destroy(self)
//        self = 0
//    }
//
    /**
     * Add buffer into digest calculation
     */
    fun update(buffer: ByteArray, length: Pointer): Unit {
        nativeLib.zdigest_update(self, buffer, length)
    }

    /**
     * Return final digest hash data. If built without crypto support,
     * returns NULL.
     */
    fun data(): ByteArray {
        return nativeLib.zdigest_data(self)
    }

    /**
     * Return final digest hash size
     */
    fun size(): Pointer {
        return nativeLib.zdigest_size(self)
    }

    /**
     * Return digest as printable hex string; caller should not modify nor
     * free this string. After calling this, you may not use zdigest_update()
     * on the same digest. If built without crypto support, returns NULL.
     */
    fun string(): String {
        return nativeLib.zdigest_string(self)
    }

}