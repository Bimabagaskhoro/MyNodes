@file:Suppress("UnstableApiUsage")

include(":oneclick")


include(":explorer")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "MyNode"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        maven("https://jitpack.io")
    }
}

include(":app")
include(":common")
include(":component")
project(":common").projectDir = file("common")
project(":component").projectDir = file("component")
include(":navigation")
include(":guest")
include(":main")
