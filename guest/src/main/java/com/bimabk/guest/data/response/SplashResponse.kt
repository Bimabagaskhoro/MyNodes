package com.bimabk.guest.data.response

import com.google.gson.annotations.SerializedName

data class SplashResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("logo") val logo: String?
)
