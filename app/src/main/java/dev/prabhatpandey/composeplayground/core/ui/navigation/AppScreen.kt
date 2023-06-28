package dev.prabhatpandey.composeplayground.core.ui.navigation

sealed class AppScreen(val route: String) {
    object Home: AppScreen("home")
    object Clock: AppScreen("clock")
}
