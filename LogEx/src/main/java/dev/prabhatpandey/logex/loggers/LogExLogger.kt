package dev.prabhatpandey.logex.loggers

interface LogExLogger {
    fun log(priority: Int, tag: String?, message: String, t: Throwable?)
}