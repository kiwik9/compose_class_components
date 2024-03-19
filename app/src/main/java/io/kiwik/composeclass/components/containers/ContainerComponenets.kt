package io.kiwik.composeclass.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview(showBackground = true)
fun ColumnExample() {
    Column {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }
}

@Preview(showBackground = true)
@Composable
fun RowExample() {
    Row {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }
}

@Preview
@Composable
fun BoxExample() {
    Box(modifier = Modifier) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
        )
    }
}

@Composable
@Preview
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image, title, description, button) = createRefs()
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(text = "Title", modifier = Modifier
            .constrainAs(title) {
                start.linkTo(image.end)
                top.linkTo(parent.top)
            })

        Text(text = "Description", modifier = Modifier
            .constrainAs(description) {
                start.linkTo(image.end)
                top.linkTo(title.bottom)
            })

        IconButton(onClick = { }, modifier = Modifier.constrainAs(button) {
            end.linkTo(parent.end)
        }) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
        }
    }
}

@Composable
@Preview
fun GuideLineConstraint() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val box1 =  createRef()
        val topGuideLine = createGuidelineFromTop(12.dp)
        val startGuideLine = createGuidelineFromStart(12.dp)
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(startGuideLine)
                    top.linkTo(topGuideLine)
                }
        )
    }
}


@Composable
@Preview
fun BarrierConstraint() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3) = createRefs()
        val barrier = createEndBarrier(box1, box2)
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    end.linkTo(box2.start)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom)
                    start.linkTo(box1.end)
                    end.linkTo(box3.start)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    start.linkTo(barrier)
                }
        )
    }
}

@Composable
@Preview
fun ChainConstraint() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3) = createRefs()
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    end.linkTo(box2.start)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {
                    start.linkTo(box1.end)
                    end.linkTo(box3.start)
                }
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    start.linkTo(box2.end)
                    end.linkTo(parent.end)
                }
        )

        //createHorizontalChain(box1,box2,box3, chainStyle = ChainStyle.Spread)
        //createHorizontalChain(box1,box2,box3, chainStyle = ChainStyle.Packed)
        //createHorizontalChain(box1,box2,box3, chainStyle = ChainStyle.SpreadInside)
    }
}