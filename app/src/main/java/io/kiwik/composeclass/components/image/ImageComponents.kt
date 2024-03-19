package io.kiwik.composeclass.components.image

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.kiwik.composeclass.R

@Composable
@Preview
fun ImagePreview1() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview
fun ImagePreview2() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
fun ImagePreview3() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillHeight
    )
}

@Composable
@Preview
fun ImagePreview4() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillWidth
    )
}

@Composable
@Preview
fun ImagePreview5() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
@Preview
fun ImagePreview6() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.Inside
    )
}

@Composable
@Preview
fun ImagePreview7() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        painter = painterResource(id = R.drawable.jetpack),
        contentDescription = "logo",
        contentScale = ContentScale.None
    )
}

@Composable
@Preview
fun IconPreview() {
    Icon(
        imageVector = Icons.Default.Favorite,
        //tint = Color.Yellow,
        //painter = painterResource(id = R.drawable.jetpac),
        contentDescription = "logo"
    )
}

@Composable
@Preview
fun IconButtonPreview() {
    IconButton(
        onClick = {},
        colors = IconButtonDefaults.iconButtonColors(
            //containerColor = Color.Red,
            //contentColor = Color.White
        ),
        enabled = true
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            //tint = Color.Yellow,
            //painter = painterResource(id = R.drawable.jetpack),
            contentDescription = "logo"
        )
    }

}