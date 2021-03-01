plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    val androidTargetSdkVersion: Int by project
    val androidCompileSdkVersion: Int by project
    val androidMinSdkVersion: Int by project
    val androidBuildToolsVersion: String by project
    val androidSourceCompatibility:JavaVersion by rootProject.extra
    val androidTargetCompatibility:JavaVersion by rootProject.extra

    compileSdkVersion(androidCompileSdkVersion)

    defaultConfig {
        minSdkVersion(androidMinSdkVersion)
        targetSdkVersion(androidTargetSdkVersion)
        buildToolsVersion(androidBuildToolsVersion)
        versionCode(1)
        versionName("1.0")

        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled=false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(androidSourceCompatibility)
        targetCompatibility(androidTargetCompatibility)
    }
}

dependencies {
    api(project(":sandhook-annotation"))
}