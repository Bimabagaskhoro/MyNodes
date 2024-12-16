package com.bimabk.mynode.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.bimabk.guest.ui.auth.navigation.authNavGraph
import com.bimabk.guest.ui.boarding.navigation.boardingNavGraph
import com.bimabk.guest.ui.splash.navigation.splashNavGraph
import com.bimabk.main.navigation.mainNavGraph
import com.bimabk.navigation.section.SplashRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SplashRoute
    ) {
        splashNavGraph(navController)
        boardingNavGraph(navController)
        authNavGraph(navController)
        mainNavGraph()
    }
}