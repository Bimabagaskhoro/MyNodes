package com.bimabk.mynode

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.bimabk.di.AppModule
import com.bimabk.component.theme.MyNodeTheme
import com.bimabk.navigation.AppNavigation
import org.koin.compose.KoinIsolatedContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.setBackgroundColor(Color.TRANSPARENT)

        setContent {
            MyNodeTheme {
                val navController = rememberNavController()
                KoinIsolatedContext(context = AppModule.koinApp) {
                    AppNavigation(
                        navController = navController
                    )
                }
            }
        }
    }
}
