plugins {
    id("com.android.application")
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
}

dependencies {

    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINT)
    testImplementation(Libraries.JUNIT)
}