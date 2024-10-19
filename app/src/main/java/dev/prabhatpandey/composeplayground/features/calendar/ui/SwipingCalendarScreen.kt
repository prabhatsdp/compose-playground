package dev.prabhatpandey.composeplayground.features.calendar.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * SwipingCalendarScreen
 *
 * Created by Prabhat Pandey on 01/08/2024
 * for ComposePlayground
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipingCalendarScreen() {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "Under Construction", modifier = Modifier.align(Alignment.Center))
        }
    }
}