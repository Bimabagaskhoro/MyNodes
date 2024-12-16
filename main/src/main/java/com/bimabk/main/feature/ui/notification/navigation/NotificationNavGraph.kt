package com.bimabk.main.feature.ui.notification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bimabk.main.feature.ui.notification.ui.NotificationScreen
import com.bimabk.navigation.section.NotificationGraph
import com.bimabk.navigation.section.NotificationRoute

fun NavGraphBuilder.notificationNavGraph(
    navController: NavController
) {
    navigation<NotificationGraph>(
        startDestination = NotificationRoute,
    ) {
        composable<NotificationRoute> {
            NotificationScreen()
        }
    }
}