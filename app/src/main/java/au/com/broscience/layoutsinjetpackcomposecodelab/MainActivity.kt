package au.com.broscience.layoutsinjetpackcomposecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme
import com.google.accompanist.coil.CoilImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsinjetpackcomposecodelabTheme {
                LayoutsCodelab { modifier ->
                    LazyList(modifier)
                }
            }
        }
    }
}

@Composable
fun LayoutsCodelab(
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        content(Modifier.padding(innerPadding))
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

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = { })
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(50.dp)
                .align(CenterVertically),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Images goes here
        }

        Column(
            modifier = Modifier
                .align(CenterVertically)
                .padding(start = 8.dp)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    LayoutsinjetpackcomposecodelabTheme {
        PhotographerCard()
    }
}

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

@Composable
fun LazyList(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) { index ->
            ImageListItem(index = index)
        }
    }
}

@Preview
@Composable
fun PreviewLazyList() {
    LayoutsinjetpackcomposecodelabTheme {
        LayoutsCodelab {
            LazyList(it)
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
