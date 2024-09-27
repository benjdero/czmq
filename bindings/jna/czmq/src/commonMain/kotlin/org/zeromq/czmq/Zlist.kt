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

class Zlist {

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
        fun zlist_new(): Pointer
        fun destroy(self: Pointer)
        fun zlist_first(self: Pointer): Pointer
        fun zlist_next(self: Pointer): Pointer
        fun zlist_last(self: Pointer): Pointer
        fun zlist_head(self: Pointer): Pointer
        fun zlist_tail(self: Pointer): Pointer
        fun zlist_item(self: Pointer): Pointer
        fun zlist_append(self: Pointer, item: Pointer): Int
        fun zlist_push(self: Pointer, item: Pointer): Int
        fun zlist_pop(self: Pointer): Pointer
        fun zlist_exists(self: Pointer, item: Pointer): Boolean
        fun zlist_remove(self: Pointer, item: Pointer): Unit
        fun zlist_dup(self: Pointer): Pointer
        fun zlist_purge(self: Pointer): Unit
        fun zlist_size(self: Pointer): Pointer
        fun zlist_autofree(self: Pointer): Unit
        fun zlist_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zlist_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create a new list container
     */
    constructor() {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zlist_new()
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Destroy a list container
     */
//    @Override
//    public void close () {
//        nativeLib.zlist_destroy(self)
//        self = 0
//    }
//
    /**
     * Return the item at the head of list. If the list is empty, returns NULL.
     * Leaves cursor pointing at the head item, or NULL if the list is empty.
     */
    fun first(): Pointer {
        return nativeLib.zlist_first(self)
    }

    /**
     * Return the next item. If the list is empty, returns NULL. To move to
     * the start of the list call zlist_first (). Advances the cursor.
     */
    fun next(): Pointer {
        return nativeLib.zlist_next(self)
    }

    /**
     * Return the item at the tail of list. If the list is empty, returns NULL.
     * Leaves cursor pointing at the tail item, or NULL if the list is empty.
     */
    fun last(): Pointer {
        return nativeLib.zlist_last(self)
    }

    /**
     * Return first item in the list, or null, leaves the cursor
     */
    fun head(): Pointer {
        return nativeLib.zlist_head(self)
    }

    /**
     * Return last item in the list, or null, leaves the cursor
     */
    fun tail(): Pointer {
        return nativeLib.zlist_tail(self)
    }

    /**
     * Return the current item of list. If the list is empty, returns NULL.
     * Leaves cursor pointing at the current item, or NULL if the list is empty.
     */
    fun item(): Pointer {
        return nativeLib.zlist_item(self)
    }

    /**
     * Append an item to the end of the list, return 0 if OK or -1 if this
     * failed for some reason (invalid input). Note that if a duplicator has
     * been set, this method will also duplicate the item.
     */
    fun append(item: Pointer): Int {
        return nativeLib.zlist_append(self, item)
    }

    /**
     * Push an item to the start of the list, return 0 if OK or -1 if this
     * failed for some reason (invalid input). Note that if a duplicator has
     * been set, this method will also duplicate the item.
     */
    fun push(item: Pointer): Int {
        return nativeLib.zlist_push(self, item)
    }

    /**
     * Pop the item off the start of the list, if any
     */
    fun pop(): Pointer {
        return nativeLib.zlist_pop(self)
    }

    /**
     * Checks if an item already is present. Uses compare method to determine if
     * items are equal. If the compare method is NULL the check will only compare
     * pointers. Returns true if item is present else false.
     */
    fun exists(item: Pointer): Boolean {
        return nativeLib.zlist_exists(self, item)
    }

    /**
     * Remove the specified item from the list if present
     */
    fun remove(item: Pointer): Unit {
        nativeLib.zlist_remove(self, item)
    }

    /**
     * Make a copy of list. If the list has autofree set, the copied list will
     * duplicate all items, which must be strings. Otherwise, the list will hold
     * pointers back to the items in the original list. If list is null, returns
     * NULL.
     */
    fun dup(): Zlist {
        return Zlist (nativeLib.zlist_dup(self))
    }

    /**
     * Purge all items from list
     */
    fun purge(): Unit {
        nativeLib.zlist_purge(self)
    }

    /**
     * Return number of items in the list
     */
    fun size(): Pointer {
        return nativeLib.zlist_size(self)
    }

    /**
     * Set list for automatic item destruction; item values MUST be strings.
     * By default a list item refers to a value held elsewhere. When you set
     * this, each time you append or push a list item, zlist will take a copy
     * of the string value. Then, when you destroy the list, it will free all
     * item values automatically. If you use any other technique to allocate
     * list values, you must free them explicitly before destroying the list.
     * The usual technique is to pop list items and destroy them, until the
     * list is empty.
     */
    fun autofree(): Unit {
        nativeLib.zlist_autofree(self)
    }

}