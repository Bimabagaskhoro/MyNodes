package com.bimabk.navigation

import com.bimabk.common.navigation.BaseNavGraph
import kotlinx.serialization.Serializable

@Serializable
object SplashNavGraphRoute

abstract class SplashNavGraph : BaseNavGraph() {
    abstract fun getSplashLandingRoute(): Any
}