package com.winkgadgets.motionlab.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.winkgadgets.motionlab.ui.components.MotionLabNavigationDrawer
import com.winkgadgets.motionlab.ui.components.MotionLabTopAppBar
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    onSettingsClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            drawerState.close()
        }
    }

    MotionLabNavigationDrawer(
        drawerState = drawerState,
        onSettingsClick = {
            scope.launch {
                drawerState.close()
                onSettingsClick()
            }
        }
    ) {
        Scaffold(
            topBar = {
                MotionLabTopAppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    onSettingsClick = onSettingsClick,
                    onMenuClick = onMenuClick
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Welcome to MotionLab",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}