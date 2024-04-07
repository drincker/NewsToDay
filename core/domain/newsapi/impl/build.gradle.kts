plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlin.plugin.serialization)
}

android {
    namespace = "com.whatrushka.core.domain.newsapi.impl"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        defaultConfig {
            buildConfigField("String", "NEWS_API_KEY", "\"0e0b5e6890d8469cbe8d99ff1a5638b5\"")
        }

        debug {
            buildConfigField("String", "NEWS_API_KEY", "\"0e0b5e6890d8469cbe8d99ff1a5638b5\"")
        }

        release {
            buildConfigField("String", "NEWS_API_KEY", "\"0e0b5e6890d8469cbe8d99ff1a5638b5\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:data:api"))
    implementation(project(":core:domain:newsapi:api"))

    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    androidTestImplementation(libs.androidx.espresso.core)
}