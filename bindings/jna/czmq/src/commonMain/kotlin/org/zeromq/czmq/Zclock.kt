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

class Zclock {

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
        fun zclock_sleep(msecs: Int): Unit
        fun zclock_time(): Pointer
        fun zclock_mono(): Pointer
        fun zclock_usecs(): Pointer
        fun zclock_timestr(): String
        fun zclock_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Sleep for a number of milliseconds
     */
    fun sleep(msecs: Int): Unit {
        nativeLib.zclock_sleep(msecs)
    }

    /**
     * Return current system clock as milliseconds. Note that this clock can
     * jump backwards (if the system clock is changed) so is unsafe to use for
     * timers and time offsets. Use zclock_mono for that instead.
     */
    fun time(): Pointer {
        return nativeLib.zclock_time()
    }

    /**
     * Return current monotonic clock in milliseconds. Use this when you compute
     * time offsets. The monotonic clock is not affected by system changes and
     * so will never be reset backwards, unlike a system clock.
     */
    fun mono(): Pointer {
        return nativeLib.zclock_mono()
    }

    /**
     * Return current monotonic clock in microseconds. Use this when you compute
     * time offsets. The monotonic clock is not affected by system changes and
     * so will never be reset backwards, unlike a system clock.
     */
    fun usecs(): Pointer {
        return nativeLib.zclock_usecs()
    }

    /**
     * Return formatted date/time as fresh string. Free using zstr_free().
     */
    fun timestr(): String {
        return nativeLib.zclock_timestr()
    }

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zclock_test(verbose)
    }

    }
}