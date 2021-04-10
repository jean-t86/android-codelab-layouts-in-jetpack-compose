package au.com.broscience.layoutsinjetpackcomposecodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints = constraints)

    // Check if the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY

    layout(placeable.width, height = height) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
}

@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    LayoutsinjetpackcomposecodelabTheme() {
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    LayoutsinjetpackcomposecodelabTheme {
        Text("Hi there!", Modifier.padding(top = 32.dp))
    }
}
