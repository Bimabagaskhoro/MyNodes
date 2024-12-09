package com.bimabk.mynode.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bimabk.guest.ui.boarding.navigation.boardingNavGraph
import com.bimabk.guest.ui.splash.navigation.splashNavGraph
import com.bimabk.navigation.section.SplashRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SplashRoute
    ) {
        splashNavGraph(navController)
        boardingNavGraph(navController)
    }
}