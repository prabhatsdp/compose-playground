package dev.prabhatpandey.composeplayground.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.prabhatpandey.composeplayground.core.ui.screens.MainScreen
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                MainScreen()
            }
        }
    }
}
