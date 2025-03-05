plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "top.shixinzhang.bitmapmonitor"
    compileSdk = 34

    defaultConfig {
        applicationId = "top.shixinzhang.bitmapmonitor"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    packagingOptions {
        pickFirst("lib/*/libshadowhook.so")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    debugImplementation(project(":library"))
    releaseImplementation(project(":library-no-op"))

    // debugImplementation 'io.github.shixinzhang:android-bitmap-monitor:1.1.0'
    // releaseImplementation 'io.github.shixinzhang:android-bitmap-monitor-no-op:1.1.0'

//    implementation project(path: ':library')
//    implementation 'io.github.shixinzhang:android-bitmap-monitor:1.1.0'
//    implementation 'io.github.shixinzhang:android-bitmap-monitor-no-op:1.1.0'

    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
    implementation("com.squareup.picasso:picasso:2.8")
}