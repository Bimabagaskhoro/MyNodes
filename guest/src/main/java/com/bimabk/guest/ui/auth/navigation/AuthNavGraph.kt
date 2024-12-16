package com.bimabk.guest.ui.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.bimabk.common.navigation.composableScreen
import com.bimabk.guest.ui.auth.ui.AuthScreen
import com.bimabk.navigation.section.BoardingRoute

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    composableScreen<BoardingRoute> {

        AuthScreen(
        )
    }
}