package dev.prabhatpandey.logex.timber

import dev.prabhatpandey.logex.loggers.LogExLogger
import timber.log.Timber

class TimberLogTree(
    private val releaseLogger: LogExLogger
) : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        releaseLogger.log(priority, tag, message, t)
    }

}