package dev.prabhatpandey.composeplayground.features.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.composeplayground.core.ui.theme.ComposePlaygroundTheme
import dev.prabhatpandey.composeplayground.core.utils.types.ClickListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMenuItem(
    title: String,
    onClick: ClickListener,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Surface(
            shape = RoundedCornerShape(0.dp),
            onClick = onClick,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Icon(painter = rememberVectorPainter(image = Icons.Default.KeyboardArrowRight), contentDescription = "")
            }
        }
        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeMenuItem() {
    ComposePlaygroundTheme {
        HomeMenuItem(
            title = "Clock",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
    }
}