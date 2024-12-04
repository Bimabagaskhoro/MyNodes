package com.bimabk.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.bimabk.common.extension.composableScreen
import com.bimabk.guest.ui.splash.ui.SplashScreen
import kotlin.reflect.KClass

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: KClass<*> = SplashRoute::class
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composableScreen<SplashRoute> {
            val onNavigateToBoarding: () -> Unit = remember {
                { navController.navigate(BoardingRoute) }
            }

            val onNavigateToGuest: () -> Unit = remember {
                { navController.navigate(GuestRoute) }
            }

            SplashScreen(
                onNavigateToBoarding = onNavigateToBoarding,
                onNavigateToGuest = onNavigateToGuest
            )
        }

        composableScreen<BoardingRoute> {

        }

        composableScreen<GuestRoute> {

        }
    }
}