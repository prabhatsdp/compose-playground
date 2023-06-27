package dev.prabhatpandey.composeplayground.core

import android.app.Application
import android.content.res.Configuration
import dagger.hilt.android.HiltAndroidApp
import dev.prabhatpandey.composeplayground.BuildConfig
import dev.prabhatpandey.logex.LogEx

@HiltAndroidApp
class ComposePlaygroundApp: Application() {
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogEx.configure(BuildConfig.DEBUG)
    }
}