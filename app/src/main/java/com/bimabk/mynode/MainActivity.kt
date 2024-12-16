package com.bimabk.mynode

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.bimabk.component.theme.MyNodeTheme
import com.bimabk.component.utils.LocalActivity
import com.bimabk.mynode.di.AppModule
import com.bimabk.mynode.navigation.AppNavigation
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinIsolatedContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.setBackgroundColor(Color.TRANSPARENT)

        setContent {
            MyNodeTheme {
                CompositionLocalProvider(LocalActivity provides this) {
                    Surface(modifier = Modifier.fillMaxSize(), color = colorScheme.background) {
                        AppModule.koinApp.androidContext(this@MainActivity)
                        KoinIsolatedContext(
                            context = AppModule.koinApp
                        ) {
                            val navController = rememberNavController()
                            AppNavigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
