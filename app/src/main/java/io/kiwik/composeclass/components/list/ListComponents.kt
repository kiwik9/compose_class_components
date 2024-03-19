package io.kiwik.composeclass.components.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



// LazyColumn seria un equivalente a un RecyclerView Vertical
@Composable
@Preview
private fun LazyColumnView() {
    val myList = listOf("a", "b", "c")
    // Las lazy column solo acepta composables que estan dentro de un item
    LazyColumn {
        item {
            Text(text = "Item composable 1")
        }
        //Tambien se pueden agregar listas por ejemplo
        items(myList) {
            Text(text = it)
        }
    }
}

// LazyColumn seria un equivalente a un RecyclerView Vertical
@Composable
@Preview
private fun LazyRowView() {
    val myList = listOf("a", "b", "c")
    LazyRow {
        item {
            Text(text = "Item composable 1")
        }
        items(myList) {
            Text(text = it)
        }
    }
}

@Composable
@Preview
private fun LazyGripView() {
    val myList = listOf("a", "b", "c")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(myList) {
            Text(text = it)
        }
    }
}



// Se usa cuando su estado o clave cambia más de lo que desea actualizar su interfaz de usuario derivedStateOf { }


