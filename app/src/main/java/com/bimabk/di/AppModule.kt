package com.bimabk.di

import com.bimabk.guest.di.featureGuest
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object AppModule {

    private val listModule = module {
        includes(
            commonModule,
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
