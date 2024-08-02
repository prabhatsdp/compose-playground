package dev.prabhatpandey.composeplayground.features.calendar.domain.models

import androidx.compose.runtime.Stable
import java.time.LocalDate

/**
 * CalendarDay
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */
@Stable
data class CalendarDay(
    val day: LocalDate,
    val selected: Boolean = false,
)
