package io.kiwik.composeclass.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun SimpleFilledTextFieldSample() {
    TextField(
        value = "Texto",
        onValueChange = { },
        label = { Text("Label") }
    )
}

@Composable
@Preview
fun SimpleOutlinedTextFieldSample() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Label") }
    )
}

@Composable
fun StyledTextField() {
    TextField(
        value = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(),
        onValueChange = {  },
        label = { Text("Enter text") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun CustomTextField() {
    BasicTextField(
        modifier = Modifier.padding(5.dp),
        value = "Search",
        onValueChange = { },
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp, color = Color.Black),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier.drawWithContent {
                    drawContent()
                    drawLine(
                        color = Color.Gray,
                        start = Offset(
                            x = 0f,
                            y = size.height - 1.dp.toPx(),
                        ),
                        end = Offset(
                            x = size.width,
                            y = size.height - 1.dp.toPx(),
                        ),
                        strokeWidth = 1.dp.toPx(),
                    )
                },
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color(0xFFA8A8A8),
                    )
                    innerTextField()
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    )
}