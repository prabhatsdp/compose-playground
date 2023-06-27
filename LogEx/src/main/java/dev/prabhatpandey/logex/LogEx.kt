package dev.prabhatpandey.logex

import dev.prabhatpandey.logex.loggers.LogExLogger
import dev.prabhatpandey.logex.timber.CustomDebugTree
import dev.prabhatpandey.logex.timber.TimberLogTree
import timber.log.Timber

object LogEx {

    fun configure(isDebug: Boolean, logger: LogExLogger? = null) {
        when {
            isDebug -> Timber.plant(CustomDebugTree())
            logger != null -> Timber.plant(TimberLogTree(logger))
        }
    }

}