package io.kiwik.composeclass.components.others

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.kiwik.composeclass.R

@Composable
@Preview
fun ShapeRoundedCornerShape() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(12.dp)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillHeight
    )
}

@Composable
@Preview
fun ShapeCircleShapePreview() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillHeight
    )
}

@Composable
@Preview
fun RectangleShapePreview() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(RectangleShape),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillHeight
    )
}