package dev.prabhatpandey.composeplayground.features.calendar.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.DateRange
import dev.prabhatpandey.composeplayground.features.calendar.ui.components.CalendarView
import java.time.LocalDate

/**
 * ScrollingCalendarScreen
 *
 * Created by Prabhat Pandey on 01/08/2024
 * for ComposePlayground
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollingCalendarScreen(
    viewModel: CalendarViewModel = hiltViewModel()
) {

    var selectedRange by remember {
        mutableStateOf<DateRange?>(DateRange())
    }


    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            CalendarView(
                currentDate = LocalDate.now(),
                onRangeSelected = { dateRange ->
                    selectedRange = dateRange
                },
                selectedRange = selectedRange
            )
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.log()
    }
}