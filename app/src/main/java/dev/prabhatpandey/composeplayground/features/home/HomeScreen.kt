package dev.prabhatpandey.composeplayground.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.prabhatpandey.composeplayground.R
import dev.prabhatpandey.composeplayground.core.ui.navigation.AppScreen
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.core.utils.types.ClickListener
import dev.prabhatpandey.composeplayground.core.utils.types.TypedClickListener

@Composable
fun HomeScreen(
    onNavigate: TypedClickListener<AppScreen>
) {

    val listState = rememberLazyListState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = listState
        ) {
            item {
                HomeMenuItem(
                    title = stringResource(id = R.string.clock),
                    onClick = { onNavigate(AppScreen.Clock) }
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    ComposePlaygroundTheme {
        HomeScreen(
            onNavigate = {

            }
        )
    }
}