package dev.prabhatpandey.composeplayground.features.clock.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.features.clock.models.AnalogClock
import dev.prabhatpandey.composeplayground.features.clock.models.ClockTime
import java.time.LocalDateTime


@Composable
fun CustomAnalogClock(
    clock: AnalogClock,
    modifier: Modifier = Modifier,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    minuteHandColor: Color = MaterialTheme.colorScheme.primary,
    secondHandColor: Color = Color.White,
    minuteLinesColor: Color = Color.White.copy(alpha = 0.5f),
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    hourHandColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawCircle(
                color = borderColor,
                radius = size.maxDimension / 2f
            )
            drawCircle(
                color = backgroundColor,
                radius = (size.maxDimension / 2f) - (size.maxDimension / 20f)
            )
            drawMinuteLines(minuteLinesColor)
        }

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {

            drawHourHand(clock.hourHandRotationDegree.toFloat(), hourHandColor)

            drawMinuteHand(clock.minuteHandRotationDegree.toFloat(), minuteHandColor)

            drawSecondHand(clock.secondHandRotationDegree.toFloat(), secondHandColor)
        }

    }
}

private fun DrawScope.drawMinuteLines(color: Color) {
    for (i in 1..60) {
        rotate(6f * i) {
            drawRoundRect(
                color = color,
                topLeft = Offset(
                    size.width / 2f - (if (i.isAtHour()) 1.dp.toPx() else 0.75.dp.toPx()),
                    size.maxDimension / 14f
                ),
                size = Size(
                    if (i.isAtHour()) size.width / 100f else size.width / 200f,
                    if (i.isAtHour()) size.width / 16f else size.width / 24f
                ),
                cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
            )
        }
    }
}

private fun DrawScope.drawHourHand(rotation: Float, color: Color) {
    val thickness = size.minDimension / 28f
    val length = size.minDimension / 4f
    rotate(degrees = rotation, pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                size.width / 2f - thickness / 2f,
                size.height / 4f + size.maxDimension / 16f
            ),
            size = Size(thickness, length),
            cornerRadius = CornerRadius(thickness / 2, thickness / 2),
            style = Fill
        )
    }

    drawCircle(
        color = color,
        radius = thickness * 1.1f
    )
}

private fun DrawScope.drawMinuteHand(rotation: Float, color: Color) {
    val thickness = size.width / 36f
    val length = size.height / 2f - size.height / 8f
    rotate(degrees = rotation, pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                (size.width / 2) - thickness / 2,
                size.height / 8f + (size.maxDimension / 16f)
            ),
            size = Size(thickness, length),
            cornerRadius = CornerRadius(thickness / 2, thickness / 2),
            style = Stroke(thickness / 4)
        )
    }

    drawCircle(
        color = color,
        radius = thickness * 1.1f
    )
}

private fun DrawScope.drawSecondHand(rotation: Float, color: Color) {
    val thickness = size.width / 84f
    val length = size.height / 2f - size.height / 20f
    rotate(degrees = rotation, pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                size.width / 2f - thickness / 2f,
                size.height / 20f + size.maxDimension / 16f
            ),
            size = Size(thickness, length),
            cornerRadius = CornerRadius(thickness / 2, thickness / 2),
            style = Fill
        )
    }

    drawCircle(
        color = color,
        radius = thickness * 1.3f
    )
}

private fun Int.isAtHour(): Boolean {
    return this % 5 == 0
}


@Preview
@Composable
fun PreviewAnalogClock() {
    ComposePlaygroundTheme {
        Surface {
            CustomAnalogClock(
                modifier = Modifier.fillMaxWidth(),
                clock = LocalDateTime.now().let {
                    AnalogClock(ClockTime(it.hour, it.minute, it.second))
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewAnalogClockSmall() {
    ComposePlaygroundTheme {
        Surface(
            modifier = Modifier.size(100.dp)
        ) {
            CustomAnalogClock(
                modifier = Modifier.fillMaxWidth(),
                clock = LocalDateTime.now().let {
                    AnalogClock(ClockTime(it.hour, it.minute, it.second))
                }
            )
        }
    }
}