package com.bimabk.guest.ui.splash.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.bimabk.common.navigation.BaseNavigator
import com.bimabk.common.navigation.composableScreen
import com.bimabk.guest.ui.splash.ui.SplashScreen
import com.bimabk.navigation.section.SplashNavGraph
import com.bimabk.navigation.section.SplashNavGraphRoute

class SplashNavGraphImpl : SplashNavGraph() {
    override fun buildGraph(
        navigator: BaseNavigator,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<SplashNavGraphRoute>(startDestination = SplashLandingRoute) {
            composableScreen<SplashLandingRoute> {
                val onNavigateToBoarding: () -> Unit = remember {
                    {
                        navigator.run {
//                            navigate(getNavGraph<BoardingGraph>().getBoardingLandingRoute())
                        }
                    }
                }

                val onNavigateToGuest: () -> Unit = remember {
                    {
                        navigator.run {
//                            navigate(getNavGraph<BoardingGraph>().getBoardingLandingRoute())
                        }
                    }
                }

                SplashScreen(
                    onNavigateToBoarding = onNavigateToBoarding,
                    onNavigateToGuest = onNavigateToGuest
                )
            }
        }
    }

    override fun getSplashLandingRoute() = SplashLandingRoute
}