package com.panevrn.streamhub.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.panevrn.streamhub.ui.enter.MainRegistrationScreen
import com.panevrn.streamhub.ui.enter.MainScreenAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainRegistrationScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.safeDrawing.asPaddingValues())  // Теперь ничего не вылезет за экран
                    .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
            )
        }
    }
}