package com.bimabk.guest.ui.splash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimabk.common.extension.asFlowState
import com.bimabk.common.extension.uiState
import com.bimabk.guest.data.repository.GuestRepository

class SplashViewModel(
    private val guestRepository: GuestRepository
) : ViewModel() {

    val getSplash = asFlowState {
        guestRepository.getSplashImage()
    }.uiState(viewModelScope)
}