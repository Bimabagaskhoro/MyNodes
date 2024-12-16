package com.bimabk.main.data.repository

import com.bimabk.main.data.MainService
import kotlinx.coroutines.CoroutineDispatcher

class MainRepositoryImpl(
    private val guestService: MainService,
    private val ioDispatcher: CoroutineDispatcher
) : MainRepository {
}