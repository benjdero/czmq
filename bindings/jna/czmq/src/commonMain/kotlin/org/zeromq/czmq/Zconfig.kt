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

class Zconfig {

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
        fun zconfig_new(name: String, parent: Pointer): Pointer
        fun zconfig_load(filename: String): Pointer
        fun zconfig_loadf(format: Array<out String>): Pointer
        fun destroy(self: Pointer)
        fun zconfig_dup(self: Pointer): Pointer
        fun zconfig_name(self: Pointer): String
        fun zconfig_value(self: Pointer): String
        fun zconfig_put(self: Pointer, path: String, value: String): Unit
        fun zconfig_putf(self: Pointer, path: String, format: Array<out String>): Unit
        fun zconfig_get(self: Pointer, path: String, defaultValue: String): String
        fun zconfig_set_name(self: Pointer, name: String): Unit
        fun zconfig_set_value(self: Pointer, format: Array<out String>): Unit
        fun zconfig_child(self: Pointer): Pointer
        fun zconfig_next(self: Pointer): Pointer
        fun zconfig_locate(self: Pointer, path: String): Pointer
        fun zconfig_at_depth(self: Pointer, level: Int): Pointer
        fun zconfig_set_comment(self: Pointer, format: Array<out String>): Unit
        fun zconfig_comments(self: Pointer): Pointer
        fun zconfig_save(self: Pointer, filename: String): Int
        fun zconfig_savef(self: Pointer, format: Array<out String>): Int
        fun zconfig_filename(self: Pointer): String
        fun zconfig_reload(self: Pointer): Pointer
        fun zconfig_chunk_load(chunk: Pointer): Pointer
        fun zconfig_chunk_save(self: Pointer): Pointer
        fun zconfig_str_load(string: String): Pointer
        fun zconfig_str_save(self: Pointer): String
        fun zconfig_has_changed(self: Pointer): Boolean
        fun zconfig_remove_subtree(self: Pointer): Unit
        fun zconfig_remove(self: Pointer): Pointer
        fun zconfig_print(self: Pointer): Unit
        fun zconfig_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Load a config tree from a memory chunk
     */
    fun chunkLoad(chunk: Zchunk): Zconfig {
        return Zconfig (nativeLib.zconfig_chunk_load(chunk.self))
    }

    /**
     * Load a config tree from a null-terminated string
     */
    fun strLoad(string: String): Zconfig {
        return Zconfig (nativeLib.zconfig_str_load(string))
    }

    /**
     * Self test of this class
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zconfig_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create new config item
     */
    constructor(name: String, parent: Zconfig) {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zconfig_new(name, parent.self)
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Load a config tree from a specified ZPL text file; returns a zconfig_t
     * reference for the root, if the file exists and is readable. Returns NULL
     * if the file does not exist.
     */
//    public static Zconfig load (filename: String) {
//        return new Zconfig (nativeLib.zconfig_load (filename))
//    }
//
    /**
     * Equivalent to zconfig_load, taking a format string instead of a fixed
     * filename.
     */
//    public static Zconfig loadf (vararg format: String) {
//        return new Zconfig (nativeLib.zconfig_loadf (format))
//    }
//
    /**
     * Destroy a config item and all its children
     */
//    @Override
//    public void close () {
//        nativeLib.zconfig_destroy(self)
//        self = 0
//    }
//
    /**
     * Create copy of zconfig, caller MUST free the value
     * Create copy of config, as new zconfig object. Returns a fresh zconfig_t
     * object. If config is null, or memory was exhausted, returns null.
     */
    fun dup(): Zconfig {
        return Zconfig (nativeLib.zconfig_dup(self))
    }

    /**
     * Return name of config item
     */
    fun name(): String {
        return nativeLib.zconfig_name(self)
    }

    /**
     * Return value of config item
     */
    fun value(): String {
        return nativeLib.zconfig_value(self)
    }

    /**
     * Insert or update configuration key with value
     */
    fun put(path: String, value: String): Unit {
        nativeLib.zconfig_put(self, path, value)
    }

    /**
     * Equivalent to zconfig_put, accepting a format specifier and variable
     * argument list, instead of a single string value.
     */
    fun putf(path: String, vararg format: String): Unit {
        nativeLib.zconfig_putf(self, path, format)
    }

    /**
     * Get value for config item into a string value; leading slash is optional
     * and ignored.
     */
    fun get(path: String, defaultValue: String): String {
        return nativeLib.zconfig_get(self, path, defaultValue)
    }

    /**
     * Set config item name, name may be NULL
     */
    fun setName(name: String): Unit {
        nativeLib.zconfig_set_name(self, name)
    }

    /**
     * Set new value for config item. The new value may be a string, a printf
     * format, or NULL. Note that if string may possibly contain '%', or if it
     * comes from an insecure source, you must use '%s' as the format, followed
     * by the string.
     */
    fun setValue(vararg format: String): Unit {
        nativeLib.zconfig_set_value(self, format)
    }

    /**
     * Find our first child, if any
     */
    fun child(): Zconfig {
        return Zconfig (nativeLib.zconfig_child(self))
    }

    /**
     * Find our first sibling, if any
     */
    fun next(): Zconfig {
        return Zconfig (nativeLib.zconfig_next(self))
    }

    /**
     * Find a config item along a path; leading slash is optional and ignored.
     */
    fun locate(path: String): Zconfig {
        return Zconfig (nativeLib.zconfig_locate(self, path))
    }

    /**
     * Locate the last config item at a specified depth
     */
    fun atDepth(level: Int): Zconfig {
        return Zconfig (nativeLib.zconfig_at_depth(self, level))
    }

    /**
     * Add comment to config item before saving to disk. You can add as many
     * comment lines as you like. If you use a null format, all comments are
     * deleted.
     */
    fun setComment(vararg format: String): Unit {
        nativeLib.zconfig_set_comment(self, format)
    }

    /**
     * Return comments of config item, as zlist.
     */
    fun comments(): Zlist {
        return Zlist (nativeLib.zconfig_comments(self))
    }

    /**
     * Save a config tree to a specified ZPL text file, where a filename
     * "-" means dump to standard output.
     */
    fun save(filename: String): Int {
        return nativeLib.zconfig_save(self, filename)
    }

    /**
     * Equivalent to zconfig_save, taking a format string instead of a fixed
     * filename.
     */
    fun savef(vararg format: String): Int {
        return nativeLib.zconfig_savef(self, format)
    }

    /**
     * Report filename used during zconfig_load, or NULL if none
     */
    fun filename(): String {
        return nativeLib.zconfig_filename(self)
    }

    /**
     * Reload config tree from same file that it was previously loaded from.
     * Returns 0 if OK, -1 if there was an error (and then does not change
     * existing data).
     */
    fun reload(): Unit {
        self = nativeLib.zconfig_reload(self)
    }

    /**
     * Save a config tree to a new memory chunk
     */
    fun chunkSave(): Zchunk {
        return Zchunk (nativeLib.zconfig_chunk_save(self))
    }

    /**
     * Save a config tree to a new null terminated string
     */
    fun strSave(): String {
        return nativeLib.zconfig_str_save(self)
    }

    /**
     * Return true if a configuration tree was loaded from a file and that
     * file has changed in since the tree was loaded.
     */
    fun hasChanged(): Boolean {
        return nativeLib.zconfig_has_changed(self)
    }

    /**
     * Destroy subtree (all children)
     */
    fun removeSubtree(): Unit {
        nativeLib.zconfig_remove_subtree(self)
    }

    /**
     * Destroy node and subtree (all children)
     */
    fun remove(): Unit {
        self = nativeLib.zconfig_remove(self)
    }

    /**
     * Print properties of object
     */
    fun print(): Unit {
        nativeLib.zconfig_print(self)
    }

}