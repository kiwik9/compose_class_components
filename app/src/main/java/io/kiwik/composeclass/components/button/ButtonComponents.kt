package io.kiwik.composeclass.components.button

import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//Solid background with contrasting text.
@Composable
@Preview
fun FilledButtonExample() {
    Button(onClick = { }) {
        Text("Filled")
    }
}

//Background color varies to match the surface.
@Composable
@Preview
fun FilledTonalButtonExample() {
    FilledTonalButton(onClick = { }) {
        Text("Tonal")
    }
}

//Features a border with no fill.
@Composable
@Preview
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { }) {
        Text("Outlined")
    }
}

//Stands out by having a shadow.
@Composable
@Preview
fun ElevatedButtonExample() {
    ElevatedButton(onClick = { }) {
        Text("Elevated")
    }
}

//Displays text with no background or border.
@Composable
@Preview
fun TextButtonExample() {
    TextButton(
        onClick = { }
    ) {
        Text("Text Button")
    }
}