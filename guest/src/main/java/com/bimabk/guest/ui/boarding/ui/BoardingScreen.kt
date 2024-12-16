package com.bimabk.guest.ui.boarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bimabk.component.base.BaseScreen
import com.bimabk.component.base.ScreenAttr
import com.bimabk.component.theme.MyNodeTheme

@Composable
fun BoardingScreen(
    onNavigateToGuest: () -> Unit
) {
    BoardingContent(
        onNavigateToGuest = onNavigateToGuest
    )
}

@Composable
fun BoardingContent(
    onNavigateToGuest: () -> Unit = {}
) {
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
            Text("boarding")
            Button(onClick = onNavigateToGuest) {
                Text("let's started")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNodeTheme {
        BoardingContent()
    }
}