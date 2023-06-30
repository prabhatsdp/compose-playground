package dev.prabhatpandey.composeplayground.features.clock.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import dev.prabhatpandey.composeplayground.features.clock.models.ClockTime
import java.time.LocalDateTime


@Composable
fun CustomAnalogClock(
    time: ClockTime,
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colorScheme.primary,
    secondaryColor: Color = MaterialTheme.colorScheme.secondary,
    tertiaryColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawCircle(
                color = primaryColor,
                radius = size.maxDimension / 2f
            )
            drawCircle(
                color = secondaryColor,
                radius = (size.maxDimension / 2f) - 16.dp.toPx()
            )
            for (i in 1..60) {
                rotate((360f / 60) * i) {
                    drawRoundRect(
                        color = Color.White.copy(alpha = 0.5f),
                        topLeft = Offset(
                            size.width / 2f - ( if (i.isAtHour()) 1.dp.toPx() else 0.75.dp.toPx()),
                            24.dp.toPx()
                        ),
                        size = Size(
                            if (i.isAtHour()) 2.dp.toPx() else 1.5.dp.toPx(),
                            if (i.isAtHour()) 20.dp.toPx() else 12.dp.toPx()
                        ),
                        cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {

            drawHourHand(time.hour, tertiaryColor)

            drawMinuteHand(time.minute, primaryColor)

            drawSecondHand(time.seconds, Color.White)
        }

    }
}

private fun DrawScope.drawHourHand(hour: Int = 0, color: Color) {
    rotate(degrees = (360 / 12) * hour.toFloat(), pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                size.width / 2f - 6.dp.toPx(),
                size.height / 4f + 24.dp.toPx()
            ),
            size = Size(12.dp.toPx(), size.height / 4f),
            cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx()),
            style = Fill
        )
    }

    drawCircle(
        color = color,
        radius = 14.dp.toPx()
    )
}

private fun DrawScope.drawMinuteHand(minues: Int = 30, color: Color) {
    rotate(degrees = (360f/60f) * minues, pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                size.width / 2f - 4.dp.toPx(),
                size.height / 8f + 24.dp.toPx()
            ),
            size = Size(8.dp.toPx(), size.height / 2f - size.height / 8f),
            cornerRadius = CornerRadius(4.dp.toPx(), 4.dp.toPx()),
            style = Stroke(2.dp.toPx())
        )
    }

    drawCircle(
        color = color,
        radius = 10.dp.toPx()
    )
}

private fun DrawScope.drawSecondHand(seconds: Int = 30, color: Color) {
    rotate(degrees = (360f/60f) * seconds, pivot = center) {
        drawRoundRect(
            color = color,
            topLeft = Offset(
                size.width / 2f - 2.dp.toPx(),
                size.height / 20f + 24.dp.toPx()
            ),
            size = Size(4.dp.toPx(), size.height / 2f - size.height / 20f),
            cornerRadius = CornerRadius(4.dp.toPx(), 4.dp.toPx()),
            style = Fill
        )
    }

    drawCircle(
        color = color,
        radius = 6.dp.toPx()
    )
}

private fun Int.isAtHour() : Boolean {
    return this % 5 == 0
}


@Preview
@Composable
fun PreviewAnalogClock() {
    ComposePlaygroundTheme {
        Surface {
            CustomAnalogClock(
                modifier = Modifier.fillMaxWidth(),
                time = LocalDateTime.now().let {
                    ClockTime(it.hour, it.minute, it.second)
                }
            )
        }
    }
}