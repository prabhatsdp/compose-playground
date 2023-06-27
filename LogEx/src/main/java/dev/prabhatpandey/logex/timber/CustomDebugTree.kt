package dev.prabhatpandey.logex.timber

import timber.log.Timber

class CustomDebugTree: Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return element.fileName.split(".").firstOrNull()
    }

}