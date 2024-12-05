package com.winkgadgets.motionlab.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MotionLabNavigationDrawer(
    drawerState: DrawerState,
    onSettingsClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(280.dp)
                    .fillMaxHeight()
                    .navigationBarsPadding(),
                drawerShape = RectangleShape,
                windowInsets = WindowInsets(0, 0, 0, 0)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = true,
                    onClick = { }
                )
                NavigationDrawerItem(
                    label = { Text("Settings") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            onSettingsClick()
                            drawerState.close()
                        }
                    }
                )
            }
        }
    ) {
        content()
    }
}