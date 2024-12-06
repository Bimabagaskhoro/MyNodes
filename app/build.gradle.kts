plugins {
    alias(libs.plugins.mynode.android.application)
    alias(libs.plugins.mynode.android.application.compose)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

android {
    namespace = "com.bimabk.mynode"

    defaultConfig {
        applicationId = "com.bimabk.mynode"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":component"))
    implementation(project(":navigation"))
    implementation(project(":guest"))
}
