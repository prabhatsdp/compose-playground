package dev.prabhatpandey.composeplayground.core.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.prabhatpandey.composeplayground.core.ui.screens.MainScreen
import dev.prabhatpandey.composeplayground.features.HomeScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route,
        enterTransition = { fadeIn(tween()) },
        exitTransition = { fadeOut(tween()) },
        popEnterTransition = { fadeIn(tween()) },
        popExitTransition = { fadeOut(tween()) },
    ) {
        mainScreen(navController)
    }
}

fun NavGraphBuilder.mainScreen(navController: NavHostController) {
    composable(AppScreen.Home.route) {
        HomeScreen()
    }
}