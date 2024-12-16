package com.bimabk.main.di

import com.bimabk.common.extension.ApiProvider
import com.bimabk.main.data.MainService
import com.bimabk.main.data.repository.MainRepository
import com.bimabk.main.data.repository.MainRepositoryImpl
import com.bimabk.main.ui.MainViewModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val MAIN_URL = ""

val featureMain = module {
    single { ApiProvider.provideApi<MainService>(baseUrl = MAIN_URL, context = androidContext()) }

    single<MainRepository> {
        MainRepositoryImpl(
            get<MainService>(),
            get<CoroutineDispatcher>()
        )
    }

    factory { MainViewModel(get()) }
}