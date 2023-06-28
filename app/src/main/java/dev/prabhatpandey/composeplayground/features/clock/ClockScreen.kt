package dev.prabhatpandey.composeplayground.features.clock

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClockScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Clock Screen")
    }
}