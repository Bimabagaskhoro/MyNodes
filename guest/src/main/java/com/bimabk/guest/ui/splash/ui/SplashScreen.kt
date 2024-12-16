package com.bimabk.guest.ui.splash.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.bimabk.common.extension.onError
import com.bimabk.common.extension.onSuccess
import com.bimabk.component.base.BaseScreen
import com.bimabk.component.base.ScreenAttr
import com.bimabk.component.theme.MyNodeTheme
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    onNavigateToBoarding: () -> Unit,
    onNavigateToGuest: () -> Unit,
    splashViewModel: SplashViewModel = koinViewModel()
) {

    val uiState by splashViewModel.getSplash.collectAsStateWithLifecycle()

    uiState
        .onSuccess { data ->
            SplashContent(
                logo = data.logo,
                title = data.title
            )
            LaunchedEffect(Unit) {
                delay(500)
                onNavigateToBoarding()
            }
        }
        .onError {
            LaunchedEffect(Unit) {
                delay(500)
                onNavigateToBoarding()
            }
        }
}

@Composable
fun SplashContent(
    logo: String,
    title: String
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
            AsyncImage(
                model = logo,
                modifier = Modifier.size(32.dp),
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                title,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNodeTheme {
        SplashContent(
            title = "",
            logo = ""
        )
    }
}
