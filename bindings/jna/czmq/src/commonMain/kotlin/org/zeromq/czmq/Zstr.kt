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

class Zstr {

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
        fun zstr_recv(source: Pointer): String
        fun zstr_recv_compress(source: Pointer): String
        fun zstr_send(dest: Pointer, string: String): Int
        fun zstr_sendm(dest: Pointer, string: String): Int
        fun zstr_sendf(dest: Pointer, format: Array<out String>): Int
        fun zstr_sendfm(dest: Pointer, format: Array<out String>): Int
        fun zstr_sendx(dest: Pointer, string: Array<out String>): Int
        fun zstr_send_compress(dest: Pointer, string: String): Int
        fun zstr_sendm_compress(dest: Pointer, string: String): Int
        fun zstr_str(source: Pointer): String
        fun zstr_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Receive C string from socket. Caller must free returned string using
     * zstr_free(). Returns NULL if the context is being terminated or the
     * process was interrupted.
     */
    fun recv(source: Pointer): String {
        return nativeLib.zstr_recv(source)
    }

    /**
     * De-compress and receive C string from socket, received as a message
     * with two frames: size of the uncompressed string, and the string itself.
     * Caller must free returned string using zstr_free(). Returns NULL if the
     * context is being terminated or the process was interrupted.
     */
    fun recvCompress(source: Pointer): String {
        return nativeLib.zstr_recv_compress(source)
    }

    /**
     * Send a C string to a socket, as a frame. The string is sent without
     * trailing null byte; to read this you can use zstr_recv, or a similar
     * method that adds a null terminator on the received string. String
     * may be NULL, which is sent as "".
     */
    fun send(dest: Pointer, string: String): Int {
        return nativeLib.zstr_send(dest, string)
    }

    /**
     * Send a C string to a socket, as zstr_send(), with a MORE flag, so that
     * you can send further strings in the same multi-part message.
     */
    fun sendm(dest: Pointer, string: String): Int {
        return nativeLib.zstr_sendm(dest, string)
    }

    /**
     * Send a formatted string to a socket. Note that you should NOT use
     * user-supplied strings in the format (they may contain '%' which
     * will create security holes).
     */
    fun sendf(dest: Pointer, vararg format: String): Int {
        return nativeLib.zstr_sendf(dest, format)
    }

    /**
     * Send a formatted string to a socket, as for zstr_sendf(), with a
     * MORE flag, so that you can send further strings in the same multi-part
     * message.
     */
    fun sendfm(dest: Pointer, vararg format: String): Int {
        return nativeLib.zstr_sendfm(dest, format)
    }

    /**
     * Send a series of strings (until NULL) as multipart data
     * Returns 0 if the strings could be sent OK, or -1 on error.
     */
    fun sendx(dest: Pointer, vararg string: String): Int {
        return nativeLib.zstr_sendx(dest, string)
    }

    /**
     * Compress and send a C string to a socket, as a message with two frames:
     * size of the uncompressed string, and the string itself. The string is
     * sent without trailing null byte; to read this you can use
     * zstr_recv_compress, or a similar method that de-compresses and adds a
     * null terminator on the received string.
     */
    fun sendCompress(dest: Pointer, string: String): Int {
        return nativeLib.zstr_send_compress(dest, string)
    }

    /**
     * Compress and send a C string to a socket, as zstr_send_compress(),
     * with a MORE flag, so that you can send further strings in the same
     * multi-part message.
     */
    fun sendmCompress(dest: Pointer, string: String): Int {
        return nativeLib.zstr_sendm_compress(dest, string)
    }

    /**
     * Accepts a void pointer and returns a fresh character string. If source
     * is null, returns an empty string.
     */
    fun str(source: Pointer): String {
        return nativeLib.zstr_str(source)
    }

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zstr_test(verbose)
    }

    }
}