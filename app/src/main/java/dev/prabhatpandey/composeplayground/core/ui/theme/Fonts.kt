package dev.prabhatpandey.composeplayground.core.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.prabhatpandey.composeplayground.R

val FontFamily.Companion.HankenGrotesk: FontFamily
    get() = FontFamily(
        Font(R.font.hanken_grotesk_regular),
        Font(R.font.hanken_grotesk_thin, FontWeight.Thin),
        Font(R.font.hanken_grotesk_extra_light, FontWeight.ExtraLight),
        Font(R.font.hanken_grotesk_light, FontWeight.Light),
        Font(R.font.hanken_grotesk_medium, FontWeight.Medium),
        Font(R.font.hanken_grotesk_semi_bold, FontWeight.SemiBold),
        Font(R.font.hanken_grotesk_bold, FontWeight.Bold),
        Font(R.font.hanken_grotesk_extra_bold, FontWeight.ExtraBold),
        Font(R.font.hanken_grotesk_black, FontWeight.Black),
    )