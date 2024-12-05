package com.bimabk.navigation

import com.bimabk.common.navigation.BaseNavGraph

class MyNodeNavGraphs(
    private val navGraphs: List<BaseNavGraph>
) {
    fun getNavGraphs() = navGraphs
}