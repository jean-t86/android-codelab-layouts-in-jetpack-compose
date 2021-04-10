package au.com.broscience.layoutsinjetpackcomposecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import au.com.broscience.layoutsinjetpackcomposecodelab.ui.theme.LayoutsinjetpackcomposecodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsinjetpackcomposecodelabTheme {
                LayoutsCodelab { modifier ->
                    ScrollingList(modifier)
                }
            }
        }
    }
}
