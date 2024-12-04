package com.bimabk.guest.data.repository

import com.bimabk.common.extension.ApiState
import com.bimabk.common.extension.processResponse
import com.bimabk.guest.data.GuestService
import com.bimabk.guest.ui.splash.model.SplashModel
import com.bimabk.guest.ui.splash.model.mapToUi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GuestRepositoryImpl(
    private val guestService: GuestService,
    private val ioDispatcher: CoroutineDispatcher
) : GuestRepository {
    override suspend fun getSplashImage(): ApiState<SplashModel> {
        return withContext(ioDispatcher) {
            processResponse(
                fetchApi = { guestService.getSplash().data },
                transformData = { it.mapToUi() }
            )
        }
    }
}