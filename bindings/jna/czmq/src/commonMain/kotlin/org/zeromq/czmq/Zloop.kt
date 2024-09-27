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

class Zloop {

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
        fun zloop_new(): Pointer
        fun destroy(self: Pointer)
        fun zloop_reader_end(self: Pointer, sock: Pointer): Unit
        fun zloop_reader_set_tolerant(self: Pointer, sock: Pointer): Unit
        fun zloop_timer_end(self: Pointer, timerId: Int): Int
        fun zloop_ticket_reset(self: Pointer, handle: Pointer): Unit
        fun zloop_ticket_delete(self: Pointer, handle: Pointer): Unit
        fun zloop_set_ticket_delay(self: Pointer, ticketDelay: Pointer): Unit
        fun zloop_set_max_timers(self: Pointer, maxTimers: Pointer): Unit
        fun zloop_set_verbose(self: Pointer, verbose: Boolean): Unit
        fun zloop_set_nonstop(self: Pointer, nonstop: Boolean): Unit
        fun zloop_start(self: Pointer): Int
        fun zloop_test(verbose: Boolean): Unit
    }

    companion object {
        private val nativeLib: NativeLib =
            Native.load("czmq", NativeLib::class.java)

    /**
     * Self test of this class.
     */
    fun test(verbose: Boolean): Unit {
        nativeLib.zloop_test(verbose)
    }

    }

    var self: Pointer

    /**
     * Create a new zloop reactor
     */
    constructor() {
        /*  TODO: if __new fails, self is null...            */
        self = nativeLib.zloop_new()
    }

    constructor(pointer: Pointer) {
        self = pointer
    }

    /**
     * Destroy a reactor
     */
//    @Override
//    public void close () {
//        nativeLib.zloop_destroy(self)
//        self = 0
//    }
//
    /**
     * Cancel a socket reader from the reactor. If multiple readers exist for
     * same socket, cancels ALL of them.
     */
    fun readerEnd(sock: Zsock): Unit {
        nativeLib.zloop_reader_end(self, sock.self)
    }

    /**
     * Configure a registered reader to ignore errors. If you do not set this,
     * then readers that have errors are removed from the reactor silently.
     */
    fun readerSetTolerant(sock: Zsock): Unit {
        nativeLib.zloop_reader_set_tolerant(self, sock.self)
    }

    /**
     * Cancel a specific timer identified by a specific timer_id (as returned by
     * zloop_timer).
     */
    fun timerEnd(timerId: Int): Int {
        return nativeLib.zloop_timer_end(self, timerId)
    }

    /**
     * Reset a ticket timer, which moves it to the end of the ticket list and
     * resets its execution time. This is a very fast operation.
     */
    fun ticketReset(handle: Pointer): Unit {
        nativeLib.zloop_ticket_reset(self, handle)
    }

    /**
     * Delete a ticket timer. We do not actually delete the ticket here, as
     * other code may still refer to the ticket. We mark as deleted, and remove
     * later and safely.
     */
    fun ticketDelete(handle: Pointer): Unit {
        nativeLib.zloop_ticket_delete(self, handle)
    }

    /**
     * Set the ticket delay, which applies to all tickets. If you lower the
     * delay and there are already tickets created, the results are undefined.
     */
    fun setTicketDelay(ticketDelay: Pointer): Unit {
        nativeLib.zloop_set_ticket_delay(self, ticketDelay)
    }

    /**
     * Set hard limit on number of timers allowed. Setting more than a small
     * number of timers (10-100) can have a dramatic impact on the performance
     * of the reactor. For high-volume cases, use ticket timers. If the hard
     * limit is reached, the reactor stops creating new timers and logs an
     * error.
     */
    fun setMaxTimers(maxTimers: Pointer): Unit {
        nativeLib.zloop_set_max_timers(self, maxTimers)
    }

    /**
     * Set verbose tracing of reactor on/off. The default verbose setting is
     * off (false).
     */
    fun setVerbose(verbose: Boolean): Unit {
        nativeLib.zloop_set_verbose(self, verbose)
    }

    /**
     * By default the reactor stops if the process receives a SIGINT or SIGTERM
     * signal. This makes it impossible to shut-down message based architectures
     * like zactors. This method lets you switch off break handling. The default
     * nonstop setting is off (false).
     */
    fun setNonstop(nonstop: Boolean): Unit {
        nativeLib.zloop_set_nonstop(self, nonstop)
    }

    /**
     * Start the reactor. Takes control of the thread and returns when the 0MQ
     * context is terminated or the process is interrupted, or any event handler
     * returns -1. Event handlers may register new sockets and timers, and
     * cancel sockets. Returns 0 if interrupted, -1 if canceled by a handler.
     */
    fun start(): Int {
        return nativeLib.zloop_start(self)
    }

}