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

class Zcert {

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
        fun zcert_new(): Pointer
        fun zcert_new_from(publicKey: ByteArray, secretKey: ByteArray): Pointer
        fun zcert_new_from_txt(publicTxt: String, secretTxt: String): Pointer
        fun zcert_load(filename: String): Pointer
        fun destroy(self: Pointer)
        fun zcert_public_key(self: Pointer): ByteArray
        fun zcert_secret_key(self: Pointer): ByteArray
        fun zcert_public_txt(self: Pointer): String
        fun zcert_secret_txt(self: Pointer): String
        fun zcert_set_meta(self: Pointer, name: String, format: Array<out String>): Unit
        fun zcert_unset_meta(self: Pointer, name: String): Unit
        fun zcert_meta(self: Pointer, name: String): String
        fun zcert_meta_keys(self: Pointer): Pointer
        fun zcert_save(self: Pointer, filename: String): Int
        fun zcert_save_public(self: Pointer, filename: String): Int
        fun zcert_save_secret(self: Pointer, filename: String): Int
        fun zcert_apply(self: Pointer, socket: Pointer): Unit
        fun zcert_dup(self: Pointer): Pointer
        fun zcert_eq(self: Pointer, compare: Pointer): Boolean
        fun zcert_print(self: Pointer): Unit
        fun zcert_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Self test of this class
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zcert_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create and initialize a new certificate in memory
     */
    constructor() {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zcert_new()
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Accepts public/secret key pair from caller
     */
//    public static Zcert newFrom (publicKey: ByteArray, secretKey: ByteArray) {
//        return new Zcert (nativeLib.zcert_new_from (publicKey, secretKey))
//    }
//
    /**
     * Accepts public/secret key text pair from caller
     */
//    public static Zcert newFromTxt (publicTxt: String, secretTxt: String) {
//        return new Zcert (nativeLib.zcert_new_from_txt (publicTxt, secretTxt))
//    }
//
    /**
     * Load certificate from file
     */
//    public static Zcert load (filename: String) {
//        return new Zcert (nativeLib.zcert_load (filename))
//    }
//
    /**
     * Destroy a certificate in memory
     */
//    @Override
//    public void close () {
//        nativeLib.zcert_destroy(self)
//        self = 0
//    }
//
    /**
     * Return public part of key pair as 32-byte binary string
     */
    fun publicKey(): ByteArray {
        return nativeLib.zcert_public_key(self)
    }

    /**
     * Return secret part of key pair as 32-byte binary string
     */
    fun secretKey(): ByteArray {
        return nativeLib.zcert_secret_key(self)
    }

    /**
     * Return public part of key pair as Z85 armored string
     */
    fun publicTxt(): String {
        return nativeLib.zcert_public_txt(self)
    }

    /**
     * Return secret part of key pair as Z85 armored string
     */
    fun secretTxt(): String {
        return nativeLib.zcert_secret_txt(self)
    }

    /**
     * Set certificate metadata from formatted string.
     */
    fun setMeta(name: String, vararg format: String): Unit {
        nativeLib.zcert_set_meta(self, name, format)
    }

    /**
     * Unset certificate metadata.
     */
    fun unsetMeta(name: String): Unit {
        nativeLib.zcert_unset_meta(self, name)
    }

    /**
     * Get metadata value from certificate; if the metadata value doesn't
     * exist, returns NULL.
     */
    fun meta(name: String): String {
        return nativeLib.zcert_meta(self, name)
    }

    /**
     * Get list of metadata fields from certificate. Caller is responsible for
     * destroying list. Caller should not modify the values of list items.
     */
    fun metaKeys(): Zlist {
        return Zlist (nativeLib.zcert_meta_keys(self))
    }

    /**
     * Save full certificate (public + secret) to file for persistent storage
     * This creates one public file and one secret file (filename + "_secret").
     */
    fun save(filename: String): Int {
        return nativeLib.zcert_save(self, filename)
    }

    /**
     * Save public certificate only to file for persistent storage
     */
    fun savePublic(filename: String): Int {
        return nativeLib.zcert_save_public(self, filename)
    }

    /**
     * Save secret certificate only to file for persistent storage
     */
    fun saveSecret(filename: String): Int {
        return nativeLib.zcert_save_secret(self, filename)
    }

    /**
     * Apply certificate to socket, i.e. use for CURVE security on socket.
     * If certificate was loaded from public file, the secret key will be
     * undefined, and this certificate will not work successfully.
     */
    fun apply(socket: Pointer): Unit {
        nativeLib.zcert_apply(self, socket)
    }

    /**
     * Return copy of certificate; if certificate is NULL or we exhausted
     * heap memory, returns NULL.
     */
    fun dup(): Zcert {
        return Zcert (nativeLib.zcert_dup(self))
    }

    /**
     * Return true if two certificates have the same keys
     */
    fun eq(compare: Zcert): Boolean {
        return nativeLib.zcert_eq(self, compare.self)
    }

    /**
     * Print certificate contents to stdout
     */
    fun print(): Unit {
        nativeLib.zcert_print(self)
    }

}