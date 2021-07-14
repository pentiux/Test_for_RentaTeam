buildscript {
    val kotlinVersion by extra("1.5.21")
    val navVersion by extra("2.4.0-alpha04")
    val roomVersion by extra("2.3.0")
    val rxJava2 by extra("2.2.21")
    val moshiRetrofitVersion by extra("2.9.0")
    val daggerVersion by extra("2.37")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }

}


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}