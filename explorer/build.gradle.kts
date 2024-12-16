plugins {
    alias(libs.plugins.mynode.android.feature)
    alias(libs.plugins.mynode.android.library.compose)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

android {
    namespace = "com.bimabk.explorer"
}
