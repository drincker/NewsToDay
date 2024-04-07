plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "pl.drincker.newstoday"
    compileSdk = 34

    defaultConfig {
        applicationId = "pl.drincker.newstoday"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:data:di"))
    implementation(project(":core:domain:newsapi:di"))
    implementation(project(":core:navigation"))

    implementation(project(":features:home:di"))
    implementation(project(":features:home:api"))

    implementation(project(":features:article:di"))
    implementation(project(":features:article:api"))

    implementation(project(":features:profile:di"))
    implementation(project(":features:profile:api"))

    implementation(project(":features:onboarding:api"))
    implementation(project(":features:onboarding:di"))

    implementation(project(":features:bookmarks:api"))
    implementation(project(":features:bookmarks:di"))

    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation(libs.koin.androidx.compose)
    implementation(libs.navigation.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(project(":core:data:api"))
}