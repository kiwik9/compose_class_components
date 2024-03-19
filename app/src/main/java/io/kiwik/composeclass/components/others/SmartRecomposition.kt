package io.kiwik.composeclass.components.others

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun RecompositionExamplePreview() {
    var item by remember { mutableStateOf("") }
    RecompositionExample(item = item, onValueChange = { item = it })
}

@Composable
fun RecompositionExample(item: String, onValueChange: (String) -> Unit) {
    RecompositionExample(item = item, onValueChange = onValueChange)
    Column(Modifier.padding(12.dp)) {
        TextField(value = item, onValueChange = onValueChange)
        CustomItem(text = item, item = 1)
        StaticItem(text = "Static", item = 2)
        CustomItem(text = item, item = 3)
    }
}

@Composable
fun CustomItem(text: String, item: Int) {
    Text(text = "$text $item")
    Log.e("Recomposition", item.toString())
}

@Composable
fun StaticItem(text: String, item: Int) {
    Text(text = "$text $item")
    Log.e("Recomposition", item.toString())
}