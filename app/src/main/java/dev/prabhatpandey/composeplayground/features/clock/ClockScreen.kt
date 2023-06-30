package dev.prabhatpandey.composeplayground.features.clock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.prabhatpandey.composeplayground.features.clock.components.CustomAnalogClock

@Composable
fun ClockScreen(
    viewModel: ClockViewModel
) {

    val time by viewModel.clockTime.collectAsStateWithLifecycle()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            CustomAnalogClock(
                modifier = Modifier.fillMaxWidth(),
                time = time
            )
        }
    }
}

