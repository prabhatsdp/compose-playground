package dev.prabhatpandey.composeplayground.features.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.DateRange
import dev.prabhatpandey.composeplayground.features.calendar.domain.utils.isInRange
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters
import java.time.format.TextStyle as DisplayTextStyle
import java.util.Locale

/**
 * MonthView
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */

@Composable
fun MonthView(
    year: Int,
    month: Month,
    dateRange: DateRange? = null,
    onRangeSelected: (DateRange) -> Unit,
) {
    Column {
        Text(
            text = month.getDisplayName(DisplayTextStyle.FULL, Locale.getDefault()) + " $year",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(8.dp)
        )
        // Use a Grid or LazyVerticalGrid to display days
        // For simplicity, using a Column with rows here
        val daysInMonth = month.length(year % 4 == 0)
        val startOfMonth = LocalDate.of(year, month, 1)
        val endOfMonth = startOfMonth.with(TemporalAdjusters.lastDayOfMonth())

        val startDayOfWeek = startOfMonth.dayOfWeek
        val endDayOfWeek = endOfMonth.dayOfWeek

        val leadingDays = startDayOfWeek.value % 7
        val trailingDays = 6 - (endDayOfWeek.value % 7)
        val days = (1..daysInMonth).map { startOfMonth.withDayOfMonth(it) }
        val actualDays = List(leadingDays) { null } + days + List(trailingDays) { null }

        Row {
            DayOfWeek.values().forEach { dayOfWeek ->
                Box(
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = dayOfWeek.getDisplayName(
                            DisplayTextStyle.SHORT,
                            Locale.getDefault()
                        )
                    )
                }
            }
        }

        actualDays.chunked(7).forEach { week ->
            Row {
                week.forEach { day ->
                    DayView(
                        date = day,
                        dateRange = dateRange,
                        onRangeSelected = onRangeSelected,
                        selected = day.isInRange(range = dateRange),
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewMonthView() {
    ComposePlaygroundTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(24.dp)
        ) {
            MonthView(
                year = 2024,
                month = Month.OCTOBER,
                onRangeSelected = {},
                dateRange = DateRange(start = LocalDate.now(), end = LocalDate.now().plusDays(5))
            )
        }
    }
}