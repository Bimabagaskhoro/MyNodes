package com.bimabk.main.feature.ui.monitor.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bimabk.main.feature.ui.monitor.ui.MonitorScreen
import com.bimabk.navigation.section.MonitorGraph
import com.bimabk.navigation.section.MonitorRoute

fun NavGraphBuilder.monitorNavGraph(
    navController: NavController
) {
    navigation<MonitorGraph>(
        startDestination = MonitorRoute,
    ) {
        composable<MonitorRoute> {
            MonitorScreen()
        }
    }
}