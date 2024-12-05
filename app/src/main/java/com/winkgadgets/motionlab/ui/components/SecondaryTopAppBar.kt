package com.winkgadgets.motionlab.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.winkgadgets.motionlab.ui.theme.DarkGray
import com.winkgadgets.motionlab.ui.theme.LightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTopAppBar(
    title: String,
    onBackClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()

    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if (isDarkTheme) DarkGray else LightGray,
            titleContentColor = if (isDarkTheme) Color.White else Color.Black,
            navigationIconContentColor = if (isDarkTheme) Color.White else Color.Black
        )
    )
}