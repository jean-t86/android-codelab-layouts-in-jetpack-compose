package au.com.broscience.layoutsinjetpackcomposecodelab

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme

@Composable
fun SimpleList(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(modifier.scrollable(scrollState, Orientation.Vertical)) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

@Preview
@Composable
fun SimpleListPreview() {
    LayoutsinjetpackcomposecodelabTheme {
        LayoutsCodelab { modifier ->
            SimpleList(modifier)
        }
    }
}