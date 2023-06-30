package dev.prabhatpandey.composeplayground.core.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.prabhatpandey.composeplayground.features.clock.ClockScreen
import dev.prabhatpandey.composeplayground.features.clock.ClockViewModel
import dev.prabhatpandey.composeplayground.features.home.HomeScreen

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
        homeScreen(navController)
        clockScreen(navController)
    }
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(AppScreen.Home.route) {
        HomeScreen(
            onNavigate = {
                navController.navigate(it.route)
            }
        )
    }
}
fun NavGraphBuilder.clockScreen(navController: NavHostController) {
    composable(AppScreen.Clock.route) {
        val viewModel: ClockViewModel = hiltViewModel(it)
        ClockScreen(viewModel)
    }
}
