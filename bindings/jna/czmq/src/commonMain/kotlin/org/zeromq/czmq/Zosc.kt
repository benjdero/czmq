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

class Zosc {

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
        fun zosc_new(address: String): Pointer
        fun zosc_fromframe(frame: Pointer): Pointer
        fun zosc_frommem(data: ByteArray, size: Pointer): Pointer
        fun zosc_fromstring(oscstring: String): Pointer
        fun zosc_create(address: String, format: Array<out String>): Pointer
        fun destroy(self: Pointer)
        fun zosc_size(self: Pointer): Pointer
        fun zosc_data(self: Pointer): ByteArray
        fun zosc_address(self: Pointer): String
        fun zosc_format(self: Pointer): String
        fun zosc_append(self: Pointer, format: Array<out String>): Int
        fun zosc_retr(self: Pointer, format: Array<out String>): Int
        fun zosc_dup(self: Pointer): Pointer
        fun zosc_pack(self: Pointer): Pointer
        fun zosc_packx(self: Pointer): Pointer
        fun zosc_unpack(frame: Pointer): Pointer
        fun zosc_dump(self: Pointer): String
        fun zosc_print(self: Pointer): Unit
        fun zosc_is(self: Pointer): Boolean
        fun zosc_first(self: Pointer, type: Char): Pointer
        fun zosc_next(self: Pointer, type: Char): Pointer
        fun zosc_last(self: Pointer, type: Char): Pointer
        fun zosc_pop_int32(self: Pointer, `val`: Int): Int
        fun zosc_pop_int64(self: Pointer, `val`: Pointer): Int
        fun zosc_pop_float(self: Pointer, `val`: Float): Int
        fun zosc_pop_double(self: Pointer, `val`: Double): Int
        fun zosc_pop_char(self: Pointer, `val`: Char): Int
        fun zosc_pop_bool(self: Pointer, `val`: Boolean): Int
        fun zosc_pop_midi(self: Pointer, `val`: Int): Int
        fun zosc_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Transform a zframe into a zosc.
     */
    fun unpack(frame: Zframe): Zosc {
        return Zosc (nativeLib.zosc_unpack(frame.self))
    }

    /**
     * Probe the supplied object, and report if it looks like a zosc_t.
     */
    fun `is`(self: Pointer): Boolean {
        return nativeLib.zosc_is(self)
    }

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zosc_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create a new empty OSC message with the specified address string.
     */
    constructor(address: String) {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zosc_new(address)
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Create a new OSC message from the specified zframe. Takes ownership of
     * the zframe.
     */
//    public static Zosc fromframe (frame: Zframe) {
//        return new Zosc (nativeLib.zosc_fromframe (frame.self))
//    }
//
    /**
     * Create a new zosc message from memory. Take ownership of the memory
     * and calling free on the data after construction.
     */
//    public static Zosc frommem (data: ByteArray, size: Pointer) {
//        return new Zosc (nativeLib.zosc_frommem (data, size))
//    }
//
    /**
     * Create a new zosc message from a string. This the same syntax as
     * zosc_create but written as a single line string.
     */
//    public static Zosc fromstring (oscstring: String) {
//        return new Zosc (nativeLib.zosc_fromstring (oscstring))
//    }
//
    /**
     * Create a new zosc message from the given format and arguments.
     * The format type tags are as follows:
     *   i - 32bit integer
     *   h - 64bit integer
     *   f - 32bit floating point number (IEEE)
     *   d - 64bit (double) floating point number
     *   s - string (NULL terminated)
     *   t = timetag: an OSC timetag in NTP format (uint64_t)
     *   S - symbol
     *   c - char
     *   m - 4 byte midi packet (8 digits hexadecimal)
     *   T - TRUE (no value required)
     *   F - FALSE (no value required)
     *   N - NIL (no value required)
     *   I - Impulse (for triggers) or INFINITUM (no value required)
     *   b - binary blob
     */
//    public static Zosc create (address: String, vararg format: String) {
//        return new Zosc (nativeLib.zosc_create (address, format))
//    }
//
    /**
     * Destroy an OSC message
     */
//    @Override
//    public void close () {
//        nativeLib.zosc_destroy(self)
//        self = 0
//    }
//
    /**
     * Return chunk data size
     */
    fun size(): Pointer {
        return nativeLib.zosc_size(self)
    }

    /**
     * Return OSC chunk data. Caller does not own the data!
     */
    fun data(): ByteArray {
        return nativeLib.zosc_data(self)
    }

    /**
     * Return the OSC address string
     */
    fun address(): String {
        return nativeLib.zosc_address(self)
    }

    /**
     * Return the OSC format of the message.
     *   i - 32bit integer
     *   h - 64bit integer
     *   f - 32bit floating point number (IEEE)
     *   d - 64bit (double) floating point number
     *   s - string (NULL terminated)
     *   t = timetag: an OSC timetag in NTP format (uint64_t)
     *   S - symbol
     *   c - char
     *   m - 4 byte midi packet (8 digits hexadecimal)
     *   T - TRUE (no value required)
     *   F - FALSE (no value required)
     *   N - NIL (no value required)
     *   I - Impulse (for triggers) or INFINITUM (no value required)
     *   b - binary blob
     */
    fun format(): String {
        return nativeLib.zosc_format(self)
    }

    /**
     * Append data to the osc message. The format describes the data that
     * needs to be appended in the message. This essentially relocates all
     * data!
     * The format type tags are as follows:
     *   i - 32bit integer
     *   h - 64bit integer
     *   f - 32bit floating point number (IEEE)
     *   d - 64bit (double) floating point number
     *   s - string (NULL terminated)
     *   t = timetag: an OSC timetag in NTP format (uint64_t)
     *   S - symbol
     *   c - char
     *   m - 4 byte midi packet (8 digits hexadecimal)
     *   T - TRUE (no value required)
     *   F - FALSE (no value required)
     *   N - NIL (no value required)
     *   I - Impulse (for triggers) or INFINITUM (no value required)
     *   b - binary blob
     */
    fun append(vararg format: String): Int {
        return nativeLib.zosc_append(self, format)
    }

    /**
     * Retrieve the values provided by the given format. Note that zosc_retr
     * creates the objects and the caller must destroy them when finished.
     * The supplied pointers do not need to be initialized. Returns 0 if
     * successful, or -1 if it failed to retrieve a value in which case the
     * pointers are not modified. If an argument pointer is NULL is skips the
     * value. See the format method for a detailed list op type tags for the
     * format string.
     */
    fun retr(vararg format: String): Int {
        return nativeLib.zosc_retr(self, format)
    }

    /**
     * Create copy of the message, as new chunk object. Returns a fresh zosc_t
     * object, or null if there was not enough heap memory. If chunk is null,
     * returns null.
     */
    fun dup(): Zosc {
        return Zosc (nativeLib.zosc_dup(self))
    }

    /**
     * Transform zosc into a zframe that can be sent in a message.
     */
    fun pack(): Zframe {
        return Zframe (nativeLib.zosc_pack(self))
    }

    /**
     * Transform zosc into a zframe that can be sent in a message.
     * Take ownership of the chunk.
     */
    fun packx(): Unit {
        self = nativeLib.zosc_packx(self)
    }

    /**
     * Return a string describing the the OSC message. The returned string must be freed by the caller.
     */
    fun dump(): String {
        return nativeLib.zosc_dump(self)
    }

    /**
     * Dump OSC message to stdout, for debugging and tracing.
     */
    fun print(): Unit {
        nativeLib.zosc_print(self)
    }

    /**
     * Return a pointer to the item at the head of the OSC data.
     * Sets the given char argument to the type tag of the data.
     * If the message is empty, returns NULL and the sets the
     * given char to NULL.
     */
    fun first(type: Char): Pointer {
        return nativeLib.zosc_first(self, type)
    }

    /**
     * Return the next item of the OSC message. If the list is empty, returns
     * NULL. To move to the start of the OSC message call zosc_first ().
     */
    fun next(type: Char): Pointer {
        return nativeLib.zosc_next(self, type)
    }

    /**
     * Return a pointer to the item at the tail of the OSC message.
     * Sets the given char argument to the type tag of the data. If
     * the message is empty, returns NULL.
     */
    fun last(type: Char): Pointer {
        return nativeLib.zosc_last(self, type)
    }

    /**
     * Set the provided 32 bit integer from value at the current cursor position in the message.
     * If the type tag at the current position does not correspond it will fail and
     * return -1. Returns 0 on success.
     */
    fun popInt32(`val`: Int): Int {
        return nativeLib.zosc_pop_int32(self, `val`)
    }

    /**
     * Set the provided 64 bit integer from the value at the current cursor position in the message.
     * If the type tag at the current position does not correspond it will fail and
     * return -1. Returns 0 on success.
     */
    fun popInt64(`val`: Pointer): Int {
        return nativeLib.zosc_pop_int64(self, `val`)
    }

    /**
     * Set the provided float from the value at the current cursor position in the message.
     * If the type tag at the current position does not correspond it will fail and
     * return -1. Returns 0 on success.
     */
    fun popFloat(`val`: Float): Int {
        return nativeLib.zosc_pop_float(self, `val`)
    }

    /**
     * Set the provided double from the value at the current cursor position in the message.
     * If the type tag at the current position does not correspond it will fail and
     * return -1. Returns 0 on success.
     */
    fun popDouble(`val`: Double): Int {
        return nativeLib.zosc_pop_double(self, `val`)
    }

    /**
     * Set the provided char from the value at the current cursor position in the message.
     * If the type tag at the current position does not correspond it will fail and
     * return -1. Returns 0 on success.
     */
    fun popChar(`val`: Char): Int {
        return nativeLib.zosc_pop_char(self, `val`)
    }

    /**
     * Set the provided boolean from the type tag in the message. Booleans are not represented
     * in the data in the message, only in the type tag. If the type tag at the current
     * position does not correspond it will fail and return -1. Returns 0 on success.
     */
    fun popBool(`val`: Boolean): Int {
        return nativeLib.zosc_pop_bool(self, `val`)
    }

    /**
     * Set the provided 4 bytes (unsigned 32bit int) from the value at the current
     * cursor position in the message. If the type tag at the current position does
     * not correspond it will fail and return -1. Returns 0 on success.
     */
    fun popMidi(`val`: Int): Int {
        return nativeLib.zosc_pop_midi(self, `val`)
    }

}
