plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.egestore.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.egestore.app"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    signingConfigs {
        create("release") {
            val ksPath = System.getenv("ANDROID_KEYSTORE_PATH")
            val ksPass = System.getenv("ANDROID_KEYSTORE_PASSWORD")
            val keyAliasValue = System.getenv("ANDROID_KEY_ALIAS")
            val keyPass = System.getenv("ANDROID_KEY_PASSWORD")
            if (!ksPath.isNullOrBlank() && !ksPass.isNullOrBlank() &&
                !keyAliasValue.isNullOrBlank() && !keyPass.isNullOrBlank()) {
                storeFile = file(ksPath)
                storePassword = ksPass
                keyAlias = keyAliasValue
                keyPassword = keyPass
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
        }
    }
}
