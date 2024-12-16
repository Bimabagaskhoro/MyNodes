package com.bimabk.main.feature.ui.notification.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bimabk.component.base.BaseScreen
import com.bimabk.component.base.ScreenAttr

@Composable
fun NotificationScreen() {
    BaseScreen(
        baseScreenArgs = ScreenAttr.ScreenArgs(
            screenName = null,
            actionMenus = listOf()
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("notification")
        }
    }
}