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

class Zhashx {

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
        fun zhashx_new(): Pointer
        fun zhashx_unpack(frame: Pointer): Pointer
        fun destroy(self: Pointer)
        fun zhashx_insert(self: Pointer, key: Pointer, item: Pointer): Int
        fun zhashx_update(self: Pointer, key: Pointer, item: Pointer): Unit
        fun zhashx_delete(self: Pointer, key: Pointer): Unit
        fun zhashx_purge(self: Pointer): Unit
        fun zhashx_lookup(self: Pointer, key: Pointer): Pointer
        fun zhashx_rename(self: Pointer, oldKey: Pointer, newKey: Pointer): Int
        fun zhashx_size(self: Pointer): Pointer
        fun zhashx_keys(self: Pointer): Pointer
        fun zhashx_values(self: Pointer): Pointer
        fun zhashx_first(self: Pointer): Pointer
        fun zhashx_next(self: Pointer): Pointer
        fun zhashx_cursor(self: Pointer): Pointer
        fun zhashx_comment(self: Pointer, format: Array<out String>): Unit
        fun zhashx_save(self: Pointer, filename: String): Int
        fun zhashx_load(self: Pointer, filename: String): Int
        fun zhashx_refresh(self: Pointer): Int
        fun zhashx_pack(self: Pointer): Pointer
        fun zhashx_dup(self: Pointer): Pointer
        fun zhashx_dup_v2(self: Pointer): Pointer
        fun zhashx_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zhashx_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create a new, empty hash container
     */
    constructor() {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zhashx_new()
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Unpack binary frame into a new hash table. Packed data must follow format
     * defined by zhashx_pack. Hash table is set to autofree. An empty frame
     * unpacks to an empty hash table.
     */
//    public static Zhashx unpack (frame: Zframe) {
//        return new Zhashx (nativeLib.zhashx_unpack (frame.self))
//    }
//
    /**
     * Destroy a hash container and all items in it
     */
//    @Override
//    public void close () {
//        nativeLib.zhashx_destroy(self)
//        self = 0
//    }
//
    /**
     * Insert item into hash table with specified key and item.
     * If key is already present returns -1 and leaves existing item unchanged
     * Returns 0 on success.
     */
    fun insert(key: Pointer, item: Pointer): Int {
        return nativeLib.zhashx_insert(self, key, item)
    }

    /**
     * Update or insert item into hash table with specified key and item. If the
     * key is already present, destroys old item and inserts new one. If you set
     * a container item destructor, this is called on the old value. If the key
     * was not already present, inserts a new item. Sets the hash cursor to the
     * new item.
     */
    fun update(key: Pointer, item: Pointer): Unit {
        nativeLib.zhashx_update(self, key, item)
    }

    /**
     * Remove an item specified by key from the hash table. If there was no such
     * item, this function does nothing.
     */
    fun delete(key: Pointer): Unit {
        nativeLib.zhashx_delete(self, key)
    }

    /**
     * Delete all items from the hash table. If the key destructor is
     * set, calls it on every key. If the item destructor is set, calls
     * it on every item.
     */
    fun purge(): Unit {
        nativeLib.zhashx_purge(self)
    }

    /**
     * Return the item at the specified key, or null
     */
    fun lookup(key: Pointer): Pointer {
        return nativeLib.zhashx_lookup(self, key)
    }

    /**
     * Reindexes an item from an old key to a new key. If there was no such
     * item, does nothing. Returns 0 if successful, else -1.
     */
    fun rename(oldKey: Pointer, newKey: Pointer): Int {
        return nativeLib.zhashx_rename(self, oldKey, newKey)
    }

    /**
     * Return the number of keys/items in the hash table
     */
    fun size(): Pointer {
        return nativeLib.zhashx_size(self)
    }

    /**
     * Return a zlistx_t containing the keys for the items in the
     * table. Uses the key_duplicator to duplicate all keys and sets the
     * key_destructor as destructor for the list.
     */
    fun keys(): Zlistx {
        return Zlistx (nativeLib.zhashx_keys(self))
    }

    /**
     * Return a zlistx_t containing the values for the items in the
     * table. Uses the duplicator to duplicate all items and sets the
     * destructor as destructor for the list.
     */
    fun values(): Zlistx {
        return Zlistx (nativeLib.zhashx_values(self))
    }

    /**
     * Simple iterator; returns first item in hash table, in no given order,
     * or NULL if the table is empty. This method is simpler to use than the
     * foreach() method, which is deprecated. To access the key for this item
     * use zhashx_cursor(). NOTE: do NOT modify the table while iterating.
     */
    fun first(): Pointer {
        return nativeLib.zhashx_first(self)
    }

    /**
     * Simple iterator; returns next item in hash table, in no given order,
     * or NULL if the last item was already returned. Use this together with
     * zhashx_first() to process all items in a hash table. If you need the
     * items in sorted order, use zhashx_keys() and then zlistx_sort(). To
     * access the key for this item use zhashx_cursor(). NOTE: do NOT modify
     * the table while iterating.
     */
    fun next(): Pointer {
        return nativeLib.zhashx_next(self)
    }

    /**
     * After a successful first/next method, returns the key for the item that
     * was returned. This is a constant string that you may not modify or
     * deallocate, and which lasts as long as the item in the hash. After an
     * unsuccessful first/next, returns NULL.
     */
    fun cursor(): Pointer {
        return nativeLib.zhashx_cursor(self)
    }

    /**
     * Add a comment to hash table before saving to disk. You can add as many
     * comment lines as you like. These comment lines are discarded when loading
     * the file. If you use a null format, all comments are deleted.
     */
    fun comment(vararg format: String): Unit {
        nativeLib.zhashx_comment(self, format)
    }

    /**
     * Save hash table to a text file in name=value format. Hash values must be
     * printable strings; keys may not contain '=' character. Returns 0 if OK,
     * else -1 if a file error occurred.
     */
    fun save(filename: String): Int {
        return nativeLib.zhashx_save(self, filename)
    }

    /**
     * Load hash table from a text file in name=value format; hash table must
     * already exist. Hash values must printable strings; keys may not contain
     * '=' character. Returns 0 if OK, else -1 if a file was not readable.
     */
    fun load(filename: String): Int {
        return nativeLib.zhashx_load(self, filename)
    }

    /**
     * When a hash table was loaded from a file by zhashx_load, this method will
     * reload the file if it has been modified since, and is "stable", i.e. not
     * still changing. Returns 0 if OK, -1 if there was an error reloading the
     * file.
     */
    fun refresh(): Int {
        return nativeLib.zhashx_refresh(self)
    }

    /**
     * Serialize hash table to a binary frame that can be sent in a message.
     * The packed format is compatible with the 'dictionary' type defined in
     * http://rfc.zeromq.org/spec:35/FILEMQ, and implemented by zproto:
     *
     *    ; A list of name/value pairs
     *    dictionary      = dict-count *( dict-name dict-value )
     *    dict-count      = number-4
     *    dict-value      = longstr
     *    dict-name       = string
     *
     *    ; Strings are always length + text contents
     *    longstr         = number-4 *VCHAR
     *    string          = number-1 *VCHAR
     *
     *    ; Numbers are unsigned integers in network byte order
     *    number-1        = 1OCTET
     *    number-4        = 4OCTET
     *
     * Comments are not included in the packed data. Item values MUST be
     * strings.
     */
    fun pack(): Zframe {
        return Zframe (nativeLib.zhashx_pack(self))
    }

    /**
     * Make a copy of the list; items are duplicated if you set a duplicator
     * for the list, otherwise not. Copying a null reference returns a null
     * reference. Note that this method's behavior changed slightly for CZMQ
     * v3.x, as it does not set nor respect autofree. It does however let you
     * duplicate any hash table safely. The old behavior is in zhashx_dup_v2.
     */
    fun dup(): Zhashx {
        return Zhashx (nativeLib.zhashx_dup(self))
    }

    /**
     * Make copy of hash table; if supplied table is null, returns null.
     * Does not copy items themselves. Rebuilds new table so may be slow on
     * very large tables. NOTE: only works with item values that are strings
     * since there's no other way to know how to duplicate the item value.
     */
    fun dupV2(): Zhashx {
        return Zhashx (nativeLib.zhashx_dup_v2(self))
    }

}
