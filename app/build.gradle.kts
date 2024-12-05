plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.winkgadgets.motionlab"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.winkgadgets.motionlab"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation (libs.androidx.core.ktx.v180)
    implementation (libs.androidx.lifecycle.runtime.ktx.v251)
    implementation (libs.androidx.activity.compose.v151)
    implementation (platform(libs.androidx.compose.bom.v20221000))
    implementation (libs.ui)
    implementation (libs.ui.graphics)
    implementation (libs.ui.tooling.preview)
    implementation (libs.material3)
    implementation (libs.androidx.navigation.compose)
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit.v115)
    androidTestImplementation (libs.androidx.espresso.core.v351)
    androidTestImplementation (platform(libs.androidx.compose.bom.v20241100))
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.ui.tooling)
    debugImplementation (libs.ui.test.manifest)
    implementation (libs.androidx.compose.material3.material3)
    implementation (libs.accompanist.systemuicontroller)
    implementation (libs.androidx.material3.v112)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}