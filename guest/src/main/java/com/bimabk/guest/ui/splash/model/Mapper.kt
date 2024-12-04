package com.bimabk.guest.ui.splash.model

import com.bimabk.guest.data.response.SplashResponse

fun SplashResponse?.mapToUi(): SplashModel {
    return SplashModel(
        logo = this?.logo.orEmpty(),
        title = this?.title.orEmpty(),
    )
}