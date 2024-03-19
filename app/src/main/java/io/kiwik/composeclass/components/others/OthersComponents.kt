package io.kiwik.composeclass.components.others

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun BadgePreview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        BadgedBox(
            modifier = Modifier.padding(12.dp),
            badge = {
                Badge { Text("4") }
            }
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )
        }
    }
}

@Composable
@Preview
fun DividerPreview() {
    Column {
        Text(text = "Item 1")
        HorizontalDivider()
        Text(text = "Item 2")
        HorizontalDivider()
        Text(text = "Item 3")
    }

}

@Composable
@Preview
fun DividerRowPreview() {
    Row(
        modifier = Modifier.height(20.dp)
    ) {
        Text(text = "Item 1")
        VerticalDivider()
        Text(text = "Item 2")
        VerticalDivider()
        Text(text = "Item 3")
    }
}

@Composable
@Preview
fun SpacerPreview() {
    Column {
        Text(text = "Item 1")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Item 2")
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Item 3")
    }
}


@Composable
@Preview
fun SpacerRowPreview() {
    Row {
        Text(text = "Item 1")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item 2")
        Spacer(modifier = Modifier.width(25.dp))
        Text(text = "Item 3")
    }
}


@Composable
@Preview
fun SlidersPreview() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 5,
            valueRange = 0f..50f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.tertiary
            ),
            onValueChangeFinished = { },
        )
        Text(text = sliderPosition.toString())
    }
}

@Preview
@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = { },
        )
        Text(text = sliderPosition.toString())
    }
}

@Preview
@Composable
fun ChipPreview() {
    AssistChip(
        onClick = { Log.d("Assist chip", "hello world") },
        label = { Text("Assist chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )

    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}
