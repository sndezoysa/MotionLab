package com.winkgadgets.motionlab.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.winkgadgets.motionlab.R
import com.winkgadgets.motionlab.ui.theme.DarkGray
import com.winkgadgets.motionlab.ui.theme.LightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MotionLabTopAppBar(
    onNavigationIconClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if (isDarkTheme) DarkGray else LightGray,
            titleContentColor = if (isDarkTheme) Color.White else Color.Black,
            actionIconContentColor = if (isDarkTheme) Color.White else Color.Black,
            navigationIconContentColor = if (isDarkTheme) Color.White else Color.Black
        )
    )
}