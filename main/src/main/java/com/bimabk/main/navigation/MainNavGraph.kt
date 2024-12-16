package com.bimabk.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bimabk.main.feature.ui.home.navigation.homeNavGraph
import com.bimabk.main.feature.ui.monitor.navigation.monitorNavGraph
import com.bimabk.main.feature.ui.notification.navigation.notificationNavGraph
import com.bimabk.main.ui.BottomScreens
import com.bimabk.main.ui.MainScreen
import com.bimabk.navigation.section.MainRoute

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomScreens.Home.route) {
        homeNavGraph(navController)
        monitorNavGraph(navController)
        notificationNavGraph(navController)
    }
}

fun NavGraphBuilder.mainNavGraph() {
    composable<MainRoute> {
        MainScreen()
    }
}