package dev.prabhatpandey.composeplayground.core.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.prabhatpandey.composeplayground.R
import dev.prabhatpandey.composeplayground.core.ui.navigation.AppScreen
import dev.prabhatpandey.composeplayground.core.ui.navigation.RootNavGraph
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val dest by navController.currentBackStackEntryAsState()
    var titleRes by rememberSaveable {
        mutableIntStateOf(R.string.home)
    }

    var isBackVisible by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = titleRes))
                },
                navigationIcon = {
                    if (isBackVisible) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = rememberVectorPainter(image = Icons.AutoMirrored.Rounded.ArrowBack),
                                contentDescription = stringResource(R.string.back)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            RootNavGraph(navController = navController)
        }
    }

    LaunchedEffect(dest) {
        dest?.destination?.route?.let {
            isBackVisible = it != AppScreen.Home.route
        }
        when(dest?.destination?.route) {
            AppScreen.Home.route -> titleRes = R.string.app_name
            AppScreen.Clock.route -> titleRes = R.string.clock
            AppScreen.CalendarScrolling.route -> titleRes = R.string.scrolling_calendar
            AppScreen.CalendarSwipe.route -> titleRes = R.string.swiping_calendar
        }

    }
}