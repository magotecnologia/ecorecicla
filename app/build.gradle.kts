plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs") version Versions.NAVIGATION
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "edu.unal.todosalau.ecorecicla"
    compileSdk = 33

    defaultConfig {
        applicationId = "edu.unal.todosalau.ecorecicla"
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINT)

    implementation(Libraries.NAVIGATION)
    implementation(Libraries.NAVIGATION_FRAGMENT)
    implementation(Libraries.NAVIGATION_UI)

    implementation(Libraries.LIVEDATA)
    implementation(Libraries.VIEWMODEL)

    implementation(Libraries.PIECHART)

    testImplementation(Libraries.JUNIT)
    androidTestImplementation(Libraries.JUNIT)

    implementation(Platforms.KOTLIN)

    implementation(Libraries.HILT)
    annotationProcessor(Libraries.HILT_ANNOTATOR)

    implementation(Libraries.ROOM)
    annotationProcessor(Libraries.ROOM_ANNOTATOR)

    implementation(Libraries.BCRYPT)
}