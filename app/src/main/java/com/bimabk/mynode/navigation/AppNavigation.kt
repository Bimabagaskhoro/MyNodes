package com.bimabk.mynode.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bimabk.common.navigation.BaseNavigator
import com.bimabk.navigation.MyNodeNavGraphs
import com.bimabk.navigation.SplashNavGraphRoute
import kotlin.reflect.KClass

@Composable
fun AppNavigation(
    myNodeNavGraphs: MyNodeNavGraphs,
    modifier: Modifier = Modifier,
    startDestination: KClass<*> = SplashNavGraphRoute::class
) {
    val navController = rememberNavController()
    val navGraphs = remember { myNodeNavGraphs.getNavGraphs() }
    val navigator = remember { BaseNavigator(navController, navGraphs) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        navGraphs.forEach { navGraph -> navGraph.buildGraph(navigator, this) }
    }
}