package com.bimabk.guest.data.repository

import com.bimabk.common.extension.ApiState
import com.bimabk.guest.ui.splash.model.SplashModel

interface GuestRepository {

    suspend fun getSplashImage(): ApiState<SplashModel>
}