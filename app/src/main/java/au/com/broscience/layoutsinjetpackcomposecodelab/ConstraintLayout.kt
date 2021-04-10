package au.com.broscience.layoutsinjetpackcomposecodelab

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button, text) = createRefs()

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    LayoutsinjetpackcomposecodelabTheme {
        ConstraintLayoutContent()
    }
}
