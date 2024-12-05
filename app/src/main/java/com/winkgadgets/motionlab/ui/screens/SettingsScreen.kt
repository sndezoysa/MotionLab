package com.winkgadgets.motionlab.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.winkgadgets.motionlab.ui.components.SecondaryTopAppBar

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            SecondaryTopAppBar(
                title = "Settings",
                onBackClick = onBackClick
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
                text = "Settings",
                style = MaterialTheme.typography.headlineMedium
            )
            // Add settings options here
        }
    }
}