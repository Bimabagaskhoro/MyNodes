package com.bimabk.guest.ui.boarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.bimabk.common.navigation.composableScreen
import com.bimabk.guest.ui.boarding.ui.BoardingScreen
import com.bimabk.navigation.section.BoardingRoute

fun NavGraphBuilder.boardingNavGraph(
    navController: NavController
) {
    composableScreen<BoardingRoute> {

        BoardingScreen(

        )
    }
}