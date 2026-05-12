plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "at.ac.univie.hci.tripzy"
    compileSdk =36 // changed because of compatibility issue

    defaultConfig {
        applicationId = "at.ac.univie.hci.tripzy"
        minSdk = 26 //changed from 36->26 because 36 is really restrictive version,
        // but 26 is needed for adaptive icons
        targetSdk = 35   // changed because of  compatibility issues
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
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}