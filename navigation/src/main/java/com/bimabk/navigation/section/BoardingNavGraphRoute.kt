package com.bimabk.navigation.section

import com.bimabk.common.navigation.BaseNavGraph
import kotlinx.serialization.Serializable

@Serializable
object BoardingRoute

abstract class BoardingGraph : BaseNavGraph() {
    abstract fun getBoardingLandingRoute(): Any
}