package com.bimabk.guest.ui.splash.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bimabk.common.extension.UiState
import com.bimabk.common.extension.onError
import com.bimabk.common.extension.onLoading
import com.bimabk.common.extension.onSuccess
import com.bimabk.component.base.BaseScreen
import com.bimabk.component.base.ScreenAttr
import com.bimabk.component.theme.MyNodeTheme
import com.bimabk.guest.ui.splash.model.SplashModel
import kotlinx.coroutines.delay
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
            Text(
                text = it.title,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodySmall
            )
            LaunchedEffect(Unit) {
                delay(500)
                onNavigateToBoarding()
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
