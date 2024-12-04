package com.bimabk.guest.ui.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bimabk.component.ScreenAttr
import com.bimabk.common.extension.UiState
import com.bimabk.common.extension.onError
import com.bimabk.common.extension.onLoading
import com.bimabk.common.extension.onSuccess
import com.bimabk.component.BaseScreen
import com.bimabk.component.theme.MyNodeTheme
import com.bimabk.guest.ui.splash.model.SplashModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    onNavigateToBoarding: () -> Unit,
    onNavigateToGuest: () -> Unit,
    splashViewModel: SplashViewModel = koinViewModel()
) {

    val uiState by splashViewModel.getSplash.collectAsStateWithLifecycle()

    BaseScreen(
        baseScreenArgs = ScreenAttr.ScreenArgs(
            screenName = null,
            actionMenus = listOf()
        )
    ) {
        SplashContent(
            state = uiState,
            onNavigateToBoarding = onNavigateToBoarding,
            onNavigateToGuest = onNavigateToGuest
        )
    }
}

@Composable
fun SplashContent(
    state: UiState<SplashModel>,
    onNavigateToBoarding: () -> Unit = {},
    onNavigateToGuest: () -> Unit = {},
) {
    state
        .onLoading { }
        .onSuccess {
            if (it.logo.isEmpty()) {
                onNavigateToBoarding()
            } else {
                onNavigateToGuest()
            }
        }
        .onError {

        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNodeTheme {
        SplashContent(
            state = UiState.Success(
                SplashModel(
                    title = "",
                    logo = ""
                )
            )
        )
    }
}
