@file:Suppress("NOTHING_TO_INLINE")

package dev.prabhatpandey.logex.log

import org.jetbrains.annotations.NonNls
import timber.log.Timber


inline fun logVerbose(msg: String, vararg args: Any?) {
    Timber.v(msg, args)
}

inline fun logVerbose(throwable: Throwable) {
    Timber.v(throwable)
}

inline fun logVerbose(throwable: Throwable, @NonNls message: String?, vararg args: Any?) {
    Timber.v(throwable, message, args)
}

inline fun logInfo(msg: String, vararg args: Any?) {
    Timber.i(msg, args)
}

inline fun logInfo(throwable: Throwable) {
    Timber.i(throwable)
}

inline fun logInfo(throwable: Throwable, @NonNls message: String?, vararg args: Any?) {
    Timber.i(throwable, message, args)
}

inline fun logError(msg: String, vararg args: Any?) {
    Timber.e(msg, args)
}

inline fun logError(throwable: Throwable) {
    Timber.e(throwable)
}

inline fun logError(throwable: Throwable, @NonNls message: String?, vararg args: Any?) {
    Timber.e(throwable, message, args)
}


inline fun logDebug(msg: String, vararg args: Any?) {
    Timber.d(msg, args)
}

inline fun logDebug(throwable: Throwable) {
    Timber.d(throwable)
}

inline fun logDebug(throwable: Throwable, @NonNls message: String?, vararg args: Any?) {
    Timber.d(throwable, message, args)
}

inline fun logxLog(priority: Int, t: Throwable?, @NonNls message: String?, vararg args: Any?) {
    Timber.log(priority, t, message, *args)
}

inline fun logxLog(priority: Int, t: Throwable?) {
    Timber.log(priority, t)
}

inline fun logWarning(message: String) {
    Timber.w(message)
}

inline fun logWarning(t: Throwable) {
    Timber.w(t)
}

inline fun logWarning(t: Throwable? = null, message: String? = null) {
    Timber.w(t, message)
}

inline fun logWarning(t: Throwable? = null, message: String? = null, vararg args: Any?) {
    Timber.w(t, message, *args)
}

inline fun logWtf(t: Throwable?) {
    Timber.wtf(t)
}

inline fun logWtf(t: Throwable? = null, message: String? = null) {
    Timber.wtf(t, message)
}

inline fun logWtf(t: Throwable? = null, message: String? = null, vararg args: Any?) {
    Timber.w(t, message, args)
}
