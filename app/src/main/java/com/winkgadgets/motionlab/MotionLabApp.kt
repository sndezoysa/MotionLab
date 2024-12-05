package com.winkgadgets.motionlab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.winkgadgets.motionlab.ui.screens.MainScreen
import com.winkgadgets.motionlab.ui.screens.SettingsScreen
import com.winkgadgets.motionlab.ui.theme.MotionLabTheme

@Composable
fun MotionLabApp() {
    MotionLabTheme {
        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.systemBarsPadding()) { // Add systemBarsPadding here
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(
                            onSettingsClick = { navController.navigate("settings") },
                            onMenuClick = { /* Handle menu click */ }
                        )
                    }
                    composable("settings") {
                        SettingsScreen(
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}