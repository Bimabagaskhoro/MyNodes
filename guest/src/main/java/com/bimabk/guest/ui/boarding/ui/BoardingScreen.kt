package com.bimabk.guest.ui.boarding.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bimabk.component.base.BaseScreen
import com.bimabk.component.base.ScreenAttr

@Composable
fun BoardingScreen() {
    BaseScreen(
        baseScreenArgs = ScreenAttr.ScreenArgs(
            screenName = null,
            actionMenus = listOf()
        )
    ) {
        Text("boarding")
    }
}