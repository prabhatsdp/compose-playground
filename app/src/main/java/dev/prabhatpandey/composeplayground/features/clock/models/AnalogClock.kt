package dev.prabhatpandey.composeplayground.features.clock.models

data class AnalogClock(val time: ClockTime) {
    val hourHandRotationDegree: Double
        get() = (time.hour % 12 + time.minute / 60.0) * 30.0

    val minuteHandRotationDegree: Double
        get() = (time.minute + time.seconds / 60.0) * 6.0

    val secondHandRotationDegree: Double
        get() = time.seconds * 6.0
}