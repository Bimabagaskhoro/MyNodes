package com.bimabk.main.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bimabk.main.R
import com.bimabk.navigation.section.HomeGraph
import com.bimabk.navigation.section.MonitorGraph
import com.bimabk.navigation.section.NotificationGraph
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomScreens<T>(
    val name: String,
    val icon: Int,
    val route: T
) {
    @Serializable
    data object Home : BottomScreens<HomeGraph>(
        name = "Home",
        icon = R.drawable.ic_home,
        route = HomeGraph
    )

    @Serializable
    data object Monitor : BottomScreens<MonitorGraph>(
        name = "Monitor",
        icon = R.drawable.ic_monitor,
        route = MonitorGraph
    )

    @Serializable
    data object Notification : BottomScreens<NotificationGraph>(
        name = "Notify",
        icon = R.drawable.ic_notification,
        route = NotificationGraph
    )
}

@Composable
fun AppBottomNavigation(navController: NavController) {
    val bottomScreens = remember {
        listOf(
            BottomScreens.Home,
            BottomScreens.Monitor,
            BottomScreens.Notification,
        )
    }

    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        bottomScreens.forEach { screen ->
            val isSelected =
                currentDestination?.hierarchy?.any() { it.hasRoute(screen.route::class) } == true
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.name
                    )
                },
                label = {
                    Text(
                        text = screen.name,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
