package io.kiwik.composeclass.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DialogComponentPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var showDialog by remember { mutableStateOf(false) }
        var showBottomSheet by remember { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()
        Button(onClick = { showAlertDialog = true }) {
            Text(text = "Show AlertDialog")
        }
        Button(onClick = { showDialog = true }) {
            Text(text = "Show CustomDialog")
        }
        Button(onClick = { showBottomSheet = true }) {
            Text(text = "Show BottomSheet")
        }
        if (showAlertDialog) {
            AlertDialogComponent {
                showAlertDialog = false
            }
        }
        if (showDialog) {
            CustomDialog {
                showDialog = false
            }
        }
        if (showBottomSheet) {
            CustomBottomSheet(state = sheetState) {
                showBottomSheet = false
            }
        }
    }
}

@Composable
fun AlertDialogComponent(onDismiss: () -> Unit) {
    val icon = Icons.Default.Info
    AlertDialog(
        tonalElevation = 1.dp,
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Title")
        },
        text = {
            Text(text = "description")
        },
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun CustomDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is a minimal dialog",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(state: SheetState, onDismiss: () -> Unit) {
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
        },
        sheetState = state
    ) {
        Button(onClick = {
            scope.launch { state.hide() }.invokeOnCompletion {
                if (!state.isVisible) {
                   onDismiss()
                }
            }
        }) {
            Text("Hide bottom sheet")
        }
    }
}