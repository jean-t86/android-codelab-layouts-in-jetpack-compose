package au.com.broscience.layoutsinjetpackcomposecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme
import com.google.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

@Composable
fun ScrollingList(modifier: Modifier = Modifier) {
    val listSize = 100

    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = ("Scroll to the top"))
            }

            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text(text = ("Scroll to the end"))
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) { index ->
                ImageListItem(index = index)
            }
        }
    }
}

@Preview
@Composable
fun PreviewLazyList() {
    LayoutsinjetpackcomposecodelabTheme {
        LayoutsCodelab {
            ScrollingList(it)
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CoilImage(
            data = "https://developer.android.com/images/brand/Android_Robot.png",
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}