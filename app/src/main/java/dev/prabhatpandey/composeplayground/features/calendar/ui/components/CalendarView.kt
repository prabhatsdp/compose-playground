package dev.prabhatpandey.composeplayground.features.calendar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.DateRange
import java.time.LocalDate

// Static Values
private const val CONTENT_TYPE_MONTH = 1

/**
 * CalendarView
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */
@Composable
fun CalendarView(
    currentDate: LocalDate,
    selectedRange: DateRange? = null,
    onRangeSelected: (DateRange) -> Unit
) {

    val startMonth = currentDate.withDayOfMonth(1)
    val months = (0 until 12).map { startMonth.plusMonths(it.toLong()) }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        items(
            items = months,
            key = {
                it.month.name + it.month.value
            },
            contentType = {
                CONTENT_TYPE_MONTH
            }
        ) { d ->
            MonthView(
                year = d.year,
                month = d.month,
                dateRange = selectedRange,
                onRangeSelected = onRangeSelected
            )
        }
    }
}


@Preview
@Composable
fun PreviewCalendarView() {
    ComposePlaygroundTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(24.dp)) {
                CalendarView(currentDate = LocalDate.now(), onRangeSelected = {})
            }
        }
    }
}
