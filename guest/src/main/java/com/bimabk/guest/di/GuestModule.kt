package com.bimabk.guest.di

import com.bimabk.common.extension.ApiProvider
import com.bimabk.guest.data.GuestService
import com.bimabk.guest.data.repository.GuestRepository
import com.bimabk.guest.data.repository.GuestRepositoryImpl
import com.bimabk.guest.ui.splash.ui.SplashViewModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val GUEST_URL =
    "https://raw.githubusercontent.com/Bimabagaskhoro/staticcontent/refs/heads/main/"

val featureGuest = module {
    single { ApiProvider.provideApi<GuestService>(baseUrl = GUEST_URL, context = androidContext()) }
    single<GuestRepository> {
        GuestRepositoryImpl(
            get<GuestService>(),
            get<CoroutineDispatcher>()
        )
    }
    factory { SplashViewModel(get()) }
}