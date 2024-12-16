package com.bimabk.main.feature.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bimabk.main.feature.ui.home.ui.HomeScreen
import com.bimabk.navigation.section.HomeGraph
import com.bimabk.navigation.section.HomeRoute

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation<HomeGraph>(
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}