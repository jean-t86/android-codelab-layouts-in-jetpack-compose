package au.com.broscience.layoutsinjetpackcomposecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsinjetpackcomposecodelabTheme {
        LayoutsCodelab { modifier ->
            Greeting(
                modifier.padding(8.dp)
            )
        }
    }
}