package dev.prabhatpandey.composeplayground.core

import android.app.Application
import android.content.res.Configuration
import dagger.hilt.android.HiltAndroidApp
import dev.prabhatpandey.composeplayground.BuildConfig
import dev.prabhatpandey.logex.LogEx

@HiltAndroidApp
class ComposePlaygroundApp: Application() {

    override fun onCreate() {
        super.onCreate()
        LogEx.configure(BuildConfig.DEBUG)

    }
}