package dev.prabhatpandey.composeplayground.features.calendar.domain.utils

import android.util.Range
import androidx.core.util.rangeTo
import dev.prabhatpandey.composeplayground.features.calendar.domain.models.DateRange
import java.time.LocalDate

/**
 * DateExt
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */
fun LocalDate?.isInRange(range: DateRange?) : Boolean {
    if (range == null) return false // false if range provided is null
    if (this == null) return false // false if date is null
    if (this == range.start || this == range.end) return true // true if date is equal to either start or end
    if (range.end == null) return false // false if range end is null
    if (this.isAfter(range.start) && this.isBefore(range.end)) return true // true if date falls between start and end
    return false
}