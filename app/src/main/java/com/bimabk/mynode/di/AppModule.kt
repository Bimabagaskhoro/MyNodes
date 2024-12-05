package com.bimabk.mynode.di

import com.bimabk.common.navigation.BaseNavGraph
import com.bimabk.common.navigation.BaseNavigator
import com.bimabk.guest.di.featureGuest
import com.bimabk.guest.ui.splash.navigation.SplashNavGraphImpl
import com.bimabk.navigation.MyNodeNavGraphs
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object AppModule {

    private val listModule = module {
        includes(
            commonModule,
            navGraphsModule,
            featureGuest,
        )
    }

    val koinApp = koinApplication {
        modules(listModule)
    }
}

private val commonModule = module {
    single { Dispatchers.IO }
}

private val navGraphsModule = module {
    single<BaseNavGraph> { SplashNavGraphImpl() }
    single { BaseNavigator(get(), get()) }
    single { MyNodeNavGraphs(getAll()) }
}
