val extras = rootProject.extra

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "ru.narod.pentiux.testforrentateam"
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.viewBinding = true
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${extras["kotlinVersion"]}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${extras["kotlinVersion"]}")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.23")
    // Navigation libraries
    implementation("androidx.navigation:navigation-fragment-ktx:${extras["navVersion"]}")
    implementation("androidx.navigation:navigation-ui-ktx:${extras["navVersion"]}")
    // Room
    implementation("androidx.room:room-runtime:${extras["roomVersion"]}")
    kapt("androidx.room:room-compiler:${extras["roomVersion"]}")
    implementation("androidx.room:room-rxjava2:${extras["roomVersion"]}")
    // Picasso
    implementation("com.squareup.picasso:picasso:2.8")
    // RxJava2
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:${extras["rxJava2"]}")
    // Retrofit+moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("com.squareup.retrofit2:retrofit:${extras["moshiRetrofitVersion"]}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${extras["moshiRetrofitVersion"]}")
    implementation("com.squareup.retrofit2:converter-moshi:${extras["moshiRetrofitVersion"]}")
    // Dagger2
    kapt ("com.google.dagger:dagger-compiler:${extras["daggerVersion"]}")
    kapt("com.google.dagger:dagger-android-processor:${extras["daggerVersion"]}")
    implementation("com.google.dagger:dagger-android:${extras["daggerVersion"]}")
    implementation("com.google.dagger:dagger-android-support:${extras["daggerVersion"]}")
    implementation("com.google.dagger:dagger:${extras["daggerVersion"]}")
}