package dev.prabhatpandey.composeplayground.features.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.CalendarDay
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.DateRange
import dev.prabhatpandey.composeplayground.features.calendar.domain.utils.isInRange
import java.time.LocalDate

/**
 * DayView
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */

@Composable
fun RowScope.DayView(
    date: LocalDate? = null,
    selected: Boolean,
    dateRange: DateRange? = null,
    onRangeSelected: (DateRange) -> Unit,
) {
    date?.let {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .padding(3.dp)
                .clip(CircleShape)
                .background(if (selected) MaterialTheme.colorScheme.primary else Color.Transparent)
                .clickable {
                    when {
                        dateRange == null -> {
                            onRangeSelected(DateRange(start = date))
                        }

                        dateRange.start == null -> {
                            onRangeSelected(DateRange(start = date))
                        }

                        dateRange.start == date -> {
                            onRangeSelected(DateRange())
                        }

                        date.isBefore(dateRange.start) -> {
                            onRangeSelected(DateRange(start = date))
                        }

                        dateRange.end == null -> {
                            onRangeSelected(dateRange.copy(end = date))
                        }

                        date.isInRange(dateRange) -> {
                            onRangeSelected(DateRange())
                        }

                        else -> {
                            onRangeSelected(DateRange(start = date))
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )
        }
    } ?: run {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        )
    }
}


@Preview
@Composable
fun PreviewDayView() {
    ComposePlaygroundTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            Row {
                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )

                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )

                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )
                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )
                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )
                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )
                DayView(
                    date = LocalDate.now(),
                    onRangeSelected = {},
                    selected = false,
                )
            }
        }
    }
}