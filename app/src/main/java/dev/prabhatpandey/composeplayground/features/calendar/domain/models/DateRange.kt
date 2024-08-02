package dev.prabhatpandey.composeplayground.features.calendar.domain.models

import androidx.compose.runtime.Stable
import java.time.LocalDate

/**
 * DateRange
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */
@Stable
data class DateRange(
    val start: LocalDate? = null,
    val end: LocalDate? = null
)
