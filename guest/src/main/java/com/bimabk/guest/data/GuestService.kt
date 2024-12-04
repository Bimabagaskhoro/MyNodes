package com.bimabk.guest.data

import com.bimabk.common.extension.BaseResponse
import com.bimabk.guest.data.response.SplashResponse
import retrofit2.http.GET

interface GuestService {
    @GET("splash.json")
    suspend fun getSplash(): BaseResponse<SplashResponse>
}