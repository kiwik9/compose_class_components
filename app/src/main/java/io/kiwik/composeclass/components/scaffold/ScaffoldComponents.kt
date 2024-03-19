package io.kiwik.composeclass.components.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

// Scaffold
// TopAppBar
// Bottom Bar Navigation
// Floating Action Button
// Navigation Drawer

@Composable
@Preview
fun ScaffoldPreview() {
    var presses by remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet { }
        },
    ) {
        Scaffold(
            topBar = { TopBarCustom() },
            bottomBar = { BottomBarCustom() },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                FloatingActionButtonCustom(onPress = {
                    presses++
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "Snackbar",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Long
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {

                            }

                            SnackbarResult.Dismissed -> {

                            }
                        }
                    }
                },
                    onPressNavigationDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    })
            }
        ) { ContentScaffold(paddingValues = it, presses) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCustom() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
            }
        },
        title = {
            Text("Title")
        },
    )
}


@Composable
fun BottomBarCustom() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Bottom app bar",
        )

    }
}

@Composable
fun FloatingActionButtonCustom(
    onPress: () -> Unit,
    onPressNavigationDrawer: () -> Unit
) {
    Column {
        FloatingActionButton(onClick = { onPress() }) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }

        Spacer(modifier = Modifier.height(16.dp))

        FloatingActionButton(onClick = { onPressNavigationDrawer() }) {
            Icon(Icons.Default.Edit, contentDescription = "Edit")
        }
    }

    // Ejemplos adicionales
//    SmallFloatingActionButton(
//        onClick = { onPress },
//        containerColor = MaterialTheme.colorScheme.secondaryContainer,
//        contentColor = MaterialTheme.colorScheme.secondary
//    ) {
//        Icon(Icons.Filled.Add, "Small floating action button.")
//    }

//    LargeFloatingActionButton(
//        onClick = { onPress() },
//        shape = CircleShape,
//    ) {
//        Icon(Icons.Filled.Add, "Large floating action button")
//    }

//    ExtendedFloatingActionButton(
//        onClick = { onPress() },
//        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
//        text = { Text(text = "Extended FAB") },
//    )
}

@Composable
fun ContentScaffold(paddingValues: PaddingValues, presses: Int) {
    Column(
        modifier = Modifier
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text =
            """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
        )
    }
}