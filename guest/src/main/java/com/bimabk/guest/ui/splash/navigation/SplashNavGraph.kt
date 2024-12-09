package com.bimabk.guest.ui.splash.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.bimabk.common.navigation.composableScreen
import com.bimabk.guest.ui.splash.ui.SplashScreen
import com.bimabk.navigation.section.BoardingRoute
import com.bimabk.navigation.section.SplashRoute

fun NavGraphBuilder.splashNavGraph(
    navController: NavController
) {
    composableScreen<SplashRoute> {
        val onNavigateToBoarding: () -> Unit = remember {
            { navController.navigate(BoardingRoute) }
        }

        SplashScreen(
            onNavigateToBoarding = onNavigateToBoarding,
            onNavigateToGuest = {}
        )
    }
}