package dev.prabhatpandey.composeplayground.features.clock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.prabhatpandey.composeplayground.features.clock.components.CustomAnalogClock
import dev.prabhatpandey.composeplayground.features.clock.models.AnalogClock

@Composable
fun ClockScreen(
    viewModel: ClockViewModel
) {

    val time by viewModel.clockTime.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier.fillMaxWidth().weight(1f)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(24.dp)
            ) {
                CustomAnalogClock(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .align(Alignment.Center),
                    clock = AnalogClock(time),
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth().weight(1f)
                    .background(Color.Black)
                    .padding(24.dp)
            ) {
                CustomAnalogClock(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .align(Alignment.Center),
                    clock = AnalogClock(time),
                    backgroundColor = Color.Black,
                    borderColor = Color.White.copy(alpha = 0.0f),
                    minuteLinesColor = MaterialTheme.colorScheme.background.copy(alpha = 0.25f),
                )
            }
        }
    }
}

